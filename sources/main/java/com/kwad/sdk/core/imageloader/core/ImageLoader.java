package com.kwad.sdk.core.imageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptions;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageViewAware;
import com.kwad.sdk.core.imageloader.core.imageaware.NonViewAware;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingProgressListener;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.ImageSizeUtils;
import com.kwad.sdk.core.imageloader.utils.L;
import com.kwad.sdk.core.imageloader.utils.MemoryCacheUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ImageLoader {
    private static final String ERROR_INIT_CONFIG_WITH_NULL = "ImageLoader configuration can not be initialized with null";
    private static final String ERROR_NOT_INIT = "ImageLoader must be init with configuration before using";
    private static final String ERROR_WRONG_ARGUMENTS = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";
    static final String LOG_DESTROY = "Destroy ImageLoader";
    static final String LOG_INIT_CONFIG = "Initialize ImageLoader with configuration";
    static final String LOG_LOAD_IMAGE_FROM_MEMORY_CACHE = "Load image from memory cache [%s]";
    public static final String TAG = "ImageLoader";
    private static final String WARNING_RE_INIT_CONFIG = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";
    private static volatile ImageLoader instance;
    private volatile ImageLoaderConfiguration configuration;
    private ImageLoadingListener defaultListener = new SimpleImageLoadingListener();
    private ImageLoaderEngine engine;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.core.imageloader.core.ImageLoader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SyncImageLoadingListener extends SimpleImageLoadingListener {
        private Bitmap loadedImage;

        private SyncImageLoadingListener() {
        }

        /* synthetic */ SyncImageLoadingListener(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Bitmap getLoadedBitmap() {
            return this.loadedImage;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
            this.loadedImage = decodedResult.mBitmap;
        }
    }

    public void cancelDisplayTask(ImageAware imageAware) {
        this.engine.cancelDisplayTaskFor(imageAware);
    }

    public void displayImage(String str, ImageAware imageAware) {
        displayImage(str, imageAware, (DisplayImageOptions) null, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
    }

    public String getLoadingUriForView(ImageAware imageAware) {
        return this.engine.getLoadingUriForView(imageAware);
    }

    public synchronized void init(ImageLoaderConfiguration imageLoaderConfiguration) {
        if (imageLoaderConfiguration == null) {
            throw new IllegalArgumentException(ERROR_INIT_CONFIG_WITH_NULL);
        }
        if (this.configuration != null) {
            L.w(WARNING_RE_INIT_CONFIG, new Object[0]);
            return;
        }
        L.d(LOG_INIT_CONFIG, new Object[0]);
        this.engine = new ImageLoaderEngine(imageLoaderConfiguration);
        this.configuration = imageLoaderConfiguration;
    }

    public void loadImage(String str, ImageLoadingListener imageLoadingListener) {
        loadImage(str, null, null, imageLoadingListener, null);
    }

    public Bitmap loadImageSync(String str) {
        return loadImageSync(str, null, null);
    }

    private void checkConfiguration() {
        if (this.configuration == null) {
            throw new IllegalStateException(ERROR_NOT_INIT);
        }
    }

    public static ImageLoader getInstance() {
        if (instance == null) {
            synchronized (ImageLoader.class) {
                try {
                    if (instance == null) {
                        instance = new ImageLoader();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public void cancelDisplayTask(ImageView imageView) {
        this.engine.cancelDisplayTaskFor(new ImageViewAware(imageView));
    }

    public void denyNetworkDownloads(boolean z5) {
        this.engine.denyNetworkDownloads(z5);
    }

    public void destroy() {
        if (this.configuration != null) {
            L.d(LOG_DESTROY, new Object[0]);
        }
        stop();
        this.configuration.diskCache.close();
        this.engine = null;
        this.configuration = null;
    }

    public void displayImage(String str, ImageAware imageAware, ImageLoadingListener imageLoadingListener) {
        displayImage(str, imageAware, (DisplayImageOptions) null, imageLoadingListener, (ImageLoadingProgressListener) null);
    }

    public String getLoadingUriForView(ImageView imageView) {
        return this.engine.getLoadingUriForView(new ImageViewAware(imageView));
    }

    public void handleSlowNetwork(boolean z5) {
        this.engine.handleSlowNetwork(z5);
    }

    public boolean isInited() {
        return this.configuration != null;
    }

    public void loadImage(String str, ImageSize imageSize, ImageLoadingListener imageLoadingListener) {
        loadImage(str, imageSize, null, imageLoadingListener, null);
    }

    public Bitmap loadImageSync(String str, DisplayImageOptions displayImageOptions) {
        return loadImageSync(str, null, displayImageOptions);
    }

    public void pause() {
        this.engine.pause();
    }

    public void resume() {
        this.engine.resume();
    }

    public void setDefaultLoadingListener(ImageLoadingListener imageLoadingListener) {
        if (imageLoadingListener == null) {
            imageLoadingListener = new SimpleImageLoadingListener();
        }
        this.defaultListener = imageLoadingListener;
    }

    public void stop() {
        this.engine.stop();
    }

    protected ImageLoader() {
    }

    private static Handler defineHandler(DisplayImageOptions displayImageOptions) {
        Handler handler = displayImageOptions.getHandler();
        if (displayImageOptions.isSyncLoading()) {
            return null;
        }
        if (handler == null && Looper.myLooper() == Looper.getMainLooper()) {
            return new Handler();
        }
        return handler;
    }

    @Deprecated
    public void clearDiscCache() {
        clearDiskCache();
    }

    public void clearDiskCache() {
        checkConfiguration();
        this.configuration.diskCache.clear();
    }

    public void clearMemoryCache() {
        checkConfiguration();
        this.configuration.memoryCache.clear();
    }

    public void displayImage(String str, ImageAware imageAware, DisplayImageOptions displayImageOptions) {
        displayImage(str, imageAware, displayImageOptions, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
    }

    @Deprecated
    public DiskCache getDiscCache() {
        return getDiskCache();
    }

    public DiskCache getDiskCache() {
        checkConfiguration();
        return this.configuration.diskCache;
    }

    public MemoryCache getMemoryCache() {
        checkConfiguration();
        return this.configuration.memoryCache;
    }

    public void loadImage(String str, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        loadImage(str, null, displayImageOptions, imageLoadingListener, null);
    }

    public Bitmap loadImageSync(String str, ImageSize imageSize) {
        return loadImageSync(str, imageSize, null);
    }

    public void displayImage(String str, ImageAware imageAware, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        displayImage(str, imageAware, displayImageOptions, imageLoadingListener, (ImageLoadingProgressListener) null);
    }

    public void loadImage(String str, ImageSize imageSize, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        loadImage(str, imageSize, displayImageOptions, imageLoadingListener, null);
    }

    public Bitmap loadImageSync(String str, ImageSize imageSize, DisplayImageOptions displayImageOptions) {
        if (displayImageOptions == null) {
            displayImageOptions = this.configuration.defaultDisplayImageOptions;
        }
        DisplayImageOptions build = new DisplayImageOptions.Builder().cloneFrom(displayImageOptions).syncLoading(true).build();
        SyncImageLoadingListener syncImageLoadingListener = new SyncImageLoadingListener(null);
        loadImage(str, imageSize, build, syncImageLoadingListener);
        return syncImageLoadingListener.getLoadedBitmap();
    }

    public void displayImage(String str, ImageAware imageAware, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener, ImageLoadingProgressListener imageLoadingProgressListener) {
        displayImage(str, imageAware, displayImageOptions, null, imageLoadingListener, imageLoadingProgressListener);
    }

    public void loadImage(String str, ImageSize imageSize, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener, ImageLoadingProgressListener imageLoadingProgressListener) {
        checkConfiguration();
        if (imageSize == null) {
            imageSize = this.configuration.getMaxImageSize();
        }
        if (displayImageOptions == null) {
            displayImageOptions = this.configuration.defaultDisplayImageOptions;
        }
        displayImage(str, new NonViewAware(str, imageSize, ViewScaleType.CROP), displayImageOptions, imageLoadingListener, imageLoadingProgressListener);
    }

    public void displayImage(String str, ImageAware imageAware, DisplayImageOptions displayImageOptions, ImageSize imageSize, ImageLoadingListener imageLoadingListener, ImageLoadingProgressListener imageLoadingProgressListener) {
        checkConfiguration();
        if (imageAware != null) {
            if (imageLoadingListener == null) {
                imageLoadingListener = this.defaultListener;
            }
            ImageLoadingListener imageLoadingListener2 = imageLoadingListener;
            if (displayImageOptions == null) {
                displayImageOptions = this.configuration.defaultDisplayImageOptions;
            }
            DisplayImageOptions displayImageOptions2 = displayImageOptions;
            if (TextUtils.isEmpty(str)) {
                this.engine.cancelDisplayTaskFor(imageAware);
                imageLoadingListener2.onLoadingStarted(str, imageAware.getWrappedView());
                if (displayImageOptions2.shouldShowImageForEmptyUri()) {
                    imageAware.setImageDrawable(displayImageOptions2.getImageForEmptyUri(this.configuration.resources));
                } else {
                    imageAware.setImageDrawable(null);
                }
                imageLoadingListener2.onLoadingComplete(str, imageAware.getWrappedView(), null);
                return;
            }
            if (imageSize == null) {
                imageSize = ImageSizeUtils.defineTargetSizeForView(imageAware, this.configuration.getMaxImageSize());
            }
            ImageSize imageSize2 = imageSize;
            String generateKey = MemoryCacheUtils.generateKey(str, imageSize2);
            this.engine.prepareDisplayTaskFor(imageAware, generateKey);
            imageLoadingListener2.onLoadingStarted(str, imageAware.getWrappedView());
            DecodedResult decodedResult = this.configuration.memoryCache.get(generateKey);
            if (decodedResult != null && decodedResult.isDecoded()) {
                L.d(LOG_LOAD_IMAGE_FROM_MEMORY_CACHE, generateKey);
                if (displayImageOptions2.shouldPostProcess()) {
                    ProcessAndDisplayImageTask processAndDisplayImageTask = new ProcessAndDisplayImageTask(this.engine, decodedResult, new ImageLoadingInfo(str, imageAware, imageSize2, generateKey, displayImageOptions2, imageLoadingListener2, imageLoadingProgressListener, this.engine.getLockForUri(str)), defineHandler(displayImageOptions2));
                    if (displayImageOptions2.isSyncLoading()) {
                        processAndDisplayImageTask.run();
                        return;
                    } else {
                        this.engine.submit(processAndDisplayImageTask);
                        return;
                    }
                }
                displayImageOptions2.getDisplayer().display(decodedResult, imageAware, LoadedFrom.MEMORY_CACHE);
                imageLoadingListener2.onLoadingComplete(str, imageAware.getWrappedView(), decodedResult);
                return;
            }
            if (displayImageOptions2.shouldShowImageOnLoading()) {
                imageAware.setImageDrawable(displayImageOptions2.getImageOnLoading(this.configuration.resources));
            } else if (displayImageOptions2.isResetViewBeforeLoading()) {
                imageAware.setImageDrawable(null);
            }
            LoadAndDisplayImageTask loadAndDisplayImageTask = new LoadAndDisplayImageTask(this.engine, new ImageLoadingInfo(str, imageAware, imageSize2, generateKey, displayImageOptions2, imageLoadingListener2, imageLoadingProgressListener, this.engine.getLockForUri(str)), defineHandler(displayImageOptions2));
            if (displayImageOptions2.isSyncLoading()) {
                loadAndDisplayImageTask.run();
                return;
            } else {
                this.engine.submit(loadAndDisplayImageTask);
                return;
            }
        }
        throw new IllegalArgumentException(ERROR_WRONG_ARGUMENTS);
    }

    public void displayImage(String str, ImageView imageView) {
        displayImage(str, new ImageViewAware(imageView), (DisplayImageOptions) null, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
    }

    public void displayImage(String str, ImageView imageView, ImageSize imageSize) {
        displayImage(str, new ImageViewAware(imageView), null, imageSize, null, null);
    }

    public void displayImage(String str, ImageView imageView, DisplayImageOptions displayImageOptions) {
        displayImage(str, new ImageViewAware(imageView), displayImageOptions, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
    }

    public void displayImage(String str, ImageView imageView, ImageLoadingListener imageLoadingListener) {
        displayImage(str, new ImageViewAware(imageView), (DisplayImageOptions) null, imageLoadingListener, (ImageLoadingProgressListener) null);
    }

    public void displayImage(String str, ImageView imageView, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        displayImage(str, imageView, displayImageOptions, imageLoadingListener, (ImageLoadingProgressListener) null);
    }

    public void displayImage(String str, ImageView imageView, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener, ImageLoadingProgressListener imageLoadingProgressListener) {
        displayImage(str, new ImageViewAware(imageView), displayImageOptions, imageLoadingListener, imageLoadingProgressListener);
    }
}
