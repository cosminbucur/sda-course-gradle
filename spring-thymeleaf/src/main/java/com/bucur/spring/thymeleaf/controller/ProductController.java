package com.bucur.spring.thymeleaf.controller;

import com.bucur.spring.thymeleaf.model.Product;
import com.bucur.spring.thymeleaf.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String viewProductsPage(Model model) {
        logger.info("List all Products...");

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String showNewProductPage(Model model) {
        logger.info("Show new product page...");

        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") @Valid Product product) {
        logger.info("Save new product...");
        productService.save(product);
        return "redirect:/products";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("edit_product");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable(name = "id") int id) {
        productService.delete(id);
        return "redirect:/products";
    }
}
