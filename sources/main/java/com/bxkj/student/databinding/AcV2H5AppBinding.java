package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.v2.common.view.b;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class AcV2H5AppBinding extends ViewDataBinding {

    @Bindable
    protected b mMActivity;

    @Bindable
    protected String mTitle;

    @NonNull
    public final SmartWebView smartWebView;

    @NonNull
    public final V2PubTitleBinding titleLayout;

    public static AcV2H5AppBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV2H5AppBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setMActivity(@Nullable b mActivity);

    public abstract void setTitle(@Nullable String title);

    @Deprecated
    public static AcV2H5AppBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV2H5AppBinding) ViewDataBinding.bind(component, view, R.layout.ac_v2_h5_app);
    }

    @NonNull
    @Deprecated
    public static AcV2H5AppBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV2H5AppBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_v2_h5_app, root, attachToRoot, component);
    }

    @Nullable
    public b getMActivity() {
        return this.mMActivity;
    }

    @Nullable
    public String getTitle() {
        return this.mTitle;
    }

    protected AcV2H5AppBinding(Object _bindingComponent, View _root, int _localFieldCount, SmartWebView smartWebView, V2PubTitleBinding titleLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.smartWebView = smartWebView;
        this.titleLayout = titleLayout;
    }

    @NonNull
    public static AcV2H5AppBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV2H5AppBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV2H5AppBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_v2_h5_app, null, false, component);
    }
}
