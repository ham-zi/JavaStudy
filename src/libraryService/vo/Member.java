package libraryService.vo;

import java.util.*;

public class Member {


    private final String name;
    private final String id;
    private final String passWord;


    private Member(String name, String id, String passWord) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Member name");
        }

        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Member ID");
        }

        if (passWord == null || passWord.isEmpty()) {
            throw new IllegalArgumentException("Member PASSWORD");
        }


        this.name = name;
        this.id = id;
        this.passWord = passWord;

    }

    public static Member of(String name, String id, String passWord) {
        return new Member(name, id , passWord);

    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPassWord() { return passWord;}

}

