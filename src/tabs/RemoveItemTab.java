package tabs;

import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import tables.ItemTable;

import java.security.PublicKey;

public class RemoveItemTab extends Tab {

    private static RemoveItemTab tab;
    public TableView tableView;

    private RemoveItemTab(){
        this.setText("Remove Item");
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
