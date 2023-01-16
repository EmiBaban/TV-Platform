package actions;

import com.fasterxml.jackson.databind.node.ArrayNode;
import entities.Movie;
import entities.Output;
import entities.Page;
import entities.DataBase;
import java.util.ArrayList;

public class ActionRateMovies extends Action {
    private final int rating;
    public ActionRateMovies(final String type, final String page, final int rating) {
        super(type, page);
        this.rating = rating;
    }

    /**
     *
     * @param node
     * @param page
     * @param dataBase
     */
    public void rate(final ArrayNode node, final Page page, final DataBase dataBase) {
        if (page.getName().equals("see details")) {
            String movieName = page.getCurrentMovie().getName();
            if (page.getCurrentUser().getWatchedMovies().stream()
                    .filter((x) -> x.getName().equals(movieName))
                    .findFirst()
                    .orElse(null) != null
                    && page.getCurrentUser().getLikedMovies().stream()
                            .filter((x) -> x.getName().equals(movieName))
                            .findFirst()
                            .orElse(null) == null
                    && page.getCurrentUser().getRatedMovies().stream()
                            .filter((x) -> x.getName().equals(movieName))
                            .findFirst()
                            .orElse(null) == null
                    && rating <= 5 && rating >= 1) {
                double movieRating = page.getCurrentMovie().getRating();
                double movieNumRatings = page.getCurrentMovie().getNumRatings();
                page.getCurrentMovie()
                        .setRating((movieRating * movieNumRatings + rating)
                                / (movieNumRatings + 1));
                page.getCurrentMovie().incrementNumRatings();

                dataBase.getUsers().forEach((x) -> {
                    x.getWatchedMovies().stream()
                            .filter(m -> m.getName().equals(movieName))
                            .findFirst()
                            .ifPresent(m -> {
                                int index = x.getWatchedMovies().indexOf(m);
                                x.getWatchedMovies().set(index, new Movie(page.getCurrentMovie()));
                            });

                    x.getPurchasedMovies().stream()
                            .filter(m -> m.getName().equals(movieName))
                            .findFirst()
                            .ifPresent(m -> {
                                int index = x.getPurchasedMovies().indexOf(m);
                                x.getPurchasedMovies().set(index, new Movie(page.getCurrentMovie()));
                            });

                    x.getLikedMovies().stream()
                            .filter(m -> m.getName().equals(movieName))
                            .findFirst()
                            .ifPresent(m -> {
                                int index = x.getLikedMovies().indexOf(m);
                                x.getLikedMovies().set(index, new Movie(page.getCurrentMovie()));
                            });
                });
                    page.getCurrentUser().getRatedMovies().add(new Movie(page.getCurrentMovie()));
                    ArrayList<Movie> movie = new ArrayList<>();
                    movie.add(page.getCurrentMovie());
                    Output output = new Output(movie, page.getCurrentUser());
                    output.addInJsonArrayNode(node);
                } else {
                Output output = new Output();
                output.addInJsonArrayNode(node);
            }
        } else {
            Output output = new Output();
            output.addInJsonArrayNode(node);
        }
    }
}
