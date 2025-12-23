package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.view.TransformExperimental;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
@TransformExperimental
/* loaded from: D:\Downloads\app\classes.dex */
public final class OutputTransform {

    @NonNull
    final Matrix mMatrix;

    @NonNull
    final Size mViewPortSize;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Matrix getMatrix() {
        return this.mMatrix;
    }

    @NonNull
    Size getViewPortSize() {
        return this.mViewPortSize;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public OutputTransform(@NonNull Matrix matrix, @NonNull Size size) {
        this.mMatrix = matrix;
        this.mViewPortSize = size;
    }
}
