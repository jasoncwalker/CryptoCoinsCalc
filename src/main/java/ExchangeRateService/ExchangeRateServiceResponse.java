package ExchangeRateService;

public class ExchangeRateServiceResponse {
  private int responseCode; // HTTP response code
  private String response; // JSON response

  public int getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(int responseCode) {
    this.responseCode = responseCode;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }
}
