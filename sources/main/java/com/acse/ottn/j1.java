package com.acse.ottn;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.acse.ottn.util.HelpShopAppUtil;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class j1 {

    /* renamed from: b, reason: collision with root package name */
    public static j1 f4659b;

    /* renamed from: a, reason: collision with root package name */
    public List<HashMap<String, String>> f4660a = new ArrayList();

    public void a(List<HashMap<String, String>> list) {
        this.f4660a = list;
    }

    public static j1 c() {
        if (f4659b == null) {
            synchronized (j1.class) {
                try {
                    if (f4659b == null) {
                        f4659b = new j1();
                    }
                } finally {
                }
            }
        }
        return f4659b;
    }

    public void a(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i6 = displayMetrics.widthPixels;
        int i7 = displayMetrics.heightPixels;
        if (j3.a() != null) {
            j3.a().a("screenWidth", i6);
            j3.a().a("screenHight", i7);
        }
    }

    public List<HashMap<String, String>> d() {
        return this.f4660a;
    }

    public final Object g() throws ObjectStreamException {
        return f4659b;
    }

    public String b() {
        try {
            if (HelpShopAppUtil.getContext() == null) {
                return "demo";
            }
            PackageManager packageManager = HelpShopAppUtil.getContext().getPackageManager();
            return packageManager.getPackageInfo(HelpShopAppUtil.getContext().getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public boolean e() {
        if (!"huawei".equals(j4.b()) && !"honor".equals(j4.b()) && !"tdtech".equals(j4.b()) && !"ptac".equals(j4.b()) && !"tyh612m".equals(j4.p()) && !j4.t()) {
            return false;
        }
        return true;
    }

    public boolean f() {
        if (!e() && !"oppo".equals(j4.b()) && !"vivo".equals(j4.b()) && !"xiaomi".equals(j4.b()) && !"redmi".equals(j4.b()) && !"realme".equals(j4.b()) && !"oneplus".equals(j4.b()) && !"blackshark".equals(j4.b()) && !"samsung".equals(j4.b())) {
            return false;
        }
        return true;
    }

    public void a(String str) {
        if (j3.a() == null) {
            return;
        }
        j3.a().b("accessiblity_state", str);
    }

    public String a() {
        if (j3.a() == null) {
            return k0.f4673i;
        }
        String e6 = j3.a().e("accessiblity_state");
        return TextUtils.isEmpty(e6) ? k0.f4673i : e6;
    }
}
