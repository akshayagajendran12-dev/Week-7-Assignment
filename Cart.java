public class Cart {
    private int[] prices;
    private int itemCount;
    private final String cartId;

    public Cart(String cartId, int maxSize) {
        if (cartId == null || cartId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Cart ID cannot be empty."
            );
        }

        if (maxSize <= 0) {
            throw new IllegalArgumentException(
                "Maximum size must be positive."
            );
        }

        this.cartId = cartId;
        this.prices = new int[maxSize];
        this.itemCount = 0;
    }

    public void addItem(int price) {
        if (price < 0) {
            throw new IllegalArgumentException(
                "Price cannot be negative."
            );
        }

        if (itemCount >= prices.length) {
            throw new IllegalStateException(
                "Cart is full."
            );
        }

        prices[itemCount] = price;
        itemCount++;
    }

    public int getTotal() {
        int total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}
