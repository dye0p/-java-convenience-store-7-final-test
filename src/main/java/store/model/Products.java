package store.model;

import java.util.List;

public class Products {

    private final List<Product> products;

    public Products(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product findNonPromotionBy(Product product) {
        //상품 목록중 해당 상품의 프로모션이 null 인것을 찾는다.
        for (Product productUnit : products) {
            if (productUnit.getName().equals(product.getName()) && productUnit.getPromotion().equals("null")) {
                return product;
            }
        }
        return null;
    }
}
