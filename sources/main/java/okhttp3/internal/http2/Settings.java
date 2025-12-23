package okhttp3.internal.http2;

import kotlin.collections.n;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Settings {
    public static final int COUNT = 10;

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    public static final int ENABLE_PUSH = 2;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 4;
    public static final int MAX_CONCURRENT_STREAMS = 3;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;

    @NotNull
    private final int[] values = new int[10];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }
    }

    public final void clear() {
        this.set = 0;
        n.T1(this.values, 0, 0, 0, 6, null);
    }

    public final boolean isSet(int i6) {
        return ((1 << i6) & this.set) != 0;
    }

    public final int get(int i6) {
        return this.values[i6];
    }

    public final boolean getEnablePush(boolean z5) {
        return (this.set & 4) != 0 ? this.values[2] == 1 : z5;
    }

    public final int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    public final int getInitialWindowSize() {
        if ((this.set & 16) != 0) {
            return this.values[4];
        }
        return 65535;
    }

    public final int getMaxConcurrentStreams() {
        if ((this.set & 8) != 0) {
            return this.values[3];
        }
        return Integer.MAX_VALUE;
    }

    public final int getMaxFrameSize(int i6) {
        return (this.set & 32) != 0 ? this.values[5] : i6;
    }

    public final int getMaxHeaderListSize(int i6) {
        return (this.set & 64) != 0 ? this.values[6] : i6;
    }

    public final void merge(@NotNull Settings other) {
        g0.p(other, "other");
        for (int i6 = 0; i6 < 10; i6++) {
            if (other.isSet(i6)) {
                set(i6, other.get(i6));
            }
        }
    }

    @NotNull
    public final Settings set(int i6, int i7) {
        if (i6 >= 0) {
            int[] iArr = this.values;
            if (i6 < iArr.length) {
                this.set = (1 << i6) | this.set;
                iArr[i6] = i7;
            }
        }
        return this;
    }

    public final int size() {
        return Integer.bitCount(this.set);
    }
}
