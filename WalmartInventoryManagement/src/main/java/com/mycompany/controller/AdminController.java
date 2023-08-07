/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DAO.AdminDAO;
import com.mycompany.command.AddUser;
import com.mycompany.command.DeleteUser;
import com.mycompany.command.ListUser;
import com.mycompany.command.LoginCommand;
import com.mycompany.domain.Admin;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Rejina
 */
@Controller
public class AdminController {
    @Autowired
    AdminDAO ad;
    @RequestMapping (value = {"/login"}, method = RequestMethod.GET)
    public String LoginForm(Model m, HttpSession  session){
        m.addAttribute("command",new LoginCommand());
                session.invalidate();
                return "login";
    }
    @RequestMapping(value="/loginProcess", method = RequestMethod.POST)
        public String LoginProcess(@ModelAttribute("command") LoginCommand lc, Model m, HttpSession session) {
            if(ad.login(lc.getuName(),lc.getpWord())){
                m.addAttribute("title","Walmart Inventory Management");
                m.addAttribute("message","Login Sucessful");
                session.setAttribute("uName", lc.getuName());
                
                return "dashboard";
            }
            else {
                m.addAttribute("message","Invalid Login");
                return "login";
            }
            
        }

      @RequestMapping("/logout")
      public String Logout(){
          return "redirect:login";
      }
      
     
    @RequestMapping("/adduser")
    public String AddUser(Model m,HttpSession session){
        if (session.getAttribute("uName")!=null){
        m.addAttribute("User", new AddUser());
        return "adduser";
    }
        else
            return "redirect:login";
 }
    @RequestMapping(value="/processUser", method = RequestMethod.POST)
    public String ProcessUser(@ModelAttribute ("User") AddUser au, HttpSession session){
        if(session.getAttribute("uName")!= null){
            if(ad.addUser(au.getUserName(),au.getAddress(),au.getContactNo(), au.getPassWord(), au.getConfirmPassWord())){
                session.setAttribute("message", "New User created sucessfully!!");
                return "redirect: adduser";
        }else{
            session.setAttribute("message", "User Already Exits!!");
                return "redirect: adduser";
        }
           
            
    }
        else
            return "redirect: login";
    }    
    
@RequestMapping("/deleteuser")
    public String deleteUser(Model m,HttpSession session){
        if (session.getAttribute("uName")!=null){
        m.addAttribute("admin", new DeleteUser());
        return "deleteuser";
    }
        else
            return "redirect:login";
 }
    
    @RequestMapping(value="/processdeleteuser", method = RequestMethod.POST)
    public String ProcessDeleteUser(@ModelAttribute ("admin") DeleteUser du, HttpSession session){
        if(session.getAttribute("uName")!= null){
            if(ad.deleteUser(du.getUserName())){
                session.setAttribute("message", "User deleted sucessfully!!");
                return "redirect: deleteuser";
        }else{
            session.setAttribute("message", "User Doesn't Exits!!");
                return "redirect: deleteuser";
        }
           
            
    }
        else
            return "redirect: login";
    }
    
    @RequestMapping(value="/listuser", method = RequestMethod.GET)
    
    public ArrayList<Admin> listUser(Model m,HttpSession session){
        if (session.getAttribute("uName")!=null){
        m.addAttribute("admin", new ListUser());
        return ad.listUser();
    }
        else
            return null;
 }

}