package com.kwad.components.core.p;

import android.content.Context;
import androidx.annotation.NonNull;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.kwad.components.core.proxy.a.b;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.collector.f;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.p;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static boolean WR;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.p.a$a, reason: collision with other inner class name */
    static final class C0626a {
        private static final a WT = new a();
    }

    private static n a(long j6, AdTemplate adTemplate, String str) {
        return new n(j6, adTemplate, str);
    }

    private static n b(long j6, AdTemplate adTemplate) {
        return new n(j6, adTemplate);
    }

    public final void c(@NonNull JSONArray jSONArray) {
        n M = M(10200L);
        M.aHc = jSONArray;
        g.a2(M);
    }

    public final void e(@NonNull JSONObject jSONObject, int i6) {
        n M = M(10201L);
        aa.putValue(jSONObject, "appChangeType", i6);
        M.aHb = jSONObject;
        g.a2(M);
    }

    public final void f(@NonNull AdTemplate adTemplate, int i6, int i7) {
        n b6 = b(12006L, adTemplate);
        b6.adE = i6;
        b6.aye = i7;
        g.a2(b6);
    }

    public final void g(@NonNull AdTemplate adTemplate, int i6, int i7) {
        n b6 = b(10002L, adTemplate);
        b6.Iw();
        if (e.ed(adTemplate)) {
            b6.aGX = com.kwad.sdk.core.response.b.a.K(e.el(adTemplate));
        } else {
            b6.aGX = e.en(adTemplate);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i6);
            jSONObject.put(JThirdPlatFormInterface.KEY_EXTRA, i7);
            b6.errorMsg = jSONObject.toString();
        } catch (JSONException e6) {
            c.printStackTraceOnly(e6);
        }
        g.a2(b6);
    }

    public static n M(long j6) {
        return new n(j6);
    }

    public final void a(@NonNull AdTemplate adTemplate, String str, String str2) {
        n b6 = b(10003L, adTemplate);
        b6.aGX = str;
        b6.errorMsg = str2;
        g.a2(b6);
    }

    public final void aI(@NonNull AdTemplate adTemplate) {
        g.a2(b(10007L, adTemplate));
    }

    public final void aJ(@NonNull AdTemplate adTemplate) {
        g.a2(b(10208L, adTemplate));
    }

    public final void aK(@NonNull AdTemplate adTemplate) {
        g.a2(b(10209L, adTemplate));
    }

    public final void aS(int i6) {
        n M = M(10104L);
        M.aGY = i6;
        g.a2(M);
    }

    public final void aT(int i6) {
        n M = M(10107L);
        M.aGZ = i6;
        g.a2(M);
    }

    public final void az(Context context) {
        n M = M(11L);
        p pVar = (p) d.f(p.class);
        if (pVar != null) {
            JSONArray[] b6 = pVar.b(context, com.kwad.sdk.core.config.e.BB());
            M.aGQ = b6[0];
            M.aGR = b6[1];
            g.a2(M);
        }
    }

    public final void b(@NonNull AdTemplate adTemplate, String str, String str2) {
        n b6 = b(10005L, adTemplate);
        if (e.ed(adTemplate)) {
            b6.aGX = com.kwad.sdk.core.response.b.a.K(e.el(adTemplate));
        } else {
            b6.aGX = e.en(adTemplate);
        }
        b6.aGX = str;
        b6.errorMsg = str2;
        g.a2(b6);
    }

    public final void h(@NonNull AdTemplate adTemplate, long j6) {
        n b6 = b(10202L, adTemplate);
        b6.aHg = j6;
        g.a2(b6);
    }

    public final void i(AdTemplate adTemplate, long j6) {
        n b6 = b(10206L, adTemplate);
        b6.aHw = j6;
        g.a2(b6);
    }

    public final void j(AdTemplate adTemplate, long j6) {
        n b6 = b(10207L, adTemplate);
        b6.aHx = j6;
        g.a2(b6);
    }

    public final n m(String str, String str2) {
        n M = M(12200L);
        M.aHF = str;
        M.aHG = str2;
        return M;
    }

    public final void sf() {
        if (WR) {
            return;
        }
        WR = true;
        h.execute(new bg() { // from class: com.kwad.components.core.p.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                n M = a.M(8L);
                M.aHy = f.DI();
                g.a2(M);
            }
        });
    }

    public final void sg() {
        g.a2(M(10101L));
    }

    public final void sh() {
        g.a2(M(10106L));
    }

    protected a() {
    }

    public static a se() {
        return C0626a.WT;
    }

    public final void c(long j6, int i6) {
        if (com.kwad.sdk.core.config.e.FU()) {
            n M = M(20000L);
            M.timestamp = System.currentTimeMillis();
            M.aHH = i6;
            M.posId = j6;
            M.aHI = BuildConfig.VERSION_CODE;
            g.a2(M);
        }
    }

    public final void e(AdTemplate adTemplate, int i6) {
        n b6 = b(10108L, adTemplate);
        b6.aGZ = i6;
        g.a2(b6);
    }

    public final void f(AdTemplate adTemplate, int i6, String str) {
        n b6 = b(10109L, adTemplate);
        b6.aGZ = 1;
        b6.aHa = str;
        g.a2(b6);
    }

    public final void a(int i6, @NonNull AdTemplate adTemplate, String str) {
        g.a2(a(i6, adTemplate, str));
    }

    public final void a(@NonNull AdTemplate adTemplate, long j6, long j7, int i6) {
        n b6 = b(10203L, adTemplate);
        b6.aci = j6;
        b6.blockDuration = j7;
        b6.aGN = i6;
        g.a2(b6);
    }

    public final void e(String str, String str2, boolean z5) {
        g.a(m(str, str2), z5);
    }

    public final void f(@NonNull AdTemplate adTemplate, int i6) {
        if (com.kwad.sdk.core.config.e.FU()) {
            AdInfo el = e.el(adTemplate);
            n M = M(20000L);
            M.timestamp = System.currentTimeMillis();
            M.aHH = i6;
            M.trace = el.trace;
            M.aHI = BuildConfig.VERSION_CODE;
            M.posId = e.ee(adTemplate);
            g.a2(M);
        }
    }

    public final void a(boolean z5, List<Integer> list) {
        n M = M(10204L);
        M.aHi = z5;
        if (list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            M.aHh = jSONArray;
        }
        g.a2(M);
    }

    public final void g(@NonNull AdTemplate adTemplate, int i6, String str) {
        n b6 = b(107L, adTemplate);
        b6.errorCode = i6;
        b6.errorMsg = str;
        g.a2(b6);
    }

    public final void a(SceneImpl sceneImpl, boolean z5, String str) {
        n M = M(10216L);
        M.aHi = z5;
        M.aHj = str;
        M.adScene = sceneImpl;
        g.a2(M);
    }

    public final void a(@NonNull AdTemplate adTemplate, long j6, int i6) {
        n b6 = b(104L, adTemplate);
        b6.clickTime = com.kwad.sdk.utils.n.eN(adTemplate);
        b6.aHm = j6;
        b6.aHn = i6;
        g.a2(b6);
    }

    public final void a(b bVar) {
        n M = M(10215L);
        M.WH = bVar.WH;
        M.WO = bVar.WO;
        M.WP = bVar.WP;
        M.WQ = bVar.WQ;
        g.a2(M);
    }
}
