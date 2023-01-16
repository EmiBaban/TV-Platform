package actions;

import com.fasterxml.jackson.databind.node.ArrayNode;
import entities.*;


public class ActionLogin extends Action {
    private final Credentials credentials;

    public ActionLogin(final String type, final String page, final Credentials credentials) {
        super(type, page);
        this.credentials = credentials;
    }

    /**
     *
     * @param node
     * @param page
     * @param emp
     */
    public void login(final ArrayNode node, final Page page, final DataBase emp) {
        if (page.getCurrentUser() == null && page.getName().equals("login")) {
            User user = findUser(emp);
            if (user != null) {
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
        }
        page.setName("homepage");
    }

    /**
     *
     * @param emp
     * @return
     */
    public User findUser(final DataBase emp) {
        for (User user : emp.getUsers()) {
          if (user.getCredentials().getName().equals(credentials.getName())
                && user.getCredentials().getPassword().equals(credentials.getPassword())) {
              return user;
          }
        }
        return null;
    }
}
