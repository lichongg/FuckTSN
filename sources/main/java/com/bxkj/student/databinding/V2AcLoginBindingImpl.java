package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.bxkj.student.R;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.LoginActivity;
import com.bxkj.student.v2.vm.LoginViewModel;
import com.google.android.material.button.MaterialButton;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class V2AcLoginBindingImpl extends V2AcLoginBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private InverseBindingListener etAccountandroidTextAttrChanged;
    private InverseBindingListener etPasswordandroidTextAttrChanged;

    @Nullable
    private final View.OnClickListener mCallback11;

    @Nullable
    private final View.OnClickListener mCallback12;

    @Nullable
    private final View.OnClickListener mCallback13;

    @Nullable
    private final View.OnClickListener mCallback14;

    @Nullable
    private final View.OnClickListener mCallback15;

    @Nullable
    private final View.OnClickListener mCallback16;

    @Nullable
    private final View.OnClickListener mCallback17;

    @Nullable
    private final View.OnClickListener mCallback18;
    private long mDirtyFlags;

    @NonNull
    private final NestedScrollView mboundView0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements InverseBindingListener {
        a() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            ObservableField<String> I;
            String textString = TextViewBindingAdapter.getTextString(V2AcLoginBindingImpl.this.etAccount);
            LoginViewModel loginViewModel = V2AcLoginBindingImpl.this.mLoginViewModel;
            if (loginViewModel == null || (I = loginViewModel.I()) == null) {
                return;
            }
            I.set(textString);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements InverseBindingListener {
        b() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            ObservableField<String> G;
            String textString = TextViewBindingAdapter.getTextString(V2AcLoginBindingImpl.this.etPassword);
            LoginViewModel loginViewModel = V2AcLoginBindingImpl.this.mLoginViewModel;
            if (loginViewModel == null || (G = loginViewModel.G()) == null) {
                return;
            }
            G.set(textString);
        }
    }

    public V2AcLoginBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.mDirtyFlags != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64L;
        }
        requestRebind();
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131297182, 12);
        sparseIntArray.put(R.id.tv_login_hint, 13);
        sparseIntArray.put(R.id.ll_account, 14);
        sparseIntArray.put(R.id.ll_password, 15);
        sparseIntArray.put(R.id.ll_agree, 16);
        sparseIntArray.put(2131296716, 17);
        sparseIntArray.put(R.id.tv_agree, 18);
        sparseIntArray.put(R.id.tv_other_login, 19);
    }

    private V2AcLoginBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (MaterialButton) bindings[5], (MaterialButton) bindings[4], (CheckBox) bindings[17], (EditText) bindings[2], (EditText) bindings[3], (ImageView) bindings[12], (ImageView) bindings[11], (ImageView) bindings[10], (ImageView) bindings[9], (LinearLayout) bindings[14], (LinearLayout) bindings[16], (LinearLayout) bindings[15], (TextView) bindings[18], (TextView) bindings[6], (TextView) bindings[7], (TextView) bindings[13], (TextView) bindings[19], (TextView) bindings[1], (TextView) bindings[8]);
        this.etAccountandroidTextAttrChanged = new a();
        this.etPasswordandroidTextAttrChanged = new b();
        this.mDirtyFlags = -1L;
        this.btAuthCenter.setTag(null);
        this.btLogin.setTag(null);
        this.etAccount.setTag(null);
        this.etPassword.setTag(null);
        this.ivPhone.setTag(null);
        this.ivQq.setTag(null);
        this.ivWechat.setTag(null);
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        this.tvFindPassword.setTag(null);
        this.tvHelp.setTag(null);
        this.tvSchoolName.setTag(null);
        this.tvSwitchSchool.setTag(null);
        setRootTag(root);
        this.mCallback17 = new com.bxkj.student.generated.callback.a(this, 7);
        this.mCallback15 = new com.bxkj.student.generated.callback.a(this, 5);
        this.mCallback13 = new com.bxkj.student.generated.callback.a(this, 3);
        this.mCallback11 = new com.bxkj.student.generated.callback.a(this, 1);
        this.mCallback16 = new com.bxkj.student.generated.callback.a(this, 6);
        this.mCallback14 = new com.bxkj.student.generated.callback.a(this, 4);
        this.mCallback12 = new com.bxkj.student.generated.callback.a(this, 2);
        this.mCallback18 = new com.bxkj.student.generated.callback.a(this, 8);
        invalidateAll();
    }

    private boolean onChangeLoginViewModelPassword(ObservableField<String> LoginViewModelPassword, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeLoginViewModelUsername(ObservableField<String> LoginViewModelUsername, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.databinding.V2AcLoginBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return onChangeLoginViewModelUsername((ObservableField) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return onChangeLoginViewModelPassword((ObservableField) object, fieldId);
    }

    @Override // com.bxkj.student.databinding.V2AcLoginBinding
    public void setActivity(@Nullable LoginActivity Activity) {
        this.mActivity = Activity;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V2AcLoginBinding
    public void setLoginInUser(@Nullable com.bxkj.base.v2.data.b LoginInUser) {
        this.mLoginInUser = LoginInUser;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V2AcLoginBinding
    public void setLoginViewModel(@Nullable LoginViewModel LoginViewModel) {
        this.mLoginViewModel = LoginViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (30 == variableId) {
            setVersion((String) variable);
            return true;
        }
        if (15 == variableId) {
            setLoginInUser((com.bxkj.base.v2.data.b) variable);
            return true;
        }
        if (1 == variableId) {
            setActivity((LoginActivity) variable);
            return true;
        }
        if (16 != variableId) {
            return false;
        }
        setLoginViewModel((LoginViewModel) variable);
        return true;
    }

    @Override // com.bxkj.student.databinding.V2AcLoginBinding
    public void setVersion(@Nullable String Version) {
        this.mVersion = Version;
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        switch (sourceId) {
            case 1:
                LoginActivity loginActivity = this.mActivity;
                if (loginActivity != null) {
                    loginActivity.S();
                    break;
                }
                break;
            case 2:
                LoginActivity loginActivity2 = this.mActivity;
                if (loginActivity2 != null) {
                    loginActivity2.T();
                    break;
                }
                break;
            case 3:
                LoginActivity loginActivity3 = this.mActivity;
                if (loginActivity3 != null) {
                    loginActivity3.M();
                    break;
                }
                break;
            case 4:
                LoginActivity loginActivity4 = this.mActivity;
                if (loginActivity4 != null) {
                    loginActivity4.O();
                    break;
                }
                break;
            case 5:
                LoginActivity loginActivity5 = this.mActivity;
                if (loginActivity5 != null) {
                    loginActivity5.e0();
                    break;
                }
                break;
            case 6:
                LoginActivity loginActivity6 = this.mActivity;
                if (loginActivity6 != null) {
                    loginActivity6.a0();
                    break;
                }
                break;
            case 7:
                LoginActivity loginActivity7 = this.mActivity;
                if (loginActivity7 != null) {
                    loginActivity7.X();
                    break;
                }
                break;
            case 8:
                LoginActivity loginActivity8 = this.mActivity;
                if (loginActivity8 != null) {
                    loginActivity8.U();
                    break;
                }
                break;
        }
    }
}
