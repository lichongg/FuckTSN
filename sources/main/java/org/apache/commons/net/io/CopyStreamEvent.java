package org.apache.commons.net.io;

import java.util.EventObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CopyStreamEvent extends EventObject {
    public static final long UNKNOWN_STREAM_SIZE = -1;
    private static final long serialVersionUID = -964927635655051867L;
    private final int bytesTransferred;
    private final long streamSize;
    private final long totalBytesTransferred;

    public int getBytesTransferred() {
        return this.bytesTransferred;
    }

    public long getStreamSize() {
        return this.streamSize;
    }

    public long getTotalBytesTransferred() {
        return this.totalBytesTransferred;
    }

    @Override // java.util.EventObject
    public String toString() {
        return getClass().getName() + "[source=" + ((EventObject) this).source + ", total=" + this.totalBytesTransferred + ", bytes=" + this.bytesTransferred + ", size=" + this.streamSize + "]";
    }

    public CopyStreamEvent(Object obj, long j6, int i6, long j7) {
        super(obj);
        this.bytesTransferred = i6;
        this.totalBytesTransferred = j6;
        this.streamSize = j7;
    }
}
