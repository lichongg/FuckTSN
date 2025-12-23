package com.kwad.sdk.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.kwad.sdk.components.p;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private static final Map<String, String> auQ = new HashMap();
    private final AtomicBoolean auR;
    private final AtomicBoolean auS;
    private final AtomicBoolean auT;
    private final AtomicBoolean auU;
    private final List<String> auV;
    private final List<String> auW;
    private final d auX;
    private final BroadcastReceiver auY;
    private Context mContext;
    private final List<com.kwad.sdk.app.a> mListeners;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final b avb = new b(0);
    }

    /* synthetic */ b(byte b6) {
        this();
    }

    private synchronized void bf(Context context) {
        if (this.auR.get()) {
            return;
        }
        D(context, "com.smile.gifmaker");
        D(context, "com.kuaishou.nebula");
        D(context, "com.tencent.mm");
        this.auR.set(true);
    }

    public final synchronized void init() {
        try {
            if (this.auS.get()) {
                return;
            }
            Dz();
            if (((h) ServiceProvider.get(h.class)).BT()) {
                com.kwad.sdk.core.c.b.Ho();
                if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                    DC();
                }
                Dx();
            } else {
                DC();
            }
            this.auS.set(true);
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    private b() {
        this.auR = new AtomicBoolean();
        this.auS = new AtomicBoolean();
        this.auT = new AtomicBoolean();
        this.auU = new AtomicBoolean();
        this.mListeners = new CopyOnWriteArrayList();
        this.auV = new CopyOnWriteArrayList();
        this.auW = new CopyOnWriteArrayList();
        this.auX = new d() { // from class: com.kwad.sdk.app.b.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                try {
                    b.this.DA();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.auY = new BroadcastReceiver() { // from class: com.kwad.sdk.app.b.3
            Intent ava;

            private boolean d(Intent intent) {
                boolean z5 = TextUtils.equals(this.ava.getAction(), intent.getAction()) && TextUtils.equals(this.ava.getPackage(), intent.getPackage()) && this.ava.getFlags() == intent.getFlags() && TextUtils.equals(this.ava.getDataString(), intent.getDataString());
                this.ava = intent;
                return z5;
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Uri data;
                try {
                    c.d("AppInstallManager", "onReceive intent: " + intent.toString());
                    if (this.ava == null) {
                        this.ava = intent;
                    } else if (d(intent)) {
                        return;
                    }
                    String action = intent.getAction();
                    if (!TextUtils.isEmpty(action) && (data = intent.getData()) != null) {
                        String schemeSpecificPart = data.getSchemeSpecificPart();
                        if (TextUtils.isEmpty(schemeSpecificPart)) {
                            return;
                        }
                        b.this.mContext = context;
                        if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", action)) {
                            b.this.A(context, schemeSpecificPart);
                        } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", action)) {
                            b.this.cv(schemeSpecificPart);
                        }
                    }
                } catch (Throwable th) {
                    c.printStackTrace(th);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Context context, @NonNull String str) {
        c.d("AppInstallManager", "installApp packageName: " + str);
        D(context, str);
        cy(str);
        B(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C(Context context, @NonNull String str) {
        try {
            p pVar = (p) com.kwad.sdk.components.d.f(p.class);
            if (pVar == null || !s.PW()) {
                return;
            }
            ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).e(pVar.e(context, str), 1);
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DB() {
        if (this.auT.get()) {
            ServiceProvider.Pp().unregisterReceiver(this.auY);
            this.auT.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DC() {
        if (this.auT.get()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme(WiseOpenHianalyticsData.UNION_PACKAGE);
        ServiceProvider.Pp().registerReceiver(this.auY, intentFilter);
        this.auT.set(true);
    }

    private void Dy() {
        if (this.auU.get()) {
            return;
        }
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.a(this.auX);
        this.auU.set(true);
    }

    private void Dz() {
        if (this.auU.get()) {
            com.kwad.sdk.core.c.b.Ho();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this.auX);
            this.auU.set(false);
        }
    }

    private void bg(Context context) {
        if (this.auR.get()) {
            for (String str : auQ.keySet()) {
                String str2 = auQ.get(str);
                String O = m.O(context, str);
                if (!TextUtils.isEmpty(O) && !TextUtils.equals(str2, O)) {
                    A(context, str);
                } else if (TextUtils.isEmpty(O) && !TextUtils.isEmpty(str2)) {
                    cv(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(@NonNull String str) {
        c.d("AppInstallManager", "unInstallApp packageName: " + str);
        cA(str);
        cz(str);
        cw(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cx(@NonNull String str) {
        try {
            p pVar = (p) com.kwad.sdk.components.d.f(p.class);
            if (pVar == null || !s.PW()) {
                return;
            }
            ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).e(pVar.C(str), 2);
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
    }

    private void cy(String str) {
        Iterator<com.kwad.sdk.app.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().U(str);
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
    }

    private void cz(String str) {
        Iterator<com.kwad.sdk.app.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().V(str);
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
    }

    private void B(Context context, String str) {
        com.kwad.sdk.core.c.b.Ho();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            C(context, str);
            return;
        }
        this.auV.add(str);
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.4
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                if (b.this.auV.size() > 0) {
                    for (int i6 = 0; i6 < b.this.auV.size(); i6++) {
                        b.C(b.this.mContext, (String) b.this.auV.get(i6));
                    }
                    b.this.auV.clear();
                }
                com.kwad.sdk.core.c.b.Ho();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    private static void D(Context context, String str) {
        str.getClass();
        switch (str) {
            case "com.tencent.mm":
                auQ.put("com.tencent.mm", m.O(context, "com.tencent.mm"));
                break;
            case "com.kuaishou.nebula":
                auQ.put("com.kuaishou.nebula", m.O(context, "com.kuaishou.nebula"));
                break;
            case "com.smile.gifmaker":
                auQ.put("com.smile.gifmaker", m.O(context, "com.smile.gifmaker"));
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DA() {
        Context Pp = ServiceProvider.Pp();
        bg(Pp);
        Iterator<AdTemplate> it = ((f) ServiceProvider.get(f.class)).Bq().iterator();
        while (it.hasNext()) {
            AdInfo el = e.el(it.next());
            int bB = com.kwad.sdk.core.response.b.a.bB(el);
            String ay = com.kwad.sdk.core.response.b.a.ay(el);
            if (bB != 12) {
                if (as.aq(Pp, ay)) {
                    A(Pp, ay);
                }
            } else if (!as.aq(Pp, ay)) {
                cv(ay);
            }
        }
    }

    public static b Dw() {
        return a.avb;
    }

    private void Dx() {
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.2
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                try {
                    b.this.DB();
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                try {
                    b.this.DA();
                    b.this.DC();
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }
        });
    }

    private static void cA(String str) {
        str.getClass();
        switch (str) {
            case "com.tencent.mm":
                auQ.put("com.tencent.mm", "");
                break;
            case "com.kuaishou.nebula":
                auQ.put("com.kuaishou.nebula", "");
                break;
            case "com.smile.gifmaker":
                auQ.put("com.smile.gifmaker", "");
                break;
        }
    }

    private void cw(String str) {
        com.kwad.sdk.core.c.b.Ho();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            cx(str);
            return;
        }
        this.auW.add(str);
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.5
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                if (b.this.auW.size() > 0) {
                    for (int i6 = 0; i6 < b.this.auW.size(); i6++) {
                        b.cx((String) b.this.auW.get(i6));
                    }
                    b.this.auW.clear();
                }
                com.kwad.sdk.core.c.b.Ho();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    public final String getVersion(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        bf(context);
        return auQ.get(str);
    }

    public final void b(com.kwad.sdk.app.a aVar) {
        if (aVar == null) {
            return;
        }
        Dy();
        this.mListeners.remove(aVar);
    }

    public final void a(com.kwad.sdk.app.a aVar) {
        if (aVar == null) {
            return;
        }
        Dy();
        this.mListeners.add(aVar);
    }
}
