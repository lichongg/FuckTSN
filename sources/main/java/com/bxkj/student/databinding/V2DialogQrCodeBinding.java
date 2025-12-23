package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V2DialogQrCodeBinding extends ViewDataBinding {

    @NonNull
    public final ImageView iv;

    @NonNull
    public final FrameLayout root;

    public static V2DialogQrCodeBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2DialogQrCodeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static V2DialogQrCodeBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2DialogQrCodeBinding) ViewDataBinding.bind(component, view, R.layout.v2_dialog_qr_code);
    }

    @NonNull
    @Deprecated
    public static V2DialogQrCodeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2DialogQrCodeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_dialog_qr_code, root, attachToRoot, component);
    }

    protected V2DialogQrCodeBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView iv, FrameLayout root) {
        super(_bindingComponent, _root, _localFieldCount);
        this.iv = iv;
        this.root = root;
    }

    @NonNull
    public static V2DialogQrCodeBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2DialogQrCodeBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2DialogQrCodeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_dialog_qr_code, null, false, component);
    }
}
