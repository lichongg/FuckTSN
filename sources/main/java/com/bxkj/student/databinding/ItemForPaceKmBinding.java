package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class ItemForPaceKmBinding extends ViewDataBinding {

    @NonNull
    public final ProgressBar pbDistance;

    @NonNull
    public final TextView tvAvgPaceHint;

    @NonNull
    public final TextView tvNumber;

    public static ItemForPaceKmBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemForPaceKmBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemForPaceKmBinding bind(@NonNull View view, @Nullable Object component) {
        return (ItemForPaceKmBinding) ViewDataBinding.bind(component, view, R.layout.item_for_pace_km);
    }

    @NonNull
    @Deprecated
    public static ItemForPaceKmBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (ItemForPaceKmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_for_pace_km, root, attachToRoot, component);
    }

    protected ItemForPaceKmBinding(Object _bindingComponent, View _root, int _localFieldCount, ProgressBar pbDistance, TextView tvAvgPaceHint, TextView tvNumber) {
        super(_bindingComponent, _root, _localFieldCount);
        this.pbDistance = pbDistance;
        this.tvAvgPaceHint = tvAvgPaceHint;
        this.tvNumber = tvNumber;
    }

    @NonNull
    public static ItemForPaceKmBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemForPaceKmBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (ItemForPaceKmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_for_pace_km, null, false, component);
    }
}
