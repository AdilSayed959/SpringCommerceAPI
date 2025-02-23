package com.ct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.product.Product;
import com.commercetools.api.models.product.ProductDraft;
import com.commercetools.api.models.product.ProductDraftBuilder;
import com.commercetools.api.models.product.ProductPagedQueryResponse;
import com.commercetools.api.models.product_type.ProductTypeResourceIdentifierBuilder;

@Service
public class CommerceToolsService {

	@Autowired
	private ProjectApiRoot apiRoot;
	
	//Retrieves all products from Commerce tools
	public List<Product> getAllProducts() {
		try {
			ProductPagedQueryResponse pagedResponse = apiRoot
													  .products()
													  .get()
													  .withLimit(10)
													  .executeBlocking()
													  .getBody();
			return pagedResponse.getResults();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	//Retrieves a product by ID
	public Product getProductById(String id) {
		try {
			Product product = apiRoot
							  .products()
							  .withId(id)
							  .get()
							  .executeBlocking()
							  .getBody();
			return product;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	//Creates a product in Commerce tools
	public Product createProduct(String name, String slug) {
		try {
			ProductDraft productDraft = ProductDraftBuilder
										.of()
										.name(LocalizedString.ofEnglish(name))
										.slug(LocalizedString.ofEnglish(slug)).productType(ProductTypeResourceIdentifierBuilder.of()
										.id("").build())
										.build();
			return apiRoot
					.products()
					.post(productDraft)
					.executeBlocking()
					.getBody();
		} catch (Exception ex) {
			throw ex;
		}
	}
}
