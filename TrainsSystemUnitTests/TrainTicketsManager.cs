using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    enum CardType
    {
        Family,
        Elder,
        None
    }

    class Train
    {
        public string destination;
        public TimeSpan hourOfLeaving;
        public int seatsAvailable;

        public Train(string destination, TimeSpan hourOfLeaving, int seatsAvailable)
        {
            this.destination = destination;
            this.hourOfLeaving = hourOfLeaving;
            this.seatsAvailable = seatsAvailable;
        }
    }

    class TrainTicketsManager
    {
        private string ticketsFileName = "tickets.txt";
        public static readonly Train[] trains = new Train[] {
            new Train("New York", new TimeSpan(8, 30, 0), 50),
            new Train("Boston", new TimeSpan(10, 15, 0), 35),
            new Train("Washington D.C.", new TimeSpan(13, 45, 0), 70)
        };
        private const double standartPrice = 100;
        private double priceOfTicket = standartPrice;

        public double getPriceFor(string hourOfLeaving, CardType cardType, int ticketsCount, String destination, bool hasChild, bool isRoundTrip)
        {
            TimeSpan hour = TimeSpan.Parse(hourOfLeaving);

            if (isInRushHour(hour))
            {
                return priceOfTicket;
            }

            switch (cardType)
            {
                case CardType.Family:
                    if (hasChild)
                    {
                        priceOfTicket = priceOfTicket * 0.5;
                    }
                    else
                    {
                        priceOfTicket = priceOfTicket * 0.9;
                    }
                    break;
                case CardType.Elder:
                    priceOfTicket = priceOfTicket * 0.66;
                    break;
            }

            calculateTicketPriceBasedOnTrip(isRoundTrip);

            return priceOfTicket * ticketsCount;
        }

        private bool isInRushHour(TimeSpan hour)
        {
            var morningStart = TimeSpan.Parse("07:30");
            var morningEnd = TimeSpan.Parse("09:30");
            var afterNoonStart = TimeSpan.Parse("16:00");
            var afterNoonEnd = TimeSpan.Parse("19:00");

            if ((hour >= morningStart && hour < morningEnd)
                || (hour >= afterNoonStart && hour < afterNoonEnd))
            {
                return true;
            }
            return false;
        }

        private Double calculateTicketPriceBasedOnTrip(bool isRoundTrip)
        {
            if (isRoundTrip)
            {
                priceOfTicket *= 2;
                priceOfTicket *= 0.9; // 10% discount for round-trip
            }
            return priceOfTicket;
        }

        public bool reserveTicket(TimeSpan desiredTimeOfLeaving, int ticketsCount)
        {
            string message = "";
            bool isReservationSuccessful = false;

            foreach (Train train in trains)
            {
                // check if the train is available at the desired time
                if (train.hourOfLeaving == desiredTimeOfLeaving)
                {
                    // check if the train has enough seats
                    if (train.seatsAvailable >= ticketsCount)
                    {
                        train.seatsAvailable -= ticketsCount;
                        string ticketInfo = $"Reservation successful for {ticketsCount} seat(s) on train to {train.destination} leaving at {train.hourOfLeaving}";
                        saveTicketToFile(ticketInfo);
                        message = ticketInfo;
                        isReservationSuccessful = true;
                        break;
                    }
                    else
                    {
                        message = $"Train to {train.destination} leaving at {train.hourOfLeaving} doesn't have enough seats.";
                        break;
                    }
                }
            }

            if (!isReservationSuccessful)
            {
                message = "No trains available.";
            }

            Console.WriteLine(message);
            return isReservationSuccessful;
        }

        public TimeSpan getTrainsHourOfLeaving(string destination)
        {
            foreach (Train train in trains)
            {
                if (train.destination == destination)
                {
                    Console.WriteLine($"Train to {train.destination} is leaving at {train.hourOfLeaving}");
                    return train.hourOfLeaving;
                }
            }
            Console.WriteLine($"There are no trains with destination - {destination}");
            return TimeSpan.Zero;
        }

        private void saveTicketToFile(string ticketInfo)
        {
            using (StreamWriter writer = new StreamWriter(ticketsFileName, true))
            {
                writer.WriteLine(ticketInfo);
            }
        }


    }

    class User
    {
        public string username;
        public string password;

        public User(string username, string password)
        {
            this.username = username;
            this.password = password;
        }
    }


    class Program
    {

        private static string usersFileName = "users.txt";

        static bool registerUser()
        {
            Console.WriteLine("Enter your desired username:");
            string username = Console.ReadLine();

            Console.WriteLine("Enter your desired password:");
            string password = Console.ReadLine();

            string newUser = $"{username},{password}";

            string[] users;

            try
            {
                users = File.ReadAllLines(usersFileName);
            } catch
            {
                using (StreamWriter writer = new StreamWriter(usersFileName, true))
                {
                    writer.WriteLine(newUser + Environment.NewLine);
                    Console.WriteLine("Registration successful!");
                    return true;
                }
            }


            foreach (string user in users)
            {
                string[] parts = user.Split(',');
                if (parts[0] == username)
                {
                    Console.WriteLine("User already exists.");
                    return false;
                }
            }

            File.AppendAllText(usersFileName, newUser + Environment.NewLine);

            Console.WriteLine("Registration successful!");
            return true;
        }

        static bool loginUser()
        {
            Console.WriteLine("Please enter your username:");
            string username = Console.ReadLine();
            Console.WriteLine("Please enter your password:");
            string password = Console.ReadLine();

            string[] users;

            try
            {
                users = File.ReadAllLines(usersFileName);
            } catch
            {
                using (StreamWriter writer = new StreamWriter(usersFileName, true))
                {
                    Console.WriteLine("Incorrect username or password. Please try again.\n");
                    return false;
                }
            }

            foreach (string user in users)
            {
                string[] parts = user.Split(',');
                if (parts[0] == username && parts[1] == password)
                {
                    Console.WriteLine("Login successful!");
                    return true;
                }
            }

            Console.WriteLine("Incorrect username or password. Please try again.\n");
            return false;
        }

    static void Main(string[] args)
        {

            TrainTicketsManager manager = new TrainTicketsManager();
            bool isLoggedIn = false;

            while (!isLoggedIn)
            {
                Console.WriteLine("\nWelcome to Train Ticket Reservation System!");
                Console.WriteLine("1. Login");
                Console.WriteLine("2. Register");
                string option = Console.ReadLine();

                switch (option)
                {
                    case "1":
                        isLoggedIn = loginUser(); 
                        break;
                    case "2":
                        isLoggedIn = registerUser(); 
                        break;
                    default:
                        Console.WriteLine("\nInvalid input. Please try again.");
                        break;
                }
            }

            bool shouldExit = false;

            while (!shouldExit)
            {
                Console.WriteLine("\nPlease select an option:");
                Console.WriteLine("1. Reserve a ticket");
                Console.WriteLine("2. View all available trains");
                Console.WriteLine("3. Exit");

                string input = Console.ReadLine();

                switch (input)
                {
                    case "1":
                        Console.WriteLine("\nPlease enter the desired time of leaving (HH:mm):");
                        string timeString = Console.ReadLine();
                        Console.WriteLine("\nPlease enter the destination:");
                        string destination = Console.ReadLine();
                        Console.WriteLine("\nPlease enter the number of tickets:");
                        int ticketsCount = int.Parse(Console.ReadLine());

                        bool hasChild = false;
                        Console.WriteLine("\nDoes any of the passengers have a child (yes/no)?");
                        string childInput = Console.ReadLine();
                        if (childInput.ToLower() == "yes")
                        {
                            hasChild = true;
                        }

                        bool isRoundTrip = false;
                        Console.WriteLine("\nIs it a round trip (yes/no)?");
                        string roundTripInput = Console.ReadLine();
                        if (roundTripInput.ToLower() == "yes")
                        {
                            isRoundTrip = true;
                        }

                        CardType cardType = CardType.None;
                        Console.WriteLine("\nDo you have a family card or an elder card (family/elder/none)?");
                        string cardInput = Console.ReadLine();
                        switch (cardInput.ToLower())
                        {
                            case "family":
                                cardType = CardType.Family;
                                break;
                            case "elder":
                                cardType = CardType.Elder;
                                break;
                            default:
                                cardType = CardType.None;
                                break;
                        }

                        double price = manager.getPriceFor(timeString, cardType, ticketsCount, destination, hasChild, isRoundTrip);
                        Console.WriteLine($"\nTotal price: {price}$. Do you want to continue?");

                        string finishReservation = Console.ReadLine();
                        if (finishReservation.ToLower() == "yes")
                        {
                            manager.reserveTicket(TimeSpan.Parse(timeString), ticketsCount);
                        } else
                        {
                            Console.WriteLine("\nAborting reservation...");
                        }

                        break;
                    case "2":
                        foreach (Train train in TrainTicketsManager.trains)
                        {
                            Console.WriteLine($"\nDestination: {train.destination}, Time of leaving: {train.hourOfLeaving}, Seats available: {train.seatsAvailable}");
                        }
                        break;
                    case "3":
                        shouldExit = true;
                        break;
                    default:
                        Console.WriteLine("\nInvalid input. Please try again.");
                        break;
                }
            }
        }
    }

}