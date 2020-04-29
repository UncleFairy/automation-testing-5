package statuses;

public class Get401 {
    private final int statusCode = 401;
    private final String segmentPath = "/notifications";

    public int getStatusCode()
    {
        return statusCode;
    }
    public String getSegmentPath()
    {
        return segmentPath;
    }
}
