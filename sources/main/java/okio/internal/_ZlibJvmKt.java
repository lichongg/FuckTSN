package okio.internal;

import java.util.GregorianCalendar;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class _ZlibJvmKt {
    private static final int DEFAULT_COMPRESSION = -1;

    @NotNull
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    public static final long datePartsToEpochMillis(int i6, int i7, int i8, int i9, int i10, int i11) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(i6, i7 - 1, i8, i9, i10, i11);
        return gregorianCalendar.getTime().getTime();
    }

    public static final int getDEFAULT_COMPRESSION() {
        return DEFAULT_COMPRESSION;
    }

    @NotNull
    public static final byte[] getEMPTY_BYTE_ARRAY() {
        return EMPTY_BYTE_ARRAY;
    }
}
