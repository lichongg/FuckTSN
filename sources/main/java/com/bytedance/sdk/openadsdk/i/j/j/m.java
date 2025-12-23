package com.bytedance.sdk.openadsdk.i.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class m implements FilterWord, Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31492j;
    private FilterWord xt;

    public m(FilterWord filterWord) {
        this.xt = filterWord;
        this.f31492j = a.f22765e;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void addOption(FilterWord filterWord) {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 241101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new m(filterWord));
        this.f31492j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getId() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 241103);
        sparseArray.put(-99999985, String.class);
        apply = this.f31492j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean getIsSelected() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 241105);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.f31492j.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getName() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 241104);
        sparseArray.put(-99999985, String.class);
        apply = this.f31492j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public List<FilterWord> getOptions() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 241108);
        sparseArray.put(-99999985, List.class);
        apply = this.f31492j.apply(sparseArray);
        List list = (List) apply;
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

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean hasSecondOptions() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 241106);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.f31492j.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean isValid() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 241107);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.f31492j.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xt == null) {
            return null;
        }
        ValueSet k6 = a.j(sparseArray).k();
        switch (k6.intValue(-99999987)) {
            case 241101:
                this.xt.addOption(new m(az.j(k6.objectValue(0, Object.class))));
                return null;
            case 241102:
                this.xt.setIsSelected(k6.booleanValue(0));
                return null;
            case 241103:
                return this.xt.getId();
            case 241104:
                return this.xt.getName();
            case 241105:
                return Boolean.class.cast(Boolean.valueOf(this.xt.getIsSelected()));
            case 241106:
                return Boolean.class.cast(Boolean.valueOf(this.xt.hasSecondOptions()));
            case 241107:
                return Boolean.class.cast(Boolean.valueOf(this.xt.isValid()));
            case 241108:
                return this.xt.getOptions();
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void setIsSelected(boolean z5) {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 241102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Boolean.valueOf(z5));
        this.f31492j.apply(sparseArray);
    }

    public m(Function<SparseArray<Object>, Object> function) {
        this.f31492j = function == null ? a.f22765e : function;
    }
}
