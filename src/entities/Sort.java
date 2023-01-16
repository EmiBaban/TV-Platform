package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@JsonIgnoreProperties({"order"})
public class Sort {
    private String rating;
    private String duration;
    private String order = "increasing";

    public Sort() {
    }

    /**
     *
     * @return
     */
    public String getRating() {
        return rating;
    }

    /**
     *
     * @return
     */
    public String getOrder() {
        return order;
    }

    /**
     *
     * @param order
     */
    public void setOrder(final String order) {
        this.order = order;
    }

    /**
     *
     * @param rating
     */
    public void setRating(final String rating) {
        this.rating = rating;
    }

    /**
     *
     * @return
     */
    public String getDuration() {
        return duration;
    }

    /**
     *
     * @param duration
     */
    public void setDuration(final String duration) {
        this.duration = duration;
    }

    /**
     *
     * @param movies
     */
    public void sortAfterRating(final ArrayList<Movie> movies) {
        Comparator<Movie> nameComparator = (m1, m2) -> (int) (m1.getRating() - m2.getRating());
        if (order.equals("increasing")) {
            movies.sort(nameComparator);
        } else {
            movies.sort(Collections.reverseOrder(nameComparator));
        }
    }

    /**
     *
     * @param movies
     */
    public void sortAfterDuration(final ArrayList<Movie> movies) {
        Comparator<Movie> nameComparator = Comparator.comparingInt(Movie::getDuration);
        if (order.equals("increasing")) {
            movies.sort(nameComparator);
        } else {
            movies.sort(Collections.reverseOrder(nameComparator));
        }
    }
}
