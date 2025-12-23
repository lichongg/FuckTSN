package xyz.adscope.ad;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import xyz.adscope.ad.a4;
import xyz.adscope.ad.b4;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.MediaModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.DisplayModel;
import xyz.adscope.ad.z3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class j6 implements w3, k2 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f55278a;

    /* renamed from: b, reason: collision with root package name */
    private xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a f55279b;

    /* renamed from: c, reason: collision with root package name */
    private h2 f55280c;

    /* renamed from: d, reason: collision with root package name */
    private final y3 f55281d = new y3();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j6.this.f55281d.a();
            j6.this.f55279b.measure(0, 0);
            int measuredHeight = j6.this.f55279b.getMeasuredHeight();
            int measuredWidth = j6.this.f55279b.getMeasuredWidth();
            j6 j6Var = j6.this;
            j6Var.a(j6Var.f55280c, new int[]{measuredWidth, measuredHeight});
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements a4.a {
        private b() {
        }

        /* synthetic */ b(j6 j6Var, a aVar) {
            this();
        }

        @Override // xyz.adscope.ad.a4.a
        public void b(o2 o2Var) {
            j6.this.a(o2Var);
        }

        @Override // xyz.adscope.ad.a4.a
        public void a(o2 o2Var) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements b4.a {
        private c() {
        }

        /* synthetic */ c(j6 j6Var, a aVar) {
            this();
        }

        @Override // xyz.adscope.ad.b4.a
        public void a(String str) {
            if (j6.this.f55280c != null) {
                Object c6 = j6.this.f55280c.a(str).c();
                if (c6 instanceof View) {
                    j6.this.f55279b.removeView((View) c6);
                }
            }
        }

        @Override // xyz.adscope.ad.b4.a
        public void b(String str) {
        }
    }

    @Override // xyz.adscope.ad.w3
    public View getExpressView() {
        return null;
    }

    @Override // xyz.adscope.ad.w3
    public void b() {
        h2 h2Var = this.f55280c;
        if (h2Var == null || !h2Var.c()) {
            return;
        }
        this.f55279b.post(new a());
    }

    @Override // xyz.adscope.ad.k2
    public j2 c() {
        return this.f55281d;
    }

    public j6(Context context, a2 a2Var) {
        this.f55278a = context;
    }

    private DisplayModel b(MediaModel mediaModel) {
        if (mediaModel == null || mediaModel.a() == null) {
            return null;
        }
        return mediaModel.a().b();
    }

    public void a(xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a aVar) {
        this.f55279b = aVar;
    }

    @Override // xyz.adscope.ad.w3
    public boolean a(MediaModel mediaModel) {
        this.f55281d.a((Object) null);
        if (mediaModel.a() == null) {
            return false;
        }
        this.f55280c = r1.a().b(this.f55278a, b(mediaModel), null);
        return false;
    }

    @Override // xyz.adscope.ad.w3
    public void a() {
        this.f55281d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h2 h2Var, int[] iArr) {
        o2 e6 = h2Var.e();
        if (e6.a() == null || iArr.length != 2) {
            return;
        }
        int i6 = iArr[0];
        int i7 = iArr[1];
        e6.a().b(i6);
        e6.a().c(i7);
        e6.a().a(new b(this, null));
        e6.a().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(o2 o2Var) {
        ViewGroup viewGroup;
        b4 c6 = o2Var.c();
        if (c6 != 0) {
            View view = (View) c6;
            if (o2Var.d() == null) {
                viewGroup = this.f55279b;
            } else {
                Object c7 = o2Var.d().c();
                if (c7 instanceof ViewGroup) {
                    viewGroup = (ViewGroup) c7;
                } else {
                    viewGroup = this.f55279b;
                }
            }
            RelativeLayout.LayoutParams e6 = o2Var.a().e();
            if (viewGroup != null && e6 != null) {
                if ((view instanceof c6) || (view instanceof z5)) {
                    ((ViewGroup.LayoutParams) e6).width = -2;
                }
                view.setLayoutParams(e6);
                this.f55281d.a(z3.a.SINGLE_VIEW_RENDERED, o2Var);
                int childCount = c6.getLayer() == 1 ? 0 : viewGroup.getChildCount();
                if (viewGroup == this.f55279b && viewGroup.getChildCount() > 0) {
                    viewGroup.addView(view, 1);
                } else {
                    viewGroup.addView(view, childCount);
                }
                c6.a(new c(this, null));
            }
            c6.setExpressRoot(this.f55279b);
            this.f55279b.requestLayout();
        }
    }
}
