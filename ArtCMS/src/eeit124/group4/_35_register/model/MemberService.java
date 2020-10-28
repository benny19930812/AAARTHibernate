package eeit124.group4._35_register.model;

public interface MemberService {
	boolean idExists(String id);
	int saveMember(MemberBean mb);
	MemberBean queryMember(String id);
	public MemberBean checkIDPassword(String userId, String password) ;
}
