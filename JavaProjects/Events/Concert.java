package Events;

public class Concert extends Event{

    protected String starName;

    public Concert(String place, String date, int startHour, int numberOfTickets, double priceOfTicket, String starName){
        super(place, date, startHour, numberOfTickets, priceOfTicket);
        this.starName = starName;
    }

    public boolean sellTickets(int num) throws NoMoreTicketsException{

        System.out.println("Purchase completed: " + num + " tickets for concert bought.");

        return true;
    }

}
