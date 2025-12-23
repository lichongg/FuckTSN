package com.bytedance.embedapplog;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.embedapplog.collector.Collector;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class j {
    private static boolean ae = false;
    public static ConcurrentHashMap<String, String> cw = new ConcurrentHashMap<>(4);

    /* renamed from: j, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static wq f23999j = null;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f24000m = true;

    /* renamed from: r, reason: collision with root package name */
    public static xt f24001r = null;
    private static volatile r tl = null;

    @SuppressLint({"StaticFieldLeak"})
    private static volatile rn up = null;
    public static boolean xt = true;

    public static boolean ae() {
        return true;
    }

    public static void j(@NonNull Context context, @NonNull tl tlVar) {
        if (up != null) {
            uc.xt(new RuntimeException("Init Twice!"));
            return;
        }
        if (tlVar.h() == null) {
            uc.xt(new RuntimeException("need to involve setSensitiveInfoProvider!"));
            return;
        }
        Application application = (Application) StubApp.getOrigApplicationContext(context.getApplicationContext());
        f m6 = f.m();
        rn rnVar = new rn(application, tlVar);
        up = rnVar;
        wq wqVar = new wq(application, rnVar);
        m6.j(application, rnVar, wqVar, new w(tlVar.oq()));
        f23999j = wqVar;
        if (up.i()) {
            application.registerReceiver(new Collector(), new IntentFilter());
        }
        uc.r("Inited", null);
    }

    public static void xt() {
        f.j();
    }

    public static r cw() {
        return tl;
    }

    public static String g() {
        wq wqVar = f23999j;
        return wqVar != null ? wqVar.g() : "";
    }

    @Nullable
    public static JSONObject m() {
        if (up != null) {
            return up.kt();
        }
        return null;
    }

    public static String oq() {
        wq wqVar = f23999j;
        return wqVar != null ? wqVar.oq() : "";
    }

    public static xt r() {
        return f24001r;
    }

    public static String tl() {
        wq wqVar = f23999j;
        return wqVar != null ? wqVar.ae() : "";
    }

    public static String up() {
        wq wqVar = f23999j;
        if (wqVar != null) {
            return wqVar.jy();
        }
        return null;
    }

    public static tl vl() {
        if (up != null) {
            return up.hh();
        }
        return null;
    }

    public static void xt(@NonNull String str, @NonNull JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
            uc.xt("call onEventData with invalid params, return", null);
            return;
        }
        try {
            f.j(new k(str, jSONObject));
        } catch (Exception e6) {
            uc.cw("call onEventData get exception: ", e6);
        }
    }

    @NonNull
    public static cw qv() {
        return rr.j();
    }

    public static void j(boolean z5) {
        xt = z5;
    }

    public static void j() {
        wq wqVar;
        if (!xt || (wqVar = f23999j) == null) {
            return;
        }
        wqVar.r();
    }

    public static void j(HashMap<String, Object> hashMap) {
        wq wqVar = f23999j;
        if (wqVar != null) {
            wqVar.j(hashMap);
        }
    }

    public static <T> T j(String str, T t5) {
        wq wqVar = f23999j;
        if (wqVar != null) {
            return (T) wqVar.j(str, t5);
        }
        return null;
    }

    public static void j(@NonNull String str, @Nullable JSONObject jSONObject) {
        f.j(new ff(str, false, jSONObject != null ? jSONObject.toString() : null));
    }

    public static void j(@NonNull String str, @Nullable JSONObject jSONObject, int i6) {
        f.j(new ff(str, false, jSONObject != null ? jSONObject.toString() : null, i6));
    }

    public static void j(@NonNull String str, @Nullable Bundle bundle) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        uc.xt(th);
                        j(str, jSONObject);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        j(str, jSONObject);
    }

    public static void j(@NonNull String str, @Nullable Bundle bundle, int i6) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        uc.xt(th);
                        j(str, jSONObject, i6);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        j(str, jSONObject, i6);
    }

    @AnyThread
    public static void j(@Nullable up upVar) {
        wo.j(upVar);
    }
}
