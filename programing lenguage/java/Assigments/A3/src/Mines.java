public class Mines extends PreminaryAssets {
   private String _mineName;
   private int _worth;
   private int _weight;
   private String _url;

   public Mines(String mineName, int worth, int weight , String url){
      this._mineName = mineName;
      this._worth = worth;
      this._weight = weight;
      this._url = url;
   }
   public String getMineName(){
      return _mineName;
   }
   public int getWorth(){
      return _worth;
   }
   public int getWeight(){
      return _weight;
   }
   public String getUrl(){
      return _url;
   }
}
