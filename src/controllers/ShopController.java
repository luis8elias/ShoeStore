package controllers;


import animatefx.animation.FadeInLeft;
import animatefx.animation.SlideInLeft;
import data.MenuItemData;
import data.PictureSelectionData;
import data.SizeSelectionData;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.MenuItemModel;
import models.PictureSquareModel;
import models.SizeSquareModel;

public class ShopController {

    private Stage stage;
    private double xOffSet = 0;
    private double yOffSet = 0;

    private int currentMenuItem = 3;




    @FXML private AnchorPane root;
    @FXML private GridPane sizeSelection;
    @FXML private GridPane pictureSquares;
    @FXML private ImageView mainPicture;
    @FXML private VBox menuItemsColumn;
    @FXML private VBox menuSigns;
    @FXML private Label mainLabel;
    @FXML private AnchorPane leftPanel;
    @FXML private Button btnAddToCart;
    @FXML private Label subtitle;
    @FXML private Label modelLabel;
    @FXML private Label price;
    @FXML private Label selectSizeLabel;


    @FXML
    private void close(){
        System.exit(0);
    }

    @FXML
    private void minimize(){
        stage.setIconified(true);
    }

    @FXML
    private void  initialize(){


        makeMenuItems();
        makeDraggableStage();
        makeSizeSelectionSquares();
        makePictureSquares();
        updateLabels(currentMenuItem,MenuItemData.menuItems.get(currentMenuItem));

        new FadeInLeft(mainPicture).play();
    }




    private void makeMenuItems() {
        for (int i = 0; i < MenuItemData.menuItems.size(); i++) {
            MenuItemModel temp = MenuItemData.menuItems.get(i);
            Label element = temp.build();
            int finalI = i;
            element.setOnMouseClicked(event -> {
              if (currentMenuItem != finalI){
                  MenuItemData.updateStatus(finalI);
                  menuItemsColumn.getChildren().clear();
                  menuSigns.getChildren().clear();
                  currentMenuItem = finalI;
                  updateLabels(finalI,temp);
                  mainLabel.setText(temp.getText().charAt(0) + temp.getText().toLowerCase().substring(1));
                  leftPanel.getStyleClass().clear();
                  leftPanel.getStyleClass().add("left-panel-" + finalI);
                  btnAddToCart.getStyleClass().clear();
                  btnAddToCart.getStyleClass().add("button-add-to-cart-" + finalI);
                  SizeSelectionData.updateColor(finalI);
                  makeSizeSelectionSquares();
                  new SlideInLeft(leftPanel).play();
                  makeMenuItems();
                  setMainPicture();
                  makePictureSquares();
              }
            });
            menuItemsColumn.getChildren().add(element);
            menuSigns.getChildren().add(temp.buildMenuSign());
        }
    }


    private void updateLabels(int index,MenuItemModel menuItem){

        subtitle.getStyleClass().setAll("label-color-" + index );
        subtitle.setText(menuItem.getSubtitle());
        subtitle.setAlignment(Pos.CENTER);
        modelLabel.getStyleClass().setAll("label-color-" + index );
        modelLabel.setText(menuItem.getModel());
        modelLabel.setAlignment(Pos.CENTER);
        price.getStyleClass().setAll("label-color-" + index );
        price.setText("$ " +menuItem.getPrice());
        price.setAlignment(Pos.CENTER);
        selectSizeLabel.getStyleClass().setAll("label-color-" + index );

    }



    private void makePictureSquares() {

        pictureSquares.getChildren().clear();

        for (int i = 0; i < PictureSelectionData.getShoe(currentMenuItem).size(); i++) {
            PictureSquareModel temp = PictureSelectionData.getShoe(currentMenuItem).get(i);

            AnchorPane element = temp.build();
            int finalI = i;

            element.setOnMouseClicked(event -> {

                PictureSelectionData.updateStatus(finalI,currentMenuItem);
                setMainPicture();

            });

            pictureSquares.add(element,i,0);


        }


    }

    private void setMainPicture(){
        for (int i = 0; i < PictureSelectionData.getShoe(currentMenuItem).size(); i++) {
            PictureSquareModel temp = PictureSelectionData.getShoe(currentMenuItem).get(i);
            if ( temp.isPressed() ){
                mainPicture.setRotate( temp.isRotated() ? -25.0 : 0.0);
                mainPicture.setImage(new Image(temp.getPicture()));
                new FadeInLeft(mainPicture).play();
           }
        }
    }



    private void makeSizeSelectionSquares() {

        int index;

        for (int i = 0; i < 2 ; i++) {

            for (int j = 0; j < 4 ; j++) {

               if( i == 1 ){
                  index = 3 + i + j;
               }else {
                   index = i + j;
               }

                SizeSquareModel temp = SizeSelectionData.squares.get(index);
                AnchorPane element = temp.build();
                int finalIndex = index;
                element.setOnMouseClicked(event -> {

                    SizeSelectionData.updateStatus(finalIndex);
                    sizeSelection.getChildren().clear();
                    makeSizeSelectionSquares();

                });
                sizeSelection.add(element, j, i);

            }

        }

    }

    private void makeDraggableStage() {

        root.setOnMousePressed(event -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffSet);
            stage.setY(event.getScreenY() - yOffSet);
        });
    }


    public void  setStage(Stage stage){
        this.stage = stage;
    }





}
