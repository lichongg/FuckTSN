package cn.jiguang.bt;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class i extends cn.jiguang.br.a {

    /* renamed from: a, reason: collision with root package name */
    private String f2550a;

    /* renamed from: b, reason: collision with root package name */
    private long f2551b;

    /* renamed from: c, reason: collision with root package name */
    private long f2552c;

    /* renamed from: d, reason: collision with root package name */
    private long f2553d;

    /* renamed from: e, reason: collision with root package name */
    private String f2554e;

    @Override // cn.jiguang.br.a
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f2554e);
            jSONObject.put("res", this.f2552c);
            jSONObject.put("req", this.f2551b);
            jSONObject.put("type", this.f2550a);
            jSONObject.put("count", this.f2553d);
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("NetDataLengthMonitor", "build getExtraJson data failed, " + th.getMessage());
            return jSONObject;
        }
    }

    public void b(long j6) {
        this.f2551b = j6;
    }

    public i(Context context) {
        super(context, "NET_DATA");
    }

    public void a(long j6) {
        this.f2552c = j6;
    }

    public void b(String str) {
        this.f2550a = str;
    }

    public void c(long j6) {
        this.f2553d = j6;
    }

    public void a(String str) {
        this.f2554e = str;
    }
}
