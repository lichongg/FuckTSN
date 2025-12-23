package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;
import com.stub.StubApp;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class i0 implements IBusLineSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f8139a;

    /* renamed from: b, reason: collision with root package name */
    private BusLineSearch.OnBusLineSearchListener f8140b;

    /* renamed from: c, reason: collision with root package name */
    private BusLineQuery f8141c;

    /* renamed from: d, reason: collision with root package name */
    private BusLineQuery f8142d;

    /* renamed from: e, reason: collision with root package name */
    private int f8143e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<BusLineResult> f8144f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private Handler f8145g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 3;
                    obtainMessage.what = 1000;
                    u4.b bVar = new u4.b();
                    obtainMessage.obj = bVar;
                    bVar.f8521b = i0.this.f8140b;
                    bVar.f8520a = i0.this.searchBusLine();
                } catch (AMapException e6) {
                    obtainMessage.what = e6.getErrorCode();
                }
            } finally {
                i0.this.f8145g.sendMessage(obtainMessage);
            }
        }
    }

    private void b(BusLineResult busLineResult) {
        int i6;
        this.f8144f = new ArrayList<>();
        int i7 = 0;
        while (true) {
            i6 = this.f8143e;
            if (i7 >= i6) {
                break;
            }
            this.f8144f.add(null);
            i7++;
        }
        if (i6 < 0 || !d(this.f8141c.getPageNumber())) {
            return;
        }
        this.f8144f.set(this.f8141c.getPageNumber(), busLineResult);
    }

    private boolean c() {
        BusLineQuery busLineQuery = this.f8141c;
        return (busLineQuery == null || j4.j(busLineQuery.getQueryString())) ? false : true;
    }

    private boolean d(int i6) {
        return i6 < this.f8143e && i6 >= 0;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final BusLineQuery getQuery() {
        return this.f8141c;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final BusLineResult searchBusLine() throws AMapException {
        try {
            s4.d(this.f8139a);
            if (this.f8142d == null || !c()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!this.f8141c.weakEquals(this.f8142d)) {
                this.f8142d = this.f8141c.m61clone();
                this.f8143e = 0;
                ArrayList<BusLineResult> arrayList = this.f8144f;
                if (arrayList != null) {
                    arrayList.clear();
                }
            }
            if (this.f8143e == 0) {
                BusLineResult busLineResult = (BusLineResult) new e4(this.f8139a, this.f8141c.m61clone()).O();
                b(busLineResult);
                return busLineResult;
            }
            BusLineResult f6 = f(this.f8141c.getPageNumber());
            if (f6 != null) {
                return f6;
            }
            BusLineResult busLineResult2 = (BusLineResult) new e4(this.f8139a, this.f8141c).O();
            this.f8144f.set(this.f8141c.getPageNumber(), busLineResult2);
            return busLineResult2;
        } catch (AMapException e6) {
            j4.i(e6, "BusLineSearch", "searchBusLine");
            throw new AMapException(e6.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void setOnBusLineSearchListener(BusLineSearch.OnBusLineSearchListener onBusLineSearchListener) {
        this.f8140b = onBusLineSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void setQuery(BusLineQuery busLineQuery) {
        if (this.f8141c.weakEquals(busLineQuery)) {
            return;
        }
        this.f8141c = busLineQuery;
        this.f8142d = busLineQuery.m61clone();
    }

    public i0(Context context, BusLineQuery busLineQuery) throws AMapException {
        this.f8145g = null;
        h1 a6 = cf.a(context, i4.a(false));
        if (a6.f8108a == cf.c.SuccessCode) {
            this.f8139a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f8141c = busLineQuery;
            if (busLineQuery != null) {
                this.f8142d = busLineQuery.m61clone();
            }
            this.f8145g = u4.a();
            return;
        }
        String str = a6.f8109b;
        throw new AMapException(str, 1, str, a6.f8108a.a());
    }

    private BusLineResult f(int i6) {
        if (d(i6)) {
            return this.f8144f.get(i6);
        }
        throw new IllegalArgumentException("page out of range");
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void searchBusLineAsyn() {
        try {
            y.a().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
