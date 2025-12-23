package com.ss.android.socialbase.appdownloader.up;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.downloader.az.m;
import com.ss.android.socialbase.downloader.downloader.cw;
import com.ss.android.socialbase.downloader.g.g;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes6.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static int f38525b = 8;

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f38526c;

    /* renamed from: a, reason: collision with root package name */
    private b<Integer, Bitmap> f38527a;

    /* renamed from: com.ss.android.socialbase.appdownloader.up.a$a, reason: collision with other inner class name */
    class RunnableC0773a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f38528a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f38529b;

        @Override // java.lang.Runnable
        public void run() {
            ByteArrayOutputStream byteArrayOutputStream;
            ByteArrayInputStream byteArrayInputStream;
            Closeable closeable;
            Throwable th;
            InputStream inputStream;
            ByteArrayInputStream byteArrayInputStream2;
            Exception e6;
            try {
                try {
                    g j6 = cw.j(true, 0, this.f38528a, null);
                    if (j6 == null) {
                        m.j(null, null, null, null);
                        return;
                    }
                    inputStream = j6.j();
                    try {
                        byteArrayOutputStream = a.g(inputStream);
                        try {
                            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            try {
                                byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            } catch (Exception e7) {
                                byteArrayInputStream2 = null;
                                e6 = e7;
                            } catch (Throwable th2) {
                                closeable = null;
                                th = th2;
                                m.j(inputStream, byteArrayOutputStream, byteArrayInputStream, closeable);
                                throw th;
                            }
                        } catch (Exception e8) {
                            byteArrayInputStream2 = null;
                            e6 = e8;
                            byteArrayInputStream = null;
                        } catch (Throwable th3) {
                            closeable = null;
                            th = th3;
                            byteArrayInputStream = null;
                        }
                    } catch (Exception e9) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e6 = e9;
                        byteArrayOutputStream = null;
                    } catch (Throwable th4) {
                        byteArrayInputStream = null;
                        closeable = null;
                        th = th4;
                        byteArrayOutputStream = null;
                    }
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                        int g6 = com.ss.android.socialbase.appdownloader.b.g(cw.nd(), 44.0f);
                        options.inSampleSize = a.a(g6, g6, options);
                        options.inJustDecodeBounds = false;
                        a.this.f38527a.put(Integer.valueOf(this.f38529b), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                        m.j(inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2);
                    } catch (Exception e10) {
                        e6 = e10;
                        vl.j(e6);
                        m.j(inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2);
                    }
                } catch (Exception e11) {
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    e6 = e11;
                    inputStream = null;
                } catch (Throwable th5) {
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    closeable = null;
                    th = th5;
                    inputStream = null;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }

        RunnableC0773a(String str, int i6) {
            this.f38528a = str;
            this.f38529b = i6;
        }
    }

    private static class b<K, T> extends LinkedHashMap<K, T> {

        /* renamed from: a, reason: collision with root package name */
        final int f38531a;

        public b(int i6, int i7) {
            super(i7, 0.75f, true);
            this.f38531a = i6;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
            if (size() > this.f38531a) {
                return true;
            }
            return false;
        }
    }

    public static int a(int i6, int i7, BitmapFactory.Options options) {
        int i8 = options.outWidth;
        if (i8 > i6 || options.outHeight > i7) {
            return Math.min(Math.round(i8 / i6), Math.round(options.outHeight / i7));
        }
        return 1;
    }

    public static a d() {
        if (f38526c == null) {
            synchronized (a.class) {
                try {
                    if (f38526c == null) {
                        f38526c = new a();
                    }
                } finally {
                }
            }
        }
        return f38526c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream g(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 0) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public Bitmap b(int i6) {
        return this.f38527a.get(Integer.valueOf(i6));
    }

    private a() {
        this.f38527a = null;
        int i6 = f38525b;
        this.f38527a = new b<>(i6, i6 / 2);
    }

    public void f(int i6, String str) {
        if (!TextUtils.isEmpty(str) && b(i6) == null) {
            cw.vl().submit(new RunnableC0773a(str, i6));
        }
    }
}
