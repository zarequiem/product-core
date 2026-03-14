package sn.isi.l3gl.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.isi.l3gl.core.entity.Product;
import sn.isi.l3gl.core.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    public Product updateQuantity(Long id, Integer quantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setQuantity(quantity);
        return productRepository.save(product);
    }

    public long countLowStockProducts() {
        return productRepository.countByQuantityLessThanEqual(5);
    }

}