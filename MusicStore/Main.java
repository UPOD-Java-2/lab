import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        MusicStoreService service = new MusicStoreService();
        service.initializeProducts();
        printMenu();
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
                    System.out.println("İyi günler");
                }
                default -> printMenu();
            }
        } while (choice != -1);

    }

    private static void printMenu() {
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
