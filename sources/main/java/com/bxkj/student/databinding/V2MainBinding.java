package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V2MainBinding extends ViewDataBinding {

    @NonNull
    public final FrameLayout flContent;

    @NonNull
    public final BottomNavigationView navView;

    public static V2MainBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2MainBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static V2MainBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2MainBinding) ViewDataBinding.bind(component, view, R.layout.v2_main);
    }

    @NonNull
    @Deprecated
    public static V2MainBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2MainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_main, root, attachToRoot, component);
    }

    protected V2MainBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout flContent, BottomNavigationView navView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.flContent = flContent;
        this.navView = navView;
    }

    @NonNull
    public static V2MainBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2MainBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2MainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_main, null, false, component);
    }
}
