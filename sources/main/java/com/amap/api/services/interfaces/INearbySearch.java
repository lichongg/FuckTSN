package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.nearby.UploadInfo;
import com.amap.api.services.nearby.UploadInfoCallback;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface INearbySearch {
    void addNearbyListener(NearbySearch.NearbyListener nearbyListener);

    void clearUserInfoAsyn();

    void destroy();

    void removeNearbyListener(NearbySearch.NearbyListener nearbyListener);

    NearbySearchResult searchNearbyInfo(NearbySearch.NearbyQuery nearbyQuery) throws AMapException;

    void searchNearbyInfoAsyn(NearbySearch.NearbyQuery nearbyQuery);

    void setUserID(String str);

    void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i6);

    void stopUploadNearbyInfoAuto();

    void uploadNearbyInfoAsyn(UploadInfo uploadInfo);
}
