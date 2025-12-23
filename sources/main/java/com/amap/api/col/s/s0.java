package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class s0 implements IRoutePOISearch {

    /* renamed from: a, reason: collision with root package name */
    private RoutePOISearchQuery f8421a;

    /* renamed from: b, reason: collision with root package name */
    private Context f8422b;

    /* renamed from: c, reason: collision with root package name */
    private RoutePOISearch.OnRoutePOISearchListener f8423c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f8424d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            u4.m mVar;
            Message obtainMessage = s0.this.f8424d.obtainMessage();
            obtainMessage.arg1 = 14;
            Bundle bundle = new Bundle();
            RoutePOISearchResult routePOISearchResult = null;
            try {
                try {
                    routePOISearchResult = s0.this.searchRoutePOI();
                    bundle.putInt("errorCode", 1000);
                    mVar = new u4.m();
                } catch (AMapException e6) {
                    bundle.putInt("errorCode", e6.getErrorCode());
                    mVar = new u4.m();
                }
                mVar.f8543b = s0.this.f8423c;
                mVar.f8542a = routePOISearchResult;
                obtainMessage.obj = mVar;
                obtainMessage.setData(bundle);
                s0.this.f8424d.sendMessage(obtainMessage);
            } catch (Throwable th) {
                u4.m mVar2 = new u4.m();
                mVar2.f8543b = s0.this.f8423c;
                mVar2.f8542a = routePOISearchResult;
                obtainMessage.obj = mVar2;
                obtainMessage.setData(bundle);
                s0.this.f8424d.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    private boolean b() {
        RoutePOISearchQuery routePOISearchQuery = this.f8421a;
        if (routePOISearchQuery == null || routePOISearchQuery.getSearchType() == null) {
            return false;
        }
        return (this.f8421a.getFrom() == null && this.f8421a.getTo() == null && this.f8421a.getPolylines() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final RoutePOISearchQuery getQuery() {
        return this.f8421a;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final RoutePOISearchResult searchRoutePOI() throws AMapException {
        try {
            s4.d(this.f8422b);
            if (!b()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            return new u(this.f8422b, this.f8421a.m83clone()).O();
        } catch (AMapException e6) {
            j4.i(e6, "RoutePOISearchCore", "searchRoutePOI");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void setQuery(RoutePOISearchQuery routePOISearchQuery) {
        this.f8421a = routePOISearchQuery;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void setRoutePOISearchListener(RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener) {
        this.f8423c = onRoutePOISearchListener;
    }

    public s0(Context context, RoutePOISearchQuery routePOISearchQuery) throws AMapException {
        this.f8424d = null;
        h1 a6 = cf.a(context, i4.a(false));
        if (a6.f8108a == cf.c.SuccessCode) {
            this.f8422b = context;
            this.f8421a = routePOISearchQuery;
            this.f8424d = u4.a();
            return;
        }
        String str = a6.f8109b;
        throw new AMapException(str, 1, str, a6.f8108a.a());
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void searchRoutePOIAsyn() {
        y.a().b(new a());
    }
}
