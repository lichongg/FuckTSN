package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.interfaces.IPoiSearchV2;
import com.amap.api.services.poisearch.PoiResultV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class r0 implements IPoiSearchV2 {

    /* renamed from: j, reason: collision with root package name */
    private static HashMap<Integer, PoiResultV2> f8365j;

    /* renamed from: a, reason: collision with root package name */
    private PoiSearchV2.SearchBound f8366a;

    /* renamed from: b, reason: collision with root package name */
    private PoiSearchV2.Query f8367b;

    /* renamed from: c, reason: collision with root package name */
    private Context f8368c;

    /* renamed from: d, reason: collision with root package name */
    private PoiSearchV2.OnPoiSearchListener f8369d;

    /* renamed from: e, reason: collision with root package name */
    private String f8370e = "zh-CN";

    /* renamed from: f, reason: collision with root package name */
    private PoiSearchV2.Query f8371f;

    /* renamed from: g, reason: collision with root package name */
    private PoiSearchV2.SearchBound f8372g;

    /* renamed from: h, reason: collision with root package name */
    private int f8373h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f8374i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            u4.k kVar;
            Message obtainMessage = r0.this.f8374i.obtainMessage();
            obtainMessage.arg1 = 19;
            obtainMessage.what = MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_BUFLEN;
            Bundle bundle = new Bundle();
            PoiResultV2 poiResultV2 = null;
            try {
                try {
                    poiResultV2 = r0.this.searchPOI();
                    bundle.putInt("errorCode", 1000);
                    kVar = new u4.k();
                } catch (AMapException e6) {
                    bundle.putInt("errorCode", e6.getErrorCode());
                    kVar = new u4.k();
                }
                kVar.f8539b = r0.this.f8369d;
                kVar.f8538a = poiResultV2;
                obtainMessage.obj = kVar;
                obtainMessage.setData(bundle);
                r0.this.f8374i.sendMessage(obtainMessage);
            } catch (Throwable th) {
                u4.k kVar2 = new u4.k();
                kVar2.f8539b = r0.this.f8369d;
                kVar2.f8538a = poiResultV2;
                obtainMessage.obj = kVar2;
                obtainMessage.setData(bundle);
                r0.this.f8374i.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8376a;

        b(String str) {
            this.f8376a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u4.i iVar;
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.arg1 = 19;
            obtainMessage.what = MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_VIDEO_BUFLEN;
            Bundle bundle = new Bundle();
            PoiItemV2 poiItemV2 = null;
            try {
                try {
                    poiItemV2 = r0.this.searchPOIId(this.f8376a);
                    bundle.putInt("errorCode", 1000);
                    iVar = new u4.i();
                } catch (AMapException e6) {
                    j4.i(e6, "PoiSearch", "searchPOIIdAsyn");
                    bundle.putInt("errorCode", e6.getErrorCode());
                    iVar = new u4.i();
                }
                iVar.f8535b = r0.this.f8369d;
                iVar.f8534a = poiItemV2;
                obtainMessage.obj = iVar;
                obtainMessage.setData(bundle);
                r0.this.f8374i.sendMessage(obtainMessage);
            } catch (Throwable th) {
                u4.i iVar2 = new u4.i();
                iVar2.f8535b = r0.this.f8369d;
                iVar2.f8534a = poiItemV2;
                obtainMessage.obj = iVar2;
                obtainMessage.setData(bundle);
                r0.this.f8374i.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    private void c(PoiResultV2 poiResultV2) {
        int i6;
        f8365j = new HashMap<>();
        PoiSearchV2.Query query = this.f8367b;
        if (query == null || poiResultV2 == null || (i6 = this.f8373h) <= 0 || i6 <= query.getPageNum()) {
            return;
        }
        f8365j.put(Integer.valueOf(this.f8367b.getPageNum()), poiResultV2);
    }

    private boolean d() {
        PoiSearchV2.Query query = this.f8367b;
        if (query == null) {
            return false;
        }
        return (j4.j(query.getQueryString()) && j4.j(this.f8367b.getCategory())) ? false : true;
    }

    private boolean g(int i6) {
        return i6 <= this.f8373h && i6 >= 0;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiSearchV2.SearchBound getBound() {
        return this.f8366a;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final String getLanguage() {
        return this.f8370e;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiSearchV2.Query getQuery() {
        return this.f8367b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiResultV2 searchPOI() throws AMapException {
        try {
            s4.d(this.f8368c);
            if (!f() && !d()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!h()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            PoiSearchV2.Query query = this.f8367b;
            if (query == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if ((!query.queryEquals(this.f8371f) && this.f8366a == null) || (!this.f8367b.queryEquals(this.f8371f) && !this.f8366a.equals(this.f8372g))) {
                this.f8373h = 0;
                this.f8371f = this.f8367b.m68clone();
                PoiSearchV2.SearchBound searchBound = this.f8366a;
                if (searchBound != null) {
                    this.f8372g = searchBound.m69clone();
                }
                HashMap<Integer, PoiResultV2> hashMap = f8365j;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            PoiSearchV2.SearchBound searchBound2 = this.f8366a;
            PoiSearchV2.SearchBound m69clone = searchBound2 != null ? searchBound2.m69clone() : null;
            q.a().f(this.f8367b.getQueryString());
            this.f8367b.setPageNum(q.a().B(this.f8367b.getPageNum()));
            this.f8367b.setPageSize(q.a().C(this.f8367b.getPageSize()));
            if (this.f8373h == 0) {
                PoiResultV2 O = new h(this.f8368c, new l(this.f8367b.m68clone(), m69clone)).O();
                c(O);
                return O;
            }
            PoiResultV2 b6 = b(this.f8367b.getPageNum());
            if (b6 != null) {
                return b6;
            }
            PoiResultV2 O2 = new h(this.f8368c, new l(this.f8367b.m68clone(), m69clone)).O();
            f8365j.put(Integer.valueOf(this.f8367b.getPageNum()), O2);
            return O2;
        } catch (AMapException e6) {
            j4.i(e6, "PoiSearch", "searchPOI");
            throw new AMapException(e6.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiItemV2 searchPOIId(String str) throws AMapException {
        s4.d(this.f8368c);
        PoiSearchV2.Query query = this.f8367b;
        return new f(this.f8368c, str, query != null ? query.m68clone() : null).O();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setBound(PoiSearchV2.SearchBound searchBound) {
        this.f8366a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setLanguage(String str) {
        if ("en".equals(str)) {
            this.f8370e = "en";
        } else {
            this.f8370e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setOnPoiSearchListener(PoiSearchV2.OnPoiSearchListener onPoiSearchListener) {
        this.f8369d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setQuery(PoiSearchV2.Query query) {
        this.f8367b = query;
    }

    public r0(Context context, PoiSearchV2.Query query) throws AMapException {
        this.f8374i = null;
        h1 a6 = cf.a(context, i4.a(false));
        if (a6.f8108a == cf.c.SuccessCode) {
            this.f8368c = StubApp.getOrigApplicationContext(context.getApplicationContext());
            setQuery(query);
            this.f8374i = u4.a();
            return;
        }
        String str = a6.f8109b;
        throw new AMapException(str, 1, str, a6.f8108a.a());
    }

    private PoiResultV2 b(int i6) {
        if (g(i6)) {
            return f8365j.get(Integer.valueOf(i6));
        }
        throw new IllegalArgumentException("page out of range");
    }

    private boolean f() {
        PoiSearchV2.SearchBound bound = getBound();
        if (bound == null || !bound.getShape().equals("Bound")) {
            return false;
        }
        return true;
    }

    private boolean h() {
        PoiSearchV2.SearchBound bound = getBound();
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

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void searchPOIAsyn() {
        try {
            y.a().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void searchPOIIdAsyn(String str) {
        y.a().b(new b(str));
    }
}
