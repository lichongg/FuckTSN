package androidx.camera.core;

import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class SafeCloseImageReaderProxy implements ImageReaderProxy {
    private ForwardingImageProxy.OnImageCloseListener mForwardingImageCloseListener;

    @GuardedBy("mLock")
    private final ImageReaderProxy mImageReaderProxy;

    @Nullable
    private final Surface mSurface;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private int mOutstandingImages = 0;

    @GuardedBy("mLock")
    private boolean mIsClosed = false;
    private final ForwardingImageProxy.OnImageCloseListener mImageCloseListener = new ForwardingImageProxy.OnImageCloseListener() { // from class: androidx.camera.core.q0
        @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
        public final void onImageClose(ImageProxy imageProxy) {
            SafeCloseImageReaderProxy.b(SafeCloseImageReaderProxy.this, imageProxy);
        }
    };

    public static /* synthetic */ void b(SafeCloseImageReaderProxy safeCloseImageReaderProxy, ImageProxy imageProxy) {
        ForwardingImageProxy.OnImageCloseListener onImageCloseListener;
        synchronized (safeCloseImageReaderProxy.mLock) {
            try {
                int i6 = safeCloseImageReaderProxy.mOutstandingImages - 1;
                safeCloseImageReaderProxy.mOutstandingImages = i6;
                if (safeCloseImageReaderProxy.mIsClosed && i6 == 0) {
                    safeCloseImageReaderProxy.close();
                }
                onImageCloseListener = safeCloseImageReaderProxy.mForwardingImageCloseListener;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (onImageCloseListener != null) {
            onImageCloseListener.onImageClose(imageProxy);
        }
    }

    @Nullable
    @GuardedBy("mLock")
    private ImageProxy wrapImageProxy(@Nullable ImageProxy imageProxy) {
        if (imageProxy == null) {
            return null;
        }
        this.mOutstandingImages++;
        SingleCloseImageProxy singleCloseImageProxy = new SingleCloseImageProxy(imageProxy);
        singleCloseImageProxy.addOnImageCloseListener(this.mImageCloseListener);
        return singleCloseImageProxy;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireLatestImage() {
        ImageProxy wrapImageProxy;
        synchronized (this.mLock) {
            wrapImageProxy = wrapImageProxy(this.mImageReaderProxy.acquireLatestImage());
        }
        return wrapImageProxy;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireNextImage() {
        ImageProxy wrapImageProxy;
        synchronized (this.mLock) {
            wrapImageProxy = wrapImageProxy(this.mImageReaderProxy.acquireNextImage());
        }
        return wrapImageProxy;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void clearOnImageAvailableListener() {
        synchronized (this.mLock) {
            this.mImageReaderProxy.clearOnImageAvailableListener();
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        synchronized (this.mLock) {
            try {
                Surface surface = this.mSurface;
                if (surface != null) {
                    surface.release();
                }
                this.mImageReaderProxy.close();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getCapacity() {
        int maxImages;
        synchronized (this.mLock) {
            maxImages = this.mImageReaderProxy.getMaxImages() - this.mOutstandingImages;
        }
        return maxImages;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        int height;
        synchronized (this.mLock) {
            height = this.mImageReaderProxy.getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getImageFormat() {
        int imageFormat;
        synchronized (this.mLock) {
            imageFormat = this.mImageReaderProxy.getImageFormat();
        }
        return imageFormat;
    }

    @NonNull
    @VisibleForTesting
    public ImageReaderProxy getImageReaderProxy() {
        ImageReaderProxy imageReaderProxy;
        synchronized (this.mLock) {
            imageReaderProxy = this.mImageReaderProxy;
        }
        return imageReaderProxy;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getMaxImages() {
        int maxImages;
        synchronized (this.mLock) {
            maxImages = this.mImageReaderProxy.getMaxImages();
        }
        return maxImages;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public Surface getSurface() {
        Surface surface;
        synchronized (this.mLock) {
            surface = this.mImageReaderProxy.getSurface();
        }
        return surface;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        int width;
        synchronized (this.mLock) {
            width = this.mImageReaderProxy.getWidth();
        }
        return width;
    }

    @VisibleForTesting
    public boolean isClosed() {
        boolean z5;
        synchronized (this.mLock) {
            z5 = this.mIsClosed;
        }
        return z5;
    }

    public void safeClose() {
        synchronized (this.mLock) {
            try {
                this.mIsClosed = true;
                this.mImageReaderProxy.clearOnImageAvailableListener();
                if (this.mOutstandingImages == 0) {
                    close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(@NonNull final ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @NonNull Executor executor) {
        synchronized (this.mLock) {
            this.mImageReaderProxy.setOnImageAvailableListener(new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.p0
                @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
                public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                    SafeCloseImageReaderProxy.a(SafeCloseImageReaderProxy.this, onImageAvailableListener, imageReaderProxy);
                }
            }, executor);
        }
    }

    public void setOnImageCloseListener(@NonNull ForwardingImageProxy.OnImageCloseListener onImageCloseListener) {
        synchronized (this.mLock) {
            this.mForwardingImageCloseListener = onImageCloseListener;
        }
    }

    public SafeCloseImageReaderProxy(@NonNull ImageReaderProxy imageReaderProxy) {
        this.mImageReaderProxy = imageReaderProxy;
        this.mSurface = imageReaderProxy.getSurface();
    }

    public static /* synthetic */ void a(SafeCloseImageReaderProxy safeCloseImageReaderProxy, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, ImageReaderProxy imageReaderProxy) {
        safeCloseImageReaderProxy.getClass();
        onImageAvailableListener.onImageAvailable(safeCloseImageReaderProxy);
    }
}
