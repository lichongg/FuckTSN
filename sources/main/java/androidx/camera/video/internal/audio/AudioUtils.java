package androidx.camera.video.internal.audio;

import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class AudioUtils {
    public static int channelCountToChannelConfig(int i6) {
        return i6 == 1 ? 16 : 12;
    }

    public static int channelCountToChannelMask(int i6) {
        return i6 == 1 ? 16 : 12;
    }

    public static long frameCountToDurationNs(long j6, int i6) {
        long j7 = i6;
        Preconditions.checkArgument(j7 > 0, "sampleRate must be greater than 0.");
        return (TimeUnit.SECONDS.toNanos(1L) * j6) / j7;
    }

    public static long frameCountToSize(long j6, int i6) {
        long j7 = i6;
        Preconditions.checkArgument(j7 > 0, "bytesPerFrame must be greater than 0.");
        return j6 * j7;
    }

    public static long sizeToFrameCount(long j6, int i6) {
        long j7 = i6;
        Preconditions.checkArgument(j7 > 0, "bytesPerFrame must be greater than 0.");
        return j6 / j7;
    }

    public static int getBytesPerFrame(int i6, int i7) {
        Preconditions.checkArgument(i7 > 0, "Invalid channel count: " + i7);
        if (i6 == 2) {
            return i7 * 2;
        }
        if (i6 == 3) {
            return i7;
        }
        if (i6 != 4) {
            if (i6 == 21) {
                return i7 * 3;
            }
            if (i6 != 22) {
                throw new IllegalArgumentException("Invalid audio encoding: " + i6);
            }
        }
        return i7 * 4;
    }

    private AudioUtils() {
    }
}
