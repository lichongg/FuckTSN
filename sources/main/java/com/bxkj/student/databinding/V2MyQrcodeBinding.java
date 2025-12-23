package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.v2.common.view.b;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V2MyQrcodeBinding extends ViewDataBinding {

    @NonNull
    public final V2PubTitleBinding includeTitle;

    @NonNull
    public final ImageView ivBar;

    @NonNull
    public final ImageView ivCode;

    @Bindable
    protected b mBackEvent;

    @Bindable
    protected String mTitle;

    @NonNull
    public final TextView tvName;

    @NonNull
    public final TextView tvQrcodeTitle;

    public static V2MyQrcodeBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2MyQrcodeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setBackEvent(@Nullable b backEvent);

    public abstract void setTitle(@Nullable String title);

    @Deprecated
    public static V2MyQrcodeBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2MyQrcodeBinding) ViewDataBinding.bind(component, view, R.layout.v2_my_qrcode);
    }

    @NonNull
    @Deprecated
    public static V2MyQrcodeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2MyQrcodeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_my_qrcode, root, attachToRoot, component);
    }

    @Nullable
    public b getBackEvent() {
        return this.mBackEvent;
    }

    @Nullable
    public String getTitle() {
        return this.mTitle;
    }

    protected V2MyQrcodeBinding(Object _bindingComponent, View _root, int _localFieldCount, V2PubTitleBinding includeTitle, ImageView ivBar, ImageView ivCode, TextView tvName, TextView tvQrcodeTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.includeTitle = includeTitle;
        this.ivBar = ivBar;
        this.ivCode = ivCode;
        this.tvName = tvName;
        this.tvQrcodeTitle = tvQrcodeTitle;
    }

    @NonNull
    public static V2MyQrcodeBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2MyQrcodeBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2MyQrcodeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_my_qrcode, null, false, component);
    }
}
