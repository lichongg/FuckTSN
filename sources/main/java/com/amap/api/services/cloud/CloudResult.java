package com.amap.api.services.cloud;

import com.amap.api.services.cloud.CloudSearch;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class CloudResult {

    /* renamed from: a, reason: collision with root package name */
    private int f9166a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<CloudItem> f9167b;

    /* renamed from: c, reason: collision with root package name */
    private int f9168c;

    /* renamed from: d, reason: collision with root package name */
    private int f9169d;

    /* renamed from: e, reason: collision with root package name */
    private CloudSearch.Query f9170e;

    /* renamed from: f, reason: collision with root package name */
    private CloudSearch.SearchBound f9171f;

    private int a(int i6) {
        return ((i6 + r0) - 1) / this.f9169d;
    }

    public static CloudResult createPagedResult(CloudSearch.Query query, int i6, CloudSearch.SearchBound searchBound, int i7, ArrayList<CloudItem> arrayList) {
        return new CloudResult(query, i6, searchBound, i7, arrayList);
    }

    public final CloudSearch.SearchBound getBound() {
        return this.f9171f;
    }

    public final ArrayList<CloudItem> getClouds() {
        return this.f9167b;
    }

    public final int getPageCount() {
        return this.f9166a;
    }

    public final CloudSearch.Query getQuery() {
        return this.f9170e;
    }

    public final int getTotalCount() {
        return this.f9168c;
    }

    private CloudResult(CloudSearch.Query query, int i6, CloudSearch.SearchBound searchBound, int i7, ArrayList<CloudItem> arrayList) {
        this.f9170e = query;
        this.f9168c = i6;
        this.f9169d = i7;
        this.f9166a = a(i6);
        this.f9167b = arrayList;
        this.f9171f = searchBound;
    }
}
