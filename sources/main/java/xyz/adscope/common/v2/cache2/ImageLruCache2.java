package xyz.adscope.common.v2.cache2;

import android.content.Context;
import java.io.File;
import java.io.InputStream;
import xyz.adscope.common.v2.cache.LruCacheModel;
import xyz.adscope.common.v2.cache2.IBaseLruCache2;
import xyz.adscope.common.v2.conn.IBaseHttpInputStreamCallback;
import xyz.adscope.common.v2.conn.IBaseHttpResponse;
import xyz.adscope.common.v2.conn.IHttpRequestError;
import xyz.adscope.common.v2.conn.http.CommonRequestBuilder;
import xyz.adscope.common.v2.encrypt.impl.MD5Util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ImageLruCache2 extends IBaseLruCache2 {
    private static final String IMAGE_PERMANENT_DIR;
    private static final String IMAGE_TEMPORARY_DIR;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ImageResourceCacheTask extends IBaseLruCache2.ResourceCacheTask<InputStream> {
        @Override // java.lang.Runnable
        public void run() {
            CommonRequestBuilder concern = new CommonRequestBuilder().autoRedirected(true).concern(new IBaseHttpInputStreamCallback() { // from class: xyz.adscope.common.v2.cache2.ImageLruCache2.ImageResourceCacheTask.1
                @Override // xyz.adscope.common.v2.conn.IBaseHttpResponseCallback
                public void failCallback(IHttpRequestError iHttpRequestError) {
                    ImageResourceCacheTask imageResourceCacheTask = ImageResourceCacheTask.this;
                    IBaseLruCache2.LruCacheHttpRespCallback<T> lruCacheHttpRespCallback = imageResourceCacheTask.mHttpRespCallback;
                    if (lruCacheHttpRespCallback != 0) {
                        lruCacheHttpRespCallback.onCacheException(imageResourceCacheTask.mTaskKey);
                    }
                }

                @Override // xyz.adscope.common.v2.conn.IBaseHttpInputStreamCallback
                public void onInputStream(InputStream inputStream) {
                    ImageResourceCacheTask imageResourceCacheTask = ImageResourceCacheTask.this;
                    IBaseLruCache2.LruCacheHttpRespCallback<T> lruCacheHttpRespCallback = imageResourceCacheTask.mHttpRespCallback;
                    if (lruCacheHttpRespCallback != 0) {
                        lruCacheHttpRespCallback.onCacheReady(imageResourceCacheTask.mTaskKey, inputStream);
                    }
                }

                @Override // xyz.adscope.common.v2.conn.IBaseHttpResponseCallback
                public void successCallback(IBaseHttpResponse iBaseHttpResponse) {
                }
            });
            concern.cacheImage(this.mURL);
            concern.performLocalIO().run();
        }

        protected ImageResourceCacheTask(String str, File file, String str2) {
            super(str, file, str2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static ImageLruCache2 instance = new ImageLruCache2();

        private InstanceHolder() {
        }
    }

    @Override // xyz.adscope.common.v2.cache2.IBaseLruCache2
    protected File getCacheDir(Context context, LruCacheModel lruCacheModel) {
        if (context != null) {
            File file = lruCacheModel == LruCacheModel.PERMANENT ? new File(context.getCacheDir(), IMAGE_PERMANENT_DIR) : null;
            if (lruCacheModel == LruCacheModel.TEMPORARY) {
                file = new File(context.getCacheDir(), IMAGE_TEMPORARY_DIR);
            }
            if (file != null) {
                try {
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    return file;
                } catch (SecurityException unused) {
                }
            }
        }
        return null;
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("Image_permanent");
        String str = File.separator;
        sb.append(str);
        IMAGE_PERMANENT_DIR = sb.toString();
        IMAGE_TEMPORARY_DIR = "Image_temporary" + str;
    }

    private ImageLruCache2() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    @Override // xyz.adscope.common.v2.cache2.IBaseLruCache2
    protected IBaseLruCache2.ResourceCacheTask<?> getResourceCacheTask(String str, final File file, String str2) {
        ImageResourceCacheTask imageResourceCacheTask = new ImageResourceCacheTask(str, file, str2);
        imageResourceCacheTask.setHttpResponseCallback(new IBaseLruCache2.LruCacheHttpRespCallback<InputStream>() { // from class: xyz.adscope.common.v2.cache2.ImageLruCache2.1
            @Override // xyz.adscope.common.v2.cache2.IBaseLruCache2.LruCacheHttpRespCallback
            public void onCacheException(String str3) {
                synchronized (ImageLruCache2.this.lock) {
                    ImageLruCache2.this.removeCacheTask(str3);
                    ImageLruCache2.this.callbackResource(str3, null);
                }
            }

            @Override // xyz.adscope.common.v2.cache2.IBaseLruCache2.LruCacheHttpRespCallback
            public void onCacheReady(String str3, InputStream inputStream) {
                synchronized (ImageLruCache2.this.lock) {
                    ImageLruCache2.this.removeCacheTask(str3);
                    ImageLruCache2.this.callbackResourceInputStream(str3, inputStream, file);
                }
            }
        });
        return imageResourceCacheTask;
    }

    @Override // xyz.adscope.common.v2.cache2.IBaseLruCache2
    protected int maxCacheSizeM() {
        return 200;
    }

    public static ImageLruCache2 getInstance() {
        return InstanceHolder.instance;
    }

    @Override // xyz.adscope.common.v2.cache2.IBaseLruCache2
    protected String getCacheFileName(String str) {
        return MD5Util.md5(str);
    }
}
