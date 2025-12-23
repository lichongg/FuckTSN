package com.bytedance.j.xt.up;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Context f24248a;

    /* renamed from: b, reason: collision with root package name */
    private com.bytedance.j.xt.f f24249b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, Object> f24250c;

    public static boolean c(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        return ((map.containsKey("app_version") || map.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) && map.containsKey("version_code") && map.containsKey("update_version_code")) ? false : true;
    }

    @NonNull
    public com.bytedance.j.xt.f a() {
        return this.f24249b;
    }

    @Nullable
    public Map<String, Object> b() {
        Map<String, Object> j6 = this.f24249b.j();
        if (j6 == null) {
            j6 = new HashMap<>(4);
        }
        if (c(j6)) {
            try {
                PackageInfo packageInfo = this.f24248a.getPackageManager().getPackageInfo(this.f24248a.getPackageName(), 128);
                j6.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, packageInfo.versionName);
                j6.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (j6.get("update_version_code") == null) {
                    Bundle bundle = packageInfo.applicationInfo.metaData;
                    Object obj = bundle != null ? bundle.get("UPDATE_VERSION_CODE") : null;
                    if (obj == null) {
                        obj = j6.get("version_code");
                    }
                    j6.put("update_version_code", obj);
                    return j6;
                }
            } catch (Throwable unused) {
                j6.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, com.bytedance.j.xt.tl.f.k(this.f24248a));
                j6.put("version_code", Integer.valueOf(com.bytedance.j.xt.tl.f.i(this.f24248a)));
                if (j6.get("update_version_code") == null) {
                    j6.put("update_version_code", j6.get("version_code"));
                }
            }
        }
        return j6;
    }

    public String d() {
        return com.bytedance.j.xt.tl.f.j(this.f24248a);
    }

    public String e() {
        return this.f24249b.xt();
    }

    @Nullable
    public Map<String, Object> f() {
        if (this.f24250c == null) {
            this.f24250c = this.f24249b.ae();
        }
        return this.f24250c;
    }

    public c(@NonNull Context context, @NonNull com.bytedance.j.xt.f fVar) {
        this.f24248a = context;
        this.f24249b = fVar;
    }
}
