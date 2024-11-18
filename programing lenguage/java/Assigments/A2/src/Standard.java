public class Standard extends Bus {
   int _cuts;

   public Standard(String type, int id, String boarding, String landing, int rows, double prize, int cuts) {
      super(type, id, boarding, landing, rows, prize);
      this._cuts = cuts;
   }

   /**
    * It allows us to access deductions on ticket refunds.
    * @return _cuts
    */
   public int getCuts() {
      return this._cuts;
   }

   public int calculatingNumberOfSeat() {
      return _rows * 4;
   }

   public void zReport() {
      GlobalLogger.log("Voyage " + _id);
      GlobalLogger.log(_boarding + "-" + _landing);
      String text = "";
      for (int i = 0; i < _sittingPlan.size(); i++) {
         if (i % 4 == 0 && i != 0) text += "\n";
         if (i % 4 == 2) text += "| ";
         if (_sittingPlan.get(i) == true) {
            text += "X ";
         } else text += "* ";
         if (i % 4 == 3) text = text.trim();
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
         if (i % 4 == 0 && i != 0) text += "\n";
         if (i % 4 == 2) text += "| ";
         if (_sittingPlan.get(i) == true) {
            text += "X ";
         } else text += "* ";
         if (i % 4 == 3) text = text.trim();
      }
      GlobalLogger.log(text);
      GlobalLogger.log("Revenue: " + String.format("%.2f", _revenue));
   }

   public void setInitInfo() {
      GlobalLogger.log("Voyage " + _id + " was initialized as a " + _type.toLowerCase() + " (2+2) voyage from " + _boarding + " to " + _landing + " with " + String.format("%.2f", _price) + " TL priced " + calculatingNumberOfSeat() + " regular seats. Note that refunds will be " + _cuts + "% less than the paid amount.");
   }
}
