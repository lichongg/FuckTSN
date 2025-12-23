package com.qq.e.comm.pi;

import com.qq.e.comm.constants.LoadAdParams;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface NUADI extends IBiddingLoss {
    String getAdNetWorkName();

    void loadData(int i6);

    void loadData(int i6, LoadAdParams loadAdParams);

    void setCategories(List<String> list);

    void setMaxVideoDuration(int i6);

    void setMinVideoDuration(int i6);

    void setVastClassName(String str);
}
