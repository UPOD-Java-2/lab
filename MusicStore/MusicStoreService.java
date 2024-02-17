import java.util.Arrays;
import java.util.Objects;

public class MusicStoreService {

    private Product[] allProducts;


    private User[] users = new User[]{
            new User(1L, "Ahmet Gültekin"),
            new User(2L, "Asım Kılıç")
    };

    private Song song1 = new Song(1L, "Vazgeçtim", "2009", 3.40, "Müslüm Gürses");
    private Song song2 = new Song(2L, "Tastamam", "2009", 2.40, "Can Bonomo");

    private Game game = new Game(3L, "Knight Online", "2005", 9.90, 5.00);

    public void initializeProducts() {
        allProducts = new Product[]{song1, song2, game};
    }

    public Product searchProductById(Long id) {
        //allProducts
        Product searchedProduct = null;
        for (var product : allProducts) {
            if (product.getId() == id) {
                searchedProduct = product;
                break;
            }
        }
        return searchedProduct;
    }

    public Song searchSongOnProductByName(String songName) {
        Song searchedSong = null;
        for (var product : allProducts) {
            if (product.getName().equalsIgnoreCase(songName)) {
                if (product instanceof Song song) {
                    searchedSong = song;
                    //searchedSong = (Song) product;
                    break;
                }
            }
        }
        return searchedSong;
    }

    public void listUsers() {
        var userInfo = Arrays.toString(users);
        System.out.println(userInfo);
    }

    public User findUserById(Long userId) {
        User user = null;
        for (User u : users) {
            if (Objects.equals(u.getId(), userId)) {
                user = u;
                break;
            }
        }
        return user;
    }

    public void listBasketByUserId(Long userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("Kullanıcı bulunamadı");
            return;
        }
        user.getBasket().listBasket();
    }

    public void purchaseProduct(Long productId, Long userId) {
        Product product = searchProductById(productId);
        if (product == null) {
            System.out.println("Ürün bulunamadı.");
            return;
        }
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("Kullanıcı bulunamadı.");
            return;
        }
        user.getBasket().addProduct(product);
    }
}
