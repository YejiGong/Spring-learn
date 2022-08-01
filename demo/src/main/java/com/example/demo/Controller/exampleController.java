package com.example.demo.Controller;

import com.example.demo.Domain.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class exampleController {
    private final UserService userService;

    @Autowired
    public exampleController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }


    @PostMapping(value = "/members/new")
    public String create(MemberForm form){
        User user = new User();
        user.setName(form.getName());
        userService.join(user);

        return "redirect:/";
    }

    @GetMapping(value="/members")
    public String list(Model model){
        List<User> users = userService.findUsers();
        model.addAttribute("users", users);
        return "members/memberList";


    }

}
