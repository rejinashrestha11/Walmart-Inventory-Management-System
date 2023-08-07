/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DAO.CustomerDAO;
import com.mycompany.command.AddCustomer;
import com.mycompany.command.DeleteCustomer;
import com.mycompany.command.ListCustomer;
import com.mycompany.domain.Customer;
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
public class CustomerController {
    @Autowired
    CustomerDAO cs;
    
    @RequestMapping("/addcustomer")
    public String AddCustomer(Model m,HttpSession session){
        if (session.getAttribute("uName")!=null){
        m.addAttribute("customer", new AddCustomer());
        return "addcustomer";
    }
        else
            return "redirect:login";
 }
    @RequestMapping(value="/processCustomer", method = RequestMethod.POST)
    public String ProcessCustomer(@ModelAttribute ("customer") AddCustomer ac, HttpSession session){
        if(session.getAttribute("uName")!= null){
            if(cs.addCustomer(ac.getCustomerId(), ac.getCustomerName(),ac.getAddress(),ac.getContactNo(),ac.getPAN_no(),ac.getBillNo())){
                session.setAttribute("message", "New customer added sucessfully!!");
                return "redirect: addcustomer";
        }else{
            session.setAttribute("message", "Customer Already Exits!!");
                return "redirect: addcustomer";
        }
           
            
    }
        else
            return "redirect: login";
    }    
    @RequestMapping("/deletecustomer")
    public String deleteCustomer(Model m,HttpSession session){
        if (session.getAttribute("uName")!=null){
        m.addAttribute("customer", new DeleteCustomer());
        return "deletecustomer";
    }
        else
            return "redirect:login";
 }
    
    @RequestMapping(value="/processdeletecustomer", method = RequestMethod.POST)
    public String ProcessDeleteCustomer(@ModelAttribute ("customer") DeleteCustomer dc, HttpSession session){
        if(session.getAttribute("uName")!= null){
            if(cs.deleteCustomer(dc.getCustomerId())){
                session.setAttribute("message", "Customer deleted sucessfully!!");
                return "redirect: deletecustomer";
        }else{
            session.setAttribute("message", "Customer Doesn't Exits!!");
                return "redirect: deletecustomer";
        }
      }
        else
            return "redirect: login";
    }
    @RequestMapping(value="/listcustomer", method = RequestMethod.GET)
    
    public ArrayList<Customer> listCustomer(Model m,HttpSession session){
        if (session.getAttribute("uName")!=null){
        m.addAttribute("customer", new ListCustomer());
        return cs.listCustomer();
    }
        else
            return null;
 }
    
}
