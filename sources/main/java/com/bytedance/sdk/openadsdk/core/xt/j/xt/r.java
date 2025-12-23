package com.bytedance.sdk.openadsdk.core.xt.j.xt;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.jy.m;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.xp;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.xt.j.xt.up;
import com.bytedance.sdk.openadsdk.l.ae;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.open.SocialConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class r {

    /* renamed from: j, reason: collision with root package name */
    private static volatile r f31342j;
    private Object cw;
    private boolean xt;

    /* renamed from: r, reason: collision with root package name */
    private AtomicBoolean f31344r = new AtomicBoolean(false);
    private AtomicInteger up = new AtomicInteger(3);

    /* renamed from: m, reason: collision with root package name */
    private AtomicBoolean f31343m = new AtomicBoolean(false);

    public boolean j() {
        return this.xt;
    }

    public static r cw() {
        if (f31342j == null) {
            synchronized (r.class) {
                try {
                    if (f31342j == null) {
                        f31342j = new r();
                    }
                } finally {
                }
            }
        }
        return f31342j;
    }

    private void j(String str) {
        Method j6;
        if (!this.f31344r.get() && this.up.getAndDecrement() > 0) {
            if (TextUtils.isEmpty(str)) {
                j("wc_init_fail", "error_appid");
                return;
            }
            if (!r()) {
                j("wc_init_fail", "error_no_wechat");
                return;
            }
            if (!this.xt) {
                j("wc_init_fail", "error_no_sdk");
                return;
            }
            try {
                Method j7 = s.j("com.tencent.mm.opensdk.openapi.WXAPIFactory", "createWXAPI", Context.class, String.class);
                if (j7 != null) {
                    Function<SparseArray<Object>, Object> qb = oq.i().qb();
                    Object apply = qb != null ? qb.apply(com.bytedance.sdk.openadsdk.i.r.j().j(3).j(Context.class).xt()) : null;
                    if (apply == null) {
                        apply = v.getContext();
                    }
                    if (apply == null && (j6 = s.j("com.bytedance.sdk.openadsdk.TTAppContextHolder", "getContext", new Class[0])) != null) {
                        apply = j6.invoke(null, null);
                    }
                    if (apply == null) {
                        j("wc_init_fail", "error_sdk");
                        return;
                    }
                    this.cw = j7.invoke(null, apply, str);
                    j("wc_init_suc", "");
                    this.f31344r.set(true);
                }
            } catch (Throwable th) {
                j("wc_init_fail", "error_sdk_" + th.getMessage());
            }
        }
    }

    private void up() {
        ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xt.j.xt.r.2
            @Override // java.lang.Runnable
            public void run() {
                a.xt(v.getContext(), "跳转微信失败。", 1, 17, 0, 0);
            }
        });
    }

    public int xt() {
        return this.xt ? 1 : 0;
    }

    private r() {
        boolean z5;
        this.xt = false;
        try {
            Object obj = Build.class.getDeclaredField("SDK_VERSION_NAME").get(null);
            if (obj instanceof String) {
                Locale locale = Locale.ROOT;
                if ("android 5.3.1".toLowerCase(locale).compareTo(((String) obj).toLowerCase(locale)) <= 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                this.xt = z5;
            }
        } catch (Throwable unused) {
            this.xt = false;
        }
    }

    private boolean r() {
        Context context = v.getContext();
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage("com.tencent.mm");
        if (packageManager.queryIntentActivities(intent, 0).size() > 0) {
            return true;
        }
        if (uf.xt(context)) {
            return false;
        }
        return uf.j("com.tencent.mm");
    }

    private void j(String str, String str2) {
        try {
            final com.bytedance.sdk.openadsdk.core.kt.j.xt<com.bytedance.sdk.openadsdk.core.kt.j.xt> xt = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt();
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error_message", str2);
                xt.xt(jSONObject.toString());
            }
            xt.j(str);
            ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.xt.j.xt.r.1
                @Override // com.bytedance.sdk.openadsdk.vl.j.j
                public com.bytedance.sdk.openadsdk.core.kt.j.j j() {
                    return xt;
                }
            }, str);
        } catch (Throwable unused) {
        }
    }

    public void j(n nVar, String str, String str2, final up.j jVar, String str3, boolean z5) {
        try {
            if (nVar == null) {
                jVar.xt();
                up();
                return;
            }
            xp al = nVar.al();
            if (al == null) {
                j("wc_init_fail", "wechat data is null");
                jVar.xt();
                up();
                return;
            }
            j(al.tl());
            if (this.cw == null) {
                jVar.xt();
                up();
                return;
            }
            Object newInstance = WXLaunchMiniProgram.Req.class.newInstance();
            Field declaredField = WXLaunchMiniProgram.Req.class.getDeclaredField("userName");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, str);
            Field declaredField2 = WXLaunchMiniProgram.Req.class.getDeclaredField("path");
            declaredField2.setAccessible(true);
            declaredField2.set(newInstance, str2);
            Field declaredField3 = WXLaunchMiniProgram.Req.class.getDeclaredField("miniprogramType");
            declaredField3.setAccessible(true);
            try {
                declaredField3.set(newInstance, WXLaunchMiniProgram.Req.class.getDeclaredField("MINIPTOGRAM_TYPE_RELEASE").get(null));
            } catch (Throwable unused) {
                declaredField3.set(newInstance, 0);
            }
            Method method = this.cw.getClass().getMethod("sendReq", WXLaunchMiniProgram.Req.class.getSuperclass());
            al.xt(2);
            com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar, str3, "deeplink_success_realtime", (Throwable) null);
            HashMap hashMap = new HashMap();
            hashMap.put(SocialConstants.PARAM_SOURCE, "WeChatOpenSdkProcessor");
            com.bytedance.sdk.openadsdk.core.jy.cw.tl(nVar, str3, "open_url_app", hashMap);
            m.j().j(nVar, str3, z5);
            method.invoke(this.cw, newInstance);
            ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xt.j.xt.r.3
                @Override // java.lang.Runnable
                public void run() {
                    jVar.j();
                }
            });
        } catch (Throwable th) {
            j("wc_init_fail", "invoke:" + th.getMessage());
            jVar.xt();
            up();
        }
    }
}
