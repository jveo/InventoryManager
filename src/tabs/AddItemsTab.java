package tabs;

import javafx.scene.control.Tab;

public class AddItemsTab extends Tab {

    private static AddItemsTab tab;

    private AddItemsTab(){
        this.setText("Add Item");
    }

    public static AddItemsTab getInstance() {
        if (tab == null){
            tab = new AddItemsTab();
        }
        return tab;
    }

}
