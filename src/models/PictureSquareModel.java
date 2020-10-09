package models;

import interfaces.Component;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class PictureSquareModel implements Component<AnchorPane> {

    private  final  String picture;
    private boolean isPressed;
    private final boolean isRotated;

    public PictureSquareModel(String picture, boolean pressed , boolean isRotated) {
        this.picture = picture;
        this.isPressed = pressed;
        this.isRotated = isRotated;
    }

    public String getPicture() {
        return picture;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public boolean isRotated() {
        return isRotated;
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }


    public AnchorPane build() {

        AnchorPane pictureSquare = new AnchorPane();
        pictureSquare.setPrefSize(100,100);
        pictureSquare.getStyleClass().add("shoe-square");

        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(picture)));
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.prefWidth(100);
        imageView.prefHeight(100);
        imageView.setRotate(isRotated ? -25.0 : 0.0);

        HBox center = new HBox();
        center.setPrefSize(100,100);
        center.setAlignment(Pos.CENTER);
        center.getChildren().add(imageView);
        pictureSquare.getChildren().add(center);



        return pictureSquare;
    }


}
