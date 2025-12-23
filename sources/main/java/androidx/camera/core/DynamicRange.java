package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class DynamicRange {
    public static final int BIT_DEPTH_10_BIT = 10;
    public static final int BIT_DEPTH_8_BIT = 8;
    public static final int BIT_DEPTH_UNSPECIFIED = 0;
    public static final int ENCODING_DOLBY_VISION = 6;
    public static final int ENCODING_HDR10 = 4;
    public static final int ENCODING_HDR10_PLUS = 5;
    public static final int ENCODING_HDR_UNSPECIFIED = 2;
    public static final int ENCODING_HLG = 3;
    public static final int ENCODING_SDR = 1;
    public static final int ENCODING_UNSPECIFIED = 0;
    private final int mBitDepth;
    private final int mEncoding;

    @NonNull
    public static final DynamicRange UNSPECIFIED = new DynamicRange(0, 0);

    @NonNull
    public static final DynamicRange SDR = new DynamicRange(1, 8);

    @NonNull
    public static final DynamicRange HDR_UNSPECIFIED_10_BIT = new DynamicRange(2, 10);

    @NonNull
    public static final DynamicRange HLG_10_BIT = new DynamicRange(3, 10);

    @NonNull
    public static final DynamicRange HDR10_10_BIT = new DynamicRange(4, 10);

    @NonNull
    public static final DynamicRange HDR10_PLUS_10_BIT = new DynamicRange(5, 10);

    @NonNull
    public static final DynamicRange DOLBY_VISION_10_BIT = new DynamicRange(6, 10);

    @NonNull
    public static final DynamicRange DOLBY_VISION_8_BIT = new DynamicRange(6, 8);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface BitDepth {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface DynamicRangeEncoding {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DynamicRange) {
            DynamicRange dynamicRange = (DynamicRange) obj;
            if (this.mEncoding == dynamicRange.getEncoding() && this.mBitDepth == dynamicRange.getBitDepth()) {
                return true;
            }
        }
        return false;
    }

    public int getBitDepth() {
        return this.mBitDepth;
    }

    public int getEncoding() {
        return this.mEncoding;
    }

    public int hashCode() {
        return ((this.mEncoding ^ 1000003) * 1000003) ^ this.mBitDepth;
    }

    @NonNull
    public String toString() {
        return "DynamicRange@" + Integer.toHexString(System.identityHashCode(this)) + "{encoding=" + getEncodingLabel(this.mEncoding) + ", bitDepth=" + this.mBitDepth + "}";
    }

    public DynamicRange(int i6, int i7) {
        this.mEncoding = i6;
        this.mBitDepth = i7;
    }

    @NonNull
    private static String getEncodingLabel(int i6) {
        switch (i6) {
            case 0:
                return "UNSPECIFIED";
            case 1:
                return "SDR";
            case 2:
                return "HDR_UNSPECIFIED";
            case 3:
                return "HLG";
            case 4:
                return "HDR10";
            case 5:
                return "HDR10_PLUS";
            case 6:
                return "DOLBY_VISION";
            default:
                return "<Unknown>";
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean is10BitHdr() {
        if (isFullySpecified() && getEncoding() != 1 && getBitDepth() == 10) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isFullySpecified() {
        if (getEncoding() != 0 && getEncoding() != 2 && getBitDepth() != 0) {
            return true;
        }
        return false;
    }
}
