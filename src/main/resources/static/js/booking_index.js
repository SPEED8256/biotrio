$('[data-toggle="tooltip"]').tooltip();
let tickets;
let HallStorage = {
  totalTickets: 0,
  ticket: {},
  summ: 0 };

let ticketArray = new Array();
class Ticket {
    constructor(row, seat) {
        this.row = row;
        this.seat = seat;
    }
}

class HallActions {
  constructor(data) {
    this.storage = data;
  }

  addTicket(ticket) {
    let id = ticket.row;

    if (id in this.storage.ticket) {
      this.storage.ticket[id].push(ticket);
    } else {
      this.storage.ticket[id] = [];
      this.storage.ticket[id].push(ticket);
    }
    ++this.storage.totalTickets;
    this.storage.summ += ticket.price;
    this.rerender();
    return this;
  }

  removeTicket(ticket) {
    let id = ticket.row;

    this.storage.ticket[id].splice(this.storage.ticket[id].indexOf(ticket.place), 1);

    if (this.storage.ticket[id].length === 0) {
      delete this.storage.ticket[id];
    }

    --this.storage.totalTickets;
    this.storage.summ -= ticket.price;
    this.rerender();
    return this;
  }

  validate() {
    if (this.storage.totalTickets >= 4) {
      return false;
    } else {
      return true;
    }
  }

  _renderRow(places) {
    //Тут получение шаблона и заполнение переменными
    let string = '<div class="hall-buy__places-row"><div class="hall-buy__places-row-num">row <span class="hall-buy__places-row-value">' + places[0].row + '</span></div>';
    let arr = [];
    for (let key in places) {
      arr.push(places[key].place);
    }
    string += '<div class="hall-buy__places-row-num">seat <span class="hall-buy__places-row-value">' + arr.join(', ') + '</span></div></div>';
    return string;
  }

  rerender() {
    if (!$.isEmptyObject(this.storage.ticket)) {
      $('#hallNoData').addClass('hidden');
      $('#hallData').removeClass('hidden');
    } else {
      $('#hallNoData').removeClass('hidden');
      $('#hallData').addClass('hidden');
    }

    //Todo сделать окончание
    $('#hallCountTickets').html(this.storage.totalTickets + ' tickets');
    $('#hallTotalSum').html(this.storage.summ + ' DKK');
    $('#hallTotalTax').html(this.storage.summ * 0.25 + ' DKK');
    let html = '';
    //А это переделайте на _.template а то на скорую руку лиж бы работало
    for (let ticket in this.storage.ticket) {
      html += this._renderRow(this.storage.ticket[ticket]);
    }
    $('#hallPlaces').html(html);
    return this;
  }
}

function format(obj) {
    return JSON.stringify(obj, null, " ");
}
let hall = new HallActions(HallStorage);

const $hall = $('#hall');
const $item = $('.hall__places-item', $hall);
const $itemFree = $('.hall__places-item.is-free', $hall);

// Убирам наведение
let blur = function () {
  $('.hall__line', $hall).removeClass('is-hover');
  $('.hall__row').removeClass('is-dark');
};
console.log($item);
$item.on('mouseenter', function () {
  blur();
  //Ставим наведение родителям
  $(this).parents('.hall__row').addClass('is-dark');
  let row = $(this).data('row');
  $(`#hallLine_${row}`, $hall).addClass('is-hover');
});

$item.on('mouseout', blur);

$itemFree.on('click', function () {
  let ticket = {
    row: $(this).data('row'),
    place: $(this).data('pos-x'),
    price: $(this).data('price') };
    let t = new Ticket($(this).data('row'), $(this).data('pos-x'));
    ticketArray.push(t);


  if ($(this).hasClass('is-checked')) {
    $(this).removeClass('is-checked');
    hall.removeTicket(ticket);
  } else {
    if (!hall.validate()) {
        alert( 'No more than 4 tickets per booking!' );
      return false;
    }
    $(this).addClass('is-checked');
    hall.addTicket(ticket);
  }
});

hall.rerender();

let booking = function(){
    let customerId = document.getElementById("booking-info").getAttribute("customer_id");
    let screeningId = document.getElementById("booking-info").getAttribute("screening_id");

    let selectedSeats = function(){
        let ticketsArray = Array();
        $(".is-checked").each(function() {
            console.log($(this).html());

            let ticket = {
                ticket_id: $(this).data('ticket_id'),
                row: $(this).data('row'),
                place: $(this).data('pos-x')};
            if (ticket.place==undefined||ticket.row==undefined) {

            }
            else {
                ticketsArray.push(ticket);
            }

        });
        //console.log(ticketsArray);
        return ticketsArray;
    }

    let booking = {customerId: customerId,
    screeningId: screeningId,
    tickets: selectedSeats()}

    return booking;

}

let submitTickets = function(){
    xhr = new XMLHttpRequest();
    let url = "/booking";
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            let json = JSON.parse(xhr.responseText);
        }
    }
    let data = format(booking());
    console.log(data);
    xhr.send(data);
    //window.location='/bookinginfo';
}
