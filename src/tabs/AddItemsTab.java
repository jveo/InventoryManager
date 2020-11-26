package tabs;

import com.sun.javafx.iio.gif.GIFDescriptor;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import pojo.Shoe;
import tables.ShoeTable;

public class AddItemsTab extends Tab {

    private static AddItemsTab tab;

    public AddItemsTab(){
        this.setText("Add Item");
        ShoeTable shoeTable = new ShoeTable();

        GridPane root = new GridPane();

        Text type = new Text("Type");
        root.add(type, 0, 0);
        ComboBox<Shoe> comboType = new ComboBox<>();
        comboType.setItems(FXCollections.observableArrayList(shoeTable.getAllShoes()));
        root.add(comboType, 1, 0);

    }

    public static AddItemsTab getInstance() {
        if (tab == null){
            tab = new AddItemsTab();
        }
        return tab;
    }


}
