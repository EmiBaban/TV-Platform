package actions;

import com.fasterxml.jackson.databind.node.ArrayNode;
import entities.Output;
import entities.Page;

public class ActionBuyPremiumAccount extends Action {
    private static final int ACCOUNT_PRICE = 10;
    public ActionBuyPremiumAccount(final String type, final String page) {
        super(type, page);
    }

    /**
     *
     * @param node
     * @param page
     */
    public void buyPremiumAccount(final ArrayNode node, final Page page) {
        if (page.getName().equals("upgrades")) {
            int balance = Integer.parseInt(page.getCurrentUser().getCredentials().getBalance());

            if (balance > ACCOUNT_PRICE) {
                page.getCurrentUser().decrementToken(ACCOUNT_PRICE);
                page.getCurrentUser().getCredentials().setAccountType("premium");
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
