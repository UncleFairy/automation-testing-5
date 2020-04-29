package statuses;

public class Get404 {
    private final int statusCode = 404;
    private final String segmentPath = "/nonExistingName";

    public int getStatusCode()
    {
        return statusCode;
    }
    public String getSegmentPath()
    {
        return segmentPath;
    }
}
