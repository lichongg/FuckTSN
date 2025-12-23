package com.bytedance.msdk.r;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.tl.r.cw;
import com.bytedance.sdk.component.g.j;
import com.bytedance.sdk.component.xt.j.r;
import com.stub.StubApp;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile xt f25199j;
    private final com.bytedance.sdk.component.g.j cw;
    private Context xt;

    public static xt j() {
        if (f25199j == null) {
            synchronized (xt.class) {
                try {
                    if (f25199j == null) {
                        f25199j = new xt(com.bytedance.msdk.core.xt.getContext());
                    }
                } finally {
                }
            }
        }
        return f25199j;
    }

    public com.bytedance.sdk.component.g.j xt() {
        return this.cw;
    }

    private xt(Context context) {
        Context origApplicationContext;
        Map<String, Object> map;
        if (context == null) {
            origApplicationContext = com.bytedance.msdk.core.xt.getContext();
        } else {
            origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.xt = origApplicationContext;
        j.C0409j c0409j = new j.C0409j();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        j.C0409j j6 = c0409j.j(10000L, timeUnit).xt(10000L, timeUnit).cw(10000L, timeUnit).j(true);
        if (cw.j() && (map = cw.f25229j) != null) {
            Object obj = map.get("case_id");
            if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                j6.j(new cw.j());
            }
        }
        com.bytedance.sdk.component.g.j j7 = j6.j();
        this.cw = j7;
        r j8 = j7.m().j();
        if (j8 != null) {
            j8.j(16);
        }
    }
}
