package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10500a = "none";

    /* renamed from: b, reason: collision with root package name */
    public static final String f10501b = "text";

    /* renamed from: c, reason: collision with root package name */
    public static final String f10502c = "static_image";

    /* renamed from: d, reason: collision with root package name */
    public static final String f10503d = "gif";

    /* renamed from: e, reason: collision with root package name */
    public static final String f10504e = "rich_media";

    /* renamed from: f, reason: collision with root package name */
    public static final String f10505f = "html";

    /* renamed from: g, reason: collision with root package name */
    public static final String f10506g = "hybrid";

    /* renamed from: h, reason: collision with root package name */
    public static final String f10507h = "video";

    /* renamed from: i, reason: collision with root package name */
    private static final long f10508i = 1750000;
    private String A;
    private String B;
    private String C;
    private String D;
    private int E;
    private String F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private String M;
    private List<String> O;
    private JSONObject P;
    private long Q;
    private long R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private JSONObject Z;
    private int aa;
    private int ab;
    private int ac;
    private List<String> ad;
    private String af;
    private String ag;
    private JSONObject ah;
    private JSONObject ai;

    /* renamed from: j, reason: collision with root package name */
    private String f10509j;

    /* renamed from: k, reason: collision with root package name */
    private String f10510k;

    /* renamed from: l, reason: collision with root package name */
    private String f10511l;

    /* renamed from: m, reason: collision with root package name */
    private String f10512m;

    /* renamed from: n, reason: collision with root package name */
    private int f10513n;

    /* renamed from: o, reason: collision with root package name */
    private int f10514o;

    /* renamed from: p, reason: collision with root package name */
    private String f10515p;

    /* renamed from: q, reason: collision with root package name */
    private long f10516q;

    /* renamed from: r, reason: collision with root package name */
    private int f10517r;

    /* renamed from: t, reason: collision with root package name */
    private String f10519t;

    /* renamed from: u, reason: collision with root package name */
    private String f10520u;

    /* renamed from: v, reason: collision with root package name */
    private String f10521v;

    /* renamed from: w, reason: collision with root package name */
    private String f10522w;

    /* renamed from: x, reason: collision with root package name */
    private String f10523x;

    /* renamed from: y, reason: collision with root package name */
    private String f10524y;

    /* renamed from: z, reason: collision with root package name */
    private String f10525z;

    /* renamed from: s, reason: collision with root package name */
    private int f10518s = 1;
    private String N = "none";
    private int ae = 0;

    public static boolean a(int i6) {
        return (i6 < 28 || 31 == i6 || 32 == i6 || 38 == i6 || 39 == i6 || 40 == i6 || 42 < i6) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x014f A[Catch: all -> 0x00b9, JSONException -> 0x00bc, TryCatch #4 {JSONException -> 0x00bc, all -> 0x00b9, blocks: (B:5:0x007e, B:8:0x0090, B:10:0x00a1, B:11:0x00bf, B:13:0x00cb, B:15:0x00d6, B:17:0x00dc, B:18:0x00de, B:20:0x00e4, B:22:0x00ea, B:24:0x00f2, B:28:0x00fb, B:30:0x0105, B:32:0x0122, B:36:0x0128, B:37:0x012e, B:39:0x0136, B:41:0x013c, B:43:0x0146, B:45:0x014f, B:47:0x015d, B:49:0x0164, B:50:0x016c, B:52:0x0172), top: B:4:0x007e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.baidu.mobads.sdk.internal.a a(org.json.JSONObject r18) {
        /*
            Method dump skipped, instructions count: 853
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.a.a(org.json.JSONObject):com.baidu.mobads.sdk.internal.a");
    }

    public String A() {
        return this.f10521v;
    }

    public String B() {
        return this.A;
    }

    public String C() {
        return this.f10525z;
    }

    public String D() {
        return this.B;
    }

    public String E() {
        return this.C;
    }

    public String F() {
        return this.D;
    }

    public long G() {
        return this.R;
    }

    public List<String> H() {
        return this.O;
    }

    public String I() {
        return this.S;
    }

    public JSONObject J() {
        return this.P;
    }

    public String K() {
        return this.V;
    }

    public String L() {
        return this.W;
    }

    public String M() {
        return this.X;
    }

    public String N() {
        String str = this.Y;
        return (str == null || str.length() <= 4) ? this.Y : "";
    }

    public int O() {
        return this.ac;
    }

    public List<String> P() {
        return this.ad;
    }

    public JSONObject Q() {
        return this.Z;
    }

    public int R() {
        return this.aa;
    }

    public int S() {
        return this.ab;
    }

    public int T() {
        return this.ae;
    }

    public JSONObject U() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", this.S);
            jSONObject.put("tit", this.f10509j);
            jSONObject.put("desc", this.f10510k);
            jSONObject.put(com.umeng.analytics.pro.d.S, this.f10522w);
            jSONObject.put("appname", this.f10515p);
            jSONObject.put(SocialConstants.PARAM_ACT, this.E);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String V() {
        return this.af;
    }

    public String W() {
        if (TextUtils.isEmpty(this.ag)) {
            return "";
        }
        try {
            long parseLong = Long.parseLong(this.ag);
            int length = this.ag.length();
            return (parseLong <= 100000 || length <= 5) ? "" : this.ag.substring(length - 4, length);
        } catch (Throwable th) {
            az.b(th);
            return "";
        }
    }

    public String b() {
        return this.f10510k;
    }

    public String c() {
        return this.f10511l;
    }

    public String d() {
        return this.f10512m;
    }

    public int e() {
        return this.f10513n;
    }

    public int f() {
        return this.f10514o;
    }

    public String g() {
        return this.f10515p;
    }

    public String h() {
        return this.T;
    }

    public String i() {
        return this.U;
    }

    public long j() {
        return this.f10516q;
    }

    public int k() {
        return this.f10517r;
    }

    public int l() {
        return this.f10518s;
    }

    public String m() {
        return this.f10522w;
    }

    public String n() {
        return this.f10523x;
    }

    public String o() {
        return this.f10524y;
    }

    public int p() {
        return this.E;
    }

    public String q() {
        return this.F;
    }

    public int r() {
        return this.G;
    }

    public int s() {
        return this.H;
    }

    public int t() {
        return this.I;
    }

    public int u() {
        return this.J;
    }

    public int v() {
        return this.K;
    }

    public int w() {
        return this.L;
    }

    public String x() {
        return this.N;
    }

    public long y() {
        return this.Q;
    }

    public String z() {
        return !TextUtils.isEmpty(this.f10520u) ? this.f10520u : this.f10519t;
    }

    public String a(String str) {
        if (this.ah == null) {
            return null;
        }
        JSONObject jSONObject = this.ai;
        JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("apo") : null;
        String optString = this.ah.optString(str);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        if (TextUtils.equals(optString, "fallback") && optJSONObject != null) {
            return optJSONObject.optString("fallback");
        }
        if (TextUtils.equals(optString, "page") && optJSONObject != null) {
            return optJSONObject.optString("page");
        }
        JSONObject jSONObject2 = this.ai;
        if (jSONObject2 != null) {
            return jSONObject2.optString(optString);
        }
        return null;
    }

    public static List<a> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                try {
                    arrayList.add(a(jSONArray.getJSONObject(i6)));
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    private static int a(JSONObject jSONObject, int i6, int i7) {
        String[] split;
        int i8 = 0;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("st_op");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("tp_id");
                    if (!TextUtils.isEmpty(optString) && optString.startsWith("opt_style_") && (split = optString.substring(10).split("_")) != null && split.length > 0) {
                        i8 = Integer.parseInt(split[0]);
                    }
                }
            } catch (Throwable th) {
                bu.a().d(th.getMessage());
            }
        }
        if (a(i8)) {
            i6 = i8;
        } else if (!a(i6)) {
            i6 = i7;
        }
        if (i6 == 42) {
            return 41;
        }
        return i6;
    }

    public String a() {
        return this.f10509j;
    }
}
