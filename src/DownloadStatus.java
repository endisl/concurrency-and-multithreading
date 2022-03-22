public class DownloadStatus {
    private int totalBytes;
    private int totalFiles;
    private Object totalBytesLock = new Object();
    private Object totalFilesLock = new Object();

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementTotalBytes() {
        synchronized (totalBytesLock) {
            totalBytes++;
        }
    }

    public synchronized void incrementTotalFiles() {
        //synchronization on the current object and not on the dedicated monitoring object
        //this approach can cause a lot of overhead
        //as a good practice don't use synchronization in new code
        //because the code runs sequentially and concurrency is lost
        totalFiles++;
    }
}
