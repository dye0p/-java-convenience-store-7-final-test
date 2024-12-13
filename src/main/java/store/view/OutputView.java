package store.view;

import store.model.Products;

public class OutputView {

    private static final String NEXT_LINE = System.lineSeparator();

    public void printProducts(Products products) {
        System.out.println("안녕하세요. W편의점입니다.");
        System.out.println("현재 보유하고 있는 상품입니다.");

        String format = OutputFormatter.formatProducts(products);

        System.out.println(NEXT_LINE + format);
    }
}
