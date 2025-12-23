package com.amap.api.services.nearby;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class NearbySearchResult {

    /* renamed from: a, reason: collision with root package name */
    private List<NearbyInfo> f9360a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private int f9361b = 0;

    public List<NearbyInfo> getNearbyInfoList() {
        return this.f9360a;
    }

    public int getTotalNum() {
        return this.f9361b;
    }

    public void setNearbyInfoList(List<NearbyInfo> list) {
        this.f9360a = list;
        this.f9361b = list.size();
    }
}
