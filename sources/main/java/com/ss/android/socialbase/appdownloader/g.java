package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.downloader.cw;
import com.ss.android.socialbase.downloader.j.j;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: D:\Downloads\app\classes6.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final Queue<Integer> f38441a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f38442b;

    /* renamed from: c, reason: collision with root package name */
    private long f38443c;

    /* renamed from: d, reason: collision with root package name */
    private long f38444d;

    /* renamed from: e, reason: collision with root package name */
    private SoftReference<JumpUnknownSourceActivity> f38445e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f38446f;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f38447g;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.b();
        }
    }

    class b implements j.InterfaceC0786j {
        b() {
        }

        @Override // com.ss.android.socialbase.downloader.j.j.InterfaceC0786j
        public void xt() {
            boolean hasCallbacks;
            if (g.this.f38441a.isEmpty()) {
                return;
            }
            long j6 = com.ss.android.socialbase.downloader.jy.j.cw().j("install_on_resume_install_interval", 120000L);
            long currentTimeMillis = System.currentTimeMillis() - g.this.f38444d;
            if (currentTimeMillis >= j6) {
                g.this.f38444d = System.currentTimeMillis();
                g.this.b();
            } else {
                hasCallbacks = g.this.f38446f.hasCallbacks(g.this.f38447g);
                if (hasCallbacks) {
                    return;
                }
                g.this.f38446f.postDelayed(g.this.f38447g, j6 - currentTimeMillis);
            }
        }

        @Override // com.ss.android.socialbase.downloader.j.j.InterfaceC0786j
        public void cw() {
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f38450a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Integer f38451b;

        c(Context context, Integer num) {
            this.f38450a = context;
            this.f38451b = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.m(this.f38450a, this.f38451b.intValue(), false);
        }
    }

    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f38453a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f38454b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f38455c;

        d(Context context, int i6, boolean z5) {
            this.f38453a = context;
            this.f38454b = i6;
            this.f38455c = z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.c(this.f38453a, this.f38454b, this.f38455c);
        }
    }

    private static class e {

        /* renamed from: a, reason: collision with root package name */
        private static final g f38457a = new g(null);
    }

    /* synthetic */ g(a aVar) {
        this();
    }

    private g() {
        this.f38441a = new ArrayDeque();
        this.f38442b = false;
        this.f38446f = new Handler(Looper.getMainLooper());
        this.f38447g = new a();
        com.ss.android.socialbase.downloader.j.j.j().j(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Integer poll;
        if (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.j.j.j().xt()) {
            synchronized (this.f38441a) {
                poll = this.f38441a.poll();
            }
            this.f38446f.removeCallbacks(this.f38447g);
            if (poll == null) {
                this.f38442b = false;
                return;
            }
            Context nd = cw.nd();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.f38446f.post(new c(nd, poll));
            } else {
                m(nd, poll.intValue(), false);
            }
            this.f38446f.postDelayed(this.f38447g, 20000L);
        }
    }

    public int c(Context context, int i6, boolean z5) {
        if (z5) {
            return m(context, i6, z5);
        }
        if (k()) {
            this.f38446f.postDelayed(new d(context, i6, z5), 1000L);
            return 1;
        }
        if (com.ss.android.socialbase.downloader.j.j.j().xt()) {
            com.ss.android.socialbase.downloader.m.j.cw("leaves", "on Foreground");
            return m(context, i6, z5);
        }
        if (j.m()) {
            return 1;
        }
        boolean z6 = Build.VERSION.SDK_INT < 29;
        if (this.f38441a.isEmpty() && !this.f38442b && z6) {
            return m(context, i6, z5);
        }
        int j6 = com.ss.android.socialbase.downloader.jy.j.cw().j("install_queue_size", 3);
        synchronized (this.f38441a) {
            while (this.f38441a.size() > j6) {
                try {
                    this.f38441a.poll();
                } finally {
                }
            }
        }
        if (z6) {
            this.f38446f.removeCallbacks(this.f38447g);
            this.f38446f.postDelayed(this.f38447g, com.ss.android.socialbase.downloader.jy.j.j(i6).j("install_queue_timeout", 20000L));
        }
        synchronized (this.f38441a) {
            try {
                if (!this.f38441a.contains(Integer.valueOf(i6))) {
                    this.f38441a.offer(Integer.valueOf(i6));
                }
            } finally {
            }
        }
        return 1;
    }

    public void h(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.f38445e = new SoftReference<>(jumpUnknownSourceActivity);
    }

    void i(com.ss.android.socialbase.downloader.ae.cw cwVar, String str) {
        if (cwVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        b();
    }

    public JumpUnknownSourceActivity n() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.f38445e;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.f38445e = null;
        return jumpUnknownSourceActivity;
    }

    public static g f() {
        return e.f38457a;
    }

    private boolean k() {
        if (System.currentTimeMillis() - this.f38443c < 1000) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int m(Context context, int i6, boolean z5) {
        int J = com.ss.android.socialbase.appdownloader.b.J(context, i6, z5);
        if (J == 1) {
            this.f38442b = true;
        }
        this.f38443c = System.currentTimeMillis();
        return J;
    }
}
