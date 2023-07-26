package base;

import common.MyLibrary;
import org.apache.commons.math3.stat.Frequency;

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
