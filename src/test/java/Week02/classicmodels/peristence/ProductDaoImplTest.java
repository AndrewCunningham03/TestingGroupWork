package Week02.classicmodels.peristence;

import Week02.classicmodels.business.Product;
import org.junit.jupiter.api.Test;
import week03.classicmodels.business.Employee;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductDaoImplTest {

    @Test
    void getAllProducts() {
        ProductDaoImpl empDao = new ProductDaoImpl();
        List<Product> results = empDao.getAllProducts();

    }
}