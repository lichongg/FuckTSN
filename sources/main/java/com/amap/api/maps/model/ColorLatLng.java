package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class ColorLatLng {
    private int color;
    private List<LatLng> latLngs;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ColorLatLng colorLatLng = (ColorLatLng) obj;
            if (this.color == colorLatLng.color && Objects.equals(this.latLngs, colorLatLng.latLngs)) {
                return true;
            }
        }
        return false;
    }

    public int getColor() {
        return this.color;
    }

    public List<LatLng> getLatLngs() {
        return this.latLngs;
    }

    public int hashCode() {
        return Objects.hash(this.latLngs, Integer.valueOf(this.color));
    }

    public String toString() {
        return "ColorLatLng{latLngs=" + this.latLngs + ", color=" + this.color + '}';
    }

    public ColorLatLng(List<LatLng> list, int i6) {
        ArrayList arrayList = new ArrayList();
        this.latLngs = arrayList;
        arrayList.clear();
        this.latLngs.addAll(list);
        this.color = i6;
    }
}
