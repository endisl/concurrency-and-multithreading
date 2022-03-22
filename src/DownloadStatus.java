import java.util.concurrent.atomic.LongAdder;

public class DownloadStatus {
    private LongAdder totalBytes = new LongAdder();

    public void incrementTotalBytes() {
        //adder objetcs faster than atomic objects
        totalBytes.increment();
    }

    public int getTotalBytes() {
        return totalBytes.intValue();
    }
}
