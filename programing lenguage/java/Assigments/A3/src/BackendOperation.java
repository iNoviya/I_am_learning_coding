import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * This class performs the collection of mines,
 * the movements of the vehicle and the score values in the game.
 */
public class BackendOperation extends Main{

   private static int WIDTH;
   private static int HEIGHT;
   private static int PIXEL_WEIGHT;
   private static final int _earthLine = 2;
   private static final double _lavaProbabilities = 5;
   private static final int _mineralProbabilities = 20;
   private static double _fuel = 100.000;
   private static double _money = 0;
   private static double _drillWeight = 0;
   private static Scene _scene;
   private static Pane _root;
   private static Stage _primaryStage;



   public BackendOperation (int WEIGHT , int HEIGHT , int PIXEL_WEIGHT, Scene scene ,Pane root ,Stage primaryStage){
      this.WIDTH = WEIGHT;
      this.HEIGHT = HEIGHT;
      this.PIXEL_WEIGHT = PIXEL_WEIGHT;
      this._scene = scene;
      this._root = root;
      this._primaryStage = primaryStage;
   }

   public BackendOperation() {

   }


   /**
    * starts background processes
    * @param scene
    * @param root
    */
   public void startBackendOperation(Scene scene , Pane root) {
      // Saves game settings for later use.
      GameSetting gameSetting = new GameSetting(WIDTH, HEIGHT, PIXEL_WEIGHT, _earthLine, _lavaProbabilities, _mineralProbabilities);

      // Creates scoreboards that are seen during the game.
      Label moneyLabel = LabelManager.createLabel("Money : " + _money, 25, 10);
      Label weightLabel = LabelManager.createLabel("Weight : " + _drillWeight, 25, 35);
      Label fuelLevel = LabelManager.createFuelLabel(_fuel, 25, 60);

      // Creates item lists.
      PreminaryAssets assetsLoader = new PreminaryAssets();
      ArrayList<Ground> groundList = assetsLoader.loadEarthAssets();
      ArrayList<Mines> minesList = assetsLoader.loadMineralAssets();

      // Creates the game map.
      MapMaker mapMaker = new MapMaker(groundList, minesList, root);
      String[][] gameMap = mapMaker.mapMakerFunction();

      // Creates and places the mining machine.
      Assets drill = new Assets("file:src/assets/drill/drill_37.png", 55);
      drill.getImageView().setX((double) (PIXEL_WEIGHT * WIDTH) / 2);
      drill.getImageView().setY(55);
      drill.getImageView().toFront();
      root.getChildren().add(drill.getImageView());

      // Shows the fuel status as an animation on the screen.
      AnimationTimer timer = new AnimationTimer() {
         private long lastUpdate = 0;
         @Override
         public void handle(long now) {
            if (now - lastUpdate >= 100_000_000) {
               // By default, the drill consumes fuel while operating.
               decreaseFuel(fuelLevel, 0.159,root);
               lastUpdate = now;
            }
         }
      };
      timer.start();

      // Manages the game's gravity system
      gravityFunction(drill, gameMap);

      scene.setOnKeyPressed(event -> {

         // Allows Drill to consume fuel every time it moves.
         decreaseFuel(fuelLevel,0.34,root);
         double newX = drill.getImageView().getX();
         double newY = drill.getImageView().getY();

         // Allows the drill to move with keyboard movements.
         if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) {
            drill.setImageView("file:src/assets/drill/drill_58.png");
            newX += PIXEL_WEIGHT;
         } else if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) {
            drill.setImageView("file:src/assets/drill/drill_03.png");
            newX -= PIXEL_WEIGHT;
         } else if ((event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W) && (isCollision(newX, newY - PIXEL_WEIGHT, "empty", gameMap) || (isCollision(newX, newY - PIXEL_WEIGHT, "sky", gameMap)))) {
            // It is for extra fuel consumption during flight.
            decreaseFuel(fuelLevel,0.93,root);
            drill.setImageView("file:src/assets/drill/drill_30.png");
            newY -= PIXEL_WEIGHT;
         } else if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.S) {
            drill.setImageView("file:src/assets/drill/drill_45.png");
            newY += PIXEL_WEIGHT;
         }
         // It restricts the drill's movement of stones.
         if (!isCollision(newX, newY, "stone", gameMap)) {
            drill.getImageView().setX(newX);
            drill.getImageView().setY(newY);
            String mineType = findMineType(gameMap, newX, newY);

            // The drill performs operations according to the characteristics of the cell at the next movement point.
            switch (mineType) {
               // Darkens the background of excavated mines. In this way,
               // it is differentiated from other items.
               case "soil": {
                  Color color = Color.DARKRED;
                  Rectangle rect = new Rectangle(PIXEL_WEIGHT, PIXEL_WEIGHT, color);
                  rect.setX(newX);
                  rect.setY(newY);
                  _root.getChildren().add(rect);
                  gameMap[(int) Math.round((double) newX / PIXEL_WEIGHT)][(int) (Math.round((double) newY / PIXEL_WEIGHT))] = "empty";
                  break;
               }
               // allows action to be taken in these cases.
               // It also ensures that it does not interfere with the operations to be performed by default.
               case "sky":
               case "stone": {
                  break;
               }
               // Encountering lava ends the game.
               case "lava": {
                  GameOverScreen gameOverScreenLava = new GameOverScreen(_money, _root,"darkred",_primaryStage,_scene);
                  gameOverScreenLava.displayGameOver();
                  break;
               }
               // This process separates different types of minerals
               //It allows us to collect I know it's not a very convenient method, but it was easier this way.
               default: {
                  List<Integer> mineralFeatures =  findMineFeature(gameMap, newX, newY, minesList);
                  int mineWorth = mineralFeatures.get(0);
                  int mineWeight = mineralFeatures.get(1);
                  Color color = Color.DARKRED;
                  Rectangle rect = new Rectangle(PIXEL_WEIGHT, PIXEL_WEIGHT, color);
                  rect.setX(newX);
                  rect.setY(newY);
                  moneyScore(moneyLabel, mineWorth);
                  weightScore(weightLabel, mineWeight);
                  decreaseFuel(fuelLevel,2,_root);
                  _root.getChildren().add(rect);
                  gameMap[(int) Math.round((double) newX / PIXEL_WEIGHT)][(int) (Math.round((double) newY / PIXEL_WEIGHT))] = "empty";
                  break;
               }
            }
            // In any case, it brings the drill to the forefront and increases its visibility.
            drill.getImageView().toFront();
           // miningProgress(root,drill,moneyLabel,weightLabel,fuelLevel,gameMap,newX,newY,mineralsList);
         }
      });
      root.getChildren().addAll(moneyLabel,fuelLevel,weightLabel);
   }

   /**
    * There is this method to check that it interacts.
    * @param newX    drill's x coordinate
    * @param newY    drill's x coordinate
    * @param type    mine type in
    * @param gameMap    game map
    * @return     Returns true if there is a mine to be checked.
    */
   private boolean isCollision(double newX, double newY, String type, String[][] gameMap) {
      String object = gameMap[(int) Math.round((double) newX / PIXEL_WEIGHT)][(int) (Math.round((double) newY / PIXEL_WEIGHT))];
      if (object.equals(type)) {
         return true;
      }
      return false;
   }

   /**
    * controls fuel consumption
    * @param fuelLevel  It is the label that shows the score.
    * @param amount     It is the fuel that is desired to be consumed.
    * @param root       It is a solid panel
    */
   private void decreaseFuel(Label fuelLevel, double amount,Pane root) {
      _fuel -= amount;
      DecimalFormat df = new DecimalFormat("#.###");
      fuelLevel.setText("Fuel : " + df.format(_fuel));
      fuelLevel.toFront();

      if (_fuel <= 0) {
         fuelLevel.setText("Fuel : " + _fuel);
         GameOverScreen gameOverScreen = new GameOverScreen(_money, root , "green",_primaryStage,_scene);
         gameOverScreen.displayGameOver();
      }
   }

   /**
    * It manages the gravity system.
    * @param drill      drill's assets
    * @param gameMap    its game's map
    */
   private void gravityFunction(Assets drill , String[][] gameMap){
      AnimationTimer gravityTimer = new AnimationTimer() {
         private long lastUpdate = 0;

         @Override
         public void handle(long now) {
            if (now - lastUpdate >= 1000 * 1_000_000) {
               if (isCollision(drill.getImageView().getX(), drill.getImageView().getY() + PIXEL_WEIGHT, "empty",gameMap)) {
                  drill.getImageView().setY(drill.getImageView().getY() + PIXEL_WEIGHT);
               }
               lastUpdate = now;
            }
         }
      };
      gravityTimer.start();
   }

   /**
    * The map finds the item at the specified location.
    * @param gameMap    its game's map
    * @param newX    drill's x coordinate
    * @param newY    drill's x coordinate
    * @return        Returns the type of item found in the location.
    */
   private String findMineType(String[][] gameMap, double newX, double newY) {
      return gameMap[(int) Math.round((double) newX / PIXEL_WEIGHT)][(int) (Math.round((double) newY / PIXEL_WEIGHT))];
   }

   /**
    * Finds the properties of the specified mineral.
    * @param gameMap    its game's map
    * @param newX       drill's x coordinate
    * @param newY       drill's x coordinate
    * @param minesList  It is a list where the properties of minerals are stored.
    * @return  Returns the properties of the mine in the location.
    */
   private List<Integer> findMineFeature (String[][] gameMap, double newX, double newY, List<Mines> minesList) {
      String mineName = gameMap[(int) Math.round((double) newX / PIXEL_WEIGHT)][(int) (Math.round((double) newY / PIXEL_WEIGHT))];
      List<Integer> mineralsFeatures = new ArrayList<>();
      for (Mines mine : minesList) {
         if (mine.getMineName().equals(mineName)) {
            mineralsFeatures.add(mine.getWorth());
            mineralsFeatures.add(mine.getWeight());
         }
      }
      // This is to prevent minor errors that may occur.
      // It has no effect on the game.
      if (mineralsFeatures.size() ==2)
         return mineralsFeatures;
      else {
         mineralsFeatures.add(0);
         mineralsFeatures.add(0);
         return mineralsFeatures;
      }
   }

   /**
    * To update the money score.
    * @param scoreLabel    It is the label that shows the score.
    * @param money         It is the monetary equivalent of the collected item.
    */
   private void moneyScore(Label scoreLabel, int money) {
      _money += money;
      scoreLabel.setText("Money : " + _money);
      scoreLabel.toFront();
   }

   /**
    * It adds up the weight of the collected materials.
    * @param weightScore
    * @param weight
    */
   private void weightScore(Label weightScore, int weight) {
      _drillWeight += weight;
      weightScore.setText("Weight : " + _drillWeight);
      weightScore.toFront();
   }

}