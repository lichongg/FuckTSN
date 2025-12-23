package com.bytedance.msdk.up;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.tl.l;
import com.bytedance.msdk.tl.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae extends j {

    /* renamed from: r, reason: collision with root package name */
    private static final SimpleDateFormat f25242r = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    public static ae j(Context context, r rVar, JSONObject jSONObject) {
        return new ae(UUID.randomUUID().toString(), xt(context, rVar, jSONObject));
    }

    private static JSONObject xt(Context context, r rVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("event", rVar.f25313j);
            jSONObject2.putOpt("params", jSONObject);
            jSONObject2.putOpt("nt", Integer.valueOf(x.up()));
            jSONObject2.putOpt("datetime", f25242r.format(new Date()));
            return jSONObject2;
        } catch (Exception e6) {
            try {
                JSONObject optJSONObject = jSONObject2.optJSONObject("params");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("event_extra");
                    if (!TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject3 = new JSONObject(optString);
                        jSONObject3.putOpt("v3_err_msg", e6.toString());
                        optJSONObject.putOpt("event_extra", jSONObject3.toString());
                    }
                }
                if (rVar != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.putOpt("v3_eventId", rVar.f25310f.get("event_id"));
                    jSONObject4.putOpt("v3_err_msg", e6.toString());
                    l.j(jSONObject4);
                }
            } catch (Throwable unused) {
            }
            return jSONObject2;
        }
    }

    @Override // com.bytedance.msdk.up.j
    public String toString() {
        return "AdEventV3{localId='" + this.f25248j + "', event=" + this.xt + '}';
    }

    public ae(String str, JSONObject jSONObject) {
        super(str, jSONObject);
    }
}
