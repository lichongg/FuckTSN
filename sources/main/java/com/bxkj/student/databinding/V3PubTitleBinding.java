package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.v2.common.view.b;
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V3PubTitleBinding extends ViewDataBinding {

    @NonNull
    public final AppCompatImageButton ibBack;

    @NonNull
    public final ConstraintLayout llTitle;

    @Bindable
    protected b mActivity;

    @Bindable
    protected Boolean mIsHideBack;

    @Bindable
    protected String mTitle;

    @NonNull
    public final Toolbar toolbar;

    @NonNull
    public final MarqueeTextView tvTitle;

    public static V3PubTitleBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3PubTitleBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setActivity(@Nullable b activity);

    public abstract void setIsHideBack(@Nullable Boolean isHideBack);

    public abstract void setTitle(@Nullable String title);

    @Deprecated
    public static V3PubTitleBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3PubTitleBinding) ViewDataBinding.bind(component, view, R.layout.v3_pub_title);
    }

    @NonNull
    @Deprecated
    public static V3PubTitleBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3PubTitleBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v3_pub_title, root, attachToRoot, component);
    }

    @Nullable
    public b getActivity() {
        return this.mActivity;
    }

    @Nullable
    public Boolean getIsHideBack() {
        return this.mIsHideBack;
    }

    @Nullable
    public String getTitle() {
        return this.mTitle;
    }

    protected V3PubTitleBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatImageButton ibBack, ConstraintLayout llTitle, Toolbar toolbar, MarqueeTextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ibBack = ibBack;
        this.llTitle = llTitle;
        this.toolbar = toolbar;
        this.tvTitle = tvTitle;
    }

    @NonNull
    public static V3PubTitleBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3PubTitleBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3PubTitleBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v3_pub_title, null, false, component);
    }
}
