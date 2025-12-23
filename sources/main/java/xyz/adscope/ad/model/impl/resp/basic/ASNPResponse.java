package xyz.adscope.ad.model.impl.resp.basic;

import android.text.TextUtils;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ASNPResponse extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "code")
    private String f55593a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "data")
    private String f55594b;

    public String a() {
        return this.f55594b;
    }

    public ASNPResponse(JSONObject jSONObject) {
        super(jSONObject);
    }

    public boolean b() {
        if (!hasParseException() && "200".equals(this.f55593a) && !TextUtils.isEmpty(this.f55594b)) {
            return true;
        }
        return false;
    }
}
