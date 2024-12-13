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

    public void isContain(String name) {
        int matchCount = 0;
        for (Product product : products) {
            if (product.getName().equals(name)) {
                matchCount++;
            }
        }

        if (matchCount == 0) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 상품입니다. 다시 입력해 주세요.");
        }
    }

    public void exceedQuantity(String name, int quantity) {
        //재고 초과
        //해당 상품의 모든 재고를 가져온다.
        int allQuantity = 0;
        for (Product product : products) {
            if (product.getName().equals(name)) {
                allQuantity += product.getQuantity();
            }
        }

        if (allQuantity < quantity) {
            throw new IllegalArgumentException("[ERROR] 재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요.");
        }
    }
}
