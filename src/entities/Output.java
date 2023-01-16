package entities;

import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;

public class Output {
    private String error = null;
    private ArrayList<Movie> currentMoviesList = new ArrayList<>();
    private User currentUser;

    public Output() {
        this.error = "Error";
        this.currentMoviesList = new ArrayList<>();
        this.currentUser = null;
    }

    public Output(final ArrayList<Movie> currentMoviesList, final User currentUser) {
        for (Movie movie : currentMoviesList) {
            this.currentMoviesList.add(new Movie(movie));
        }
        this.currentUser = new User(currentUser);
    }

    /**
     *
     * @param node
     */
    public void addInJsonArrayNode(final ArrayNode node) {
        node.addObject().put("error", error)
                .putPOJO("currentMoviesList", currentMoviesList)
                .putPOJO("currentUser", currentUser);
    }

    /**
     *
     * @return
     */
    public String getError() {
        return error;
    }

    /**
     *
     * @param error
     */
    public void setError(final String error) {
        this.error = error;
    }

    /**
     *
     * @return
     */
    public ArrayList<Movie> getCurrentMoviesList() {
        return currentMoviesList;
    }

    /**
     *
     * @param currentMoviesList
     */
    public void setCurrentMoviesList(final ArrayList<Movie> currentMoviesList) {
        this.currentMoviesList = currentMoviesList;
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
}
