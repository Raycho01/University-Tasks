using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
namespace ConsoleApplication1
{
    [TestClass]
    public class TrainTicketsManagerTests
    {
        [TestMethod]
        public void TestGetPriceFor_NoDiscount()
        {
            TrainTicketsManager manager = new TrainTicketsManager();

            double expectedPrice = 180.0 * 2;
            double actualPrice = manager.getPriceFor("11:00", CardType.None, 2, "Boston", false, true);

            Assert.AreEqual(expectedPrice, actualPrice, 0.001);
        }

        [TestMethod]
        public void TestGetPriceFor_ElderDiscount()
        {
            TrainTicketsManager manager = new TrainTicketsManager();

            double expectedPrice = 66.0 * 1;
            double actualPrice = manager.getPriceFor("12:00", CardType.Elder, 1, "New York", false, false);

            Assert.AreEqual(expectedPrice, actualPrice, 0.001);
        }

        [TestMethod]
        public void TestGetPriceFor_FamilyDiscount()
        {
            TrainTicketsManager manager = new TrainTicketsManager();

            double expectedPrice = 100.0 * 3 * 0.5;
            double actualPrice = manager.getPriceFor("15:00", CardType.Family, 3, "Washington D.C.", true, false);

            Assert.AreEqual(expectedPrice, actualPrice, 0.001);
        }

        [TestMethod]
        public void TestGetTrainsHourOfLeaving_ExistingTrain()
        {
            TrainTicketsManager manager = new TrainTicketsManager();

            TimeSpan expectedTime = new TimeSpan(8, 30, 0);
            TimeSpan actualTime = manager.getTrainsHourOfLeaving("New York");

            Assert.AreEqual(expectedTime, actualTime);
        }

        [TestMethod]
        public void TestGetTrainsHourOfLeaving_NonExistingTrain()
        {
            TrainTicketsManager manager = new TrainTicketsManager();

            TimeSpan expectedTime = new TimeSpan(0, 0, 0);
            TimeSpan actualTime = manager.getTrainsHourOfLeaving("Los Angeles");

            Assert.AreEqual(expectedTime, actualTime);
        }

        [TestMethod]
        public void TestReserveTicket_AvailableTrain()
        {
            TrainTicketsManager manager = new TrainTicketsManager();

            bool expectedStatus = true;
            bool actualStatus = manager.reserveTicket(new TimeSpan(10, 15, 0), 2);

            Assert.AreEqual(expectedStatus, actualStatus);
        }

        [TestMethod]
        public void TestReserveTicket_UnavailableTrain()
        {
            TrainTicketsManager manager = new TrainTicketsManager();

            bool expectedStatus = false;
            bool actualStatus = manager.reserveTicket(new TimeSpan(13, 45, 0), 100);

            Assert.AreEqual(expectedStatus, actualStatus);
        }
    }
}