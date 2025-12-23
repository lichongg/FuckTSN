package com.kwad.sdk.api.loader;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.analytics.pro.bi;
import java.io.File;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.api.loader.a$a, reason: collision with other inner class name */
    static class C0668a {
        int atB;
        String atC;
        transient File atD;
        long interval;
        String md5;
        String sdkVersion;

        public final boolean Di() {
            return this.atB == 1;
        }

        public final boolean Dj() {
            return this.atB == -1;
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.atB = jSONObject.optInt("dynamicType");
            this.atC = jSONObject.optString("dynamicUrl");
            this.md5 = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
            this.interval = jSONObject.optLong(bi.aX);
            this.sdkVersion = jSONObject.optString("sdkVersion");
        }

        public final String toString() {
            return "Data{dynamicType=" + this.atB + ", dynamicUrl='" + this.atC + "', md5='" + this.md5 + "', interval=" + this.interval + ", sdkVersion='" + this.sdkVersion + "', downloadFile=" + this.atD + '}';
        }

        C0668a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b {
        C0668a atE;
        String errorMsg;
        long result;

        final boolean isLegal() {
            return this.result == 1 && this.atE != null;
        }

        public final void parseJson(JSONObject jSONObject) {
            this.result = jSONObject.optLong("result");
            this.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            C0668a c0668a = new C0668a();
            this.atE = c0668a;
            c0668a.parseJson(jSONObject.optJSONObject("data"));
        }

        public final String toString() {
            return "UpdateData{result=" + this.result + ", errorMsg='" + this.errorMsg + "', data=" + this.atE + '}';
        }

        b() {
        }
    }
}
