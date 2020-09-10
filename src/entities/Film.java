package entities;

public final class Film {

    private final String name;
    private final String genre;
    private final String director;
    private final Integer year;
    private final Rating rating;

    public Film(String name, String genre, String director, int year, Rating rating) {
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }

    public String getName() {
        return name;
    }

    public Rating getRating() {
        return rating;
    }

}
