package com.bytedance.j.xt.up;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class h implements Handler.Callback {

    /* renamed from: j, reason: collision with root package name */
    private static Printer f24257j;

    /* renamed from: k, reason: collision with root package name */
    private static h f24258k;

    /* renamed from: l, reason: collision with root package name */
    private static final Printer f24259l = new a();

    /* renamed from: c, reason: collision with root package name */
    private long f24262c;

    /* renamed from: d, reason: collision with root package name */
    private long f24263d;

    /* renamed from: i, reason: collision with root package name */
    private boolean f24268i;

    /* renamed from: b, reason: collision with root package name */
    private int f24261b = 0;

    /* renamed from: e, reason: collision with root package name */
    private final SparseArray<List<Runnable>> f24264e = new SparseArray<>();

    /* renamed from: f, reason: collision with root package name */
    private final List<Printer> f24265f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    private final List<Printer> f24266g = new LinkedList();

    /* renamed from: h, reason: collision with root package name */
    private boolean f24267h = false;

    /* renamed from: a, reason: collision with root package name */
    private Handler f24260a = new Handler(com.bytedance.j.xt.up.a.a().getLooper(), this);

    static class a implements Printer {
        @Override // android.util.Printer
        public void println(String str) {
            if (str == null) {
                return;
            }
            if (str.startsWith(">>>>> Dispatching")) {
                h.b().e(str);
            } else if (str.startsWith("<<<<< Finished")) {
                h.b().k(str);
            }
            if (h.f24257j == null || h.f24257j == h.f24259l) {
                return;
            }
            h.f24257j.println(str);
        }

        a() {
        }
    }

    private synchronized void g(List<? extends Printer> list, String str) {
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    Iterator<? extends Printer> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().println(str);
                    }
                } catch (Exception e6) {
                    com.bytedance.j.xt.tl.i.b(e6);
                }
            }
        }
    }

    public void c(long j6, Runnable runnable) {
        d(j6, runnable, 1, 0L);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.f24260a.hasMessages(0)) {
            return true;
        }
        int i6 = message.what;
        if (i6 == 0) {
            this.f24261b = 0;
            if (this.f24264e.size() != 0 && this.f24264e.keyAt(0) == 0) {
                f(this.f24264e.valueAt(0));
                this.f24261b++;
            }
        } else {
            if (i6 == 1) {
                this.f24260a.removeMessages(2);
                if (this.f24264e.size() != 0) {
                    SparseArray<List<Runnable>> sparseArray = this.f24264e;
                    if (sparseArray.keyAt(sparseArray.size() - 1) == 0) {
                        f(this.f24264e.get(Integer.MAX_VALUE));
                    }
                }
                return true;
            }
            if (i6 == 2) {
                f(this.f24264e.valueAt(this.f24261b));
                this.f24261b++;
            }
        }
        if (this.f24261b >= this.f24264e.size()) {
            return true;
        }
        long keyAt = this.f24264e.keyAt(this.f24261b);
        if (keyAt != 2147483647L) {
            this.f24260a.sendEmptyMessageAtTime(2, this.f24262c + keyAt);
        }
        return true;
    }

    public static h b() {
        if (f24258k == null) {
            synchronized (h.class) {
                try {
                    if (f24258k == null) {
                        f24258k = new h();
                    }
                } finally {
                }
            }
        }
        return f24258k;
    }

    private static void f(List<? extends Runnable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<? extends Runnable> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        } catch (Exception e6) {
            com.bytedance.j.xt.tl.i.b(e6);
        }
    }

    private Printer i() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception e6) {
            com.bytedance.j.xt.tl.i.c(e6);
            return null;
        }
    }

    public void d(long j6, Runnable runnable, int i6, long j7) {
        if (j6 < 0) {
            return;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = (int) j6;
            List<Runnable> list = this.f24264e.get(i8);
            if (list == null) {
                synchronized (this.f24264e) {
                    try {
                        list = this.f24264e.get(i8);
                        if (list == null) {
                            list = new LinkedList<>();
                            this.f24264e.put(i8, list);
                        }
                    } finally {
                    }
                }
            }
            list.add(runnable);
            j6 += j7;
        }
    }

    void e(String str) {
        if (!this.f24268i) {
            d.a(32L);
            this.f24268i = true;
        }
        this.f24262c = SystemClock.uptimeMillis();
        try {
            g(this.f24265f, str);
            this.f24260a.sendEmptyMessage(0);
        } catch (Exception e6) {
            com.bytedance.j.xt.tl.i.b(e6);
        }
    }

    public void j() {
        if (this.f24267h) {
            return;
        }
        this.f24267h = true;
        Printer i6 = i();
        f24257j = i6;
        Printer printer = f24259l;
        if (i6 == printer) {
            f24257j = null;
        }
        Looper.getMainLooper().setMessageLogging(printer);
    }

    private h() {
        j();
    }

    void k(String str) {
        this.f24263d = SystemClock.uptimeMillis();
        try {
            this.f24260a.removeMessages(2);
            g(this.f24266g, str);
            this.f24260a.sendEmptyMessage(1);
        } catch (Exception e6) {
            com.bytedance.j.xt.tl.i.c(e6);
        }
    }
}
