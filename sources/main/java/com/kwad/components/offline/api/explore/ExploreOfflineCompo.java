package com.kwad.components.offline.api.explore;

import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.explore.model.AdParams;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface ExploreOfflineCompo extends IOfflineCompo<ExploreOfflineCompoInitConfig> {
    public static final String IMPL = "com.kwad.sdk.explore.ExploreOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.explore";

    void reportKsAllianceAdLoad(AdParams adParams);

    void reportKsAllianceAdShow(AdParams adParams);
}
