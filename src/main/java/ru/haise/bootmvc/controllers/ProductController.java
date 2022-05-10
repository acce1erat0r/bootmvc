package ru.haise.bootmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.haise.bootmvc.entities.Product;
import ru.haise.bootmvc.services.ProductService;

import java.math.BigDecimal;
import java.util.Optional;


@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String indexPage(Model model,
                            @RequestParam(name = "title-filter", required = false) Optional<String> titleFilter,
                            @RequestParam(name = "min", required = false)Optional<BigDecimal> min,
                            @RequestParam(name = "max", required = false)Optional<BigDecimal> max) {

        model.addAttribute("products", productService.getByParams(titleFilter, min, max));
        return "product_views/index";
    }

    //METHOD: UPDATE
    @GetMapping("/{id}")
    public String editPage(@PathVariable(value = "id") Long id,
                           Model model) {
        model.addAttribute("product", productService.getById(id));
        return "product_views/product_form";

    }

    @PostMapping("/product_update")
    public String updateProduct(Product product,
                                Model model) {
        productService.addOrUpdate(product);
        return "redirect:/product";
    }

    //METHOD: ADD
    @GetMapping("/new")
    public String newProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product_views/product_form"; // незаполненная
    }

    //METHOD: DELETE
    @GetMapping("/delete/{id}")
    public String removeProduct(@PathVariable(value = "id") Long id) {
        productService.remove(id);
        return "redirect:/product"; // незаполненная
    }
}
