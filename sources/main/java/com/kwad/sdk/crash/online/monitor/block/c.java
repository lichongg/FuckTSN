package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.n.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private static volatile boolean aPN;

    public static void b(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        if (aPN) {
            return;
        }
        try {
            com.kwad.sdk.crash.online.monitor.a.b c6 = c(aVar);
            com.kwad.sdk.n.e.a(b(c6), a(c6), new e.a() { // from class: com.kwad.sdk.crash.online.monitor.block.c.1
                @Override // com.kwad.sdk.n.e.a
                public final void a(String str, long j6, long j7, String str2, String str3) {
                    f.a(str, j6, j7, str2, str3, false);
                }

                @Override // com.kwad.sdk.n.e.a
                public final void onError(String str) {
                    c.onError(str);
                }
            });
            aPN = true;
        } catch (Exception e6) {
            onError(Log.getStackTraceString(e6));
        }
    }

    private static String a(com.kwad.sdk.crash.online.monitor.a.b bVar) {
        String str = new String(com.kwad.sdk.core.a.c.Hh().decode((bVar == null || TextUtils.isEmpty(bVar.aQg)) ? "b25SZXBvcnRJc3N1ZQ==" : bVar.aQg));
        com.kwad.sdk.core.d.c.d("perfMonitor.Injector", "report methodName:" + str);
        return str;
    }

    private static com.kwad.sdk.crash.online.monitor.a.b c(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        h hVar = (h) ServiceProvider.get(h.class);
        String appId = hVar != null ? hVar.getAppId() : "";
        if (TextUtils.isEmpty(appId)) {
            return null;
        }
        return aVar.fN(appId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onError(String str) {
        f.fM(str);
        com.kwad.sdk.core.d.c.w("perfMonitor.Injector", str);
    }

    private static String b(com.kwad.sdk.crash.online.monitor.a.b bVar) {
        String str;
        if (bVar != null && !TextUtils.isEmpty(bVar.aQf)) {
            str = bVar.aQf;
        } else {
            str = "Y29tLnRlbmNlbnQubWF0cml4LnBsdWdpbi5QbHVnaW5MaXN0ZW5lcg==";
        }
        String str2 = new String(com.kwad.sdk.core.a.c.Hh().decode(str));
        com.kwad.sdk.core.d.c.d("perfMonitor.Injector", "ListenerName:" + str2);
        return str2;
    }
}
