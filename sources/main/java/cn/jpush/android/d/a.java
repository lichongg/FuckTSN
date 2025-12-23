package cn.jpush.android.d;

import cn.jpush.android.api.JThirdPlatFormInterface;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a implements Serializable {
    private static final long serialVersionUID = -942487107643335186L;

    /* renamed from: a, reason: collision with root package name */
    public String f3581a;

    /* renamed from: b, reason: collision with root package name */
    public String f3582b;

    /* renamed from: c, reason: collision with root package name */
    public int f3583c;

    public a() {
        this.f3583c = -1;
    }

    public static a a(JSONObject jSONObject) {
        return new a(jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID), jSONObject.optString("override_msg_id"), jSONObject.optInt("msg_type", -1));
    }

    public a(d dVar) {
        this.f3583c = -1;
        this.f3581a = dVar.f3588d;
        this.f3582b = dVar.f3592h;
        this.f3583c = dVar.f3585a;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JThirdPlatFormInterface.KEY_MSG_ID, this.f3581a);
            jSONObject.put("override_msg_id", this.f3582b);
            jSONObject.put("msg_type", this.f3583c);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!a(this.f3581a, aVar.f3581a)) {
            return false;
        }
        int i6 = this.f3583c;
        return (i6 == -1 || i6 == aVar.f3583c) && a(this.f3582b, aVar.f3582b);
    }

    public String toString() {
        return "EntityKey{msg_id='" + this.f3581a + "', override_msg_id='" + this.f3582b + "', msgType=" + this.f3583c + '}';
    }

    public a(String str, String str2, int i6) {
        this.f3581a = str;
        this.f3582b = str2;
        this.f3583c = i6;
    }

    private static boolean a(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        return str != null && str.equals(str2);
    }
}
