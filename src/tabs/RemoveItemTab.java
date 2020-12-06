package tabs;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import pojo.DisplayShoe;
import tables.ItemTable;

import java.security.PublicKey;

public class RemoveItemTab extends Tab {

    private static RemoveItemTab tab;
    public TableView tableView;

    private RemoveItemTab(){
        this.setText("Remove Item");

//        ItemTable itemTable = new ItemTable();
//
//        BorderPane root = new BorderPane();
//        tableView = new TableView();
//
//        TableColumn<DisplayShoe, String> column1 =
//                new TableColumn<>("Item Name");
//        column1.setCellValueFactory(
//                e -> new SimpleStringProperty(e.getValue().getType()));
//        tableView.getColumns().add(column1);
//
//        TableColumn<DisplayShoe, String> column2 =
//                new TableColumn<>("Item Condition");
//        column2.setCellValueFactory(
//                e -> new SimpleStringProperty(e.getValue().get));
//        tableView.getColumns().add(column2);
//
//        TableColumn<DisplayShoe, String> column3 =
//                new TableColumn<>("Item Year");
//        column3.setCellValueFactory(
//                e -> new SimpleStringProperty(
//                        e.getValue().getYear()));
//        tableView.getColumns().add(column3);
//
//
//        TableColumn<DisplayShoe, String> column4 =
//                new TableColumn<>("Item Location");
//        column4.setCellValueFactory(
//                e -> new SimpleStringProperty(
//                        e.getValue().getLocation()));
//        tableView.getColumns().add(column4);
//        tableView.getItems().addAll(itemTable.getPrettyItems());
//        root.setCenter(tableView);
//
//        Button removeButton = new Button("Remove");
//        removeButton.setOnAction(e->{
//            DisplayItem item = (DisplayItem) tableView.getSelectionModel().getSelectedItem();
//            itemTable.deleteItem(item.getId());
//            refreshTable();
//            StatsTab.getInstance().generateChart();
//        });
//        root.setBottom(removeButton);
    }

    public static RemoveItemTab getInstance(){
        if(tab == null){
            tab = new RemoveItemTab();
        }
        return tab;
    }

    public void refreshTable() {
        ItemTable table = new ItemTable();
        tableView.getItems().clear();
        tableView.getItems().addAll(table.getPrettyItems());
    }


}
