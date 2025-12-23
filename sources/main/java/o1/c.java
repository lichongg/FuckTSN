package o1;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static final String f50461b = "c";

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, PLSharedPreferences> f50462c = new ConcurrentHashMap(16);

    /* renamed from: a, reason: collision with root package name */
    private final PLSharedPreferences f50463a;

    private void c(Context context) {
        String str = f50461b;
        Logger.i(str, "ContextHolder.getAppContext() from GRS is:" + ContextHolder.getAppContext());
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        try {
            String l6 = Long.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode);
            String a6 = a("version", "");
            if (l6.equals(a6)) {
                return;
            }
            Logger.i(str, "app version changed! old version{%s} and new version{%s}", a6, l6);
            e();
            f("version", l6);
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.w(f50461b, "get app version failed and catch NameNotFoundException");
        }
    }

    public String a(String str, String str2) {
        String string;
        PLSharedPreferences pLSharedPreferences = this.f50463a;
        if (pLSharedPreferences == null) {
            return str2;
        }
        synchronized (pLSharedPreferences) {
            string = this.f50463a.getString(str, str2);
        }
        return string;
    }

    public Map<String, ?> b() {
        Map<String, ?> all;
        PLSharedPreferences pLSharedPreferences = this.f50463a;
        if (pLSharedPreferences == null) {
            return new HashMap();
        }
        synchronized (pLSharedPreferences) {
            all = this.f50463a.getAll();
        }
        return all;
    }

    public void d(String str) {
        PLSharedPreferences pLSharedPreferences = this.f50463a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f50463a.remove(str);
        }
    }

    public void e() {
        PLSharedPreferences pLSharedPreferences = this.f50463a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f50463a.clear();
        }
    }

    public void f(String str, String str2) {
        PLSharedPreferences pLSharedPreferences = this.f50463a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f50463a.putString(str, str2);
        }
    }

    public c(Context context, String str) {
        String packageName = context.getPackageName();
        Logger.d(f50461b, "get pkgname from context is{%s}", packageName);
        Map<String, PLSharedPreferences> map = f50462c;
        if (map.containsKey(str + packageName)) {
            this.f50463a = map.get(str + packageName);
        } else {
            PLSharedPreferences pLSharedPreferences = new PLSharedPreferences(context, str + packageName);
            this.f50463a = pLSharedPreferences;
            map.put(str + packageName, pLSharedPreferences);
        }
        c(context);
    }
}
