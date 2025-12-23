package com.amap.api.col.s;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.nearby.UploadInfo;
import com.amap.api.services.nearby.UploadInfoCallback;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class p0 implements INearbySearch {

    /* renamed from: l, reason: collision with root package name */
    private static long f8298l;

    /* renamed from: b, reason: collision with root package name */
    private String f8300b;

    /* renamed from: c, reason: collision with root package name */
    private Context f8301c;

    /* renamed from: d, reason: collision with root package name */
    private u4 f8302d;

    /* renamed from: e, reason: collision with root package name */
    private ExecutorService f8303e;

    /* renamed from: j, reason: collision with root package name */
    private UploadInfoCallback f8308j;

    /* renamed from: k, reason: collision with root package name */
    private TimerTask f8309k;

    /* renamed from: a, reason: collision with root package name */
    private List<NearbySearch.NearbyListener> f8299a = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private LatLonPoint f8304f = null;

    /* renamed from: g, reason: collision with root package name */
    private String f8305g = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8306h = false;

    /* renamed from: i, reason: collision with root package name */
    private Timer f8307i = new Timer();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = p0.this.f8302d.obtainMessage();
            obtainMessage.arg1 = 8;
            obtainMessage.obj = p0.this.f8299a;
            try {
                try {
                    p0.this.a();
                    obtainMessage.what = 1000;
                    if (p0.this.f8302d == null) {
                        return;
                    }
                } catch (AMapException e6) {
                    obtainMessage.what = e6.getErrorCode();
                    j4.i(e6, "NearbySearch", "clearUserInfoAsyn");
                    if (p0.this.f8302d == null) {
                        return;
                    }
                }
                p0.this.f8302d.sendMessage(obtainMessage);
            } catch (Throwable th) {
                if (p0.this.f8302d != null) {
                    p0.this.f8302d.sendMessage(obtainMessage);
                }
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UploadInfo f8311a;

        b(UploadInfo uploadInfo) {
            this.f8311a = uploadInfo;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Message obtainMessage = p0.this.f8302d.obtainMessage();
                obtainMessage.arg1 = 10;
                obtainMessage.obj = p0.this.f8299a;
                obtainMessage.what = p0.this.c(this.f8311a);
                p0.this.f8302d.sendMessage(obtainMessage);
            } catch (Throwable th) {
                j4.i(th, "NearbySearch", "uploadNearbyInfoAsyn");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NearbySearch.NearbyQuery f8313a;

        c(NearbySearch.NearbyQuery nearbyQuery) {
            this.f8313a = nearbyQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = p0.this.f8302d.obtainMessage();
            obtainMessage.arg1 = 9;
            u4.g gVar = new u4.g();
            gVar.f8530a = p0.this.f8299a;
            obtainMessage.obj = gVar;
            try {
                try {
                    gVar.f8531b = p0.this.searchNearbyInfo(this.f8313a);
                    obtainMessage.what = 1000;
                    if (p0.this.f8302d == null) {
                        return;
                    }
                } catch (AMapException e6) {
                    obtainMessage.what = e6.getErrorCode();
                    j4.i(e6, "NearbySearch", "searchNearbyInfoAsyn");
                    if (p0.this.f8302d == null) {
                        return;
                    }
                }
                p0.this.f8302d.sendMessage(obtainMessage);
            } catch (Throwable th) {
                if (p0.this.f8302d != null) {
                    p0.this.f8302d.sendMessage(obtainMessage);
                }
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class d extends TimerTask {
        private d() {
        }

        /* synthetic */ d(p0 p0Var, byte b6) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            try {
                if (p0.this.f8308j != null) {
                    int h6 = p0.this.h(p0.this.f8308j.OnUploadInfoCallback());
                    Message obtainMessage = p0.this.f8302d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = p0.this.f8299a;
                    obtainMessage.what = h6;
                    p0.this.f8302d.sendMessage(obtainMessage);
                }
            } catch (Throwable th) {
                j4.i(th, "NearbySearch", "UpdateDataTask");
            }
        }
    }

    private static boolean e(NearbySearch.NearbyQuery nearbyQuery) {
        return (nearbyQuery == null || nearbyQuery.getCenterPoint() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void addNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        try {
            this.f8299a.add(nearbyListener);
        } catch (Throwable th) {
            j4.i(th, "NearbySearch", "addNearbyListener");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void destroy() {
        try {
            this.f8307i.cancel();
        } catch (Throwable th) {
            j4.i(th, "NearbySearch", "destryoy");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void removeNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        if (nearbyListener == null) {
            return;
        }
        try {
            this.f8299a.remove(nearbyListener);
        } catch (Throwable th) {
            j4.i(th, "NearbySearch", "removeNearbyListener");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i6) {
        TimerTask timerTask;
        if (i6 < 7000) {
            i6 = 7000;
        }
        try {
            this.f8308j = uploadInfoCallback;
            if (this.f8306h && (timerTask = this.f8309k) != null) {
                timerTask.cancel();
            }
            this.f8306h = true;
            d dVar = new d(this, (byte) 0);
            this.f8309k = dVar;
            this.f8307i.schedule(dVar, 0L, i6);
        } catch (Throwable th) {
            j4.i(th, "NearbySearch", "startUploadNearbyInfoAuto");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void stopUploadNearbyInfoAuto() {
        try {
            TimerTask timerTask = this.f8309k;
            if (timerTask != null) {
                timerTask.cancel();
            }
        } finally {
            this.f8306h = false;
            this.f8309k = null;
        }
        this.f8306h = false;
        this.f8309k = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() throws AMapException {
        try {
            if (this.f8306h) {
                throw new AMapException(AMapException.AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR);
            }
            if (!f(this.f8300b)) {
                throw new AMapException(AMapException.AMAP_CLIENT_USERID_ILLEGAL);
            }
            s4.d(this.f8301c);
            return new v4(this.f8301c, this.f8300b).O().intValue();
        } catch (AMapException e6) {
            throw e6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(UploadInfo uploadInfo) {
        return this.f8306h ? AMapException.CODE_AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR : h(uploadInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(UploadInfo uploadInfo) {
        try {
            s4.d(this.f8301c);
            if (uploadInfo == null) {
                return AMapException.CODE_AMAP_CLIENT_NEARBY_NULL_RESULT;
            }
            long time = new Date().getTime();
            if (time - f8298l < 6500) {
                return AMapException.CODE_AMAP_CLIENT_UPLOAD_TOO_FREQUENT;
            }
            f8298l = time;
            String userID = uploadInfo.getUserID();
            if (!f(userID)) {
                return AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL;
            }
            if (TextUtils.isEmpty(this.f8305g)) {
                this.f8305g = userID;
            }
            if (!userID.equals(this.f8305g)) {
                return AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL;
            }
            LatLonPoint point = uploadInfo.getPoint();
            if (point != null && !point.equals(this.f8304f)) {
                new com.amap.api.col.s.c(this.f8301c, uploadInfo).O();
                this.f8304f = point.copy();
                return 1000;
            }
            return AMapException.CODE_AMAP_CLIENT_UPLOAD_LOCATION_ERROR;
        } catch (AMapException e6) {
            return e6.getErrorCode();
        } catch (Throwable unused) {
            return 1900;
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final NearbySearchResult searchNearbyInfo(NearbySearch.NearbyQuery nearbyQuery) throws AMapException {
        try {
            s4.d(this.f8301c);
            if (e(nearbyQuery)) {
                return new com.amap.api.col.s.b(this.f8301c, nearbyQuery).O();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e6) {
            throw e6;
        } catch (Throwable th) {
            j4.i(th, "NearbySearch", "searchNearbyInfo");
            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void setUserID(String str) {
        this.f8300b = str;
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void uploadNearbyInfoAsyn(UploadInfo uploadInfo) {
        if (this.f8303e == null) {
            this.f8303e = Executors.newSingleThreadExecutor();
        }
        this.f8303e.submit(new b(uploadInfo));
    }

    public p0(Context context) throws AMapException {
        h1 a6 = cf.a(context, i4.a(false));
        if (a6.f8108a == cf.c.SuccessCode) {
            this.f8301c = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f8302d = u4.a();
        } else {
            String str = a6.f8109b;
            throw new AMapException(str, 1, str, a6.f8108a.a());
        }
    }

    private static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^[a-z0-9A-Z_-]{1,32}$").matcher(str).find();
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void clearUserInfoAsyn() {
        try {
            y.a().b(new a());
        } catch (Throwable th) {
            j4.i(th, "NearbySearch", "clearUserInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void searchNearbyInfoAsyn(NearbySearch.NearbyQuery nearbyQuery) {
        try {
            y.a().b(new c(nearbyQuery));
        } catch (Throwable th) {
            j4.i(th, "NearbySearch", "searchNearbyInfoAsynThrowable");
        }
    }
}
