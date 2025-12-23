package com.bytedance.j.xt.j;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.oq.r.cw;

/* loaded from: D:\Downloads\app\classes3.dex */
public class b extends FileObserver {

    /* renamed from: a, reason: collision with root package name */
    private final com.bytedance.j.xt.j.a f24205a;

    /* renamed from: b, reason: collision with root package name */
    private final int f24206b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f24207c;

    private final class a extends cw {

        /* renamed from: a, reason: collision with root package name */
        private int f24208a;

        a(int i6) {
            super("ANRFileObserver$RestartMonitorThread");
            this.f24208a = i6;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.f24208a);
            b.this.f24207c = true;
        }
    }

    @Override // android.os.FileObserver
    public void onEvent(int i6, String str) {
        if (this.f24207c && i6 == 8 && !TextUtils.isEmpty(str) && str.contains("trace") && this.f24205a != null) {
            this.f24207c = false;
            this.f24205a.e(200, "/data/anr/".concat(str), 80);
            new a(5000).start();
        }
    }

    public b(com.bytedance.j.xt.j.a aVar, String str, int i6) {
        super(str, i6);
        this.f24206b = 5000;
        this.f24207c = true;
        if (aVar != null && !TextUtils.isEmpty(str)) {
            this.f24205a = aVar;
            return;
        }
        throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
    }
}
