package com.bytedance.sdk.openadsdk.i.cw.xt;

import a1.a;
import a1.b;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f31428j;

    public String j() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 241103);
        sparseArray.put(-99999985, String.class);
        apply = this.f31428j.apply(sparseArray);
        return (String) apply;
    }

    public boolean cw() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 241105);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.f31428j.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    public boolean m() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 241106);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.f31428j.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    public List<m> r() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 241108);
        sparseArray.put(-99999985, List.class);
        apply = this.f31428j.apply(sparseArray);
        List list = (List) apply;
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new m(com.bytedance.sdk.openadsdk.p.cw.j(it.next())));
        }
        return arrayList;
    }

    public boolean up() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 241107);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.f31428j.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    public String xt() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 241104);
        sparseArray.put(-99999985, String.class);
        apply = this.f31428j.apply(sparseArray);
        return (String) apply;
    }

    public m(Function<SparseArray<Object>, Object> function) {
        Function<SparseArray<Object>, Object> function2 = e.f22772d;
        this.f31428j = function2;
        this.f31428j = function == null ? function2 : function;
    }

    public void j(m mVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, mVar);
        sparseArray.put(-99999987, 241101);
        sparseArray.put(-99999985, Void.class);
        this.f31428j.apply(sparseArray);
    }

    public void j(boolean z5) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, Boolean.valueOf(z5));
        sparseArray.put(-99999987, 241102);
        sparseArray.put(-99999985, Void.class);
        this.f31428j.apply(sparseArray);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        k6.objectValue(-99999985, Class.class);
        if (intValue != -99999986) {
            switch (intValue) {
                case 241101:
                    j(new m(b.a(k6.objectValue(0, a.a()))));
                    return null;
                case 241102:
                    j(k6.booleanValue(0));
                    return null;
                case 241103:
                    return j();
                case 241104:
                    return xt();
                case 241105:
                    return Boolean.class.cast(Boolean.valueOf(cw()));
                case 241106:
                    return Boolean.class.cast(Boolean.valueOf(m()));
                case 241107:
                    return Boolean.class.cast(Boolean.valueOf(up()));
                case 241108:
                    return r();
                default:
                    return null;
            }
        }
        return new SparseArray();
    }
}
