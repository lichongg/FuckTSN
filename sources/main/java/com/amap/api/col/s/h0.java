package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IAutoTSearch;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class h0 implements IAutoTSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f8103a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f8104b;

    /* renamed from: c, reason: collision with root package name */
    private AutoTSearch.Query f8105c;

    /* renamed from: d, reason: collision with root package name */
    private AutoTSearch.OnChargeStationListener f8106d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            u4.a aVar;
            Message obtainMessage = h0.this.f8104b.obtainMessage();
            obtainMessage.arg1 = 20;
            obtainMessage.what = 600;
            Bundle bundle = new Bundle();
            AutoTChargeStationResult autoTChargeStationResult = null;
            try {
                try {
                    autoTChargeStationResult = h0.this.searchChargeStation();
                    bundle.putInt("errorCode", 1000);
                    aVar = new u4.a();
                } catch (AMapException e6) {
                    bundle.putInt("errorCode", e6.getErrorCode());
                    aVar = new u4.a();
                }
                aVar.f8519b = h0.this.f8106d;
                aVar.f8518a = autoTChargeStationResult;
                obtainMessage.obj = aVar;
                obtainMessage.setData(bundle);
                h0.this.f8104b.sendMessage(obtainMessage);
            } catch (Throwable th) {
                u4.a aVar2 = new u4.a();
                aVar2.f8519b = h0.this.f8106d;
                aVar2.f8518a = autoTChargeStationResult;
                obtainMessage.obj = aVar2;
                obtainMessage.setData(bundle);
                h0.this.f8104b.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final AutoTChargeStationResult searchChargeStation() throws AMapException {
        try {
            s4.d(this.f8103a);
            AutoTSearch.Query query = this.f8105c;
            if (query != null) {
                return new b0(this.f8103a, query.m60clone()).O();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e6) {
            throw new AMapException(e6.getMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final void setChargeStationListener(AutoTSearch.OnChargeStationListener onChargeStationListener) {
        this.f8106d = onChargeStationListener;
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final void setQuery(AutoTSearch.Query query) {
        this.f8105c = query;
    }

    public h0(Context context) throws AMapException {
        this.f8104b = null;
        h1 a6 = cf.a(context, i4.a(false));
        if (a6.f8108a == cf.c.SuccessCode) {
            this.f8103a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f8104b = u4.a();
        } else {
            String str = a6.f8109b;
            throw new AMapException(str, 1, str, a6.f8108a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final void searchChargeStationAsync() {
        try {
            y.a().b(new a());
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
