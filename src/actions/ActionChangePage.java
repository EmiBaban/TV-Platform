package actions;

import com.fasterxml.jackson.databind.node.ArrayNode;
import entities.DataBase;
import entities.Output;
import entities.Page;
import entities.PagesStack;
import entities.Movie;
import java.util.ArrayList;
import java.util.List;


public class ActionChangePage extends Action {
    public ActionChangePage(final String type, final String pageName) {
        super(type, pageName);
    }

    /**
     *
     * @param node
     * @param page
     * @param emp
     */
    public void changePage(final ArrayNode node,
                           final Page page, final DataBase emp,
                           final PagesStack stack, final String movieName) {
        Output output = new Output();
        switch (getPageName()) {
            case "register":
                if (page.getCurrentUser() == null && page.getName().equals("homepage")) {
                    page.setName("register");
                    page.resetMovie();
                    stack.push(new Page(page));
                } else {
                   output.addInJsonArrayNode(node);
                }
                break;
            case "login":
                if (page.getCurrentUser() == null && page.getName().equals("homepage")) {
                    page.setName("login");
                    page.resetMovie();
                    stack.push(new Page(page));
                } else {
                    output.addInJsonArrayNode(node);
                }
                break;
            case "logout":
                if (page.getCurrentUser() != null) {
                    page.setName("homepage");
                    page.resetMovie();
                    page.resetUser();
                    stack.clear();;
                    stack.push(new Page(page));
                } else {
                    output.addInJsonArrayNode(node);
                }
                break;
            case "movies":
                if (page.getCurrentUser() != null) {
                    page.setName("movies");
                    page.resetMovie();
                    List<Movie> movies = emp.unbannedMovies(page.getCurrentUser()
                            .getCredentials().getCountry());
                    page.setMovieList((ArrayList<Movie>) movies);
                    Output output1 = new Output((ArrayList<Movie>) movies, page.getCurrentUser());
                    output1.addInJsonArrayNode(node);
                    stack.push(new Page(page));
                } else {
                    output.addInJsonArrayNode(node);
                }
                break;
            case "see details":
                if (page.getName().equals("movies") || page.getName().equals("see details")) {
                    Movie currentMovie = page.getMovieList().stream()
                            .filter((x) -> x.getName().equals(movieName))
                            .findFirst()
                            .orElse(null);
                    if (currentMovie != null) {
                        page.setCurrentMovie(currentMovie);
                        page.setName("see details");
                        ArrayList<Movie> movie = new ArrayList<>();
                        movie.add(currentMovie);
                        Output output2 = new Output(movie, page.getCurrentUser());
                        output2.addInJsonArrayNode(node);
                        stack.push(new Page(page));
                    } else {
                        output.addInJsonArrayNode(node);
                    }
                } else {
                    output.addInJsonArrayNode(node);
                }
                break;
            case "upgrades":
                if (page.getCurrentUser() != null) {
                    page.setName("upgrades");
                    page.setCurrentMovie(null);
                    stack.push(new Page(page));
                } else {
                    output.addInJsonArrayNode(node);
                }
                break;
            default:
                break;
        }
    }
}
