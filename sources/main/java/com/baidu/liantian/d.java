package com.baidu.liantian;

import android.content.Context;
import android.os.FileObserver;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class d extends FileObserver {

    /* renamed from: a, reason: collision with root package name */
    private String f10452a;

    /* renamed from: b, reason: collision with root package name */
    private String f10453b;

    /* renamed from: c, reason: collision with root package name */
    private int f10454c;

    /* renamed from: d, reason: collision with root package name */
    private Context f10455d;

    @Override // android.os.FileObserver
    public void onEvent(int i6, String str) {
        if (i6 == 2 || i6 == 4 || i6 == 64 || i6 == 128 || i6 == 512 || i6 == 1024 || i6 == 2048) {
            try {
                new Thread() { // from class: com.baidu.liantian.d.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        try {
                            super.run();
                            b.a();
                            synchronized (d.class) {
                                try {
                                    if (!com.baidu.liantian.b.e.c(d.this.f10452a)) {
                                        b.a();
                                        com.baidu.liantian.b.e.b(d.this.f10453b, d.this.f10452a);
                                        com.baidu.liantian.b.e.a(d.this.f10452a, true);
                                        c.a(new File(d.this.f10452a));
                                        c.a(d.this.f10455d, d.this.f10454c, new File(d.this.f10452a), new File(d.this.f10453b));
                                        d.this.f10452a.toString();
                                        b.a();
                                        com.baidu.liantian.a.a.a(d.this.f10455d).b(d.this.f10454c, -1);
                                    }
                                } finally {
                                }
                            }
                        } catch (Throwable unused) {
                            com.baidu.liantian.b.e.a();
                        }
                    }
                }.start();
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
            }
        }
    }

    public d(Context context, int i6, String str, String str2) {
        super(str, 4095);
        try {
            this.f10452a = str;
            this.f10453b = str2;
            this.f10454c = i6;
            this.f10455d = context;
            new File(this.f10452a).exists();
            b.a();
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    public final boolean a() {
        try {
            File file = new File(this.f10453b);
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return false;
        }
    }
}
