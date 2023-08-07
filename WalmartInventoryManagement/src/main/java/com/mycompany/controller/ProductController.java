/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DAO.ProductDAO;
import com.mycompany.command.AddProduct;
import com.mycompany.command.ListProduct;
import com.mycompany.command.RevokeProduct;
import com.mycompany.domain.Product;
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
public class ProductController {
        @Autowired
    ProductDAO pd;
    
    @RequestMapping("/addproduct")
    public String AddProduct(Model m,HttpSession session){
        if (session.getAttribute("uName")!=null){
        m.addAttribute("product", new AddProduct());
        return "addproduct";
    }
        else
            return "redirect:login";
 }
    @RequestMapping(value="/processProduct", method = RequestMethod.POST)
    public String ProcessProduct(@ModelAttribute ("product") AddProduct ap, HttpSession session){
        if(session.getAttribute("uName")!= null){
            if(pd.addProduct(ap.getProductId(),ap.getProductName(),ap.getQuantity(),ap.getSellingPrice(),ap.getCostPrice())){
                session.setAttribute("message", "New product added sucessfully!!");
                return "redirect: addproduct";
        }else{
            session.setAttribute("message", "Error!!");
                return "redirect: addproduct";
        }
           
            
    }
        else
            return "redirect: login";
    }
    
    @RequestMapping(value="/listproduct", method = RequestMethod.GET)
    
    public ArrayList<Product> listProduct(Model m,HttpSession session){
        if (session.getAttribute("uName")!=null){
        m.addAttribute("product", new ListProduct());
        return pd.listProduct();
    }
        else
            return null;
 }

    @RequestMapping("/revokeproduct")
    public String RevokeProduct(Model m,HttpSession session){
        if (session.getAttribute("uName")!=null){
        m.addAttribute("product", new RevokeProduct());
        return "revokeproduct";
    }
        else
            return "redirect:login";
 }
    
    @RequestMapping(value="/processrevoke", method = RequestMethod.POST)
    public String ProcessRevoke(@ModelAttribute ("product") RevokeProduct rp, HttpSession session){
        if(session.getAttribute("uName")!= null){
            if(pd.revokeProduct(rp.getProductId(),rp.getQuantity())){
                session.setAttribute("message", "Product is revoked successfully!!");
                return "redirect: revokeproduct";
        }else{
            session.setAttribute("message", "There was an error!!");
                return "redirect: revokeproduct";
        }
           
            
    }
        else
            return "redirect: login";
    }
}
