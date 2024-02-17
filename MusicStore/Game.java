public class Game extends Product {
    private Double duration;

    public Game(Long id, String name,
                String releaseDate,
                Double price, Double duration) {
        super(id, name, releaseDate, price);
        this.duration = duration;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

//    @Override
//    void printInfo() {
//        System.out.println("game");
//    }

//    @Override
//    public void setPrice(Double price) {
//        System.out.println("price setlendi");
//        super.setPrice(price);
//    }
}
