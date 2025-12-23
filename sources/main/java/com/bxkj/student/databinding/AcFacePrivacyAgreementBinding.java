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
import com.bxkj.base.v2.common.view.b;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class AcFacePrivacyAgreementBinding extends ViewDataBinding {

    @NonNull
    public final Button btAgree;

    @NonNull
    public final Button btRefuse;

    @NonNull
    public final LinearLayout llBottom;

    @Bindable
    protected b mMActivity;

    @NonNull
    public final V2PubTitleBinding titleLayout;

    @NonNull
    public final TextView tvUserAgree;

    @NonNull
    public final TextView tvUserPrivate;

    public static AcFacePrivacyAgreementBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcFacePrivacyAgreementBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setMActivity(@Nullable b mActivity);

    @Deprecated
    public static AcFacePrivacyAgreementBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcFacePrivacyAgreementBinding) ViewDataBinding.bind(component, view, R.layout.ac_face_privacy_agreement);
    }

    @NonNull
    @Deprecated
    public static AcFacePrivacyAgreementBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcFacePrivacyAgreementBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_face_privacy_agreement, root, attachToRoot, component);
    }

    @Nullable
    public b getMActivity() {
        return this.mMActivity;
    }

    protected AcFacePrivacyAgreementBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btAgree, Button btRefuse, LinearLayout llBottom, V2PubTitleBinding titleLayout, TextView tvUserAgree, TextView tvUserPrivate) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btAgree = btAgree;
        this.btRefuse = btRefuse;
        this.llBottom = llBottom;
        this.titleLayout = titleLayout;
        this.tvUserAgree = tvUserAgree;
        this.tvUserPrivate = tvUserPrivate;
    }

    @NonNull
    public static AcFacePrivacyAgreementBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcFacePrivacyAgreementBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcFacePrivacyAgreementBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_face_privacy_agreement, null, false, component);
    }
}
