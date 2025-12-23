package xyz.adscope.common.v2.image.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import xyz.adscope.common.v2.cache.LruCacheModel;
import xyz.adscope.common.v2.cache2.IResourceCacheCallback;
import xyz.adscope.common.v2.cache2.ImageLruCache2;
import xyz.adscope.common.v2.encrypt.impl.MD5Util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class BitmapHolder {
    private final LimitedLinkedHashMap<String, Bitmap> mLruBitmapCache;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.image.loader.BitmapHolder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class BitmapHandler extends Handler {
        private static final int LOADED_DONE = 1;
        private static final int LOADED_FAILED = 99;
        private final IBitmapResult mCallback;

        /* synthetic */ BitmapHandler(IBitmapResult iBitmapResult, AnonymousClass1 anonymousClass1) {
            this(iBitmapResult);
        }

        private BitmapHandler(IBitmapResult iBitmapResult) {
            super(Looper.getMainLooper());
            this.mCallback = iBitmapResult;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what == 1) {
                Object obj = message.obj;
                if (obj instanceof Bitmap) {
                    this.mCallback.onImageLoaded((Bitmap) obj);
                } else {
                    this.mCallback.onImageLoadFailed();
                }
            }
            if (message.what == 99) {
                this.mCallback.onImageLoadFailed();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static BitmapHolder instance = new BitmapHolder(null);

        private InstanceHolder() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class LimitedLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private final int maxCapacity;

        /* synthetic */ LimitedLinkedHashMap(int i6, AnonymousClass1 anonymousClass1) {
            this(i6);
        }

        private LimitedLinkedHashMap(int i6) {
            super(i6, 0.75f, true);
            this.maxCapacity = i6;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
            if (size() > this.maxCapacity) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class ResourceCacheCallback2 extends IResourceCacheCallback {
        private final Handler mHandler;

        /* synthetic */ ResourceCacheCallback2(BitmapHolder bitmapHolder, Handler handler, AnonymousClass1 anonymousClass1) {
            this(handler);
        }

        private ResourceCacheCallback2(Handler handler) {
            this.mHandler = handler;
        }

        @Override // xyz.adscope.common.v2.cache2.IResourceCacheCallback
        public void onCacheException(String str) {
            this.mHandler.sendEmptyMessage(99);
        }

        @Override // xyz.adscope.common.v2.cache2.IResourceCacheCallback
        public void onCacheInputStream(String str, InputStream inputStream, File file) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferQualityOverSpeed = false;
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            if (decodeStream == null) {
                this.mHandler.sendEmptyMessage(99);
                return;
            }
            BitmapHolder.this.cacheBitmapLru(str, decodeStream);
            BitmapHolder.this.sendSuccessMessage(this.mHandler, decodeStream);
            try {
                decodeStream.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(file));
            } catch (FileNotFoundException unused) {
            }
        }

        @Override // xyz.adscope.common.v2.cache2.IResourceCacheCallback
        public void onCacheFile(String str, File file) {
            if (file.exists()) {
                try {
                    file.setLastModified(System.currentTimeMillis());
                } catch (IllegalArgumentException | SecurityException unused) {
                }
                try {
                    Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), new BitmapFactory.Options());
                    if (decodeFile != null) {
                        BitmapHolder.this.cacheBitmapLru(str, decodeFile);
                        BitmapHolder.this.sendSuccessMessage(this.mHandler, decodeFile);
                        return;
                    } else {
                        this.mHandler.sendEmptyMessage(99);
                        return;
                    }
                } catch (Exception unused2) {
                    this.mHandler.sendEmptyMessage(99);
                    return;
                }
            }
            this.mHandler.sendEmptyMessage(99);
        }
    }

    /* synthetic */ BitmapHolder(AnonymousClass1 anonymousClass1) {
        this();
    }

    private BitmapHolder() {
        this.mLruBitmapCache = new LimitedLinkedHashMap<>(20, null);
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cacheBitmapLru(String str, Bitmap bitmap) {
        synchronized (this.mLruBitmapCache) {
            this.mLruBitmapCache.put(str, bitmap);
        }
    }

    private Bitmap getCacheBitmapLru(String str) {
        Bitmap bitmap;
        synchronized (this.mLruBitmapCache) {
            bitmap = this.mLruBitmapCache.get(str);
        }
        return bitmap;
    }

    private String getCacheTaskKey(String str) {
        return MD5Util.md5(str);
    }

    public static BitmapHolder getInstance() {
        return InstanceHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSuccessMessage(Handler handler, Bitmap bitmap) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = bitmap;
        handler.sendMessage(obtain);
    }

    public void loadImage(Context context, String str, boolean z5, IBitmapResult iBitmapResult) {
        LruCacheModel lruCacheModel;
        Bitmap cacheBitmapLru = getCacheBitmapLru(getCacheTaskKey(str));
        AnonymousClass1 anonymousClass1 = null;
        BitmapHandler bitmapHandler = new BitmapHandler(iBitmapResult, anonymousClass1);
        if (cacheBitmapLru != null) {
            sendSuccessMessage(bitmapHandler, cacheBitmapLru);
            return;
        }
        ResourceCacheCallback2 resourceCacheCallback2 = new ResourceCacheCallback2(this, bitmapHandler, anonymousClass1);
        ImageLruCache2 imageLruCache2 = ImageLruCache2.getInstance();
        if (z5) {
            lruCacheModel = LruCacheModel.TEMPORARY;
        } else {
            lruCacheModel = LruCacheModel.PERMANENT;
        }
        imageLruCache2.getCacheResource(context, str, lruCacheModel, resourceCacheCallback2);
    }
}
