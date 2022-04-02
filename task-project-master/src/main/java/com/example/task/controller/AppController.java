package com.example.task.controller;

import com.example.task.entity.User;
import com.example.task.repository.UserRepository;
import com.example.task.servise.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String listUsers(Model model) {
        List<User> listUsers = (List<User>) userRepository.findAll();
        model.addAttribute("listUsers", listUsers);
        return findPaginated(1, model);
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }


    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "register_success";
    }


    @GetMapping("/page/{pageNo}")
    private String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 3;
        Page<User> page = userService.findPaginated(pageNo, pageSize);
        List<User> listUsers = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

//    @GetMapping("/verify")
//    public String verifyUser(@Param("code") String code) {
//        if (userService.verify(code)) {
//            return "verify_success";
//        } else {
//            return "verify_fail";
//        }
//    }
}
