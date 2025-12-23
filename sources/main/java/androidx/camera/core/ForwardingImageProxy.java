package androidx.camera.core;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.Image;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.ImageProxy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class ForwardingImageProxy implements ImageProxy {
    protected final ImageProxy mImage;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private final Set<OnImageCloseListener> mOnImageCloseListeners = new HashSet();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnImageCloseListener {
        void onImageClose(@NonNull ImageProxy imageProxy);
    }

    public void addOnImageCloseListener(@NonNull OnImageCloseListener onImageCloseListener) {
        synchronized (this.mLock) {
            this.mOnImageCloseListeners.add(onImageCloseListener);
        }
    }

    @Override // androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public void close() {
        this.mImage.close();
        notifyOnImageCloseListeners();
    }

    @Override // androidx.camera.core.ImageProxy
    @NonNull
    public Rect getCropRect() {
        return this.mImage.getCropRect();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getFormat() {
        return this.mImage.getFormat();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getHeight() {
        return this.mImage.getHeight();
    }

    @Override // androidx.camera.core.ImageProxy
    @Nullable
    @ExperimentalGetImage
    public Image getImage() {
        return this.mImage.getImage();
    }

    @Override // androidx.camera.core.ImageProxy
    @NonNull
    public ImageInfo getImageInfo() {
        return this.mImage.getImageInfo();
    }

    @Override // androidx.camera.core.ImageProxy
    @NonNull
    public ImageProxy.PlaneProxy[] getPlanes() {
        return this.mImage.getPlanes();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getWidth() {
        return this.mImage.getWidth();
    }

    protected void notifyOnImageCloseListeners() {
        HashSet hashSet;
        synchronized (this.mLock) {
            hashSet = new HashSet(this.mOnImageCloseListeners);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((OnImageCloseListener) it.next()).onImageClose(this);
        }
    }

    @Override // androidx.camera.core.ImageProxy
    public void setCropRect(@Nullable Rect rect) {
        this.mImage.setCropRect(rect);
    }

    protected ForwardingImageProxy(@NonNull ImageProxy imageProxy) {
        this.mImage = imageProxy;
    }

    @Override // androidx.camera.core.ImageProxy
    public /* synthetic */ Bitmap toBitmap() {
        return f0.a(this);
    }
}
