import tabs.AddItemsTab;
import tabs.StatsTab;
import tabs.ViewItemsTab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);

        //created menu / menuItem options
        MenuBar menuBar = new MenuBar();
        Menu login = new Menu("Login");
        Menu settings = new Menu("Settings");
        Menu exit = new Menu("Exit");

        MenuItem logout = new MenuItem("Logout");//<-- is attached to the login button as a dropdown item
        login.getItems().add(logout);

        //added all the menu buttons to the menu bar
        menuBar.getMenus().addAll(login, settings, exit);

        //Tabs items
        TabPane tabPane = new TabPane();
        AddItemsTab addItems = new AddItemsTab();
        ViewItemsTab viewItems = new ViewItemsTab();
        StatsTab statsTab = new StatsTab();



        //disabled the ability to close tabs
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.getTabs().addAll(addItems, viewItems, statsTab);


        //EXIT menu option
        exit.setOnAction(e -> {
            System.exit(0);
        });


        //set tabpane to center
        root.setCenter(tabPane);
        //set the menu bar to appear at the top
        root.setTop(menuBar);

        primaryStage.setTitle("Shoe Inventory Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
