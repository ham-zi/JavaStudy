package libraryService.controller;

import libraryService.Service.BookService;
import libraryService.Service.MemberService;
import libraryService.vo.Member;

public class MemberController {
    private final BookService bookService = new BookService();
    private final MemberService memberService = new MemberService();

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
