package ma.mundiapolis.ormjpahibernatespringdata;

import ma.mundiapolis.ormjpahibernatespringdata.entities.Products;
import ma.mundiapolis.ormjpahibernatespringdata.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
    public class OrmJpaHibernateSpringDataApplication implements CommandLineRunner {
    @Autowired
    private ProductsRepository productsRepository;


    public static void main(String[] args) {

        SpringApplication.run(OrmJpaHibernateSpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       productsRepository.save(new Products(null,"Computer",13000,00));
        productsRepository.save(new Products(null,"Cle USB",1000,00));
        productsRepository.save(new Products(null,"Smart phone",10000,00));
        List<Products> products = productsRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });
        Products products1 = productsRepository.findById(Long.valueOf(1)).get();
        System.out.println("###############");
        System.out.println(products1.getId());
        System.out.println(products1.getName());
        System.out.println(products1.getQuantity());
        System.out.println("###############");
        System.out.println("-----------------");
        List<Products> productsList = productsRepository.findByNameContains("C");
        productsList.forEach(p->{
            System.out.println(p);
        });
        System.out.println("-----------------");
        List<Products> productsList2 = productsRepository.search("%C%");
        productsList2.forEach(p->{
            System.out.println(p);
        });
        System.out.println("-----------------");
        List<Products> productsList3 = productsRepository.searchByPrice(3000);
        productsList3.forEach(p->{
            System.out.println(p);
        });


    }
}
