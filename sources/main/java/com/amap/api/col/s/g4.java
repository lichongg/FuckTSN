package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class g4 extends f4<j, CloudItemDetail> {
    private static CloudItemDetail Z(String str) throws AMapException {
        if (str != null && !str.equals("")) {
            try {
                return a0(new JSONObject(str));
            } catch (JSONException e6) {
                e6.printStackTrace();
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.f() + "/datasearch/id";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3, com.amap.api.col.s.dz
    public final Map<String, String> o() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", x0.i(this.f7866q));
        hashtable.put("layerId", ((j) this.f7863n).f8169a);
        hashtable.put("output", "json");
        hashtable.put("id", ((j) this.f7863n).f8170b);
        String a6 = a1.a();
        String c6 = a1.c(this.f7866q, a6, j1.r(hashtable));
        hashtable.put("ts", a6);
        hashtable.put("scode", c6);
        return hashtable;
    }

    public g4(Context context, j jVar) {
        super(context, jVar);
    }

    private static CloudItemDetail a0(JSONObject jSONObject) throws JSONException {
        JSONArray U = f4.U(jSONObject);
        if (U != null && U.length() > 0) {
            JSONObject jSONObject2 = U.getJSONObject(0);
            CloudItemDetail X = f4.X(jSONObject2);
            f4.V(X, jSONObject2);
            return X;
        }
        return null;
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    public final /* synthetic */ Object I(String str) throws AMapException {
        return Z(str);
    }
}
