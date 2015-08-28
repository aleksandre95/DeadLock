package deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Lars Mortensen
 */
class DeadLockDetector extends Thread {

  ThreadMXBean tmxb = ManagementFactory.getThreadMXBean();
  boolean doRun = true;
  
  
  
  @Override
  public void run() {
    while (doRun) {
      long[] threadIds = tmxb.findDeadlockedThreads();
        try {
            //...
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(DeadLockDetector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  }
}