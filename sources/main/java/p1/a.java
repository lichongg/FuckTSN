package p1;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q1.d;
import r1.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f51773a = "a";

    /* renamed from: b, reason: collision with root package name */
    private static d f51774b;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f51775c = new Object();

    public static synchronized d a(Context context) {
        synchronized (a.class) {
            synchronized (f51775c) {
                d dVar = f51774b;
                if (dVar != null) {
                    return dVar;
                }
                String a6 = c.a(GrsApp.getInstance().getBrand("/") + "grs_sdk_server_config.json", context);
                ArrayList arrayList = null;
                if (TextUtils.isEmpty(a6)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(a6).getJSONObject("grs_server");
                    JSONArray jSONArray = jSONObject.getJSONArray("grs_base_url");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        arrayList = new ArrayList();
                        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                            arrayList.add(jSONArray.get(i6).toString());
                        }
                    }
                    d dVar2 = new d();
                    f51774b = dVar2;
                    dVar2.d(arrayList);
                    f51774b.c(jSONObject.getString("grs_query_endpoint_2.0"));
                    f51774b.b(jSONObject.getInt("grs_query_timeout"));
                } catch (JSONException e6) {
                    Logger.w(f51773a, "getGrsServerBean catch JSONException: %s", StringUtils.anonymizeMessage(e6.getMessage()));
                }
                return f51774b;
            }
        }
    }
}
