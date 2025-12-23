package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V2ItemForMyMenuBinding extends ViewDataBinding {

    @NonNull
    public final ConstraintLayout clRoot;

    @NonNull
    public final ImageView ivIcon;

    @Bindable
    protected Map<String, Object> mMap;

    @NonNull
    public final TextView tvName;

    public static V2ItemForMyMenuBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2ItemForMyMenuBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setMap(@Nullable Map<String, Object> map);

    @Deprecated
    public static V2ItemForMyMenuBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2ItemForMyMenuBinding) ViewDataBinding.bind(component, view, R.layout.v2_item_for_my_menu);
    }

    @NonNull
    @Deprecated
    public static V2ItemForMyMenuBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2ItemForMyMenuBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_item_for_my_menu, root, attachToRoot, component);
    }

    @Nullable
    public Map<String, Object> getMap() {
        return this.mMap;
    }

    protected V2ItemForMyMenuBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout clRoot, ImageView ivIcon, TextView tvName) {
        super(_bindingComponent, _root, _localFieldCount);
        this.clRoot = clRoot;
        this.ivIcon = ivIcon;
        this.tvName = tvName;
    }

    @NonNull
    public static V2ItemForMyMenuBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2ItemForMyMenuBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2ItemForMyMenuBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_item_for_my_menu, null, false, component);
    }
}
