package xyz.adscope.ad;

import android.content.Context;
import androidx.annotation.NonNull;
import xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.BasicWebView;
import xyz.adscope.ad.b4;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.AssetModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class o6 extends BasicWebView implements b4 {

    /* renamed from: a, reason: collision with root package name */
    private String f55756a;

    /* renamed from: b, reason: collision with root package name */
    protected RenderModel f55757b;

    /* renamed from: c, reason: collision with root package name */
    protected AssetModel f55758c;

    /* renamed from: d, reason: collision with root package name */
    private xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a f55759d;

    @Override // xyz.adscope.ad.b4
    public void a() {
    }

    @Override // xyz.adscope.ad.b4
    public void a(b4.a aVar) {
    }

    @Override // xyz.adscope.ad.b4
    public xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a getExpressRoot() {
        return this.f55759d;
    }

    @Override // xyz.adscope.ad.b4
    public int getLayer() {
        return this.f55757b.c();
    }

    @Override // xyz.adscope.ad.b4
    public String getScopeViewID() {
        return this.f55756a;
    }

    @Override // xyz.adscope.ad.b4
    public void setExpressRoot(xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a aVar) {
        this.f55759d = aVar;
    }

    @Override // xyz.adscope.ad.b4
    public void setScopeViewID(String str) {
        this.f55756a = str;
        setId(StringUtil.parseInt(str));
    }

    public o6(@NonNull Context context) {
        super(context);
    }

    @Override // xyz.adscope.ad.b4
    public void a(RenderModel renderModel) {
        this.f55757b = renderModel;
    }

    @Override // xyz.adscope.ad.b4
    public void a(AssetModel assetModel) {
        this.f55758c = assetModel;
    }

    @Override // xyz.adscope.ad.b4
    public void b() {
    }

    @Override // xyz.adscope.ad.b4
    public void c() {
    }
}
