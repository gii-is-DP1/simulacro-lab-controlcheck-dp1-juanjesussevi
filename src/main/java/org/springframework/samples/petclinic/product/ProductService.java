package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
@Service

public class ProductService {
	private ProductRepository productRepository;
	 @Autowired
	    public ProductService(ProductRepository productRepository) {
	    	this.productRepository=productRepository;}
	public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
    	return productRepository.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return productRepository.findTypeByName(typeName);
    }

    public Product save(Product p){
        return productRepository.save(p);       
    }



	public List<ProductType> findAllProductTypes() {
		// TODO Auto-generated method stub
		return productRepository.findAllProductTypes();
	}
}