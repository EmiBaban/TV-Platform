package entities;

import java.util.ArrayList;

public class Movie {
    private String name;
    private String year;
    private int duration;
    private ArrayList<String> genres = new ArrayList<>();
    private ArrayList<String> actors = new ArrayList<>();
    private ArrayList<String> countriesBanned = new ArrayList<>();
    private int numLikes;
    private double rating;
    private int numRatings;

    public Movie() {
    }

    public Movie(final Movie movie) {
        this.name = movie.name;
        this.rating = movie.rating;
        this.numRatings = movie.numRatings;
        this.year = movie.year;
        this.numLikes = movie.numLikes;
        this.duration = movie.duration;
        this.genres.addAll(movie.genres);
        this.actors.addAll(movie.actors);
        this.countriesBanned.addAll(movie.countriesBanned);
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getYear() {
        return year;
    }

    /**
     *
     * @param year
     */
    public void setYear(final String year) {
        this.year = year;
    }

    /**
     *
     * @return
     */
    public int getDuration() {
        return duration;
    }

    /**
     *
     * @param duration
     */
    public void setDuration(final int duration) {
        this.duration = duration;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getGenres() {
        return genres;
    }

    /**
     *
     * @param genres
     */
    public void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getActors() {
        return actors;
    }

    /**
     *
     * @param actors
     */
    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    /**
     *
     * @param countriesBanned
     */
    public void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

    /**
     *
     * @return
     */
    public int getNumLikes() {
        return numLikes;
    }

    /**
     *
     * @param numLikes
     */
    public void setNumLikes(final int numLikes) {
        this.numLikes = numLikes;
    }

    /**
     *
     * @return
     */
    public double getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(final double rating) {
        this.rating = rating;
    }

    /**
     *
     * @return
     */
    public int getNumRatings() {
        return numRatings;
    }

    /**
     *
     * @param numRatings
     */
    public void setNumRatings(final int numRatings) {
        this.numRatings = numRatings;
    }

    public void incrementNumLikes() {
        ++this.numLikes;
    }
    public void incrementNumRatings() {
        ++this.numRatings;
    }
}

