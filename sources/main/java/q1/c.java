package q1;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final GrsBaseInfo f51971a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f51972b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<String> f51973c = new HashSet();

    private String f() {
        Set<String> f6 = com.huawei.hms.framework.network.grs.f.b.a(this.f51972b.getPackageName()).f();
        if (f6.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = f6.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.d("GrsRequestInfo", "post service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    private String g() {
        Logger.v("GrsRequestInfo", "getGeoipService enter");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f51973c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.v("GrsRequestInfo", "post query service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public Context a() {
        return this.f51972b;
    }

    public void b(String str) {
        this.f51973c.add(str);
    }

    public GrsBaseInfo c() {
        return this.f51971a;
    }

    public String d() {
        return this.f51973c.size() == 0 ? f() : g();
    }

    public Set<String> e() {
        return this.f51973c;
    }

    public c(GrsBaseInfo grsBaseInfo, Context context) {
        this.f51971a = grsBaseInfo;
        this.f51972b = context;
    }
}
