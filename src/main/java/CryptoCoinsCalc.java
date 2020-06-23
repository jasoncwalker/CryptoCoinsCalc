import CryptoCoins.CurrencyAmount;
import CryptoCoins.CurrencyAmountsFileReader;
import ExchangeRateService.ExchangeRateServiceClient;
import ExchangeRateService.ExchangeRateServiceResponse;
import ExchangeRateService.ResponseParser;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class CryptoCoinsCalc {

  public static void main(String[] args) throws IOException {
    if (args.length == 0) {
      System.out.println("Please specify the filename.");
      System.exit(1);
    }

    File file = new File(args[0]); // TODO handle file not found and IO exceptions
    CurrencyAmountsFileReader fileReader = new CurrencyAmountsFileReader();
    List<CurrencyAmount> amounts = fileReader.readCurrencyAmountsFile(file);

    ExchangeRateServiceClient exchangeRateServiceClient = new ExchangeRateServiceClient();
    BigDecimal total = BigDecimal.ZERO;
    for (CurrencyAmount amount : amounts) {
      ExchangeRateServiceResponse response = exchangeRateServiceClient.callRateService(amount.getCurrency(), "EUR");
      BigDecimal rate = ResponseParser.getRate(response.getResponse());
      BigDecimal euroAmount = amount.getAmount().multiply(rate);
      total = total.add(euroAmount);
      System.out.println(amount + " -> EUR " + euroAmount);
    }
    System.out.println("Total EUR " + total);
  }
}
