package com.amap.api.services.routepoisearch;

import com.amap.api.col.s.j4;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RoutePOISearchQuery implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f9836a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f9837b;

    /* renamed from: c, reason: collision with root package name */
    private int f9838c;

    /* renamed from: d, reason: collision with root package name */
    private RoutePOISearch.RoutePOISearchType f9839d;

    /* renamed from: e, reason: collision with root package name */
    private int f9840e;

    /* renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f9841f;

    /* renamed from: g, reason: collision with root package name */
    private String f9842g;

    public RoutePOISearchQuery(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i6, RoutePOISearch.RoutePOISearchType routePOISearchType, int i7) {
        this.f9836a = latLonPoint;
        this.f9837b = latLonPoint2;
        this.f9838c = i6;
        this.f9839d = routePOISearchType;
        this.f9840e = i7;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RoutePOISearchQuery m83clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e6) {
            j4.i(e6, "RoutePOISearchQuery", "RoutePOISearchQueryclone");
        }
        List<LatLonPoint> list = this.f9841f;
        if (list == null || list.size() <= 0) {
            RoutePOISearchQuery routePOISearchQuery = new RoutePOISearchQuery(this.f9836a, this.f9837b, this.f9838c, this.f9839d, this.f9840e);
            routePOISearchQuery.setChannel(this.f9842g);
            return routePOISearchQuery;
        }
        RoutePOISearchQuery routePOISearchQuery2 = new RoutePOISearchQuery(this.f9841f, this.f9839d, this.f9840e);
        routePOISearchQuery2.setChannel(this.f9842g);
        return routePOISearchQuery2;
    }

    public String getChannel() {
        return this.f9842g;
    }

    public LatLonPoint getFrom() {
        return this.f9836a;
    }

    public int getMode() {
        return this.f9838c;
    }

    public List<LatLonPoint> getPolylines() {
        return this.f9841f;
    }

    public int getRange() {
        return this.f9840e;
    }

    public RoutePOISearch.RoutePOISearchType getSearchType() {
        return this.f9839d;
    }

    public LatLonPoint getTo() {
        return this.f9837b;
    }

    public void setChannel(String str) {
        this.f9842g = str;
    }

    public RoutePOISearchQuery(List<LatLonPoint> list, RoutePOISearch.RoutePOISearchType routePOISearchType, int i6) {
        this.f9841f = list;
        this.f9839d = routePOISearchType;
        this.f9840e = i6;
    }
}
