package com.jsoap.model;

import javax.persistence.*;

@Entity
@Table(name = "jsoap")
public class CodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "code1")
    private String code1;
    @Column(name = "code2")
    private String code2;

    public CodeEntity() {
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CodeEntity{" +
                " code1='" + code1 + '\'' +
                ", code2='" + code2 + '\'' +
                '}';
    }
}
