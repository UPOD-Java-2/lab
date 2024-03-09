import java.util.Arrays;
import java.util.Objects;

public class MusicStoreService {

    private Product[] allProducts;


    private User[] users = new User[]{
            new User(1L, "Ahmet Gültekin", "ahmet", "ahmet123"),
            new User(2L, "Asım Kılıç", "asim", "asim123")
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

    public void searchProductByName(String searchName) {
        for (Product product : allProducts) {
            //product.getName().contains()
            //if (product.getName().equalsIgnoreCase(searchName)) {
            if (product.getName().contains(searchName)) {
                System.out.println(product);
                return;
            }
        }
        System.out.println(searchName + " isimli ürün bulunamadı");
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

    public Game searchGameOnProductByName(String gameName) {
        Game searchedGame = null;
        for (var product : allProducts) {
            if (product.getName().equalsIgnoreCase(gameName)) {
                if (product instanceof Game game) {
                    searchedGame = game;
                    break;
                }
            }
        }
        return searchedGame;
    }

    public void searchGameByNameAndPrint(String gameName) {
        var game = searchGameOnProductByName(gameName);
        if (game == null) {
            System.out.println("Oyun bulunamadı");
            return;
        }
        System.out.println(game);
    }

    public void searchSongByNameAndPrint(String songName) {
        var song = searchSongOnProductByName(songName);
        if (song == null) {
            System.out.println("Şarkı bulunamadı.");
            return;
        }
        System.out.println(song);

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
        Basket userBasket = user.getBasket();
        userBasket.addProduct(product);
        //user.getBasket().addProduct(product);
    }

    public void listProducts() {
        for (Product product : allProducts) {
            System.out.println(product);
        }
    }

    public void listSongs() {
        for (Product product : allProducts) {
            if (product instanceof Song song) {
                System.out.println(song);
            }
        }
    }

    public void listGames() {
        for (Product product : allProducts) {
            if (product instanceof Game game) {
                System.out.println(game);
            }
        }
    }
}
