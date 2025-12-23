package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class LensFacingCameraFilter implements CameraFilter {
    private final int mLensFacing;

    @Override // androidx.camera.core.CameraFilter
    @NonNull
    public List<CameraInfo> filter(@NonNull List<CameraInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (CameraInfo cameraInfo : list) {
            Preconditions.checkArgument(cameraInfo instanceof CameraInfoInternal, "The camera info doesn't contain internal implementation.");
            if (cameraInfo.getLensFacing() == this.mLensFacing) {
                arrayList.add(cameraInfo);
            }
        }
        return arrayList;
    }

    public int getLensFacing() {
        return this.mLensFacing;
    }

    public LensFacingCameraFilter(int i6) {
        this.mLensFacing = i6;
    }

    @Override // androidx.camera.core.CameraFilter
    public /* synthetic */ Identifier getIdentifier() {
        return androidx.camera.core.e.a(this);
    }
}
