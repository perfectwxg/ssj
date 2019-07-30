package com.xianguang.controller;

import com.xianguang.domian.Product;
import com.xianguang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getProduct(){
        return productService.getAll();
    }
}
