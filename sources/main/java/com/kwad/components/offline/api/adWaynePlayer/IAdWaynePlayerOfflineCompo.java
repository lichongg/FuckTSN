package com.kwad.components.offline.api.adWaynePlayer;

import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IAdWaynePlayerOfflineCompo extends IOfflineCompo<IAdWaynePlayerOfflineCompoInitConfig> {
    public static final String IMPL = "com.kwad.sdk.AdWaynePlayerOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.adWaynePlayer";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum AdWaynePlayerState {
        READY,
        SO_FAIL
    }

    IAdWaynePlayerPlayModule getAdWaynePlayerPlayModule(String str, boolean z5);

    AdWaynePlayerState getState();
}
