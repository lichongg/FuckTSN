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
import com.google.android.material.imageview.ShapeableImageView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class ItemForV3PassPointDialogBinding extends ViewDataBinding {

    @NonNull
    public final ShapeableImageView ivPoint;

    @NonNull
    public final TextView tvPoint;

    public static ItemForV3PassPointDialogBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemForV3PassPointDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemForV3PassPointDialogBinding bind(@NonNull View view, @Nullable Object component) {
        return (ItemForV3PassPointDialogBinding) ViewDataBinding.bind(component, view, R.layout.item_for_v3_pass_point_dialog);
    }

    @NonNull
    @Deprecated
    public static ItemForV3PassPointDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (ItemForV3PassPointDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_for_v3_pass_point_dialog, root, attachToRoot, component);
    }

    protected ItemForV3PassPointDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, ShapeableImageView ivPoint, TextView tvPoint) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivPoint = ivPoint;
        this.tvPoint = tvPoint;
    }

    @NonNull
    public static ItemForV3PassPointDialogBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemForV3PassPointDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (ItemForV3PassPointDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_for_v3_pass_point_dialog, null, false, component);
    }
}
