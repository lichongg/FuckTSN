package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(29)
/* loaded from: D:\Downloads\app\classes.dex */
class ViewUtilsApi29 extends ViewUtilsApi23 {
    ViewUtilsApi29() {
    }

    @Override // androidx.transition.ViewUtilsApi19, androidx.transition.ViewUtilsBase
    public float getTransitionAlpha(@NonNull View view) {
        float transitionAlpha;
        transitionAlpha = view.getTransitionAlpha();
        return transitionAlpha;
    }

    @Override // androidx.transition.ViewUtilsApi21, androidx.transition.ViewUtilsBase
    public void setAnimationMatrix(@NonNull View view, @Nullable Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    @Override // androidx.transition.ViewUtilsApi22, androidx.transition.ViewUtilsBase
    public void setLeftTopRightBottom(@NonNull View view, int i6, int i7, int i8, int i9) {
        view.setLeftTopRightBottom(i6, i7, i8, i9);
    }

    @Override // androidx.transition.ViewUtilsApi19, androidx.transition.ViewUtilsBase
    public void setTransitionAlpha(@NonNull View view, float f6) {
        view.setTransitionAlpha(f6);
    }

    @Override // androidx.transition.ViewUtilsApi23, androidx.transition.ViewUtilsBase
    public void setTransitionVisibility(@NonNull View view, int i6) {
        view.setTransitionVisibility(i6);
    }

    @Override // androidx.transition.ViewUtilsApi21, androidx.transition.ViewUtilsBase
    public void transformMatrixToGlobal(@NonNull View view, @NonNull Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // androidx.transition.ViewUtilsApi21, androidx.transition.ViewUtilsBase
    public void transformMatrixToLocal(@NonNull View view, @NonNull Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
