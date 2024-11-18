import java.util.*;

public class TicketTransactions {
   private final Bus _bus;
   private double _sellAmount;
   private double _refundAmount;
   private double _cancelAmount;

   /**
    * It is for us to reach class.
    * Allows us to access the bus class
    * @param bus  is the class reached
    */
   public TicketTransactions(Bus bus) {
      this._bus = bus;
   }

   /**
    * To set the amount to be refunded.
    * @param refundAmount  refund amount
    */
   public void setRefundAmount(double refundAmount) {
      this._refundAmount = refundAmount;
   }

   /**
    * To set the amount to be sales amount.
    * @param sellAmount sell amount
    */
   public void setSellAmount(double sellAmount) {
      this._sellAmount = sellAmount;
   }

   /**
    * To get the amount to be sales amount.
    * @return
    */
   public double getSellAmount() {
      return this._sellAmount;
   }

   /**
    * To get the amount to be refunded.
    * @return
    */
   public double getRefundAmount() {
      return this._refundAmount;
   }

   /**
    * Sets the refund amount in case of trip cancellation.
    * @param cancelAmount
    */
   public void setCancelAmount(double cancelAmount) {
      this._cancelAmount = cancelAmount;
   }

   /**
    * Gets the refund amount in case of trip cancellation.
    * @return
    */
   public double getCancelAmount() {
      return this._cancelAmount;
   }

   /**
    * It checks whether the seats to be sold are sold or not.
    * @param seatsNumbers seat number
    * @return
    */
   public Boolean checkSell(List<Integer> seatsNumbers) {
      List<Boolean> seats = _bus.getSittingPlan();
      for (int seatNumber : seatsNumbers) {
         if (seats.get(seatNumber - 1)) {
            GlobalLogger.log("ERROR: One or more seats already sold!");
            return false;
         }
      }
      return true;
   }

   /**
    * It checks whether the tickets and seats to be returned are full.
    * @param seatsNumbers seat number
    * @return
    */
   public Boolean checkRefund(List<Integer> seatsNumbers) {
      List<Boolean> seats = _bus.getSittingPlan();
      for (int seatNumber : seatsNumbers) {
         if (!seats.get(seatNumber - 1)) {
            GlobalLogger.log("ERROR: One or more seats are already empty!");
            return false;
         }
      }
      return true;
   }

   /**
    * Performs ticket sales.
    * @param seatsNumber
    */
   public void sellTicket(List<Integer> seatsNumber) {
      List<Boolean> seats = _bus.getSittingPlan();
      // Returns true for sold seats.
      for (int seatNumber : seatsNumber) {
         if (!seats.get(seatNumber - 1)) {
            seats.set(seatNumber - 1, true);
         }
      }
      // calculate sold amount
      double sellAmount = 0.00;
      if (_bus instanceof Premium) {
         for (int seatNumber : seatsNumber) {
            if (seatNumber % 3 == 1) {
               sellAmount += ((Premium) _bus).getPremiumPrice();
            } else sellAmount += _bus.getPrice();
         }
      } else {
         sellAmount += _bus.getPrice() * seatsNumber.size();

      }
      setSellAmount(sellAmount);
      _bus.setRevenue(_bus._revenue + sellAmount);
   }

   /**
    * performs the ticket refund process.
    * @param seatsNumbers
    */
   public void refundTickets(List<Integer> seatsNumbers) {
      List<Boolean> seats = _bus.getSittingPlan();

      double refundAmount = 0.00;
      // Returns false for refund seats.
      for (int seatNumber : seatsNumbers) {
         if (seats.get(seatNumber - 1)) {
            seats.set(seatNumber - 1, false);
         }
      }
      // calculate refund amount
      if (_bus instanceof Premium) {
         for (int seatNumber : seatsNumbers) {
            if (seatNumber % 3 == 1) {
               refundAmount += ((Premium) _bus).getPremiumPrice() * ((double) (100 - ((Premium) _bus).getCuts()) / 100);
            } else refundAmount += _bus.getPrice() * ((double) (100 - ((Premium) _bus).getCuts()) / 100);
         }
      } else if (_bus instanceof Standard) {
         refundAmount += _bus.getPrice() * (100 - (double) ((Standard) _bus).getCuts()) / 100 * seatsNumbers.size();
      }
      setRefundAmount(refundAmount);
      _bus.setRevenue(_bus.getRevenue() - refundAmount);
   }

   /**
    * She checks whether the bus is a minibus or not.
    * because there is no refund for Minibus
    * @return
    */
   public boolean checkRefundMinibus() {
      if (_bus instanceof Minibus) {
         GlobalLogger.log("ERROR: Minibus tickets are not refundable!");
         return false;
      } else return true;
   }


   /**
    * Calculates the amount to be refunded in case of trip cancellation.
    */
   public void cancelAmountPrice() {
      List<Boolean> seats = _bus.getSittingPlan();
      double cancelAmount = 0.00;
      for (int i = 0; i < seats.size(); i++) {
         if (seats.get(i)) {
            if (_bus instanceof Premium) { // check premium seats
               if (i % 3 == 0) {
                  cancelAmount += ((Premium) _bus).getPremiumPrice();
               } else cancelAmount += _bus.getPrice();
            } else if (_bus instanceof Standard) {
               cancelAmount += ((Standard) _bus).getPrice();
            } else if (_bus instanceof Minibus) {
               cancelAmount += ((Minibus) _bus).getPrice();
            }
         }
      }
      setCancelAmount(cancelAmount);
      _bus.setRevenue(_bus.getRevenue() - cancelAmount);
   }
}