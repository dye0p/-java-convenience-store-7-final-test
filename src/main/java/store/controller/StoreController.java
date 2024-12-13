package store.controller;

import java.util.List;
import java.util.function.Supplier;
import store.io.StoreFileReader;
import store.model.Products;
import store.model.Promotions;
import store.model.Purchase;
import store.model.Purchases;
import store.view.InputView;
import store.view.OutputView;

public class StoreController {

    private final InputView inputView;
    private final OutputView outputView;

    public StoreController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

        StoreFileReader storeFileReader = new StoreFileReader();
        Products products = storeFileReader.productsReader();
        Promotions promotions = storeFileReader.promotionsReader();

        //상품 출력
        outputView.printProducts(products);

        //구매할 상품 입력
        Purchases purchases = tryReadPurchaseItems(products);

    }

    private Purchases tryReadPurchaseItems(Products products) {
        return requestRead(() -> {
            List<Purchase> purchases = inputView.readPurchaseItem();

            for (Purchase purchase : purchases) {
                String name = purchase.getName();
                products.isContain(name);
                int quantity = purchase.getQuantity();
                products.exceedQuantity(name, quantity);
            }
            return new Purchases(purchases);
        });
    }


    private <T> T requestRead(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
