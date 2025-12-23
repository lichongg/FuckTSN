package com.ss.android.downloadlib.up;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.socialbase.appdownloader.m.c;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class a implements v2.a {

    /* renamed from: com.ss.android.downloadlib.up.a$a, reason: collision with other inner class name */
    private static class C0763a {

        /* renamed from: a, reason: collision with root package name */
        private static a f38207a = new a();
    }

    public void c(String str) {
        d(true, str);
    }

    public void f(String str) {
        h(true, str);
    }

    @Override // v2.a
    public void j(Throwable th, String str) {
        e(true, th, str);
    }

    public static a a() {
        return C0763a.f38207a;
    }

    public static String b(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Exception unused) {
            return null;
        }
    }

    private void g(Throwable th) {
        if (!c.m(m.getContext())) {
        } else {
            throw new j(th);
        }
    }

    private boolean i() {
        if (m.f().optInt("enable_monitor", 1) != 1) {
            return true;
        }
        return false;
    }

    public void d(boolean z5, String str) {
        if (i()) {
            return;
        }
        if (z5) {
            g(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        a.h.u(jSONObject, "msg", str);
        a.h.u(jSONObject, "stack", b(new Throwable()));
        m.D();
    }

    public void e(boolean z5, Throwable th, String str) {
        if (i()) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        if (z5) {
            g(th);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th.getMessage();
        }
        a.h.u(jSONObject, "msg", str);
        a.h.u(jSONObject, "stack", Log.getStackTraceString(th));
        m.D();
    }

    public void h(boolean z5, String str) {
        if (i()) {
            return;
        }
        if (z5) {
            g(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        a.h.u(jSONObject, "msg", str);
        a.h.u(jSONObject, "stack", b(new Throwable()));
        m.D();
    }
}
