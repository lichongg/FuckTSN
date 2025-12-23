package com.bytedance.sdk.openadsdk.i.xt.cw;

import android.util.SparseArray;
import com.bykv.j.j.j.j.f;
import com.bykv.j.j.j.j.g;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.i.xt;
import com.bytedance.sdk.openadsdk.i.xt.cw;
import com.bytedance.sdk.openadsdk.i.xt.r;
import com.bytedance.sdk.openadsdk.i.xt.up;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static Result j(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ValueSet k6 = com.bykv.j.j.j.j.a.j(sparseArray).k();
        return g.a().b(k6.intValue(-999900)).d(k6.stringValue(-999901)).e(k6.booleanValue(-999903)).c(xt((SparseArray<Object>) k6.objectValue(-999902, SparseArray.class))).f();
    }

    public static ValueSet xt(SparseArray<Object> sparseArray) {
        SparseArray<Object> j6;
        if (sparseArray == null) {
            return null;
        }
        com.bykv.j.j.j.j.a a6 = com.bykv.j.j.j.j.a.a();
        for (int i6 = 0; i6 < sparseArray.size(); i6++) {
            int keyAt = sparseArray.keyAt(i6);
            j(a6, keyAt, sparseArray.get(keyAt));
        }
        if ((sparseArray instanceof xt) && (j6 = ((xt) sparseArray).j()) != null && j6.size() > 0) {
            for (int i7 = 0; i7 < j6.size(); i7++) {
                int keyAt2 = j6.keyAt(i7);
                j(a6, keyAt2, j6.get(keyAt2));
            }
        }
        return a6.k();
    }

    public static Object cw(Object obj) {
        final HashMap hashMap = new HashMap();
        ((Map) obj).forEach(new BiConsumer<Object, Object>() { // from class: com.bytedance.sdk.openadsdk.i.xt.cw.j.2
            @Override // java.util.function.BiConsumer
            public void accept(Object obj2, Object obj3) {
                long asLong;
                if (f.a(obj3)) {
                    if (b.a(obj3)) {
                        asLong = c.a(obj3).getAsLong();
                        if (asLong == -99999981) {
                            hashMap.put(obj2, new up(a1.b.a(obj3)));
                            return;
                        }
                    }
                    hashMap.put(obj2, new com.bytedance.sdk.openadsdk.i.xt.xt(a1.b.a(obj3)));
                    return;
                }
                if (obj3 instanceof SparseArray) {
                    hashMap.put(obj2, j.xt((SparseArray<Object>) obj3));
                    return;
                }
                if (obj3 == a1.a.a()) {
                    hashMap.put(obj2, Bridge.class);
                } else if (obj3 == SparseArray.class) {
                    hashMap.put(obj2, ValueSet.class);
                } else {
                    hashMap.put(obj2, obj3);
                }
            }
        });
        return hashMap;
    }

    public static Object r(Object obj) {
        final HashMap hashMap = new HashMap();
        ((Map) obj).forEach(new BiConsumer<Object, Object>() { // from class: com.bytedance.sdk.openadsdk.i.xt.cw.j.3
            @Override // java.util.function.BiConsumer
            public void accept(Object obj2, Object obj3) {
                if (obj3 instanceof Bridge) {
                    hashMap.put(obj2, new cw((Bridge) obj3));
                    return;
                }
                if (obj3 instanceof ValueSet) {
                    hashMap.put(obj2, new com.bytedance.sdk.openadsdk.i.xt.j((ValueSet) obj3));
                    return;
                }
                if (obj3 instanceof EventListener) {
                    hashMap.put(obj2, new r((EventListener) obj3));
                    return;
                }
                if (obj3 == Bridge.class) {
                    hashMap.put(obj2, a1.a.a());
                } else if (obj3 == ValueSet.class) {
                    hashMap.put(obj2, SparseArray.class);
                } else {
                    hashMap.put(obj2, obj3);
                }
            }
        });
        return hashMap;
    }

    private static void j(com.bykv.j.j.j.j.a aVar, int i6, final Object obj) {
        long asLong;
        if (f.a(obj)) {
            if (b.a(obj)) {
                asLong = c.a(obj).getAsLong();
                if (asLong == -99999981) {
                    aVar.g(i6, new up(a1.b.a(obj)));
                    return;
                }
            }
            aVar.g(i6, new com.bytedance.sdk.openadsdk.i.xt.xt(a1.b.a(obj)));
            return;
        }
        if (obj instanceof SparseArray) {
            if (i6 == -99999979) {
                aVar.g(i6, j((SparseArray<Object>) obj));
                return;
            } else {
                aVar.g(i6, xt((SparseArray<Object>) obj));
                return;
            }
        }
        if (com.bykv.j.j.j.j.b.a(obj) && !f.a(obj) && !(obj instanceof ValueSet)) {
            aVar.g(i6, new Supplier<Object>() { // from class: com.bytedance.sdk.openadsdk.i.xt.cw.j.1
                @Override // java.util.function.Supplier
                public Object get() {
                    Object obj2;
                    obj2 = com.bykv.j.j.j.j.c.a(obj).get();
                    return j.xt(obj2);
                }
            });
            return;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (!list.isEmpty() && f.a(list.get(0))) {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.bytedance.sdk.openadsdk.i.xt.xt(a1.b.a(it.next())));
                }
                aVar.g(i6, arrayList);
                return;
            }
            aVar.g(i6, obj);
            return;
        }
        if (obj instanceof Map) {
            aVar.g(i6, cw(obj));
        } else {
            aVar.g(i6, obj);
        }
    }

    public static Object xt(Object obj) {
        if (f.a(obj)) {
            return new com.bytedance.sdk.openadsdk.i.xt.xt(a1.b.a(obj));
        }
        if (obj instanceof SparseArray) {
            return xt((SparseArray<Object>) obj);
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.isEmpty() || !f.a(list.get(0))) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.bytedance.sdk.openadsdk.i.xt.xt(a1.b.a(it.next())));
            }
            return arrayList;
        }
        if (obj instanceof Map) {
            return cw(obj);
        }
        if (obj == a1.a.a()) {
            return Bridge.class;
        }
        return obj == SparseArray.class ? ValueSet.class : obj;
    }

    public static SparseArray<Object> j(Function<SparseArray<Object>, Object> function) {
        Object apply;
        if (function == null) {
            return new SparseArray<>();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        apply = function.apply(sparseArray);
        if (apply instanceof SparseArray) {
            return (SparseArray) apply;
        }
        return new SparseArray<>();
    }

    public static Object j(Object obj) {
        if (obj instanceof Bridge) {
            return new cw((Bridge) obj);
        }
        if (obj instanceof ValueSet) {
            return new com.bytedance.sdk.openadsdk.i.xt.j((ValueSet) obj);
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.isEmpty() || !(list.get(0) instanceof Bridge)) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new cw((Bridge) it.next()));
            }
            return arrayList;
        }
        if (obj instanceof Map) {
            return r(obj);
        }
        if (obj == Bridge.class) {
            return a1.a.a();
        }
        return obj == ValueSet.class ? SparseArray.class : obj;
    }

    public static SparseArray<Object> j(Result result) {
        if (result == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-999900, Integer.valueOf(result.code()));
        sparseArray.put(-999901, result.message());
        sparseArray.put(-999903, Boolean.valueOf(result.isSuccess()));
        sparseArray.put(-999902, new com.bytedance.sdk.openadsdk.i.xt.j(result.values()));
        return sparseArray;
    }
}
