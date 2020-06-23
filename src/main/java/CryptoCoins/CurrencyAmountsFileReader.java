package CryptoCoins;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CurrencyAmountsFileReader {

  public List<CurrencyAmount> readCurrencyAmountsFile(File file) throws IOException {
    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    List<CurrencyAmount> amounts = new ArrayList();
    String line;
    while ((line = bufferedReader.readLine()) != null) {
      String[] parts = line.split("=");
      amounts.add(new CurrencyAmount(parts[0], new BigDecimal(parts[1])));
    }
    return amounts;
  }
}
