package com.bxkj.base.v2.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewbinding.ViewBinding;
import com.bxkj.base.v2.base.BaseViewModel;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class BaseActivity<VB extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity implements j<VB, VM>, com.bxkj.base.v2.common.view.b {
    public FragmentActivity M;
    public Fragment N;
    public Context O;
    public VM P;
    public VB Q;
    public LifecycleOwner R;
    public FragmentManager S;

    @Nullable
    private p T;

    @Override // com.bxkj.base.v2.base.j
    public void C(@Nullable p pVar) {
        this.T = pVar;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public VM D() {
        VM vm = this.P;
        if (vm != null) {
            return vm;
        }
        g0.S("mViewModel");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    public void F(@NotNull FragmentManager fragmentManager) {
        g0.p(fragmentManager, "<set-?>");
        this.S = fragmentManager;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public LifecycleOwner G() {
        LifecycleOwner lifecycleOwner = this.R;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        g0.S("lifecycleOwner");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public Context H() {
        Context context = this.O;
        if (context != null) {
            return context;
        }
        g0.S("mContext");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public FragmentManager J() {
        FragmentManager fragmentManager = this.S;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        g0.S("dialogFagmentManager");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    public void K(@NotNull Context context) {
        g0.p(context, "<set-?>");
        this.O = context;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public VB L() {
        VB vb = this.Q;
        if (vb != null) {
            return vb;
        }
        g0.S("mDataBinding");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    public void a(@NotNull FragmentActivity fragmentActivity) {
        g0.p(fragmentActivity, "<set-?>");
        this.M = fragmentActivity;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public Fragment q() {
        Fragment fragment = this.N;
        if (fragment != null) {
            return fragment;
        }
        g0.S("mFragment");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public FragmentActivity r() {
        FragmentActivity fragmentActivity = this.M;
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        g0.S("mActivity");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    public void s(@NotNull Fragment fragment) {
        g0.p(fragment, "<set-?>");
        this.N = fragment;
    }

    @Override // com.bxkj.base.v2.base.j
    public void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner) {
        g0.p(lifecycleOwner, "<set-?>");
        this.R = lifecycleOwner;
    }

    @Override // com.bxkj.base.v2.base.j
    public void x(@NotNull VM vm) {
        g0.p(vm, "<set-?>");
        this.P = vm;
    }

    @Override // com.bxkj.base.v2.base.j
    @Nullable
    public p y() {
        return this.T;
    }

    @Override // com.bxkj.base.v2.base.j
    public void z(@NotNull VB vb) {
        g0.p(vb, "<set-?>");
        this.Q = vb;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public <VM extends ViewModel> VM B(@NotNull Object obj, @NonNull @NotNull ViewModelStoreOwner viewModelStoreOwner) {
        return (VM) i.d(this, obj, viewModelStoreOwner);
    }

    @Override // com.bxkj.base.v2.base.j
    public void E() {
        i.a(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a(this);
        K(this);
        x(B(this, this));
        LayoutInflater layoutInflater = getLayoutInflater();
        g0.o(layoutInflater, "getLayoutInflater(...)");
        z(v(this, layoutInflater));
        setLifecycleOwner(this);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        g0.o(supportFragmentManager, "getSupportFragmentManager(...)");
        F(supportFragmentManager);
        setContentView(L().getRoot());
        E();
        t();
        p();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
        cn.bluemobi.dylan.base.utils.a.n().c(r());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        cn.bluemobi.dylan.base.utils.a.n().s(r());
        u();
    }

    @Override // com.bxkj.base.v2.base.j
    public void u() {
        i.e(this);
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public <VB extends ViewBinding> VB v(@NotNull Object obj, @NotNull LayoutInflater layoutInflater) {
        return (VB) i.b(this, obj, layoutInflater);
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public <VB extends ViewBinding> VB w(@NotNull Object obj, @NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        return (VB) i.c(this, obj, layoutInflater, viewGroup);
    }
}
