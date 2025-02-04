package com.example.springbasicdb.repository;

import com.example.springbasicdb.dto.MemoResponseDto;
import com.example.springbasicdb.entity.Memo;

import java.util.*;


public interface MemoRepository
{
    MemoResponseDto saveMemo(Memo memo);
    List<MemoResponseDto> findAllMemos();
    Optional<Memo> findMemoById(Long id);
    Memo findMemoByIdOrElseThrow(Long id);
    int updateMemo(Long id, String title, String contents);
    int updateTitle(Long id, String title);
    int deleteMemo(Long id);
}
