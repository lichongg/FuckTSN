package com.bytedance.sdk.openadsdk.mediation;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.i.j.j.az;
import com.bytedance.sdk.openadsdk.mediation.xt.j.j.xt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MediationManagerVisitor {

    /* renamed from: j, reason: collision with root package name */
    private static volatile MediationManagerVisitor f31632j;
    private static volatile Object xt;
    private xt cw;

    public synchronized IMediationManager getMediationManager() {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("mediation_manager", "mediation_manager");
            TTAdManager adManager = TTAdSdk.getAdManager();
            Object obj = xt;
            if (adManager != null) {
                xt = adManager.getExtra(null, bundle);
            }
            if (xt == null) {
                return null;
            }
            if (this.cw == null) {
                this.cw = new xt(az.j(xt));
            } else if (obj != xt) {
                this.cw.j(az.j(xt));
            }
            return this.cw;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static MediationManagerVisitor getInstance() {
        if (f31632j == null) {
            synchronized (MediationManagerVisitor.class) {
                try {
                    if (f31632j == null) {
                        f31632j = new MediationManagerVisitor();
                    }
                } finally {
                }
            }
        }
        return f31632j;
    }

    private MediationManagerVisitor() {
    }
}
