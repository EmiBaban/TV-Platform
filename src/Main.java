import actions.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import entities.*;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(final String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode node = objectMapper.createArrayNode();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
       DataBase dataBase = objectMapper.readValue(new File(args[0]), DataBase.class);
      // DataBase dataBase = objectMapper.readValue(new File("checker/resources/in/basic_6.json"), DataBase.class);

        Page page = new Page("homepage");
        PagesStack stack = new PagesStack();
        stack.push(new Page(page));

        for (ActionInput action : dataBase.getActions()) {
            switch (action.getType()) {
                case "database" -> {
                    ActionDataBase actionDataBase = new ActionDataBase(dataBase, action.getDeletedMovie(), action.getAddedMovie());
                    actionDataBase.dataBaseAction(action.getFeature(), page);
                }
                case "back" -> {
                    ActionBack  actionBack = new ActionBack();
                    actionBack.back(node, page, stack, dataBase, action);
                }
                case "change page" -> {
                    ActionChangePage actionChangePage = new ActionChangePage(action.getType(), action.getPage());
                    actionChangePage.changePage(node, page, dataBase, stack, action.getMovie());
                }
                case "on page" -> {
                    switch (action.getFeature()) {
                        case "register" -> {
                            ActionRegister actionRegister = new ActionRegister(action.getType(),
                                    action.getPage(), action.getCredentials());
                            actionRegister.register(node, page, dataBase);
                        }
                        case "login" -> {
                            ActionLogin actionLogin = new ActionLogin(action.getType(),
                                    action.getPage(), action.getCredentials());
                            actionLogin.login(node, page, dataBase);
                        }
                        case "search" -> {
                            ActionSearch actionSearch = new ActionSearch(action.getType(),
                                    action.getPage(), action.getStartsWith());
                            actionSearch.search(node, page, dataBase);
                        }
                        case "filter" -> {
                            ActionFilter actionFilter = new ActionFilter(action.getType(),
                                    action.getPage());
                            actionFilter.filterAction(node, page, action, dataBase);
                        }
                        case "buy tokens" -> {
                            ActionBuyTokens actionBuyTokens = new ActionBuyTokens(action.getType(),
                                    action.getPage(), action.getCount());
                            actionBuyTokens.buyTokens(node, page);
                        }
                        case "buy premium account" -> {
                            ActionBuyPremiumAccount actionBuyPremiumAccount =
                                    new ActionBuyPremiumAccount(action.getType(), action.getPage());
                            actionBuyPremiumAccount.buyPremiumAccount(node, page);
                        }
                        case "purchase" -> {
                            ActionPurchase actionPurchase = new ActionPurchase(action.getType(),
                                    action.getPage(), action.getMovie());
                            actionPurchase.purchase(node, page);
                        }
                        case "watch" -> {
                            ActionWatch actionWatch = new ActionWatch(action.getType(),
                                    action.getPage());
                            actionWatch.watch(node, page);
                        }
                        case "like" -> {
                            ActionLike actionLike = new ActionLike(action.getType(),
                                    action.getPage(), action.getMovie());
                            actionLike.like(node, page);
                        }
                        case "rate" -> {
                            ActionRateMovies actionRateMovies = new ActionRateMovies(action.getType(),
                                    action.getPage(), action.getMovie(), action.getRate());
                            actionRateMovies.rate(node, page, dataBase);
                        }
                        case "subscribe" -> {
                            ActionSubscribe actionSubscribe = new ActionSubscribe(action.getSubscribedGenre());
                            actionSubscribe.subscribe(node, page, dataBase);
                        }
                        default -> {
                        }
                    }
                }
            }
        }

        if (page.getCurrentUser().getCredentials().getAccountType().equals("premium")) {
            Recommendation recommendation = new Recommendation(page.getCurrentUser());
            recommendation.setRecommendedMovie(page);
            recommendation.setCurrentUser(page.getCurrentUser());
            recommendation.addInJsonArrayNode(node);
        }


        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File(args[1]), node);
    }
}
