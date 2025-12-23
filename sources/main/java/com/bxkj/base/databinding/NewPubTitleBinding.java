package com.bxkj.base.databinding;

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
import com.bxkj.base.R;
import com.bxkj.base.v2.common.view.b;
import com.bxkj.base.view.MarqueeTextView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class NewPubTitleBinding extends ViewDataBinding {

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

    public static NewPubTitleBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static NewPubTitleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z5) {
        return inflate(layoutInflater, viewGroup, z5, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setActivity(@Nullable b bVar);

    public abstract void setIsHideBack(@Nullable Boolean bool);

    public abstract void setTitle(@Nullable String str);

    @Deprecated
    public static NewPubTitleBinding bind(@NonNull View view, @Nullable Object obj) {
        return (NewPubTitleBinding) ViewDataBinding.bind(obj, view, R.layout.new_pub_title);
    }

    @NonNull
    @Deprecated
    public static NewPubTitleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z5, @Nullable Object obj) {
        return (NewPubTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.new_pub_title, viewGroup, z5, obj);
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

    protected NewPubTitleBinding(Object obj, View view, int i6, AppCompatImageButton appCompatImageButton, ConstraintLayout constraintLayout, Toolbar toolbar, MarqueeTextView marqueeTextView) {
        super(obj, view, i6);
        this.ibBack = appCompatImageButton;
        this.llTitle = constraintLayout;
        this.toolbar = toolbar;
        this.tvTitle = marqueeTextView;
    }

    @NonNull
    public static NewPubTitleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static NewPubTitleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (NewPubTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.new_pub_title, null, false, obj);
    }
}
