package controller.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;

public class IncomeReportFormController {

    public AnchorPane incomeReportFormContext;
    public PieChart monthlyPieChart;
    public PieChart annualyPieChart;

    public void initialize(){
        iniPie();
    }

    private void iniPie(){
        ObservableList<PieChart.Data> pieChartMonthlyData = FXCollections.observableArrayList(
                new PieChart.Data("Booked",30),
                new PieChart.Data("Canceled",4),
                new PieChart.Data("Short Leave",14)
        );

        ObservableList<PieChart.Data> pieChartAnnuallyData = FXCollections.observableArrayList(
                new PieChart.Data("Booked",250),
                new PieChart.Data("Canceled",28),
                new PieChart.Data("Short Leave",57)

        );

        monthlyPieChart.setData(pieChartMonthlyData);
        annualyPieChart.setData(pieChartAnnuallyData);

    }
    
}
