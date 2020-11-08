package com.example.BlogMe.controller;

import com.example.BlogMe.entities.Content;
import com.example.BlogMe.repositories.ContentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    @Autowired
    private ContentRepo contentRepo;
    private boolean checkAdmin = false;
    @GetMapping("/admin")
    public String indexAdmin(@RequestParam String username, @RequestParam String password,ModelMap model){

        if(!username.equals("admin") && !password.equals("admin")){
            return "redirect:/home?username="+username+"&password="+password;
        }
        
        model.addAttribute("AllContent",contentRepo.findAll()); 
        return "admin";
    }

    @GetMapping(path="/home")
    public String index(ModelMap model){

        model.addAttribute("AllContent",contentRepo.findAll()); 
        return "home";
    }
    @GetMapping(path="/")
    public String loginPage(){
        checkAdmin = false;
        // model.addAttribute("AllContent",contentRepo.findAll()); 
        return "login";
    }
    @GetMapping(path="/addpage")
    public String add(){
        return "add";
    }
    @PostMapping(path = "/addtoDB")
    public String addtoDB(@RequestParam String title,@RequestParam String text,@RequestParam String author ,ModelMap model){
        Content blog = new Content();
        blog.setTitle(title);
        blog.setText(text);
        blog.setAuthor(author);

        model.addAttribute("alert" , "complete");
        // model.addAttribute("checkAdmin" ,checkAdmin);

        contentRepo.save(blog);
        
        return "alert";
    }
}
