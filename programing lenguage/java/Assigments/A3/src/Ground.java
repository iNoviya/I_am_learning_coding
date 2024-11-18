/**
 * This class hides the properties of materials to be placed in the game other than minerals.
 */
public class Ground extends PreminaryAssets {
   private String _groundName;
   private String _url;

   public Ground(){}
   public Ground(String groundName, String url){
      this._groundName = groundName;
      this._url = url;
   }

   /**
    * encapsulation getter/setter items
    */
   public void setGroundName(String groundName) {
      this._groundName = groundName;
   }
   public String getGroundName(){
      return _groundName;
   }
   public String getUrl(){
      return _url;
   }
}