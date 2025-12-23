package cn.jiguang.ba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private Context f1914a;

    /* renamed from: b, reason: collision with root package name */
    private String f1915b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f1916c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1917d;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final g f1927a = new g();
    }

    private g() {
        this.f1915b = "JProcessInternalManager";
        this.f1916c = new ConcurrentHashMap<>();
        this.f1914a = cn.jiguang.bz.d.a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Bundle c(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        str.getClass();
        switch (str) {
            case "isTcpLoggedIn":
                boolean d6 = cn.jiguang.bi.g.a().d();
                cn.jiguang.bb.f.c(this.f1915b, "from jcore isLoggedIn=" + d6);
                bundle.putBoolean("state", d6);
                return bundle;
            case "get_loc_info":
                Object a6 = cn.jiguang.v.a.a(this.f1914a, "get_loc_info", null);
                cn.jiguang.bb.f.c(this.f1915b, "from  jcore LOC_INFO bundle=" + a6);
                if (a6 instanceof Bundle) {
                    bundle.putAll((Bundle) a6);
                }
                return bundle;
            case "deviceinfo":
                Object a7 = cn.jiguang.v.a.a(this.f1914a, "deviceinfo", null);
                cn.jiguang.bb.f.c(this.f1915b, "from jcore DEVICE_INFO bundle=" + a7);
                if (a7 instanceof JSONObject) {
                    bundle.putString("de_inf", a7.toString());
                    return bundle;
                }
                return bundle;
            default:
                return bundle;
        }
    }

    private Bundle d(String str, Bundle bundle) {
        cn.jiguang.e.a<String> aM;
        str.getClass();
        switch (str) {
            case "isTcpLoggedIn":
                if (bundle == null) {
                    return null;
                }
                boolean z5 = bundle.getBoolean("state", false);
                if (z5 && !this.f1917d) {
                    this.f1917d = true;
                    cn.jiguang.bw.b.a().b();
                }
                this.f1916c.put(str, Boolean.valueOf(z5));
                cn.jiguang.e.b.a(this.f1914a, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.z().a((cn.jiguang.e.a<Boolean>) Boolean.valueOf(z5))});
                cn.jiguang.bb.f.c(this.f1915b, "Updated connection state cache from callback: " + z5);
                return null;
            case "get_loc_info":
                aM = cn.jiguang.e.a.aM();
                break;
            case "deviceinfo":
                aM = cn.jiguang.e.a.aL();
                break;
            default:
                return null;
        }
        a(str, bundle, aM);
        return null;
    }

    public Bundle b(String str, Bundle bundle) {
        cn.jiguang.bb.f.c(this.f1915b, "action=" + str);
        String a6 = cn.jiguang.bz.a.a(this.f1914a);
        String a7 = d.a(this.f1914a);
        if (this.f1914a.getPackageName().equals(a6)) {
            return d(str, bundle);
        }
        if (TextUtils.isEmpty(a6) || !a6.equals(a7)) {
            return null;
        }
        return c(str, bundle);
    }

    private Bundle a(String str) {
        return a(str, d.a(this.f1914a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, cn.jiguang.e.a aVar) {
        try {
            a(str, a(str), aVar);
        } catch (Throwable th) {
            cn.jiguang.bb.f.d(this.f1915b, "Error updating generic data cache", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        try {
            Bundle a6 = a(str);
            cn.jiguang.bb.f.c(this.f1915b, "Updated connection state bundle: " + a6);
            if (a6 != null) {
                boolean z5 = a6.getBoolean("state", false);
                this.f1916c.put(str, Boolean.valueOf(z5));
                cn.jiguang.e.b.a(this.f1914a, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.z().a((cn.jiguang.e.a<Boolean>) Boolean.valueOf(z5))});
                cn.jiguang.bb.f.c(this.f1915b, "Updated connection state cache: " + z5);
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.d(this.f1915b, "Error updating connection state cache", th);
        }
    }

    private Object d(String str) {
        return a(str, cn.jiguang.e.a.aL());
    }

    private Bundle a(String str, String str2) {
        String str3;
        try {
            str3 = str2;
        } catch (Throwable th) {
            th = th;
            str3 = str2;
        }
        try {
            Bundle a6 = e.a().a(this.f1914a, "INTERNAL_API", str, null, str3);
            return a6 != null ? a6 : new Bundle();
        } catch (Throwable th2) {
            th = th2;
            Throwable th3 = th;
            cn.jiguang.bb.f.d(this.f1915b, "Failed to get data from process: " + str3, th3);
            return new Bundle();
        }
    }

    private boolean b(final String str) {
        try {
            Object obj = this.f1916c.get(str);
            if (obj instanceof Boolean) {
                cn.jiguang.bb.f.c(this.f1915b, "return state memory: " + obj);
                return ((Boolean) obj).booleanValue();
            }
            cn.jiguang.by.d.a("AIDL_TASK", new Runnable() { // from class: cn.jiguang.ba.g.2
                @Override // java.lang.Runnable
                public void run() {
                    g.this.c(str);
                }
            });
            Boolean bool = (Boolean) cn.jiguang.e.b.a(this.f1914a, cn.jiguang.e.a.z());
            cn.jiguang.bb.f.c(this.f1915b, "return state sp: " + bool);
            return bool.booleanValue();
        } catch (Throwable th) {
            cn.jiguang.bb.f.d(this.f1915b, "Error in getConnectionState", th);
            return false;
        }
    }

    private Object e(String str) {
        return a(str, cn.jiguang.e.a.aM());
    }

    public static g a() {
        return a.f1927a;
    }

    public Object a(int i6) {
        if (i6 == 67) {
            return Boolean.valueOf(b("isTcpLoggedIn"));
        }
        if (i6 != 68) {
            if (i6 == 91) {
                return e("get_loc_info");
            }
            if (i6 != 94) {
                return null;
            }
        }
        return d("deviceinfo");
    }

    private Object a(final String str, final cn.jiguang.e.a aVar) {
        try {
            cn.jiguang.bb.f.l(this.f1915b, "get action=" + str);
            Object obj = this.f1916c.get(str);
            if (obj instanceof JSONObject) {
                cn.jiguang.bb.f.l(this.f1915b, "get from memory cachedData=" + obj);
                return obj;
            }
            cn.jiguang.by.d.a("AIDL_TASK", new Runnable() { // from class: cn.jiguang.ba.g.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.b(str, aVar);
                }
            });
            String str2 = (String) cn.jiguang.e.b.a(this.f1914a, aVar);
            cn.jiguang.bb.f.l(this.f1915b, "get from sp cachedData=" + str2);
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return new JSONObject(str2);
        } catch (Throwable th) {
            cn.jiguang.bb.f.d(this.f1915b, "Error in getGenericData", th);
            return null;
        }
    }

    public void a(String str, Bundle bundle) {
        a(str, bundle, this.f1914a.getPackageName());
    }

    private void a(String str, Bundle bundle, cn.jiguang.e.a aVar) {
        if (bundle != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (String str2 : bundle.keySet()) {
                    jSONObject.put(str2, bundle.get(str2));
                }
                this.f1916c.put(str, jSONObject);
                cn.jiguang.e.b.a(this.f1914a, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{aVar.a((cn.jiguang.e.a) jSONObject.toString())});
                cn.jiguang.bb.f.c(this.f1915b, "Updated generic data cache: " + jSONObject.toString());
            } catch (Throwable th) {
                cn.jiguang.bb.f.d(this.f1915b, "Error updating generic data cache", th);
            }
        }
    }

    private void a(final String str, final Bundle bundle, final String str2) {
        try {
            cn.jiguang.by.d.a("AIDL_TASK", new Runnable() { // from class: cn.jiguang.ba.g.1
                @Override // java.lang.Runnable
                public void run() {
                    e.a().a(g.this.f1914a, "INTERNAL_API", str, bundle, str2);
                }
            });
        } catch (Throwable th) {
            cn.jiguang.bb.f.d(this.f1915b, "Failed to send data to process: " + str2, th);
        }
    }
}
