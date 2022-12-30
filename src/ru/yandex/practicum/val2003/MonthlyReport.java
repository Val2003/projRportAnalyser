package ru.yandex.practicum.val2003;


import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;


public class MonthlyReport {

void getMaxExpenseForMonth(){


}
    public ArrayList<MonthlyReportItem> getItems() {
        return items;
    }

    private ArrayList<MonthlyReportItem> items;

    public Month getMonthIs() {
        return monthIs;
    }

    private Month monthIs;

    public MonthlyReport(Month monthIs, ArrayList<MonthlyReportItem> items) {

        this.items = items;
        this.monthIs = monthIs;

    }






    public static class MonthlyReportItem {

        public String itemName;

        public boolean isExpense;
        public int quantity;
        public int price; //sum_of_one
        public int sumOfExpense;
        public int sumOfIncome;

        public MonthlyReportItem(String itemName, boolean isExpense, int quantity, int price, int sumOfExpense,int sumOfIncome) {
            this.itemName = itemName;
            this.isExpense = isExpense;
            this.quantity = quantity;
            this.price = price;
            this.sumOfExpense=sumOfExpense;
            this.sumOfIncome=sumOfIncome;

        }

    }




}
