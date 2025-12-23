package com.amap.api.services.busline;

import android.content.Context;
import com.amap.api.col.s.j0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BusStationSearch {

    /* renamed from: a, reason: collision with root package name */
    private IBusStationSearch f9156a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnBusStationSearchListener {
        void onBusStationSearched(BusStationResult busStationResult, int i6);
    }

    public BusStationQuery getQuery() {
        IBusStationSearch iBusStationSearch = this.f9156a;
        if (iBusStationSearch != null) {
            return iBusStationSearch.getQuery();
        }
        return null;
    }

    public BusStationResult searchBusStation() throws AMapException {
        IBusStationSearch iBusStationSearch = this.f9156a;
        if (iBusStationSearch != null) {
            return iBusStationSearch.searchBusStation();
        }
        return null;
    }

    public void searchBusStationAsyn() {
        IBusStationSearch iBusStationSearch = this.f9156a;
        if (iBusStationSearch != null) {
            iBusStationSearch.searchBusStationAsyn();
        }
    }

    public void setOnBusStationSearchListener(OnBusStationSearchListener onBusStationSearchListener) {
        IBusStationSearch iBusStationSearch = this.f9156a;
        if (iBusStationSearch != null) {
            iBusStationSearch.setOnBusStationSearchListener(onBusStationSearchListener);
        }
    }

    public void setQuery(BusStationQuery busStationQuery) {
        IBusStationSearch iBusStationSearch = this.f9156a;
        if (iBusStationSearch != null) {
            iBusStationSearch.setQuery(busStationQuery);
        }
    }

    public BusStationSearch(Context context, BusStationQuery busStationQuery) throws AMapException {
        if (this.f9156a == null) {
            try {
                this.f9156a = new j0(context, busStationQuery);
            } catch (Exception e6) {
                e6.printStackTrace();
                if (e6 instanceof AMapException) {
                    throw ((AMapException) e6);
                }
            }
        }
    }
}
