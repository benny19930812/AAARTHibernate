package eeit124.group4._35_register.model;

import java.sql.Connection;

public interface MemberDao {
	
	public boolean idExists(String id);

	public int saveMember(MemberBean mb) ;
	
	public MemberBean queryMember(String id);
	
	public MemberBean checkIDPassword(String userId, String password);	

	public void setConnection(Connection con);
}