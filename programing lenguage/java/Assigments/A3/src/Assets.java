import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class is for adding image elements to the media.
 */

public  class  Assets {

   private static ImageView _imageView;
   private static int _PIXEL_WEIGHT;

   public Assets(String imagePath , int pixelWeight) {
      Image image = new Image(imagePath);
      this._imageView = new ImageView(image);
      this._PIXEL_WEIGHT = pixelWeight;
      _imageView.setFitHeight(pixelWeight);
      _imageView.setFitWidth(pixelWeight);
   }

   /**
    * encapsulation's getter and setter methods
    */
   public static ImageView getImageView() {
      return _imageView;
   }

   public void setImageView(String imagePath) {
      if (_imageView.getY()  < (GameSetting.getInstance().getEarthLine()-1)* _PIXEL_WEIGHT){
         Image newImage = new Image("file:src/assets/drill/drill_27.png");
         _imageView.setImage(newImage);
      } else {
         Image newImage = new Image(imagePath);
         _imageView.setImage(newImage);
      }


   }
}
