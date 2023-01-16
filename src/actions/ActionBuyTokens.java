package actions;

import com.fasterxml.jackson.databind.node.ArrayNode;
import entities.Output;
import entities.Page;

public class ActionBuyTokens extends Action {
    private final String count;
    public ActionBuyTokens(final String type, final String page, final String count) {
        super(type, page);
        this.count = count;
    }

    /**
     *
     * @param node
     * @param page
     */
    public void buyTokens(final ArrayNode node, final Page page) {
        if (page.getName().equals("upgrades")) {
            int balance = Integer.parseInt(page.getCurrentUser().getCredentials().getBalance());
            int intCount = Integer.parseInt(count);

            if (balance >= intCount) {
                page.getCurrentUser().incrementToken(intCount);
                page.getCurrentUser().decrementBalance(intCount);
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
