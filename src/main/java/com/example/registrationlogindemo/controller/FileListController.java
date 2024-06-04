package com.example.registrationlogindemo.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileListController {
    @GetMapping("/downloadArquivo")
    public String listFile(Model model) {
        // Substitua este caminho pelo caminho real do diretório onde os arquivos estão armazenados
        String directoryPath = "../imagens/";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        List<String> fileList = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileList.add(file.getName());
                }
            }
        }

        model.addAttribute("fileList", fileList);

        return "downloadArquivo"; // Nome do seu arquivo HTML que exibirá a lista de arquivos
    }

}

