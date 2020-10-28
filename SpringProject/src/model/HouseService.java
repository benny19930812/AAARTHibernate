package model;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("houseService")
public class HouseService {

	@Autowired
	private HouseDAO houseDAO;

//	public HouseService(HouseDAO houseDAO) {
//		this.houseDAO = houseDAO;
//	}

	public House select(int houseid) throws SQLException {
		return houseDAO.select(houseid);
	}

}
