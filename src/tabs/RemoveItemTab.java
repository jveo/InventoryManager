package tabs;

import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import pojo.DisplayShoe;
import tables.ItemTable;


public class RemoveItemTab extends Tab {

    private static RemoveItemTab tab;
    public TableView tableView;

    private RemoveItemTab(){
        this.setText("View/Remove Items");

        ItemTable itemTable = new ItemTable();

        BorderPane pane = new BorderPane();
        tableView = new TableView();

        TableColumn<DisplayShoe, String> column1 =
                new TableColumn<>("Item Name");
        column1.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getType()));
        tableView.getColumns().add(column1);

        TableColumn<DisplayShoe, String> column2 =
                new TableColumn<>("Size");
        column2.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getSize()));
        tableView.getColumns().add(column2);

        TableColumn<DisplayShoe, String> column3 =
                new TableColumn<>("Brand");
        column3.setCellValueFactory(
                e -> new SimpleStringProperty(
                        e.getValue().getBrand()));
        tableView.getColumns().add(column3);


        TableColumn<DisplayShoe, String> column4 =
                new TableColumn<>("Item Condition");
        column4.setCellValueFactory(
                e -> new SimpleStringProperty(
                        e.getValue().getCondition()));
        tableView.getColumns().add(column4);
        //tableView.getItems().addAll(itemTable.getPrettyItems());
        pane.setCenter(tableView);

        Button removeButton = new Button("Remove");
        removeButton.setOnAction(e->{
            DisplayShoe item = (DisplayShoe) tableView.getSelectionModel().getSelectedItem();
            itemTable.deleteItem(item.getId());
            refreshTable();
            StatsTab.getInstance().generateChart();
        });
        pane.setBottom(removeButton);
        this.setContent(pane);


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
        //tableView.getItems().addAll(table.getPrettyItems());
    }


}
