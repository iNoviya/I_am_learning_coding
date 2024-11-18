/**
 * this class created for save route features
 */
public class Route {
   private String _start;
   private String _end;
   private int _roadLength;
   private int _id;

   /**
    * Contractor this class
    * @param start   starting city
    * @param end     arrived city
    * @param distance   distance between 2 city
    * @param id         way's specific numbers
    */
   public Route(String start, String end, int distance, int id) {
      this._start = start;
      this._end = end;
      this._roadLength = distance;
      this._id = id;
   }

   // its all encapsulation methods
   public void setStart(String _start) {
      this._start = _start;
   }

   public String getStart() {
      return _start;
   }

   public void setSend(String _end) {
      this._end = _end;
   }

   public String getEnd() {
      return _end;
   }

   public void setRoadLength(int _roadLength) {
      this._roadLength = _roadLength;
   }
   public int getRoadLength() {
      return _roadLength;
   }

   public void setId(int _id) {
      this._id = _id;
   }
   public int getId() {
      return _id;
   }

   public String writeFormat(){
      return _start + "\t" + _end + "\t" + _roadLength + "\t" + _id;
   }
}
