package xyz.adscope.ad;

import android.view.View;
import java.util.concurrent.TimeUnit;
import xyz.adscope.ad.a3;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.report.ReportModel;
import xyz.adscope.common.v2.dev.info.ScreenUtil;
import xyz.adscope.common.v2.thread.pool.IRemoveAbleScheduledTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class y2 implements j2<a3, ReportModel, View>, z2 {

    /* renamed from: a, reason: collision with root package name */
    private final View f56180a;

    /* renamed from: b, reason: collision with root package name */
    private final String f56181b;

    /* renamed from: c, reason: collision with root package name */
    private a3 f56182c;

    /* renamed from: d, reason: collision with root package name */
    private ReportModel f56183d;

    /* renamed from: e, reason: collision with root package name */
    private d f56184e;

    /* renamed from: f, reason: collision with root package name */
    private b f56185f = b.VIEW_PAUSE;

    /* renamed from: g, reason: collision with root package name */
    private int f56186g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum b {
        VIEW_RESUME,
        VIEW_PAUSE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements Runnable {
        private c() {
        }

        /* synthetic */ c(y2 y2Var, a aVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ScreenUtil.Calculate.checkViewVisibilityCoverage(y2.this.f56180a, 10)) {
                if (y2.this.f56185f == b.VIEW_PAUSE) {
                    y2 y2Var = y2.this;
                    y2Var.a(a3.a.AD_VIEW_SHOWN, y2Var.f56180a);
                }
                y2.this.f56185f = b.VIEW_RESUME;
            } else {
                if (y2.this.f56185f == b.VIEW_RESUME) {
                    y2 y2Var2 = y2.this;
                    y2Var2.a(a3.a.AD_VIEW_PAUSE, y2Var2.f56180a);
                }
                y2.this.f56185f = b.VIEW_PAUSE;
            }
            if (!ScreenUtil.Calculate.checkViewVisibilityCoverage(y2.this.f56180a, y2.this.f56183d.a())) {
                y2.this.f56185f = b.VIEW_PAUSE;
                return;
            }
            y2.this.f56185f = b.VIEW_RESUME;
            y2 y2Var3 = y2.this;
            y2Var3.a(a3.a.ADN_RECOGNIZE, y2Var3.f56180a);
            y2 y2Var4 = y2.this;
            y2Var4.a(a3.a.AD_EXPOSURE, y2Var4.f56180a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class d extends IRemoveAbleScheduledTask {
        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            startScheduled(0L, 100L, TimeUnit.MILLISECONDS);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            stopScheduled();
        }

        public d(Runnable runnable) {
            super(runnable);
        }
    }

    @Override // xyz.adscope.ad.z2
    public int b() {
        return ScreenUtil.Calculate.checkViewVisibilityCoverage(this.f56180a, this.f56186g) ? 1 : 0;
    }

    public void c() {
        d dVar = this.f56184e;
        if (dVar != null) {
            dVar.b();
        }
    }

    public y2(View view, String str) {
        this.f56180a = view;
        this.f56181b = str;
    }

    public void a(ReportModel reportModel) {
        this.f56183d = reportModel;
        this.f56186g = reportModel.a();
    }

    @Override // xyz.adscope.ad.j2
    public void a() {
        d dVar = new d(new c(this, null));
        this.f56184e = dVar;
        dVar.a();
    }

    public void a(l2 l2Var, View view) {
        a3 a3Var = this.f56182c;
        if (a3Var != null) {
            if (l2Var == a3.a.AD_EXPOSURE) {
                a3Var.a(l2Var, view);
            }
            if (l2Var == a3.a.ADN_RECOGNIZE) {
                this.f56182c.b(view);
            }
            if (l2Var == a3.a.AD_VIEW_SHOWN) {
                this.f56182c.b(l2Var, view);
            }
            if (l2Var == a3.a.AD_VIEW_PAUSE) {
                this.f56182c.a(view);
            }
        }
    }

    @Override // xyz.adscope.ad.j2
    public void a(a3 a3Var) {
        this.f56182c = a3Var;
        a3Var.a((a3) this);
    }
}
