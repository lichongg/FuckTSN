package com.amap.api.trace;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TraceOverlay {
    public static final int TRACE_STATUS_FAILURE = 3;
    public static final int TRACE_STATUS_FINISH = 2;
    public static final int TRACE_STATUS_PREPARE = 4;
    public static final int TRACE_STATUS_PROCESSING = 1;

    /* renamed from: a, reason: collision with root package name */
    private Polyline f9896a;

    /* renamed from: b, reason: collision with root package name */
    private PolylineOptions f9897b;

    /* renamed from: c, reason: collision with root package name */
    private AMap f9898c;

    /* renamed from: d, reason: collision with root package name */
    private List<LatLng> f9899d;

    /* renamed from: e, reason: collision with root package name */
    private int f9900e;

    /* renamed from: f, reason: collision with root package name */
    private int f9901f;

    /* renamed from: g, reason: collision with root package name */
    private int f9902g;

    public TraceOverlay(AMap aMap, List<LatLng> list) {
        this.f9899d = new ArrayList();
        this.f9900e = 4;
        this.f9898c = aMap;
        a();
        this.f9899d = list;
        this.f9897b.addAll(list);
        this.f9896a = aMap.addPolyline(this.f9897b);
    }

    private PolylineOptions a() {
        if (this.f9897b == null) {
            PolylineOptions polylineOptions = new PolylineOptions();
            this.f9897b = polylineOptions;
            polylineOptions.setCustomTexture(BitmapDescriptorFactory.fromAsset("tracelinetexture.png"));
            this.f9897b.width(40.0f);
        }
        return this.f9897b;
    }

    public void add(List<LatLng> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f9899d.addAll(list);
        a();
        if (this.f9896a == null) {
            this.f9896a = this.f9898c.addPolyline(this.f9897b);
        }
        Polyline polyline = this.f9896a;
        if (polyline != null) {
            polyline.setPoints(this.f9899d);
        }
    }

    public int getDistance() {
        return this.f9901f;
    }

    public int getTraceStatus() {
        return this.f9900e;
    }

    public int getWaitTime() {
        return this.f9902g;
    }

    public void remove() {
        Polyline polyline = this.f9896a;
        if (polyline != null) {
            polyline.remove();
        }
    }

    public void setDistance(int i6) {
        this.f9901f = i6;
    }

    public void setTraceStatus(int i6) {
        this.f9900e = i6;
    }

    public void setWaitTime(int i6) {
        this.f9902g = i6;
    }

    public void zoopToSpan() {
        setProperCamera(this.f9897b.getPoints());
    }

    public void setProperCamera(List<LatLng> list) {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        if (list != null && list.size() != 0) {
            Iterator<LatLng> it = list.iterator();
            while (it.hasNext()) {
                builder.include(it.next());
            }
            try {
                this.f9898c.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 20));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public TraceOverlay(AMap aMap) {
        this.f9899d = new ArrayList();
        this.f9900e = 4;
        this.f9898c = aMap;
        a();
    }
}
