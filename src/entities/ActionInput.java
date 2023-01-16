package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActionInput {
    private String type;
    private String page;
    private Credentials credentials;
    private String feature;
    private String startsWith;
    @JsonProperty("filters")
    private Filter filters;
    private String count;
    @JsonProperty("movie")
    private String movie;
    private Integer rate;
    @JsonProperty("subscribedGenre")
    private String subscribedGenre;
    @JsonProperty("deletedMovie")
    private String deletedMovie;
    @JsonProperty("addedMovie")
    private Movie addedMovie;

    /**
     *
     */
    public ActionInput() {
    }

    /**
     *
     * @return
     */
    public String getType() {
        return this.type;
    }

    /**
     *
     * @param type
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public String getPage() {
        return this.page;
    }

    /**
     *
     * @param page
     */
    public void setPage(final String page) {
        this.page = page;
    }

    /**
     *
     * @return
     */
    public Credentials getCredentials() {
        return this.credentials;
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
    public String getFeature() {
        return feature;
    }

    /**
     *
     * @return
     */
    public Filter getFilters() {
        return filters;
    }

    /**
     *
     * @param feature
     */
    public void setFeature(final String feature) {
        this.feature = feature;
    }

    /**
     *
     * @return
     */
    public String getStartsWith() {
        return this.startsWith;
    }

    /**
     *
     * @param startsWith
     */
    public void setStartsWith(final String startsWith) {
        this.startsWith = startsWith;
    }

    /**
     *
     * @return
     */
    public String getCount() {
        return this.count;
    }

    /**
     *
     * @param count
     */
    public void setCount(final String count) {
        this.count = count;
    }

    /**
     *
     * @return
     */
    public Integer getRate() {
        return this.rate;
    }

    /**
     *
     * @param rate
     */
    public void setRate(final Integer rate) {
        this.rate = rate;
    }

    /**
     *
     * @return
     */
    public String getMovie() {
        return this.movie;
    }

    /**
     *
     * @return
     */
    public Filter getFilter() {
        return filters;
    }

    /**
     *
     * @param filter
     */
    public void setFilter(final Filter filter) {
        this.filters = filter;
    }

    /**
     *
     * @param movie
     */
    public void setMovie(final String movie) {
        this.movie = movie;
    }

    /**
     *
     * @param filters
     */
    public void setFilters(final Filter filters) {
        this.filters = filters;
    }

    /**
     *
     * @return
     */
    public String getSubscribedGenre() {
        return subscribedGenre;
    }

    public void setSubscribedGenre(final String subscribedGenre) {
        this.subscribedGenre = subscribedGenre;
    }

    /**
     *
     * @return
     */
    public String getDeletedMovie() {
        return deletedMovie;
    }

    /**
     *
     * @param deletedMovie
     */
    public void setDeletedMovie(final String deletedMovie) {
        this.deletedMovie = deletedMovie;
    }

    /**
     *
     * @return
     */
    public Movie getAddedMovie() {
        return addedMovie;
    }

    public void setAddedMovie(final Movie addedMovie) {
        this.addedMovie = addedMovie;
    }
}
