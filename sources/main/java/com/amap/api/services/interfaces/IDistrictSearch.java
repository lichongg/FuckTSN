package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.district.DistrictSearchQuery;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IDistrictSearch {
    DistrictSearchQuery getQuery();

    DistrictResult searchDistrict() throws AMapException;

    void searchDistrictAnsy();

    void searchDistrictAsyn();

    void setOnDistrictSearchListener(DistrictSearch.OnDistrictSearchListener onDistrictSearchListener);

    void setQuery(DistrictSearchQuery districtSearchQuery);
}
