package libraryService;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    private final List<Member> members = new ArrayList<>();


    public void registerMember(String name, String id, String passWord) {
            members.add(Member.of(name, id, passWord));

    }

    public boolean isID(String id) {
        for (Member m:members) {
            if( m.getId().equals(id) ) {
                return true;
            }
        }
        return false;
    }

    public Member getMember(String id, String pass) {
        for(Member m:members) {
            if( m.getId().equals(id) && m.getPassWord().equals(pass) ) {
                return m;
            }
        }
        return null;
    }



}
