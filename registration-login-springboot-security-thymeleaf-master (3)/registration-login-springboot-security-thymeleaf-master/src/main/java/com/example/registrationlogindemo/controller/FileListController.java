<<<<<<< HEAD:registration-login-springboot-security-thymeleaf-master/src/main/java/com/example/registrationlogindemo/controller/FileListController.java
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
        String directoryPath = "C:/imagens/";

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

    @GetMapping("/matches")
    public String listFiles(Model model) {
        // Substitua este caminho pelo caminho real do diretório onde os arquivos estão armazenados
        String directoryPath = "C:/imagens/";

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

        return "match"; // Nome do seu arquivo HTML que exibirá a lista de arquivos
    }
}

=======
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
        String directoryPath = "C:/imagens/";

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

    @GetMapping("/matches")
    public String listFiles(Model model) {
        // Substitua este caminho pelo caminho real do diretório onde os arquivos estão armazenados
        String directoryPath = "C:/imagens/";

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

        return "match"; // Nome do seu arquivo HTML que exibirá a lista de arquivos
    }
}

>>>>>>> f37bb475635418cda0b692a6fafa54d7437f1511:registration-login-springboot-security-thymeleaf-master (3)/registration-login-springboot-security-thymeleaf-master/src/main/java/com/example/registrationlogindemo/controller/FileListController.java
