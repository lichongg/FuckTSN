package com.autonavi.base.ae.gmap.style;

import com.snail.antifake.deviceid.e;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class StyleItem {
    public int mainKey;
    private Map<Integer, StyleElement> styleElements = new HashMap();
    private int styleTypeId;
    public int[] subKey;

    public StyleElement get(int i6) {
        return this.styleElements.get(Integer.valueOf(i6));
    }

    public StyleElement[] getStyleElements() {
        Map<Integer, StyleElement> map = this.styleElements;
        if (map == null || map.size() <= 0) {
            return null;
        }
        return (StyleElement[]) this.styleElements.values().toArray(new StyleElement[this.styleElements.size()]);
    }

    public boolean isValid() {
        return this.styleElements.size() > 0 && this.styleTypeId >= 0;
    }

    public void put(int i6, StyleElement styleElement) {
        this.styleElements.put(Integer.valueOf(i6), styleElement);
    }

    public String toString() {
        return "styleTypeId:" + this.styleTypeId + e.f37542d + "styleElements.size :" + this.styleElements.size();
    }

    public StyleItem(int i6) {
        this.styleTypeId = i6;
    }
}
