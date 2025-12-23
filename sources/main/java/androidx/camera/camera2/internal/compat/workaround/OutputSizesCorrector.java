package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;
import androidx.camera.core.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class OutputSizesCorrector {
    private static final String TAG = "OutputSizesCorrector";
    private final String mCameraId;
    private final ExcludedSupportedSizesContainer mExcludedSupportedSizesContainer;
    private final ExtraSupportedOutputSizeQuirk mExtraSupportedOutputSizeQuirk = (ExtraSupportedOutputSizeQuirk) DeviceQuirks.get(ExtraSupportedOutputSizeQuirk.class);

    @NonNull
    public Size[] applyQuirks(@NonNull Size[] sizeArr, int i6) {
        ArrayList arrayList = new ArrayList(Arrays.asList(sizeArr));
        addExtraSupportedOutputSizesByFormat(arrayList, i6);
        excludeProblematicOutputSizesByFormat(arrayList, i6);
        if (arrayList.isEmpty()) {
            Logger.w(TAG, "Sizes array becomes empty after excluding problematic output sizes.");
        }
        return (Size[]) arrayList.toArray(new Size[0]);
    }

    private void addExtraSupportedOutputSizesByClass(@NonNull List<Size> list, @NonNull Class<?> cls) {
        ExtraSupportedOutputSizeQuirk extraSupportedOutputSizeQuirk = this.mExtraSupportedOutputSizeQuirk;
        if (extraSupportedOutputSizeQuirk == null) {
            return;
        }
        Size[] extraSupportedResolutions = extraSupportedOutputSizeQuirk.getExtraSupportedResolutions(cls);
        if (extraSupportedResolutions.length > 0) {
            list.addAll(Arrays.asList(extraSupportedResolutions));
        }
    }

    private void addExtraSupportedOutputSizesByFormat(@NonNull List<Size> list, int i6) {
        ExtraSupportedOutputSizeQuirk extraSupportedOutputSizeQuirk = this.mExtraSupportedOutputSizeQuirk;
        if (extraSupportedOutputSizeQuirk == null) {
            return;
        }
        Size[] extraSupportedResolutions = extraSupportedOutputSizeQuirk.getExtraSupportedResolutions(i6);
        if (extraSupportedResolutions.length > 0) {
            list.addAll(Arrays.asList(extraSupportedResolutions));
        }
    }

    private void excludeProblematicOutputSizesByClass(@NonNull List<Size> list, @NonNull Class<?> cls) {
        List<Size> list2 = this.mExcludedSupportedSizesContainer.get(cls);
        if (list2.isEmpty()) {
            return;
        }
        list.removeAll(list2);
    }

    private void excludeProblematicOutputSizesByFormat(@NonNull List<Size> list, int i6) {
        List<Size> list2 = this.mExcludedSupportedSizesContainer.get(i6);
        if (list2.isEmpty()) {
            return;
        }
        list.removeAll(list2);
    }

    public OutputSizesCorrector(@NonNull String str) {
        this.mCameraId = str;
        this.mExcludedSupportedSizesContainer = new ExcludedSupportedSizesContainer(str);
    }

    @NonNull
    public <T> Size[] applyQuirks(@NonNull Size[] sizeArr, @NonNull Class<T> cls) {
        List<Size> arrayList = new ArrayList<>(Arrays.asList(sizeArr));
        addExtraSupportedOutputSizesByClass(arrayList, cls);
        excludeProblematicOutputSizesByClass(arrayList, cls);
        if (arrayList.isEmpty()) {
            Logger.w(TAG, "Sizes array becomes empty after excluding problematic output sizes.");
        }
        return (Size[]) arrayList.toArray(new Size[0]);
    }
}
