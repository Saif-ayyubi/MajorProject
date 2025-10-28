package in.ashokit.repo;

import in.ashokit.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long> {

    public List<Product> findByCategoryCategoryId(Long categoryId);

    public List<Product> findByProductNameContainingIgnoreCase(String productName);//select * from product where name like %name% ==> it will just check matching characters

    //public List<Product> findByName(String productName);//select * from product where name= ? ==> match the exact name

}
