package com.ct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.commercetools.api.models.product.Product;
import com.ct.service.CommerceToolsService;

@RestController
@RequestMapping("/api")
public class CommerceToolsController {

	@Autowired
	private CommerceToolsService commerceToolsService;

	@GetMapping("/products")
	public List<Product> products() {
		return commerceToolsService.getAllProducts();
	}

	@GetMapping("/products/{id}")
	public Product productById(@PathVariable String id) {
		return commerceToolsService.getProductById(id);
	}

	@PostMapping("/createProduct")
	public Product createProduct(@RequestParam String name, @RequestParam String slug) {
		return commerceToolsService.createProduct(name, slug);
	}

}
