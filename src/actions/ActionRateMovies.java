package actions;

import com.fasterxml.jackson.databind.node.ArrayNode;
import entities.*;

import java.util.ArrayList;

public class ActionRateMovies extends Action {
    private final int rating;
    public ActionRateMovies(final String type, final String page, final String movieName, final int rating) {
        super(type, page);
        this.rating = rating;
    }

    public void rate(final ArrayNode node, final Page page, DataBase emp) {
        if (page.getName().equals("see details")) {
            String movieName = page.getCurrentMovie().getName();
            if (page.getCurrentUser().getWatchedMovies().stream()
                    .filter((x) -> x.getName().equals(movieName))
                    .findFirst()
                    .orElse(null) != null &&
                    page.getCurrentUser().getLikedMovies().stream()
                            .filter((x) -> x.getName().equals(movieName))
                            .findFirst()
                            .orElse(null) == null &&
                    page.getCurrentUser().getRatedMovies().stream()
                            .filter((x) -> x.getName().equals(movieName))
                            .findFirst()
                            .orElse(null) == null
                    && rating <= 5 && rating >= 1) {
                double movieRating = page.getCurrentMovie().getRating();
                double movieNumRatings = page.getCurrentMovie().getNumRatings();
                page.getCurrentMovie().setRating((movieRating * movieNumRatings + rating) / (movieNumRatings + 1));
                page.getCurrentMovie().incrementNumRatings();

                emp.getUsers().forEach((x) -> {
                    x.getWatchedMovies().forEach((m -> {
                        if (m.getName().equals(movieName)) {
                                x.getWatchedMovies()
                                        .set(x.getWatchedMovies().indexOf(m), new Movie(page.getCurrentMovie()));
                            }
                        }));

                        x.getPurchasedMovies().forEach((m -> {
                            if (m.getName().equals(movieName)) {
                                x.getPurchasedMovies()
                                        .set(x.getPurchasedMovies().indexOf(m), new Movie(page.getCurrentMovie()));
                            }
                        }));

                        x.getLikedMovies().forEach((m -> {
                            if (m.getName().equals(movieName)) {
                                x.getLikedMovies()
                                        .set(x.getLikedMovies().indexOf(m), new Movie(page.getCurrentMovie()));
                            }
                        }));

                        x.getRatedMovies().forEach((m -> {
                            if (!x.getCredentials().getName().equals(page.getCurrentUser().getCredentials().getName())
                                    && m.getName().equals(page.getCurrentMovie().getName())) {
                                x.getRatedMovies().set(x.getRatedMovies().indexOf(m), new Movie(page.getCurrentMovie()));
                            }
                        }));
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
