/**
 * This class is there to store the game settings and
 * easily access them when desired via instance.
 */
public class GameSetting {

   private static int _WIDTH ;
   private static int _HEIGHT ;
   private static int _PIXEL_WEIGHT ;
   private static int _earthLine ;
   private static double _lavaProbabilities ;
   private static int _mineralProbabilities;


   private static GameSetting instance;

   public GameSetting(){};
   public GameSetting (int width, int height, int pixel_weight , int earthLine , double lavaProbabilities , int mineralProbabilities ){
      this._WIDTH = width;
      this._HEIGHT = height;
      this._PIXEL_WEIGHT = pixel_weight;
      this._earthLine = earthLine;
      this._lavaProbabilities = lavaProbabilities;
      this._mineralProbabilities = mineralProbabilities;
   }

   /**
    * encapsulation's getter and setter methods
    */

   public int getWidth(){
      return _WIDTH;
   }
   public void setWidth(int width){
      this._WIDTH = width;
   }

   public int getHeight(){
      return _HEIGHT ;
   }
   public void setHeight(int height){
      this._HEIGHT =height;
   }

   public int getPixelWeight(){
      return _PIXEL_WEIGHT ;
   }
   public void setPixelWeight(int pixelWeight){
      this._PIXEL_WEIGHT =pixelWeight;
   }

   public int getEarthLine() {
      return _earthLine;
   }
   public void setEarthLine (int earthLine){
      this._earthLine = earthLine;
   }

   public double getLavaProbabilities(){
      return _lavaProbabilities;
   }
   public void setLavaProbabilities (double lavaProbabilities){
      this._lavaProbabilities = lavaProbabilities;
   }

   public int getMineralProbabilities(){
      return _mineralProbabilities;
   }
   public void setMineralProbabilities(int mineralProbabilities){
      this._mineralProbabilities = mineralProbabilities;
   }


   /**
    * It is for quick access from other classes.
    * @return
    */
   public static synchronized GameSetting getInstance() {
      if (instance == null) {
         instance = new GameSetting();
      }
      return instance;
   }
}
