package com.bytedance.sdk.openadsdk.i.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements DislikeInfo {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31495j;
    private ValueSet xt;

    @Override // com.bytedance.sdk.openadsdk.DislikeInfo
    public List<FilterWord> getFilterWords() {
        List list = (List) this.xt.objectValue(243001, List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new m(az.j(it.next())));
            }
        }
        return arrayList;
    }

    public r(Function<SparseArray<Object>, Object> function) {
        Object apply;
        this.xt = a.f22763c;
        function = function == null ? a.f22765e : function;
        this.f31495j = function;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        apply = function.apply(sparseArray);
        if (apply instanceof SparseArray) {
            this.xt = a.j((SparseArray) apply).k();
        }
    }
}
