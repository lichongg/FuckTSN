package xyz.adscope.ad;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import xyz.adscope.ad.a4;
import xyz.adscope.ad.b4;
import xyz.adscope.ad.h2;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.MediaModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.DisplayModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;
import xyz.adscope.ad.z3;
import xyz.adscope.common.v2.dev.info.ScreenUtil;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class h6 implements w3, k2 {

    /* renamed from: a, reason: collision with root package name */
    private h2 f55208a;

    /* renamed from: b, reason: collision with root package name */
    private final y3 f55209b = new y3();

    /* renamed from: c, reason: collision with root package name */
    private final Context f55210c;

    /* renamed from: d, reason: collision with root package name */
    private final a2 f55211d;

    /* renamed from: e, reason: collision with root package name */
    private final l0 f55212e;

    /* renamed from: f, reason: collision with root package name */
    private xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a f55213f;

    /* renamed from: g, reason: collision with root package name */
    private AtomicInteger f55214g;

    /* renamed from: h, reason: collision with root package name */
    private String f55215h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements h2.a {
        a() {
        }

        @Override // xyz.adscope.ad.h2.a
        public List<RenderModel> a(String str) {
            return h6.this.f55212e.a(h6.this.f55211d.getAdType(), str);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements a4.a {
        private b() {
        }

        /* synthetic */ b(h6 h6Var, a aVar) {
            this();
        }

        @Override // xyz.adscope.ad.a4.a
        public void a(o2 o2Var) {
            if (h6.this.f55208a != null) {
                h6.this.f55208a.b();
                h6.this.b();
            }
        }

        @Override // xyz.adscope.ad.a4.a
        public void b(o2 o2Var) {
            h6.this.b(o2Var);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements b4.a {
        private c() {
        }

        /* synthetic */ c(h6 h6Var, a aVar) {
            this();
        }

        @Override // xyz.adscope.ad.b4.a
        public void a(String str) {
            if (h6.this.f55208a != null) {
                h6.this.a(h6.this.f55208a.a(str));
            }
        }

        @Override // xyz.adscope.ad.b4.a
        public void b(String str) {
            if (h6.this.f55208a != null) {
                h6.this.f55209b.a(z3.a.SINGLE_VIEW_RENDERED, h6.this.f55208a.a(str));
            }
            if (h6.this.f55214g == null || h6.this.f55214g.decrementAndGet() != 0) {
                return;
            }
            String f6 = h6.this.f55208a != null ? h6.this.f55208a.f() : "";
            if (!TextUtils.isEmpty(h6.this.f55215h) && !TextUtils.isEmpty(f6)) {
                h6.this.f55212e.a(h6.this.f55211d.getAdType(), h6.this.f55215h, f6);
            }
            h6.this.f55209b.a(z3.a.RENDER_SUCCESS, null);
        }
    }

    @Override // xyz.adscope.ad.k2
    public j2 c() {
        return this.f55209b;
    }

    @Override // xyz.adscope.ad.w3
    public View getExpressView() {
        return this.f55213f;
    }

    public h6(Context context, a2 a2Var) {
        this.f55210c = context;
        this.f55211d = a2Var;
        this.f55212e = m0.a().getOrCreateImplement(context);
    }

    private DisplayModel b(MediaModel mediaModel) {
        if (mediaModel == null || mediaModel.a() == null) {
            return null;
        }
        return mediaModel.a().b();
    }

    @Override // xyz.adscope.ad.w3
    public boolean a(MediaModel mediaModel) {
        if (mediaModel.a() == null) {
            return false;
        }
        this.f55209b.a((Object) null);
        DisplayModel b6 = b(mediaModel);
        this.f55208a = r1.a().b(this.f55210c, b6, new a());
        this.f55214g = new AtomicInteger(this.f55208a.d());
        this.f55213f = new xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a(this.f55210c, this.f55211d.getApiKey());
        h2 h2Var = this.f55208a;
        if (h2Var == null || !h2Var.c()) {
            return false;
        }
        if (b6 == null || b6.d() == null) {
            return true;
        }
        this.f55215h = b6.d().f();
        return true;
    }

    @Override // xyz.adscope.ad.w3
    public void b() {
        h2 h2Var = this.f55208a;
        if (h2Var != null && h2Var.c()) {
            this.f55209b.a();
            a(this.f55208a);
        } else {
            a((o2) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(o2 o2Var) {
        ViewGroup viewGroup;
        b4 c6 = o2Var.c();
        if (c6 != 0) {
            View view = (View) c6;
            if (o2Var.d() == null) {
                viewGroup = this.f55213f;
                float[] a6 = a(this.f55211d);
                int i6 = (int) a6[0];
                int i7 = (int) a6[1];
                if (i6 <= 0) {
                    i6 = -2;
                }
                if (i7 <= 0) {
                    i7 = -2;
                }
                viewGroup.setLayoutParams(new RelativeLayout.LayoutParams(i6, i7));
            } else {
                Object c7 = o2Var.d().c();
                if (c7 instanceof ViewGroup) {
                    viewGroup = (ViewGroup) c7;
                } else {
                    viewGroup = this.f55213f;
                }
            }
            RelativeLayout.LayoutParams e6 = o2Var.a().e();
            if (viewGroup != null && e6 != null) {
                if ((view instanceof c6) || (view instanceof z5)) {
                    ((ViewGroup.LayoutParams) e6).width = -2;
                }
                view.setLayoutParams(e6);
                viewGroup.addView(view, c6.getLayer() != 1 ? viewGroup.getChildCount() : 0);
                c6.a(new c(this, null));
            } else {
                a(o2Var);
            }
            c6.setExpressRoot(this.f55213f);
            this.f55213f.requestLayout();
            return;
        }
        a(o2Var);
    }

    @Override // xyz.adscope.ad.w3
    public void a() {
        h2 h2Var = this.f55208a;
        if (h2Var != null) {
            h2Var.a();
            this.f55208a = null;
        }
        y3 y3Var = this.f55209b;
        if (y3Var != null) {
            y3Var.b();
        }
    }

    private void a(h2 h2Var) {
        o2 e6 = h2Var.e();
        a aVar = null;
        if (e6.a() != null) {
            float[] a6 = a(this.f55211d);
            SDKLog.i("Render", "广告展示大小 " + a6[0] + " " + a6[1]);
            if (a6.length == 2) {
                int i6 = (int) a6[0];
                int i7 = (int) a6[1];
                e6.a().b(i6);
                e6.a().c(i7);
                e6.a().a(new b(this, aVar));
                e6.a().d();
                return;
            }
        }
        a((o2) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o2 o2Var) {
        this.f55209b.a(z3.a.RENDER_FAILED, o2Var);
    }

    private float[] a(a2 a2Var) {
        float[] expressViewSizePixel = a2Var.getExpressViewSizePixel();
        if (a2Var.getAdType() == xyz.adscope.ad.c.SPLASH) {
            if (expressViewSizePixel[0] <= 0.0f) {
                expressViewSizePixel[0] = ScreenUtil.getScreenWidth(this.f55210c);
            }
            if (expressViewSizePixel[1] <= 0.0f) {
                expressViewSizePixel[1] = ScreenUtil.getScreenHeight(this.f55210c);
            }
        }
        return expressViewSizePixel;
    }
}
