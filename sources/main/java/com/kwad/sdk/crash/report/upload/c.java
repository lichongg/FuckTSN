package com.kwad.sdk.crash.report.upload;

import androidx.annotation.NonNull;
import cn.jpush.android.local.JPushConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends com.kwad.sdk.core.network.b {

    @NonNull
    public final Map<String, String> aQy;

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getBodyMap() {
        return this.aQy;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return JPushConstants.HTTPS_PRE + com.kwad.sdk.core.network.idc.a.HF().W("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/token";
    }

    public c(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        this.aQy = hashMap;
        hashMap.put("did", str);
        hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_SID, str2);
        hashMap.put("fileExtend", str3);
        hashMap.put("bizType", "5");
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }
}
