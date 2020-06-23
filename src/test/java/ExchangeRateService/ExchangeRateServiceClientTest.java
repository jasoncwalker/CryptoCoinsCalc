package ExchangeRateService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.HttpURLConnection;
import org.junit.Test;

public class ExchangeRateServiceClientTest {

  @Test
  public void callRateServiceShouldSucceed() throws Exception {
    ExchangeRateServiceClient exchangeRateServiceClient = new ExchangeRateServiceClient();
    ExchangeRateServiceResponse exchangeRateServiceResponse = exchangeRateServiceClient.callRateService("BTC", "EUR");
    assertEquals(HttpURLConnection.HTTP_OK, exchangeRateServiceResponse.getResponseCode());
    assertTrue(exchangeRateServiceResponse.getResponse() != null);
    assertTrue(exchangeRateServiceResponse.getResponse().startsWith("{\"EUR\":"));
    assertTrue(exchangeRateServiceResponse.getResponse().endsWith("}"));
  }
}
