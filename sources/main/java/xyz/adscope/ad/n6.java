package xyz.adscope.ad;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import xyz.adscope.ad.b4;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.AssetModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.ViewModel;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class n6 extends RelativeLayout implements b4 {

    /* renamed from: a, reason: collision with root package name */
    private String f55726a;

    /* renamed from: b, reason: collision with root package name */
    protected RenderModel f55727b;

    /* renamed from: c, reason: collision with root package name */
    protected AssetModel f55728c;

    /* renamed from: d, reason: collision with root package name */
    private xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a f55729d;

    public void a(RenderModel renderModel) {
        this.f55727b = renderModel;
    }

    @Override // xyz.adscope.ad.b4
    public void a(AssetModel assetModel) {
        this.f55728c = assetModel;
    }

    @Override // xyz.adscope.ad.b4
    public xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a getExpressRoot() {
        return this.f55729d;
    }

    @Override // xyz.adscope.ad.b4
    public int getLayer() {
        return this.f55727b.c();
    }

    @Override // xyz.adscope.ad.b4
    public String getScopeViewID() {
        return this.f55726a;
    }

    public void setExpressRoot(xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a aVar) {
        this.f55729d = aVar;
    }

    @Override // xyz.adscope.ad.b4
    public void setScopeViewID(String str) {
        this.f55726a = str;
        setId(StringUtil.parseInt(str));
    }

    public n6(Context context) {
        super(context);
    }

    private void d() {
        if (getChildCount() > 0) {
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                KeyEvent.Callback childAt = getChildAt(i6);
                if (childAt instanceof b4) {
                    ((b4) childAt).b();
                }
            }
        }
    }

    private void e() {
        if (getChildCount() > 0) {
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                KeyEvent.Callback childAt = getChildAt(i6);
                if (childAt instanceof b4) {
                    ((b4) childAt).c();
                }
            }
        }
    }

    public void a() {
        if (getChildCount() > 0) {
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                KeyEvent.Callback childAt = getChildAt(i6);
                if (childAt instanceof b4) {
                    ((b4) childAt).a();
                }
            }
        }
    }

    public void b() {
        d();
    }

    public void c() {
        e();
    }

    public void a(b4.a aVar) {
        n6 n6Var;
        RenderModel renderModel = this.f55727b;
        if (renderModel != null) {
            ViewModel f6 = renderModel.f();
            if (f6 != null) {
                n6Var = this;
                q6.a(getContext(), n6Var, b7.a().a(f6.c()), StringUtil.parseInt(f6.f()), f6.d(), q6.a(f6.e(), getLayoutParams().height));
            } else {
                n6Var = this;
            }
            aVar.b(n6Var.f55727b.a());
        }
    }
}
