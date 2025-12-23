package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.interfaces.IDistrictSearch;
import com.stub.StubApp;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class m0 implements IDistrictSearch {

    /* renamed from: g, reason: collision with root package name */
    private static HashMap<Integer, DistrictResult> f8234g;

    /* renamed from: a, reason: collision with root package name */
    private Context f8235a;

    /* renamed from: b, reason: collision with root package name */
    private DistrictSearchQuery f8236b;

    /* renamed from: c, reason: collision with root package name */
    private DistrictSearch.OnDistrictSearchListener f8237c;

    /* renamed from: d, reason: collision with root package name */
    private DistrictSearchQuery f8238d;

    /* renamed from: e, reason: collision with root package name */
    private int f8239e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f8240f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            DistrictResult districtResult = new DistrictResult();
            districtResult.setQuery(m0.this.f8236b);
            try {
                try {
                    try {
                        districtResult = m0.this.searchDistrict();
                        if (districtResult != null) {
                            districtResult.setAMapException(new AMapException());
                        }
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = m0.this.f8237c;
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("result", districtResult);
                        obtainMessage.setData(bundle);
                        if (m0.this.f8240f != null) {
                            m0.this.f8240f.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        j4.i(th, "DistrictSearch", "searchDistrictAnsyThrowable");
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = m0.this.f8237c;
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelable("result", districtResult);
                        obtainMessage.setData(bundle2);
                        if (m0.this.f8240f == null) {
                            return;
                        }
                        m0.this.f8240f.sendMessage(obtainMessage);
                    }
                } catch (AMapException e6) {
                    districtResult.setAMapException(e6);
                    obtainMessage.arg1 = 4;
                    obtainMessage.obj = m0.this.f8237c;
                    Bundle bundle3 = new Bundle();
                    bundle3.putParcelable("result", districtResult);
                    obtainMessage.setData(bundle3);
                    if (m0.this.f8240f == null) {
                        return;
                    }
                    m0.this.f8240f.sendMessage(obtainMessage);
                }
            } catch (Throwable th2) {
                obtainMessage.arg1 = 4;
                obtainMessage.obj = m0.this.f8237c;
                Bundle bundle4 = new Bundle();
                bundle4.putParcelable("result", districtResult);
                obtainMessage.setData(bundle4);
                if (m0.this.f8240f != null) {
                    m0.this.f8240f.sendMessage(obtainMessage);
                }
                throw th2;
            }
        }
    }

    private void c(DistrictResult districtResult) {
        int i6;
        f8234g = new HashMap<>();
        DistrictSearchQuery districtSearchQuery = this.f8236b;
        if (districtSearchQuery == null || districtResult == null || (i6 = this.f8239e) <= 0 || i6 <= districtSearchQuery.getPageNum()) {
            return;
        }
        f8234g.put(Integer.valueOf(this.f8236b.getPageNum()), districtResult);
    }

    private boolean d() {
        return this.f8236b != null;
    }

    private boolean f(int i6) {
        return i6 < this.f8239e && i6 >= 0;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final DistrictSearchQuery getQuery() {
        return this.f8236b;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final DistrictResult searchDistrict() throws AMapException {
        int i6;
        try {
            DistrictResult districtResult = new DistrictResult();
            s4.d(this.f8235a);
            if (!d()) {
                this.f8236b = new DistrictSearchQuery();
            }
            districtResult.setQuery(this.f8236b.m65clone());
            if (!this.f8236b.weakEquals(this.f8238d)) {
                this.f8239e = 0;
                this.f8238d = this.f8236b.m65clone();
                HashMap<Integer, DistrictResult> hashMap = f8234g;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            if (this.f8239e == 0) {
                DistrictResult O = new l4(this.f8235a, this.f8236b.m65clone()).O();
                if (O == null) {
                    return O;
                }
                this.f8239e = O.getPageCount();
                c(O);
                return O;
            }
            DistrictResult a6 = a(this.f8236b.getPageNum());
            if (a6 == null) {
                a6 = new l4(this.f8235a, this.f8236b.m65clone()).O();
                DistrictSearchQuery districtSearchQuery = this.f8236b;
                if (districtSearchQuery != null && a6 != null && (i6 = this.f8239e) > 0 && i6 > districtSearchQuery.getPageNum()) {
                    f8234g.put(Integer.valueOf(this.f8236b.getPageNum()), a6);
                }
            }
            return a6;
        } catch (AMapException e6) {
            j4.i(e6, "DistrictSearch", "searchDistrict");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setOnDistrictSearchListener(DistrictSearch.OnDistrictSearchListener onDistrictSearchListener) {
        this.f8237c = onDistrictSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f8236b = districtSearchQuery;
    }

    public m0(Context context) throws AMapException {
        h1 a6 = cf.a(context, i4.a(false));
        if (a6.f8108a == cf.c.SuccessCode) {
            this.f8235a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f8240f = u4.a();
        } else {
            String str = a6.f8109b;
            throw new AMapException(str, 1, str, a6.f8108a.a());
        }
    }

    private DistrictResult a(int i6) throws AMapException {
        if (f(i6)) {
            return f8234g.get(Integer.valueOf(i6));
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAnsy() {
        searchDistrictAsyn();
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAsyn() {
        try {
            y.a().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
