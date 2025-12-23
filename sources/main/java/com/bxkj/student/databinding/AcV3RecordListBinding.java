package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.R;
import com.bxkj.student.v2.ui.sports.v3.record.V3RecordListActivity;
import com.google.android.material.tabs.TabLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class AcV3RecordListBinding extends ViewDataBinding {

    @NonNull
    public final AppCompatImageButton ibBack;

    @NonNull
    public final AppCompatImageView ivSet;

    @NonNull
    public final LinearLayout llContent;

    @Bindable
    protected V3RecordListActivity mMActivity;

    @NonNull
    public final TabLayout tb;

    @NonNull
    public final MarqueeTextView tvTitle;

    public static AcV3RecordListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV3RecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setMActivity(@Nullable V3RecordListActivity mActivity);

    @Deprecated
    public static AcV3RecordListBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV3RecordListBinding) ViewDataBinding.bind(component, view, R.layout.ac_v3_record_list);
    }

    @NonNull
    @Deprecated
    public static AcV3RecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV3RecordListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_v3_record_list, root, attachToRoot, component);
    }

    @Nullable
    public V3RecordListActivity getMActivity() {
        return this.mMActivity;
    }

    protected AcV3RecordListBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatImageButton ibBack, AppCompatImageView ivSet, LinearLayout llContent, TabLayout tb, MarqueeTextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ibBack = ibBack;
        this.ivSet = ivSet;
        this.llContent = llContent;
        this.tb = tb;
        this.tvTitle = tvTitle;
    }

    @NonNull
    public static AcV3RecordListBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV3RecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV3RecordListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_v3_record_list, null, false, component);
    }
}
