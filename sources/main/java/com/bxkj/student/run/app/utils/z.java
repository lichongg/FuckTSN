package com.bxkj.student.run.app.utils;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class z {

    /* renamed from: d, reason: collision with root package name */
    private TraceLocation f20361d;

    /* renamed from: a, reason: collision with root package name */
    final int f20358a = 20;

    /* renamed from: b, reason: collision with root package name */
    private Boolean f20359b = Boolean.TRUE;

    /* renamed from: c, reason: collision with root package name */
    private TraceLocation f20360c = new TraceLocation();

    /* renamed from: e, reason: collision with root package name */
    private List<TraceLocation> f20362e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private List<TraceLocation> f20363f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private int f20364g = 0;

    public Boolean a(TraceLocation aMapLocation) {
        if (this.f20359b.booleanValue()) {
            this.f20359b = Boolean.FALSE;
            this.f20360c.setLatitude(aMapLocation.getLatitude());
            this.f20360c.setLongitude(aMapLocation.getLongitude());
            this.f20360c.setTime(aMapLocation.getTime());
            TraceLocation traceLocation = new TraceLocation();
            traceLocation.setLatitude(aMapLocation.getLatitude());
            traceLocation.setLongitude(aMapLocation.getLongitude());
            traceLocation.setTime(aMapLocation.getTime());
            this.f20362e.add(traceLocation);
            this.f20364g++;
            return Boolean.TRUE;
        }
        String str = "非第一次 : ";
        if (this.f20361d == null) {
            long time = ((aMapLocation.getTime() - this.f20360c.getTime()) / 1000) * 20;
            float calculateLineDistance = AMapUtils.calculateLineDistance(new LatLng(this.f20360c.getLatitude(), this.f20360c.getLongitude()), new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
            String str2 = (str + "weight2=null : ") + "distance = " + calculateLineDistance + ",MaxDistance = " + time + " : ";
            if (calculateLineDistance > time) {
                TraceLocation traceLocation2 = new TraceLocation();
                this.f20361d = traceLocation2;
                traceLocation2.setLatitude(aMapLocation.getLatitude());
                this.f20361d.setLongitude(aMapLocation.getLongitude());
                this.f20361d.setTime(aMapLocation.getTime());
                this.f20363f.add(this.f20361d);
                return Boolean.FALSE;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("distance < MaxDistance当前点 距离小 : 添加到w1TempList");
            TraceLocation traceLocation3 = new TraceLocation();
            traceLocation3.setLatitude(aMapLocation.getLatitude());
            traceLocation3.setLongitude(aMapLocation.getLongitude());
            traceLocation3.setTime(aMapLocation.getTime());
            this.f20362e.add(traceLocation3);
            this.f20364g++;
            TraceLocation traceLocation4 = this.f20360c;
            traceLocation4.setLatitude((traceLocation4.getLatitude() * 0.2d) + (aMapLocation.getLatitude() * 0.8d));
            TraceLocation traceLocation5 = this.f20360c;
            traceLocation5.setLongitude((traceLocation5.getLongitude() * 0.2d) + (aMapLocation.getLongitude() * 0.8d));
            this.f20360c.setTime(aMapLocation.getTime());
            this.f20360c.setSpeed(aMapLocation.getSpeed());
            if (this.f20364g <= 3) {
                return Boolean.FALSE;
            }
            this.f20362e.clear();
            return Boolean.TRUE;
        }
        long time2 = ((aMapLocation.getTime() - this.f20361d.getTime()) / 1000) * 16;
        float calculateLineDistance2 = AMapUtils.calculateLineDistance(new LatLng(this.f20361d.getLatitude(), this.f20361d.getLongitude()), new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
        String str3 = (str + "weight2 != null : ") + "distance = " + calculateLineDistance2 + ",MaxDistance = " + time2 + " : ";
        if (calculateLineDistance2 > time2) {
            this.f20363f.clear();
            TraceLocation traceLocation6 = new TraceLocation();
            this.f20361d = traceLocation6;
            traceLocation6.setLatitude(aMapLocation.getLatitude());
            this.f20361d.setLongitude(aMapLocation.getLongitude());
            this.f20361d.setTime(aMapLocation.getTime());
            this.f20363f.add(this.f20361d);
            return Boolean.FALSE;
        }
        String str4 = str3 + "当前点 距离小: 添加到w2TempList";
        TraceLocation traceLocation7 = new TraceLocation();
        traceLocation7.setLatitude(aMapLocation.getLatitude());
        traceLocation7.setLongitude(aMapLocation.getLongitude());
        traceLocation7.setTime(aMapLocation.getTime());
        this.f20363f.add(traceLocation7);
        TraceLocation traceLocation8 = this.f20361d;
        traceLocation8.setLatitude((traceLocation8.getLatitude() * 0.2d) + (aMapLocation.getLatitude() * 0.8d));
        TraceLocation traceLocation9 = this.f20361d;
        traceLocation9.setLongitude((traceLocation9.getLongitude() * 0.2d) + (aMapLocation.getLongitude() * 0.8d));
        this.f20361d.setTime(aMapLocation.getTime());
        this.f20361d.setSpeed(aMapLocation.getSpeed());
        if (this.f20363f.size() <= 4) {
            return Boolean.FALSE;
        }
        if (this.f20364g > 4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str4);
            sb2.append("w1Count > 4计算增加W1");
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str4);
            sb3.append("w1Count < 4计算丢弃W1");
            this.f20362e.clear();
        }
        this.f20363f.clear();
        this.f20360c = this.f20361d;
        this.f20361d = null;
        return Boolean.TRUE;
    }
}
