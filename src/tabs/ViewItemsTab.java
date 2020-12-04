package tabs;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import pojo.DisplayShoe;
import tables.ItemTable;

public class ViewItemsTab extends Tab {

    private static ViewItemsTab tab;

    //create the tableView to display items
    public TableView tableView;

    private ViewItemsTab(){
        this.setText("View Items");

        ItemTable itemTable = new ItemTable();
        BorderPane root = new BorderPane();

        tableView = new TableView();

        TableColumn<DisplayShoe, String> column1 = new TableColumn<>("Shoe Type");
        column1.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getType()));
        tableView.getColumns().add(column1);

        TableColumn<DisplayShoe, String> column2 = new TableColumn<>("Shoe Brand");
        column1.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getBrand()));
        tableView.getColumns().add(column2);

        TableColumn<DisplayShoe, String> column3 = new TableColumn<>("Shoe Size");
        column1.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getSize()));
        tableView.getColumns().add(column3);

        TableColumn<DisplayShoe, String> column4 = new TableColumn<>("Shoe Condition");
        column1.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getCondition()));
        tableView.getColumns().add(column4);
    }

    public void refreshTable() {
        ItemTable table = new ItemTable();
        tableView.getItems().clear();
        //tableView.getItems().addAll(table.getPrettyItems());
    }

    public static ViewItemsTab getInstance() {
        if (tab == null){
            tab = new ViewItemsTab();
        }
        return tab;
    }

}
