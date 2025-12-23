package com.amap.api.services.routepoisearch;

import android.content.Context;
import com.amap.api.col.s.s0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RoutePOISearch {
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingNoExpressways = 3;
    public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
    public static final int DrivingNoHighWay = 6;
    public static final int DrivingNoHighWaySaveMoney = 7;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 8;
    public static final int DrivingShortDistance = 2;

    /* renamed from: a, reason: collision with root package name */
    private IRoutePOISearch f9834a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnRoutePOISearchListener {
        void onRoutePoiSearched(RoutePOISearchResult routePOISearchResult, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum RoutePOISearchType {
        TypeGasStation,
        TypeMaintenanceStation,
        TypeATM,
        TypeToilet,
        TypeFillingStation,
        TypeServiceArea,
        TypeChargeStation,
        TypeFood,
        TypeHotel
    }

    public RoutePOISearchResult searchRoutePOI() throws AMapException {
        IRoutePOISearch iRoutePOISearch = this.f9834a;
        if (iRoutePOISearch != null) {
            return iRoutePOISearch.searchRoutePOI();
        }
        return null;
    }

    public void searchRoutePOIAsyn() {
        IRoutePOISearch iRoutePOISearch = this.f9834a;
        if (iRoutePOISearch != null) {
            iRoutePOISearch.searchRoutePOIAsyn();
        }
    }

    public void setPoiSearchListener(OnRoutePOISearchListener onRoutePOISearchListener) {
        IRoutePOISearch iRoutePOISearch = this.f9834a;
        if (iRoutePOISearch != null) {
            iRoutePOISearch.setRoutePOISearchListener(onRoutePOISearchListener);
        }
    }

    public void setQuery(RoutePOISearchQuery routePOISearchQuery) {
        IRoutePOISearch iRoutePOISearch = this.f9834a;
        if (iRoutePOISearch != null) {
            iRoutePOISearch.setQuery(routePOISearchQuery);
        }
    }

    public RoutePOISearch(Context context, RoutePOISearchQuery routePOISearchQuery) throws AMapException {
        if (this.f9834a == null) {
            try {
                this.f9834a = new s0(context, routePOISearchQuery);
            } catch (Exception e6) {
                e6.printStackTrace();
                if (e6 instanceof AMapException) {
                    throw ((AMapException) e6);
                }
            }
        }
    }
}
