package com.kwad.components.core.webview.a;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class c extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public String NN;
    public String abZ;
    public String aca;
    public int acb;

    public final AdInfo.SmallAppJumpInfo aR(String str) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = new AdInfo.SmallAppJumpInfo();
        smallAppJumpInfo.mediaSmallAppId = str;
        smallAppJumpInfo.originId = this.abZ;
        smallAppJumpInfo.smallAppJumpUrl = this.aca;
        return smallAppJumpInfo;
    }
}
