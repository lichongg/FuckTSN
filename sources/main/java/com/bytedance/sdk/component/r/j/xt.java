package com.bytedance.sdk.component.r.j;

import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface xt extends SharedPreferences {

    public interface j<T> {
        void j(T t5);
    }

    void j();

    void j(j<Map<String, ?>> jVar);

    void j(String str);

    void j(String str, float f6);

    void j(String str, int i6);

    void j(String str, long j6);

    void j(String str, String str2);

    void j(String str, Set<String> set);

    void j(String str, boolean z5);

    float xt(String str, float f6);

    int xt(String str, int i6);

    long xt(String str, long j6);

    String xt(String str, String str2);

    Set<String> xt(String str, Set<String> set);

    void xt();

    boolean xt(String str, boolean z5);
}
