package com.deploy.tugas.controller;

import com.deploy.tugas.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private final String USERNAME = "admin";
    private final String PASSWORD = "20230140013";

    private List<User> dataMahasiswa = new ArrayList<>();

    @GetMapping("/")
    public String loginpage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/home")
    public String homepage(Model model) {
        // Mengirim data mahasiswa yang ada di List ke halaman home.html
        model.addAttribute("mahasiswaList", dataMahasiswa);
        return "home";
    }

    @GetMapping("/form")
    public String formpage() {
        return "form";
    }

    @PostMapping("/simpan")
    public String simpanData(User user) {
        dataMahasiswa.add(user);
        return "redirect:/home";
    }
}