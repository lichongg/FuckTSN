package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;
import com.bxkj.student.v2.ui.dialog.TipsDialog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class TipsDialogBinding extends ViewDataBinding {

    @Bindable
    protected TipsDialog mDialog;

    @NonNull
    public final CardView rlThreetwoone;

    @NonNull
    public final TextView tvMsg;

    public static TipsDialogBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static TipsDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setDialog(@Nullable TipsDialog dialog);

    @Deprecated
    public static TipsDialogBinding bind(@NonNull View view, @Nullable Object component) {
        return (TipsDialogBinding) ViewDataBinding.bind(component, view, R.layout.tips_dialog);
    }

    @NonNull
    @Deprecated
    public static TipsDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (TipsDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.tips_dialog, root, attachToRoot, component);
    }

    @Nullable
    public TipsDialog getDialog() {
        return this.mDialog;
    }

    protected TipsDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView rlThreetwoone, TextView tvMsg) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rlThreetwoone = rlThreetwoone;
        this.tvMsg = tvMsg;
    }

    @NonNull
    public static TipsDialogBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static TipsDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (TipsDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.tips_dialog, null, false, component);
    }
}
