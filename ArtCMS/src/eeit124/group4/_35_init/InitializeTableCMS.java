package eeit124.group4._35_init;

import eeit124.group4._35_init.util.CreateTableForDB;

public class InitializeTableCMS {
	
	public static void main(String[] args) {
		CreateTableForDB ct = new CreateTableForDB();
		ct.dropTableEventSpace();
		ct.createTableEventSpace();
		ct.dropTableSponsorship();
		ct.createTableSponsorship();
	}
}
