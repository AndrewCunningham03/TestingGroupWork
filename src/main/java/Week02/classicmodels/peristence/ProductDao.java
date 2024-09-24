package Week02.classicmodels.peristence;

import Week02.classicmodels.business.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getAllProducts();
}
