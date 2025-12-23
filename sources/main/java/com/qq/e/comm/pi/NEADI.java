package com.qq.e.comm.pi;

import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface NEADI extends IBiddingLoss {
    String getAdNetWorkName();

    void loadAd(int i6);

    void loadAd(int i6, LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i6);

    void setMinVideoDuration(int i6);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVideoOption(VideoOption videoOption);
}
