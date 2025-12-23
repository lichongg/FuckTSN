package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import com.huawei.hms.common.util.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class TargetUtils {
    public static int getNumberOfTargets(int i6) {
        int i7 = 0;
        while (i6 != 0) {
            i7 += i6 & 1;
            i6 >>= 1;
        }
        return i7;
    }

    public static boolean isSuperset(int i6, int i7) {
        return (i6 & i7) == i7;
    }

    @NonNull
    public static String getHumanReadableName(int i6) {
        ArrayList arrayList = new ArrayList();
        if ((i6 & 4) != 0) {
            arrayList.add("IMAGE_CAPTURE");
        }
        if ((i6 & 1) != 0) {
            arrayList.add("PREVIEW");
        }
        if ((i6 & 2) != 0) {
            arrayList.add("VIDEO_CAPTURE");
        }
        return j0.a(Logger.f33116c, arrayList);
    }

    @NonNull
    private static String getHumanReadableNames(@NonNull Collection<Integer> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(getHumanReadableName(it.next().intValue()));
        }
        return "[" + j0.a(", ", arrayList) + "]";
    }

    private TargetUtils() {
    }

    public static void checkSupportedTargets(@NonNull Collection<Integer> collection, int i6) {
        Preconditions.checkArgument(collection.contains(Integer.valueOf(i6)), String.format(Locale.US, "Effects target %s is not in the supported list %s.", getHumanReadableName(i6), getHumanReadableNames(collection)));
    }
}
