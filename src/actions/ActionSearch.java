package actions;

import com.fasterxml.jackson.databind.node.ArrayNode;
import entities.Movie;
import entities.DataBase;
import entities.Output;
import entities.Page;

import java.util.ArrayList;

public class ActionSearch extends Action {
    private String startsWith;
    public ActionSearch(final String type, final String page, final String startsWith) {
        super(type, page);
        this.startsWith = startsWith;
    }

    /**
     *
     * @param node
     * @param page
     * @param emp
     */
    public void search(final ArrayNode node, final Page page, final DataBase emp) {
        if (page.getName().equals("movies")) {
            ArrayList<Movie> searchedMovies = new ArrayList<>();
            for (Movie movie : emp.getMovies()) {
                if (movie.getName().startsWith(startsWith)
                        && !movie.getCountriesBanned()
                        .contains(page.getCurrentUser().getCredentials().getCountry())) {
                    searchedMovies.add(movie);
                }
            }
            if (searchedMovies.size() != 0) {
                page.setMovieList(searchedMovies);
            }
            Output output = new Output(searchedMovies, page.getCurrentUser());
            output.addInJsonArrayNode(node);
        } else {
            Output output = new Output();
            output.addInJsonArrayNode(node);
        }
    }
}
