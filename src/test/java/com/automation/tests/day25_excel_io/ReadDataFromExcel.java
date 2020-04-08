package com.automation.tests.day25_excel_io;

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

        Workbook workbook = WorkbookFactory.create(file);
        // Workbook is an object that represent excel file
        // workbook coming from apache poi

        // to get specific sheet
        Sheet workSheet = workbook.getSheet("QA1-short");


        Row firstRow = workSheet.getRow(0);

        Cell firstCell = firstRow.getCell(0);

        // get string value of firt cell first value
        String value = firstCell.getStringCellValue();

        String secondCellValue = firstRow.getCell(1).getStringCellValue();

        System.out.println(value);
        System.out.println(secondCellValue);

        int lastCell = firstRow.getLastCellNum();
        System.out.println(lastCell);
        System.out.println("###########");

        for (int i = 0; i <lastCell ; i++) {
            System.out.print(firstRow.getCell(i)+"  |  ");
        }

        // question in interview HOW YOU READ THE DATE FROM EXCEL ?
        // answer -> explain how you add the apoche dependency into your maven
        // and how you used them like above .

        // numbers of rows ?
        int numberOfRows = workSheet.getLastRowNum();
        System.out.println(numberOfRows);
        // it is 16 on file  but based index 0 1 2 3 4 ... it is 15.

        // returns how many rows on file -> 16
        int numberOfRows2 = workSheet.getPhysicalNumberOfRows();
        System.out.println(numberOfRows2);


        System.out.println("########");

        for (int row = 0; row < workSheet.getPhysicalNumberOfRows(); row++) {
            for (int cell = 0; cell < workSheet.getRow(row).getLastCellNum() ; cell++){
                String cellValue = workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.println(cellValue + " | ");


                }
            System.out.println();
            }
        }



    @Test
    public void excelUtilityTest(){
        String path = "VytrackTestUsers.xlsx" ;
        String spreadSheet = "QA1-all" ;
        ExcelUtil excelUtil = new ExcelUtil(path,spreadSheet);

        // excelUtil.getDataList().forEach(System.out::println);
        // or

        for(Map<String, String> record : excelUtil.getDataList()) {
            System.out.println(record);
        }
    }

    @Test
    public void getColumnNamesTest(){
        String path = "VytrackTestUsers.xlsx" ;
        String spreadSheet = "QA1-all" ;
        ExcelUtil excelUtil = new ExcelUtil(path,spreadSheet);
        System.out.println(excelUtil.getColumnsNames());

    }



    }

 // just getting data from excel and store them into Map or MultiDimensional Array
