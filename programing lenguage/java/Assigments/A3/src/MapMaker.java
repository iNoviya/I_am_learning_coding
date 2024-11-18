import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

/**
 * This class creates the map of the game.
 */
public class MapMaker extends BackendOperation {
   /**
    * Retrieves the necessary game settings
    */
   private static final int WIDTH = GameSetting.getInstance().getWidth();
   private static final int HEIGHT = GameSetting.getInstance().getHeight();
   private static final int PIXEL_WEIGHT = GameSetting.getInstance().getPixelWeight();
   private static final int EARTH_LINE = GameSetting.getInstance().getEarthLine();
   private static final double LAVA_PROBABILITIES = GameSetting.getInstance().getLavaProbabilities();
   private static final int MINERALS_PROBABILITIES = GameSetting.getInstance().getMineralProbabilities();
   private final List<Ground> _groundList;
   private final List<Mines> _minesList;
   private final Pane _root;

   /**
    * Stores the creation order of acids with a matrix when creating a game map.
    * The aim is to understand where and which asset is located during drilling operations.
    * In addition, it helps in the properties of minerals.
    */
   private static String[][] _gameMap = new String[WIDTH][HEIGHT];


   public MapMaker(List<Ground> groundList, List<Mines> mineralsList, Pane root) {
      super();
      _groundList = groundList;
      _minesList = mineralsList;
      _root = root;
   }

   /**
    * It is the main method that creates the game map.
    * @return  _gameMap saved to item's location in map
    */
   public String[][]  mapMakerFunction() {
      for (int y = 0; y < HEIGHT; y += 1) {
         for (int x = 0; x < WIDTH; x += 1) {
            /**
             * creates the sky.
             */
            // start if  statement layer 1
            if (y < EARTH_LINE) {
               createSky(x,y);
            }
            /**
             * created to earth
             */
            else if (y == EARTH_LINE) {
               createEarthLine(x,y);
            }
            else {     //    It forms other layers except the sky and earth layer.
               creatItems(x,y);
            } // end if statement layer 1
         } // emd for x
      } // end for y
      return _gameMap;
   }

   private void createSky(int x , int y){
      Color color = Color.BLUE;
      Rectangle rect = new Rectangle(PIXEL_WEIGHT, PIXEL_WEIGHT+3, color);
      rect.setX(x*PIXEL_WEIGHT);
      rect.setY(y*PIXEL_WEIGHT);
      _root.getChildren().add(rect);
      _gameMap[x][y] = "sky";
   }

   private void createEarthLine(int x , int y){
      Assets topSoil = new Assets(_groundList.get(0).getUrl(),PIXEL_WEIGHT);
      topSoil.getImageView().setX(x*PIXEL_WEIGHT);
      topSoil.getImageView().setY(y*PIXEL_WEIGHT);
      _root.getChildren().add(topSoil.getImageView());
      _gameMap[x][y] = "soil";
   }

   /**
    * It forms other layers except the sky and earth layer.
    * @param x index x of gameMap
    * @param y index y of gameMap
    */
   private void creatItems(int x, int y){
      // @parameter mineralRound    It determines a random value to determine the mineral formation in each cell.
      int mineralRound = (int) Math.round(Math.random() * 100);

      // start if statement layer 1
      if (y == HEIGHT -1 ) {
         creatStone(x,y);
      }
      else {
         // start if statement layer 2
         if (x == 0 || x == WIDTH-1){
            creatStone(x,y);
         }
         // Allows the formation of lava
         else if (mineralRound < LAVA_PROBABILITIES) {
            /**
             * I wanted to place a stone in the middle of the map, so
             * I added this value through the function without creating a separate parameter.
             */
            if ( mineralRound < LAVA_PROBABILITIES /4 ){
               creatStone(x,y);
            } else {
               createLava(x, y);
            }
         }
         // Allows the formation of minerals
         else if (mineralRound < MINERALS_PROBABILITIES) {
            createMineral(x, y);
         }
         // fills the empty spaces with pure soil.
         else {
            createSoil(x, y);
         } // end if statement layer 2
      } // end if statement layer 1
   }

   /**
    * Places stone names on the map.
    * @param x index x of gameMap
    * @param y index y of gameMap
    */
   private void creatStone(int x , int y){
      Assets stone = new Assets(_groundList.get(2).getUrl(),PIXEL_WEIGHT);
      stone.getImageView().setX(x*PIXEL_WEIGHT);
      stone.getImageView().setY(y*PIXEL_WEIGHT);
      _root.getChildren().add(stone.getImageView());
      _gameMap[x][y] = "stone";
   }

   /**
    * Places lava names on the map.
    * @param x index x of gameMap
    * @param y index y of gameMap
    */
   private void createLava(int x , int y){
      Assets lava = new Assets(_groundList.get(3).getUrl(),PIXEL_WEIGHT);
      lava.getImageView().setX(x*PIXEL_WEIGHT);
      lava.getImageView().setY(y*PIXEL_WEIGHT);
      _root.getChildren().add(lava.getImageView());
      _gameMap[x][y] = "lava";
   }
   /**
    * Places minerals names on the map.
    * @param x index x of gameMap
    * @param y index y of gameMap
    */
   private void createMineral(int x , int y){
      Assets minerals = new Assets(_minesList.get((int) Math.round(Math.random() * 9)).getUrl(),PIXEL_WEIGHT);
      minerals.getImageView().setX(x*PIXEL_WEIGHT);
      minerals.getImageView().setY(y*PIXEL_WEIGHT);
      _root.getChildren().add(minerals.getImageView());
      _gameMap[x][y] = _minesList.get((int) Math.round(Math.random() * 9)).getMineName();
   }

   /**
    * Places soil to all the spaces.
    * @param x index x of gameMap
    * @param y index y of gameMap
    */
   private void createSoil(int x , int y){
      Assets soil = new Assets(_groundList.get(1).getUrl(),PIXEL_WEIGHT);
      soil.getImageView().setX(x*PIXEL_WEIGHT);
      soil.getImageView().setY(y*PIXEL_WEIGHT);
      _root.getChildren().add(soil.getImageView());
      _gameMap[x][y] = "soil";
   }
}
