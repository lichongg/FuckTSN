package cn.jiguang.bs;

import android.content.Context;
import cn.jiguang.bb.f;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c extends cn.jiguang.br.a {

    /* renamed from: a, reason: collision with root package name */
    private String f2545a;

    @Override // cn.jiguang.br.a
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_type", this.f2545a);
            jSONObject.put("count", 1);
            return jSONObject;
        } catch (Throwable th) {
            f.i("ExceptMonitor", "build getExtraJson data failed, " + th.getMessage());
            return jSONObject;
        }
    }

    public void a(String str) {
        this.f2545a = str;
    }

    public c(Context context, String str) {
        super(context, str);
    }

    @Override // cn.jiguang.br.a
    public JSONObject b() {
        return super.b();
    }

    @Override // cn.jiguang.br.a
    public String c() {
        return super.c();
    }
}
