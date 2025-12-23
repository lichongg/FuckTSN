package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.event;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class EventModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "type")
    private int f55455a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "method")
    private int f55456b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "url")
    private String f55457c;

    public int a() {
        return this.f55456b;
    }

    public int b() {
        return this.f55455a;
    }

    public String c() {
        return this.f55457c;
    }

    public EventModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
