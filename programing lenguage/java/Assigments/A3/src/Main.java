import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author by b2230356164
 * @author by Muhammet mustafa KARATAS
 * @version v1.03
 * BBM 104 Assigment 3 HU-LOUD game
 */

public class Main extends Application{

   /**
    * These parameters specify the number of width-height cells of
    * the screen to be created and the width of these cells.
    */
   private static final int WIDTH = 16;
   private static final int HEIGHT = 12;
   private static final int PIXEL_WEIGHT = 50;


   /**
    *
    * @param primaryStage the primary stage for this application, onto which
    * the application scene can be set. The primary stage will be embedded in
    * the browser if the application was launched as an applet.
    * Applications may create other stages,
    */
   @Override
   public void start(Stage primaryStage){
      Image icon = new Image("file:src/assets/drill/drill_19.png");
      primaryStage.getIcons().add(icon);

      Pane root = new Pane();
      Scene scene = new Scene(root, WIDTH * PIXEL_WEIGHT, HEIGHT * PIXEL_WEIGHT, Color.BROWN);

      BackendOperation backendOperation = new BackendOperation(WIDTH,HEIGHT,PIXEL_WEIGHT,scene,root,primaryStage);
      backendOperation.startBackendOperation(scene,root);

      primaryStage.setTitle("HU-LOAD      powered by b2230356164");
      primaryStage.setResizable(false);
      primaryStage.setScene(scene);
      primaryStage.show();
   }


   /**
    * its start to launch
    * @param args
    */
   public static void main(String[] args) {
      launch(args);
   }
}