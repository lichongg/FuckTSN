package cn.jiguang.br;

import android.content.Context;
import cn.jiguang.bb.f;
import cn.jiguang.d.b;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class a {

    /* renamed from: b, reason: collision with root package name */
    private static String f2541b = UUID.randomUUID().toString();

    /* renamed from: a, reason: collision with root package name */
    private String f2542a;

    /* renamed from: c, reason: collision with root package name */
    private String f2543c = UUID.randomUUID().toString();

    /* renamed from: d, reason: collision with root package name */
    private long f2544d;

    public abstract JSONObject a();

    public String c() {
        return this.f2543c;
    }

    public a(Context context, String str) {
        long b6;
        this.f2542a = str;
        if (context == null) {
            b6 = System.currentTimeMillis() / 1000;
        } else {
            b6 = b.b(context);
        }
        this.f2544d = b6;
    }

    public JSONObject b() {
        JSONObject a6 = a();
        if (a6 != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("moniter_type", this.f2542a);
                jSONObject.put("uuid", f2541b);
                jSONObject.put("moniter_id", this.f2543c);
                jSONObject.put("timestamp", this.f2544d);
                jSONObject.put(JThirdPlatFormInterface.KEY_EXTRA, a6);
                return jSONObject;
            } catch (JSONException e6) {
                f.c("BaseMoniter", "build baseMoniter data error" + e6.getMessage());
                return null;
            }
        }
        return null;
    }
}
