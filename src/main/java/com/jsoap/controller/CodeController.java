package com.jsoap.controller;

import com.jsoap.model.CodeEntity;
import com.jsoap.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CodeController {
    private final CodeRepository codeRepository;

    @Autowired
    public CodeController(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    @GetMapping("all-codes")
    public List<CodeEntity> getAllCodes() {
        return codeRepository.findAll();
    }
}
