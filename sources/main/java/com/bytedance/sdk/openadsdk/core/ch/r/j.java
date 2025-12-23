package com.bytedance.sdk.openadsdk.core.ch.r;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.openadsdk.ats.cw;
import com.bytedance.sdk.openadsdk.core.ch.g;
import com.bytedance.sdk.openadsdk.core.ch.tl;
import com.bytedance.sdk.openadsdk.core.ch.xt;
import com.bytedance.sdk.openadsdk.core.cw.r;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.v;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends g implements xt {
    private static volatile j xt;

    /* renamed from: j, reason: collision with root package name */
    private AtomicBoolean f28018j = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.core.ch.g
    public JSONObject xt(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("business_name", "common");
            jSONObject.put("business_type", 2);
            jSONObject.put("general_params", new JSONObject());
            return jSONObject;
        } catch (Exception e6) {
            e6.getMessage();
            return jSONObject;
        }
    }

    public static j cw() {
        if (xt == null) {
            synchronized (j.class) {
                try {
                    if (xt == null) {
                        xt = new j();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        try {
            AtomicBoolean atomicBoolean = this.f28018j;
            if (atomicBoolean == null || atomicBoolean.getAndSet(true)) {
                return;
            }
            j(v.getContext());
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.g
    public void j(int i6, tl tlVar) {
        if (oq.i().hl()) {
            try {
                Field[] declaredFields = tlVar.cw().getClass().getDeclaredFields();
                for (int i7 = 0; i7 < declaredFields.length; i7++) {
                    declaredFields[i7].setAccessible(true);
                    declaredFields[i7].get(tlVar.cw());
                }
            } catch (Exception unused) {
            }
        }
    }

    public void r() {
        ae.xt(new com.bytedance.sdk.component.oq.g("pity_splopt") { // from class: com.bytedance.sdk.openadsdk.core.ch.r.j.1
            @Override // java.lang.Runnable
            public void run() {
                j.this.m();
            }
        });
    }

    private j() {
    }

    public static void up() {
        cw().r();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.xt
    public String j() {
        return "splash";
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.g
    public boolean xt() {
        return com.bytedance.sdk.openadsdk.core.ch.oq.cw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.xt
    public String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if ("spl_load_strategy".equalsIgnoreCase(str)) {
            return r.j().f();
        }
        return cw.xt(j()).xt(str, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.xt
    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("spl_load_strategy".equalsIgnoreCase(str)) {
            r.j().av(str2);
        } else {
            cw.xt(j()).j(str, str2);
        }
    }
}
