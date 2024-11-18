import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Bus {
   int _id;
   String _type;
   String _boarding;
   String _landing;
   static int _rows;
   double _price;
   int _numberOfSeats;
   List<Boolean> _sittingPlan;
   double _revenue;


   public Bus(String type, int id, String boarding, String landing, int rows, double price) {
      this._id = id;
      this._type = type;
      this._boarding = boarding;
      this._landing = landing;
      this._rows = rows;
      this._price = price;
      this._numberOfSeats = calculatingNumberOfSeat();
      this._sittingPlan = new ArrayList<>(Collections.nCopies(_numberOfSeats, false));
   }

   /**
    * calculate number of seats for each sub-class
    * @return _seats
    */
   public abstract int calculatingNumberOfSeat();

   /**
    * prints the upcoming trip information in the z report.
    */
   public abstract void zReport();

   /**
    * just printing specific voyage
    */
   public abstract void printVoyage();

   /**
    * Returns the necessary information when creating init voyage.
    */
   public abstract void setInitInfo();


   /**
    * Allows us to access the trip ID
    * @return _id
    */
   public int getId() {
      return this._id;
   }

   /**
    * Stores a list showing whether seats are occupied or not.
    * @return
    */
   public List<Boolean> getSittingPlan() {
      return _sittingPlan;
   }

   /**
    * It allows us to access the income we earned during the trip.
    * @return _revenue
    */
   public double getRevenue() {
      return this._revenue;
   }

   /**
    * It allows us to set the income we earned during the trip.
    * @return _revenue
    */
   public void setRevenue(double revenue) {
      this._revenue = revenue;
   }

   /**
    * It allows us to access the seat price.
    * @return
    */
   public double getPrice() {
      return this._price;
   }
}
