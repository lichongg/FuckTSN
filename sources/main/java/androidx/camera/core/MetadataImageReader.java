package androidx.camera.core;

import android.media.ImageReader;
import android.util.LongSparseArray;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class MetadataImageReader implements ImageReaderProxy, ForwardingImageProxy.OnImageCloseListener {
    private static final String TAG = "MetadataImageReader";

    @GuardedBy("mLock")
    private final List<ImageProxy> mAcquiredImageProxies;
    private CameraCaptureCallback mCameraCaptureCallback;

    @GuardedBy("mLock")
    private boolean mClosed;

    @Nullable
    @GuardedBy("mLock")
    private Executor mExecutor;

    @GuardedBy("mLock")
    private int mImageProxiesIndex;

    @GuardedBy("mLock")
    private final ImageReaderProxy mImageReaderProxy;

    @Nullable
    @GuardedBy("mLock")
    ImageReaderProxy.OnImageAvailableListener mListener;
    private final Object mLock;

    @GuardedBy("mLock")
    private final List<ImageProxy> mMatchedImageProxies;

    @GuardedBy("mLock")
    private final LongSparseArray<ImageInfo> mPendingImageInfos;

    @GuardedBy("mLock")
    private final LongSparseArray<ImageProxy> mPendingImages;
    private ImageReaderProxy.OnImageAvailableListener mTransformedListener;

    @GuardedBy("mLock")
    private int mUnAcquiredAvailableImageCount;

    public MetadataImageReader(int i6, int i7, int i8, int i9) {
        this(createImageReaderProxy(i6, i7, i8, i9));
    }

    MetadataImageReader(@NonNull ImageReaderProxy imageReaderProxy) {
        this.mLock = new Object();
        this.mCameraCaptureCallback = new CameraCaptureCallback() { // from class: androidx.camera.core.MetadataImageReader.1
            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
                super.onCaptureCompleted(cameraCaptureResult);
                MetadataImageReader.this.resultIncoming(cameraCaptureResult);
            }
        };
        this.mUnAcquiredAvailableImageCount = 0;
        this.mTransformedListener = new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.j0
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void onImageAvailable(ImageReaderProxy imageReaderProxy2) {
                MetadataImageReader.b(MetadataImageReader.this, imageReaderProxy2);
            }
        };
        this.mClosed = false;
        this.mPendingImageInfos = new LongSparseArray<>();
        this.mPendingImages = new LongSparseArray<>();
        this.mAcquiredImageProxies = new ArrayList();
        this.mImageReaderProxy = imageReaderProxy;
        this.mImageProxiesIndex = 0;
        this.mMatchedImageProxies = new ArrayList(getMaxImages());
    }

    public static /* synthetic */ void b(MetadataImageReader metadataImageReader, ImageReaderProxy imageReaderProxy) {
        synchronized (metadataImageReader.mLock) {
            metadataImageReader.mUnAcquiredAvailableImageCount++;
        }
        metadataImageReader.imageIncoming(imageReaderProxy);
    }

    private static ImageReaderProxy createImageReaderProxy(int i6, int i7, int i8, int i9) {
        return new AndroidImageReaderProxy(ImageReader.newInstance(i6, i7, i8, i9));
    }

    private void dequeImageProxy(ImageProxy imageProxy) {
        synchronized (this.mLock) {
            try {
                int indexOf = this.mMatchedImageProxies.indexOf(imageProxy);
                if (indexOf >= 0) {
                    this.mMatchedImageProxies.remove(indexOf);
                    int i6 = this.mImageProxiesIndex;
                    if (indexOf <= i6) {
                        this.mImageProxiesIndex = i6 - 1;
                    }
                }
                this.mAcquiredImageProxies.remove(imageProxy);
                if (this.mUnAcquiredAvailableImageCount > 0) {
                    imageIncoming(this.mImageReaderProxy);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void enqueueImageProxy(SettableImageProxy settableImageProxy) {
        final ImageReaderProxy.OnImageAvailableListener onImageAvailableListener;
        Executor executor;
        synchronized (this.mLock) {
            try {
                if (this.mMatchedImageProxies.size() < getMaxImages()) {
                    settableImageProxy.addOnImageCloseListener(this);
                    this.mMatchedImageProxies.add(settableImageProxy);
                    onImageAvailableListener = this.mListener;
                    executor = this.mExecutor;
                } else {
                    Logger.d("TAG", "Maximum image number reached.");
                    settableImageProxy.close();
                    onImageAvailableListener = null;
                    executor = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (onImageAvailableListener != null) {
            if (executor != null) {
                executor.execute(new Runnable() { // from class: androidx.camera.core.k0
                    @Override // java.lang.Runnable
                    public final void run() {
                        MetadataImageReader.a(MetadataImageReader.this, onImageAvailableListener);
                    }
                });
            } else {
                onImageAvailableListener.onImageAvailable(this);
            }
        }
    }

    private void matchImages() {
        synchronized (this.mLock) {
            try {
                for (int size = this.mPendingImageInfos.size() - 1; size >= 0; size--) {
                    ImageInfo valueAt = this.mPendingImageInfos.valueAt(size);
                    long timestamp = valueAt.getTimestamp();
                    ImageProxy imageProxy = this.mPendingImages.get(timestamp);
                    if (imageProxy != null) {
                        this.mPendingImages.remove(timestamp);
                        this.mPendingImageInfos.removeAt(size);
                        enqueueImageProxy(new SettableImageProxy(imageProxy, valueAt));
                    }
                }
                removeStaleData();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void removeStaleData() {
        synchronized (this.mLock) {
            try {
                if (this.mPendingImages.size() != 0 && this.mPendingImageInfos.size() != 0) {
                    long keyAt = this.mPendingImages.keyAt(0);
                    Long valueOf = Long.valueOf(keyAt);
                    long keyAt2 = this.mPendingImageInfos.keyAt(0);
                    Preconditions.checkArgument(!Long.valueOf(keyAt2).equals(valueOf));
                    if (keyAt2 > keyAt) {
                        for (int size = this.mPendingImages.size() - 1; size >= 0; size--) {
                            if (this.mPendingImages.keyAt(size) < keyAt2) {
                                this.mPendingImages.valueAt(size).close();
                                this.mPendingImages.removeAt(size);
                            }
                        }
                    } else {
                        for (int size2 = this.mPendingImageInfos.size() - 1; size2 >= 0; size2--) {
                            if (this.mPendingImageInfos.keyAt(size2) < keyAt) {
                                this.mPendingImageInfos.removeAt(size2);
                            }
                        }
                    }
                }
            } finally {
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireLatestImage() {
        synchronized (this.mLock) {
            try {
                if (this.mMatchedImageProxies.isEmpty()) {
                    return null;
                }
                if (this.mImageProxiesIndex >= this.mMatchedImageProxies.size()) {
                    throw new IllegalStateException("Maximum image number reached.");
                }
                ArrayList arrayList = new ArrayList();
                for (int i6 = 0; i6 < this.mMatchedImageProxies.size() - 1; i6++) {
                    if (!this.mAcquiredImageProxies.contains(this.mMatchedImageProxies.get(i6))) {
                        arrayList.add(this.mMatchedImageProxies.get(i6));
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ImageProxy) it.next()).close();
                }
                int size = this.mMatchedImageProxies.size();
                List<ImageProxy> list = this.mMatchedImageProxies;
                this.mImageProxiesIndex = size;
                ImageProxy imageProxy = list.get(size - 1);
                this.mAcquiredImageProxies.add(imageProxy);
                return imageProxy;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireNextImage() {
        synchronized (this.mLock) {
            try {
                if (this.mMatchedImageProxies.isEmpty()) {
                    return null;
                }
                if (this.mImageProxiesIndex >= this.mMatchedImageProxies.size()) {
                    throw new IllegalStateException("Maximum image number reached.");
                }
                List<ImageProxy> list = this.mMatchedImageProxies;
                int i6 = this.mImageProxiesIndex;
                this.mImageProxiesIndex = i6 + 1;
                ImageProxy imageProxy = list.get(i6);
                this.mAcquiredImageProxies.add(imageProxy);
                return imageProxy;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void clearOnImageAvailableListener() {
        synchronized (this.mLock) {
            this.mImageReaderProxy.clearOnImageAvailableListener();
            this.mListener = null;
            this.mExecutor = null;
            this.mUnAcquiredAvailableImageCount = 0;
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        synchronized (this.mLock) {
            try {
                if (this.mClosed) {
                    return;
                }
                Iterator it = new ArrayList(this.mMatchedImageProxies).iterator();
                while (it.hasNext()) {
                    ((ImageProxy) it.next()).close();
                }
                this.mMatchedImageProxies.clear();
                this.mImageReaderProxy.close();
                this.mClosed = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public CameraCaptureCallback getCameraCaptureCallback() {
        return this.mCameraCaptureCallback;
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

    void imageIncoming(ImageReaderProxy imageReaderProxy) {
        ImageProxy imageProxy;
        synchronized (this.mLock) {
            try {
                if (this.mClosed) {
                    return;
                }
                int size = this.mPendingImages.size() + this.mMatchedImageProxies.size();
                if (size >= imageReaderProxy.getMaxImages()) {
                    Logger.d(TAG, "Skip to acquire the next image because the acquired image count has reached the max images count.");
                    return;
                }
                do {
                    try {
                        imageProxy = imageReaderProxy.acquireNextImage();
                        if (imageProxy != null) {
                            this.mUnAcquiredAvailableImageCount--;
                            size++;
                            this.mPendingImages.put(imageProxy.getImageInfo().getTimestamp(), imageProxy);
                            matchImages();
                        }
                    } catch (IllegalStateException e6) {
                        Logger.d(TAG, "Failed to acquire next image.", e6);
                        imageProxy = null;
                    }
                    if (imageProxy == null || this.mUnAcquiredAvailableImageCount <= 0) {
                        break;
                    }
                } while (size < imageReaderProxy.getMaxImages());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public void onImageClose(@NonNull ImageProxy imageProxy) {
        synchronized (this.mLock) {
            dequeImageProxy(imageProxy);
        }
    }

    void resultIncoming(CameraCaptureResult cameraCaptureResult) {
        synchronized (this.mLock) {
            try {
                if (this.mClosed) {
                    return;
                }
                this.mPendingImageInfos.put(cameraCaptureResult.getTimestamp(), new CameraCaptureResultImageInfo(cameraCaptureResult));
                matchImages();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(@NonNull ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @NonNull Executor executor) {
        synchronized (this.mLock) {
            this.mListener = (ImageReaderProxy.OnImageAvailableListener) Preconditions.checkNotNull(onImageAvailableListener);
            this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
            this.mImageReaderProxy.setOnImageAvailableListener(this.mTransformedListener, executor);
        }
    }

    public static /* synthetic */ void a(MetadataImageReader metadataImageReader, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        metadataImageReader.getClass();
        onImageAvailableListener.onImageAvailable(metadataImageReader);
    }
}
