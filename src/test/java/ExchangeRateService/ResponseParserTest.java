package ExchangeRateService;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import org.junit.Test;

public class ResponseParserTest {

  @Test
  public void getRateShouldSucceed() {
    assertTrue(new BigDecimal("8314.84").compareTo(ExchangeRateService.ResponseParser.getRate("{\"EUR\":8314.84}")) == 0);
  }
}
