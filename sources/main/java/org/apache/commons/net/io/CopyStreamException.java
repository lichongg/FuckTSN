package org.apache.commons.net.io;

import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CopyStreamException extends IOException {
    private static final long serialVersionUID = -2602899129433221532L;
    private final long totalBytesTransferred;

    public long getTotalBytesTransferred() {
        return this.totalBytesTransferred;
    }

    public CopyStreamException(String str, long j6, IOException iOException) {
        super(str);
        initCause(iOException);
        this.totalBytesTransferred = j6;
    }

    public IOException getIOException() {
        return (IOException) getCause();
    }
}
