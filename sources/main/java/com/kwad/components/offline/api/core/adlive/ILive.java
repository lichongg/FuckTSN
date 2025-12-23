package com.kwad.components.offline.api.core.adlive;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface ILive {
    IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j6);

    IAdLiveOfflineView getIAdLiveOfflineView(Context context, int i6);

    IAdLiveEndRequest mIAdLiveEndRequest(String str);
}
