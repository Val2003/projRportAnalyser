package ru.yandex.practicum.val2003;
import java.nio.file.Path;
import java.util.HashMap;


public class Reports {
    private HashMap<Integer, MonthlyReport> monthlyReports;
    private YearlyReport yearlyReport;

    public Reports(HashMap<Integer, MonthlyReport> monthlyReports, YearlyReport yearlyReport) {
        this.monthlyReports = monthlyReports;
        this.yearlyReport = yearlyReport;
    }



    void saveYearlyReport(YearlyReport yearlyReport) {
        this.yearlyReport = yearlyReport;
    }

    void saveMonthlyReports(HashMap<Integer, MonthlyReport> monthlyReports) {
        this.monthlyReports = monthlyReports;

    }

    public boolean getCompareResult() {
        return false;
    }
}