import java.util.*;

public class OperationSystem {

   private List<String> _inputList;
   private List<Bus> _busList = new ArrayList<>();

   /**
    * Assigns the data received from the input file to a list.
    *
    * @param inputList
    */
   public void setInputList(List<String> inputList) {
      this._inputList = inputList;
   }

   /**
    * accessing _inputList
    *
    * @return
    */
   public List<String> getInputList() {
      return _inputList;
   }

   /**
    * It is the main method used to process commands.
    */
   public void handleCommands() {
      for (String line : _inputList) {
         GlobalLogger.log("COMMAND: " + line);
         String[] splited = line.split("\t");
         String parameter = splited[0].trim();
         // Controls the parameter numbers of entered commands
         if (ErrorLogger.getInstance().commendLengthCheck(splited)) {
            switch (parameter) {
               // create a voyage
               case "INIT_VOYAGE": {
                  // Controls the numerical parameters for the trips to be created.
                  if (ErrorLogger.getInstance().checkParameterInitVoyage(splited)) {
                     if (isVoyageIdUnique(Integer.parseInt(splited[2]))) {
                        if (splited[1].equals("Premium")) {
                           Bus premium = new Premium(splited[1], Integer.parseInt(splited[2]), splited[3], splited[4], Integer.parseInt(splited[5]), Double.parseDouble(splited[6]), Integer.parseInt(splited[7]), Integer.parseInt(splited[8]));
                           premium.setRevenue(0.00);
                           _busList.add(premium);
                           premium.setInitInfo();
                        } else if (splited[1].equals("Standard")) {
                           Bus standard = new Standard(splited[1], Integer.parseInt(splited[2]), splited[3], splited[4], Integer.parseInt(splited[5]), Double.parseDouble(splited[6]), Integer.parseInt(splited[7]));
                           standard.setRevenue(0.00);
                           _busList.add(standard);
                           standard.setInitInfo();
                        } else if (splited[1].equals("Minibus")) {
                           Bus minibus = new Minibus(splited[1], Integer.parseInt(splited[2]), splited[3], splited[4], Integer.parseInt(splited[5]), Double.parseDouble(splited[6]));
                           minibus.setRevenue(0.00);
                           _busList.add(minibus);
                           minibus.setInitInfo();
                        }
                     } else GlobalLogger.log("ERROR: There is already a voyage with ID of " + splited[2] + "!");
                  }
                  break;
               }
               // print zReport
               case "Z_REPORT": {
                  if (!_busList.isEmpty()) {
                     GlobalLogger.log("Z Report:");
                     GlobalLogger.log("----------------");
                     _busList.sort(Comparator.comparingInt(Bus::getId));
                     for (Bus bus : _busList) {
                        bus.zReport();
                     }
                  } else {
                     GlobalLogger.log("Z Report:");
                     GlobalLogger.log("----------------");
                     GlobalLogger.log("No Voyages Available!");
                     GlobalLogger.log("----------------");
                  }
                  break;
               }
               // print specific voyage
               case "PRINT_VOYAGE": {
                  int searchedID = Integer.parseInt(splited[1]);
                  if (searchedID > 0) {
                     int index = findIndexOfId(Integer.parseInt(splited[1]));
                     if (index >= 0) {
                        _busList.get(index).printVoyage();
                     }
                  } else
                     GlobalLogger.log("ERROR: " + searchedID + " is not a positive integer, ID of a voyage must be a positive integer!");
                  break;
               }
               // handles ticket sell.
               case "SELL_TICKET": {
                  int index = findIndexOfId(Integer.parseInt(splited[1]));
                  List<Integer> ticketsNumbers = createTicketsList(splited[2]);

                  // Checks whether the parameters are appropriate
                  if (ErrorLogger.getInstance().checkIndex(index) && ErrorLogger.getInstance().checkParameterSellTicket(splited, ticketsNumbers, _busList.get(index)._numberOfSeats)) {
                     TicketTransactions ticketTransactions = new TicketTransactions(_busList.get(index));
                     // It checks whether the seats to be sold are sold or not.
                     if (ticketTransactions.checkSell(ticketsNumbers)) {
                        ticketTransactions.sellTicket(ticketsNumbers);
                        StringBuilder text = new StringBuilder();
                        for (int number : ticketsNumbers) {
                           text.append(number).append("-");
                        }
                        if (text.length() - 1 >= 0) {
                           GlobalLogger.log("Seat " + text.substring(0, text.length() - 1) + " of the Voyage " + _busList.get(index)._id + " from " + _busList.get(index)._boarding + " to " + _busList.get(index)._landing + " was successfully sold for " + String.format("%.2f", ticketTransactions.getSellAmount()) + " TL.");
                        }
                     }
                  }

                  break;
               }
               // handles ticket refunds.
               case "REFUND_TICKET": {
                  int index = findIndexOfId(Integer.parseInt(splited[1]));
                  List<Integer> ticketsNumbers = createTicketsList(splited[2]);

                  //  Checks whether the parameters are appropriate
                  if (ErrorLogger.getInstance().checkIndex(index) && ErrorLogger.getInstance().checkParameterRefundTicket(splited, ticketsNumbers, _busList.get(index)._numberOfSeats)) {
                     TicketTransactions ticketTransactions = new TicketTransactions(_busList.get(index));
                     // It checks that the type of vehicle is minibus and that the seats to be returned are not sold.
                     if (ticketTransactions.checkRefundMinibus() && ticketTransactions.checkRefund(ticketsNumbers)) {
                        ticketTransactions.refundTickets(ticketsNumbers);
                        String text = "";
                        for (int number : ticketsNumbers) {
                           text += number + "-";
                        }
                        if (text.length() - 1 >= 0) {
                           GlobalLogger.log("Seat " + text.substring(0, text.length() - 1) + " of the Voyage " + _busList.get(index)._id + " from " + _busList.get(index)._boarding + " to " + _busList.get(index)._landing + " was successfully refunded for " + String.format("%.2f", ticketTransactions.getRefundAmount()) + " TL.");
                        }
                     }
                  }
                  break;
               }
               // handles ticket cancel voyage
               case "CANCEL_VOYAGE": {
                  int searchedID = Integer.parseInt(splited[1]);
                  int index = 0;

                  boolean isVoyageID = _busList.stream().anyMatch(bus -> bus.getId() == searchedID);

                  for (int i = 0; i < _busList.size(); i++) {
                     if (_busList.get(i).getId() == searchedID) {
                        index = i;
                     }
                  }
                  // check the index
                  if (ErrorLogger.getInstance().checkIndexCancel(index)) {
                     // check the parameter
                     if (ErrorLogger.getInstance().checkParameterCancelVoyage(searchedID)) {
                        if (!isVoyageID) {
                           GlobalLogger.log("ERROR: There is no voyage with ID of " + searchedID + "!");
                        } else {
                           TicketTransactions ticketTransactions = new TicketTransactions(_busList.get(index));
                           ticketTransactions.cancelAmountPrice();
                           GlobalLogger.log("Voyage " + _busList.get(index)._id + " was successfully cancelled!");
                           GlobalLogger.log("Voyage details can be found below:");
                           _busList.get(index).printVoyage();
                           _busList.remove(index);
                        }
                     }
                  } else {
                     GlobalLogger.log("ERROR: " + searchedID + " is not a positive integer, ID of a voyage must be a positive integer!");
                  }
                  break;
               }
            }
         }

      }

      // If there is no Z report at the end of the file,
      if (!_inputList.get(_inputList.size() - 1).equals("Z_REPORT")) {
         GlobalLogger.log("Z Report:");
         GlobalLogger.log("----------------");
         if (_busList.isEmpty()) {
            GlobalLogger.log("No Voyages Available!");
            GlobalLogger.log("----------------");
         } else {
            _busList.sort(Comparator.comparingInt(Bus::getId));
            for (Bus bus : _busList) {
               bus.zReport();
            }
         }
      }
   }

   // It finds the index of the element with the given id in the list.
   private int findIndexOfId(int searchId) {
      for (int i = 0; i < _busList.size(); i++) {
         if (_busList.get(i).getId() == searchId) {
            return i;
         }
      }
      GlobalLogger.log("ERROR: There is no voyage with ID of " + searchId + "!");
      return -1;
   }

   /**
    * It checks whether the ticket numbers entered as parameters comply with the parameters.
    *  If it matches the parameters, it returns a list.
    * @param ticketsText
    * @return
    */
   private List<Integer> createTicketsList(String ticketsText) {
      String[] line = ticketsText.split("_");
      List<Integer> ticketsNumbers = new ArrayList<>();
      for (String ticketNumber : line) {
         ticketsNumbers.add(Integer.parseInt(ticketNumber));
      }
      return ticketsNumbers;
   }

   /**
    * It checks if there is another bus with the entered id.
    *
    * @param id
    * @return
    */
   public boolean isVoyageIdUnique(int id) {
      for (int i = 0; i < _busList.size(); i++) {
         if (_busList.get(i)._id == id) {
            return false;
         }
      }
      return true;
   }
}