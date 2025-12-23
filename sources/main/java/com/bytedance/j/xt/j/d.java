package com.bytedance.j.xt.j;

import com.bytedance.j.xt.up.h;
import java.io.File;

/* loaded from: D:\Downloads\app\classes3.dex */
public class d implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    private final com.bytedance.j.xt.j.a f24213b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f24214c = false;

    /* renamed from: d, reason: collision with root package name */
    private Runnable f24215d = new a();

    /* renamed from: a, reason: collision with root package name */
    private long f24212a = a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f24214c = false;
        }
    }

    private long a() {
        File file = new File("/data/anr/traces.txt");
        if (file.exists()) {
            return file.lastModified();
        }
        return 0L;
    }

    private boolean c() {
        File file = new File("/data/anr/traces.txt");
        return file.exists() && file.canRead();
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int i6;
        if (this.f24214c) {
            return;
        }
        if (c()) {
            i6 = 200;
            str = "/data/anr/traces.txt";
        } else {
            str = null;
            i6 = 100;
        }
        if (this.f24213b.e(i6, str, 25)) {
            this.f24214c = true;
        }
    }

    d(com.bytedance.j.xt.j.a aVar) {
        this.f24213b = aVar;
        com.bytedance.j.xt.up.d.a(2L);
        h.b().c(4500L, this.f24215d);
        h.b().d(5000L, this, 40, 5000L);
    }
}
