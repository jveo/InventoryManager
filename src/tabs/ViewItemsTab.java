package tabs;

import javafx.scene.control.Tab;

public class ViewItemsTab extends Tab {

    public static ViewItemsTab tab;

    public ViewItemsTab(){
        this.setText("View Items");
    }

    public static ViewItemsTab getInstance() {
        if (tab == null){
            tab = new ViewItemsTab();
        }
        return tab;
    }

}
