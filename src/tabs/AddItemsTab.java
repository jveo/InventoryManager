package tabs;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import pojo.Shoe;
import tables.BrandTable;
import tables.ConditionTable;
import tables.ItemTable;
import tables.ShoeTable;

public class AddItemsTab extends Tab {

    private static AddItemsTab tab;

    private AddItemsTab(){
        this.setText("Add Item");

        ItemTable table = new ItemTable();
        ShoeTable shoes = new ShoeTable();
        BrandTable brand = new BrandTable();
        ConditionTable condition = new ConditionTable();

        GridPane pane = new GridPane();

        Text name = new Text("Name");
        pane.add(name, 0, 0);

        ComboBox<Shoe> shoeComboBox = new ComboBox<>();
        shoeComboBox.setItems(FXCollections.observableList(shoes.getAllShoes()));
        pane.add(shoeComboBox,1,0);







        this.setContent(pane);

    }

    public static AddItemsTab getInstance() {
        if (tab == null){
            tab = new AddItemsTab();
        }
        return tab;
    }

}
