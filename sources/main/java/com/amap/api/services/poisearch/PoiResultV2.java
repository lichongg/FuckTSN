package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PoiResultV2 {

    /* renamed from: a, reason: collision with root package name */
    private int f9397a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<PoiItemV2> f9398b;

    /* renamed from: c, reason: collision with root package name */
    private PoiSearchV2.Query f9399c;

    /* renamed from: d, reason: collision with root package name */
    private PoiSearchV2.SearchBound f9400d;

    public static PoiResultV2 createPagedResult(PoiSearchV2.Query query, PoiSearchV2.SearchBound searchBound, int i6, ArrayList<PoiItemV2> arrayList) {
        return new PoiResultV2(query, searchBound, i6, arrayList);
    }

    public PoiSearchV2.SearchBound getBound() {
        return this.f9400d;
    }

    public int getCount() {
        return this.f9397a;
    }

    public ArrayList<PoiItemV2> getPois() {
        return this.f9398b;
    }

    public PoiSearchV2.Query getQuery() {
        return this.f9399c;
    }

    private PoiResultV2(PoiSearchV2.Query query, PoiSearchV2.SearchBound searchBound, int i6, ArrayList<PoiItemV2> arrayList) {
        new ArrayList();
        this.f9399c = query;
        this.f9400d = searchBound;
        this.f9397a = i6;
        this.f9398b = arrayList;
    }
}
