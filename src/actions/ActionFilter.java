package actions;

import com.fasterxml.jackson.databind.node.ArrayNode;
import entities.Filter;
import entities.Movie;
import entities.Output;
import entities.Page;
import entities.Sort;
import entities.ActionInput;
import entities.DataBase;
import java.util.ArrayList;
import java.util.List;

public class ActionFilter extends Action {
    public ActionFilter(final String type, final String pageName) {
        super(type, pageName);
    }

    /**
     *
     * @param node
     * @param page
     * @param action
     */
    public void filterAction(final ArrayNode node,
                             final Page page, final ActionInput action, final DataBase dataBase) {
        if (page.getName().equals("movies")) {
            Filter filters = action.getFilters();
            if (filters.getContains() != null) {
                List<Movie> movies = new ArrayList<>();
                if (filters.getContains().getActors() != null) {
                    movies = filters.getContains()
                            .containsActor(dataBase.unbannedMovies(page.getCurrentUser()
                            .getCredentials().getCountry()));
                    page.setMovieList(filters.getContains()
                            .containsActor(dataBase.unbannedMovies(page.getCurrentUser()
                            .getCredentials().getCountry())));
                }
                if (filters.getContains().getGenre() != null) {
                    page.setMovieList(filters.getContains().containsGenre(movies));
                }
            }

            Sort sort = action.getFilter().getSort();
            if (sort != null) {
                if (sort.getRating() != null) {
                    if (action.getFilter().getSort().getRating().equals("decreasing")) {
                        sort.setOrder("decreasing");
                        sort.sortAfterRating(page.getMovieList());
                    } else {
                        sort.sortAfterRating(page.getMovieList());
                    }
                }
                if (sort.getDuration() != null) {
                    if (action.getFilter().getSort().getDuration().equals("decreasing")) {
                        sort.setOrder("decreasing");
                        sort.sortAfterDuration(page.getMovieList());
                    } else {
                        sort.sortAfterDuration(page.getMovieList());
                    }
                }
            }
            Output output = new Output(page.getMovieList(), page.getCurrentUser());
            output.addInJsonArrayNode(node);
        } else {
            Output output = new Output();
            output.addInJsonArrayNode(node);
        }
    }
}
