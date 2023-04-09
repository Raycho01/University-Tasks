using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

[TestClass]
public class TrainsUnitTests
{
    [TestMethod]
    public void testGetPriceForNoDiscount() {
        TrainTicketsManager manager = new TrainTicketsManager();

        double expectedPrice = 100.0 * 2;
        double actualPrice = manager.getPriceFor("11:00", CardType.None, 2, "Boston", false, true);

        Assert.AreEqual(expectedPrice, actualPrice, 0.001);
    }

    [TestMethod]
    public void testGetPriceForElderDiscount()
    {
        TrainTicketsManager manager = new TrainTicketsManager();

        double expectedPrice = 66.0;
        double actualPrice = manager.getPriceFor("12:00", CardType.Elder, 1, "New York", false, false);

        Assert.AreEqual(expectedPrice, actualPrice, 0.001);
    }

    [TestMethod]
    public void testGetPriceForFamilyDiscount()
    {
        TrainTicketsManager manager = new TrainTicketsManager();

        double expectedPrice = 100.0 * 3 * 0.5;
        double actualPrice = manager.getPriceFor("15:00", CardType.Family, 3, "Washington D.C.", true, false);

        Assert.AreEqual(expectedPrice, actualPrice, 0.001);
    }

    [TestMethod]
    public void testGetTrainsHourOfLeavingExistingTrain()
    {
        TrainTicketsManager manager = new TrainTicketsManager();

        TimeSpan expectedTime = new TimeSpan(8, 30, 0);
        TimeSpan actualTime = manager.getTrainsHourOfLeaving("New York");

        Assert.AreEqual(expectedTime, actualTime);
    }

    [TestMethod]
    public void testGetTrainsHourOfLeavingNonExistingTrain()
    {
        TrainTicketsManager manager = new TrainTicketsManager();

        TimeSpan expectedTime = new TimeSpan(0, 0, 0);
        TimeSpan actualTime = manager.getTrainsHourOfLeaving("Los Angeles");

        Assert.AreEqual(expectedTime, actualTime);
    }

    [TestMethod]
    public void testReserveTicketAvailableTrain()
    {
        TrainTicketsManager manager = new TrainTicketsManager();

        bool expectedStatus = true;
        bool actualStatus = manager.reserveTicket(new TimeSpan(10, 15, 0), 2);

        Assert.AreEqual(expectedStatus, actualStatus);
    }

    [TestMethod]
    public void testReserveTicketUnavailableTrain()
    {
        TrainTicketsManager manager = new TrainTicketsManager();

        bool expectedStatus = false;
        bool actualStatus = manager.reserveTicket(new TimeSpan(13, 45, 0), 100);

        Assert.AreEqual(expectedStatus, actualStatus);
    }
}
