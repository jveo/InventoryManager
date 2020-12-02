package tabs;

import javafx.scene.control.Tab;

public class ViewItemsTab extends Tab {

    private static ViewItemsTab tab;

    private ViewItemsTab(){
        this.setText("View Items");
    }

    public static ViewItemsTab getInstance() {
        if (tab == null){
            tab = new ViewItemsTab();
        }
        return tab;
    }

}
