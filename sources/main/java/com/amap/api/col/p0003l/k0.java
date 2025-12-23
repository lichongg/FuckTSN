package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.g4;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class k0 extends b1<String, List<OfflineMapProvince>> {

    /* renamed from: d, reason: collision with root package name */
    private Context f6663d;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0003l.b1
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public List<OfflineMapProvince> a(JSONObject jSONObject) throws AMapException {
        try {
            if (this.f6663d != null) {
                a1.p(jSONObject.toString(), this.f6663d);
            }
        } catch (Throwable th) {
            v5.p(th, "OfflineUpdateCityHandlerAbstract", "loadData jsonInit");
            th.printStackTrace();
        }
        try {
            Context context = this.f6663d;
            if (context != null) {
                return a1.g(jSONObject, context);
            }
            return null;
        } catch (JSONException e6) {
            v5.p(e6, "OfflineUpdateCityHandlerAbstract", "loadData parseJson");
            e6.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0003l.b1
    protected final String b() {
        return "015";
    }

    @Override // com.amap.api.col.p0003l.b1
    protected final JSONObject c(g4.c cVar) {
        JSONObject jSONObject;
        if (cVar == null || (jSONObject = cVar.f6322f) == null) {
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("015");
        if (!optJSONObject.has("result")) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", new JSONObject().put("offlinemap_with_province_vfour", optJSONObject));
                return jSONObject2;
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
        }
        return optJSONObject;
    }

    @Override // com.amap.api.col.p0003l.b1
    protected final Map<String, String> e() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.f5687a);
        return hashtable;
    }

    public final void h(Context context) {
        this.f6663d = context;
    }

    public k0(Context context, String str) {
        super(context, str);
    }
}
