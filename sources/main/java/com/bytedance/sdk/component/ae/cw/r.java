package com.bytedance.sdk.component.ae.cw;

import android.content.SharedPreferences;
import com.bytedance.sdk.component.r.j.xt;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements com.bytedance.sdk.component.r.j.xt {

    /* renamed from: j, reason: collision with root package name */
    SharedPreferences f26073j;

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(xt.j<Map<String, ?>> jVar) {
        if (jVar != null) {
            jVar.j(getAll());
        }
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void xt() {
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f26073j.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f26073j.edit();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        try {
            return this.f26073j.getAll();
        } catch (Exception unused) {
            return Collections.EMPTY_MAP;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z5) {
        try {
            return this.f26073j.getBoolean(str, z5);
        } catch (Exception unused) {
            return z5;
        }
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f6) {
        try {
            return this.f26073j.getFloat(str, f6);
        } catch (Exception unused) {
            return f6;
        }
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i6) {
        try {
            return this.f26073j.getInt(str, i6);
        } catch (Exception unused) {
            return i6;
        }
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j6) {
        try {
            return this.f26073j.getLong(str, j6);
        } catch (Exception unused) {
            return j6;
        }
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        try {
            return this.f26073j.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        try {
            return this.f26073j.getStringSet(str, set);
        } catch (Exception unused) {
            return set;
        }
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, int i6) {
        try {
            this.f26073j.edit().putInt(str, i6).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f26073j.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f26073j.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public int xt(String str, int i6) {
        try {
            return this.f26073j.getInt(str, i6);
        } catch (Exception unused) {
            return i6;
        }
    }

    public r(SharedPreferences sharedPreferences) {
        this.f26073j = sharedPreferences;
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, long j6) {
        try {
            this.f26073j.edit().putLong(str, j6).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public long xt(String str, long j6) {
        try {
            return this.f26073j.getLong(str, j6);
        } catch (Exception unused) {
            return j6;
        }
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, float f6) {
        try {
            this.f26073j.edit().putFloat(str, f6).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public float xt(String str, float f6) {
        try {
            return this.f26073j.getFloat(str, f6);
        } catch (Exception unused) {
            return f6;
        }
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, boolean z5) {
        try {
            this.f26073j.edit().putBoolean(str, z5).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public boolean xt(String str, boolean z5) {
        try {
            return this.f26073j.getBoolean(str, z5);
        } catch (Exception unused) {
            return z5;
        }
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, String str2) {
        try {
            this.f26073j.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public String xt(String str, String str2) {
        try {
            return this.f26073j.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str, Set<String> set) {
        try {
            this.f26073j.edit().putStringSet(str, set).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public Set<String> xt(String str, Set<String> set) {
        try {
            return this.f26073j.getStringSet(str, set);
        } catch (Exception unused) {
            return set;
        }
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j(String str) {
        try {
            this.f26073j.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.r.j.xt
    public void j() {
        try {
            this.f26073j.edit().clear().apply();
        } catch (Throwable unused) {
        }
    }
}
