package com.example.springbasicdb.service;

import com.example.springbasicdb.dto.MemoRequestDto;
import com.example.springbasicdb.dto.MemoResponseDto;

import java.util.*;

public interface MemoService
{
    MemoResponseDto saveMemo(MemoRequestDto requestDto);
    List<MemoResponseDto> findAllMemos();
    MemoResponseDto findMemoById(Long id);
    MemoResponseDto updateMemo(Long id, String title, String contents);
    MemoResponseDto updateTitle(Long id, String title, String contents);
    void deleteMemo(Long id);
}
