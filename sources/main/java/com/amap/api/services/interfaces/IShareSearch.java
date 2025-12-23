package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.share.ShareSearch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IShareSearch {
    String searchBusRouteShareUrl(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) throws AMapException;

    void searchBusRouteShareUrlAsyn(ShareSearch.ShareBusRouteQuery shareBusRouteQuery);

    String searchDrivingRouteShareUrl(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException;

    void searchDrivingRouteShareUrlAsyn(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery);

    String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException;

    void searchLocationShareUrlAsyn(LatLonSharePoint latLonSharePoint);

    String searchNaviShareUrl(ShareSearch.ShareNaviQuery shareNaviQuery) throws AMapException;

    void searchNaviShareUrlAsyn(ShareSearch.ShareNaviQuery shareNaviQuery);

    String searchPoiShareUrl(PoiItem poiItem) throws AMapException;

    void searchPoiShareUrlAsyn(PoiItem poiItem);

    String searchWalkRouteShareUrl(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException;

    void searchWalkRouteShareUrlAsyn(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery);

    void setOnShareSearchListener(ShareSearch.OnShareSearchListener onShareSearchListener);
}
