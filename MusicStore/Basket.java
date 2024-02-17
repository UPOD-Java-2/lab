import java.util.Arrays;

public class Basket {
    private Product[] products = new Product[DomainConstants.BASKET_OPENING_COUNT];

    private int itemCount = 0;
    private Double totalPrice = 0d;

    // ürün ekleme +
    public void addProduct(Product product) {
        if (itemCount == products.length - 1) {
            reInitializeArray();
        }
        products[itemCount] = product;
        itemCount++;
        totalPrice += product.getPrice();
    }

    public void listBasket() {
        if (products == null) { //guard block
            return;
        }
        System.out.println("-------- Basket List --------");
        for (int i = 0; i < itemCount; i++) {
            var actualProduct = products[i];
            String productInfo =
                    actualProduct.getClass().getName()
                    + " "
                    + actualProduct.getName()
                    + " "
                    + actualProduct.getPrice();
            System.out.println(productInfo);
        }
        System.out.printf("\tTotal price %.2f \n ", totalPrice);
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Basket{" +
               ", itemCount=" + itemCount +
               ", totalPrice=" + totalPrice +
               '}';
    }

    private void reInitializeArray() {
        //DomainConstants.BASKET_OPENING_COUNT
        //DomainConstants.BASKET_INCREASE_COUNT;
        Product[] tempProducts = new Product[products.length + DomainConstants.BASKET_INCREASE_COUNT];
//        for (int i = 0; i < products.length; i++) {
//            tempProducts[i] = products[i];
//        }
        System.arraycopy(products, 0, tempProducts,
                0, products.length);
        products = tempProducts;
    }
    // ürün çıkartma +
    // listeleme
}
