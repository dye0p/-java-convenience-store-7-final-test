package store.model;

public class Purchase {

    private final String name;
    private int quantity;

    public Purchase(String name, int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.");
        }

        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
