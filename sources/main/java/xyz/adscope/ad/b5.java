package xyz.adscope.ad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.AssetModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.type.ImageModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.type.VideoModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class b5 implements o2 {

    /* renamed from: a, reason: collision with root package name */
    private o2 f54880a;

    /* renamed from: c, reason: collision with root package name */
    private o2 f54882c;

    /* renamed from: d, reason: collision with root package name */
    private final b4 f54883d;

    /* renamed from: e, reason: collision with root package name */
    private final a4 f54884e;

    /* renamed from: g, reason: collision with root package name */
    private final Map<String, o2> f54886g;

    /* renamed from: f, reason: collision with root package name */
    private boolean f54885f = false;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, o2> f54881b = new HashMap();

    @Override // xyz.adscope.ad.o2
    public void a(o2 o2Var) {
        this.f54881b.put(o2Var.e(), o2Var);
    }

    public void b(o2 o2Var) {
        this.f54880a = o2Var;
    }

    @Override // xyz.adscope.ad.o2
    public b4 c() {
        return this.f54883d;
    }

    @Override // xyz.adscope.ad.o2
    public a4 a() {
        return this.f54884e;
    }

    @Override // xyz.adscope.ad.o2
    public boolean b() {
        return this.f54885f;
    }

    public void c(o2 o2Var) {
        this.f54882c = o2Var;
    }

    @Override // xyz.adscope.ad.o2
    public o2 d() {
        return this.f54880a;
    }

    @Override // xyz.adscope.ad.o2
    public String e() {
        return this.f54883d.getScopeViewID();
    }

    public int f() {
        Map<String, o2> map = this.f54881b;
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    public List<o2> g() {
        Map<String, o2> map = this.f54881b;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return new ArrayList(this.f54881b.values());
    }

    public Map<String, o2> h() {
        return this.f54886g;
    }

    b5(b4 b4Var, RenderModel renderModel, Map<String, o2> map) {
        this.f54883d = b4Var;
        b4Var.setScopeViewID(renderModel.a());
        b4Var.a(renderModel);
        this.f54886g = map;
        map.put(e(), this);
        this.f54884e = new c5(b4Var.getContext(), renderModel.d(), this, renderModel.e());
    }

    public void a(AssetModel assetModel) {
        ImageModel b6 = assetModel.b();
        VideoModel d6 = assetModel.d();
        if (b6 != null) {
            this.f54884e.a(b6.b(), b6.a());
        }
        if (d6 != null) {
            this.f54884e.a(d6.f(), d6.e());
        }
        if (b6 != null || d6 != null) {
            this.f54885f = true;
        }
        this.f54883d.a(assetModel);
    }
}
