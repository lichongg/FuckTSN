package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class k0 implements ICloudSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f8188a;

    /* renamed from: b, reason: collision with root package name */
    private CloudSearch.OnCloudSearchListener f8189b;

    /* renamed from: c, reason: collision with root package name */
    private CloudSearch.Query f8190c;

    /* renamed from: d, reason: collision with root package name */
    private int f8191d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<Integer, CloudResult> f8192e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f8193f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CloudSearch.Query f8194a;

        a(CloudSearch.Query query) {
            this.f8194a = query;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 12;
                    obtainMessage.what = 700;
                    u4.e eVar = new u4.e();
                    eVar.f8527b = k0.this.f8189b;
                    obtainMessage.obj = eVar;
                    eVar.f8526a = k0.this.e(this.f8194a);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e6) {
                    obtainMessage.arg2 = e6.getErrorCode();
                }
            } finally {
                k0.this.f8193f.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8196a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f8197b;

        b(String str, String str2) {
            this.f8196a = str;
            this.f8197b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 12;
                    obtainMessage.what = 701;
                    u4.d dVar = new u4.d();
                    dVar.f8525b = k0.this.f8189b;
                    obtainMessage.obj = dVar;
                    dVar.f8524a = k0.this.b(this.f8196a, this.f8197b);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e6) {
                    obtainMessage.arg2 = e6.getErrorCode();
                }
            } finally {
                k0.this.f8193f.sendMessage(obtainMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public CloudResult e(CloudSearch.Query query) throws AMapException {
        CloudResult cloudResult = null;
        try {
            if (!j(query)) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!query.queryEquals(this.f8190c)) {
                this.f8191d = 0;
                this.f8190c = query.m63clone();
                HashMap<Integer, CloudResult> hashMap = this.f8192e;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            ?? r12 = this.f8191d;
            try {
                if (r12 == 0) {
                    CloudResult O = new h4(this.f8188a, query).O();
                    g(O, query);
                    return O;
                }
                CloudResult c6 = c(query.getPageNum());
                if (c6 != null) {
                    return c6;
                }
                CloudResult O2 = new h4(this.f8188a, query).O();
                this.f8192e.put(Integer.valueOf(query.getPageNum()), O2);
                return O2;
            } catch (Throwable th) {
                th = th;
                cloudResult = r12;
                j4.i(th, "CloudSearch", "searchCloud");
                if (th instanceof AMapException) {
                    throw th;
                }
                th.printStackTrace();
                return cloudResult;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean j(CloudSearch.Query query) {
        if (query == null || j4.j(query.getTableID()) || query.getBound() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Bound") && query.getBound().getCenter() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Rectangle")) {
            LatLonPoint lowerLeft = query.getBound().getLowerLeft();
            LatLonPoint upperRight = query.getBound().getUpperRight();
            if (lowerLeft == null || upperRight == null || lowerLeft.getLatitude() >= upperRight.getLatitude() || lowerLeft.getLongitude() >= upperRight.getLongitude()) {
                return false;
            }
        }
        if (query.getBound() == null || !query.getBound().getShape().equals("Polygon")) {
            return true;
        }
        List<LatLonPoint> polyGonList = query.getBound().getPolyGonList();
        for (int i6 = 0; i6 < polyGonList.size(); i6++) {
            if (polyGonList.get(i6) == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CloudItemDetail b(String str, String str2) throws AMapException {
        if (str == null || str.trim().equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        if (str2 == null || str2.trim().equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        try {
            return new g4(this.f8188a, new j(str, str2)).O();
        } catch (Throwable th) {
            j4.i(th, "CloudSearch", "searchCloudDetail");
            if (th instanceof AMapException) {
                throw th;
            }
            th.printStackTrace();
            return null;
        }
    }

    private void g(CloudResult cloudResult, CloudSearch.Query query) {
        HashMap<Integer, CloudResult> hashMap = new HashMap<>();
        this.f8192e = hashMap;
        if (this.f8191d > 0) {
            hashMap.put(Integer.valueOf(query.getPageNum()), cloudResult);
        }
    }

    private boolean i(int i6) {
        return i6 <= this.f8191d && i6 > 0;
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener onCloudSearchListener) {
        this.f8189b = onCloudSearchListener;
    }

    public k0(Context context) throws AMapException {
        h1 a6 = cf.a(context, i4.a(false));
        if (a6.f8108a == cf.c.SuccessCode) {
            this.f8188a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f8193f = u4.a();
        } else {
            String str = a6.f8109b;
            throw new AMapException(str, 1, str, a6.f8108a.a());
        }
    }

    private CloudResult c(int i6) {
        if (i(i6)) {
            return this.f8192e.get(Integer.valueOf(i6));
        }
        throw new IllegalArgumentException("page out of range");
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void searchCloudAsyn(CloudSearch.Query query) {
        try {
            y.a().b(new a(query));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void searchCloudDetailAsyn(String str, String str2) {
        try {
            y.a().b(new b(str, str2));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
