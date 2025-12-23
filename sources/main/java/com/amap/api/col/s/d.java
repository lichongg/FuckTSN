package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.poisearch.PoiSearchV2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
abstract class d<T, V> extends b4<T, V> {
    protected static String U(PoiSearchV2.ShowFields showFields) {
        if (showFields != null && showFields.getValue() != 0) {
            StringBuilder sb = new StringBuilder();
            if ((showFields.getValue() & 1) != 0) {
                sb.append("children,");
            }
            if ((showFields.getValue() & 2) != 0) {
                sb.append("business,");
            }
            if ((showFields.getValue() & 4) != 0) {
                sb.append("indoor,");
            }
            if ((showFields.getValue() & 8) != 0) {
                sb.append("navi,");
            }
            if ((showFields.getValue() & 16) != 0) {
                sb.append("photos,");
            }
            if (sb.length() > 0) {
                sb.replace(sb.length() - 1, sb.length(), "");
                return sb.toString();
            }
        }
        return null;
    }

    protected static boolean V(String str) {
        return str == null || str.equals("") || str.equals("[]");
    }

    public d(Context context, T t5) {
        super(context, t5);
    }
}
