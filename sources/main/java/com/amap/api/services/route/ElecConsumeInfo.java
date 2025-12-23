package com.amap.api.services.route;

import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ElecConsumeInfo {

    /* renamed from: a, reason: collision with root package name */
    private int f9586a;

    /* renamed from: b, reason: collision with root package name */
    private int f9587b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f9588c;

    /* renamed from: d, reason: collision with root package name */
    private List<Integer> f9589d = new ArrayList();

    public int getConsumeEnergy() {
        return this.f9586a;
    }

    public List<Integer> getLeftEnergy() {
        return this.f9589d;
    }

    public LatLonPoint getRunOutPoint() {
        return this.f9588c;
    }

    public int getRunOutStepIndex() {
        return this.f9587b;
    }

    public void setConsumeEnergy(int i6) {
        this.f9586a = i6;
    }

    public void setLeftEnergy(List<Integer> list) {
        this.f9589d = list;
    }

    public void setRunOutPoint(LatLonPoint latLonPoint) {
        this.f9588c = latLonPoint;
    }

    public void setRunOutStepIndex(int i6) {
        this.f9587b = i6;
    }
}
