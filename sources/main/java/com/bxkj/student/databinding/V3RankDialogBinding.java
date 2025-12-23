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
import com.bxkj.student.v2.ui.sports.v3.detail.V3RankTipsDialog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V3RankDialogBinding extends ViewDataBinding {

    @Bindable
    protected V3RankTipsDialog mDialog;

    @NonNull
    public final CardView rlThreetwoone;

    @NonNull
    public final TextView tvMsg;

    public static V3RankDialogBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3RankDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setDialog(@Nullable V3RankTipsDialog dialog);

    @Deprecated
    public static V3RankDialogBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3RankDialogBinding) ViewDataBinding.bind(component, view, R.layout.v3_rank_dialog);
    }

    @NonNull
    @Deprecated
    public static V3RankDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3RankDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v3_rank_dialog, root, attachToRoot, component);
    }

    @Nullable
    public V3RankTipsDialog getDialog() {
        return this.mDialog;
    }

    protected V3RankDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView rlThreetwoone, TextView tvMsg) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rlThreetwoone = rlThreetwoone;
        this.tvMsg = tvMsg;
    }

    @NonNull
    public static V3RankDialogBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3RankDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3RankDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v3_rank_dialog, null, false, component);
    }
}
