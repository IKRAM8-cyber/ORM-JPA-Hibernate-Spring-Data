package ma.mundiapolis.ormjpahibernatespringdata.repository;

import ma.mundiapolis.ormjpahibernatespringdata.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProductsRepository extends JpaRepository<Products,Long> {
}
