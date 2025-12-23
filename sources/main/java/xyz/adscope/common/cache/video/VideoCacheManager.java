package xyz.adscope.common.cache.video;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.LruCache;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import xyz.adscope.common.tool.security.MD5Util;
import xyz.adscope.common.tool.utils.FileUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class VideoCacheManager {

    /* renamed from: d, reason: collision with root package name */
    private static VideoCacheManager f56297d;

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f56298a = Executors.newFixedThreadPool(4);

    /* renamed from: b, reason: collision with root package name */
    private LruCache<String, String> f56299b = new LruCache<>(1048576);

    /* renamed from: c, reason: collision with root package name */
    private Handler f56300c = new Handler();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface VideoLoadedListener {
        void onVideoLoadFailed();

        void onVideoLoaded(String str);
    }

    private static VideoCacheManager a() {
        if (f56297d == null) {
            synchronized (VideoCacheManager.class) {
                try {
                    if (f56297d == null) {
                        f56297d = new VideoCacheManager();
                    }
                } finally {
                }
            }
        }
        return f56297d;
    }

    public static VideoCacheManager with() {
        return a();
    }

    public void getCacheVideo(final Context context, final String str, final VideoLoadedListener videoLoadedListener) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = this.f56299b.get(str);
        if (!TextUtils.isEmpty(str3)) {
            videoLoadedListener.onVideoLoaded(str3);
            return;
        }
        File file = new File(FileUtils.getResourceCacheDirectory(context), MD5Util.md5(str.substring(str.lastIndexOf("/") + 1)));
        if (file.exists() && file.length() > 0) {
            str2 = file.getAbsolutePath();
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f56299b.put(str, str2);
            videoLoadedListener.onVideoLoaded(str2);
        } else {
            this.f56298a.submit(new Runnable() { // from class: xyz.adscope.common.cache.video.VideoCacheManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        InputStream inputStream = ((HttpURLConnection) new URL(str).openConnection()).getInputStream();
                        String str4 = str;
                        File file2 = new File(FileUtils.getResourceCacheDirectory(context), MD5Util.md5(str4.substring(str4.lastIndexOf("/") + 1)));
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, read);
                            }
                        }
                        final String absolutePath = file2.getAbsolutePath();
                        VideoCacheManager.this.f56300c.post(new Runnable() { // from class: xyz.adscope.common.cache.video.VideoCacheManager.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                videoLoadedListener.onVideoLoaded(absolutePath);
                            }
                        });
                        VideoCacheManager.this.f56299b.put(str, absolutePath);
                        fileOutputStream.close();
                        inputStream.close();
                        bufferedInputStream.close();
                    } catch (Exception unused) {
                        VideoCacheManager.this.f56300c.post(new Runnable() { // from class: xyz.adscope.common.cache.video.VideoCacheManager.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                videoLoadedListener.onVideoLoadFailed();
                            }
                        });
                    }
                    FileUtils.deleteOldFiles(context);
                }
            });
        }
    }
}
