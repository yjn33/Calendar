package com.example.springbasicdb.service;

import com.example.springbasicdb.dto.MemoRequestDto;
import com.example.springbasicdb.dto.MemoResponseDto;
import com.example.springbasicdb.entity.Memo;
import com.example.springbasicdb.repository.MemoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;


@Service
public class MemoServiceImpl implements MemoService
{
    private final MemoRepository memoRepository;


    public MemoServiceImpl(MemoRepository memoRepository)
    {
        this.memoRepository = memoRepository;
    }


    @Override
    public MemoResponseDto saveMemo(MemoRequestDto requestDto)
    {
        // 요청받은 데이터로 Memo 객체 생성
        Memo memo = new Memo(requestDto.getTitle(), requestDto.getContents(), requestDto.getName(),  requestDto.getPw());

        // 저장
        return memoRepository.saveMemo(memo);
    }

    @Override
    public List<MemoResponseDto> findAllMemos()
    {
        return memoRepository.findAllMemos();
    }

    @Override
    public MemoResponseDto findMemoById(Long id)
    {
        Memo memo = memoRepository.findMemoByIdOrElseThrow(id);
        return new MemoResponseDto(memo);
    }


    @Transactional
    @Override
    public MemoResponseDto updateMemo(Long id, String title, String contents)
    {
        // 필수값 검증
        if (title == null || contents == null)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and content are required values.");
        }

        // memo 수정
        int updatedRow = memoRepository.updateMemo(id, title, contents);
        // 수정된 row가 0개라면
        if (updatedRow == 0)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No data has been modified.");
        }

        Memo memo = memoRepository.findMemoByIdOrElseThrow(id);

        // 수정된 메모 조회
        return new MemoResponseDto(memo);
    }


    @Transactional
    @Override
    public MemoResponseDto updateTitle(Long id, String title, String contents)
    {
        // 필수값 검증
        if (title == null || contents != null)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and content are required values.");
        }

        // memo 제목 수정
        int updatedRow = memoRepository.updateTitle(id, title);
        // 수정된 row가 0개 라면
        if (updatedRow == 0)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No data has been modified.");
        }

        Memo memo = memoRepository.findMemoByIdOrElseThrow(id);

        // 수정된 메모 조회
        return new MemoResponseDto(memo);
    }

    @Override
    public void deleteMemo(Long id)
    {
        // memo 삭제
        int deletedRow = memoRepository.deleteMemo(id);
        // 삭제된 row가 0개 라면
        if (deletedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

    }

}
