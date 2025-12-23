package com.umeng.socialize.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.socialize.utils.ContextUtil;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f42206a;

    /* renamed from: b, reason: collision with root package name */
    private final SharedPreferences f42207b = ContextUtil.getContext().getSharedPreferences("um_social_azx", 0);

    public static b a() {
        if (f42206a == null) {
            synchronized (b.class) {
                try {
                    if (f42206a == null) {
                        f42206a = new b();
                    }
                } finally {
                }
            }
        }
        return f42206a;
    }

    public String b(String str, String str2) {
        return this.f42207b.getString(str, str2);
    }

    public Map<String, ?> b() {
        return this.f42207b.getAll();
    }

    private b() {
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f42207b.edit().putString(str, str2).apply();
    }

    public int a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return 0;
        }
        SharedPreferences.Editor edit = this.f42207b.edit();
        int i6 = 0;
        for (String str : strArr) {
            if (this.f42207b.contains(str)) {
                edit.remove(str);
                i6++;
            }
        }
        if (i6 > 0) {
            edit.apply();
        }
        return i6;
    }

    public void a(String str) {
        if (this.f42207b.contains(str)) {
            this.f42207b.edit().remove(str).apply();
        }
    }
}
