package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.R;
import com.bxkj.student.v2.ui.LoginActivity;
import com.bxkj.student.v2.vm.LoginViewModel;
import com.google.android.material.button.MaterialButton;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V2AcLoginBinding extends ViewDataBinding {

    @NonNull
    public final MaterialButton btAuthCenter;

    @NonNull
    public final MaterialButton btLogin;

    @NonNull
    public final CheckBox cbAgree;

    @NonNull
    public final EditText etAccount;

    @NonNull
    public final EditText etPassword;

    @NonNull
    public final ImageView ivLogo;

    @NonNull
    public final ImageView ivPhone;

    @NonNull
    public final ImageView ivQq;

    @NonNull
    public final ImageView ivWechat;

    @NonNull
    public final LinearLayout llAccount;

    @NonNull
    public final LinearLayout llAgree;

    @NonNull
    public final LinearLayout llPassword;

    @Bindable
    protected LoginActivity mActivity;

    @Bindable
    protected b mLoginInUser;

    @Bindable
    protected LoginViewModel mLoginViewModel;

    @Bindable
    protected String mVersion;

    @NonNull
    public final TextView tvAgree;

    @NonNull
    public final TextView tvFindPassword;

    @NonNull
    public final TextView tvHelp;

    @NonNull
    public final TextView tvLoginHint;

    @NonNull
    public final TextView tvOtherLogin;

    @NonNull
    public final TextView tvSchoolName;

    @NonNull
    public final TextView tvSwitchSchool;

    protected V2AcLoginBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialButton btAuthCenter, MaterialButton btLogin, CheckBox cbAgree, EditText etAccount, EditText etPassword, ImageView ivLogo, ImageView ivPhone, ImageView ivQq, ImageView ivWechat, LinearLayout llAccount, LinearLayout llAgree, LinearLayout llPassword, TextView tvAgree, TextView tvFindPassword, TextView tvHelp, TextView tvLoginHint, TextView tvOtherLogin, TextView tvSchoolName, TextView tvSwitchSchool) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btAuthCenter = btAuthCenter;
        this.btLogin = btLogin;
        this.cbAgree = cbAgree;
        this.etAccount = etAccount;
        this.etPassword = etPassword;
        this.ivLogo = ivLogo;
        this.ivPhone = ivPhone;
        this.ivQq = ivQq;
        this.ivWechat = ivWechat;
        this.llAccount = llAccount;
        this.llAgree = llAgree;
        this.llPassword = llPassword;
        this.tvAgree = tvAgree;
        this.tvFindPassword = tvFindPassword;
        this.tvHelp = tvHelp;
        this.tvLoginHint = tvLoginHint;
        this.tvOtherLogin = tvOtherLogin;
        this.tvSchoolName = tvSchoolName;
        this.tvSwitchSchool = tvSwitchSchool;
    }

    public static V2AcLoginBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2AcLoginBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setActivity(@Nullable LoginActivity activity);

    public abstract void setLoginInUser(@Nullable b loginInUser);

    public abstract void setLoginViewModel(@Nullable LoginViewModel loginViewModel);

    public abstract void setVersion(@Nullable String version);

    @Deprecated
    public static V2AcLoginBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2AcLoginBinding) ViewDataBinding.bind(component, view, R.layout.v2_ac_login);
    }

    @NonNull
    @Deprecated
    public static V2AcLoginBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2AcLoginBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_ac_login, root, attachToRoot, component);
    }

    @Nullable
    public LoginActivity getActivity() {
        return this.mActivity;
    }

    @Nullable
    public b getLoginInUser() {
        return this.mLoginInUser;
    }

    @Nullable
    public LoginViewModel getLoginViewModel() {
        return this.mLoginViewModel;
    }

    @Nullable
    public String getVersion() {
        return this.mVersion;
    }

    @NonNull
    public static V2AcLoginBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2AcLoginBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2AcLoginBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_ac_login, null, false, component);
    }
}
