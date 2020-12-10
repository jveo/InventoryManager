package tabs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import pojo.Shoe;
import tables.ItemTable;
import tables.ShoeTable;

import java.util.ArrayList;

public class StatsTab extends Tab {

    private static StatsTab tab;
    private PieChart chart;

    private StatsTab(){
        this.setText("Statistics");


        BorderPane pane = new BorderPane();
        chart = new PieChart();
        chart.setTitle("All Found Shoes");
        chart.setLabelsVisible(true);
        generateChart();
        pane.setCenter(chart);

        //set the center of the BorderPane to a PieChart
        this.setContent(pane);


    }

    public static StatsTab getInstance() {
        if (tab == null){
            tab = new StatsTab();
        }
        return tab;
    }

    public void generateChart(){

        ItemTable itemTable = new ItemTable();
        ShoeTable shoeTable = new ShoeTable();

        ArrayList<Shoe> shoesArrayList = shoeTable.getAllShoes();
        chart.getData().clear();

        ArrayList<PieChart.Data> data = new ArrayList<>();

        for(Shoe shoe : shoesArrayList) {
            if(itemTable.getItemCount(shoe.getId()) > 0) {
                data.add(new PieChart.Data(shoe.getType(),
                        itemTable.getItemCount(shoe.getId())));
            }
        }

        ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList(data);
        chart.setData(chartData);
    }


}
