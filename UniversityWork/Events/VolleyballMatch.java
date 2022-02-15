package Events;

public class VolleyballMatch extends Event{

    protected String firstTeam;
    protected String secondTeam;

    public VolleyballMatch(String place, String date, int startHour, int numberOfTickets, double priceOfTicket, String firstTeam, String secondTeam){
        super(place, date, startHour, numberOfTickets, priceOfTicket);
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    public boolean sellTickets(int num) throws NoMoreTicketsException{

        System.out.println("Purchase completed: " + num + " tickets for volleyball match bought.");

        return true;
    }

}
