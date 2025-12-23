package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;
import com.bxkj.student.v2.ui.face.FaceAgreementActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class AcFaceAgreementBinding extends ViewDataBinding {

    @NonNull
    public final Button btAgree;

    @NonNull
    public final Button btRefuse;

    @NonNull
    public final LinearLayout llBottom;

    @NonNull
    public final V2PubTitleBinding llTitle;

    @Bindable
    protected FaceAgreementActivity mActivity;

    public static AcFaceAgreementBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcFaceAgreementBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setActivity(@Nullable FaceAgreementActivity activity);

    @Deprecated
    public static AcFaceAgreementBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcFaceAgreementBinding) ViewDataBinding.bind(component, view, R.layout.ac_face_agreement);
    }

    @NonNull
    @Deprecated
    public static AcFaceAgreementBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcFaceAgreementBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_face_agreement, root, attachToRoot, component);
    }

    @Nullable
    public FaceAgreementActivity getActivity() {
        return this.mActivity;
    }

    protected AcFaceAgreementBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btAgree, Button btRefuse, LinearLayout llBottom, V2PubTitleBinding llTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btAgree = btAgree;
        this.btRefuse = btRefuse;
        this.llBottom = llBottom;
        this.llTitle = llTitle;
    }

    @NonNull
    public static AcFaceAgreementBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcFaceAgreementBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcFaceAgreementBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_face_agreement, null, false, component);
    }
}
