package xyz.adscope.common.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.baidu.mobads.sdk.internal.by;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HttpsURLConnection;
import xyz.adscope.common.cache.CacheManager;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.imageloader.inter.IImageLoaderCallback;
import xyz.adscope.common.network.ssl.TLSSocketFactory;
import xyz.adscope.common.tool.LogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ImageUtils {

    /* renamed from: d, reason: collision with root package name */
    private static ImageUtils f56351d;

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f56352a = Executors.newFixedThreadPool(4);

    /* renamed from: b, reason: collision with root package name */
    private LruCache<String, Bitmap> f56353b = new LruCache<>(4194304);

    /* renamed from: c, reason: collision with root package name */
    private Handler f56354c = new Handler();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface BitmapLoadedListener {
        void onBitmapLoadFailed();

        void onBitmapLoaded(Bitmap bitmap);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class RequestCreatorRunnble implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        String f56367a;

        /* renamed from: b, reason: collision with root package name */
        int f56368b;

        /* renamed from: c, reason: collision with root package name */
        int f56369c;

        /* renamed from: d, reason: collision with root package name */
        ImageView f56370d;

        /* renamed from: e, reason: collision with root package name */
        IImageLoaderCallback f56371e;

        private Bitmap a(Context context) {
            String str = this.f56367a;
            File file = new File(StorageUtils.getCacheDirectory(context), ImageUtils.b(str.substring(str.lastIndexOf("/") + 1)));
            LogUtil.d("BeiZiImageUtils", "BeiZiImageUtils getBitmapFile file == " + file);
            if (!file.exists() || file.length() <= 0) {
                return null;
            }
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }

        public RequestCreatorRunnble(String str) {
            this.f56367a = str;
        }

        public RequestCreatorRunnble callback(IImageLoaderCallback iImageLoaderCallback) {
            this.f56371e = iImageLoaderCallback;
            return this;
        }

        public RequestCreatorRunnble error(int i6) {
            this.f56369c = i6;
            return this;
        }

        public void into(ImageView imageView) {
            this.f56370d = imageView;
            if (TextUtils.isEmpty(this.f56367a)) {
                return;
            }
            Bitmap bitmap = (Bitmap) ImageUtils.this.f56353b.get(this.f56367a);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                IImageLoaderCallback iImageLoaderCallback = this.f56371e;
                if (iImageLoaderCallback != null) {
                    iImageLoaderCallback.successCallback(bitmap);
                    return;
                }
                return;
            }
            Bitmap a6 = a(imageView.getContext());
            if (a6 == null) {
                ImageUtils.this.f56352a.submit(this);
                return;
            }
            imageView.setImageBitmap(a6);
            ImageUtils.this.f56353b.put(this.f56367a, a6);
            IImageLoaderCallback iImageLoaderCallback2 = this.f56371e;
            if (iImageLoaderCallback2 != null) {
                iImageLoaderCallback2.successCallback(a6);
            }
        }

        public RequestCreatorRunnble placeholder(int i6) {
            this.f56368b = i6;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection c6 = ImageUtils.this.c(this.f56367a);
                if (c6.getResponseCode() != 200) {
                    a();
                    IImageLoaderCallback iImageLoaderCallback = this.f56371e;
                    if (iImageLoaderCallback != null) {
                        iImageLoaderCallback.failCallback("net error");
                        return;
                    }
                    return;
                }
                final Bitmap decodeStream = BitmapFactory.decodeStream(c6.getInputStream());
                ImageUtils.this.f56354c.post(new Runnable() { // from class: xyz.adscope.common.imageloader.ImageUtils.RequestCreatorRunnble.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RequestCreatorRunnble.this.f56370d.setImageBitmap(decodeStream);
                    }
                });
                ImageUtils.this.f56353b.put(this.f56367a, decodeStream);
                String str = this.f56367a;
                File file = new File(StorageUtils.getCacheDirectory(this.f56370d.getContext()), ImageUtils.b(str.substring(str.lastIndexOf("/") + 1)));
                LogUtil.d("BeiZiImageUtils", "BeiZiImageUtils run file == " + file);
                decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(file));
                IImageLoaderCallback iImageLoaderCallback2 = this.f56371e;
                if (iImageLoaderCallback2 != null) {
                    iImageLoaderCallback2.successCallback(decodeStream);
                }
            } catch (FileNotFoundException e6) {
                IImageLoaderCallback iImageLoaderCallback3 = this.f56371e;
                if (iImageLoaderCallback3 != null) {
                    iImageLoaderCallback3.failCallback("fileNotFound " + e6.toString());
                }
            } catch (Exception e7) {
                LogUtil.e("BeiZiImageUtils", "e : " + e7);
                a();
                IImageLoaderCallback iImageLoaderCallback4 = this.f56371e;
                if (iImageLoaderCallback4 != null) {
                    iImageLoaderCallback4.failCallback("exception " + e7.toString());
                }
            }
        }

        private void a() {
            ImageUtils.this.f56354c.post(new Runnable() { // from class: xyz.adscope.common.imageloader.ImageUtils.RequestCreatorRunnble.2
                @Override // java.lang.Runnable
                public void run() {
                }
            });
        }
    }

    public void getBitmap(Context context, String str, BitmapLoadedListener bitmapLoadedListener) {
        getBitmap(context, str, true, bitmapLoadedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpURLConnection c(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            if (!str.startsWith(CommonConstants.HTTPS_PREFIX)) {
                return httpURLConnection;
            }
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new TLSSocketFactory());
            return httpURLConnection;
        } catch (Exception e6) {
            LogUtil.e("BeiZiImageUtils", "Exception e : " + e6);
            return null;
        }
    }

    public void getBitmap(final Context context, final String str, final boolean z5, final BitmapLoadedListener bitmapLoadedListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = this.f56353b.get(str);
        if (bitmap != null) {
            bitmapLoadedListener.onBitmapLoaded(bitmap);
            return;
        }
        Bitmap bitmapByFileName = CacheManager.getInstance(context).getBitmapByFileName(str.substring(str.lastIndexOf("/") + 1), z5);
        if (bitmapByFileName == null) {
            this.f56352a.submit(new Runnable() { // from class: xyz.adscope.common.imageloader.ImageUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HttpURLConnection c6 = ImageUtils.this.c(str);
                        if (c6.getResponseCode() == 200) {
                            final Bitmap decodeStream = BitmapFactory.decodeStream(c6.getInputStream());
                            c6.disconnect();
                            ImageUtils.this.f56354c.post(new Runnable() { // from class: xyz.adscope.common.imageloader.ImageUtils.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    bitmapLoadedListener.onBitmapLoaded(decodeStream);
                                }
                            });
                            ImageUtils.this.f56353b.put(str, decodeStream);
                            String str2 = str;
                            CacheManager.getInstance(context).saveImage(str2.substring(str2.lastIndexOf("/") + 1), decodeStream, z5);
                        }
                    } catch (Exception unused) {
                        ImageUtils.this.f56354c.post(new Runnable() { // from class: xyz.adscope.common.imageloader.ImageUtils.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                bitmapLoadedListener.onBitmapLoadFailed();
                            }
                        });
                    }
                }
            });
        } else {
            this.f56353b.put(str, bitmapByFileName);
            bitmapLoadedListener.onBitmapLoaded(bitmapByFileName);
        }
    }

    public RequestCreatorRunnble load(String str) {
        return new RequestCreatorRunnble(str);
    }

    public static ImageUtils with() {
        return a();
    }

    public void getCacheBitmap(final Context context, final String str, final boolean z5, BitmapLoadedListener bitmapLoadedListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = this.f56353b.get(str);
        if (bitmap != null) {
            bitmapLoadedListener.onBitmapLoaded(bitmap);
            return;
        }
        Bitmap bitmapByFileName = CacheManager.getInstance(context).getBitmapByFileName(str.substring(str.lastIndexOf("/") + 1), z5);
        if (bitmapByFileName != null) {
            this.f56353b.put(str, bitmapByFileName);
            bitmapLoadedListener.onBitmapLoaded(bitmapByFileName);
        } else {
            this.f56352a.submit(new Runnable() { // from class: xyz.adscope.common.imageloader.ImageUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HttpURLConnection c6 = ImageUtils.this.c(str);
                        if (c6.getResponseCode() == 200) {
                            Bitmap decodeStream = BitmapFactory.decodeStream(c6.getInputStream());
                            c6.disconnect();
                            ImageUtils.this.f56353b.put(str, decodeStream);
                            String str2 = str;
                            CacheManager.getInstance(context).saveImage(str2.substring(str2.lastIndexOf("/") + 1), decodeStream, z5);
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    private static ImageUtils a() {
        if (f56351d == null) {
            synchronized (ImageUtils.class) {
                try {
                    if (f56351d == null) {
                        f56351d = new ImageUtils();
                    }
                } finally {
                }
            }
        }
        return f56351d;
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b6 : bArr) {
            int i6 = (b6 >>> 4) & 15;
            int i7 = 0;
            while (true) {
                sb.append((char) ((i6 < 0 || i6 > 9) ? i6 + 87 : i6 + 48));
                i6 = b6 & 15;
                int i8 = i7 + 1;
                if (i7 >= 1) {
                    break;
                }
                i7 = i8;
            }
        }
        return sb.toString();
    }
}
