package libraryService.repository;

import libraryService.vo.Member;

public interface MemberRepository {
    public void addMember(Member member);
    public Member getEqualsID(String id);
    public Member findMember(String id, String pw);
}
