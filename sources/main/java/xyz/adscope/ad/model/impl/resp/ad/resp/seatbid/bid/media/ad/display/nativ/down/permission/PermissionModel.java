package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down.permission;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class PermissionModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "permissionType")
    private String f55494a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "describe")
    private String f55495b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "title")
    private String f55496c;

    public String a() {
        return this.f55495b;
    }

    public String b() {
        return this.f55494a;
    }

    public String c() {
        return this.f55496c;
    }

    public PermissionModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
