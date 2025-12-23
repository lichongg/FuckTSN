package com.amap.api.col.p0003l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public enum cx {
    STYLE_ELEMENT_LABELFILL_OLD("labels.text.fill", 0),
    STYLE_ELEMENT_LABELSTROKE_OLD("labels.text.stroke", 1),
    STYLE_ELEMENT_GEOMETRYSTROKE_OLD("geometry.stroke", 2),
    STYLE_ELEMENT_GEOMETRYFILL_OLD("geometry.fill", 3),
    STYLE_ELEMENT_LABELFILL("textFillColor", 0),
    STYLE_ELEMENT_LABELSTROKE("textStrokeColor", 1),
    STYLE_ELEMENT_GEOMETRYSTROKE("strokeColor", 2),
    STYLE_ELEMENT_GEOMETRYFILL("fillColor", 3),
    STYLE_ELEMENT_GEOMETRYFILL1("color", 3),
    STYLE_ELEMENT_GEOMETRYFILL2("textureName", 3),
    STYLE_ELEMENT_BACKGROUNDFILL("backgroundColor", 4),
    STYLE_ELEMENT_VISIBLE("visible", 5);


    /* renamed from: m, reason: collision with root package name */
    private String f5881m;

    /* renamed from: n, reason: collision with root package name */
    private int f5882n;

    private String a() {
        return this.f5881m;
    }

    public static int a(String str) {
        for (cx cxVar : values()) {
            if (cxVar.a().equals(str)) {
                return cxVar.f5882n;
            }
        }
        return -1;
    }

    cx(String str, int i6) {
        this.f5881m = str;
        this.f5882n = i6;
    }
}
