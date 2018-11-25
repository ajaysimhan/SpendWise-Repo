package categoriesAPI;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.WatchService;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TransactionCategory {
	private ArrayList<Integer> waste = new ArrayList<>();
	private ArrayList<Integer> useful = new ArrayList<>();
	
	//Receives filestream of excel sheet
	public ArrayList<TransactionType> getData(FileInputStream fStream) {
		ArrayList<TransactionType> types = new ArrayList<>();
		try {
			Workbook wb = new XSSFWorkbook(fStream);
			int numberOfSheets = wb.getNumberOfSheets();
			for(int i = 0; i < numberOfSheets; i++) {
				TransactionType transactionType = new TransactionType();
				types.add(transactionType);
				Sheet sheet = wb.getSheetAt(i);
				String sheetName = sheet.getSheetName();
				transactionType.catergoryType = sheetName;
				for(int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {
					CategoryDTO categoryDTO = new CategoryDTO();
					transactionType.elements.add(categoryDTO);
					Row row = sheet.getRow(j);
					Cell firstCell = row.getCell(0);
					Cell secondCell = row.getCell(1);
					Cell thirdCell = row.getCell(2);
					categoryDTO.categoryId = (int) firstCell.getNumericCellValue();
					categoryDTO.description = secondCell.getStringCellValue();
					categoryDTO.nature = thirdCell.getStringCellValue();
					if(categoryDTO.nature.equals("waste")) {
						waste.add(categoryDTO.categoryId);
					} else {
						useful.add(categoryDTO.categoryId);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return types;
	}

	public ArrayList<Integer> getWaste() {
		return waste;
	}

	public void setWaste(ArrayList<Integer> waste) {
		this.waste = waste;
	}

	public ArrayList<Integer> getUseful() {
		return useful;
	}

	public void setUseful(ArrayList<Integer> useful) {
		this.useful = useful;
	}
}
