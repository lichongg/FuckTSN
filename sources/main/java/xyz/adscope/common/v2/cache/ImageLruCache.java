package xyz.adscope.common.v2.cache;

import android.content.Context;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ImageLruCache extends IBaseLruCache {
    private static final String IMAGE_PERMANENT_DIR;
    private static final String IMAGE_TEMPORARY_DIR;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.cache.ImageLruCache$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static ImageLruCache instance = new ImageLruCache(null);

        private InstanceHolder() {
        }
    }

    /* synthetic */ ImageLruCache(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // xyz.adscope.common.v2.cache.IBaseLruCache
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

    private ImageLruCache() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    @Override // xyz.adscope.common.v2.cache.IBaseLruCache
    protected int maxCacheSizeM() {
        return 200;
    }

    public static ImageLruCache getInstance() {
        return InstanceHolder.instance;
    }
}
