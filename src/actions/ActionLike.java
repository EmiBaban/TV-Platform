package actions;

import com.fasterxml.jackson.databind.node.ArrayNode;
import entities.Movie;
import entities.Output;
import entities.Page;
import entities.User;

import java.util.ArrayList;

public class ActionLike extends Action {
    public ActionLike(final String type, final String page, final String movieName) {
        super(type, page);
    }

    public void like(final ArrayNode node, final Page page) {
        if (page.getName().equals("see details")) {
            String movieName = page.getCurrentMovie().getName();
            if (page.getCurrentUser().getWatchedMovies().stream()
                    .filter((x) -> x.getName().equals(movieName))
                    .findFirst()
                    .orElse(null) != null &&
                    page.getCurrentUser().getLikedMovies().stream()
                            .filter((x) -> x.getName().equals(movieName))
                            .findFirst()
                            .orElse(null) == null) {
                Movie currentMovie = page.getMovieList().stream()
                        .filter((x) -> x.getName().equals(movieName))
                        .findFirst()
                        .orElse(null);
                if (currentMovie == null) {
                    Output output = new Output();
                    output.addInJsonArrayNode(node);
                } else {
                    currentMovie.incrementNumLikes();
                    User currentUser = page.getCurrentUser();

                    currentUser.getWatchedMovies().forEach((m -> {
                        if (m.getName().equals(movieName)) {
                            currentUser.getWatchedMovies()
                                    .set(currentUser.getWatchedMovies().indexOf(m), new Movie(currentMovie));
                        }
                    }));

                    currentUser.getPurchasedMovies().forEach((m -> {
                        if (m.getName().equals(movieName)) {
                            currentUser.getPurchasedMovies()
                                    .set(currentUser.getPurchasedMovies().indexOf(m), new Movie(currentMovie));
                        }
                    }));

                    currentUser.getRatedMovies().forEach((m -> {
                        if (m.getName().equals(movieName)) {
                            currentUser.getRatedMovies()
                                    .set(currentUser.getRatedMovies().indexOf(m), new Movie(currentMovie));
                        }
                    }));

                    page.getCurrentUser().getLikedMovies().add(new Movie(currentMovie));
                    ArrayList<Movie> movie = new ArrayList<>();
                    movie.add(currentMovie);
                    Output output = new Output(movie, page.getCurrentUser());
                    output.addInJsonArrayNode(node);
                }
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
