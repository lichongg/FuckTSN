package com.kwad.sdk.mobileid.a;

import android.annotation.SuppressLint;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.al;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends d {
    private static String aTm;

    @SuppressLint({"SimpleDateFormat"})
    private static String NG() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }

    private static String NH() {
        return "300012755841";
    }

    private static String NI() {
        return "CB607A51A7A639E532D288AB8C963DB6";
    }

    private static String al(String str, String str2) {
        return al.md5(NH() + str + str2 + "2.0" + NI());
    }

    private static String NF() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        try {
            aTm = NF();
            String NG = NG();
            String al = al(NG, aTm);
            putBody("timestamp", NG);
            putBody("sign", al);
            putBody("traceId", aTm);
            putBody("appId", NH());
            putBody("interfaceVersion", "2.0");
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.Bb();
    }

    @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }
}
