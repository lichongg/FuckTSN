package com.qq.e.comm.pi;

import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface UBVI extends LADI {
    void destroy();

    void fetchAd();

    String getAdNetWorkName();

    void onWindowFocusChanged(boolean z5);

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setRefresh(int i6);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);
}
