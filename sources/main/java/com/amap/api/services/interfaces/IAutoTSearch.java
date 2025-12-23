package com.amap.api.services.interfaces;

import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.core.AMapException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IAutoTSearch {
    AutoTChargeStationResult searchChargeStation() throws AMapException;

    void searchChargeStationAsync() throws AMapException;

    void setChargeStationListener(AutoTSearch.OnChargeStationListener onChargeStationListener);

    void setQuery(AutoTSearch.Query query);
}
