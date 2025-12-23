package com.beizi.ad.lance.a;

import android.graphics.Rect;
import android.view.View;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private View f12750a;

    /* renamed from: b, reason: collision with root package name */
    private com.beizi.ad.internal.e.e f12751b;

    /* renamed from: c, reason: collision with root package name */
    private com.beizi.ad.internal.e.g f12752c;

    /* renamed from: d, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f12753d;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f12754e;

    /* renamed from: f, reason: collision with root package name */
    private DecimalFormatSymbols f12755f = new DecimalFormatSymbols(Locale.ENGLISH);

    /* renamed from: g, reason: collision with root package name */
    private Format f12756g = new DecimalFormat("0.00", this.f12755f);

    /* renamed from: h, reason: collision with root package name */
    private boolean f12757h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f12758i = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.lance.a.f$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f12754e = new Runnable() { // from class: com.beizi.ad.lance.a.f.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.f12757h || f.this.a(10)) {
                        if (!f.this.f12757h && f.this.f12752c != null) {
                            f.this.f12757h = true;
                            f.this.f12752c.a();
                        }
                        if (!f.this.f12758i && f.this.a(50)) {
                            f.this.f12758i = true;
                            if (f.this.f12753d != null) {
                                f.this.f12753d.remove(f.this.f12754e);
                                f.this.f12753d = null;
                            }
                            if (f.this.f12750a != null) {
                                f.this.f12750a.post(new Runnable() { // from class: com.beizi.ad.lance.a.f.1.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (f.this.f12751b != null) {
                                            f.this.f12751b.a();
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            };
            f.this.f12753d = c.b().g();
            if (f.this.f12753d == null) {
                return;
            }
            f.this.f12753d.scheduleWithFixedDelay(f.this.f12754e, 0L, 250L, TimeUnit.MILLISECONDS);
        }
    }

    public f(View view, com.beizi.ad.internal.e.e eVar, com.beizi.ad.internal.e.g gVar) {
        this.f12750a = view;
        this.f12751b = eVar;
        this.f12752c = gVar;
        b();
    }

    private void b() {
        View view = this.f12750a;
        if (view == null) {
            return;
        }
        view.post(new AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i6) {
        try {
            View view = this.f12750a;
            if (view != null && view.getVisibility() == 0 && this.f12750a.getParent() != null) {
                Rect rect = new Rect();
                if (!this.f12750a.getGlobalVisibleRect(rect)) {
                    return false;
                }
                int height = rect.height() * rect.width();
                int height2 = this.f12750a.getHeight() * this.f12750a.getWidth();
                return height2 > 0 && height * 100 >= i6 * height2;
            }
            return false;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public void a() {
        Runnable runnable;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f12753d;
            if (scheduledThreadPoolExecutor != null && (runnable = this.f12754e) != null) {
                scheduledThreadPoolExecutor.remove(runnable);
            }
            this.f12752c = null;
            this.f12751b = null;
            this.f12750a = null;
            this.f12753d = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
