public class Song extends Product {
    private String artist;

    public Song(Long id, String name,
                String releaseDate,
                Double price, String artist) {
        super(id, name, releaseDate, price);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

//    @Override
//    void printInfo() {
//        System.out.println("song");
//    }

}
