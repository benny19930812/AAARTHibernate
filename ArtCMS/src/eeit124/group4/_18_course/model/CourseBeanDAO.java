package eeit124.group4._18_course.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class CourseBeanDAO {

	private Session session;

	public CourseBeanDAO(Session session) {
		this.session = session;
	}

	public Course_LN insert(Course_LN bean_LN) {
		Course_LN result = session.get(Course_LN.class, bean_LN.getId());
		if (result == null) {
			session.save(bean_LN);
			return bean_LN;
		}
		return null;
	}

	public Course_LN select(String id) {
		return session.get(Course_LN.class, id);
	}

	public List<Course_LN> selectAll() {
		Query<Course_LN> query = session.createQuery("FROM Course_LN", Course_LN.class);
		System.out.println(query);
		List<Course_LN> list = query.list();
		return list;
	}

	public Course_LN update(String id, String title, String act_Location, String location_Name, int price,
			String act_Time, String end_Time, String main_Unit) {
		Course_LN result = session.get(Course_LN.class, id);
		if (result != null) {
			result.setTitle(title);
			result.setAct_Location(act_Location);
			result.setLocation_Name(location_Name);
			result.setPrice(price);
			result.setAct_Time(act_Time);
			result.setEnd_Time(end_Time);
			result.setMain_Unit(main_Unit);
		}
		return result;
	}

	public boolean delete(String id) {
		Course_LN result = session.get(Course_LN.class, id);
		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}

}
