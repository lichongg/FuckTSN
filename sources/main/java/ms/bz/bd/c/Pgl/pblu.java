package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes8.dex */
public class pblu {

    /* renamed from: q, reason: collision with root package name */
    public static final int f50353q = -1;

    /* renamed from: r, reason: collision with root package name */
    public static final int f50354r = 0;

    /* renamed from: s, reason: collision with root package name */
    public static final int f50355s = 1;

    /* renamed from: t, reason: collision with root package name */
    public static final int f50356t = 290;

    /* renamed from: u, reason: collision with root package name */
    public static final int f50357u = 99999;

    /* renamed from: v, reason: collision with root package name */
    public static final int f50358v = 810;

    /* renamed from: a, reason: collision with root package name */
    protected String f50359a = "";

    /* renamed from: b, reason: collision with root package name */
    protected String f50360b = "";

    /* renamed from: c, reason: collision with root package name */
    protected String f50361c = "";

    /* renamed from: d, reason: collision with root package name */
    protected String f50362d = "";

    /* renamed from: e, reason: collision with root package name */
    protected String f50363e = "";

    /* renamed from: f, reason: collision with root package name */
    protected String f50364f = "";

    /* renamed from: g, reason: collision with root package name */
    protected String f50365g = "";

    /* renamed from: h, reason: collision with root package name */
    protected String f50366h = "";

    /* renamed from: i, reason: collision with root package name */
    protected String f50367i = "";

    /* renamed from: j, reason: collision with root package name */
    protected String f50368j = null;

    /* renamed from: k, reason: collision with root package name */
    protected int f50369k = -1;

    /* renamed from: l, reason: collision with root package name */
    protected int f50370l = -1;

    /* renamed from: m, reason: collision with root package name */
    protected int f50371m = f50357u;

    /* renamed from: n, reason: collision with root package name */
    protected Map<String, String> f50372n = new HashMap();

    /* renamed from: o, reason: collision with root package name */
    protected HashMap f50373o = new HashMap();

    /* renamed from: p, reason: collision with root package name */
    protected HashSet f50374p = new HashSet();

    public interface pblb {
    }

    public static abstract class pgla<T extends pblb> extends pblu implements pblb {
        public pgla(String str, String str2, int i6) {
            this.f50359a = str;
            this.f50367i = str2;
            this.f50371m = i6;
            if (TextUtils.isEmpty(str) || "0".equals(str) || TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("appID or license must be set.");
            }
            if (i6 != 99999 && i6 != 290 && i6 != 810) {
                throw new IllegalArgumentException("COLLECT_MODE is error ");
            }
        }

        protected final pgla b() {
            this.f50369k = 1;
            return this;
        }

        public pgla(String str, String str2, String str3, int i6) {
            this.f50365g = str;
            this.f50366h = str2;
            this.f50367i = str3;
            this.f50371m = i6;
            if (TextUtils.isEmpty(str) || "0".equals(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                throw new IllegalArgumentException("sdkID or license must be set.");
            }
        }

        public T c(String str, String str2) {
            this.f50373o.put(str, str2);
            return this;
        }

        public T d(PglITokenObserver pglITokenObserver) {
            if (pglITokenObserver != null) {
                this.f50374p.add(pglITokenObserver);
            }
            return this;
        }

        public T e(String str) {
            this.f50362d = str;
            return this;
        }

        public T f(String str) {
            this.f50360b = str;
            return this;
        }

        public T g(int i6) {
            this.f50369k = i6;
            return this;
        }

        public T h(Map<String, String> map) {
            if (map == null) {
                map = new HashMap<>();
            }
            this.f50372n = map;
            return this;
        }

        public T i(String str) {
            this.f50361c = str;
            return this;
        }

        public T j(String str) {
            this.f50363e = str;
            return this;
        }

        public T k(int i6) {
            this.f50370l = i6;
            return this;
        }

        public T l(String str) {
            if (!str.equals("timeout") && !str.equals("error")) {
                if (!str.isEmpty()) {
                    this.f50373o.put("kOA1", "1");
                }
                return this;
            }
            this.f50373o.put("kOA1", "1");
            str = null;
            this.f50368j = str;
            return this;
        }

        public T m(String str) {
            this.f50364f = str;
            return this;
        }
    }

    static String a(Object obj) {
        return (obj == null || !(obj instanceof String)) ? "" : ((String) obj).trim();
    }

    protected pblu() {
    }
}
