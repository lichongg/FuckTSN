package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.view.TransformExperimental;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
@TransformExperimental
/* loaded from: D:\Downloads\app\classes.dex */
public final class ImageProxyTransformFactory {
    private boolean mUsingCropRect;
    private boolean mUsingRotationDegrees;

    private RectF getCropRect(@NonNull ImageProxy imageProxy) {
        return this.mUsingCropRect ? new RectF(imageProxy.getCropRect()) : new RectF(0.0f, 0.0f, imageProxy.getWidth(), imageProxy.getHeight());
    }

    private int getRotationDegrees(@NonNull ImageProxy imageProxy) {
        if (this.mUsingRotationDegrees) {
            return imageProxy.getImageInfo().getRotationDegrees();
        }
        return 0;
    }

    public boolean isUsingCropRect() {
        return this.mUsingCropRect;
    }

    public boolean isUsingRotationDegrees() {
        return this.mUsingRotationDegrees;
    }

    public void setUsingCropRect(boolean z5) {
        this.mUsingCropRect = z5;
    }

    public void setUsingRotationDegrees(boolean z5) {
        this.mUsingRotationDegrees = z5;
    }

    static RectF getRotatedCropRect(RectF rectF, int i6) {
        if (TransformUtils.is90or270(i6)) {
            return new RectF(0.0f, 0.0f, rectF.height(), rectF.width());
        }
        return new RectF(0.0f, 0.0f, rectF.width(), rectF.height());
    }

    @NonNull
    public OutputTransform getOutputTransform(@NonNull ImageProxy imageProxy) {
        int rotationDegrees = getRotationDegrees(imageProxy);
        RectF cropRect = getCropRect(imageProxy);
        Matrix rectToRect = TransformUtils.getRectToRect(cropRect, getRotatedCropRect(cropRect, rotationDegrees), rotationDegrees);
        rectToRect.preConcat(TransformUtils.getNormalizedToBuffer(imageProxy.getCropRect()));
        return new OutputTransform(rectToRect, TransformUtils.rectToSize(imageProxy.getCropRect()));
    }
}
