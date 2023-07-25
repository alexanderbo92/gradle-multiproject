package base;

import common.MyLibrary;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.stat.Frequency;

@Slf4j
public abstract class MyBase implements MyInterface {

  @Override
  public void doSomeProcess() {

    MyLibrary.doSomeProcess();
    //   log.info("log floor: {}", LongMath.log2(8, RoundingMode.FLOOR));
  }

  public void countStringFrequencies() {
    Frequency f = new Frequency();
    f.addValue("one");
    f.addValue("One");
    f.addValue("oNe");
    f.addValue("Z");
    f.addValue("edwin");
    // log.info("f.getCumPct('Z'): {}", f.getCumPct("Z")); // displays 0.5
  }
}
