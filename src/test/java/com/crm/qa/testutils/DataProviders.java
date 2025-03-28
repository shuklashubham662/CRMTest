package com.crm.qa.testutils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	


	

@DataProvider(name="testdata")	
public String[][] getdata() throws IOException
{
String path=".\\testdata\\Contacts.xlsx";
ExcelUtils utils=new ExcelUtils(path);
int row=utils.getRowCount("Sheet1");
int column=utils.getCellCount("Sheet1", row);
String data[][]=new String[row][column];
 for(int i=1;i<=row;i++)
 {
	 for(int j=0;j<column;j++)
	 {
		data[i-1][j]= utils.getCellData("Sheet1",i, j);
	 }
 }
return data;

}
}