package com.tencent.open.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.tauth.Tencent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends Tracer implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    private b f40584a;

    /* renamed from: b, reason: collision with root package name */
    private FileWriter f40585b;

    /* renamed from: c, reason: collision with root package name */
    private File f40586c;

    /* renamed from: d, reason: collision with root package name */
    private char[] f40587d;

    /* renamed from: e, reason: collision with root package name */
    private volatile f f40588e;

    /* renamed from: f, reason: collision with root package name */
    private volatile f f40589f;

    /* renamed from: g, reason: collision with root package name */
    private volatile f f40590g;

    /* renamed from: h, reason: collision with root package name */
    private volatile f f40591h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f40592i;

    /* renamed from: j, reason: collision with root package name */
    private HandlerThread f40593j;

    /* renamed from: k, reason: collision with root package name */
    private Handler f40594k;

    public a(b bVar) {
        this(c.f40606b, true, g.f40626a, bVar);
    }

    private void i() {
        synchronized (this) {
            try {
                if (this.f40590g == this.f40588e) {
                    this.f40590g = this.f40589f;
                    this.f40591h = this.f40588e;
                } else {
                    this.f40590g = this.f40588e;
                    this.f40591h = this.f40589f;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a() {
        if (this.f40594k.hasMessages(1024)) {
            this.f40594k.removeMessages(1024);
        }
        this.f40594k.sendEmptyMessage(1024);
    }

    public void b() {
        h();
        this.f40593j.quit();
    }

    public a(int i6, boolean z5, g gVar, b bVar) {
        super(i6, z5, gVar);
        this.f40592i = false;
        a(bVar);
        this.f40588e = new f();
        this.f40589f = new f();
        this.f40590g = this.f40588e;
        this.f40591h = this.f40589f;
        this.f40587d = new char[bVar.c()];
        HandlerThread handlerThread = new HandlerThread(bVar.b(), bVar.d());
        this.f40593j = handlerThread;
        handlerThread.start();
        if (!this.f40593j.isAlive() || this.f40593j.getLooper() == null) {
            return;
        }
        this.f40594k = new Handler(this.f40593j.getLooper(), this);
    }

    private void h() {
        try {
            FileWriter fileWriter = this.f40585b;
            if (fileWriter != null) {
                fileWriter.flush();
                this.f40585b.close();
            }
        } catch (IOException e6) {
            SLog.e(SLog.TAG, "-->closeAppSpecificFileWriter() exception:", e6);
        }
    }

    public b c() {
        return this.f40584a;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return true;
        }
        f();
        return true;
    }

    private boolean b(File file) {
        if (file == null) {
            return false;
        }
        String name = file.getName();
        SLog.d("FileTracer", "name=" + name);
        return !TextUtils.isEmpty(name) && name.length() == 47 && name.startsWith("com.tencent.mobileqq_connectSdk.") && name.endsWith(".log");
    }

    private void f() {
        if (Thread.currentThread() != this.f40593j || this.f40592i) {
            return;
        }
        this.f40592i = true;
        i();
        try {
            try {
                this.f40591h.a(g(), this.f40587d);
            } catch (IOException e6) {
                SLog.e("FileTracer", "flushBuffer exception", e6);
            }
            this.f40592i = false;
        } finally {
            this.f40591h.b();
        }
    }

    private Writer g() {
        File a6 = c().a();
        if (a6 != null && (!a6.equals(this.f40586c) || this.f40585b == null)) {
            this.f40586c = a6;
            h();
            try {
                this.f40585b = new FileWriter(this.f40586c, true);
            } catch (IOException unused) {
                this.f40585b = null;
                SLog.e(SLog.TAG, "-->obtainFileWriter() app specific file permission denied");
            }
            a(a6);
        }
        return this.f40585b;
    }

    @Override // com.tencent.open.log.Tracer
    protected void doTrace(int i6, Thread thread, long j6, String str, String str2, Throwable th) {
        a(e().a(i6, thread, j6, str, str2, th));
    }

    private void a(String str) {
        this.f40590g.a(str);
        if (this.f40590g.a() >= c().c()) {
            a();
        }
    }

    private void a(File file) {
        File[] listFiles;
        File parentFile = file.getParentFile();
        if (parentFile == null || !parentFile.exists() || !parentFile.isDirectory() || (listFiles = parentFile.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (b(file2)) {
                String name = file2.getName();
                if (b.a(System.currentTimeMillis() - (Tencent.USE_ONE_HOUR ? 3600000L : 259200000L)).compareTo(name.substring(32, 43)) > 0) {
                    SLog.d("FileTracer", "delete name=" + name + ", success=" + file2.delete());
                }
            }
        }
    }

    public void a(b bVar) {
        this.f40584a = bVar;
    }
}
