package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.link;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class LinkModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "interact_type")
    private int f55497a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "urlfb")
    private String f55498b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "urldw")
    private String f55499c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "url")
    private String f55500d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = "urlmk")
    private String f55501e;

    public String a() {
        return this.f55498b;
    }

    public String b() {
        return this.f55499c;
    }

    public int c() {
        return this.f55497a;
    }

    public String d() {
        return this.f55500d;
    }

    public String e() {
        return this.f55501e;
    }

    public LinkModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
