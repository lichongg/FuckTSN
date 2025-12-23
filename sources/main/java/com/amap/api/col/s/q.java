package com.amap.api.col.s;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchV2;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class q {

    /* renamed from: r, reason: collision with root package name */
    private static volatile q f8328r;

    /* renamed from: a, reason: collision with root package name */
    boolean f8329a = true;

    /* renamed from: b, reason: collision with root package name */
    boolean f8330b = true;

    /* renamed from: c, reason: collision with root package name */
    boolean f8331c = true;

    /* renamed from: d, reason: collision with root package name */
    boolean f8332d = true;

    /* renamed from: e, reason: collision with root package name */
    boolean f8333e = true;

    /* renamed from: f, reason: collision with root package name */
    boolean f8334f = true;

    /* renamed from: g, reason: collision with root package name */
    boolean f8335g = true;

    /* renamed from: h, reason: collision with root package name */
    int f8336h = 25;

    /* renamed from: i, reason: collision with root package name */
    int f8337i = 100;

    /* renamed from: j, reason: collision with root package name */
    int f8338j = 100;

    /* renamed from: k, reason: collision with root package name */
    int f8339k = 100;

    /* renamed from: l, reason: collision with root package name */
    int f8340l = 6;

    /* renamed from: m, reason: collision with root package name */
    int f8341m = 100;

    /* renamed from: n, reason: collision with root package name */
    int f8342n = 5000;

    /* renamed from: o, reason: collision with root package name */
    int f8343o = AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS;

    /* renamed from: p, reason: collision with root package name */
    int f8344p = 100000000;

    /* renamed from: q, reason: collision with root package name */
    int f8345q = 16;

    public static q a() {
        if (f8328r == null) {
            synchronized (q.class) {
                try {
                    if (f8328r == null) {
                        f8328r = new q();
                    }
                } finally {
                }
            }
        }
        return f8328r;
    }

    public static void l(List<LatLonPoint> list) throws AMapException {
        if (list != null && 16 < list.size()) {
            throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION);
        }
    }

    public final void A(int i6) {
        this.f8345q = i6;
    }

    public final int B(int i6) {
        int i7;
        return (this.f8332d && (i7 = this.f8341m) < i6) ? i7 : i6;
    }

    public final int C(int i6) {
        int i7;
        return (this.f8332d && (i7 = this.f8336h) < i6) ? i7 : i6;
    }

    public final void b(int i6) {
        this.f8336h = i6;
    }

    public final void c(RouteSearch.FromAndTo fromAndTo) throws AMapException {
        if (!this.f8333e || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (this.f8343o < j4.b(fromAndTo.getFrom(), fromAndTo.getTo()) / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public final void d(RouteSearch.FromAndTo fromAndTo, List<LatLonPoint> list) throws AMapException {
        double b6;
        if (!this.f8331c || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (list == null || list.size() == 0) {
            b6 = j4.b(fromAndTo.getFrom(), fromAndTo.getTo());
        } else {
            LatLonPoint from = fromAndTo.getFrom();
            LatLonPoint to = fromAndTo.getTo();
            Iterator<LatLonPoint> it = list.iterator();
            double d6 = 0.0d;
            while (it.hasNext()) {
                d6 += j4.b(from, r3);
                from = it.next();
            }
            b6 = d6 + j4.b(from, to);
        }
        if (this.f8342n < b6 / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public final void e(RouteSearchV2.FromAndTo fromAndTo) throws AMapException {
        if (!this.f8333e || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (this.f8343o < j4.b(fromAndTo.getFrom(), fromAndTo.getTo()) / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public final void f(String str) throws AMapException {
        if (str != null && this.f8330b && str.length() > this.f8337i) {
            throw new AMapException(AMapException.AMAP_CLIENT_OVER_KEYWORD_LEN_MAX_COUNT_EXCEPTION);
        }
    }

    public final void g(List<LatLonPoint> list) throws AMapException {
        if (this.f8335g && list != null) {
            if (this.f8340l < list.size()) {
                throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION);
            }
        }
    }

    public final void h(boolean z5) {
        this.f8329a = z5;
    }

    public final void i(int i6) {
        this.f8337i = i6;
    }

    public final void j(RouteSearch.FromAndTo fromAndTo) throws AMapException {
        if (!this.f8334f || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (this.f8339k < j4.b(fromAndTo.getFrom(), fromAndTo.getTo()) / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public final void k(RouteSearchV2.FromAndTo fromAndTo) throws AMapException {
        if (!this.f8334f || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (this.f8339k < j4.b(fromAndTo.getFrom(), fromAndTo.getTo()) / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public final void m(boolean z5) {
        this.f8331c = z5;
    }

    public final void n(int i6) {
        this.f8338j = i6;
    }

    public final void o(List<List<LatLonPoint>> list) throws AMapException {
        if (this.f8329a && list != null) {
            if (this.f8338j < list.size()) {
                throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION);
            }
            for (List<LatLonPoint> list2 : list) {
                double k6 = j4.k(list2);
                if (this.f8345q < list2.size()) {
                    throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION);
                }
                if (this.f8344p < k6) {
                    throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION);
                }
            }
        }
    }

    public final void p(boolean z5) {
        this.f8332d = z5;
    }

    public final void q(int i6) {
        this.f8339k = i6;
    }

    public final void r(boolean z5) {
        this.f8333e = z5;
    }

    public final void s(int i6) {
        this.f8340l = i6;
    }

    public final void t(boolean z5) {
        this.f8334f = z5;
    }

    public final void u(int i6) {
        this.f8341m = i6;
    }

    public final void v(boolean z5) {
        this.f8335g = z5;
    }

    public final void w(int i6) {
        this.f8342n = i6;
    }

    public final void x(boolean z5) {
        this.f8330b = z5;
    }

    public final void y(int i6) {
        this.f8343o = i6;
    }

    public final void z(int i6) {
        this.f8344p = i6;
    }
}
