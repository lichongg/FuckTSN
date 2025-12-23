package xyz.adscope.common.v2.cache;

import android.content.Context;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class VideoLruCache extends IBaseLruCache {
    private static final String VIDEO_PERMANENT_DIR;
    private static final String VIDEO_TEMPORARY_DIR;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.cache.VideoLruCache$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static VideoLruCache instance = new VideoLruCache(null);

        private InstanceHolder() {
        }
    }

    /* synthetic */ VideoLruCache(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // xyz.adscope.common.v2.cache.IBaseLruCache
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

    private VideoLruCache() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    @Override // xyz.adscope.common.v2.cache.IBaseLruCache
    protected int maxCacheSizeM() {
        return 300;
    }

    public static VideoLruCache getInstance() {
        return InstanceHolder.instance;
    }
}
