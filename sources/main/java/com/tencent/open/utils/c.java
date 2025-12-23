package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.log.SLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static String f40641c;

    /* renamed from: a, reason: collision with root package name */
    private String f40642a;

    /* renamed from: b, reason: collision with root package name */
    private d f40643b;

    /* renamed from: d, reason: collision with root package name */
    private long f40644d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f40645e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<Activity> f40646f;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f40647g = new Runnable() { // from class: com.tencent.open.utils.c.2
        @Override // java.lang.Runnable
        public void run() {
            boolean z5;
            SLog.v("AsynLoadImg", "saveFileRunnable:");
            String str = "share_qq_" + m.g(c.this.f40642a) + ".jpg";
            String str2 = c.f40641c + str;
            File file = new File(str2);
            Message obtainMessage = c.this.f40645e.obtainMessage();
            if (file.exists()) {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = str2;
                SLog.v("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - c.this.f40644d));
            } else {
                Bitmap a6 = c.a(c.this.f40642a);
                if (a6 != null) {
                    z5 = c.this.a(a6, str);
                } else {
                    SLog.v("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    z5 = false;
                }
                if (z5) {
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = str2;
                } else {
                    obtainMessage.arg1 = 1;
                }
                SLog.v("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - c.this.f40644d));
            }
            c.this.f40645e.sendMessage(obtainMessage);
        }
    };

    public c(Activity activity) {
        this.f40646f = new WeakReference<>(activity);
        this.f40645e = new Handler(activity.getMainLooper()) { // from class: com.tencent.open.utils.c.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                SLog.v("AsynLoadImg", "handleMessage:" + message.arg1);
                if (message.arg1 == 0) {
                    c.this.f40643b.a(message.arg1, (String) message.obj);
                } else {
                    c.this.f40643b.a(message.arg1, (String) null);
                }
            }
        };
    }

    public void a(String str, d dVar) {
        SLog.v("AsynLoadImg", "--save---");
        if (str != null && !str.equals("")) {
            if (!m.a()) {
                dVar.a(2, (String) null);
                return;
            }
            if (this.f40646f.get() != null) {
                Activity activity = this.f40646f.get();
                File h6 = m.h(activity, "Images");
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (h6 == null) {
                    SLog.e("AsynLoadImg", "externalImageFile is null");
                    dVar.a(2, (String) null);
                    return;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(k.d(activity) ? h6.getAbsolutePath() : externalStorageDirectory.getAbsolutePath());
                    sb.append("/tmp/");
                    f40641c = sb.toString();
                }
            }
            this.f40644d = System.currentTimeMillis();
            this.f40642a = str;
            this.f40643b = dVar;
            new Thread(this.f40647g).start();
            return;
        }
        dVar.a(1, (String) null);
    }

    public boolean a(Bitmap bitmap, String str) {
        String str2 = f40641c;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdir();
                }
                SLog.v("AsynLoadImg", "saveFile:" + str);
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(str2 + str)));
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    try {
                        bufferedOutputStream2.close();
                        return true;
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        return true;
                    }
                } catch (IOException e7) {
                    e = e7;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    SLog.e("AsynLoadImg", "saveFile bmp fail---", e);
                    if (bufferedOutputStream == null) {
                        return false;
                    }
                    try {
                        bufferedOutputStream.close();
                        return false;
                    } catch (IOException e8) {
                        e8.printStackTrace();
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Bitmap a(String str) {
        SLog.v("AsynLoadImg", "getbitmap:" + str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            SLog.v("AsynLoadImg", "image download finished." + str);
            return decodeStream;
        } catch (IOException e6) {
            e6.printStackTrace();
            SLog.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (OutOfMemoryError e7) {
            e7.printStackTrace();
            SLog.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }
}
