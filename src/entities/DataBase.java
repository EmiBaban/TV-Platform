package entities;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<User> users;
    private List<Movie> movies;
    private List<ActionInput> actions;

    private static DataBase instance = null;

    private DataBase() {
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    /**
     *
     * @return
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     *
     * @param users
     */
    public void setUsers(final List<User> users) {
        this.users = users;
    }

    /**
     *
     * @return
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     *
     * @param movies
     */
    public void setMovies(final List<Movie> movies) {
        this.movies = movies;
    }

    /**
     *
     * @return
     */
    public List<ActionInput> getActions() {
        return actions;
    }

    /**
     *
     * @param actions
     */
    public void setActions(final List<ActionInput> actions) {
        this.actions = actions;
    }

    /**
     *
     * @param user
     */
    public void addUser(final User user) {
        this.users.add(user);
    }

    /**
     *
     * @param country
     * @return
     */
    public List<Movie> unbannedMovies(final String country) {
        List<Movie> unbanned = new ArrayList<>();
        for (Movie movie : movies) {
            if (!movie.getCountriesBanned().contains(country)) {
                unbanned.add(movie);
            }
        }
        return unbanned;
    }

    /**
     *
     * @param deletedMovie
     */
    public void deleteMovie(final String deletedMovie) {
        movies.removeIf(m -> m.getName().equals(deletedMovie));
    }

    /**
     *
     * @param movie
     */
    public void addMovie(final Movie movie) {
        movies.add(movie);
    }
}
