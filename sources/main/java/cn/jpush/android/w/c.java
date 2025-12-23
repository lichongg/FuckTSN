package cn.jpush.android.w;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f3944a;

    /* renamed from: b, reason: collision with root package name */
    private String f3945b;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f3948e;

    /* renamed from: g, reason: collision with root package name */
    private Object f3950g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3951h;

    /* renamed from: l, reason: collision with root package name */
    private X509TrustManager f3955l;

    /* renamed from: m, reason: collision with root package name */
    private HostnameVerifier f3956m;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3952i = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f3953j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3954k = false;

    /* renamed from: c, reason: collision with root package name */
    private int f3946c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f3947d = -1;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, String> f3949f = new HashMap();

    public String a() {
        return this.f3944a;
    }

    public void a(Object obj) {
        this.f3950g = obj;
    }

    public int b() {
        return this.f3946c;
    }

    public int c() {
        return this.f3947d;
    }

    public boolean d() {
        return this.f3951h;
    }

    public boolean e() {
        return this.f3954k;
    }

    public X509TrustManager f() {
        return this.f3955l;
    }

    public HostnameVerifier g() {
        return this.f3956m;
    }

    public byte[] h() {
        Object obj = this.f3950g;
        if (obj != null) {
            if (obj instanceof String) {
                if (!TextUtils.isEmpty((CharSequence) obj)) {
                    return ((String) this.f3950g).getBytes();
                }
            } else if (obj instanceof byte[]) {
                return (byte[]) obj;
            }
        }
        String a6 = e.a(this.f3948e);
        if (TextUtils.isEmpty(a6)) {
            return null;
        }
        return a6.getBytes();
    }

    public Map<String, String> i() {
        return this.f3949f;
    }

    public boolean j() {
        return this.f3952i;
    }

    public boolean k() {
        return this.f3953j;
    }

    public String l() {
        return this.f3945b;
    }

    public c(String str) {
        this.f3944a = str;
    }

    public void a(String str) {
        this.f3945b = str;
    }

    public void a(String str, String str2) {
        this.f3949f.put(str, str2);
    }
}
