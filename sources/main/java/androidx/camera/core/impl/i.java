package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class i {
    @NonNull
    public static CameraSelector a(final CameraInfoInternal cameraInfoInternal) {
        return new CameraSelector.Builder().addCameraFilter(new CameraFilter() { // from class: androidx.camera.core.impl.h
            @Override // androidx.camera.core.CameraFilter
            public final List filter(List list) {
                return i.c(CameraInfoInternal.this, list);
            }

            @Override // androidx.camera.core.CameraFilter
            public /* synthetic */ Identifier getIdentifier() {
                return androidx.camera.core.e.a(this);
            }
        }).addCameraFilter(new LensFacingCameraFilter(cameraInfoInternal.getLensFacing())).build();
    }

    public static /* synthetic */ List c(CameraInfoInternal cameraInfoInternal, List list) {
        String cameraId = cameraInfoInternal.getCameraId();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CameraInfo cameraInfo = (CameraInfo) it.next();
            Preconditions.checkArgument(cameraInfo instanceof CameraInfoInternal);
            if (((CameraInfoInternal) cameraInfo).getCameraId().equals(cameraId)) {
                return Collections.singletonList(cameraInfo);
            }
        }
        throw new IllegalStateException("Unable to find camera with id " + cameraId + " from list of available cameras.");
    }

    @NonNull
    public static CameraInfoInternal b(CameraInfoInternal cameraInfoInternal) {
        return cameraInfoInternal;
    }
}
