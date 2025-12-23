package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class AcSplashBinding extends ViewDataBinding {

    @NonNull
    public final FrameLayout adsFl;

    @NonNull
    public final ImageView ivLogo;

    @NonNull
    public final TextView tvSchoolName;

    @NonNull
    public final TextView tvTime;

    public static AcSplashBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcSplashBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AcSplashBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcSplashBinding) ViewDataBinding.bind(component, view, R.layout.ac_splash);
    }

    @NonNull
    @Deprecated
    public static AcSplashBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcSplashBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_splash, root, attachToRoot, component);
    }

    protected AcSplashBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout adsFl, ImageView ivLogo, TextView tvSchoolName, TextView tvTime) {
        super(_bindingComponent, _root, _localFieldCount);
        this.adsFl = adsFl;
        this.ivLogo = ivLogo;
        this.tvSchoolName = tvSchoolName;
        this.tvTime = tvTime;
    }

    @NonNull
    public static AcSplashBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcSplashBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcSplashBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_splash, null, false, component);
    }
}
