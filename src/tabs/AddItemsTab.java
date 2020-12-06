package tabs;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import pojo.Brand;
import pojo.Condition;
import pojo.Item;
import pojo.Shoe;
import tables.BrandTable;
import tables.ConditionTable;
import tables.ItemTable;
import tables.ShoeTable;

public class AddItemsTab extends Tab {

    private static AddItemsTab tab;

    private AddItemsTab(){
        this.setText("Add Item");

        ItemTable itemTable = new ItemTable();
        ShoeTable shoeTable = new ShoeTable();
        BrandTable brandTable = new BrandTable();
        ConditionTable conditionTable = new ConditionTable();

        GridPane pane = new GridPane();

        Text name = new Text("Name");
        pane.add(name, 0, 0);
        TextField nameTextField = new TextField();
        pane.add(nameTextField, 1, 0);

        Text size = new Text("Size");
        pane.add(size, 0, 1);
        TextField sizeTextField = new TextField();
        pane.add(sizeTextField, 1, 1);

        Text brand = new Text("Brand");
        pane.add(brand, 0, 2);
        ComboBox<Brand> comboBrand = new ComboBox<>();
        comboBrand.setItems(
                FXCollections.observableArrayList(brandTable.getAllBrands()));
        pane.add(comboBrand, 1, 2);


        Text condition = new Text("Condition");
        pane.add(condition, 0, 3);
        ComboBox<Condition> comboCondition = new ComboBox<>();
        comboCondition.setItems(
                FXCollections.observableArrayList(conditionTable.getAllConditions()));
        pane.add(comboCondition, 1, 3);


        Button submit = new Button("Submit");
        submit.setOnAction(e->{
            Item item = new Item(
                    Integer.parseInt(name.getText()),
                    Integer.parseInt(size.getText()),
                    comboBrand.getSelectionModel().getSelectedItem().getId(),
                    comboCondition.getSelectionModel().getSelectedItem().getId());
                    itemTable.createItem(item);
                    //StatsTab.getInstance().generateChart();
                    RemoveItemTab.getInstance().refreshTable();
        });
        pane.add(submit, 0, 4);


        pane.setPadding(new Insets(15));
        this.setContent(pane);

    }

    public static AddItemsTab getInstance() {
        if (tab == null){
            tab = new AddItemsTab();
        }
        return tab;
    }

}
