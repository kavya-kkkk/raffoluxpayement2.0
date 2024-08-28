package com.common_utilities;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class ExcelLogger {
	 private Workbook workbook;
	    private Sheet sheet;
	    private String filePath;
	    private Map<Integer, Row> rows;
	    private int rowIndex;

	    public ExcelLogger(String sheetName, String filePath) {
	        this.workbook = new XSSFWorkbook();
	        this.sheet = workbook.createSheet(sheetName);
	        this.filePath = filePath;
	        this.rows = new HashMap<>();
	        this.rowIndex = 0;
	    }

	    private Row getOrCreateRow(int rowIndex) {
	        Row row = rows.get(rowIndex);
	        if (row == null) {
	            row = sheet.createRow(rowIndex);
	            rows.put(rowIndex, row);
	        }
	        return row;
	    }

	    public void logData(String... data) {
	        Row row = getOrCreateRow(rowIndex++);
	        for (int i = 0; i < data.length; i++) {
	            Cell cell = row.createCell(i);
	            cell.setCellValue(data[i]);
	        }
	        save(); // Save after every log
	    }

	    private void save() {
	        try (FileOutputStream fos = new FileOutputStream(filePath)) {
	            workbook.write(fos);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // Close workbook explicitly only if needed
	    public void close() {
	        try {
	            workbook.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
