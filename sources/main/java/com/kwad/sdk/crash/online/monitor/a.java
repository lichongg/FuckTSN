package com.kwad.sdk.crash.online.monitor;

import android.text.TextUtils;
import com.kwad.sdk.crash.online.monitor.a.c;
import com.kwad.sdk.crash.online.monitor.block.e;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static volatile boolean hasInit;

    static /* synthetic */ boolean access$002(boolean z5) {
        hasInit = true;
        return true;
    }

    private static c LJ() {
        c cVar = new c();
        com.kwad.sdk.crash.online.monitor.a.a aVar = new com.kwad.sdk.crash.online.monitor.a.a();
        cVar.aQl = aVar;
        aVar.aQc = 5;
        return cVar;
    }

    public static void cS(final String str) {
        h.execute(new bg() { // from class: com.kwad.sdk.crash.online.monitor.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (a.hasInit) {
                    return;
                }
                com.kwad.sdk.core.d.c.d("perfMonitor.MonitorManager", "configStr:" + str);
                c fF = a.fF(str);
                com.kwad.sdk.core.d.c.d("perfMonitor.MonitorManager", fF.toJson().toString());
                e.d(fF.aQl);
                a.access$002(true);
            }
        });
    }

    public static c fF(String str) {
        if (TextUtils.isEmpty(str)) {
            return LJ();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c cVar = new c();
            cVar.parseJson(jSONObject);
            return cVar;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.w("perfMonitor.MonitorManager", e6);
            return LJ();
        }
    }
}
