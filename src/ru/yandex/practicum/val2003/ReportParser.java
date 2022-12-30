package ru.yandex.practicum.val2003;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReportParser {
    HashMap<Month, ArrayList<MonthlyReport.MonthlyReportItem>> monthlyReportsList;
    List<Path> monthFilesInDir;    //Список названий файлов с отчетами в директории
    ArrayList<YearlyReport> yearItems;
    String yearFilesInDir;    //годовой отчет название файла
    String currentYear ;
    String filesPath ;


    public ReportParser() {

        monthlyReportsList = new HashMap<>();
        yearItems=new ArrayList<>();
        currentYear = "2021";
        filesPath = "./resources";
        monthFilesInDir=new ArrayList<>();


        getNameOfFales();
    }

   public static List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }

   private void getNameOfFales() {    // получаем список названий файлов
        try (Stream<Path> stream = Files.walk(Paths.get(filesPath))) {

            monthFilesInDir = stream.map(Path::normalize)
                    .filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().startsWith("m."))
                    .filter(path -> path.getFileName().toString().endsWith(".csv"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        yearFilesInDir = filesPath+"/y."+currentYear+".csv" ;


    }

    public MonthlyReport readMonthlyReport(Path fileName) {   //получаем месячный отчет

        List<String> lines = ReportParser.readFileContents(fileName.toString());

        ArrayList<MonthlyReport.MonthlyReportItem> items = new ArrayList<>();
        Month monthIs = Month.of(Integer.parseInt(fileName.toString().substring(16, 18)));

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);

            String[] filds = line.split(",");

            String itemName = filds[0];
            boolean isExpense = Boolean.parseBoolean(filds[1]);
            int quantity = Integer.parseInt(filds[2]);
            int price = Integer.parseInt(filds[3]);
            int sumOfExpense = 0;
            int sumOfIncome=0;
            if (isExpense) {sumOfExpense=quantity*price;} else {sumOfIncome=quantity*price;}
            MonthlyReport.MonthlyReportItem item = new MonthlyReport.MonthlyReportItem(
                    itemName,
                    isExpense,
                    quantity,
                    price,
                    sumOfExpense,
                    sumOfIncome


            );


            items.add(item);
        }

        return new MonthlyReport(monthIs, items);


    }





    void getAllMonth(){
        for(Path currentFile:monthFilesInDir){

            monthlyReportsList.put(readMonthlyReport(currentFile).getMonthIs(),readMonthlyReport(currentFile).getItems());

        }


    }

    public ArrayList<YearlyReport> readYearlyReport() {
        List<String> lines = readFileContents(yearFilesInDir);
        ArrayList<YearlyReport> items =new ArrayList<>();
        for (int i=1;i<lines.size();i++) {
            String line = lines.get(i);
            String[] filds=line.split(",");
            Month month = Month.of(Integer.parseInt(filds[0]))  ;
            Month preMount=null;
            int amount=Integer.parseInt(filds[1]);
            boolean isExpense= Boolean.parseBoolean(filds[2]);
            int sumOfExpense=0;
            int sumOfIncome=0;
            if (isExpense) {sumOfExpense=amount;} else {sumOfIncome=amount;}

            YearlyReport item = new YearlyReport(
                    month,
                    amount,
                    isExpense,
                    sumOfExpense,
                    sumOfIncome

            );

            items.add(item);
            preMount=month;
            System.out.println(preMount);
        }

      return  items;
    }
   void getYearlyArrayList(){
       yearItems=readYearlyReport();

    }
    }
