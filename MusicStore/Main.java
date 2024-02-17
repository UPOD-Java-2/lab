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

                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 5 -> {

                }
                case 6 -> {

                }
                case 7 -> {

                }
                case 8 -> {

                }
                case 9 -> {

                }
                case -1 -> {
                    System.out.println("İyi günler");
                }
                default -> printMenu();
            }
        } while(choice != -1);

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
