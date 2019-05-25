package dk.kea.project.biotrio.Service;

import dk.kea.project.biotrio.Domain.Screening;
import dk.kea.project.biotrio.Domain.Ticket;
import dk.kea.project.biotrio.Repository.ScreeningRepository;
import dk.kea.project.biotrio.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    @Autowired
    private ScreeningRepository screeningRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void save(Screening screening){
        Set<Ticket> set = new HashSet<>();
        for (int r = 1; r<=screening.getTheater().getRows(); r++) {
            for (int s = 1; s <= screening.getTheater().getSeatCount(); s++) {
                Ticket t = new Ticket();
                t.setTicketRow(r);
                t.setTicketseat(s);
                t.setTicketStatus(false);


                set.add(t);

            }
        }
        screening.setTickets(set);
        screeningRepository.save(screening);
    }

    @Override
    public Screening findById(int id){
        return screeningRepository.findById(id);
    }
}
