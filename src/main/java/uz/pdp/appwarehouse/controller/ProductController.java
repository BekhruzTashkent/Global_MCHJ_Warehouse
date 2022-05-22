package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appwarehouse.payload.ProductDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.ProductService;

@RestController
@RequestMapping("/product")


public class ProductController {
@Autowired
ProductService productService;
    @PostMapping
    public Result addProduct(@RequestBody ProductDto productDto){

        Result result = productService.addProduct(productDto);
        return result;

    }

}
