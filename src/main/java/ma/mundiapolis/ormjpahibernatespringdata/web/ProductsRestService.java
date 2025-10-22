package ma.mundiapolis.ormjpahibernatespringdata.web;

import ma.mundiapolis.ormjpahibernatespringdata.entities.Products;
import ma.mundiapolis.ormjpahibernatespringdata.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController

public class ProductsRestService {
    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/products")
    public List<Products> products() {
        return productsRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Products findProducts(@PathVariable Long id) {
        Products products = productsRepository.findById(id).orElse(null);
        return products;

    }
}
