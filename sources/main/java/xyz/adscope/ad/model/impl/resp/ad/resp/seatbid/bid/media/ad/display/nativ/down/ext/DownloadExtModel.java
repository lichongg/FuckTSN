package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down.ext;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DownloadExtModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "dialog")
    private int f55492a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "jumpStore")
    private int f55493b;

    public boolean a() {
        return this.f55493b == 0;
    }

    public boolean b() {
        return this.f55492a == 0;
    }

    public DownloadExtModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
