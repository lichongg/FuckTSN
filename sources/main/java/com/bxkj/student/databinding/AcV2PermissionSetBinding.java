package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.student.R;
import com.bxkj.student.v2.ui.sports.set.PermissionSetActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class AcV2PermissionSetBinding extends ViewDataBinding {

    @NonNull
    public final Button btFastSet;

    @NonNull
    public final CardView cardBatteryOptimizations;

    @NonNull
    public final CardView cardGpsAlways;

    @NonNull
    public final CardView cardSaveModel;

    @NonNull
    public final CardView cardWhy;

    @Bindable
    protected PermissionSetActivity mMActivity;

    @NonNull
    public final SmartWebView sw;

    @NonNull
    public final V3PubTitleBinding titleLayout;

    @NonNull
    public final TextView tvHint;

    @NonNull
    public final TextView tvHint2;

    public static AcV2PermissionSetBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV2PermissionSetBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setMActivity(@Nullable PermissionSetActivity mActivity);

    @Deprecated
    public static AcV2PermissionSetBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV2PermissionSetBinding) ViewDataBinding.bind(component, view, R.layout.ac_v2_permission_set);
    }

    @NonNull
    @Deprecated
    public static AcV2PermissionSetBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV2PermissionSetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_v2_permission_set, root, attachToRoot, component);
    }

    @Nullable
    public PermissionSetActivity getMActivity() {
        return this.mMActivity;
    }

    protected AcV2PermissionSetBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btFastSet, CardView cardBatteryOptimizations, CardView cardGpsAlways, CardView cardSaveModel, CardView cardWhy, SmartWebView sw, V3PubTitleBinding titleLayout, TextView tvHint, TextView tvHint2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btFastSet = btFastSet;
        this.cardBatteryOptimizations = cardBatteryOptimizations;
        this.cardGpsAlways = cardGpsAlways;
        this.cardSaveModel = cardSaveModel;
        this.cardWhy = cardWhy;
        this.sw = sw;
        this.titleLayout = titleLayout;
        this.tvHint = tvHint;
        this.tvHint2 = tvHint2;
    }

    @NonNull
    public static AcV2PermissionSetBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV2PermissionSetBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV2PermissionSetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_v2_permission_set, null, false, component);
    }
}
