package v0;

import com.bytedance.sdk.component.utils.vl;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f54679a = "tobsdk_livesdk_live_show";

    /* renamed from: b, reason: collision with root package name */
    public static final String f54680b = "tobsdk_livesdk_rec_live_play";

    /* renamed from: c, reason: collision with root package name */
    public static final String f54681c = "tobsdk_livesdk_live_window_duration_v2";

    private static JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject;
        } catch (Exception e6) {
            vl.j(e6);
            return jSONObject;
        }
    }

    public static JSONObject b(c cVar) {
        return c(cVar, new HashMap());
    }

    public static JSONObject c(c cVar, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.g());
        map.put("room_id", sb.toString());
        map.put("anchor_id", cVar.b());
        map.put("enter_from_merge", cVar.d().lowerName());
        map.put("enter_method", cVar.e().lowerName());
        map.put("action_type", cVar.a().lowerName());
        map.put("request_id", cVar.f());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cVar.c());
        map.put("duration", sb2.toString());
        map.put("is_other_channel", "union_ad");
        return a(map);
    }
}
