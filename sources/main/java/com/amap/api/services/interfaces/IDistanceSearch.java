package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IDistanceSearch {
    DistanceResult calculateRouteDistance(DistanceSearch.DistanceQuery distanceQuery) throws AMapException;

    void calculateRouteDistanceAsyn(DistanceSearch.DistanceQuery distanceQuery);

    void setDistanceSearchListener(DistanceSearch.OnDistanceSearchListener onDistanceSearchListener);
}
