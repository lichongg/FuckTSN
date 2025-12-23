package androidx.camera.core;

import android.media.Image;
import android.media.ImageReader;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
class AndroidImageReaderProxy implements ImageReaderProxy {

    @GuardedBy("mLock")
    private final ImageReader mImageReader;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private boolean mIsImageAvailableListenerCleared = true;

    public static /* synthetic */ void a(final AndroidImageReaderProxy androidImageReaderProxy, Executor executor, final ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, ImageReader imageReader) {
        synchronized (androidImageReaderProxy.mLock) {
            try {
                if (!androidImageReaderProxy.mIsImageAvailableListenerCleared) {
                    executor.execute(new Runnable() { // from class: androidx.camera.core.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            AndroidImageReaderProxy.b(AndroidImageReaderProxy.this, onImageAvailableListener);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean isImageReaderContextNotInitializedException(RuntimeException runtimeException) {
        return "ImageReaderContext is not initialized".equals(runtimeException.getMessage());
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireLatestImage() {
        Image image;
        synchronized (this.mLock) {
            try {
                image = this.mImageReader.acquireLatestImage();
            } catch (RuntimeException e6) {
                if (!isImageReaderContextNotInitializedException(e6)) {
                    throw e6;
                }
                image = null;
            }
            if (image == null) {
                return null;
            }
            return new AndroidImageProxy(image);
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireNextImage() {
        Image image;
        synchronized (this.mLock) {
            try {
                image = this.mImageReader.acquireNextImage();
            } catch (RuntimeException e6) {
                if (!isImageReaderContextNotInitializedException(e6)) {
                    throw e6;
                }
                image = null;
            }
            if (image == null) {
                return null;
            }
            return new AndroidImageProxy(image);
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void clearOnImageAvailableListener() {
        synchronized (this.mLock) {
            this.mIsImageAvailableListenerCleared = true;
            this.mImageReader.setOnImageAvailableListener(null, null);
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        synchronized (this.mLock) {
            this.mImageReader.close();
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        int height;
        synchronized (this.mLock) {
            height = this.mImageReader.getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getImageFormat() {
        int imageFormat;
        synchronized (this.mLock) {
            imageFormat = this.mImageReader.getImageFormat();
        }
        return imageFormat;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getMaxImages() {
        int maxImages;
        synchronized (this.mLock) {
            maxImages = this.mImageReader.getMaxImages();
        }
        return maxImages;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public Surface getSurface() {
        Surface surface;
        synchronized (this.mLock) {
            surface = this.mImageReader.getSurface();
        }
        return surface;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        int width;
        synchronized (this.mLock) {
            width = this.mImageReader.getWidth();
        }
        return width;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(@NonNull final ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @NonNull final Executor executor) {
        synchronized (this.mLock) {
            this.mIsImageAvailableListenerCleared = false;
            this.mImageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: androidx.camera.core.b
                @Override // android.media.ImageReader.OnImageAvailableListener
                public final void onImageAvailable(ImageReader imageReader) {
                    AndroidImageReaderProxy.a(AndroidImageReaderProxy.this, executor, onImageAvailableListener, imageReader);
                }
            }, MainThreadAsyncHandler.getInstance());
        }
    }

    AndroidImageReaderProxy(ImageReader imageReader) {
        this.mImageReader = imageReader;
    }

    public static /* synthetic */ void b(AndroidImageReaderProxy androidImageReaderProxy, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        androidImageReaderProxy.getClass();
        onImageAvailableListener.onImageAvailable(androidImageReaderProxy);
    }
}
