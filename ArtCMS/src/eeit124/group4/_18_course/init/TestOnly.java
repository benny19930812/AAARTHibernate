package eeit124.group4._18_course.init;

import java.util.ArrayList;

public class TestOnly {

	public static void main(String[] args) {
				
		CourseDataInput jdbcdao = new CourseDataInput();
	
		jdbcdao.dropTable(); //刪除表格
		jdbcdao.createTable();//創建表格
		ArrayList<COURSE_LN> list = jdbcdao.readJson();//讀取網路上的json
		jdbcdao.writeDB(list);//寫入資料到資料庫內的表格
		
	}

}
