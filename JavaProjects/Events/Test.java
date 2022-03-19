package Events;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Concert cocaColaTour = new Concert("Sofia", "15.12.2021", 20, 500, 50, "Kirsko");
        VolleyballMatch BGnational = new VolleyballMatch("Varna", "07.01.2022", 17, 200, 20, "Levski", "CSKA");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter tickets: ");
        int tickets = scanner.nextInt();

        try {
            checkTickets(cocaColaTour, BGnational, tickets);
        }
        catch (NoMoreTicketsException e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("End of program.");
        }

    }

    public static void checkTickets (Concert concert, VolleyballMatch match,int tickets) throws
            NoMoreTicketsException {

        if (concert.numberOfTickets >= tickets) {
            boolean meaningless = concert.sellTickets(tickets);
        } else {
            throw new NoMoreTicketsException("Not enough tickets for the concert.");
        }

        if (match.numberOfTickets >= tickets) {
            boolean meaningless = match.sellTickets(tickets);
        } else {
            throw new NoMoreTicketsException("Not enough tickets for the match.");
        }

    }
}
