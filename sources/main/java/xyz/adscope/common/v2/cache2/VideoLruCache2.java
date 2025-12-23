package xyz.adscope.common.v2.cache2;

import android.content.Context;
import java.io.File;
import xyz.adscope.common.v2.cache.LruCacheModel;
import xyz.adscope.common.v2.cache2.IBaseLruCache2;
import xyz.adscope.common.v2.conn.IBaseHttpResponse;
import xyz.adscope.common.v2.conn.IBaseHttpResponseCallback;
import xyz.adscope.common.v2.conn.IHttpRequestError;
import xyz.adscope.common.v2.conn.http.CommonRequestBuilder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class VideoLruCache2 extends IBaseLruCache2 {
    private static final String VIDEO_PERMANENT_DIR;
    private static final String VIDEO_TEMPORARY_DIR;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static VideoLruCache2 instance = new VideoLruCache2();

        private InstanceHolder() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class VideoCacheTask extends IBaseLruCache2.ResourceCacheTask<File> {
        @Override // java.lang.Runnable
        public void run() {
            CommonRequestBuilder concern = new CommonRequestBuilder().autoRedirected(true).concern(new IBaseHttpResponseCallback() { // from class: xyz.adscope.common.v2.cache2.VideoLruCache2.VideoCacheTask.1
                @Override // xyz.adscope.common.v2.conn.IBaseHttpResponseCallback
                public void failCallback(IHttpRequestError iHttpRequestError) {
                    VideoCacheTask videoCacheTask = VideoCacheTask.this;
                    IBaseLruCache2.LruCacheHttpRespCallback<T> lruCacheHttpRespCallback = videoCacheTask.mHttpRespCallback;
                    if (lruCacheHttpRespCallback != 0) {
                        lruCacheHttpRespCallback.onCacheException(videoCacheTask.mTaskKey);
                    }
                }

                @Override // xyz.adscope.common.v2.conn.IBaseHttpResponseCallback
                public void successCallback(IBaseHttpResponse iBaseHttpResponse) {
                    VideoCacheTask videoCacheTask = VideoCacheTask.this;
                    IBaseLruCache2.LruCacheHttpRespCallback<T> lruCacheHttpRespCallback = videoCacheTask.mHttpRespCallback;
                    if (lruCacheHttpRespCallback != 0) {
                        lruCacheHttpRespCallback.onCacheReady(videoCacheTask.mTaskKey, videoCacheTask.mCacheFile);
                    }
                }
            });
            concern.download(this.mURL, this.mCacheFile);
            concern.performLocalIO().run();
        }

        protected VideoCacheTask(String str, File file, String str2) {
            super(str, file, str2);
        }
    }

    @Override // xyz.adscope.common.v2.cache2.IBaseLruCache2
    protected File getCacheDir(Context context, LruCacheModel lruCacheModel) {
        if (context != null) {
            File file = lruCacheModel == LruCacheModel.PERMANENT ? new File(context.getCacheDir(), VIDEO_PERMANENT_DIR) : null;
            if (lruCacheModel == LruCacheModel.TEMPORARY) {
                file = new File(context.getCacheDir(), VIDEO_TEMPORARY_DIR);
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
        sb.append("Video_permanent");
        String str = File.separator;
        sb.append(str);
        VIDEO_PERMANENT_DIR = sb.toString();
        VIDEO_TEMPORARY_DIR = "Video_temporary" + str;
    }

    private VideoLruCache2() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    @Override // xyz.adscope.common.v2.cache2.IBaseLruCache2
    protected IBaseLruCache2.ResourceCacheTask<?> getResourceCacheTask(String str, File file, String str2) {
        VideoCacheTask videoCacheTask = new VideoCacheTask(str, file, str2);
        videoCacheTask.setHttpResponseCallback(new IBaseLruCache2.LruCacheHttpRespCallback<File>() { // from class: xyz.adscope.common.v2.cache2.VideoLruCache2.1
            @Override // xyz.adscope.common.v2.cache2.IBaseLruCache2.LruCacheHttpRespCallback
            public void onCacheException(String str3) {
                synchronized (VideoLruCache2.this.lock) {
                    VideoLruCache2.this.removeCacheTask(str3);
                    VideoLruCache2.this.callbackResource(str3, null);
                }
            }

            @Override // xyz.adscope.common.v2.cache2.IBaseLruCache2.LruCacheHttpRespCallback
            public void onCacheReady(String str3, File file2) {
                synchronized (VideoLruCache2.this.lock) {
                    VideoLruCache2.this.removeCacheTask(str3);
                    VideoLruCache2.this.callbackResource(str3, file2);
                }
            }
        });
        return videoCacheTask;
    }

    @Override // xyz.adscope.common.v2.cache2.IBaseLruCache2
    protected int maxCacheSizeM() {
        return 300;
    }

    public static VideoLruCache2 getInstance() {
        return InstanceHolder.instance;
    }
}
