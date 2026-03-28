package libraryService.repository;

import libraryService.vo.Member;

import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository {

    private final List<Member> members = new ArrayList<>();


    public void addMember(Member member) {
        members.add(member);
    }

    public Member getEqualsID(String id) {
        for (Member m : members) {
            if (m.getId().equals(id)) {
                return m;
            }
        }
        return null;
    }

    public Member findMember(String id, String pass) {
        for (Member m : members) {
            if (m.getId().equals(id) && m.getPassWord().equals(pass)) {
                return m;
            }
        }
        return null;
    }
}
