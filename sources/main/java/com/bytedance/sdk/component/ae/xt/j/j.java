package com.bytedance.sdk.component.ae.xt.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.keva.KevaMonitor;
import com.bytedance.sdk.component.r.j.xt;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements xt {

    /* renamed from: j, reason: collision with root package name */
    private Keva f26081j;
    private static final Map<String, xt> xt = new HashMap();
    private static volatile boolean cw = false;

    /* renamed from: r, reason: collision with root package name */
    private static volatile boolean f26080r = true;

    public static xt j(Context context, String str, boolean z5, int i6) {
        if (!f26080r) {
            return null;
        }
        try {
            if (!cw) {
                cw = j(context);
            }
            if (TextUtils.isEmpty(str)) {
                str = "tt_ad_sdk_keva";
            }
            if (!f26080r) {
                return null;
            }
            Map<String, xt> map = xt;
            xt xtVar = map.get(str);
            if (xtVar == null) {
                xtVar = new j(str, z5, i6);
                if (f26080r) {
                    map.put(str, xtVar);
                }
            }
            if (f26080r) {
                return xtVar;
            }
            return null;
        } catch (Throwable unused) {
            f26080r = false;
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return null;
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void xt() {
    }

    private void cw(String str, boolean z5) {
        if (z5) {
            this.f26081j = Keva.getRepo(str, 1);
        } else {
            this.f26081j = Keva.getRepo(str, 0);
        }
    }

    private void r(String str, boolean z5) {
        if (z5) {
            this.f26081j = Keva.getRepoSync(str, 1);
        } else {
            this.f26081j = Keva.getRepoSync(str, 0);
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f26081j.contains(str);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.f26081j.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z5) {
        return this.f26081j.getBoolean(str, z5);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f6) {
        return this.f26081j.getFloat(str, f6);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i6) {
        return this.f26081j.getInt(str, i6);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j6) {
        return this.f26081j.getLong(str, j6);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.f26081j.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return this.f26081j.getStringSet(str, set);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public int xt(String str, int i6) {
        return getInt(str, i6);
    }

    private j(String str, boolean z5, int i6) {
        if (i6 != 1) {
            r(str, z5);
        } else {
            cw(str, z5);
        }
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public long xt(String str, long j6) {
        return getLong(str, j6);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public float xt(String str, float f6) {
        return getFloat(str, f6);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public boolean xt(String str, boolean z5) {
        return getBoolean(str, z5);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public String xt(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public Set<String> xt(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    private static boolean j(Context context) {
        if (context == null) {
            return false;
        }
        KevaBuilder kevaBuilder = KevaBuilder.getInstance();
        kevaBuilder.setMonitor(new KevaMonitor() { // from class: com.bytedance.sdk.component.ae.xt.j.j.1
        });
        kevaBuilder.setContext(context);
        return true;
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(xt.j<Map<String, ?>> jVar) {
        jVar.j(getAll());
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, int i6) {
        this.f26081j.storeInt(str, i6);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, long j6) {
        this.f26081j.storeLong(str, j6);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, float f6) {
        this.f26081j.storeFloat(str, f6);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, boolean z5) {
        this.f26081j.storeBoolean(str, z5);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, String str2) {
        this.f26081j.storeString(str, str2);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, Set<String> set) {
        this.f26081j.getStringSet(str, set);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str) {
        this.f26081j.erase(str);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j() {
        this.f26081j.clear();
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
