package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties("subscribe")
public class User {
    private Credentials credentials;
    private int tokensCount = 0;
    private int numFreePremiumMovies = 15;
    private ArrayList<Movie> purchasedMovies = new ArrayList<>();
    private ArrayList<Movie> watchedMovies = new ArrayList<>();
    private ArrayList<Movie> likedMovies = new ArrayList<>();
    private ArrayList<Movie> ratedMovies = new ArrayList<>();
    private ArrayList<Notification> notifications = new ArrayList<>();
    private ArrayList<String> subscribe = new ArrayList<>();

    public User() {
    }

    public User(final String name, final String password, final String accountType,
                final String country, final String balance) {
        this.credentials = new Credentials(name, password, accountType, country, balance);
    }

    public User(final User user) {
        this.credentials = new Credentials();
        this.credentials.setName(user.getCredentials().getName());
        this.credentials.setAccountType(user.getCredentials().getAccountType());
        this.credentials.setBalance(user.getCredentials().getBalance());
        this.credentials.setCountry(user.getCredentials().getCountry());
        this.credentials.setPassword(user.getCredentials().getPassword());
        this.tokensCount = user.tokensCount;
        this.numFreePremiumMovies = user.numFreePremiumMovies;
        this.purchasedMovies.addAll(user.purchasedMovies);
        this.watchedMovies.addAll(user.watchedMovies);
        this.likedMovies.addAll(user.likedMovies);
        this.ratedMovies.addAll(user.ratedMovies);
        this.notifications.addAll(user.notifications);
    }

    /**
     *
     */
    public void decrementNumFreePremiumMovies() {
        this.numFreePremiumMovies--;
    }

    /**
     *
     * @param tokensCount
     */
    public void incrementToken(final int tokensCount) {
        this.tokensCount += tokensCount;
    }

    /**
     *
     * @param tokensCount
     */
    public void decrementToken(final int tokensCount) {
        this.tokensCount -= tokensCount;
    }

    /**
     *
     * @param balance
     */
    public void decrementBalance(final int balance) {
        int b = Integer.parseInt(this.getCredentials().getBalance());
        b -= balance;
        this.credentials.setBalance(String.valueOf(b));
    }

    /**
     *
     * @return
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     *
     * @param credentials
     */
    public void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }

    /**
     *
     * @return
     */
    public int getTokensCount() {
        return tokensCount;
    }

    /**
     *
     * @param tokensCount
     */
    public void setTokensCount(final int tokensCount) {
        this.tokensCount = tokensCount;
    }

    /**
     *
     * @return
     */
    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }

    /**
     *
     * @param numFreePremiumMovies
     */
    public void setNumFreePremiumMovies(final int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }

    /**
     *
     * @return
     */
    public List<Movie> getPurchasedMovies() {
        return purchasedMovies;
    }

    /**
     *
     * @param purchasedMovies
     */
    public void setPurchasedMovies(final ArrayList<Movie> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }

    /**
     *
     * @return
     */
    public List<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    /**
     *
     * @param watchedMovies
     */
    public void setWatchedMovies(final ArrayList<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    /**
     *
     * @return
     */
    public List<Movie> getLikedMovies() {
        return likedMovies;
    }

    /**
     *
     * @param likedMovies
     */
    public void setLikedMovies(final ArrayList<Movie> likedMovies) {
        this.likedMovies = likedMovies;
    }

    /**
     *
     * @return
     */
    public List<Movie> getRatedMovies() {
        return ratedMovies;
    }

    /**
     *
     * @param ratedMovies
     */
    public void setRatedMovies(final ArrayList<Movie> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }

    /**
     *
     * @return
     */
    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    /**
     *
     * @param notifications
     */
    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getSubscribe() {
        return subscribe;
    }
}
