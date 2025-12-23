package com.amap.api.services.routepoisearch;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RoutePOISearchResult {

    /* renamed from: a, reason: collision with root package name */
    private List<RoutePOIItem> f9843a;

    /* renamed from: b, reason: collision with root package name */
    private RoutePOISearchQuery f9844b;

    public RoutePOISearchQuery getQuery() {
        return this.f9844b;
    }

    public List<RoutePOIItem> getRoutePois() {
        return this.f9843a;
    }

    public RoutePOISearchResult(ArrayList<RoutePOIItem> arrayList, RoutePOISearchQuery routePOISearchQuery) {
        new ArrayList();
        this.f9843a = arrayList;
        this.f9844b = routePOISearchQuery;
    }
}
