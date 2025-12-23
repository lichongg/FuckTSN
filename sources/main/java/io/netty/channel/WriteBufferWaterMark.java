package io.netty.channel;

import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class WriteBufferWaterMark {
    public static final WriteBufferWaterMark DEFAULT = new WriteBufferWaterMark(32768, 65536, false);
    private static final int DEFAULT_HIGH_WATER_MARK = 65536;
    private static final int DEFAULT_LOW_WATER_MARK = 32768;
    private final int high;
    private final int low;

    public WriteBufferWaterMark(int i6, int i7) {
        this(i6, i7, true);
    }

    WriteBufferWaterMark(int i6, int i7, boolean z5) {
        if (z5) {
            ObjectUtil.checkPositiveOrZero(i6, "low");
            if (i7 < i6) {
                throw new IllegalArgumentException("write buffer's high water mark cannot be less than  low water mark (" + i6 + "): " + i7);
            }
        }
        this.low = i6;
        this.high = i7;
    }

    public int high() {
        return this.high;
    }

    public int low() {
        return this.low;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(55);
        sb.append("WriteBufferWaterMark(low: ");
        sb.append(this.low);
        sb.append(", high: ");
        sb.append(this.high);
        sb.append(")");
        return sb.toString();
    }
}
