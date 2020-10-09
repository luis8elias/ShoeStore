package models;

import interfaces.Component;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;

public class MenuItemModel implements Component<Label> {

    private final String text;
    private boolean isPressed;
    private final String subtitle;
    private final String model;
    private final String price;


    public MenuItemModel(String text, boolean isPressed, String subtitle, String model, String price) {
        this.text = text;
        this.isPressed = isPressed;
        this.subtitle = subtitle;
        this.model = model;
        this.price = price;
    }

    public String getText() {
        return text;
    }

    public void setPressed(boolean isPressed) {
        this.isPressed = isPressed;
    }

    public Label build() {
       Label label = new Label(text);
       label.getStyleClass().clear();

       label.getStyleClass().add( isPressed ? "menu-item-label-shoe-pressed" :"menu-item-label-shoe" );
       return label;
    }


    public String getSubtitle() {
        return subtitle;
    }

    public String getModel() {
        return model;
    }

    public String getPrice() {
        return price;
    }

    public Separator buildMenuSign(){
        Separator separator = new Separator();
        separator.setOrientation(Orientation.HORIZONTAL);
        separator.prefWidth(200);
        separator.setStyle("-fx-background-color: #FFFFFF");
        separator.setVisible(isPressed);
        return separator;
    }
}
