package com.example.springbasicdb.dto;

import com.example.springbasicdb.entity.Memo;
import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.*;

@Getter
@AllArgsConstructor
public class MemoResponseDto
{


    private Long id;


    private String title;


    private String contents;


    private String name;
    private Long pw;
    private Date date;


    public MemoResponseDto(Memo memo)
    {
        this.id = memo.getId();
        this.title = memo.getTitle();
        this.contents = memo.getContents();
        this.name = memo.getName();
        this.pw = memo.getPw();
        this.date = memo.getDate();

    }
}
