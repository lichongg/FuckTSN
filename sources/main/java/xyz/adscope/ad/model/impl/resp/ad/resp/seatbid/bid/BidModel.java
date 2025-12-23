package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid;

import com.umeng.analytics.pro.au;
import com.umeng.socialize.common.SocializeConstants;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.MediaModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class BidModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "price")
    private double f55439a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "burl")
    private String f55440b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "lurl")
    private String f55441c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = au.f40897b)
    private long f55442d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = SocializeConstants.KEY_PLATFORM)
    private MediaModel f55443e;

    /* renamed from: f, reason: collision with root package name */
    private String f55444f;

    /* renamed from: g, reason: collision with root package name */
    private String f55445g;

    public void a(String str) {
        this.f55444f = str;
    }

    public long b() {
        return this.f55442d;
    }

    public String a() {
        return this.f55444f;
    }

    public void b(String str) {
        this.f55445g = str;
    }

    public String c() {
        return this.f55441c;
    }

    public MediaModel d() {
        return this.f55443e;
    }

    public double e() {
        return this.f55439a;
    }

    public String f() {
        return this.f55440b;
    }

    public BidModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
