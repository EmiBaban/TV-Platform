package actions;

import com.fasterxml.jackson.databind.node.ArrayNode;
import entities.Movie;
import entities.Output;
import entities.Page;

import java.util.ArrayList;

public class ActionWatch extends Action {

    public ActionWatch(final String type, final String page) {
        super(type, page);
    }

    /**
     *
     * @param node
     * @param page
     */
    public void watch(final ArrayNode node, final Page page) {
        if (page.getName().equals("see details")) {
            Movie currentMovie = page.getMovieList().stream()
                    .filter((x) -> x.getName().equals(page.getCurrentMovie().getName()))
                    .findFirst()
                    .orElse(null);
            if (page.getCurrentUser().getPurchasedMovies().stream()
                    .noneMatch((x) -> x.getName().equals(page.getCurrentMovie().getName()))) {
                Output output = new Output();
                output.addInJsonArrayNode(node);
            } else {
                if (page.getCurrentUser().getWatchedMovies().stream()
                        .noneMatch((x) -> x.getName().equals(page.getCurrentMovie().getName()))) {
                    assert currentMovie != null;
                    page.getCurrentUser().getWatchedMovies().add(new Movie(currentMovie));
                    ArrayList<Movie> movie = new ArrayList<>();
                    movie.add(currentMovie);
                    Output output = new Output(movie, page.getCurrentUser());
                    output.addInJsonArrayNode(node);
                }
            }
        } else {
            Output output = new Output();
            output.addInJsonArrayNode(node);
        }

    }
}
