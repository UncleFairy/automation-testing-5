package headers;

public class ResponseHeader {
    private final String headerName ;
    private final String headerValue ;

    public ResponseHeader(String headerName, String headerValue)
    {
        this.headerName = headerName;
        this.headerValue = headerValue;
    }

    public String getHeaderValue() {
        return headerValue;
    }

    public String getHeaderName() {
        return headerName;
    }
}
