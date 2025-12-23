package androidx.camera.video.internal.workaround;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.TimeProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class VideoTimebaseConverter {
    private static final String TAG = "VideoTimebaseConverter";
    private Timebase mInputTimebase;
    private final TimeProvider mTimeProvider;
    private long mUptimeToRealtimeOffsetUs = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: androidx.camera.video.internal.workaround.VideoTimebaseConverter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$Timebase;

        static {
            int[] iArr = new int[Timebase.values().length];
            $SwitchMap$androidx$camera$core$impl$Timebase = iArr;
            try {
                iArr[Timebase.REALTIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$Timebase[Timebase.UPTIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private long calculateUptimeToRealtimeOffsetUs() {
        long j6 = Long.MAX_VALUE;
        long j7 = 0;
        for (int i6 = 0; i6 < 3; i6++) {
            long uptimeUs = this.mTimeProvider.uptimeUs();
            long realtimeUs = this.mTimeProvider.realtimeUs();
            long uptimeUs2 = this.mTimeProvider.uptimeUs();
            long j8 = uptimeUs2 - uptimeUs;
            if (i6 == 0 || j8 < j6) {
                j7 = realtimeUs - ((uptimeUs + uptimeUs2) >> 1);
                j6 = j8;
            }
        }
        return Math.max(0L, j7);
    }

    private boolean isCloseToRealtime(long j6) {
        return Math.abs(j6 - this.mTimeProvider.realtimeUs()) < Math.abs(j6 - this.mTimeProvider.uptimeUs());
    }

    public long convertToUptimeUs(long j6) {
        if (this.mInputTimebase == null) {
            if (isCloseToRealtime(j6)) {
                this.mInputTimebase = Timebase.REALTIME;
            } else {
                this.mInputTimebase = Timebase.UPTIME;
            }
            Logger.d(TAG, "Detect input timebase = " + this.mInputTimebase);
        }
        int i6 = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$Timebase[this.mInputTimebase.ordinal()];
        if (i6 != 1) {
            if (i6 == 2) {
                return j6;
            }
            throw new AssertionError("Unknown timebase: " + this.mInputTimebase);
        }
        if (this.mUptimeToRealtimeOffsetUs == -1) {
            this.mUptimeToRealtimeOffsetUs = calculateUptimeToRealtimeOffsetUs();
            Logger.d(TAG, "mUptimeToRealtimeOffsetUs = " + this.mUptimeToRealtimeOffsetUs);
        }
        return j6 - this.mUptimeToRealtimeOffsetUs;
    }

    public VideoTimebaseConverter(@NonNull TimeProvider timeProvider, @Nullable Timebase timebase) {
        this.mTimeProvider = timeProvider;
        this.mInputTimebase = timebase;
    }
}
