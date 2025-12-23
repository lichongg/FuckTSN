package cn.jiguang.bt;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends k {

    /* renamed from: a, reason: collision with root package name */
    private int f2546a;

    /* renamed from: b, reason: collision with root package name */
    private String f2547b;

    /* renamed from: c, reason: collision with root package name */
    private String f2548c;

    /* renamed from: d, reason: collision with root package name */
    private int f2549d;

    public void b(int i6) {
        this.f2549d = i6;
    }

    public void b(String str) {
        this.f2547b = str;
    }

    public void c(String str) {
        this.f2548c = str;
    }

    @Override // cn.jiguang.bt.k
    JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("is_foreground", this.f2546a);
        jSONObject.put("tcp_id", this.f2547b);
        jSONObject.put("host", this.f2548c);
        jSONObject.put("port", this.f2549d);
        return jSONObject;
    }

    public b(Context context, String str) {
        super(context, str);
        this.f2547b = "";
        this.f2548c = "";
        this.f2546a = !cn.jiguang.be.b.f2036b.get() ? 1 : 0;
    }
}
