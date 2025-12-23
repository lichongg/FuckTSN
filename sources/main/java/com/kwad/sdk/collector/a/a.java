package com.kwad.sdk.collector.a;

import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.aa;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends d {
    private C0670a avj;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.collector.a.a$a, reason: collision with other inner class name */
    static class C0670a {
        private List<String> avk;

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, this.avk);
            return jSONObject;
        }

        public C0670a(List<String> list) {
            this.avk = list;
        }
    }

    public a(List<String> list) {
        C0670a c0670a = new C0670a(list);
        this.avj = c0670a;
        putBody("targetAppInfo", c0670a.toJson());
        putBody("sdkVersion", BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.AT();
    }
}
