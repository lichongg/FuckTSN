package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V2ItemForClassifyTitleBinding extends ViewDataBinding {

    @NonNull
    public final TextView tvName;

    public static V2ItemForClassifyTitleBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2ItemForClassifyTitleBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static V2ItemForClassifyTitleBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2ItemForClassifyTitleBinding) ViewDataBinding.bind(component, view, R.layout.v2_item_for_classify_title);
    }

    @NonNull
    @Deprecated
    public static V2ItemForClassifyTitleBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2ItemForClassifyTitleBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_item_for_classify_title, root, attachToRoot, component);
    }

    protected V2ItemForClassifyTitleBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView tvName) {
        super(_bindingComponent, _root, _localFieldCount);
        this.tvName = tvName;
    }

    @NonNull
    public static V2ItemForClassifyTitleBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2ItemForClassifyTitleBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2ItemForClassifyTitleBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_item_for_classify_title, null, false, component);
    }
}
