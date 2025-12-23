package com.amap.api.services.busline;

import android.content.Context;
import com.amap.api.col.s.i0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BusLineSearch {
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";

    /* renamed from: a, reason: collision with root package name */
    private IBusLineSearch f9140a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnBusLineSearchListener {
        void onBusLineSearched(BusLineResult busLineResult, int i6);
    }

    public BusLineQuery getQuery() {
        IBusLineSearch iBusLineSearch = this.f9140a;
        if (iBusLineSearch != null) {
            return iBusLineSearch.getQuery();
        }
        return null;
    }

    public BusLineResult searchBusLine() throws AMapException {
        IBusLineSearch iBusLineSearch = this.f9140a;
        if (iBusLineSearch != null) {
            return iBusLineSearch.searchBusLine();
        }
        return null;
    }

    public void searchBusLineAsyn() {
        IBusLineSearch iBusLineSearch = this.f9140a;
        if (iBusLineSearch != null) {
            iBusLineSearch.searchBusLineAsyn();
        }
    }

    public void setOnBusLineSearchListener(OnBusLineSearchListener onBusLineSearchListener) {
        IBusLineSearch iBusLineSearch = this.f9140a;
        if (iBusLineSearch != null) {
            iBusLineSearch.setOnBusLineSearchListener(onBusLineSearchListener);
        }
    }

    public void setQuery(BusLineQuery busLineQuery) {
        IBusLineSearch iBusLineSearch = this.f9140a;
        if (iBusLineSearch != null) {
            iBusLineSearch.setQuery(busLineQuery);
        }
    }

    public BusLineSearch(Context context, BusLineQuery busLineQuery) throws AMapException {
        this.f9140a = null;
        try {
            this.f9140a = new i0(context, busLineQuery);
        } catch (Exception e6) {
            e6.printStackTrace();
            if (!(e6 instanceof AMapException)) {
            } else {
                throw ((AMapException) e6);
            }
        }
    }
}
