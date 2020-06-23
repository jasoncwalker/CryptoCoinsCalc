package ExchangeRateService;

import java.math.BigDecimal;

/**
 * Simple exchange rate service response parser
 */
public class ResponseParser {

  /**
   * Parses exchange rate from JSON string of form: {"EUR":8314.84}
   * @param json
   * @return rate as BigDecimal
   */
  public static BigDecimal getRate(String json) {
    int start = json.indexOf(":") + 1;
    int end = json.indexOf("}");
    String rateString = json.substring(start, end);
    return new BigDecimal(rateString);
  }
}
