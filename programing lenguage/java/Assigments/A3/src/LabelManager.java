import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.text.DecimalFormat;

/**
 * It is for creating the texts that will appear on the panel during the game.
 */
public class LabelManager {
   private static final int LABEL_OFFSET_X = 25;
   private static final int LABEL_FONT_SIZE = 25;
   private static final Color LABEL_TEXT_COLOR = Color.WHITE;


   /**
    * It constitutes the basic features of the panels.
    * @param text       text to be written on the screen
    * @param layoutX    is the x coordinate to be positioned.
    * @param layoutY    is the y coordinate to be positioned.
    * @return
    */
   public static Label createLabel(String text, double layoutX, double layoutY) {
      Label label = new Label(text);
      label.setLayoutX(layoutX + LABEL_OFFSET_X);
      label.setLayoutY(layoutY);
      label.setFont(new Font(LABEL_FONT_SIZE));
      label.setTextFill(LABEL_TEXT_COLOR);
      label.toFront();
      return label;
   }

   /**
    * It has been added specifically for the fuel system due to the comma values in the fuel system.
    * @param fuel       text to be written on the screen
    * @param layoutX    is the x coordinate to be positioned.
    * @param layoutY    is the y coordinate to be positioned.
    * @return
    */
   public static Label createFuelLabel(double fuel, double layoutX, double layoutY) {
      DecimalFormat df = new DecimalFormat("#.###");
      String formattedFuel = ("Fuel : " + df.format(fuel));
      return createLabel(formattedFuel, layoutX, layoutY);
   }
}
