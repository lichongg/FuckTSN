package com.bxkj.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import com.bxkj.base.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V2PubRecyclerviewWithEmptyViewBinding extends ViewDataBinding {

    @NonNull
    public final EmptyRecyclerView recyclerView;

    @NonNull
    public final SmartRefreshLayout refresh;

    @NonNull
    public final TextView tvEmptyView;

    public static V2PubRecyclerviewWithEmptyViewBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2PubRecyclerviewWithEmptyViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z5) {
        return inflate(layoutInflater, viewGroup, z5, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static V2PubRecyclerviewWithEmptyViewBinding bind(@NonNull View view, @Nullable Object obj) {
        return (V2PubRecyclerviewWithEmptyViewBinding) ViewDataBinding.bind(obj, view, R.layout.v2_pub_recyclerview_with_empty_view);
    }

    @NonNull
    @Deprecated
    public static V2PubRecyclerviewWithEmptyViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z5, @Nullable Object obj) {
        return (V2PubRecyclerviewWithEmptyViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.v2_pub_recyclerview_with_empty_view, viewGroup, z5, obj);
    }

    protected V2PubRecyclerviewWithEmptyViewBinding(Object obj, View view, int i6, EmptyRecyclerView emptyRecyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView) {
        super(obj, view, i6);
        this.recyclerView = emptyRecyclerView;
        this.refresh = smartRefreshLayout;
        this.tvEmptyView = textView;
    }

    @NonNull
    public static V2PubRecyclerviewWithEmptyViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2PubRecyclerviewWithEmptyViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (V2PubRecyclerviewWithEmptyViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.v2_pub_recyclerview_with_empty_view, null, false, obj);
    }
}
