import java.util.Random;
import java.util.Scanner;

public class Main {
    static MusicStoreService service = new MusicStoreService();
    static UserService userService = new UserService();
    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();

    private static int exitCode = 1;

    public static void main(String[] args) throws Exception {
        System.out.println("#### HOŞGELDİNİZ ###");
        service.initializeProducts();
        while (exitCode > 0) {
            writeMenu();
        }
        System.out.println("İyi günler.");
    }

    public static void writeMenu() throws Exception {
        if (userService.isLoggedIn()) {
            int choice = 0;
            printLoggedInMenu();
            do {
                System.out.print("Seçiminiz: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("----------------------------------");
                        service.listUsers();
                        System.out.println("----------------------------------");
                    }
                    case 2 -> {
                        System.out.println("----------------------------------");
                        service.listProducts();
                        System.out.println("----------------------------------");
                    }
                    case 3 -> {
                        System.out.println("----------------------------------");
                        service.listSongs();
                        System.out.println("----------------------------------");
                    }
                    case 4 -> {
                        System.out.println("----------------------------------");
                        service.listGames();
                        System.out.println("----------------------------------");
                    }
                    case 5 -> {
                        System.out.println("----------------------------------");
                        System.out.println("Ürün id'si giriniz: ");
                        Long productId = sc.nextLong();
                        System.out.println("Kullanıcı id'sini giriniz: ");
                        Long userId = sc.nextLong();
                        service.purchaseProduct(productId, userId);
                        service.listBasketByUserId(userId);
                        System.out.println("----------------------------------");
                    }
                    case 6 -> {
                        System.out.println("----------------------------------");
                        sc.nextLine();
                        System.out.println("Aranılacak ürün adını giriniz: ");

                        String productName = sc.nextLine();
                        service.searchProductByName(productName);
                        System.out.println("----------------------------------");
                    }
                    case 7 -> {
                        System.out.println("----------------------------------");
                        sc.nextLine();
                        System.out.println("Aranılacak şarkı adını giriniz: ");
                        String songName = sc.nextLine();
                        service.searchSongByNameAndPrint(songName);
                        System.out.println("----------------------------------");
                    }
                    case 8 -> {
                        System.out.println("----------------------------------");
                        sc.nextLine();
                        System.out.println("Aranılacak oyun adını giriniz: ");
                        String gameName = sc.nextLine();
                        service.searchGameByNameAndPrint(gameName);
                        System.out.println("----------------------------------");

                    }
                    case 9 -> {
                        System.out.println("----------------------------------");
                        System.out.println("Kullanıcı id'si giriniz: ");
                        Long userId = sc.nextLong();
                        service.listBasketByUserId(userId);
                        System.out.println("----------------------------------");


                    }
                    case -1 -> {
                        //System.out.println("İyi günler");
                        userService.logout();
                        Main.exitCode = 1;
                    }
                    default -> printLoggedInMenu();
                }
            } while (choice != -1);
        } else {
            System.out.println("###############");
            System.out.println("# 1 - Giriş yap");
            System.out.println("# 2 - Üye ol");
            System.out.println("# -1 - Sistemden çıkış yap");
            System.out.println("###############");
            System.out.println("Seçiminiz: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    sc.nextLine();
                    System.out.println("Kullanıcı adınız: ");
                    String username = sc.nextLine();
                    System.out.println("Şifreniz: ");
                    String password = sc.nextLine();
                    userService.login(username, password);
                }
                case 2 -> {

                    System.out.println("Kullanıcı adınız: ");

                    String username = sc.next();
                    while (userService.isUserAlreadyExist(username)) {
                        System.out.println("Kullanıcı adı alınmış başka bir kullanıcı adı seçiniz.");
                        username = sc.next();
                    }
                    sc.nextLine();
                    System.out.println("Adınız soyadınız: "); //10:01
                    String userFullname = sc.nextLine();
                    System.out.println("Şifreniz: ");
                    String password = sc.nextLine();

                    User user = new User(rnd.nextLong(), userFullname, username, password);
                    userService.addUser(user);
                }
                case -1 -> Main.exitCode = -1;

                default -> System.out.println("Hata giriş yaptınız");

            }
        }
    }

    public static void main2(String[] args) {

        int choice = 0;

        service.initializeProducts();
        printLoggedInMenu();
        do {
            System.out.print("Seçiminiz: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("----------------------------------");
                    service.listUsers();
                    System.out.println("----------------------------------");
                }
                case 2 -> {
                    System.out.println("----------------------------------");
                    service.listProducts();
                    System.out.println("----------------------------------");
                }
                case 3 -> {
                    System.out.println("----------------------------------");
                    service.listSongs();
                    System.out.println("----------------------------------");
                }
                case 4 -> {
                    System.out.println("----------------------------------");
                    service.listGames();
                    System.out.println("----------------------------------");
                }
                case 5 -> {
                    System.out.println("----------------------------------");
                    System.out.println("Ürün id'si giriniz: ");
                    Long productId = sc.nextLong();
                    System.out.println("Kullanıcı id'sini giriniz: ");
                    Long userId = sc.nextLong();
                    service.purchaseProduct(productId, userId);
                    service.listBasketByUserId(userId);
                    System.out.println("----------------------------------");
                }
                case 6 -> {
                    System.out.println("----------------------------------");
                    sc.nextLine();
                    System.out.println("Aranılacak ürün adını giriniz: ");

                    String productName = sc.nextLine();
                    service.searchProductByName(productName);
                    System.out.println("----------------------------------");
                }
                case 7 -> {
                    System.out.println("----------------------------------");
                    sc.nextLine();
                    System.out.println("Aranılacak şarkı adını giriniz: ");
                    String songName = sc.nextLine();
                    service.searchSongByNameAndPrint(songName);
                    System.out.println("----------------------------------");
                }
                case 8 -> {
                    System.out.println("----------------------------------");
                    sc.nextLine();
                    System.out.println("Aranılacak oyun adını giriniz: ");
                    String gameName = sc.nextLine();
                    service.searchGameByNameAndPrint(gameName);
                    System.out.println("----------------------------------");

                }
                case 9 -> {
                    System.out.println("----------------------------------");
                    System.out.println("Kullanıcı id'si giriniz: ");
                    Long userId = sc.nextLong();
                    service.listBasketByUserId(userId);
                    System.out.println("----------------------------------");


                }
                case -1 -> {
                    //System.out.println("İyi günler");
                    Main.exitCode = 1;
                }
                default -> printLoggedInMenu();
            }
        } while (choice != -1);

    }

    private static void printLoggedInMenu() {
        System.out.println("### Menu ###");
        System.out.println("1 : Kullanıcıları listele");
        System.out.println("2 : Ürünleri listele");
        System.out.println("3 : Şarkıları listele");
        System.out.println("4 : Oyunları listele");
        System.out.println("5 : Ürün satın al");
        System.out.println("6 : Ürün ara");
        System.out.println("7 : Şarkı ara");
        System.out.println("8 : Oyun ara");
        System.out.println("9 : Kullanıcı sepeti listele");
        System.out.println("-1 : Çıkış \n\n");
    }
}
