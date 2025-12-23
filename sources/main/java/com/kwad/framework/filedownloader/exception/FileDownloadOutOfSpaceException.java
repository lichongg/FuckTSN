package com.kwad.framework.filedownloader.exception;

import android.annotation.TargetApi;
import com.kwad.framework.filedownloader.f.f;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class FileDownloadOutOfSpaceException extends IOException {
    private long breakpointBytes;
    private long freeSpaceBytes;
    private long requiredSpaceBytes;

    @TargetApi(9)
    public FileDownloadOutOfSpaceException(long j6, long j7, long j8, Throwable th) {
        super(f.c("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j8), Long.valueOf(j7), Long.valueOf(j6)), th);
        init(j6, j7, j8);
    }

    private void init(long j6, long j7, long j8) {
        this.freeSpaceBytes = j6;
        this.requiredSpaceBytes = j7;
        this.breakpointBytes = j8;
    }

    public long getBreakpointBytes() {
        return this.breakpointBytes;
    }

    public long getFreeSpaceBytes() {
        return this.freeSpaceBytes;
    }

    public long getRequiredSpaceBytes() {
        return this.requiredSpaceBytes;
    }

    public FileDownloadOutOfSpaceException(long j6, long j7, long j8) {
        super(f.c("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j8), Long.valueOf(j7), Long.valueOf(j6)));
        init(j6, j7, j8);
    }
}
