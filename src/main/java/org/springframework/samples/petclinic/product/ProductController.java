package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    ProductService productService;

    @ModelAttribute("productTypes")
    public List<ProductType> populateProductTypes() {
        return this.productService.findAllProductTypes();
    }

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/create")
    public ModelAndView createProduct() {
        ModelAndView mav = new ModelAndView("products/createOrUpdateProductForm");
        mav.addObject("product", new Product());
        return mav;
    }

    @PostMapping(value = "/product/create")
    public ModelAndView processCreationForm(@Valid Product product, BindingResult result) {
        ModelAndView mav;
        if (result.hasErrors()) {
            mav=new ModelAndView("products/createOrUpdateProductForm");
            mav.addObject("product", product);
            mav.addObject("types", productService.findAllProductTypes());
        }
        else {
            this.productService.save(product);
            mav = new ModelAndView("welcome");
        }
        return mav;
    }

}
