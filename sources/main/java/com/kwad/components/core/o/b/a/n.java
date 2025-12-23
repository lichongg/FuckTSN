package com.kwad.components.core.o.b.a;

import cn.jpush.android.local.JPushConstants;
import com.kwad.components.offline.api.core.network.IIdc;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class n implements IIdc {
    @Override // com.kwad.components.offline.api.core.network.IIdc
    public final String hostForAPI(String str) {
        if (str.equals("api")) {
            return com.kwad.sdk.h.AK();
        }
        return JPushConstants.HTTPS_PRE + com.kwad.sdk.core.network.idc.a.HF().W(str, null);
    }
}
