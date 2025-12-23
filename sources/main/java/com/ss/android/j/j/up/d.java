package com.ss.android.j.j.up;

import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.downloadlib.addownload.m;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private String f38281a;

    /* renamed from: b, reason: collision with root package name */
    private final String f38282b;

    /* renamed from: c, reason: collision with root package name */
    private final String f38283c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f38284d;

    /* renamed from: e, reason: collision with root package name */
    private final long f38285e;

    /* renamed from: f, reason: collision with root package name */
    private final String f38286f;

    /* renamed from: g, reason: collision with root package name */
    private final long f38287g;

    /* renamed from: h, reason: collision with root package name */
    private final JSONObject f38288h;

    /* renamed from: i, reason: collision with root package name */
    private final JSONObject f38289i;

    /* renamed from: j, reason: collision with root package name */
    private final List<String> f38290j;

    /* renamed from: k, reason: collision with root package name */
    private final int f38291k;

    /* renamed from: l, reason: collision with root package name */
    private final Object f38292l;

    /* renamed from: m, reason: collision with root package name */
    private final String f38293m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f38294n;

    /* renamed from: o, reason: collision with root package name */
    private final String f38295o;

    /* renamed from: p, reason: collision with root package name */
    private final JSONObject f38296p;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f38297a;

        /* renamed from: b, reason: collision with root package name */
        private String f38298b;

        /* renamed from: c, reason: collision with root package name */
        private String f38299c;

        /* renamed from: e, reason: collision with root package name */
        private long f38301e;

        /* renamed from: f, reason: collision with root package name */
        private String f38302f;

        /* renamed from: g, reason: collision with root package name */
        private long f38303g;

        /* renamed from: h, reason: collision with root package name */
        private JSONObject f38304h;

        /* renamed from: i, reason: collision with root package name */
        private JSONObject f38305i;

        /* renamed from: j, reason: collision with root package name */
        private Map<String, Object> f38306j;

        /* renamed from: k, reason: collision with root package name */
        private List<String> f38307k;

        /* renamed from: l, reason: collision with root package name */
        private int f38308l;

        /* renamed from: m, reason: collision with root package name */
        private Object f38309m;

        /* renamed from: n, reason: collision with root package name */
        private String f38310n;

        /* renamed from: p, reason: collision with root package name */
        private String f38312p;

        /* renamed from: q, reason: collision with root package name */
        private JSONObject f38313q;

        /* renamed from: d, reason: collision with root package name */
        private boolean f38300d = false;

        /* renamed from: o, reason: collision with root package name */
        private boolean f38311o = false;

        public a A(String str) {
            this.f38299c = str;
            return this;
        }

        public a B(JSONObject jSONObject) {
            this.f38305i = jSONObject;
            return this;
        }

        public a C(boolean z5) {
            this.f38300d = z5;
            return this;
        }

        public a d(String str) {
            this.f38302f = str;
            return this;
        }

        public a g(int i6) {
            this.f38308l = i6;
            return this;
        }

        public a h(long j6) {
            this.f38301e = j6;
            return this;
        }

        public a i(Object obj) {
            this.f38309m = obj;
            return this;
        }

        public a j(String str) {
            this.f38298b = str;
            return this;
        }

        public a k(List<String> list) {
            this.f38307k = list;
            return this;
        }

        public a l(JSONObject jSONObject) {
            this.f38304h = jSONObject;
            return this;
        }

        public a m(boolean z5) {
            this.f38311o = z5;
            return this;
        }

        public d n() {
            if (TextUtils.isEmpty(this.f38297a)) {
                this.f38297a = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f38304h == null) {
                this.f38304h = new JSONObject();
            }
            try {
                Map<String, Object> map = this.f38306j;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f38306j.entrySet()) {
                        if (!this.f38304h.has(entry.getKey())) {
                            this.f38304h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.f38311o) {
                    this.f38312p = this.f38299c;
                    JSONObject jSONObject2 = new JSONObject();
                    this.f38313q = jSONObject2;
                    if (this.f38300d) {
                        jSONObject2.put("ad_extra_data", this.f38304h.toString());
                    } else {
                        Iterator<String> keys = this.f38304h.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.f38313q.put(next, this.f38304h.get(next));
                        }
                    }
                    this.f38313q.put("category", this.f38297a);
                    this.f38313q.put(CommonNetImpl.TAG, this.f38298b);
                    this.f38313q.put("value", this.f38301e);
                    this.f38313q.put("ext_value", this.f38303g);
                    if (!TextUtils.isEmpty(this.f38310n)) {
                        this.f38313q.put("refer", this.f38310n);
                    }
                    JSONObject jSONObject3 = this.f38305i;
                    if (jSONObject3 != null) {
                        this.f38313q = u2.b.e(jSONObject3, this.f38313q);
                    }
                    if (this.f38300d) {
                        if (!this.f38313q.has(MediationConstant.EXTRA_LOG_EXTRA) && !TextUtils.isEmpty(this.f38302f)) {
                            this.f38313q.put(MediationConstant.EXTRA_LOG_EXTRA, this.f38302f);
                        }
                        this.f38313q.put("is_ad_event", "1");
                    }
                }
                if (this.f38300d) {
                    jSONObject.put("ad_extra_data", this.f38304h.toString());
                    if (!jSONObject.has(MediationConstant.EXTRA_LOG_EXTRA) && !TextUtils.isEmpty(this.f38302f)) {
                        jSONObject.put(MediationConstant.EXTRA_LOG_EXTRA, this.f38302f);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put(JThirdPlatFormInterface.KEY_EXTRA, this.f38304h);
                }
                if (!TextUtils.isEmpty(this.f38310n)) {
                    jSONObject.putOpt("refer", this.f38310n);
                }
                JSONObject jSONObject4 = this.f38305i;
                if (jSONObject4 != null) {
                    jSONObject = u2.b.e(jSONObject4, jSONObject);
                }
                this.f38304h = jSONObject;
            } catch (Exception e6) {
                m.w().j(e6, "DownloadEventModel build");
            }
            return new d(this);
        }

        public a t(String str) {
            this.f38310n = str;
            return this;
        }

        public a z(long j6) {
            this.f38303g = j6;
            return this;
        }
    }

    public long a() {
        return this.f38287g;
    }

    public JSONObject b() {
        return this.f38296p;
    }

    public String c() {
        return this.f38283c;
    }

    public JSONObject d() {
        return this.f38289i;
    }

    public String e() {
        return this.f38281a;
    }

    public boolean f() {
        return this.f38294n;
    }

    public String g() {
        return this.f38286f;
    }

    public List<String> h() {
        return this.f38290j;
    }

    public int i() {
        return this.f38291k;
    }

    public boolean j() {
        return this.f38284d;
    }

    public JSONObject k() {
        return this.f38288h;
    }

    public long l() {
        return this.f38285e;
    }

    public Object m() {
        return this.f38292l;
    }

    public String n() {
        return this.f38295o;
    }

    public String o() {
        return this.f38282b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("category: ");
        sb.append(this.f38281a);
        sb.append("\ttag: ");
        sb.append(this.f38282b);
        sb.append("\tlabel: ");
        sb.append(this.f38283c);
        sb.append("\nisAd: ");
        sb.append(this.f38284d);
        sb.append("\tadId: ");
        sb.append(this.f38285e);
        sb.append("\tlogExtra: ");
        sb.append(this.f38286f);
        sb.append("\textValue: ");
        sb.append(this.f38287g);
        sb.append("\nextJson: ");
        sb.append(this.f38288h);
        sb.append("\nparamsJson: ");
        sb.append(this.f38289i);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.f38290j;
        sb.append(list != null ? list.toString() : "");
        sb.append("\teventSource: ");
        sb.append(this.f38291k);
        sb.append("\textraObject: ");
        Object obj = this.f38292l;
        sb.append(obj != null ? obj.toString() : "");
        sb.append("\nisV3: ");
        sb.append(this.f38294n);
        sb.append("\tV3EventName: ");
        sb.append(this.f38295o);
        sb.append("\tV3EventParams: ");
        JSONObject jSONObject = this.f38296p;
        sb.append(jSONObject != null ? jSONObject.toString() : "");
        return sb.toString();
    }

    d(a aVar) {
        this.f38281a = aVar.f38297a;
        this.f38282b = aVar.f38298b;
        this.f38283c = aVar.f38299c;
        this.f38284d = aVar.f38300d;
        this.f38285e = aVar.f38301e;
        this.f38286f = aVar.f38302f;
        this.f38287g = aVar.f38303g;
        this.f38288h = aVar.f38304h;
        this.f38289i = aVar.f38305i;
        this.f38290j = aVar.f38307k;
        this.f38291k = aVar.f38308l;
        this.f38292l = aVar.f38309m;
        this.f38294n = aVar.f38311o;
        this.f38295o = aVar.f38312p;
        this.f38296p = aVar.f38313q;
        this.f38293m = aVar.f38310n;
    }
}
