package xyz.adscope.ad;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.beizi.fusion.widget.ScrollClickView;
import xyz.adscope.ad.b4;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.AssetModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.ViewModel;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class i6 extends TextView implements b4 {

    /* renamed from: a, reason: collision with root package name */
    private final String f55251a;

    /* renamed from: b, reason: collision with root package name */
    private final String f55252b;

    /* renamed from: c, reason: collision with root package name */
    private String f55253c;

    /* renamed from: d, reason: collision with root package name */
    protected RenderModel f55254d;

    /* renamed from: e, reason: collision with root package name */
    protected AssetModel f55255e;

    /* renamed from: f, reason: collision with root package name */
    private xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a f55256f;

    @Override // xyz.adscope.ad.b4
    public void a() {
    }

    @Override // xyz.adscope.ad.b4
    public void a(RenderModel renderModel) {
        this.f55254d = renderModel;
    }

    protected void d() {
        AssetModel assetModel = this.f55255e;
        String p5 = (assetModel == null || assetModel.c() == null) ? this.f55254d.f() != null ? this.f55254d.f().p() : null : this.f55255e.c().a();
        if (TextUtils.isEmpty(p5)) {
            return;
        }
        setText(p5);
    }

    @Override // xyz.adscope.ad.b4
    public xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a getExpressRoot() {
        return this.f55256f;
    }

    @Override // xyz.adscope.ad.b4
    public int getLayer() {
        return this.f55254d.c();
    }

    @Override // xyz.adscope.ad.b4
    public String getScopeViewID() {
        return this.f55253c;
    }

    @Override // xyz.adscope.ad.b4
    public void setExpressRoot(xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a aVar) {
        this.f55256f = aVar;
    }

    @Override // xyz.adscope.ad.b4
    public void setScopeViewID(String str) {
        this.f55253c = str;
        setId(StringUtil.parseInt(str));
    }

    public i6(@NonNull Context context) {
        super(context);
        this.f55251a = ScrollClickView.DIR_LEFT;
        this.f55252b = "right";
    }

    @Override // xyz.adscope.ad.b4
    public void a(AssetModel assetModel) {
        this.f55255e = assetModel;
    }

    public void setTextConfig(ViewModel viewModel) {
        int m6 = viewModel.m();
        if (m6 > 0) {
            setLines(m6);
        }
        setTextSize(2, viewModel.i());
        if (StringUtil.isValidColor(viewModel.o())) {
            setTextColor(Color.parseColor(viewModel.o()));
        }
        String n6 = viewModel.n();
        if (!TextUtils.isEmpty(n6)) {
            n6.getClass();
            if (!n6.equals(ScrollClickView.DIR_LEFT)) {
                if (!n6.equals("right")) {
                    setGravity(17);
                    return;
                } else {
                    setGravity(21);
                    return;
                }
            }
            setGravity(19);
        }
    }

    @Override // xyz.adscope.ad.b4
    public void a(b4.a aVar) {
        RenderModel renderModel = this.f55254d;
        if (renderModel == null || renderModel.f() == null) {
            return;
        }
        ViewModel f6 = this.f55254d.f();
        q6.a(getContext(), this, f6.c(), StringUtil.parseInt(f6.f()), f6.d(), q6.a(f6.e(), getLayoutParams().height));
        setTextConfig(f6);
        d();
        aVar.b(this.f55254d.a());
    }

    public void b() {
    }

    public void c() {
    }
}
