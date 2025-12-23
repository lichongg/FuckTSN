package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;
import com.bxkj.student.v2.ui.dialog.FaceOutDialog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class FaceOutOfCompassBinding extends ViewDataBinding {

    @NonNull
    public final Button btnOne;

    @NonNull
    public final Button btnTwo;

    @NonNull
    public final LinearLayout layTwoButton;

    @NonNull
    public final View lineTitle;

    @Bindable
    protected FaceOutDialog mDialog;

    @NonNull
    public final TextView textMessage;

    @NonNull
    public final TextView tvTitle;

    public static FaceOutOfCompassBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FaceOutOfCompassBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setDialog(@Nullable FaceOutDialog dialog);

    @Deprecated
    public static FaceOutOfCompassBinding bind(@NonNull View view, @Nullable Object component) {
        return (FaceOutOfCompassBinding) ViewDataBinding.bind(component, view, R.layout.face_out_of_compass);
    }

    @NonNull
    @Deprecated
    public static FaceOutOfCompassBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (FaceOutOfCompassBinding) ViewDataBinding.inflateInternal(inflater, R.layout.face_out_of_compass, root, attachToRoot, component);
    }

    @Nullable
    public FaceOutDialog getDialog() {
        return this.mDialog;
    }

    protected FaceOutOfCompassBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btnOne, Button btnTwo, LinearLayout layTwoButton, View lineTitle, TextView textMessage, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnOne = btnOne;
        this.btnTwo = btnTwo;
        this.layTwoButton = layTwoButton;
        this.lineTitle = lineTitle;
        this.textMessage = textMessage;
        this.tvTitle = tvTitle;
    }

    @NonNull
    public static FaceOutOfCompassBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FaceOutOfCompassBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (FaceOutOfCompassBinding) ViewDataBinding.inflateInternal(inflater, R.layout.face_out_of_compass, null, false, component);
    }
}
