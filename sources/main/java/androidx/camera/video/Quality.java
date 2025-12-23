package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class Quality {
    public static final Quality FHD;
    public static final Quality HD;
    public static final Quality HIGHEST;
    public static final Quality LOWEST;
    static final Quality NONE;
    private static final Set<Quality> QUALITIES;
    private static final List<Quality> QUALITIES_ORDER_BY_SIZE;
    public static final Quality SD;
    public static final Quality UHD;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    static abstract class ConstantQuality extends Quality {
        ConstantQuality() {
            super();
        }

        @NonNull
        abstract String getName();

        abstract int getValue();

        @NonNull
        static ConstantQuality of(int i6, @NonNull String str) {
            return new AutoValue_Quality_ConstantQuality(i6, str);
        }
    }

    static {
        ConstantQuality of = ConstantQuality.of(4, "SD");
        SD = of;
        ConstantQuality of2 = ConstantQuality.of(5, "HD");
        HD = of2;
        ConstantQuality of3 = ConstantQuality.of(6, "FHD");
        FHD = of3;
        ConstantQuality of4 = ConstantQuality.of(8, "UHD");
        UHD = of4;
        ConstantQuality of5 = ConstantQuality.of(0, "LOWEST");
        LOWEST = of5;
        ConstantQuality of6 = ConstantQuality.of(1, "HIGHEST");
        HIGHEST = of6;
        NONE = ConstantQuality.of(-1, "NONE");
        QUALITIES = new HashSet(Arrays.asList(of5, of6, of, of2, of3, of4));
        QUALITIES_ORDER_BY_SIZE = Arrays.asList(of4, of3, of2, of);
    }

    private Quality() {
    }

    static boolean containsQuality(@NonNull Quality quality) {
        return QUALITIES.contains(quality);
    }

    @NonNull
    static List<Quality> getSortedQualities() {
        return new ArrayList(QUALITIES_ORDER_BY_SIZE);
    }
}
