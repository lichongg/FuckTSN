package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.adlog.c;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c implements NetworkMonitor.a, com.kwad.sdk.core.download.c, com.kwad.sdk.core.webview.a {
    private List<KsAppDownloadListener> PA;

    @NonNull
    private AdTemplate Pw;
    private boolean Px;
    private a Py;
    private DialogInterface.OnShowListener Pz;
    private boolean downloadPauseEnable;
    private Handler iK;

    @NonNull
    private AdInfo mAdInfo;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private JSONObject mReportExtData;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);
    }

    public c(@NonNull AdTemplate adTemplate, JSONObject jSONObject, KsAppDownloadListener ksAppDownloadListener) {
        this.iK = new Handler(Looper.getMainLooper());
        this.PA = new ArrayList();
        this.Pw = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.mReportExtData = jSONObject;
        if (ksAppDownloadListener != null) {
            b(ksAppDownloadListener);
        }
        pA();
        this.downloadPauseEnable = com.kwad.sdk.core.response.b.a.cH(com.kwad.sdk.core.response.b.e.el(this.Pw));
        pz();
        com.kwad.sdk.a.a.c.CU().aZ(this.Pw);
    }

    @Override // com.kwad.sdk.core.download.c
    public final void b(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 4 && eVar.GV()) {
                com.kwad.sdk.core.adlog.c.a(this.Pw, this.mReportExtData);
                eVar.GU();
                com.kwad.sdk.commercial.a.a.bg(this.Pw);
            }
            this.mAdInfo.status = 4;
            pF();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int r(a.C0616a c0616a) {
        this.Px = false;
        pG();
        switch (this.mAdInfo.status) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                return u(c0616a);
            case 2:
            case 3:
                if (c0616a.pm() && this.downloadPauseEnable) {
                    return pN();
                }
                return 0;
            case 4:
                return pO();
            case 8:
            case 9:
            case 11:
                return pL();
            case 10:
            default:
                return 0;
            case 12:
                return z(c0616a);
        }
    }

    private boolean pE() {
        if (Build.VERSION.SDK_INT < 29) {
            if (this.Pw.mIsFromContent && com.kwad.sdk.core.config.e.EO()) {
                boolean pK = pK();
                if (pK) {
                    com.kwad.sdk.core.adlog.c.bV(this.Pw);
                }
                return pK;
            }
            if (!this.Pw.mIsFromContent && com.kwad.sdk.core.config.e.Fu()) {
                boolean av = com.kwad.components.core.l.b.av(ServiceProvider.getContext());
                com.kwad.sdk.core.d.c.d("ApkDownloadHelper", "handleForceOpenApp enableForceOpen: " + av);
                r2 = av ? pK() : false;
                if (r2) {
                    com.kwad.sdk.core.adlog.c.bW(this.Pw);
                }
            }
        }
        return r2;
    }

    private void pF() {
        this.iK.post(new bg() { // from class: com.kwad.components.core.e.d.c.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ArrayList<KsAppDownloadListener> arrayList = new ArrayList(c.this.PA.size());
                arrayList.addAll(c.this.PA);
                for (KsAppDownloadListener ksAppDownloadListener : arrayList) {
                    if (ksAppDownloadListener != null) {
                        c.this.a(ksAppDownloadListener);
                    }
                }
            }
        });
    }

    private boolean pI() {
        a aVar = this.Py;
        if (aVar != null) {
            return aVar.handleDownloadDialog(new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.e.d.c.4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i6) {
                    if (i6 == -1) {
                        switch (c.this.mAdInfo.status) {
                            case 0:
                            case 1:
                            case 5:
                            case 6:
                            case 7:
                                c.this.pM();
                                break;
                            case 4:
                                c.this.pO();
                                break;
                            case 8:
                            case 9:
                            case 11:
                                c.this.pL();
                                break;
                            case 12:
                                c.this.pJ();
                                break;
                        }
                    }
                }
            });
        }
        return false;
    }

    private int pP() {
        this.Pw.downLoadType = 1;
        pM();
        return 5;
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 1;
            pF();
            if (eVar.GV()) {
                this.mAdInfo.mStartDownloadTime = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.adlog.c.bS(this.Pw);
                eVar.GU();
                com.kwad.sdk.commercial.a.a.x(this.Pw);
            }
        }
    }

    public final void aG(int i6) {
        this.Pw.downloadSource = i6;
    }

    @Override // com.kwad.sdk.core.download.c
    public final void c(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            WeakHashMap<String, Integer> weakHashMap = com.kwad.sdk.core.download.b.aDk;
            Integer num = weakHashMap.get(str);
            if (num != null && num.intValue() == 2) {
                this.Pw.downLoadType = 2;
                weakHashMap.remove(str);
            }
            if (this.mAdInfo.status != 2 && eVar.GV()) {
                com.kwad.sdk.core.adlog.c.b(this.Pw, this.mReportExtData);
                eVar.GU();
                com.kwad.sdk.commercial.a.a.bh(this.Pw);
            }
            this.mAdInfo.status = 2;
            pF();
        }
    }

    public final void d(JSONObject jSONObject) {
        this.mReportExtData = jSONObject;
    }

    @Override // com.kwad.sdk.core.download.c
    public final void e(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 9;
            pF();
            if (eVar.GV()) {
                com.kwad.sdk.core.adlog.c.h(this.Pw, 2);
                eVar.GU();
                com.kwad.sdk.commercial.a.a.bk(this.Pw);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void f(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            pG();
            if (eVar.GV()) {
                eVar.GU();
                com.kwad.sdk.commercial.a.a.bm(this.Pw);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void g(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str) && eVar.GV()) {
            eVar.GU();
            com.kwad.sdk.core.adlog.c.bT(this.Pw);
            com.kwad.sdk.commercial.a.a.bj(this.Pw);
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final String pC() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.c
    public final String pD() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }

    public final void pG() {
        if (as.aq(ServiceProvider.getContext(), this.mAdInfo.adBaseInfo.appPackageName)) {
            this.mAdInfo.status = 12;
            return;
        }
        AdInfo adInfo = this.mAdInfo;
        if (adInfo.status == 12) {
            adInfo.status = 0;
            adInfo.progress = 0;
        }
        int i6 = adInfo.status;
        if (i6 == 8 || i6 == 9) {
            String str = adInfo.downloadFilePath;
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                AdInfo adInfo2 = this.mAdInfo;
                adInfo2.status = 0;
                adInfo2.progress = 0;
            }
        }
        AdInfo adInfo3 = this.mAdInfo;
        if (adInfo3.status == 0) {
            String H = com.kwad.sdk.core.download.a.H(adInfo3);
            if (TextUtils.isEmpty(H) || !new File(H).exists()) {
                return;
            }
            AdInfo adInfo4 = this.mAdInfo;
            adInfo4.downloadFilePath = H;
            adInfo4.status = 8;
        }
    }

    @NonNull
    public final AdTemplate pH() {
        return this.Pw;
    }

    public final int pJ() {
        h.execute(new bg() { // from class: com.kwad.components.core.e.d.c.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
            }
        });
        if (!as.as(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.ay(this.mAdInfo))) {
            return 6;
        }
        com.kwad.sdk.core.adlog.c.bU(this.Pw);
        return 6;
    }

    public final int pL() {
        as.a(this.mAdInfo.downloadFilePath, new as.a() { // from class: com.kwad.components.core.e.d.c.6
            @Override // com.kwad.sdk.utils.as.a
            public final void d(Throwable th) {
                com.kwad.sdk.commercial.a.a.i(c.this.Pw, 100003, Log.getStackTraceString(th));
            }

            @Override // com.kwad.sdk.utils.as.a
            public final void pR() {
                com.kwad.sdk.core.adlog.c.h(c.this.Pw, 1);
                com.kwad.sdk.commercial.a.a.bk(c.this.Pw);
            }
        });
        return 7;
    }

    public final int pM() {
        com.kwad.sdk.core.download.a.I(this.mAdInfo);
        return 3;
    }

    public final int pN() {
        com.kwad.sdk.core.download.a.dL(this.mAdInfo.downloadId);
        return 4;
    }

    public final int pO() {
        this.Pw.downLoadType = 2;
        pM();
        return 5;
    }

    @Override // com.kwad.sdk.core.webview.a
    public final void pQ() {
        List<KsAppDownloadListener> list = this.PA;
        if (list != null) {
            list.clear();
        }
    }

    public final int q(a.C0616a c0616a) {
        int i6 = this.mAdInfo.status;
        if (i6 != 0 && i6 != 1) {
            switch (i6) {
                case 4:
                case 5:
                case 6:
                case 7:
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                    return pL();
                case 12:
                    return z(c0616a);
                default:
                    return 0;
            }
        }
        return t(c0616a) ? 11 : 0;
    }

    public final boolean s(a.C0616a c0616a) {
        return this.mAdInfo.status == 0 && t(c0616a);
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.Pz = onShowListener;
    }

    public static int A(a.C0616a c0616a) {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(c0616a.getAdTemplate());
        if (el.downloadSafeInfo.complianceInfo != null) {
            int dW = c0616a.dW();
            if (dW != 2) {
                if (dW != 3) {
                    return el.downloadSafeInfo.complianceInfo.actionBarType;
                }
                return el.downloadSafeInfo.complianceInfo.materialJumpType;
            }
            return el.downloadSafeInfo.complianceInfo.describeBarType;
        }
        return 0;
    }

    private void pA() {
        com.kwad.sdk.core.download.b.GR();
        int dO = com.kwad.sdk.core.download.b.dO(pC());
        if (dO != 0) {
            this.mAdInfo.status = dO;
        }
        pG();
        pF();
    }

    private boolean pK() {
        Context context = ServiceProvider.getContext();
        if (d.a(new a.C0616a(context).aB(this.Pw), 1) == 1) {
            return true;
        }
        boolean as = as.as(context, com.kwad.sdk.core.response.b.a.ay(this.mAdInfo));
        if (as) {
            com.kwad.sdk.core.adlog.c.bU(this.Pw);
        }
        return as;
    }

    private boolean t(a.C0616a c0616a) {
        boolean i6 = com.kwad.sdk.utils.e.i(c0616a.getContext(), this.Pw);
        if (i6) {
            com.kwad.sdk.core.adlog.c.k(this.Pw, 0);
        }
        return i6;
    }

    private int u(a.C0616a c0616a) {
        Context context = c0616a.getContext();
        if (com.kwad.sdk.utils.e.a(context, com.kwad.sdk.core.response.b.a.cW(this.mAdInfo), this.Pw)) {
            com.kwad.sdk.core.adlog.c.k(this.Pw, 1);
            return 11;
        }
        if (t(c0616a)) {
            return 11;
        }
        if (pI()) {
            return 10;
        }
        if (!ao.isNetworkConnected(context)) {
            ac.Q(context, ae.cQ(context));
            return 2;
        }
        if (c0616a.pv() && com.kwad.sdk.core.config.e.Fg()) {
            return v(c0616a);
        }
        if (com.kwad.sdk.core.response.b.e.eA(this.Pw) && c0616a.px() != 2) {
            return d(c0616a.getContext(), c0616a.getAdTemplate());
        }
        if (c0616a.pr()) {
            return w(c0616a);
        }
        if (x(c0616a)) {
            return 8;
        }
        return pM();
    }

    private int v(a.C0616a c0616a) {
        Context context = c0616a.getContext();
        AdTemplate adTemplate = c0616a.getAdTemplate();
        int pw = c0616a.pw();
        if (pw != 1) {
            if (pw != 2) {
                return 1;
            }
            if (com.kwad.sdk.core.response.b.b.dp(adTemplate)) {
                com.kwad.components.core.e.c.b.a(context, new b.a().aA(adTemplate).ak(com.kwad.sdk.core.response.b.b.m122do(adTemplate)).a(this.Pz).c(this.mOnDismissListener).oZ());
                return 8;
            }
            return 8;
        }
        return pM();
    }

    private int w(a.C0616a c0616a) {
        Context context = c0616a.getContext();
        AdTemplate adTemplate = c0616a.getAdTemplate();
        int A = A(c0616a);
        if (A != 1) {
            if (A != 2) {
                if (A == 3) {
                    return 1;
                }
                if (x(c0616a)) {
                    return 8;
                }
                return pM();
            }
            return d(c0616a.getContext(), c0616a.getAdTemplate());
        }
        if (com.kwad.sdk.core.response.b.b.dp(adTemplate)) {
            com.kwad.components.core.e.c.b.a(context, new b.a().aA(adTemplate).ak(com.kwad.sdk.core.response.b.b.m122do(adTemplate)).a(this.Pz).c(this.mOnDismissListener).oZ());
        }
        return 8;
    }

    private boolean x(a.C0616a c0616a) {
        if (!c0616a.po() && this.mAdInfo.status != 4 && com.kwad.sdk.core.response.b.b.ds(this.Pw) && y(c0616a)) {
            return com.kwad.components.core.e.c.b.a(c0616a.getContext(), new b.a().aA(this.Pw).ak(com.kwad.sdk.core.response.b.b.dr(this.Pw)).a(this.Pz).c(this.mOnDismissListener).oZ());
        }
        return false;
    }

    private static boolean y(a.C0616a c0616a) {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(c0616a.getAdTemplate());
        if (com.kwad.sdk.core.response.b.a.bw(el) && (DownloadLandPageActivity.showingAdWebViewLandPage || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0616a.getAdTemplate().isWebViewDownload)) {
            return true;
        }
        if (com.kwad.sdk.core.response.b.a.bx(el) && !ao.isWifiConnected(c0616a.getContext())) {
            return true;
        }
        return false;
    }

    private int z(a.C0616a c0616a) {
        Activity ej = m.ej(c0616a.getContext());
        if (ej != null && com.kwad.sdk.core.response.b.a.T(this.mAdInfo) && !c0616a.pf() && !c0616a.pk()) {
            c0616a.ay(1);
            com.kwad.components.core.e.e.e.a(ej, c0616a);
            return 18;
        }
        return pJ();
    }

    public final void clear() {
        pQ();
    }

    @Override // com.kwad.sdk.core.download.c
    public final void d(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 5 && eVar.GV()) {
                com.kwad.sdk.core.adlog.c.d(this.Pw, this.mReportExtData);
                eVar.GU();
                com.kwad.sdk.commercial.a.a.bi(this.Pw);
            }
            com.kwad.sdk.a.a.c.CU().ba(this.Pw);
            com.kwad.sdk.a.a.b.CR().aV(this.Pw);
            this.mAdInfo.status = 5;
            pF();
        }
    }

    public final int pB() {
        pG();
        int i6 = this.mAdInfo.status;
        if (i6 == 3) {
            return 2;
        }
        return i6;
    }

    public final void pz() {
        com.kwad.sdk.core.download.b.GR().a(this, this.Pw);
        if (com.kwad.sdk.core.config.e.FG()) {
            NetworkMonitor.getInstance().a(ServiceProvider.getContext(), this, this.Pw);
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
        final boolean z5;
        this.mAdInfo.status = 12;
        pF();
        if (eVar.GV()) {
            com.kwad.sdk.core.adlog.c.e(this.Pw, this.mReportExtData);
            eVar.GU();
            com.kwad.sdk.commercial.a.a.bl(this.Pw);
            z5 = pE();
            com.kwad.sdk.a.a.c.CU().bc(this.Pw);
            com.kwad.sdk.a.a.c.CU().ba(this.Pw);
            com.kwad.sdk.a.a.b.CR().aV(this.Pw);
            com.kwad.components.core.e.a.e.oK().ax(this.Pw);
            com.kwad.sdk.core.a.Em().dl(pC());
        } else {
            z5 = false;
        }
        h.execute(new bg() { // from class: com.kwad.components.core.e.d.c.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
            }
        });
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i6, int i7, int i8) {
        if (this.mAdInfo.downloadId.equals(str)) {
            AdInfo adInfo = this.mAdInfo;
            adInfo.status = 3;
            adInfo.progress = i6;
            adInfo.soFarBytes = i7;
            adInfo.totalBytes = i8;
            pF();
        }
    }

    public final void d(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        pG();
        a(ksAppDownloadListener);
    }

    public c(@NonNull AdTemplate adTemplate, @NonNull KsAppDownloadListener ksAppDownloadListener) {
        this(adTemplate, null, ksAppDownloadListener);
    }

    public final void c(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.PA.remove(ksAppDownloadListener);
        } else {
            this.iK.post(new bg() { // from class: com.kwad.components.core.e.d.c.8
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    c.this.PA.remove(ksAppDownloadListener);
                }
            });
        }
    }

    public c(@NonNull AdTemplate adTemplate, JSONObject jSONObject) {
        this(adTemplate, jSONObject, null);
    }

    private static int d(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return 9;
        }
        DownloadLandPageActivity.launch(context, adTemplate, false);
        return 9;
    }

    public c(@NonNull AdTemplate adTemplate) {
        this(adTemplate, null, null);
    }

    public c(@NonNull AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener, String str, String str2) {
        this(adTemplate, null, null);
        AdInfo adInfo = this.mAdInfo;
        adInfo.adConversionInfo.appDownloadUrl = str;
        adInfo.adBaseInfo.appPackageName = str2;
        adInfo.downloadId = al.md5(str);
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, String str2, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            AdInfo adInfo = this.mAdInfo;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            adInfo.status = 8;
            pF();
            if (eVar.GV()) {
                eVar.GU();
                com.kwad.sdk.core.adlog.c.c(this.Pw, this.mReportExtData);
                com.kwad.sdk.commercial.a.a.k(this.Pw, SystemClock.elapsedRealtime() - this.mAdInfo.mStartDownloadTime);
                com.kwad.sdk.core.a.Em().e(str, this.Pw);
                h.execute(new Runnable() { // from class: com.kwad.components.core.e.d.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
                    }
                });
                com.kwad.sdk.a.a.c.CU().bb(this.Pw);
                com.kwad.sdk.a.a.c.CU().aZ(this.Pw);
                com.kwad.sdk.a.a.b.CR().aU(this.Pw);
                ApkCacheManager.getInstance().GE();
            }
        }
    }

    @UiThread
    public final void b(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!this.PA.contains(ksAppDownloadListener)) {
                this.PA.add(0, ksAppDownloadListener);
            }
        } else {
            this.iK.post(new bg() { // from class: com.kwad.components.core.e.d.c.7
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (c.this.PA.contains(ksAppDownloadListener)) {
                        return;
                    }
                    c.this.PA.add(0, ksAppDownloadListener);
                }
            });
        }
        pG();
        a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i6, String str2, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 7;
            pF();
            if (eVar.GV()) {
                c.a aVar = new c.a(i6, str2);
                com.kwad.sdk.core.adlog.c.a(this.Pw, aVar);
                com.kwad.components.core.p.a.se().a(this.Pw, this.mAdInfo.adConversionInfo.appDownloadUrl, aVar.toJson().toString());
                eVar.GU();
                com.kwad.sdk.commercial.a.a.h(this.Pw, i6, str2);
            }
            if (this.mAdInfo.adConversionInfo.retryH5TimeStep <= 0 || this.Px) {
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            AdInfo adInfo = this.mAdInfo;
            if (elapsedRealtime - adInfo.mStartDownloadTime >= adInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(adInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(ServiceProvider.getContext(), this.Pw);
            this.Px = true;
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, Throwable th, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 11;
            pF();
            if (eVar.GV()) {
                eVar.GU();
                com.kwad.sdk.commercial.a.a.i(this.Pw, 100003, Log.getStackTraceString(th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull KsAppDownloadListener ksAppDownloadListener) {
        int BY = com.kwad.sdk.core.config.e.BY();
        boolean BX = com.kwad.sdk.core.config.e.BX();
        com.kwad.sdk.core.d.c.d("ApkDownloadHelper", "DownloadProgressTransformUtil  go in updateDownloadProgress");
        AdInfo adInfo = this.mAdInfo;
        int a6 = t.a(adInfo.soFarBytes, adInfo.totalBytes, BX, BY);
        switch (this.mAdInfo.status) {
            case 0:
            case 5:
                ksAppDownloadListener.onIdle();
                break;
            case 1:
                ksAppDownloadListener.onProgressUpdate(0);
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.a) {
                    ((com.kwad.sdk.core.download.a.a) ksAppDownloadListener).onDownloadStarted();
                    break;
                } else {
                    try {
                        ksAppDownloadListener.onDownloadStarted();
                        break;
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        return;
                    }
                }
            case 2:
            case 3:
                ksAppDownloadListener.onProgressUpdate(a6);
                break;
            case 4:
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.a) {
                    ((com.kwad.sdk.core.download.a.a) ksAppDownloadListener).onPaused(a6);
                }
                try {
                    if (ksAppDownloadListener instanceof KsApkDownloadListener) {
                        ((KsApkDownloadListener) ksAppDownloadListener).onPaused(a6);
                        break;
                    }
                } catch (Throwable unused) {
                    return;
                }
                break;
            case 7:
                ksAppDownloadListener.onDownloadFailed();
                break;
            case 8:
            case 9:
                ksAppDownloadListener.onDownloadFinished();
                break;
            case 12:
                ksAppDownloadListener.onInstalled();
                break;
        }
    }

    public final void a(a aVar) {
        this.Py = aVar;
    }

    @Override // com.kwad.sdk.core.NetworkMonitor.a
    public final void a(NetworkMonitor.NetworkState networkState) {
        if (this.mAdInfo.status == 7 && networkState == NetworkMonitor.NetworkState.NETWORK_WIFI) {
            pP();
        }
    }
}
