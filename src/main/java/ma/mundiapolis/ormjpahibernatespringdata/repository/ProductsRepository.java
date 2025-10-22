package ma.mundiapolis.ormjpahibernatespringdata.repository;

import ma.mundiapolis.ormjpahibernatespringdata.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductsRepository extends JpaRepository<Products,Long> {
    List<Products> findByNameContains(String mc);
    List<Products> findByPriceGreaterThan(double price);

    @Query("select  p from Products p where p.name like :x")
    List<Products> search(@Param("x") String mc);

    @Query("select  p from Products p where p.price>:x")
    List<Products> searchByPrice(@Param("x") double price);
}

