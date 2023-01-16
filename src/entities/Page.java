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

    /**
     *
     */
    public void resetMovie() {
        movieList = new ArrayList<>();
        currentMovie = null;
    }

    /**
     *
     */
    public void resetUser() {
        currentUser = null;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     *
     * @param currentUser
     */
    public void setCurrentUser(final User currentUser) {
        this.currentUser = currentUser;
    }

    /**
     *
     * @return
     */
    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    /**
     *
     * @param movieList
     */
    public void setMovieList(final ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    /**
     *
     * @return
     */
    public Movie getCurrentMovie() {
        return currentMovie;
    }

    /**
     *
     * @param currentMovie
     */
    public void setCurrentMovie(final Movie currentMovie) {
        this.currentMovie = currentMovie;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Page{"
                + "name='" + name + '\''
                + ", currentUser=" + currentUser
                + ", movieList=" + movieList
                + ", currentMovie=" + currentMovie
                + '}';
    }
}
