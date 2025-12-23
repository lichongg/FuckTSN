package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;
import com.stub.StubApp;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class j0 implements IBusStationSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f8171a;

    /* renamed from: b, reason: collision with root package name */
    private BusStationSearch.OnBusStationSearchListener f8172b;

    /* renamed from: c, reason: collision with root package name */
    private BusStationQuery f8173c;

    /* renamed from: d, reason: collision with root package name */
    private BusStationQuery f8174d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<BusStationResult> f8175e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private int f8176f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f8177g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 7;
                    u4.c cVar = new u4.c();
                    cVar.f8523b = j0.this.f8172b;
                    obtainMessage.obj = cVar;
                    BusStationResult searchBusStation = j0.this.searchBusStation();
                    obtainMessage.what = 1000;
                    cVar.f8522a = searchBusStation;
                } catch (AMapException e6) {
                    obtainMessage.what = e6.getErrorCode();
                }
            } finally {
                j0.this.f8177g.sendMessage(obtainMessage);
            }
        }
    }

    private void b(BusStationResult busStationResult) {
        int i6;
        this.f8175e = new ArrayList<>();
        int i7 = 0;
        while (true) {
            i6 = this.f8176f;
            if (i7 > i6) {
                break;
            }
            this.f8175e.add(null);
            i7++;
        }
        if (i6 > 0) {
            this.f8175e.set(this.f8173c.getPageNumber(), busStationResult);
        }
    }

    private boolean c() {
        BusStationQuery busStationQuery = this.f8173c;
        return (busStationQuery == null || j4.j(busStationQuery.getQueryString())) ? false : true;
    }

    private boolean d(int i6) {
        return i6 <= this.f8176f && i6 >= 0;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final BusStationQuery getQuery() {
        return this.f8173c;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final BusStationResult searchBusStation() throws AMapException {
        try {
            s4.d(this.f8171a);
            if (!c()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!this.f8173c.weakEquals(this.f8174d)) {
                this.f8174d = this.f8173c.m62clone();
                this.f8176f = 0;
                ArrayList<BusStationResult> arrayList = this.f8175e;
                if (arrayList != null) {
                    arrayList.clear();
                }
            }
            if (this.f8176f == 0) {
                BusStationResult busStationResult = (BusStationResult) new e4(this.f8171a, this.f8173c).O();
                this.f8176f = busStationResult.getPageCount();
                b(busStationResult);
                return busStationResult;
            }
            BusStationResult f6 = f(this.f8173c.getPageNumber());
            if (f6 != null) {
                return f6;
            }
            BusStationResult busStationResult2 = (BusStationResult) new e4(this.f8171a, this.f8173c).O();
            this.f8175e.set(this.f8173c.getPageNumber(), busStationResult2);
            return busStationResult2;
        } catch (AMapException e6) {
            j4.i(e6, "BusStationSearch", "searchBusStation");
            throw new AMapException(e6.getErrorMessage());
        } catch (Throwable th) {
            j4.i(th, "BusStationSearch", "searchBusStation");
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener onBusStationSearchListener) {
        this.f8172b = onBusStationSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setQuery(BusStationQuery busStationQuery) {
        if (busStationQuery.weakEquals(this.f8173c)) {
            return;
        }
        this.f8173c = busStationQuery;
    }

    public j0(Context context, BusStationQuery busStationQuery) throws AMapException {
        h1 a6 = cf.a(context, i4.a(false));
        if (a6.f8108a == cf.c.SuccessCode) {
            this.f8171a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f8173c = busStationQuery;
            this.f8177g = u4.a();
            return;
        }
        String str = a6.f8109b;
        throw new AMapException(str, 1, str, a6.f8108a.a());
    }

    private BusStationResult f(int i6) {
        if (d(i6)) {
            return this.f8175e.get(i6);
        }
        throw new IllegalArgumentException("page out of range");
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void searchBusStationAsyn() {
        try {
            y.a().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
