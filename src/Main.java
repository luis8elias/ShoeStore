import controllers.ShopController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/shop_view.fxml"));
        Parent root = loader.load();
        ShopController controller = loader.getController();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root, 1200, 650);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        scene.getStylesheets().add("/styles/app.css");
        primaryStage.setScene(scene);
        controller.setStage(primaryStage);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
