package com.kwad.components.ad.nativead.monitor;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.b;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.c.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class NativeAdMonitor {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class NativeReportMsg extends a implements Serializable {
        public static final long serialVersionUID = 478072683065430299L;
        public String containerName;
        public String containerType;
        public int state;

        public static NativeReportMsg obtain() {
            return new NativeReportMsg();
        }

        public NativeReportMsg setContainerName(String str) {
            this.containerName = str;
            return this;
        }

        public NativeReportMsg setContainerType(String str) {
            this.containerType = str;
            return this;
        }

        public NativeReportMsg setState(int i6) {
            this.state = i6;
            return this;
        }
    }

    public static void a(ViewGroup viewGroup, int i6) {
        String str = "";
        if (viewGroup != null) {
            try {
                str = viewGroup.getClass().getName();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
        }
        if (viewGroup instanceof FrameLayout) {
            a("frameLayout", str, i6);
            return;
        }
        if (viewGroup instanceof LinearLayout) {
            a("linearLayout", str, i6);
        } else if (viewGroup instanceof RelativeLayout) {
            a("relativeLayout", str, i6);
        } else {
            a("unknown", str, i6);
        }
    }

    private static void c(a aVar) {
        try {
            b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_native_container_monitor", "state").b(BusinessType.AD_NATIVE).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.e("reportNativeContainerLog", e6.toString());
        }
    }

    public static void fw() {
        c(NativeReportMsg.obtain().setState(6));
    }

    public static void fx() {
        c(NativeReportMsg.obtain().setState(7));
    }

    private static void a(String str, String str2, int i6) {
        c(NativeReportMsg.obtain().setContainerType(str).setContainerName(str2).setState(i6));
    }
}
