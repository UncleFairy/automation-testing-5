package statuses;

public class Get200 {
    private final int statusCode = 200;
    private final String segmentPath = "/gists/public";

    public int getStatusCode() {
        return statusCode;
    }

    public String getSegmentPath() {
        return segmentPath;
    }

}
