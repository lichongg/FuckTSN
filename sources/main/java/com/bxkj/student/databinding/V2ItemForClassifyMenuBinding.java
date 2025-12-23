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
import com.bxkj.base.v2.data.b;
import com.bxkj.student.R;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V2ItemForClassifyMenuBinding extends ViewDataBinding {

    @NonNull
    public final ImageView ivIcon;

    @NonNull
    public final ImageView ivOp;

    @Bindable
    protected b mLoggedInUser;

    @Bindable
    protected Map<String, Object> mMap;

    @NonNull
    public final TextView tvName;

    public static V2ItemForClassifyMenuBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2ItemForClassifyMenuBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setLoggedInUser(@Nullable b loggedInUser);

    public abstract void setMap(@Nullable Map<String, Object> map);

    @Deprecated
    public static V2ItemForClassifyMenuBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2ItemForClassifyMenuBinding) ViewDataBinding.bind(component, view, R.layout.v2_item_for_classify_menu);
    }

    @NonNull
    @Deprecated
    public static V2ItemForClassifyMenuBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2ItemForClassifyMenuBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_item_for_classify_menu, root, attachToRoot, component);
    }

    @Nullable
    public b getLoggedInUser() {
        return this.mLoggedInUser;
    }

    @Nullable
    public Map<String, Object> getMap() {
        return this.mMap;
    }

    protected V2ItemForClassifyMenuBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivIcon, ImageView ivOp, TextView tvName) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivIcon = ivIcon;
        this.ivOp = ivOp;
        this.tvName = tvName;
    }

    @NonNull
    public static V2ItemForClassifyMenuBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2ItemForClassifyMenuBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2ItemForClassifyMenuBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_item_for_classify_menu, null, false, component);
    }
}
