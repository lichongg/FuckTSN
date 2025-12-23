package androidx.camera.core.impl;

import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraFilter;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class CameraFilters {
    public static final CameraFilter ANY = new CameraFilter() { // from class: androidx.camera.core.impl.f
        @Override // androidx.camera.core.CameraFilter
        public final List filter(List list) {
            return CameraFilters.a(list);
        }

        @Override // androidx.camera.core.CameraFilter
        public /* synthetic */ Identifier getIdentifier() {
            return androidx.camera.core.e.a(this);
        }
    };
    public static final CameraFilter NONE = new CameraFilter() { // from class: androidx.camera.core.impl.g
        @Override // androidx.camera.core.CameraFilter
        public final List filter(List list) {
            List list2;
            list2 = Collections.EMPTY_LIST;
            return list2;
        }

        @Override // androidx.camera.core.CameraFilter
        public /* synthetic */ Identifier getIdentifier() {
            return androidx.camera.core.e.a(this);
        }
    };

    private CameraFilters() {
    }

    public static /* synthetic */ List a(List list) {
        return list;
    }
}
