package libraryService.Service;

import libraryService.repository.MemberRepository;
import libraryService.repository.MemoryMemberRepository;
import libraryService.vo.Member;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void signUp(String name, String id, String pw) {
        Member member = Member.of(name,id,pw);
        memberRepository.addMember(member);
    }

    public boolean isEqualsID(String id) {
        return memberRepository.getEqualsID(id) != null;

    }

    public Member login(String id, String pw) {
        return memberRepository.findMember(id, pw);
    }
}
