package com.bytedance.sdk.component.ae.cw.j;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.r.j.xt;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements com.bytedance.sdk.component.r.j.xt {
    private static final Map<String, com.bytedance.sdk.component.r.j.xt> xt = new ConcurrentHashMap();

    /* renamed from: j, reason: collision with root package name */
    private String f26070j;

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return null;
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(xt.j<Map<String, ?>> jVar) {
        jVar.j(getAll());
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void xt() {
    }

    public static com.bytedance.sdk.component.r.j.xt xt(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_multi_sp";
        }
        Map<String, com.bytedance.sdk.component.r.j.xt> map = xt;
        com.bytedance.sdk.component.r.j.xt xtVar = map.get(str);
        if (xtVar != null) {
            return xtVar;
        }
        j jVar = new j(str);
        map.put(str, jVar);
        return jVar;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return xt.j(this.f26070j, str);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return xt.xt(this.f26070j);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z5) {
        return xt.j(this.f26070j, str, z5);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f6) {
        return xt.j(this.f26070j, str, f6);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i6) {
        return xt.j(this.f26070j, str, i6);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j6) {
        return xt.j(this.f26070j, str, j6);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return xt.xt(this.f26070j, str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return xt.xt(this.f26070j, str, set);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, int i6) {
        xt.j(this.f26070j, str, Integer.valueOf(i6));
    }

    private j(String str) {
        this.f26070j = str;
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, long j6) {
        xt.j(this.f26070j, str, Long.valueOf(j6));
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, float f6) {
        xt.j(this.f26070j, str, Float.valueOf(f6));
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, boolean z5) {
        xt.j(this.f26070j, str, Boolean.valueOf(z5));
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, String str2) {
        xt.j(this.f26070j, str, str2);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, Set<String> set) {
        xt.j(this.f26070j, str, set);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public int xt(String str, int i6) {
        return getInt(str, i6);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str) {
        xt.xt(this.f26070j, str);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public long xt(String str, long j6) {
        return getLong(str, j6);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j() {
        xt.j(this.f26070j);
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

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
