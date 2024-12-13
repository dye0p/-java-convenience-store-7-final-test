package store.view;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import store.model.Purchase;

public class InputConverter {

    public static List<Purchase> convertPurchaseItems(String inputPurchaseItems) {

        if (inputPurchaseItems.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.");
        }

        List<String> split = split(inputPurchaseItems);

        List<Purchase> purchases = new ArrayList<>();
        for (String item : split) {

            String[] nameAndQuantity = splitNameAndQuantity(item);

            if (nameAndQuantity.length != 2) {
                throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.");
            }

            String name = nameAndQuantity[0];
            int quantity = parseQuantity(nameAndQuantity[1]);

            Purchase purchase = new Purchase(name, quantity);
            purchases.add(purchase);
        }

        return purchases;
    }

    private static List<String> split(String inputPurchaseItems) {
        try {
            String[] split = inputPurchaseItems.trim().split(",");

            List<String> purchaseItems = new ArrayList<>();
            for (String item : split) {
                String replace = item.replace("[", "").replace("]", "");
                purchaseItems.add(replace.trim());
            }

            return purchaseItems;

        } catch (PatternSyntaxException exception) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.");
        }
    }

    private static int parseQuantity(String nameAndQuantity) {
        try {
            return Integer.parseInt(nameAndQuantity);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.");
        }
    }

    private static String[] splitNameAndQuantity(String item) {
        try {
            return item.trim().split("-");
        } catch (PatternSyntaxException exception) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.");
        }
    }
}
