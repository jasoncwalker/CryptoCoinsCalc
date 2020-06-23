package CryptoCoins;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;
import org.junit.Test;

public class CurrencyAmountsFileReaderTest {

  @Test
  public void readCurrencyAmountsFileShouldSucceed() throws Exception {
    CurrencyAmountsFileReader fileReader = new CurrencyAmountsFileReader();
    File file = new File(getClass().getClassLoader().getResource("testcoins.txt").getFile());
    List<CurrencyAmount> amounts = fileReader.readCurrencyAmountsFile(file);
    assertNotNull(amounts);
    assertEquals(3, amounts.size());
  }
}
