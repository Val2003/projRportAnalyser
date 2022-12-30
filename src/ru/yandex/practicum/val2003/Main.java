package ru.yandex.practicum.val2003;

import java.time.Month;
import java.util.*;

public class Main {
public static void main(String[] args) {


    Scanner scanner = new Scanner(System.in);
    Reconciliation reconciliation = new Reconciliation();
    ReportParser reportParser = new ReportParser();



    int userInput;
    boolean swich = true;
    System.out.println(

            "Это бухгалтерия. Для использования введите одну из цирф 1-5" );

    while(swich) {
        menu();
        userInput = scanner.nextInt();

        switch (userInput) {
            case 1 : {
                reportParser.getAllMonth();




                break;
            }
            case 2 :  {


                reportParser.getYearlyArrayList();
                break;
            }
            case 3 : {

                Set<Month> months = reportParser.monthlyReportsList.keySet();
                HashMap<Month, ArrayList<MonthlyReport.MonthlyReportItem>> x = reportParser.monthlyReportsList;
               for (Month m:months) {

                   x.get(m);

               }


                /*if (reconciliation.reportsCompare())
                        {

                            System.out.println("\nСверка данных завершена.");

                }*/


            }
            case 4 : {
                if(true//monthlyReport == null
                ){
                    System.out.println("Месячные отчеты не загружены, вызовите соответсвтующий метод");
                    break;
                }
                System.out.println("\nИнформация о месячных отчетах: \n");
                for (int i = 0; i < reportParser.monthFilesInDir.size(); i++){
                   // System.out.println(MonthlyReport.getShortReport(i) + "\n");
                }
            }
            case 5 : {
                if (true//yearlyReport == null || monthlyReport == null
                 )  {
                    System.out.println("Отчеты не загружены, считайте годовой и месячный отчеты");
                    break;
                }
                //    fileMaker.shortReportYear();
            }

            default : {
                System.out.println("Завершение работы!");
                swich = false;
            }
        }

    }


}
    private static void menu(){
        System.out.print("Введите команду: \n");
        System.out.println("1 - Считать все месячные отчеты.");
        System.out.println("2 - Считать годовой отчет.");
        System.out.println("3 - Сверить отчеты.");
        System.out.println("4 - Вывести информацию о всех месячных отчетах.");
        System.out.println("5 - Вывести информацию о годовом отчете.");
        System.out.println("Для выхода из программы используйте любую другую цифру");
    }
}
