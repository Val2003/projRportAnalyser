package ru.yandex.practicum.val2003;

import java.time.Month;

public class YearlyReport {
   
    public  Month month;
    public  int amount;
    public  boolean isExpense;
    public int sumOfExpense=0;
    public int sumOfIncome=0;
    public YearlyReport(Month month, int amount, boolean isExpense, int sumOfExpense,int sumOfIncome) {

        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
        this.sumOfExpense=sumOfExpense;
        this.sumOfIncome=sumOfIncome;
    }
}
