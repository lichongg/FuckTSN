package com.bxkj.student.run.app.utils;

import androidx.annotation.NonNull;
import com.amap.api.maps.model.LatLng;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class k implements Comparable<k> {

    /* renamed from: a, reason: collision with root package name */
    public int f20283a;

    /* renamed from: b, reason: collision with root package name */
    public LatLng f20284b;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull k latLngPoint) {
        int i6 = this.f20283a;
        int i7 = latLngPoint.f20283a;
        if (i6 < i7) {
            return -1;
        }
        return i6 > i7 ? 1 : 0;
    }

    public k(int id, LatLng latLng) {
        this.f20283a = id;
        this.f20284b = latLng;
    }
}
