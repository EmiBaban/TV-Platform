package entities;

import java.util.ArrayList;
import java.util.List;

public class Contains {
    private List<String> actors;
    private List<String> genre;

    public Contains() {
    }

    /**
     *
     * @return
     */
    public List<String> getActors() {
        return actors;
    }

    /**
     *
     * @param actors
     */
    public void setActors(final List<String> actors) {
        this.actors = actors;
    }

    /**
     *
     * @return
     */
    public List<String> getGenre() {
        return genre;
    }

    /**
     *
     * @param genre
     */
    public void setGenre(final List<String> genre) {
        this.genre = genre;
    }


    public ArrayList<Movie> containsActor(List<Movie> movies ){
        ArrayList<Movie> containList = new ArrayList<>();

        for (Movie movie : movies) {
            for (String actor : movie.getActors()) {
                if (actors.contains(actor)) {
                    containList.add(movie);
                }
            }
        }
        return containList;
    }

    public ArrayList<Movie> containsGenre(List<Movie> movies) {
        ArrayList<Movie> containList = new ArrayList<>();

        for (Movie movie : movies) {
            for (String gen : movie.getGenres()) {
                if (genre.contains(gen)) {
                    containList.add(movie);
                }
            }
        }
        return containList;
    }
}
