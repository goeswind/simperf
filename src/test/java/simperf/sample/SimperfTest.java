package simperf.sample;

import simperf.Simperf;
import simperf.config.Constant;
import simperf.sample.thread.MessageSender;
import simperf.sample.thread.SendMessageThread;
import simperf.thread.SimperfThread;
import simperf.thread.SimperfThreadFactory;

public class SimperfTest {
    static MessageSender sender = new MessageSender();

    /**
     * @param args
     */
    public static void main(String[] args) {

        Simperf perf = new Simperf(10, 100);
        Constant.USE_DETAIL_MSG_FORMAT = true;
        perf.setMaxTps(100);

        sender.sleepTime = 100;

        perf.start(new SimperfThreadFactory() {
            public SimperfThread newThread() {
                SendMessageThread t = new SendMessageThread();
                t.setSender(sender);
                return t;
            }
        });
    }
}
