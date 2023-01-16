package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Filter {
    @JsonProperty("sort")
    private Sort sort;
    @JsonProperty("contains")
    private Contains contains;
    public Filter() {
    }

    /**
     *
     * @return
     */
    public Sort getSort() {
        return sort;
    }

    /**
     *
     * @param sort
     */
    public void setSort(final Sort sort) {
        this.sort = sort;
    }

    /**
     *
     * @return
     */
    public Contains getContains() {
        return contains;
    }

    /**
     *
     * @param contains
     */
    public void setContains(final Contains contains) {
        this.contains = contains;
    }
}
