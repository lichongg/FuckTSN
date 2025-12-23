package com.bytedance.sdk.openadsdk.i.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j<E> extends SparseArray<E> {

    /* renamed from: j, reason: collision with root package name */
    private final ValueSet f31512j;
    private final PluginValueSet xt;

    public j(ValueSet valueSet) {
        this.f31512j = valueSet == null ? a.f22763c : valueSet;
        this.xt = e.f22771c;
    }

    @Override // android.util.SparseArray
    public E get(int i6, E e6) {
        E e7 = (E) super.get(i6, null);
        if (e7 != null) {
            return e7;
        }
        E j6 = j(i6);
        return j6 != null ? j6 : e6;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [E, java.util.ArrayList, java.util.List] */
    private E j(int i6) {
        List list = (E) this.f31512j.objectValue(i6, Object.class);
        if (list == null) {
            list = (E) this.xt.objectValue(i6, Object.class);
        }
        if (list != null) {
            if (i6 == 9) {
                if (list == Bridge.class) {
                    return (E) a1.a.a();
                }
                if (list == ValueSet.class) {
                    return SparseArray.class;
                }
            } else {
                if (list instanceof Bridge) {
                    return (E) new cw((Bridge) list);
                }
                if (list instanceof ValueSet) {
                    return (E) new j((ValueSet) list);
                }
                if (list instanceof EventListener) {
                    return (E) new r((EventListener) list);
                }
                if (list instanceof Result) {
                    return (E) com.bytedance.sdk.openadsdk.i.xt.cw.j.j((Result) list);
                }
                if (list instanceof List) {
                    List list2 = list;
                    if (!list2.isEmpty() && (list2.get(0) instanceof Bridge)) {
                        ?? r02 = (E) new ArrayList();
                        Iterator<E> it = list2.iterator();
                        while (it.hasNext()) {
                            r02.add(new cw((Bridge) it.next()));
                        }
                        return r02;
                    }
                } else if (list instanceof Map) {
                    return (E) com.bytedance.sdk.openadsdk.i.xt.cw.j.r(list);
                }
            }
        }
        return (E) list;
    }

    @Override // android.util.SparseArray
    public boolean contains(int i6) {
        if (!super.contains(i6) && !this.f31512j.containsKey(i6) && !this.xt.containsKey(i6)) {
            return false;
        }
        return true;
    }

    public j(PluginValueSet pluginValueSet) {
        this.xt = pluginValueSet == null ? e.f22771c : pluginValueSet;
        this.f31512j = a.f22763c;
    }
}
