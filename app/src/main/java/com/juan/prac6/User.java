package com.juan.prac6;

/**
 * Created by juan on 18/10/17.
 */

public class User {
    private String name, nameB, phone, autor;
    private String uid;

    public User() {
    }

    public User(String uid, String name, String phone, String nameB, String autor) {
        this.name = name;
        this.nameB = nameB;
        this.phone = phone;
        this.uid = uid;
        this.autor=autor;
    }

    public String getNameB() {
        return nameB;
    }

    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
