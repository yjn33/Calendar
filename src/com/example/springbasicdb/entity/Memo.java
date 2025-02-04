package com.example.springbasicdb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@Getter
@AllArgsConstructor
public class Memo
{

    private Long id;
    private String title;
    private String contents;


    private String name;
    private Long pw;
    private Date date;


    public Memo(String title, String contents, String name, Long pw)
    {
        this.title = title;
        this.contents = contents;
        this.name = name;
        this.pw = pw;

    }

    public void update(String title, String contents)
    {
        this.title = title;
        this.contents = contents;
    }

    public void update(String title)
    {
        this.title = title;
    }
}
