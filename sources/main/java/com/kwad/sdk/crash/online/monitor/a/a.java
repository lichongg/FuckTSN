package com.kwad.sdk.crash.online.monitor.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public List<String> aPW = new ArrayList();
    public List<String> aPX = new ArrayList();
    public List<String> aPY = new ArrayList();
    public List<String> aPZ = new ArrayList();
    public List<b> aQa = new ArrayList();
    public Map<String, b> aQb = new HashMap();
    public int aQc;
    public int aQd;
    public int aQe;
    public double avY;

    public final boolean LQ() {
        return (this.aQe & 4) != 0;
    }

    public final boolean LR() {
        return (this.aQe & 1) != 0;
    }

    public final boolean LS() {
        return (this.aQe & 2) != 0;
    }

    public final boolean LT() {
        return this.aQe == 0;
    }

    @Nullable
    public final b fN(String str) {
        if (this.aQb != null) {
            r1 = TextUtils.isEmpty(str) ? null : this.aQb.get(str);
            if (r1 == null) {
                return this.aQb.get("000000000");
            }
        }
        return r1;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        List<b> list = this.aQa;
        if (list != null) {
            for (b bVar : list) {
                this.aQb.put(bVar.appId, bVar);
            }
            this.aQa.clear();
        }
    }
}
