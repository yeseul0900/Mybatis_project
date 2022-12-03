package com.example;

import java.util.Date;

public class SuggestionVO {
    private int personID;
    private String name;
    private String nickname;
    private int s_number;
    private String major;
    private String department;
    private String category;
    private Date regdate;
    private String suggestions;

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getS_number() {
        return s_number;
    }

    public void setS_number(int s_number) {
        this.s_number = s_number;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getSuggestion() {
        return suggestions;
    }

    public void setSuggestion(String suggestions) {
        this.suggestions = suggestions;
    }

}
