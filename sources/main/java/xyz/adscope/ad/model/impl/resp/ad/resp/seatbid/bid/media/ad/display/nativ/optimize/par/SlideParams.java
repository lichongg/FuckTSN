package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize.par;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class SlideParams extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "randomNum")
    private int f55515a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "distance")
    private int f55516b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "needTime")
    private int f55517c;

    public int a() {
        return this.f55516b;
    }

    public int b() {
        return this.f55517c;
    }

    public int c() {
        return this.f55515a;
    }

    public SlideParams(JSONObject jSONObject) {
        super(jSONObject);
    }
}
