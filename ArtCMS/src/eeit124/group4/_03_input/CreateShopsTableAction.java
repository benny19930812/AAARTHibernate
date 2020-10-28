package eeit124.group4._03_input;

import java.util.ArrayList;

import eeit124.group4._03_input.Shops.CreateShopsTable;
import eeit124.group4._03_input.Shops.ShopsTable;

public class CreateShopsTableAction {

	public static void main(String[] args) {
		
		CreateShopsTable input = new CreateShopsTable();
		
		//刪除舊的文創商店表格
		input.dropShopsTable();
		
		//建立文創商店表格
		input.createShopsTableForDB();
		
		//讀取Json轉換成list
		ArrayList<ShopsTable> list = input.readJsonToTable();
		
		//將list讀進DB
		input.creatShopsInfoTable(list);
		
	}

}
