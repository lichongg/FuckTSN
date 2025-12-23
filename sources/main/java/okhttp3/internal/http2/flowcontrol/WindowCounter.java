package okhttp3.internal.http2.flowcontrol;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class WindowCounter {
    private long acknowledged;
    private final int streamId;
    private long total;

    public final synchronized long getUnacknowledged() {
        return this.total - this.acknowledged;
    }

    public final synchronized void update(long j6, long j7) {
        try {
            if (j6 < 0) {
                throw new IllegalStateException("Check failed.");
            }
            if (j7 < 0) {
                throw new IllegalStateException("Check failed.");
            }
            long j8 = this.total + j6;
            this.total = j8;
            long j9 = this.acknowledged + j7;
            this.acknowledged = j9;
            if (j9 > j8) {
                throw new IllegalStateException("Check failed.");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static /* synthetic */ void update$default(WindowCounter windowCounter, long j6, long j7, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            j6 = 0;
        }
        if ((i6 & 2) != 0) {
            j7 = 0;
        }
        windowCounter.update(j6, j7);
    }

    public final long getAcknowledged() {
        return this.acknowledged;
    }

    public final int getStreamId() {
        return this.streamId;
    }

    public final long getTotal() {
        return this.total;
    }

    @NotNull
    public String toString() {
        return "WindowCounter(streamId=" + this.streamId + ", total=" + this.total + ", acknowledged=" + this.acknowledged + ", unacknowledged=" + getUnacknowledged() + ')';
    }

    public WindowCounter(int i6) {
        this.streamId = i6;
    }
}
