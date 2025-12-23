package com.amap.api.col.p0003l;

import com.autonavi.base.ae.gmap.style.StyleItem;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class f2 {

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, StyleItem> f6163a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private Object f6164b = null;

    /* renamed from: c, reason: collision with root package name */
    private StyleItem[] f6165c;

    public final Map<Integer, StyleItem> a() {
        return this.f6163a;
    }

    public final StyleItem[] b() {
        Map<Integer, StyleItem> map = this.f6163a;
        if (map != null && map.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (StyleItem styleItem : this.f6163a.values()) {
                if (styleItem.isValid()) {
                    arrayList.add(styleItem);
                }
            }
            int size = arrayList.size();
            if (size > 0) {
                StyleItem[] styleItemArr = (StyleItem[]) arrayList.toArray(new StyleItem[size]);
                this.f6165c = styleItemArr;
                return styleItemArr;
            }
        }
        return null;
    }

    public final StyleItem[] c() {
        return this.f6165c;
    }

    public final Object d() {
        return this.f6164b;
    }
}
