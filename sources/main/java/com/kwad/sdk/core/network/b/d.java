package com.kwad.sdk.core.network.b;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d implements b {
    private static boolean aFG = true;
    public static double aFH = 1.0d;
    private static volatile boolean aFL = false;
    private static String aFM = "";
    private long aFI = -1;
    private long aFJ = -1;
    private long aFK = -1;
    private j aFN = new j();

    private static boolean c(@NonNull i iVar) {
        if (TextUtils.isEmpty(iVar.url)) {
            return true;
        }
        String lowerCase = iVar.url.toLowerCase();
        return lowerCase.contains("beta") || lowerCase.contains("test") || lowerCase.contains("staging");
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final /* synthetic */ b dy(int i6) {
        return dC(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: HV, reason: merged with bridge method [inline-methods] */
    public d HN() {
        this.aFN.aER = SystemClock.elapsedRealtime();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: HX, reason: merged with bridge method [inline-methods] */
    public d HP() {
        if (aA(this.aFI) && aA(this.aFJ)) {
            this.aFN.aEY = this.aFJ - this.aFI;
            en("info.waiting_response_cost:" + this.aFN.aEY);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: HY, reason: merged with bridge method [inline-methods] */
    public d HQ() {
        if (aA(this.aFN.aER)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.aFI = elapsedRealtime;
            j jVar = this.aFN;
            jVar.aEL = elapsedRealtime - jVar.aER;
            if (aA(jVar.aEJ)) {
                j jVar2 = this.aFN;
                jVar2.aEK = jVar2.aEL - jVar2.aEJ;
            }
            en("info.request_create_cost:" + this.aFN.aEL);
            en("info.requestAddParamsCost:" + this.aFN.aEK);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: HZ, reason: merged with bridge method [inline-methods] */
    public d HS() {
        if (aA(this.aFJ)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.aFK = elapsedRealtime;
            this.aFN.aEW = elapsedRealtime - this.aFJ;
            en("info.response_parse_cost:" + this.aFN.aEW);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: Ia, reason: merged with bridge method [inline-methods] */
    public d HT() {
        if (aA(this.aFK)) {
            this.aFN.aFd = SystemClock.elapsedRealtime() - this.aFK;
            Ib();
            en("info.response_done_cost:" + this.aFN.aFd);
        }
        return this;
    }

    private void Ib() {
        j jVar = this.aFN;
        if (jVar == null || jVar.aFc != 1 || aD(jVar.aFd)) {
            return;
        }
        this.aFN.aFd = -1L;
    }

    private d Ic() {
        this.aFN.aFg = (int) com.kwad.sdk.ip.direct.a.Mx();
        this.aFN.aFh = (int) com.kwad.sdk.ip.direct.a.My();
        this.aFN.aFi = (int) com.kwad.sdk.ip.direct.a.Mz();
        return this;
    }

    private void Id() {
        i c6 = c(this.aFN);
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(c6);
        }
        com.kwad.sdk.core.d.c.d("NetworkMonitorRecorder", "reportError" + c6.toJson().toString());
    }

    private static boolean aA(long j6) {
        return j6 != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: aB, reason: merged with bridge method [inline-methods] */
    public d az(long j6) {
        this.aFN.aEX = j6;
        en("responseSize:" + j6);
        return this;
    }

    private d aC(long j6) {
        this.aFN.aEZ = j6;
        en("totalCost:" + j6);
        return this;
    }

    private static boolean aD(long j6) {
        return j6 >= 50;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: dB, reason: merged with bridge method [inline-methods] */
    public d dx(int i6) {
        this.aFN.httpCode = i6;
        en("http_code:" + i6);
        return this;
    }

    private d dC(int i6) {
        this.aFN.aFc = i6;
        en("hasData:" + i6);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: dD, reason: merged with bridge method [inline-methods] */
    public d dz(int i6) {
        this.aFN.result = i6;
        en("result:" + i6);
        return this;
    }

    private static void en(String str) {
        if (aFG) {
            com.kwad.sdk.core.d.c.d("NetworkMonitorRecorder", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: eq, reason: merged with bridge method [inline-methods] */
    public d ek(String str) {
        this.aFN.errorMsg = str;
        en(str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: er, reason: merged with bridge method [inline-methods] */
    public d el(String str) {
        this.aFN.aEH = str;
        en("reqType:" + str);
        et(com.kwad.sdk.ip.direct.a.Mw());
        Ic();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: es, reason: merged with bridge method [inline-methods] */
    public d em(String str) {
        this.aFN.aFb = str;
        en("requestId:" + str);
        return this;
    }

    private d et(String str) {
        this.aFN.aFe = str;
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b HR() {
        if (aA(this.aFN.aER)) {
            this.aFN.aEJ = SystemClock.elapsedRealtime() - this.aFN.aER;
            en("info.request_prepare_cost:" + this.aFN.aEJ);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b dA(int i6) {
        j jVar = this.aFN;
        jVar.aFf = i6;
        if (i6 != 0) {
            jVar.aEI = 1;
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final void report() {
        if (c((i) this.aFN)) {
            return;
        }
        if (this.aFN.httpCode != 200) {
            Id();
            return;
        }
        long elapsedRealtime = aA(this.aFN.aER) ? SystemClock.elapsedRealtime() - this.aFN.aER : -1L;
        aC(elapsedRealtime);
        if (elapsedRealtime > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS || elapsedRealtime <= -1) {
            return;
        }
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(this.aFN);
        }
        en("report normal" + this.aFN.toString());
    }

    public d() {
        aFH = new Random().nextDouble();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: HW, reason: merged with bridge method [inline-methods] */
    public d HO() {
        this.aFJ = SystemClock.elapsedRealtime();
        en("this.responseReceiveTime:" + this.aFJ);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: eo, reason: merged with bridge method [inline-methods] */
    public d ei(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aFN.url = str;
            if (str.contains("?")) {
                String[] split = str.split("\\?");
                if (split.length > 0) {
                    str = split[0];
                }
            }
            if (!TextUtils.isEmpty(str)) {
                en("url:" + str);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: ep, reason: merged with bridge method [inline-methods] */
    public d ej(String str) {
        try {
            this.aFN.host = Uri.parse(str).getHost();
            en("host:" + this.aFN.host);
            return this;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.e("NetworkMonitorRecorder", Log.getStackTraceString(e6));
            return this;
        }
    }

    private static i c(j jVar) {
        i iVar = new i();
        iVar.errorMsg = jVar.errorMsg;
        iVar.host = jVar.host;
        iVar.httpCode = jVar.httpCode;
        iVar.aEH = jVar.aEH;
        iVar.url = jVar.url;
        iVar.aEI = jVar.aEI;
        return iVar;
    }
}
