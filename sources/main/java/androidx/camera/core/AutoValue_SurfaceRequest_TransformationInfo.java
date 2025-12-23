package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.core.SurfaceRequest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_SurfaceRequest_TransformationInfo extends SurfaceRequest.TransformationInfo {
    private final Rect getCropRect;
    private final boolean getMirroring;
    private final int getRotationDegrees;
    private final Matrix getSensorToBufferTransform;
    private final int getTargetRotation;
    private final boolean hasCameraTransform;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SurfaceRequest.TransformationInfo) {
            SurfaceRequest.TransformationInfo transformationInfo = (SurfaceRequest.TransformationInfo) obj;
            if (this.getCropRect.equals(transformationInfo.getCropRect()) && this.getRotationDegrees == transformationInfo.getRotationDegrees() && this.getTargetRotation == transformationInfo.getTargetRotation() && this.hasCameraTransform == transformationInfo.hasCameraTransform() && this.getSensorToBufferTransform.equals(transformationInfo.getSensorToBufferTransform()) && this.getMirroring == transformationInfo.getMirroring()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    @NonNull
    public Rect getCropRect() {
        return this.getCropRect;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean getMirroring() {
        return this.getMirroring;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    public int getRotationDegrees() {
        return this.getRotationDegrees;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Matrix getSensorToBufferTransform() {
        return this.getSensorToBufferTransform;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getTargetRotation() {
        return this.getTargetRotation;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean hasCameraTransform() {
        return this.hasCameraTransform;
    }

    public int hashCode() {
        return ((((((((((this.getCropRect.hashCode() ^ 1000003) * 1000003) ^ this.getRotationDegrees) * 1000003) ^ this.getTargetRotation) * 1000003) ^ (this.hasCameraTransform ? 1231 : 1237)) * 1000003) ^ this.getSensorToBufferTransform.hashCode()) * 1000003) ^ (this.getMirroring ? 1231 : 1237);
    }

    public String toString() {
        return "TransformationInfo{getCropRect=" + this.getCropRect + ", getRotationDegrees=" + this.getRotationDegrees + ", getTargetRotation=" + this.getTargetRotation + ", hasCameraTransform=" + this.hasCameraTransform + ", getSensorToBufferTransform=" + this.getSensorToBufferTransform + ", getMirroring=" + this.getMirroring + "}";
    }

    AutoValue_SurfaceRequest_TransformationInfo(Rect rect, int i6, int i7, boolean z5, Matrix matrix, boolean z6) {
        if (rect != null) {
            this.getCropRect = rect;
            this.getRotationDegrees = i6;
            this.getTargetRotation = i7;
            this.hasCameraTransform = z5;
            if (matrix != null) {
                this.getSensorToBufferTransform = matrix;
                this.getMirroring = z6;
                return;
            }
            throw new NullPointerException("Null getSensorToBufferTransform");
        }
        throw new NullPointerException("Null getCropRect");
    }
}
