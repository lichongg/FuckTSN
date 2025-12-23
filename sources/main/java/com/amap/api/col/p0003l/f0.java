package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.g4;
import com.amap.api.maps.AMapException;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class f0 extends b1<String, d0> {
    private static d0 h(JSONObject jSONObject) throws AMapException {
        d0 d0Var = new d0();
        try {
            String optString = jSONObject.optString("update", "");
            if (optString.equals("0")) {
                d0Var.b(false);
            } else if (optString.equals("1")) {
                d0Var.b(true);
            }
            d0Var.a(jSONObject.optString("version", ""));
            return d0Var;
        } catch (Throwable th) {
            v5.p(th, "OfflineInitHandlerAbstract", "loadData parseJson");
            return d0Var;
        }
    }

    @Override // com.amap.api.col.p0003l.b1
    protected final String b() {
        return "016";
    }

    @Override // com.amap.api.col.p0003l.b1
    protected final JSONObject c(g4.c cVar) {
        JSONObject jSONObject;
        if (cVar == null || (jSONObject = cVar.f6322f) == null) {
            return null;
        }
        return jSONObject.optJSONObject("016");
    }

    @Override // com.amap.api.col.p0003l.b1
    protected final Map<String, String> e() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.f5687a);
        return hashtable;
    }

    public f0(Context context, String str) {
        super(context, str);
    }

    @Override // com.amap.api.col.p0003l.b1
    protected final /* synthetic */ d0 a(JSONObject jSONObject) throws AMapException {
        return h(jSONObject);
    }
}
