package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.v2.common.view.EmptyRecyclerView;
import com.bxkj.student.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V3FmValidRecordListBinding extends ViewDataBinding {

    @NonNull
    public final EmptyRecyclerView recyclerView;

    @NonNull
    public final SmartRefreshLayout refresh;

    public static V3FmValidRecordListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3FmValidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static V3FmValidRecordListBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3FmValidRecordListBinding) ViewDataBinding.bind(component, view, R.layout.v3_fm_valid_record_list);
    }

    @NonNull
    @Deprecated
    public static V3FmValidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3FmValidRecordListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v3_fm_valid_record_list, root, attachToRoot, component);
    }

    protected V3FmValidRecordListBinding(Object _bindingComponent, View _root, int _localFieldCount, EmptyRecyclerView recyclerView, SmartRefreshLayout refresh) {
        super(_bindingComponent, _root, _localFieldCount);
        this.recyclerView = recyclerView;
        this.refresh = refresh;
    }

    @NonNull
    public static V3FmValidRecordListBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3FmValidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3FmValidRecordListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v3_fm_valid_record_list, null, false, component);
    }
}
