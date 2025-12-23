package com.bytedance.sdk.openadsdk.core.component.reward;

import android.os.Bundle;
import android.os.RemoteException;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.oq.oq;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.av;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.r;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.up;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    protected static HashMap<Integer, av> f28282j = new HashMap<>();
    private static final ExecutorService xt = com.bytedance.sdk.component.oq.cw.j(new oq("RewardFullCallback"));

    public static void j(final int i6, final String str, final String str2, final Bundle bundle) {
        xt.execute(new g("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.j.1
            @Override // java.lang.Runnable
            public void run() {
                av avVar = j.f28282j.get(Integer.valueOf(i6));
                if (avVar == null) {
                    avVar = av.j.j(com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j(v.getContext()).j(i6));
                    j.f28282j.put(Integer.valueOf(i6), avVar);
                }
                if (avVar == null) {
                    return;
                }
                try {
                    int i7 = i6;
                    if (i7 == 0) {
                        avVar.j(str, str2, bundle);
                    } else if (i7 == 1) {
                        avVar.j(str, str2);
                    } else {
                        if (i7 != 5) {
                            return;
                        }
                        avVar.xt(str, str2, bundle);
                    }
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }
        });
    }

    public static void j(final String str, final com.bytedance.sdk.openadsdk.a.j.xt.j.j jVar) {
        xt.execute(new g("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.j.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.j j6 = com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j(v.getContext());
                if (jVar != null) {
                    up upVar = new up(jVar);
                    av j7 = av.j.j(j6.j(0));
                    if (j7 != null) {
                        try {
                            j7.j(str, upVar);
                        } catch (RemoteException e6) {
                            vl.j(e6);
                        }
                    }
                }
            }
        });
    }

    public static void j(final String str, final com.bytedance.sdk.openadsdk.a.j.xt.j.xt xtVar) {
        xt.execute(new g("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.j.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.j j6 = com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j(v.getContext());
                if (xtVar != null) {
                    r rVar = new r(xtVar);
                    av j7 = av.j.j(j6.j(5));
                    if (j7 != null) {
                        try {
                            j7.j(str, rVar);
                        } catch (RemoteException e6) {
                            vl.j(e6);
                        }
                    }
                }
            }
        });
    }

    public static void j(final String str, final com.bytedance.sdk.openadsdk.x.j.xt.j.j jVar) {
        xt.execute(new g("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.j.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.j j6 = com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j(v.getContext());
                if (jVar != null) {
                    com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.cw cwVar = new com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.cw(jVar);
                    av j7 = av.j.j(j6.j(1));
                    if (j7 != null) {
                        try {
                            j7.j(str, cwVar);
                        } catch (RemoteException e6) {
                            vl.j(e6);
                        }
                    }
                }
            }
        });
    }
}
