package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class q0 implements IPoiSearch {

    /* renamed from: j, reason: collision with root package name */
    private static HashMap<Integer, PoiResult> f8346j;

    /* renamed from: a, reason: collision with root package name */
    private PoiSearch.SearchBound f8347a;

    /* renamed from: b, reason: collision with root package name */
    private PoiSearch.Query f8348b;

    /* renamed from: c, reason: collision with root package name */
    private Context f8349c;

    /* renamed from: d, reason: collision with root package name */
    private PoiSearch.OnPoiSearchListener f8350d;

    /* renamed from: e, reason: collision with root package name */
    private String f8351e = "zh-CN";

    /* renamed from: f, reason: collision with root package name */
    private PoiSearch.Query f8352f;

    /* renamed from: g, reason: collision with root package name */
    private PoiSearch.SearchBound f8353g;

    /* renamed from: h, reason: collision with root package name */
    private int f8354h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f8355i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            u4.j jVar;
            Message obtainMessage = q0.this.f8355i.obtainMessage();
            obtainMessage.arg1 = 6;
            obtainMessage.what = 600;
            Bundle bundle = new Bundle();
            PoiResult poiResult = null;
            try {
                try {
                    poiResult = q0.this.searchPOI();
                    bundle.putInt("errorCode", 1000);
                    jVar = new u4.j();
                } catch (AMapException e6) {
                    bundle.putInt("errorCode", e6.getErrorCode());
                    jVar = new u4.j();
                }
                jVar.f8537b = q0.this.f8350d;
                jVar.f8536a = poiResult;
                obtainMessage.obj = jVar;
                obtainMessage.setData(bundle);
                q0.this.f8355i.sendMessage(obtainMessage);
            } catch (Throwable th) {
                u4.j jVar2 = new u4.j();
                jVar2.f8537b = q0.this.f8350d;
                jVar2.f8536a = poiResult;
                obtainMessage.obj = jVar2;
                obtainMessage.setData(bundle);
                q0.this.f8355i.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8357a;

        b(String str) {
            this.f8357a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u4.h hVar;
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.arg1 = 6;
            obtainMessage.what = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN;
            Bundle bundle = new Bundle();
            PoiItem poiItem = null;
            try {
                try {
                    poiItem = q0.this.searchPOIId(this.f8357a);
                    bundle.putInt("errorCode", 1000);
                    hVar = new u4.h();
                } catch (AMapException e6) {
                    j4.i(e6, "PoiSearch", "searchPOIIdAsyn");
                    bundle.putInt("errorCode", e6.getErrorCode());
                    hVar = new u4.h();
                }
                hVar.f8533b = q0.this.f8350d;
                hVar.f8532a = poiItem;
                obtainMessage.obj = hVar;
                obtainMessage.setData(bundle);
                q0.this.f8355i.sendMessage(obtainMessage);
            } catch (Throwable th) {
                u4.h hVar2 = new u4.h();
                hVar2.f8533b = q0.this.f8350d;
                hVar2.f8532a = poiItem;
                obtainMessage.obj = hVar2;
                obtainMessage.setData(bundle);
                q0.this.f8355i.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    private void c(PoiResult poiResult) {
        int i6;
        f8346j = new HashMap<>();
        PoiSearch.Query query = this.f8348b;
        if (query == null || poiResult == null || (i6 = this.f8354h) <= 0 || i6 <= query.getPageNum()) {
            return;
        }
        f8346j.put(Integer.valueOf(this.f8348b.getPageNum()), poiResult);
    }

    private boolean d() {
        PoiSearch.Query query = this.f8348b;
        if (query == null) {
            return false;
        }
        return (j4.j(query.getQueryString()) && j4.j(this.f8348b.getCategory())) ? false : true;
    }

    private boolean g(int i6) {
        return i6 <= this.f8354h && i6 >= 0;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiSearch.SearchBound getBound() {
        return this.f8347a;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final String getLanguage() {
        return this.f8351e;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiSearch.Query getQuery() {
        return this.f8348b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiResult searchPOI() throws AMapException {
        try {
            s4.d(this.f8349c);
            if (!f() && !d()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!h()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            PoiSearch.Query query = this.f8348b;
            if (query == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if ((!query.queryEquals(this.f8352f) && this.f8347a == null) || (!this.f8348b.queryEquals(this.f8352f) && !this.f8347a.equals(this.f8353g))) {
                this.f8354h = 0;
                this.f8352f = this.f8348b.m66clone();
                PoiSearch.SearchBound searchBound = this.f8347a;
                if (searchBound != null) {
                    this.f8353g = searchBound.m67clone();
                }
                HashMap<Integer, PoiResult> hashMap = f8346j;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            PoiSearch.SearchBound searchBound2 = this.f8347a;
            PoiSearch.SearchBound m67clone = searchBound2 != null ? searchBound2.m67clone() : null;
            q.a().f(this.f8348b.getQueryString());
            this.f8348b.setPageNum(q.a().B(this.f8348b.getPageNum()));
            this.f8348b.setPageSize(q.a().C(this.f8348b.getPageSize()));
            if (this.f8354h == 0) {
                PoiResult O = new g(this.f8349c, new k(this.f8348b.m66clone(), m67clone)).O();
                c(O);
                return O;
            }
            PoiResult b6 = b(this.f8348b.getPageNum());
            if (b6 != null) {
                return b6;
            }
            PoiResult O2 = new g(this.f8349c, new k(this.f8348b.m66clone(), m67clone)).O();
            f8346j.put(Integer.valueOf(this.f8348b.getPageNum()), O2);
            return O2;
        } catch (AMapException e6) {
            j4.i(e6, "PoiSearch", "searchPOI");
            throw new AMapException(e6.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiItem searchPOIId(String str) throws AMapException {
        s4.d(this.f8349c);
        PoiSearch.Query query = this.f8348b;
        return new e(this.f8349c, str, query != null ? query.m66clone() : null).O();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setBound(PoiSearch.SearchBound searchBound) {
        this.f8347a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setLanguage(String str) {
        if ("en".equals(str)) {
            this.f8351e = "en";
        } else {
            this.f8351e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setOnPoiSearchListener(PoiSearch.OnPoiSearchListener onPoiSearchListener) {
        this.f8350d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setQuery(PoiSearch.Query query) {
        this.f8348b = query;
    }

    public q0(Context context, PoiSearch.Query query) throws AMapException {
        this.f8355i = null;
        h1 a6 = cf.a(context, i4.a(false));
        if (a6.f8108a == cf.c.SuccessCode) {
            this.f8349c = StubApp.getOrigApplicationContext(context.getApplicationContext());
            setQuery(query);
            this.f8355i = u4.a();
            return;
        }
        String str = a6.f8109b;
        throw new AMapException(str, 1, str, a6.f8108a.a());
    }

    private PoiResult b(int i6) {
        if (g(i6)) {
            return f8346j.get(Integer.valueOf(i6));
        }
        throw new IllegalArgumentException("page out of range");
    }

    private boolean f() {
        PoiSearch.SearchBound bound = getBound();
        if (bound == null || !bound.getShape().equals("Bound")) {
            return false;
        }
        return true;
    }

    private boolean h() {
        PoiSearch.SearchBound bound = getBound();
        if (bound != null) {
            if (bound.getShape().equals("Bound")) {
                if (bound.getCenter() == null) {
                    return false;
                }
                return true;
            }
            if (bound.getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = bound.getPolyGonList();
                if (polyGonList == null || polyGonList.size() == 0) {
                    return false;
                }
                for (int i6 = 0; i6 < polyGonList.size(); i6++) {
                    if (polyGonList.get(i6) == null) {
                        return false;
                    }
                }
                return true;
            }
            if (bound.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = bound.getLowerLeft();
                LatLonPoint upperRight = bound.getUpperRight();
                if (lowerLeft == null || upperRight == null || lowerLeft.getLatitude() >= upperRight.getLatitude() || lowerLeft.getLongitude() >= upperRight.getLongitude()) {
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIAsyn() {
        try {
            y.a().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIIdAsyn(String str) {
        y.a().b(new b(str));
    }
}
