import java.util.List;

/**
 * This class was created to identify possible errors.
 * Although error messages for general errors are printed verbatim, in most cases they are resolved in code.
 */
public class ErrorLogger {

   private static ErrorLogger instance;

   private ErrorLogger() {
   }

   public static synchronized ErrorLogger getInstance() {
      if (instance == null) {
         instance = new ErrorLogger();
      }
      return instance;
   }

   /**
    * Prints log messages to file.
    * @param message
    */
   public void logError(String message) {
      GlobalLogger.log(message);
   }

   /**
    * It checks if there is another bus with the entered id.
    * @param id
    * @param _busList
    * @return
    */
   public boolean isVoyageIdUnique(int id , List<Bus> _busList) {
      for (int i = 0; i < _busList.size(); i++) {
         if (_busList.get(i)._id == id) {
            return false;
         }
      }
      return true;
   }

   /**
    * Controls the parameter numbers of entered commands
    * @param list parameter
    * @return
    */
   public boolean commendLengthCheck(String[] list) {
      int parameterListLength = 0;
      if (list.length == 0) {
         return true;
      }
      switch (list[0]) {
         case "INIT_VOYAGE": {
            if (list[1].equals("Premium")) {
               parameterListLength = 9;
            } else if (list[1].equals("Standard")) {
               parameterListLength = 8;
            } else if (list[1].equals("Minibus")) {
               parameterListLength = 7;
            }
            break;
         }
         case "Z_REPORT": {
            parameterListLength = 1;
            break;
         }
         case "PRINT_VOYAGE":
         case "CANCEL_VOYAGE": {
            parameterListLength = 2;
            break;
         }
         case "SELL_TICKET":
         case "REFUND_TICKET": {
            parameterListLength = 3;
            break;
         }
         default: {
            logError("ERROR: There is no command namely " + list[0] + "!");
            return true;
         }
      }

      if (list.length != parameterListLength) {
         logError("ERROR: Erroneous usage of \"" + list[0] + "\" command!");
         return false;
      } else return true;
   }


   /**
    * It checks whether the given number is greater than 0.
    * @param index
    * @return
    */
   public boolean checkIndex(int index) {
      if (index >= 0) return true;
      else return false;
   }

   /**
    * This does the same job as above.
    * It only gives an extra error message in case of cancellation.
    * @param index
    * @return
    */
   public boolean checkIndexCancel(int index) {
      if (index >= 0) return true;
      else {
         logError("ERROR: " + index + " is not a positive integer, ID of a voyage must be a positive integer!");
         return false;
      }
   }

   /**
    * Controls the numerical parameters for the trips to be created.
    * @param list
    * @return
    */
   public boolean checkParameterInitVoyage(String[] list) {
      // id list[2];
      if (!checkIndex(Integer.parseInt(list[2]))) {
         logError("ERROR: " + list[2] + " is not a positive integer, ID of a voyage must be a positive integer!");
         return false;
      }
      ;
      // row list[5]
      if (!checkIndex(Integer.parseInt(list[5]))) {
         logError("ERROR: " + list[5] + " is not a positive integer, number of seat rows of a voyage must be a positive integer!");
         return false;
      }
      // price list[6]
      if (!checkIndex((int) Double.parseDouble(list[6]))) {
         logError("ERROR: " + list[6] + " is not a positive number, price must be a positive number!");
         return false;
      }

      switch (list[1]) {
         case "Premium": {
            // cuts list[7]
            if (!checkIndex((int) Double.parseDouble(list[7]))) {
               logError("ERROR: " + list[7] + " is not an integer that is in range of [0, 100], refund cut must be an integer that is in range of [0, 100]!");
               return false;
            }

            // premium fee list[8]
            if (!checkIndex((int) Double.parseDouble(list[8]))) {
               logError("ERROR: " + list[8] + " is not a non-negative integer, premium fee must be a non-negative integer!");
               return false;
            }
            break;
         }
         case "Standard": {
            // cuts list[7]
            if (!checkIndex((int) Double.parseDouble(list[7]))) {
               logError("ERROR: " + list[7] + " is not an integer that is in range of [0, 100], refund cut must be an integer that is in range of [0, 100]!");
               return false;
            }
         }
      }
      return true;
   }

   /**
    * Controls numerical parameters for ticket sales.
    * @param list command
    * @param ticketList tickets to buy
    * @param maxSeat numbers of total seats
    * @return
    */
   public boolean checkParameterSellTicket (String[] list ,List<Integer> ticketList, int maxSeat){
      if (!checkIndex(Integer.parseInt(list[1]))){
         logError("ERROR: "+ list[1] +" is not a positive integer, seat number must be a positive integer!");
         return false;
      }
      for (int ticketNo : ticketList){
         if (ticketNo < 0){
            GlobalLogger.log("ERROR: "+ ticketNo +" is not a positive integer, seat number must be a positive integer!");
            return false;
         } else if (ticketNo > maxSeat) {
            GlobalLogger.log("ERROR: There is no such a seat!");
            return false;
         }
      }
      return true;
   }

   /**
    * Controls numerical parameters for ticket refund.
    * @param list command
    * @param ticketList tickets to buy
    * @param maxSeat   numbers of total seats
    * @return
    */
   public boolean checkParameterRefundTicket (String[] list ,List<Integer> ticketList, int maxSeat){
      if (!checkIndex(Integer.parseInt(list[1]))){
         logError("ERROR: "+ list[1] +" is not a positive integer, seat number must be a positive integer!");
         return false;
      }
      for (int ticketNo : ticketList){
         if (ticketNo < 0){
            GlobalLogger.log("ERROR: "+ ticketNo +" is not a positive integer, seat number must be a positive integer!");
            return false;
         } else if (ticketNo > maxSeat) {
            GlobalLogger.log("ERROR: There is no such a seat!");
            return false;
         }
      }
      return true;
   }

   /**
    * Controls numerical parameters for cancel voyage.
    * @param id
    * @return
    */
   public boolean checkParameterCancelVoyage(int id){
      if (id <0){
         logError("ERROR: "+ id + " is not a positive integer, ID of a voyage must be a positive integer!\n");
         return false;
      }
      return true;
   }
}