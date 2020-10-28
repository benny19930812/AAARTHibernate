package eeit124.group4._35_cms.model;

import java.util.List;

public interface InterfaceEventSpaceService {

	EventSpace select(int id);

	List<EventSpace> selectAll();

	EventSpace insert(EventSpace bean);

	EventSpace update(int id, String name);

	boolean delete(int id);

}