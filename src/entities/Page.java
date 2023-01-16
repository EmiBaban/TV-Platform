package entities;

import java.util.ArrayList;

public class Page {
    private String name;
    private User currentUser;
    private ArrayList<Movie> movieList = new ArrayList<>();
    private Movie currentMovie;

    public Page(final String name) {
        this.name = name;
    }

    public Page(final Page page) {
        this.name = page.getName();
        this.currentUser = page.getCurrentUser();
        this.movieList = page.getMovieList();
        this.currentMovie = page.getCurrentMovie();
    }

    public void resetMovie() {
        movieList = new ArrayList<>();
        currentMovie = null;
    }

    public void resetUser() {
        currentUser = null;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(final User currentUser) {
        this.currentUser = currentUser;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(final ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    public Movie getCurrentMovie() {
        return currentMovie;
    }

    public void setCurrentMovie(final Movie currentMovie) {
        this.currentMovie = currentMovie;
    }

    @Override
    public String toString() {
        return "Page{" +
                "name='" + name + '\'' +
                ", currentUser=" + currentUser +
                ", movieList=" + movieList +
                ", currentMovie=" + currentMovie +
                '}';
    }
}
