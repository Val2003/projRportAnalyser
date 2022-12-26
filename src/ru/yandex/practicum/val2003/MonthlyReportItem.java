package ru.yandex.practicum.val2003;

public class MonthlyReportItem {

    public String itemName;

    public boolean isExpense;
    public int quantity;
    public int price; //sum_of_one


    public MonthlyReportItem(String itemName, boolean isExpense, int quantity, int price) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.price = price;
    }

}
