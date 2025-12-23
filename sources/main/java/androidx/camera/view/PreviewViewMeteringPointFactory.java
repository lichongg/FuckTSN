package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Size;
import androidx.annotation.AnyThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.impl.utils.Threads;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
class PreviewViewMeteringPointFactory extends MeteringPointFactory {
    static final PointF INVALID_POINT = new PointF(2.0f, 2.0f);

    @Nullable
    @GuardedBy("this")
    private Matrix mMatrix;

    @NonNull
    private final PreviewTransformation mPreviewTransformation;

    @Override // androidx.camera.core.MeteringPointFactory
    @NonNull
    @AnyThread
    protected PointF convertPoint(float f6, float f7) {
        float[] fArr = {f6, f7};
        synchronized (this) {
            try {
                Matrix matrix = this.mMatrix;
                if (matrix == null) {
                    return INVALID_POINT;
                }
                matrix.mapPoints(fArr);
                return new PointF(fArr[0], fArr[1]);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    PreviewViewMeteringPointFactory(@NonNull PreviewTransformation previewTransformation) {
        this.mPreviewTransformation = previewTransformation;
    }

    @UiThread
    void recalculate(@NonNull Size size, int i6) {
        Threads.checkMainThread();
        synchronized (this) {
            try {
                if (size.getWidth() != 0 && size.getHeight() != 0) {
                    this.mMatrix = this.mPreviewTransformation.getPreviewViewToNormalizedSurfaceMatrix(size, i6);
                    return;
                }
                this.mMatrix = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
