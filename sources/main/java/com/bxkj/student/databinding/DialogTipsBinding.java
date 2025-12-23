package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;
import com.bxkj.student.v2.ui.dialog.NoticeDialog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class DialogTipsBinding extends ViewDataBinding {

    @NonNull
    public final AppCompatButton bt;

    @NonNull
    public final View divider;

    @NonNull
    public final ImageView iv;

    @NonNull
    public final LinearLayout llMsg;

    @Bindable
    protected NoticeDialog mDialog;

    @NonNull
    public final TextView tvContent;

    @NonNull
    public final TextView tvTitle;

    public static DialogTipsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogTipsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setDialog(@Nullable NoticeDialog dialog);

    @Deprecated
    public static DialogTipsBinding bind(@NonNull View view, @Nullable Object component) {
        return (DialogTipsBinding) ViewDataBinding.bind(component, view, R.layout.dialog_tips);
    }

    @NonNull
    @Deprecated
    public static DialogTipsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (DialogTipsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_tips, root, attachToRoot, component);
    }

    @Nullable
    public NoticeDialog getDialog() {
        return this.mDialog;
    }

    protected DialogTipsBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatButton bt, View divider, ImageView iv, LinearLayout llMsg, TextView tvContent, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bt = bt;
        this.divider = divider;
        this.iv = iv;
        this.llMsg = llMsg;
        this.tvContent = tvContent;
        this.tvTitle = tvTitle;
    }

    @NonNull
    public static DialogTipsBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogTipsBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (DialogTipsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_tips, null, false, component);
    }
}
