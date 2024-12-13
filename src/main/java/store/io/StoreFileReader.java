package store.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import store.model.Product;
import store.model.Products;
import store.model.Promotion;
import store.model.Promotions;

public class StoreFileReader {

    public Products productsReader() {

        File file = new File("src/main/resources/products.md");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            line = br.readLine(); // 한줄 건너띄기

            List<Product> products = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");

                String name = split[0];
                int price = Integer.parseInt(split[1]);
                int quantity = Integer.parseInt(split[2]);
                String promotion = split[3];

                Product product = new Product(name, price, quantity, promotion);

                products.add(product);
            }

            return new Products(products);

        } catch (IOException exception) {
            throw new IllegalArgumentException("파일이 존재하지 않습니다.");
        }
    }

    public Promotions promotionsReader() {

        File file = new File("src/main/resources/promotions.md");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            line = br.readLine(); // 한줄 건너띄기

            List<Promotion> promotions = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");

                String name = split[0];
                int buy = Integer.parseInt(split[1]);
                int get = Integer.parseInt(split[2]);
                String startDate = split[3];
                String endDate = split[4];

                Promotion promotion = new Promotion(name, buy, get, startDate, endDate);
                promotions.add(promotion);
            }

            return new Promotions(promotions);

        } catch (IOException exception) {
            throw new IllegalArgumentException("파일이 존재하지 않습니다.");
        }
    }

}
