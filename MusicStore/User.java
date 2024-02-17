public class User {
    private Long id;
    private String fullName;

    private final Basket basket;

    public User(Long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.basket = new Basket();
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", fullName='" + fullName + '\'' +
               ", basket=" + basket +
               '}';
    }
}
