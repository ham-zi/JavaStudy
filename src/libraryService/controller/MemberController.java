package libraryService.controller;

import libraryService.Service.BookService;
import libraryService.Service.MemberService;
import libraryService.vo.Member;

public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    // Member
    public void signUp(String name, String id, String pw) {
        memberService.signUp(name,id,pw);
    }

    public boolean isEqualsID(String id) {
        return memberService.isEqualsID(id);
    }

    public Member login(String id, String pw) {
        return memberService.login(id, pw);
    }

}
