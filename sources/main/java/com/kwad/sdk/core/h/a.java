package com.kwad.sdk.core.h;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.h;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static C0687a aJV;
    private static boolean aJW;
    private static final AtomicBoolean mHasInit = new AtomicBoolean(false);
    private static boolean aJX = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    /* renamed from: com.kwad.sdk.core.h.a$a, reason: collision with other inner class name */
    public static class C0687a extends com.kwad.sdk.core.response.a.a {
        public List<String> aJY;
        public int aJZ;
        public List<String> aKa;
        public List<String> aKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void JM() {
        aJX = true;
        if (aJV == null) {
            return;
        }
        dI(JN());
        ag.l("ksadsdk_tk_switch", "tk_config", aJX);
    }

    private static void dI(int i6) {
        for (int i7 = 0; i7 < Integer.toBinaryString(i6).length(); i7++) {
            if (((1 << i7) & i6) != 0) {
                aJX = false;
                dJ(i7);
                if (aJX) {
                    return;
                }
            }
        }
    }

    private static void dJ(int i6) {
        if (i6 == 0) {
            if (aJV.aKa.contains(br.RW())) {
                return;
            }
            aJX = true;
        } else if (i6 == 1) {
            if (aJV.aJZ < br.Sg()) {
                aJX = true;
            }
        } else if (i6 == 2) {
            if (aJV.aJY.contains(BuildConfig.VERSION_NAME)) {
                return;
            }
            aJX = true;
        } else if (i6 == 3 && !aJV.aKb.contains(br.RV())) {
            aJX = true;
        }
    }

    public static void JL() {
        h.execute(new bg() { // from class: com.kwad.sdk.core.h.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (a.mHasInit.getAndSet(true)) {
                    return;
                }
                try {
                    C0687a unused = a.aJV = new C0687a();
                    boolean unused2 = a.aJW = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BU();
                    String BV = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BV();
                    if (a.aJW && !TextUtils.isEmpty(BV)) {
                        a.aJV.parseJson(new JSONObject(BV));
                        a.JM();
                        return;
                    }
                    boolean unused3 = a.aJX = a.aJW;
                } catch (Throwable unused4) {
                }
            }
        });
    }

    private static int JN() {
        int i6 = !aJV.aKa.isEmpty() ? 1 : 0;
        C0687a c0687a = aJV;
        int i7 = c0687a.aJZ != 0 ? 2 : 0;
        return ((i6 ^ i7) ^ (!c0687a.aJY.isEmpty() ? 4 : 0)) ^ (aJV.aKb.isEmpty() ? 0 : 8);
    }

    public static boolean JO() {
        return mHasInit.get() ? aJX : ag.m("ksadsdk_tk_switch", "tk_config", true);
    }
}
