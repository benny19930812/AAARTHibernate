package tw.springmvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureService {
	@Autowired
	private PictureDAO pictureDao;
	
	public Picture insert(Picture pBean) {
		return pictureDao.insert(pBean);
	}
	
	public Picture select(int id) {
		return pictureDao.select(id);
	}
}
