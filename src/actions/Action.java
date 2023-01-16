package actions;

public class Action {
    private String type;
    private String pageName;

    public Action() {
    }
    public Action(final String type, final String pageName) {
        this.type = type;
        this.pageName = pageName;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
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
    public String getPageName() {
        return pageName;
    }

    /**
     *
     * @param page
     */
    public void setPageName(final String page) {
        this.pageName = page;
    }
}
