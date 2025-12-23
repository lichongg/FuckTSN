package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class w0 implements IWeatherSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f8581a;

    /* renamed from: b, reason: collision with root package name */
    private WeatherSearchQuery f8582b;

    /* renamed from: c, reason: collision with root package name */
    private WeatherSearch.OnWeatherSearchListener f8583c;

    /* renamed from: d, reason: collision with root package name */
    private LocalWeatherLiveResult f8584d;

    /* renamed from: e, reason: collision with root package name */
    private LocalWeatherForecastResult f8585e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f8586f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.arg1 = 13;
            Bundle bundle = new Bundle();
            if (w0.this.f8582b != null) {
                if (w0.this.f8582b.getType() == 1) {
                    try {
                        w0 w0Var = w0.this;
                        w0Var.f8584d = w0Var.b();
                        bundle.putInt("errorCode", 1000);
                        return;
                    } catch (AMapException e6) {
                        bundle.putInt("errorCode", e6.getErrorCode());
                        j4.i(e6, "WeatherSearch", "searchWeatherAsyn");
                        return;
                    } catch (Throwable th) {
                        j4.i(th, "WeatherSearch", "searchWeatherAnsyThrowable");
                        return;
                    } finally {
                        u4.o oVar = new u4.o();
                        obtainMessage.what = 1301;
                        oVar.f8547b = w0.this.f8583c;
                        oVar.f8546a = w0.this.f8584d;
                        obtainMessage.obj = oVar;
                        obtainMessage.setData(bundle);
                        w0.this.f8586f.sendMessage(obtainMessage);
                    }
                }
                if (w0.this.f8582b.getType() == 2) {
                    try {
                        w0 w0Var2 = w0.this;
                        w0Var2.f8585e = w0Var2.e();
                        bundle.putInt("errorCode", 1000);
                        return;
                    } catch (AMapException e7) {
                        bundle.putInt("errorCode", e7.getErrorCode());
                        j4.i(e7, "WeatherSearch", "searchWeatherAsyn");
                        return;
                    } catch (Throwable th2) {
                        j4.i(th2, "WeatherSearch", "searchWeatherAnsyThrowable");
                        return;
                    } finally {
                        u4.n nVar = new u4.n();
                        obtainMessage.what = 1302;
                        nVar.f8545b = w0.this.f8583c;
                        nVar.f8544a = w0.this.f8585e;
                        obtainMessage.obj = nVar;
                        obtainMessage.setData(bundle);
                        w0.this.f8586f.sendMessage(obtainMessage);
                    }
                }
                return;
            }
            try {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } catch (AMapException e8) {
                j4.i(e8, "WeatherSearch", "searchWeatherAsyn");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocalWeatherLiveResult b() throws AMapException {
        s4.d(this.f8581a);
        WeatherSearchQuery weatherSearchQuery = this.f8582b;
        if (weatherSearchQuery == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        e0 e0Var = new e0(this.f8581a, weatherSearchQuery);
        return LocalWeatherLiveResult.createPagedResult((WeatherSearchQuery) e0Var.U(), e0Var.O());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocalWeatherForecastResult e() throws AMapException {
        s4.d(this.f8581a);
        WeatherSearchQuery weatherSearchQuery = this.f8582b;
        if (weatherSearchQuery == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        d0 d0Var = new d0(this.f8581a, weatherSearchQuery);
        return LocalWeatherForecastResult.createPagedResult((WeatherSearchQuery) d0Var.U(), d0Var.O());
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final WeatherSearchQuery getQuery() {
        return this.f8582b;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener onWeatherSearchListener) {
        this.f8583c = onWeatherSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setQuery(WeatherSearchQuery weatherSearchQuery) {
        this.f8582b = weatherSearchQuery;
    }

    public w0(Context context) throws AMapException {
        this.f8586f = null;
        h1 a6 = cf.a(context, i4.a(false));
        if (a6.f8108a == cf.c.SuccessCode) {
            this.f8581a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f8586f = u4.a();
        } else {
            String str = a6.f8109b;
            throw new AMapException(str, 1, str, a6.f8108a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void searchWeatherAsyn() {
        try {
            y.a().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
