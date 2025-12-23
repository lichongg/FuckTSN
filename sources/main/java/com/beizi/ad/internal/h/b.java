package com.beizi.ad.internal.h;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        @UiThread
        void a();

        @UiThread
        void a(InterfaceC0110b interfaceC0110b);

        @UiThread
        void a(d dVar);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.h.b$b, reason: collision with other inner class name */
    public interface InterfaceC0110b {
        @UiThread
        void a(int i6);

        @UiThread
        void a(long j6, long j7);

        @WorkerThread
        boolean a(File file);

        @UiThread
        void b(File file);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c implements a, Runnable {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private HandlerThread f12045a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private InterfaceC0110b f12046b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private Handler f12047c;

        /* renamed from: d, reason: collision with root package name */
        private Handler f12048d = new Handler(Looper.getMainLooper());

        /* renamed from: e, reason: collision with root package name */
        private d f12049e;

        private void b(final File file) {
            this.f12048d.post(new Runnable() { // from class: com.beizi.ad.internal.h.b.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.f12046b != null) {
                        c.this.f12046b.b(file);
                    }
                }
            });
        }

        @Override // com.beizi.ad.internal.h.b.a
        public void a(InterfaceC0110b interfaceC0110b) {
            this.f12046b = interfaceC0110b;
        }

        @Override // java.lang.Runnable
        @WorkerThread
        public void run() {
            HttpURLConnection httpURLConnection;
            InputStream inputStream;
            d dVar = this.f12049e;
            dVar.f12057a = true;
            File file = new File(dVar.f12061e);
            if (!file.exists() && !file.mkdirs()) {
                a(3);
                return;
            }
            String str = dVar.f12061e + File.separator + dVar.f12062f;
            File file2 = new File(str);
            RandomAccessFile randomAccessFile = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(dVar.f12060d).openConnection();
                try {
                    if (dVar.f12064h != 0) {
                        httpURLConnection.setRequestProperty("Range", "bytes=" + dVar.f12064h + "-");
                    }
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200 || responseCode == 206) {
                        httpURLConnection.getHeaderField("Content-Disposition");
                        httpURLConnection.getContentType();
                        long contentLengthLong = Build.VERSION.SDK_INT >= 24 ? httpURLConnection.getContentLengthLong() : httpURLConnection.getContentLength();
                        if (responseCode == 200) {
                            dVar.f12064h = 0L;
                            dVar.f12063g = contentLengthLong;
                        }
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            try {
                                byte[] bArr = new byte[8192];
                                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "rw");
                                try {
                                    randomAccessFile2.seek(dVar.f12064h);
                                    int i6 = 0;
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (read != -1) {
                                            i6++;
                                            randomAccessFile2.write(bArr, 0, read);
                                            dVar.f12064h += read;
                                            if (i6 % 64 == 0) {
                                                if (dVar.f12058b) {
                                                    dVar.f12057a = false;
                                                    a(1);
                                                    try {
                                                        randomAccessFile2.getFD().sync();
                                                    } catch (IOException unused) {
                                                    }
                                                    try {
                                                        randomAccessFile2.close();
                                                    } catch (IOException unused2) {
                                                    }
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException unused3) {
                                                    }
                                                    httpURLConnection.disconnect();
                                                    return;
                                                }
                                                if (dVar.f12059c) {
                                                    dVar.f12057a = false;
                                                    a(6);
                                                    try {
                                                        randomAccessFile2.getFD().sync();
                                                    } catch (IOException unused4) {
                                                    }
                                                    try {
                                                        randomAccessFile2.close();
                                                    } catch (IOException unused5) {
                                                    }
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException unused6) {
                                                    }
                                                    httpURLConnection.disconnect();
                                                    return;
                                                }
                                                if (i6 % 16 == 0) {
                                                    a(dVar.f12064h, dVar.f12063g);
                                                }
                                            }
                                        } else {
                                            randomAccessFile2.getFD().sync();
                                            if (a(file2)) {
                                                dVar.f12057a = false;
                                                b(file2);
                                            } else {
                                                dVar.f12057a = false;
                                                a(4);
                                            }
                                            randomAccessFile = randomAccessFile2;
                                        }
                                    }
                                } catch (IOException e6) {
                                    e = e6;
                                    randomAccessFile = randomAccessFile2;
                                    e.printStackTrace();
                                    dVar.f12057a = false;
                                    a(5);
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.getFD().sync();
                                        } catch (IOException unused7) {
                                        }
                                    }
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (IOException unused8) {
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException unused9) {
                                        }
                                    }
                                    if (httpURLConnection == null) {
                                        return;
                                    }
                                    httpURLConnection.disconnect();
                                } catch (Throwable th) {
                                    th = th;
                                    randomAccessFile = randomAccessFile2;
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.getFD().sync();
                                        } catch (IOException unused10) {
                                        }
                                    }
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (IOException unused11) {
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException unused12) {
                                        }
                                    }
                                    if (httpURLConnection == null) {
                                        throw th;
                                    }
                                    httpURLConnection.disconnect();
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (IOException e7) {
                            e = e7;
                        }
                    } else {
                        dVar.f12057a = false;
                        a(2);
                        inputStream = null;
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.getFD().sync();
                        } catch (IOException unused13) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused14) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused15) {
                        }
                    }
                } catch (IOException e8) {
                    e = e8;
                    inputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                }
            } catch (IOException e9) {
                e = e9;
                httpURLConnection = null;
                inputStream = null;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = null;
                inputStream = null;
            }
            httpURLConnection.disconnect();
        }

        public c() {
            HandlerThread handlerThread = new HandlerThread("download");
            this.f12045a = handlerThread;
            handlerThread.start();
            this.f12047c = new Handler(this.f12045a.getLooper());
        }

        @Override // com.beizi.ad.internal.h.b.a
        public void a(d dVar) {
            if (!dVar.f12057a) {
                d dVar2 = this.f12049e;
                if (dVar2 != null && !dVar.equals(dVar2)) {
                    this.f12049e.f12058b = true;
                }
                this.f12049e = dVar;
                dVar.a();
                Handler handler = this.f12047c;
                if (handler != null) {
                    handler.post(this);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Invalid request,it's downloading");
        }

        @Override // com.beizi.ad.internal.h.b.a
        public void a() {
            HandlerThread handlerThread = this.f12045a;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.f12047c = null;
            this.f12045a = null;
        }

        private void a(final long j6, final long j7) {
            this.f12048d.post(new Runnable() { // from class: com.beizi.ad.internal.h.b.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.f12046b != null) {
                        c.this.f12046b.a(j6, j7);
                    }
                }
            });
        }

        private boolean a(File file) {
            InterfaceC0110b interfaceC0110b = this.f12046b;
            return interfaceC0110b != null && interfaceC0110b.a(file);
        }

        private void a(final int i6) {
            this.f12048d.post(new Runnable() { // from class: com.beizi.ad.internal.h.b.c.3
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.f12046b != null) {
                        c.this.f12046b.a(i6);
                    }
                }
            });
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public volatile boolean f12057a;

        /* renamed from: b, reason: collision with root package name */
        public volatile boolean f12058b;

        /* renamed from: c, reason: collision with root package name */
        public volatile boolean f12059c;

        /* renamed from: d, reason: collision with root package name */
        private String f12060d;

        /* renamed from: e, reason: collision with root package name */
        private String f12061e;

        /* renamed from: f, reason: collision with root package name */
        private String f12062f;

        /* renamed from: g, reason: collision with root package name */
        private volatile long f12063g;

        /* renamed from: h, reason: collision with root package name */
        private volatile long f12064h;

        public d(String str, String str2, String str3) {
            this.f12060d = str;
            this.f12061e = str2;
            this.f12062f = str3;
            a();
        }

        public void a() {
            this.f12063g = 0L;
            this.f12064h = 0L;
            this.f12058b = false;
            this.f12059c = false;
            this.f12057a = false;
        }
    }

    public static a a() {
        return new c();
    }
}
