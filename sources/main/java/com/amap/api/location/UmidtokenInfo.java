package com.amap.api.location;

import android.content.Context;
import android.os.Handler;
import androidx.work.WorkRequest;
import com.amap.api.col.p0003l.i4;
import com.autonavi.aps.amapapi.utils.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class UmidtokenInfo {

    /* renamed from: d, reason: collision with root package name */
    private static AMapLocationClient f8910d;

    /* renamed from: a, reason: collision with root package name */
    static Handler f8907a = new Handler();

    /* renamed from: b, reason: collision with root package name */
    static String f8908b = null;

    /* renamed from: e, reason: collision with root package name */
    private static long f8911e = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;

    /* renamed from: c, reason: collision with root package name */
    static boolean f8909c = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements AMapLocationListener {
        a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            try {
                if (UmidtokenInfo.f8910d != null) {
                    UmidtokenInfo.f8907a.removeCallbacksAndMessages(null);
                    UmidtokenInfo.f8910d.onDestroy();
                }
            } catch (Throwable th) {
                b.a(th, "UmidListener", "onLocationChanged");
            }
        }
    }

    public static String getUmidtoken() {
        return f8908b;
    }

    public static void setLocAble(boolean z5) {
        f8909c = z5;
    }

    public static synchronized void setUmidtoken(Context context, String str) {
        synchronized (UmidtokenInfo.class) {
            try {
                f8908b = str;
                i4.s(str);
                if (f8910d == null && f8909c) {
                    a aVar = new a();
                    f8910d = new AMapLocationClient(context);
                    AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
                    aMapLocationClientOption.setOnceLocation(true);
                    aMapLocationClientOption.setNeedAddress(false);
                    f8910d.setLocationOption(aMapLocationClientOption);
                    f8910d.setLocationListener(aVar);
                    f8910d.startLocation();
                    f8907a.postDelayed(new Runnable() { // from class: com.amap.api.location.UmidtokenInfo.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (UmidtokenInfo.f8910d != null) {
                                    UmidtokenInfo.f8910d.onDestroy();
                                }
                            } catch (Throwable th) {
                                b.a(th, "UmidListener", "postDelayed");
                            }
                        }
                    }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
                }
            } catch (Throwable th) {
                b.a(th, "UmidListener", "setUmidtoken");
            }
        }
    }
}
