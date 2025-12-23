package com.bytedance.android.live.base.api.outer;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.api.outer.ILivePreviewLayout;
import com.bytedance.android.live.base.api.outer.data.RoomInfo;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface ILiveProvider {
    String getCirculationData();

    ILivePreviewLayout getILivePreviewLayout(ILivePreviewLayout.Builder builder);

    String getIdentity();

    ILiveView getLiveView(Context context, int i6, String str, boolean z5, Bundle bundle);

    @Deprecated
    List<RoomInfo> getRoomInfoList(int i6, int i7, int i8);

    List<RoomInfo> getRoomInfoList(int i6, int i7, int i8, Bundle bundle);

    IStandalonePreviewView makeStandalonePreviewView(Context context, int i6, Bundle bundle);

    void reportShow(int i6, String str, Bundle bundle);

    void startLive(Context context, int i6, String str, Bundle bundle);
}
