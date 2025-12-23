package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.InteractionModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.layout.LayoutModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.ViewModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class RenderModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "layer")
    private int f55518a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "uid")
    private String f55519b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "superView")
    private String f55520c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "")
    private LayoutModel f55521d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = "")
    private ViewModel f55522e;

    /* renamed from: f, reason: collision with root package name */
    @JsonParseNode(key = "")
    private InteractionModel f55523f;

    public String a() {
        return this.f55519b;
    }

    public InteractionModel b() {
        return this.f55523f;
    }

    public int c() {
        return this.f55518a;
    }

    public LayoutModel d() {
        return this.f55521d;
    }

    public String e() {
        return this.f55520c;
    }

    public ViewModel f() {
        return this.f55522e;
    }

    public RenderModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
