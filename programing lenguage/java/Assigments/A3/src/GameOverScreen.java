import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 *In this classy game you have to create objects that
 * will eventually be displayed on the screen.
 */
public class GameOverScreen {
   private final int WIDTH = GameSetting.getInstance().getWidth();
   private final int HEIGHT = GameSetting.getInstance().getHeight();
   private final int PIXEL_WEIGHT = GameSetting.getInstance().getPixelWeight();

   private final double _money;
   private static Pane _root;
   private static String _gameOverColor;
   private static Stage _primaryStage;
   private static Scene _scene;

   public GameOverScreen(double money, Pane root, String gameOverColor, Stage primaryStage, Scene scene){
      this._money = money;
      this._root = root;
      this._gameOverColor = gameOverColor;
      this._primaryStage = primaryStage;
      this._scene = scene;
   }

   /**
    * @apiNote    This method creates the data to be displayed at the end of the game.
    */
   public void displayGameOver() {
      _root.getChildren().clear();
      _root.setStyle("-fx-background-color: " + _gameOverColor + ";");

      Label gameOverLabel = createLabel("GAME OVER!!!", (double) (WIDTH * PIXEL_WEIGHT) / 3, HEIGHT * PIXEL_WEIGHT / 2.5, 45);
      Label gameOverScoreLabel = createLabel("YOUR MONEY : " + _money, (double) (WIDTH * PIXEL_WEIGHT) / 3, HEIGHT * PIXEL_WEIGHT / 2.5 + 100, 30);

      Label closeLabel = createLabel("Press ESC to close",(double) PIXEL_WEIGHT,  (double) (HEIGHT-1)*PIXEL_WEIGHT, 30);
      _root.getChildren().addAll(gameOverLabel, gameOverScoreLabel,closeLabel);
      _scene.setOnKeyPressed(event -> { 
         if (event.getCode() == KeyCode.ESCAPE){
            _primaryStage.close();
         }

      });

   }


   /**
    *  It is used to create the amount of money that will appear on the end-of-game screen and the
    *  "game over" message at the end of the game.
    * @param text       text to be written on the screen
    * @param layoutX    is the x coordinate to be positioned.
    * @param layoutY    is the y coordinate to be positioned.
    * @param fontSize   specifies the font size
    * @return
    */
   private static Label createLabel(String text, double layoutX, double layoutY, int fontSize) {
      Label label = new Label(text);
      label.setLayoutX(layoutX);
      label.setLayoutY(layoutY);
      label.setFont(Font.font("Verdana", FontWeight.BOLD, fontSize));
      label.setTextFill(Color.WHITE);
      return label;
   }
}