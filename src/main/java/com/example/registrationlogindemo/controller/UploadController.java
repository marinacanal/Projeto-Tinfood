package com.example.registrationlogindemo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.registrationlogindemo.repository.UserRepository;

@Controller
public class UploadController {

    @Autowired
    private final UserRepository userRepository;

    public UploadController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Value("${upload.path}")
    private String uploadPath;

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Por favor, selecione um arquivo para fazer upload.");
            return "";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadPath + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "Upload realizado com sucesso: " + file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        UsuarioLogadoController.getUsuarioLogado().setFoto_perfil("../imagens/" + file.getOriginalFilename());
        userRepository.save(UsuarioLogadoController.getUsuarioLogado());

        return "redirect:/downloadArquivo";
    }
}
