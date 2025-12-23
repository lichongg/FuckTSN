package cn.jiguang.common.app.entity;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public String f2845a;

    /* renamed from: b, reason: collision with root package name */
    public String f2846b;

    /* renamed from: c, reason: collision with root package name */
    public String f2847c;

    /* renamed from: d, reason: collision with root package name */
    public String f2848d;

    /* renamed from: e, reason: collision with root package name */
    public int f2849e;

    /* renamed from: f, reason: collision with root package name */
    public String f2850f;

    /* renamed from: g, reason: collision with root package name */
    public long f2851g;

    /* renamed from: h, reason: collision with root package name */
    public long f2852h;

    /* renamed from: i, reason: collision with root package name */
    public long f2853i;

    /* renamed from: j, reason: collision with root package name */
    public long f2854j;

    /* renamed from: k, reason: collision with root package name */
    public int f2855k;

    /* renamed from: l, reason: collision with root package name */
    public String f2856l;

    /* renamed from: m, reason: collision with root package name */
    public String f2857m;

    /* renamed from: n, reason: collision with root package name */
    public long f2858n;

    /* renamed from: o, reason: collision with root package name */
    public long f2859o;

    /* renamed from: p, reason: collision with root package name */
    public long f2860p;

    /* renamed from: q, reason: collision with root package name */
    public long f2861q;

    /* renamed from: r, reason: collision with root package name */
    public long f2862r;

    /* renamed from: s, reason: collision with root package name */
    public int f2863s;

    /* renamed from: t, reason: collision with root package name */
    public int f2864t;

    /* renamed from: u, reason: collision with root package name */
    public int f2865u;

    private static CharSequence a(CharSequence charSequence, int i6) {
        return (i6 < 0 || i6 >= charSequence.length()) ? charSequence : charSequence.subSequence(0, i6);
    }

    public JSONObject a(int i6) {
        try {
            return new JSONObject().put("uid", this.f2845a).put("pid", this.f2846b).put("ppid", this.f2847c).put("proc_name", a(this.f2848d, i6)).put("foreground", this.f2849e).put("state", this.f2850f).put(com.umeng.analytics.pro.d.f41197p, this.f2851g).put("priority", this.f2852h).put("num_threads", this.f2853i).put("size", this.f2854j).put("tpgid", this.f2855k).put("cpuacct", this.f2856l).put("cpu", this.f2857m).put("utime", this.f2858n).put("stime", this.f2859o).put("cutime", this.f2860p).put("cstime", this.f2861q).put("rt_priority", this.f2862r).put("oom_score", this.f2863s).put("oom_adj", this.f2864t).put("oom_score_adj", this.f2865u);
        } catch (JSONException unused) {
            return null;
        }
    }
}
