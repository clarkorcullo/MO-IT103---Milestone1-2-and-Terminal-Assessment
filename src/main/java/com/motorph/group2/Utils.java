/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.group2;

//import com.opencsv.CSVReader;
//import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author enuj
 */
public class Utils {
//    public static void main(String args[]) {
//        Object[][] d = GetData("10001");
//        System.out.println(d);
//    }
    public static void writeTableModelToCsv(DefaultTableModel tableModel, String filePath) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(filePath));
            
            // Write the column headers to the CSV file
            String[] headers = new String[tableModel.getColumnCount()];
            for (int i = 0; i < headers.length; i++) {
                headers[i] = tableModel.getColumnName(i);
            }
            writer.writeNext(headers);
            
            // Write the data rows to the CSV file
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String[] rowData = new String[tableModel.getColumnCount()];
                for (int j = 0; j < rowData.length; j++) {
                    rowData[j] = tableModel.getValueAt(i, j).toString();
                }
                writer.writeNext(rowData);
            }
            
            writer.close();
        } catch (IOException e) {
        }
    }
}
