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
        chart.setTitle("All Found Coins");
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
        //Get access to the database
        ItemTable itemTable = new ItemTable();
        ShoeTable shoeTable = new ShoeTable();
        //Grab a list of coin types
        ArrayList<Shoe> shoesArrayList = shoeTable.getAllShoes();
        //Clear the data in the chart
        chart.getData().clear();
        //Build a list of PieChart data
        ArrayList<PieChart.Data> data = new ArrayList<>();

        for(Shoe shoe : shoesArrayList) {
            //not add the record unless it has 1 or more coins
            if(itemTable.getItemCount(shoe.getId()) > 0) {
                data.add(new PieChart.Data(shoe.getName(),
                        itemTable.getItemCount(shoe.getId())));
            }
        }
        //Wrap the list in an ObservableList
        ObservableList<PieChart.Data> chartData =
                FXCollections.observableArrayList(data);
        //Populate the chart
        chart.setData(chartData);
    }


}
