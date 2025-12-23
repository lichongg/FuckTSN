package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.p0003l.ax;
import com.amap.api.col.p0003l.b3;
import com.amap.api.col.p0003l.c0;
import com.amap.api.col.p0003l.ft;
import com.amap.api.col.p0003l.h0;
import com.amap.api.col.p0003l.k4;
import com.amap.api.col.p0003l.n4;
import com.amap.api.col.p0003l.v5;
import com.amap.api.col.p0003l.y2;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class OfflineMapManager {

    /* renamed from: a, reason: collision with root package name */
    h0 f9044a;

    /* renamed from: b, reason: collision with root package name */
    c0 f9045b;

    /* renamed from: c, reason: collision with root package name */
    private Context f9046c;

    /* renamed from: d, reason: collision with root package name */
    private OfflineMapDownloadListener f9047d;

    /* renamed from: e, reason: collision with root package name */
    private OfflineLoadedListener f9048e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f9049f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f9050g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OfflineLoadedListener {
        void onVerifyComplete();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OfflineMapDownloadListener {
        void onCheckUpdate(boolean z5, String str);

        void onDownload(int i6, int i7, String str);

        void onRemove(boolean z5, String str, String str2);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener) throws Exception {
        n4 a6 = ft.a(context, b3.s());
        if (a6.f6803a != ft.c.SuccessCode) {
            throw new Exception(a6.f6804b);
        }
        this.f9047d = offlineMapDownloadListener;
        this.f9046c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f9049f = new Handler(this.f9046c.getMainLooper());
        this.f9050g = new Handler(this.f9046c.getMainLooper());
        a(context);
        k4.a().c(this.f9046c);
    }

    private void a(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f9046c = origApplicationContext;
        c0.f5772p = false;
        c0 b6 = c0.b(origApplicationContext);
        this.f9045b = b6;
        b6.g(new c0.d() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1
            @Override // com.amap.api.col.3l.c0.d
            public final void a(final ax axVar) {
                if (OfflineMapManager.this.f9047d == null || axVar == null) {
                    return;
                }
                OfflineMapManager.this.f9049f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            OfflineMapManager.this.f9047d.onDownload(axVar.s().d(), axVar.getcompleteCode(), axVar.getCity());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.col.3l.c0.d
            public final void b(final ax axVar) {
                if (OfflineMapManager.this.f9047d == null || axVar == null) {
                    return;
                }
                OfflineMapManager.this.f9049f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (!axVar.s().equals(axVar.f5645l) && !axVar.s().equals(axVar.f5639f)) {
                                OfflineMapManager.this.f9047d.onCheckUpdate(false, axVar.getCity());
                                return;
                            }
                            OfflineMapManager.this.f9047d.onCheckUpdate(true, axVar.getCity());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.col.3l.c0.d
            public final void c(final ax axVar) {
                if (OfflineMapManager.this.f9047d == null || axVar == null) {
                    return;
                }
                OfflineMapManager.this.f9049f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (axVar.s().equals(axVar.f5639f)) {
                                OfflineMapManager.this.f9047d.onRemove(true, axVar.getCity(), "");
                            } else {
                                OfflineMapManager.this.f9047d.onRemove(false, axVar.getCity(), "");
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.col.3l.c0.d
            public final void a() {
                if (OfflineMapManager.this.f9048e != null) {
                    OfflineMapManager.this.f9049f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                OfflineMapManager.this.f9048e.onVerifyComplete();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
        try {
            this.f9045b.d();
            this.f9044a = this.f9045b.f5785k;
            y2.k(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b() {
        this.f9047d = null;
    }

    public final void destroy() {
        try {
            c0 c0Var = this.f9045b;
            if (c0Var != null) {
                c0Var.A();
            }
            b();
            Handler handler = this.f9049f;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f9049f = null;
            Handler handler2 = this.f9050g;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            this.f9050g = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityCode(String str) throws AMapException {
        try {
            this.f9045b.C(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityName(String str) throws AMapException {
        try {
            this.f9045b.y(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final ArrayList<OfflineMapCity> getDownloadOfflineMapCityList() {
        return this.f9044a.s();
    }

    public final ArrayList<OfflineMapProvince> getDownloadOfflineMapProvinceList() {
        return this.f9044a.t();
    }

    public final ArrayList<OfflineMapCity> getDownloadingCityList() {
        return this.f9044a.u();
    }

    public final ArrayList<OfflineMapProvince> getDownloadingProvinceList() {
        return this.f9044a.v();
    }

    public final OfflineMapCity getItemByCityCode(String str) {
        return this.f9044a.a(str);
    }

    public final OfflineMapCity getItemByCityName(String str) {
        return this.f9044a.m(str);
    }

    public final OfflineMapProvince getItemByProvinceName(String str) {
        return this.f9044a.r(str);
    }

    public final ArrayList<OfflineMapCity> getOfflineMapCityList() {
        return this.f9044a.n();
    }

    public final ArrayList<OfflineMapProvince> getOfflineMapProvinceList() {
        return this.f9044a.b();
    }

    public final void pause() {
        this.f9045b.w();
    }

    public final void pauseByName(String str) {
        this.f9045b.v(str);
    }

    public final void remove(String str) {
        try {
            if (this.f9045b.m(str)) {
                this.f9045b.r(str);
                return;
            }
            OfflineMapProvince r5 = this.f9044a.r(str);
            if (r5 != null && r5.getCityList() != null) {
                Iterator<OfflineMapCity> it = r5.getCityList().iterator();
                while (it.hasNext()) {
                    final String city = it.next().getCity();
                    this.f9050g.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            OfflineMapManager.this.f9045b.r(city);
                        }
                    });
                }
                return;
            }
            OfflineMapDownloadListener offlineMapDownloadListener = this.f9047d;
            if (offlineMapDownloadListener != null) {
                offlineMapDownloadListener.onRemove(false, str, "没有该城市");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnOfflineLoadedListener(OfflineLoadedListener offlineLoadedListener) {
        this.f9048e = offlineLoadedListener;
    }

    public final void stop() {
        this.f9045b.t();
    }

    public final void downloadByProvinceName(String str) throws AMapException {
        try {
            a();
            OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
            if (itemByProvinceName != null) {
                Iterator<OfflineMapCity> it = itemByProvinceName.getCityList().iterator();
                while (it.hasNext()) {
                    final String city = it.next().getCity();
                    this.f9050g.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                OfflineMapManager.this.f9045b.y(city);
                            } catch (AMapException e6) {
                                v5.p(e6, "OfflineMapManager", "downloadByProvinceName");
                            }
                        }
                    });
                }
                return;
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (Throwable th) {
            if (!(th instanceof AMapException)) {
                v5.p(th, "OfflineMapManager", "downloadByProvinceName");
                return;
            }
            throw th;
        }
    }

    public final void updateOfflineCityByCode(String str) throws AMapException {
        OfflineMapCity itemByCityCode = getItemByCityCode(str);
        if (itemByCityCode != null && itemByCityCode.getCity() != null) {
            a(itemByCityCode.getCity());
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public final void updateOfflineCityByName(String str) throws AMapException {
        a(str);
    }

    public final void updateOfflineMapProvinceByName(String str) throws AMapException {
        a(str);
    }

    private void a(String str) throws AMapException {
        this.f9045b.h(str);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener, AMap aMap) {
        this.f9047d = offlineMapDownloadListener;
        this.f9046c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f9049f = new Handler(this.f9046c.getMainLooper());
        this.f9050g = new Handler(this.f9046c.getMainLooper());
        try {
            a(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() throws AMapException {
        if (!b3.h0(this.f9046c)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }

    public final void restart() {
    }
}
