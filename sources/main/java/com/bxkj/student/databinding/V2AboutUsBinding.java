package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.v2.common.view.b;
import com.bxkj.student.R;
import com.bxkj.student.common.view.ToggleButton;
import com.bxkj.student.v2.ui.my.AboutUsActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V2AboutUsBinding extends ViewDataBinding {

    @NonNull
    public final FrameLayout flTop;

    @NonNull
    public final V2PubTitleBinding includeTitle;

    @NonNull
    public final ImageView ivIcon;

    @NonNull
    public final ImageView ivLogo;

    @Bindable
    protected AboutUsActivity mActivity;

    @Bindable
    protected b mBackEvent;

    @Bindable
    protected String mTitle;

    @NonNull
    public final ToggleButton tagFloatButton;

    @NonNull
    public final TextView tvName;

    @NonNull
    public final TextView tvVersion;

    public static V2AboutUsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2AboutUsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setActivity(@Nullable AboutUsActivity activity);

    public abstract void setBackEvent(@Nullable b backEvent);

    public abstract void setTitle(@Nullable String title);

    @Deprecated
    public static V2AboutUsBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2AboutUsBinding) ViewDataBinding.bind(component, view, R.layout.v2_about_us);
    }

    @NonNull
    @Deprecated
    public static V2AboutUsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2AboutUsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_about_us, root, attachToRoot, component);
    }

    @Nullable
    public AboutUsActivity getActivity() {
        return this.mActivity;
    }

    @Nullable
    public b getBackEvent() {
        return this.mBackEvent;
    }

    @Nullable
    public String getTitle() {
        return this.mTitle;
    }

    protected V2AboutUsBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout flTop, V2PubTitleBinding includeTitle, ImageView ivIcon, ImageView ivLogo, ToggleButton tagFloatButton, TextView tvName, TextView tvVersion) {
        super(_bindingComponent, _root, _localFieldCount);
        this.flTop = flTop;
        this.includeTitle = includeTitle;
        this.ivIcon = ivIcon;
        this.ivLogo = ivLogo;
        this.tagFloatButton = tagFloatButton;
        this.tvName = tvName;
        this.tvVersion = tvVersion;
    }

    @NonNull
    public static V2AboutUsBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2AboutUsBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2AboutUsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_about_us, null, false, component);
    }
}
