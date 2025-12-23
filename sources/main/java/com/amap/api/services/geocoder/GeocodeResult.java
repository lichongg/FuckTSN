package com.amap.api.services.geocoder;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GeocodeResult {

    /* renamed from: a, reason: collision with root package name */
    private GeocodeQuery f9293a;

    /* renamed from: b, reason: collision with root package name */
    private List<GeocodeAddress> f9294b;

    public List<GeocodeAddress> getGeocodeAddressList() {
        return this.f9294b;
    }

    public GeocodeQuery getGeocodeQuery() {
        return this.f9293a;
    }

    public void setGeocodeAddressList(List<GeocodeAddress> list) {
        this.f9294b = list;
    }

    public void setGeocodeQuery(GeocodeQuery geocodeQuery) {
        this.f9293a = geocodeQuery;
    }

    public GeocodeResult(GeocodeQuery geocodeQuery, List<GeocodeAddress> list) {
        new ArrayList();
        this.f9293a = geocodeQuery;
        this.f9294b = list;
    }
}
