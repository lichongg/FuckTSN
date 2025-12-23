package com.bytedance.j.xt.up;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.j.xt.cw;
import com.bytedance.j.xt.tl.k;
import com.bytedance.j.xt.tl.l;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.api.plugin.xt;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private Context f24246a;

    class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str != null && str.endsWith(".npth");
        }
    }

    private cw a(String str, JSONObject jSONObject) {
        if (jSONObject == null && TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("launch_")) {
            return cw.LAUNCH;
        }
        if (str.startsWith("anr_")) {
            return cw.ANR;
        }
        if (str.startsWith("java_")) {
            if (jSONObject.optInt("is_dart") == 1) {
                return cw.DART;
            }
            if (jSONObject.optInt("isJava") == 1) {
                return cw.JAVA;
            }
        }
        return null;
    }

    private void b() {
        try {
            SharedPreferences xt = xt.xt(this.f24246a, "npth", 0);
            long j6 = xt.getLong("history_time", -1L);
            if (j6 < 0) {
                xt.edit().putLong("history_time", System.currentTimeMillis()).apply();
            } else if (System.currentTimeMillis() - j6 > 86400000) {
                k.g(l.d(this.f24246a));
                xt.edit().putLong("history_time", System.currentTimeMillis()).apply();
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    private void e() {
        File[] d6 = d(l.b(this.f24246a), ".npth");
        if (d6 == null) {
            return;
        }
        Arrays.sort(d6, Collections.reverseOrder());
        for (int i6 = 0; i6 < d6.length && i6 < 50; i6++) {
            File file = d6[i6];
            try {
                if (y0.a.a().d(file.getAbsolutePath())) {
                    k.g(file);
                } else {
                    com.bytedance.j.xt.cw.a a6 = k.a(file.getAbsolutePath());
                    if (a6 != null && a6.f() != null) {
                        JSONObject f6 = a6.f();
                        a(file.getName(), f6);
                        a6.f().put("upload_scene", "launch_scan");
                        if (com.bytedance.j.xt.ae.xt.e(a6.b(), f6.toString(), a6.a()).a() && !k.g(file)) {
                            y0.a.a().c(z0.a.a(file.getAbsolutePath()));
                        }
                    }
                }
            } catch (Exception e6) {
                com.bytedance.j.xt.tl.i.c(e6);
            }
        }
    }

    public b(Context context) {
        this.f24246a = context;
    }

    @Nullable
    private File[] d(File file, String str) {
        if (!file.exists()) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return file.listFiles();
        }
        return file.listFiles(new a());
    }

    public void c(boolean z5) {
        b();
        if (z5) {
            e();
        }
    }
}
