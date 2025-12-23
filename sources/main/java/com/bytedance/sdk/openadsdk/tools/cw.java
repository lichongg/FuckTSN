package com.bytedance.sdk.openadsdk.tools;

import a1.a;
import a1.b;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private static volatile cw f31849j;

    public static cw j() {
        if (f31849j == null) {
            f31849j = new cw();
        }
        return f31849j;
    }

    private cw() {
    }

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        if (intValue == 10001) {
            oq.i().oq(k6.booleanValue(1));
        } else {
            if (intValue == 10002) {
                return Boolean.valueOf(oq.i().zz());
            }
            if (intValue == 10003) {
                v.j().j(b.a(k6.objectValue(0, a.a())));
            } else if (intValue == 10004) {
                Function<SparseArray<Object>, Object> a6 = b.a(k6.objectValue(0, a.a()));
                String str = (String) k6.objectValue(1, String.class);
                String str2 = (String) k6.objectValue(2, String.class);
                String str3 = (String) k6.objectValue(3, String.class);
                String str4 = (String) k6.objectValue(4, String.class);
                HashMap hashMap = new HashMap();
                hashMap.put("adtype", str2);
                hashMap.put("rit", str);
                hashMap.put("image_mode", str3);
                hashMap.put("preview_extra", str4);
                v.j().j(hashMap, a6);
            } else {
                if (intValue == 10005) {
                    e a7 = e.a();
                    a7.g(0, oq.i().aq());
                    a7.g(1, oq.i().rr());
                    return a7.k().sparseArray();
                }
                if (intValue == 10006) {
                    v.j().j((Map<String, Object>) k6.objectValue(0, Map.class), b.a(k6.objectValue(1, a.a())));
                } else if (intValue == 10007) {
                    oq.i().j((oq.r) null);
                }
            }
        }
        return null;
    }
}
