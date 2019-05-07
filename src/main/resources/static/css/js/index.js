$('[data-toggle="tooltip"]').tooltip();
let HallStorage = {
  totalTickets: 0,
  ticket: {},
  summ: 0 };


class HallActions {
  constructor(data) {
    this.storage = data;
  }

  addTicket(ticket) {
    let id = ticket.row + '-' + ticket.tribune;

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
    let id = ticket.row + '-' + ticket.tribune;

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
    let string = '<div class="hall-buy__places-row"><div class="hall-buy__places-row-num">ряд <span class="hall-buy__places-row-value">' + places[0].row + '</span></div>';
    let arr = [];
    for (let key in places) {
      arr.push(places[key].place);
    }
    string += '<div class="hall-buy__places-row-num">место <span class="hall-buy__places-row-value">' + arr.join(', ') + '</span></div></div>';
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
    $('#hallCountTickets').html(this.storage.totalTickets + ' билетов');
    $('#hallTotalSum').html(this.storage.summ + ' р');
    let html = '';
    //А это переделайте на _.template а то на скорую руку лиж бы работало
    for (let ticket in this.storage.ticket) {
      html += this._renderRow(this.storage.ticket[ticket]);
    }
    $('#hallPlaces').html(html);
    return this;
  }}


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
  let tribune = $(this).data('tribune');
  $(`#hallLine_${row}_${tribune}`, $hall).addClass('is-hover');
});

$item.on('mouseout', blur);

$itemFree.on('click', function () {
  let ticket = {
    row: $(this).data('row'),
    tribune: $(this).data('tribune'),
    place: $(this).data('pos-x'),
    price: $(this).data('price') };

  if ($(this).hasClass('is-checked')) {
    $(this).removeClass('is-checked');
    hall.removeTicket(ticket);
  } else {
    if (!hall.validate()) {
      Notification.requestPermission(function (permission) {
        var notification = new Notification("Не надо так", { body: 'За один раз можно заказать не более 4 билетов.', icon: 'https://avatars0.githubusercontent.com/u/9361325?v=3&s=466', dir: 'auto' });
      });
      return false;
    }
    $(this).addClass('is-checked');
    hall.addTicket(ticket);
  }
});
hall.rerender();

let cancelBooking = function () {
  // Делаем еще что то чтобы сбросить бронь
  $('#timeoutPopUp').removeClass('hidden');
};

$('select').select2({
  minimumResultsForSearch: -1,
  placeholder: 'Способ оплаты' });

window.cancelBooking = cancelBooking;