package actions;

import com.fasterxml.jackson.databind.node.ArrayNode;
import entities.Output;
import entities.Page;
import entities.DataBase;
import entities.Credentials;
import entities.User;

public class ActionRegister extends Action {
    private final Credentials credentials;
    public ActionRegister(final String type, final String page, final Credentials credentials) {
        super(type, page);
        this.credentials = credentials;
    }

    /**
     *
     * @param node
     * @param page
     * @param emp
     */
    public void register(final ArrayNode node, final Page page, final DataBase emp) {
        if (page.getName().equals("register") && page.getCurrentUser() == null) {
            if (emp.getUsers().stream()
                    .filter(x -> x.getCredentials().getName().equals(credentials.getName()))
                    .findFirst()
                    .isEmpty()) {
                User user = new User(credentials.getName(),
                        credentials.getPassword(), credentials.getAccountType(),
                        credentials.getCountry(), credentials.getBalance());
                emp.addUser(user);
                page.setCurrentUser(user);
                Output output = new Output(page.getMovieList(), page.getCurrentUser());
                output.addInJsonArrayNode(node);
            } else {
                Output output = new Output();
                output.addInJsonArrayNode(node);
            }
        } else {
            Output output = new Output();
            output.addInJsonArrayNode(node);
            page.setName("homepage");
        }
        page.setName("homepage");
    }
}
