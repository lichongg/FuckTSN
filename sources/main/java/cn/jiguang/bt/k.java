package cn.jiguang.bt;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bz.o;
import cn.jiguang.bz.x;
import com.umeng.analytics.pro.bi;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class k extends cn.jiguang.br.a {

    /* renamed from: a, reason: collision with root package name */
    private String f2559a;

    /* renamed from: b, reason: collision with root package name */
    private String f2560b;

    /* renamed from: c, reason: collision with root package name */
    private int f2561c;

    /* renamed from: d, reason: collision with root package name */
    private long f2562d;

    /* renamed from: e, reason: collision with root package name */
    private int f2563e;

    /* renamed from: f, reason: collision with root package name */
    private int f2564f;

    /* renamed from: g, reason: collision with root package name */
    private long f2565g;

    /* renamed from: h, reason: collision with root package name */
    private long f2566h;

    abstract JSONObject d();

    public void d(int i6) {
        this.f2564f = i6;
    }

    @Override // cn.jiguang.br.a
    public JSONObject a() {
        try {
            this.f2562d = this.f2566h - this.f2565g;
            JSONObject d6 = d();
            d6.put(bi.T, this.f2559a);
            d6.put("operate_type", this.f2560b);
            d6.put("signal_strength", this.f2561c);
            d6.put("cost_time", this.f2562d);
            d6.put("error_code", this.f2563e);
            d6.put("status_code", this.f2564f);
            d6.put("status_code", this.f2564f);
            return d6;
        } catch (JSONException e6) {
            cn.jiguang.bb.f.c("NetMoniter", "build netmoniter data error" + e6.getMessage());
            return null;
        }
    }

    public void c(int i6) {
        this.f2563e = i6;
    }

    public k(Context context, String str) {
        super(context, str);
        this.f2559a = "unkown";
        this.f2560b = "unkown";
        this.f2559a = o.a(context);
        String a6 = x.a(context, false);
        if (!TextUtils.isEmpty(a6)) {
            this.f2559a = a6;
        }
    }

    public void e() {
        this.f2565g = System.currentTimeMillis();
    }

    public void f() {
        this.f2566h = System.currentTimeMillis();
    }
}
