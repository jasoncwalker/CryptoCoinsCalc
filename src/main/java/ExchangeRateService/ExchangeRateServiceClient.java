package ExchangeRateService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Simple client for calling crypto currency REST API
 */
public class ExchangeRateServiceClient {

  public ExchangeRateServiceResponse callRateService(String fromCurrency, String toCurrency) throws IOException {
    ExchangeRateServiceResponse exchangeRateServiceResponse = new ExchangeRateServiceResponse();
    // Call REST service
    URL urlForGetRequest = new URL("https://min-api.cryptocompare.com/data/price?fsym=" + fromCurrency + "&tsyms=" + toCurrency);
    HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
    connection.setRequestMethod("GET");

    // Extract response
    exchangeRateServiceResponse.setResponseCode(connection.getResponseCode());
    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuffer response = new StringBuffer();
      String readLine;
      while ((readLine = in.readLine()) != null) {
        response.append(readLine);
      } in .close();
      exchangeRateServiceResponse.setResponse(response.toString());
    }
    return exchangeRateServiceResponse;
  }
}
