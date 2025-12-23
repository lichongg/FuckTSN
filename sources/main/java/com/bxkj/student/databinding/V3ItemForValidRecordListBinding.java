package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.student.R;
import com.google.android.material.card.MaterialCardView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V3ItemForValidRecordListBinding extends ViewDataBinding {

    @NonNull
    public final MaterialCardView card1;

    @NonNull
    public final ImageView ivArrow;

    @NonNull
    public final RecyclerView rvTrace;

    @NonNull
    public final TextView tvCountDistance;

    @NonNull
    public final TextView tvCountNumber;

    @NonNull
    public final TextView tvCountTime;

    @NonNull
    public final TextView tvDate;

    public static V3ItemForValidRecordListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3ItemForValidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static V3ItemForValidRecordListBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3ItemForValidRecordListBinding) ViewDataBinding.bind(component, view, R.layout.v3_item_for_valid_record_list);
    }

    @NonNull
    @Deprecated
    public static V3ItemForValidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3ItemForValidRecordListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v3_item_for_valid_record_list, root, attachToRoot, component);
    }

    protected V3ItemForValidRecordListBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialCardView card1, ImageView ivArrow, RecyclerView rvTrace, TextView tvCountDistance, TextView tvCountNumber, TextView tvCountTime, TextView tvDate) {
        super(_bindingComponent, _root, _localFieldCount);
        this.card1 = card1;
        this.ivArrow = ivArrow;
        this.rvTrace = rvTrace;
        this.tvCountDistance = tvCountDistance;
        this.tvCountNumber = tvCountNumber;
        this.tvCountTime = tvCountTime;
        this.tvDate = tvDate;
    }

    @NonNull
    public static V3ItemForValidRecordListBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3ItemForValidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3ItemForValidRecordListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v3_item_for_valid_record_list, null, false, component);
    }
}
