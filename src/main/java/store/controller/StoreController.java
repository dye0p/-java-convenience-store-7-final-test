package store.controller;

import store.io.StoreFileReader;
import store.model.Products;
import store.model.Promotions;
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

    }
}
