package com.jsoap;

import com.jsoap.model.CodeEntity;
import com.jsoap.repository.CodeRepository;
import com.jsoap.util.CodeFileWalker;
import com.jsoap.util.JsoapParseContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
public class JsaopTestApplication {
    private static CodeRepository codeRepository;

    @Autowired
    public JsaopTestApplication(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JsaopTestApplication.class, args);
        String pathToFiles = "src/data/pages";
        Path path = Paths.get(pathToFiles);
        try {
            Files.walkFileTree(path, new CodeFileWalker());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<CodeEntity> listEntity = JsoapParseContent.getEntity();
        for (CodeEntity entity: listEntity) {
            if (entity.getCode1() != null && entity.getCode2() != null) {
                codeRepository.save(entity);
            }
        }
        System.out.println("done");
    }
}
