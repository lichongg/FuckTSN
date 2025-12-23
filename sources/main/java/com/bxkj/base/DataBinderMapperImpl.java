package com.bxkj.base;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.databinding.NewPubTitleBindingImpl;
import com.bxkj.base.databinding.V2PubRecyclerviewWithEmptyViewBindingImpl;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a, reason: collision with root package name */
    private static final int f16363a = 1;

    /* renamed from: b, reason: collision with root package name */
    private static final int f16364b = 2;

    /* renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f16365c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static final SparseArray<String> f16366a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(4);
            f16366a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, TTDownloadField.TT_ACTIVITY);
            sparseArray.put(2, "isHideBack");
            sparseArray.put(3, "title");
        }

        private a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        static final HashMap<String, Integer> f16367a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(2);
            f16367a = hashMap;
            hashMap.put("layout/new_pub_title_0", Integer.valueOf(R.layout.new_pub_title));
            hashMap.put("layout/v2_pub_recyclerview_with_empty_view_0", Integer.valueOf(R.layout.v2_pub_recyclerview_with_empty_view));
        }

        private b() {
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i6) {
        int i7 = f16365c.get(i6);
        if (i7 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        if (i7 == 1) {
            if ("layout/new_pub_title_0".equals(tag)) {
                return new NewPubTitleBindingImpl(dataBindingComponent, view);
            }
            throw new IllegalArgumentException("The tag for new_pub_title is invalid. Received: " + tag);
        }
        if (i7 != 2) {
            return null;
        }
        if ("layout/v2_pub_recyclerview_with_empty_view_0".equals(tag)) {
            return new V2PubRecyclerviewWithEmptyViewBindingImpl(dataBindingComponent, view);
        }
        throw new IllegalArgumentException("The tag for v2_pub_recyclerview_with_empty_view is invalid. Received: " + tag);
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f16367a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(2);
        f16365c = sparseIntArray;
        sparseIntArray.put(R.layout.new_pub_title, 1);
        sparseIntArray.put(R.layout.v2_pub_recyclerview_with_empty_view, 2);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i6) {
        return a.f16366a.get(i6);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i6) {
        if (viewArr == null || viewArr.length == 0 || f16365c.get(i6) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
