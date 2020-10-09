package models;

import interfaces.Component;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


public class SizeSquareModel implements Component<AnchorPane> {

    private final String text;
    private boolean isPressed;
    private int color;

    public SizeSquareModel(String text, boolean isPressed) {
        this.text = text;
        this.isPressed = isPressed;
        color = 3;
    }


    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }


    public AnchorPane build(){
        AnchorPane sizeSquare = new AnchorPane();
        sizeSquare.setPrefSize(38,38);

        Label label = new Label(text);
        label.setAlignment(Pos.CENTER);
        label.setPrefSize(35,35);


        if ( isPressed ){
            sizeSquare.getStyleClass().removeAll();
            sizeSquare.getStyleClass().addAll("size-square-pressed-" + color);
            label.setStyle("-fx-text-fill: #FFFFFF");
        }else {
            sizeSquare.getStyleClass().removeAll();
            sizeSquare.getStyleClass().addAll("size-square-" +color);
            label.setStyle("-fx-text-fill: #20304B");
        }

        sizeSquare.getChildren().add(label);
        return sizeSquare;
    }


    public void setColor(int color) {
        this.color = color;
    }
}
