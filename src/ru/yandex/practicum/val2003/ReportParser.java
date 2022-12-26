package ru.yandex.practicum.val2003;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReportParser {
    //ArrayList<MonthlyReport> monthlyReportsList;
    List<Path> monthFilesInDir;    //Список названий файлов с отчетами в директории
    String yearFilesInDir;    //годовой отчет название файла
    String currentYear ;
    String filesPath ;
    List<Integer> expenseIncomeForMonth;
    List<Integer> expenseIncomeForYear;

    public ReportParser() {
         //monthlyReportsList = new ArrayList<>();
        currentYear = "2021";
        filesPath = "./resources";
        monthFilesInDir=new ArrayList<>();;
        yearFilesInDir= null;
        expenseIncomeForMonth=new ArrayList<>();
        expenseIncomeForYear= new ArrayList<>();
    }

    static List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }

    void getNameOfFales() {    // получаем список названий файлов
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





    public MonthlyReport readMonthlyReport(String fileName) {   //получаем месячный отчет
        List<String> lines = readFileContents(fileName);
        ArrayList<MonthlyReportItem> items =new ArrayList<>();
        Month monthIs = Month.of(Integer.parseInt(fileName.substring(16, 18)));
        for (int i=1;i<lines.size();i++) {
            String line = lines.get(i);

            String[] filds=line.split(",");

            String itemName = filds[0];
            boolean isExpense=Boolean.parseBoolean(filds[1]);
            int quantity= Integer.parseInt(filds[2]);
            int price = Integer.parseInt(filds[3]);
           // System.out.println(monthIs+" "+itemName +" "+ isExpense+" "+quantity+" "+price);
            MonthlyReportItem item = new MonthlyReportItem(
                    itemName,
                    isExpense,
                    quantity,
                    price

            );
            items.add(item);
        }

        return new MonthlyReport(monthIs,items);
    }
    public MonthlyReport getAllMonthFiles(){ //получаем все месячные отчеты

        for (Path filename:monthFilesInDir
             ) {


            //System.out.println(monthlyReportList.toString());

        }
        return null;

    }
    public YearlyReport readYearlyReport() {
        List<String> lines = readFileContents(yearFilesInDir);
        ArrayList<YearlyReportItem> items =new ArrayList<>();


        for (int i=1;i<lines.size();i++) {
            String line = lines.get(i);

            String[] filds=line.split(",");

            Month month = Month.of(Integer.parseInt(filds[0]))  ;
            int amount=Integer.parseInt(filds[1]);
            boolean isExpense= Boolean.parseBoolean(filds[2]);

           System.out.println( month+" "+" "+amount+" "+isExpense);
            YearlyReportItem item = new YearlyReportItem(
                    month,
                    amount,
                    isExpense

            );
            items.add(item);



        }


        return  new YearlyReport(items);
    }

    }
