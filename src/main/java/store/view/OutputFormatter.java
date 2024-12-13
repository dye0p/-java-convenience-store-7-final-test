package store.view;

import java.util.StringJoiner;
import store.model.Product;
import store.model.Products;

public class OutputFormatter {

    private static final String NEXT_LINE = System.lineSeparator();

    public static String formatProducts(Products products) {
        StringJoiner sj = new StringJoiner(NEXT_LINE);

        for (Product product : products.getProducts()) {

            //해당 상품의 프로모션이 null인것을 찾는다.
            Product nonPromotionBy = products.findNonPromotionBy(product);

            String promotion = product.getPromotion();
            if (product.getPromotion().equals("null")) {
                promotion = "";
            }

            String format = String.format("- %s %,d원 %s개 %s",
                    product.getName(),
                    product.getPrice(),
                    product.getQuantity(),
                    promotion);

            sj.add(format);

            if (nonPromotionBy == null) {
                String nonFormat = String.format("- %s %,d원 %s %s",
                        product.getName(),
                        product.getPrice(),
                        "재고 없음",
                        "");

                sj.add(nonFormat);
            }
        }

        return sj.toString();
    }
}
