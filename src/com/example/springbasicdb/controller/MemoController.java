package com.example.springbasicdb.controller;

import com.example.springbasicdb.dto.MemoRequestDto;
import com.example.springbasicdb.dto.MemoResponseDto;
import com.example.springbasicdb.service.MemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;


@RestController // @Controller + @ResponseBody
@RequestMapping("/memos") // Prefix
public class MemoController
{

    private final MemoService memoService;


    private MemoController(MemoService memoService) {
        this.memoService = memoService;
    }


    @PostMapping
    public ResponseEntity<MemoResponseDto> createMemo(@RequestBody MemoRequestDto requestDto)
    {
        return new ResponseEntity<>(memoService.saveMemo(requestDto), HttpStatus.CREATED);
    }


    @GetMapping
    public List<MemoResponseDto> findAllMemos()
    {
        return memoService.findAllMemos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<MemoResponseDto> findMemoById(@PathVariable Long id)
    {
        return new ResponseEntity<>(memoService.findMemoById(id), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<MemoResponseDto> updateMemo
            (
            @PathVariable Long id,
            @RequestBody MemoRequestDto requestDto
            )
    {
        return new ResponseEntity<>(memoService.updateMemo(id, requestDto.getTitle(), requestDto.getContents()), HttpStatus.OK);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<MemoResponseDto> updateTitle
            (
            @PathVariable Long id,
            @RequestBody MemoRequestDto requestDto
            )
    {
        return new ResponseEntity<>(memoService.updateTitle(id, requestDto.getTitle(), requestDto.getContents()), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMemo(@PathVariable Long id)
    {
        memoService.deleteMemo(id);
        // 성공한 경우
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
