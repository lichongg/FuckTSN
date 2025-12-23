package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class PoiResult {

    /* renamed from: a, reason: collision with root package name */
    private int f9390a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<PoiItem> f9391b;

    /* renamed from: c, reason: collision with root package name */
    private PoiSearch.Query f9392c;

    /* renamed from: d, reason: collision with root package name */
    private PoiSearch.SearchBound f9393d;

    /* renamed from: e, reason: collision with root package name */
    private List<String> f9394e;

    /* renamed from: f, reason: collision with root package name */
    private List<SuggestionCity> f9395f;

    /* renamed from: g, reason: collision with root package name */
    private int f9396g;

    private int a(int i6) {
        return ((i6 + r0) - 1) / this.f9396g;
    }

    public static PoiResult createPagedResult(PoiSearch.Query query, PoiSearch.SearchBound searchBound, List<String> list, List<SuggestionCity> list2, int i6, int i7, ArrayList<PoiItem> arrayList) {
        return new PoiResult(query, searchBound, list, list2, i6, i7, arrayList);
    }

    public final PoiSearch.SearchBound getBound() {
        return this.f9393d;
    }

    public final int getPageCount() {
        return this.f9390a;
    }

    public final ArrayList<PoiItem> getPois() {
        return this.f9391b;
    }

    public final PoiSearch.Query getQuery() {
        return this.f9392c;
    }

    public final List<SuggestionCity> getSearchSuggestionCitys() {
        return this.f9395f;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.f9394e;
    }

    private PoiResult(PoiSearch.Query query, PoiSearch.SearchBound searchBound, List<String> list, List<SuggestionCity> list2, int i6, int i7, ArrayList<PoiItem> arrayList) {
        this.f9391b = new ArrayList<>();
        this.f9392c = query;
        this.f9393d = searchBound;
        this.f9394e = list;
        this.f9395f = list2;
        this.f9396g = i6;
        this.f9390a = a(i7);
        this.f9391b = arrayList;
    }
}
