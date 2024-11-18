public class Premium extends Bus {
   final int _cuts;
   private final double _premiumPrice;

   public Premium(String type, int id, String boarding, String landing, int rows, double prize, int cuts, int premiumFee) {
      super(type, id, boarding, landing, rows, prize);
      this._cuts = cuts;
      this._premiumPrice = prize * (premiumFee + 100) / 100;
   }

   /**
    * It allows us to access deductions on ticket refunds.
    * @return _cuts
    */
   public int getCuts() {
      return this._cuts;
   }

   /**
    * Stores the single premium seat price.
    * @return _
    */
   public double getPremiumPrice() {
      return this._premiumPrice;
   }


   public int calculatingNumberOfSeat() {
      return _rows * 3;
   }

   public void zReport() {
      GlobalLogger.log("Voyage " + _id);
      GlobalLogger.log(_boarding + "-" + _landing);
      String text = "";
      for (int i = 0; i < _sittingPlan.size(); i++) {
         if (i % 3 == 0 && i != 0) text += "\n";
         if (i % 3 == 1) text += "| ";
         if (_sittingPlan.get(i) == true) {
            text += "X ";
         } else text += "* ";
         if (i % 3 == 2) text = text.trim();
      }
      GlobalLogger.log(text);
      GlobalLogger.log("Revenue: " + String.format("%.2f", _revenue));
      GlobalLogger.log("----------------");
   }

   public void printVoyage() {
      GlobalLogger.log("Voyage " + _id);
      GlobalLogger.log(_boarding + "-" + _landing);
      String text = "";
      for (int i = 0; i < _sittingPlan.size(); i++) {
         if (i % 3 == 0 && i != 0) text += "\n";
         if (i % 3 == 1) text += "| ";
         if (_sittingPlan.get(i) == true) {
            text += "X ";
         } else text += "* ";
         if (i % 3 == 2) text = text.trim();
      }
      GlobalLogger.log(text);
      GlobalLogger.log("Revenue: " + String.format("%.2f", _revenue));
   }

   public void setInitInfo() {
      GlobalLogger.log("Voyage " + _id + " was initialized as a " + _type.toLowerCase() + " (1+2) voyage from " + _boarding + " to " + _landing + " with " + String.format("%.2f", _price) + " TL priced " + 2 * (calculatingNumberOfSeat() / 3) + " regular seats and " + String.format("%.2f", _premiumPrice) + " TL priced " + calculatingNumberOfSeat() / 3 + " premium seats. Note that refunds will be " + _cuts + "% less than the paid amount.");
   }
}
