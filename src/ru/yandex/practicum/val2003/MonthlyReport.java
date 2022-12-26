package ru.yandex.practicum.val2003;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MonthlyReport {


    List<String> mostIncomeItem;
    List<Integer> maxIncomeForMonth;
    //item_name,is_expense,quantity,sum_of_one

public ArrayList<MonthlyReportItem> items;
    public Month monthIs;
  //  mostIncomeItem = new ArrayList<>();
   // maxIncomeForMonth = new ArrayList<>();
public MonthlyReport(Month monthIs,ArrayList<MonthlyReportItem> items) {

this.items=items;
this.monthIs=monthIs;

}
    public String getShortReport(int index){
        return ("Название месяца: " + Month.of(index)); //+
              //  "\nСамый прибыльный товар:  " + mostIncomeItem.get(index) +
             //   "\nЗаработанная сумма: " + maxIncomeForMonth.get(index));
    }
void printMontlyReport(){
    System.out.println();
}


}
