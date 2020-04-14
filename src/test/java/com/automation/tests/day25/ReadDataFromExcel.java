package com.automation.tests.day25;

import com.automation.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ReadDataFromExcel {

    @Test
    public void readExcelFileTest() throws IOException {

        File file = new File("VytrackTestUsers.xlsx");
        // file coming from java
        // we need to get a file as an object

        Workbook workbook = WorkbookFactory.create(file);
        // workbook coming from apache poi
        // Workbook is an object that represent excel file

        // to get specific sheet
        // there are 6 sheet in workbook
        Sheet workSheet = workbook.getSheet("QA1-short");


        // get first rows at first place
        Row firstRow = workSheet.getRow(0);

        // get first cell in first row
        Cell firstCell = firstRow.getCell(0);

        // get string value of first cell
        String value = firstCell.getStringCellValue();

        // get string  value of second cell
        String secondCellValue = firstRow.getCell(1).getStringCellValue();

        System.out.println(value);
        System.out.println(secondCellValue);



        int lastCell = firstRow.getLastCellNum();
        System.out.println(lastCell); // 'result' place number
        System.out.println("###########");

        // to print all cells in firstRow
        for (int i = 0; i <lastCell ; i++) {
            System.out.print(firstRow.getCell(i)+"  |  ");
        }
        System.out.println();


        // question in interview HOW YOU READ THE DATE FROM EXCEL ?
        // answer -> explain how you add the apoche poi dependency into your maven
        // and how you used them like above .


        // to pprint amount of numbers rows
        int numberOfRows = workSheet.getLastRowNum();
        System.out.println(numberOfRows);
        // it is 16 on file  but based index 0 1 2 3 4 ... it is 15.


        // returns how many rows on file -> 16
        // this one considered number of rows
        int numberOfRows2 = workSheet.getPhysicalNumberOfRows();
        System.out.println(numberOfRows2);


        System.out.println("########");


        // to print whole spreedsheet -> QA1-short
        for (int row = 0; row < workSheet.getPhysicalNumberOfRows(); row++) {
            for (int cell = 0; cell < workSheet.getRow(row).getLastCellNum() ; cell++){
                String cellValue = workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.print(cellValue + " | ");

                }
            System.out.println();
            }
        }



    @Test
    public void excelUtilityTest(){
        String path = "VytrackTestUsers.xlsx" ;
        String spreadSheet = "QA1-all" ;
        ExcelUtil excelUtil = new ExcelUtil(path,spreadSheet);


        // System.out.println(excelUtil.getDataList());
        // excelUtil.getDataList().forEach(System.out::println);
        // or for each ;
        for(Map<String, String> record : excelUtil.getDataList()) {
            System.out.println(record);
        }
    }


    @Test
    public void getColumnNamesTest(){
        String path = "VytrackTestUsers.xlsx" ;
        String spreadSheet = "QA1-all" ;
        ExcelUtil excelUtil = new ExcelUtil(path,spreadSheet);
        // path and spread sheet  must be specified in constructor
        System.out.println(excelUtil.getColumnsNames());
        // all column names as a collection string

    }
}

 // All purpose of ExcelUtils are ;
 // just getting data from excel and store them into Map or MultiDimensional Array
