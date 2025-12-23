package androidx.camera.view;

import android.graphics.Bitmap;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
abstract class PreviewViewImplementation {

    @NonNull
    FrameLayout mParent;

    @NonNull
    private final PreviewTransformation mPreviewTransform;

    @Nullable
    Size mResolution;
    private boolean mWasSurfaceProvided = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface OnSurfaceNotInUseListener {
        void onSurfaceNotInUse();
    }

    @Nullable
    abstract View getPreview();

    @Nullable
    abstract Bitmap getPreviewBitmap();

    abstract void initializePreview();

    abstract void onAttachedToWindow();

    abstract void onDetachedFromWindow();

    void onSurfaceProvided() {
        this.mWasSurfaceProvided = true;
        redrawPreview();
    }

    abstract void onSurfaceRequested(@NonNull SurfaceRequest surfaceRequest, @Nullable OnSurfaceNotInUseListener onSurfaceNotInUseListener);

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public abstract ListenableFuture<Void> waitForNextFrame();

    PreviewViewImplementation(@NonNull FrameLayout frameLayout, @NonNull PreviewTransformation previewTransformation) {
        this.mParent = frameLayout;
        this.mPreviewTransform = previewTransformation;
    }

    @Nullable
    Bitmap getBitmap() {
        Bitmap previewBitmap = getPreviewBitmap();
        if (previewBitmap == null) {
            return null;
        }
        return this.mPreviewTransform.createTransformedBitmap(previewBitmap, new Size(this.mParent.getWidth(), this.mParent.getHeight()), this.mParent.getLayoutDirection());
    }

    void redrawPreview() {
        View preview = getPreview();
        if (preview != null && this.mWasSurfaceProvided) {
            this.mPreviewTransform.transformView(new Size(this.mParent.getWidth(), this.mParent.getHeight()), this.mParent.getLayoutDirection(), preview);
        }
    }

    void setFrameUpdateListener(@NonNull Executor executor, @NonNull PreviewView.OnFrameUpdateListener onFrameUpdateListener) {
    }
}
