package com.kwad.sdk.mobileid;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p0.g;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.mobileid.a.a.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {
    private static String TAG = "MobileIdManager";
    public static com.kwad.sdk.mobileid.a.a.a aTh;
    private static Context mContext;

    private static d Nr() {
        Context context = mContext;
        int d6 = ao.d(context, bd.dt(context), bc.useNetworkStateDisable());
        try {
            if (!ao.isWifiConnected(mContext)) {
                d dVar = new d(true, "uaidTokenCanRequest");
                new com.kwad.sdk.mobileid.a.a().ci(mContext);
                com.kwad.sdk.core.d.c.w(TAG, "requestMobileIdByMobileData");
                return dVar;
            }
            boolean z5 = d6 == 1;
            boolean Ns = Ns();
            if (!z5 || Ns) {
                return z5 ? new d(false, "noRequestByBrand") : !Ns ? new d(false, "noRequestByNoCMCC") : new d(false, "noRequestByBrandAndCMCC");
            }
            d dVar2 = new d(true, "uaidTokenCanRequestByWifi");
            h.schedule(new bg() { // from class: com.kwad.sdk.mobileid.a.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    a.ch(a.mContext);
                    com.kwad.sdk.core.d.c.w(a.TAG, "requestMobileIdChangeToyMobileData");
                    h.schedule(new bg() { // from class: com.kwad.sdk.mobileid.a.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            a.Nt();
                            com.kwad.sdk.core.d.c.w(a.TAG, "schedule unbindNetwork");
                        }
                    }, 2L, TimeUnit.SECONDS);
                }
            }, e.Gl(), TimeUnit.SECONDS);
            return dVar2;
        } catch (Exception e6) {
            d dVar3 = new d(false, "noRequestByException");
            dVar3.gn(e6.getMessage());
            ServiceProvider.reportSdkCaughtException(e6);
            return dVar3;
        }
    }

    private static boolean Ns() {
        String str = Build.MANUFACTURER;
        com.kwad.sdk.core.d.c.w(TAG, "isHuaweiOrHonorDevice manufacturer: " + str);
        return "HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str);
    }

    public static void Nt() {
        synchronized (a.class) {
            try {
                if (aTh != null) {
                    com.kwad.sdk.core.d.c.w(TAG, "unbindNetwork");
                    aTh.Nt();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean Nv() {
        String[] strArr = {g.f36042b, g.f36044d, "android.permission.CHANGE_NETWORK_STATE", g.f36041a};
        for (int i6 = 0; i6 < 4; i6++) {
            if (ContextCompat.checkSelfPermission(ServiceProvider.getContext(), strArr[i6]) != 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ch(final Context context) {
        if (aTh == null) {
            aTh = new com.kwad.sdk.mobileid.a.a.a();
        }
        c.b(context, new d(true, "uaidTokenCanRequestByWifiPre"));
        aTh.a(context, new a.InterfaceC0705a() { // from class: com.kwad.sdk.mobileid.a.2
            @Override // com.kwad.sdk.mobileid.a.a.a.InterfaceC0705a
            public final void Ny() {
                new com.kwad.sdk.mobileid.a.a().b(context, true);
            }
        });
    }

    public static void init(Context context) {
        mContext = context;
        d Nu = Nu();
        if (Nu.isSuccess()) {
            Nu = Nr();
            com.kwad.sdk.core.d.c.d(TAG, "init success :" + Nu);
        } else {
            com.kwad.sdk.core.d.c.d(TAG, "init error: " + Nu.Nz());
        }
        c.a(context, Nu);
    }

    private static d Nu() {
        boolean z5;
        String str;
        boolean Qq = ag.Qq();
        if (Qq && !ag.QD() && Nv()) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (!Qq) {
            str = "noRequestByUaidEnable";
        } else if (ag.QD()) {
            str = "noRequestByUaidExist";
        } else if (!Nv()) {
            str = "noNetworkPermission";
        } else {
            str = "uaidTokenCanRequest";
        }
        return new d(z5, str);
    }
}
