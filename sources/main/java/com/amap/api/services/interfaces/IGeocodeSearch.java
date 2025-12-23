package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IGeocodeSearch {
    RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException;

    void getFromLocationAsyn(RegeocodeQuery regeocodeQuery);

    List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException;

    void getFromLocationNameAsyn(GeocodeQuery geocodeQuery);

    void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener);
}
