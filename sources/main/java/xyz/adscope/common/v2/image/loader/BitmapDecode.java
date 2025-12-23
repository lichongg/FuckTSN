package xyz.adscope.common.v2.image.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import xyz.adscope.common.v2.cache.IResourceLruCache;
import xyz.adscope.common.v2.cache.ImageLruCache;
import xyz.adscope.common.v2.cache.LruCacheModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class BitmapDecode {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.image.loader.BitmapDecode$1, reason: invalid class name */
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
                this.mCallback.onImageLoaded((Bitmap) message.obj);
            }
            if (message.what == 99) {
                this.mCallback.onImageLoadFailed();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ResourceCacheCallback implements IResourceLruCache.IResourceCacheCallback {
        private final Handler mHandler;

        /* synthetic */ ResourceCacheCallback(Handler handler, AnonymousClass1 anonymousClass1) {
            this(handler);
        }

        private ResourceCacheCallback(Handler handler) {
            this.mHandler = handler;
        }

        @Override // xyz.adscope.common.v2.cache.IResourceLruCache.IResourceCacheCallback
        public void onCacheException() {
            this.mHandler.sendEmptyMessage(99);
        }

        @Override // xyz.adscope.common.v2.cache.IResourceLruCache.IResourceCacheCallback
        public void onCacheDone(File file) {
            if (file.exists()) {
                try {
                    file.setLastModified(System.currentTimeMillis());
                } catch (IllegalArgumentException unused) {
                }
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(new FileInputStream(file));
                    if (decodeStream != null) {
                        Message obtain = Message.obtain();
                        obtain.what = 1;
                        obtain.obj = decodeStream;
                        this.mHandler.sendMessage(obtain);
                        return;
                    }
                    this.mHandler.sendEmptyMessage(99);
                    return;
                } catch (FileNotFoundException unused2) {
                    this.mHandler.sendEmptyMessage(99);
                    return;
                }
            }
            this.mHandler.sendEmptyMessage(99);
        }
    }

    public static void loadImage(Context context, String str, boolean z5, IBitmapResult iBitmapResult) {
        AnonymousClass1 anonymousClass1 = null;
        ImageLruCache.getInstance().getCacheResource(context, str, z5 ? LruCacheModel.TEMPORARY : LruCacheModel.PERMANENT, new ResourceCacheCallback(new BitmapHandler(iBitmapResult, anonymousClass1), anonymousClass1));
    }

    private BitmapDecode() {
    }
}
