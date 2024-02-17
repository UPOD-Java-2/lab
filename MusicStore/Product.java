public abstract class Product {
    private Long id;

    private String name;

    private String releaseDate;

    private Double price;

    public Product(Long id, String name,
                   String releaseDate, Double price) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    // abstract void printInfo();
    final void printInfo() {
        System.out.println("printed");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
