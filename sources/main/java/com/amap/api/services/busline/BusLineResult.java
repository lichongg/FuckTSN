package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class BusLineResult {

    /* renamed from: a, reason: collision with root package name */
    private int f9135a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<BusLineItem> f9136b;

    /* renamed from: c, reason: collision with root package name */
    private BusLineQuery f9137c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f9138d;

    /* renamed from: e, reason: collision with root package name */
    private List<SuggestionCity> f9139e;

    private int a(int i6) {
        int pageSize = ((i6 + r0) - 1) / this.f9137c.getPageSize();
        if (pageSize > 30) {
            return 30;
        }
        return pageSize;
    }

    public static BusLineResult createPagedResult(BusLineQuery busLineQuery, int i6, List<SuggestionCity> list, List<String> list2, ArrayList<BusLineItem> arrayList) {
        return new BusLineResult(busLineQuery, i6, list, list2, arrayList);
    }

    public final List<BusLineItem> getBusLines() {
        return this.f9136b;
    }

    public final int getPageCount() {
        return this.f9135a;
    }

    public final BusLineQuery getQuery() {
        return this.f9137c;
    }

    public final List<SuggestionCity> getSearchSuggestionCities() {
        return this.f9139e;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.f9138d;
    }

    private BusLineResult(BusLineQuery busLineQuery, int i6, List<SuggestionCity> list, List<String> list2, ArrayList<BusLineItem> arrayList) {
        this.f9136b = new ArrayList<>();
        this.f9138d = new ArrayList();
        this.f9139e = new ArrayList();
        this.f9137c = busLineQuery;
        this.f9135a = a(i6);
        this.f9139e = list;
        this.f9138d = list2;
        this.f9136b = arrayList;
    }
}
