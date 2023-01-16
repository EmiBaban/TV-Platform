package actions;

import com.fasterxml.jackson.databind.node.ArrayNode;
import entities.Movie;
import entities.Output;
import entities.Page;
import java.util.ArrayList;

public class ActionPurchase extends Action {
    public ActionPurchase(final String type, final String page, final String movieName) {
        super(type, page);
    }

    /**
     *
     * @param node
     * @param page
     */
    public void purchase(final ArrayNode node, final Page page) {
        if (page.getName().equals("see details")) {
            helper(node, page, page.getCurrentMovie());
        } else {
            Output output = new Output();
            output.addInJsonArrayNode(node);
        }
    }

    private void helper(final ArrayNode node, final Page page, final Movie currentMovie) {
        if (page.getCurrentUser().getPurchasedMovies()
                .stream().anyMatch((x) -> x.getName().equals(currentMovie.getName()))) {
            Output output = new Output();
            output.addInJsonArrayNode(node);
        } else if (page.getCurrentUser().getCredentials().getAccountType().equals("premium")
                && page.getCurrentUser().getNumFreePremiumMovies() > 0) {
            page.getCurrentUser().decrementNumFreePremiumMovies();
            page.getCurrentUser().getPurchasedMovies().add(new Movie(currentMovie));
            ArrayList<Movie> list = new ArrayList<>();
            list.add(currentMovie);
            Output output = new Output(list, page.getCurrentUser());
            output.addInJsonArrayNode(node);
        } else if (page.getCurrentUser().getTokensCount() < 2) {
            Output output = new Output();
            output.addInJsonArrayNode(node);
        } else {
            page.getCurrentUser().decrementToken(2);
            page.getCurrentUser().getPurchasedMovies().add(new Movie(currentMovie));
            ArrayList<Movie> list = new ArrayList<>();
            list.add(currentMovie);
            Output output = new Output(list, page.getCurrentUser());
            output.addInJsonArrayNode(node);
        }
    }

}
