package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class BusStationResult {

    /* renamed from: a, reason: collision with root package name */
    private int f9151a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<BusStationItem> f9152b;

    /* renamed from: c, reason: collision with root package name */
    private BusStationQuery f9153c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f9154d;

    /* renamed from: e, reason: collision with root package name */
    private List<SuggestionCity> f9155e;

    private int a(int i6) {
        int pageSize = ((i6 + r0) - 1) / this.f9153c.getPageSize();
        if (pageSize > 30) {
            return 30;
        }
        return pageSize;
    }

    public static BusStationResult createPagedResult(BusStationQuery busStationQuery, int i6, List<SuggestionCity> list, List<String> list2, ArrayList<BusStationItem> arrayList) {
        return new BusStationResult(busStationQuery, i6, list, list2, arrayList);
    }

    public final List<BusStationItem> getBusStations() {
        return this.f9152b;
    }

    public final int getPageCount() {
        return this.f9151a;
    }

    public final BusStationQuery getQuery() {
        return this.f9153c;
    }

    public final List<SuggestionCity> getSearchSuggestionCities() {
        return this.f9155e;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.f9154d;
    }

    private BusStationResult(BusStationQuery busStationQuery, int i6, List<SuggestionCity> list, List<String> list2, ArrayList<BusStationItem> arrayList) {
        this.f9152b = new ArrayList<>();
        this.f9154d = new ArrayList();
        this.f9155e = new ArrayList();
        this.f9153c = busStationQuery;
        this.f9151a = a(i6);
        this.f9155e = list;
        this.f9154d = list2;
        this.f9152b = arrayList;
    }
}
