package com.bxkj.base.v2.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewbinding.ViewBinding;
import com.bxkj.base.v2.base.BaseViewModel;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBaseFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseFragment.kt\ncom/bxkj/base/v2/base/BaseFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,66:1\n1#2:67\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class BaseFragment<VB extends ViewDataBinding, VM extends BaseViewModel> extends Fragment implements j<VB, VM> {

    /* renamed from: c, reason: collision with root package name */
    public FragmentActivity f16679c;

    /* renamed from: d, reason: collision with root package name */
    public Fragment f16680d;

    /* renamed from: e, reason: collision with root package name */
    public Context f16681e;

    /* renamed from: f, reason: collision with root package name */
    public VM f16682f;

    /* renamed from: g, reason: collision with root package name */
    public VB f16683g;

    /* renamed from: h, reason: collision with root package name */
    public LifecycleOwner f16684h;

    /* renamed from: i, reason: collision with root package name */
    public FragmentManager f16685i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private p f16686j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f16687k;

    @Override // com.bxkj.base.v2.base.j
    public void C(@Nullable p pVar) {
        this.f16686j = pVar;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public VM D() {
        VM vm = this.f16682f;
        if (vm != null) {
            return vm;
        }
        g0.S("mViewModel");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    public void F(@NotNull FragmentManager fragmentManager) {
        g0.p(fragmentManager, "<set-?>");
        this.f16685i = fragmentManager;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public LifecycleOwner G() {
        LifecycleOwner lifecycleOwner = this.f16684h;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        g0.S("lifecycleOwner");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public Context H() {
        Context context = this.f16681e;
        if (context != null) {
            return context;
        }
        g0.S("mContext");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public FragmentManager J() {
        FragmentManager fragmentManager = this.f16685i;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        g0.S("dialogFagmentManager");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    public void K(@NotNull Context context) {
        g0.p(context, "<set-?>");
        this.f16681e = context;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public VB L() {
        VB vb = this.f16683g;
        if (vb != null) {
            return vb;
        }
        g0.S("mDataBinding");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    public void a(@NotNull FragmentActivity fragmentActivity) {
        g0.p(fragmentActivity, "<set-?>");
        this.f16679c = fragmentActivity;
    }

    public final boolean b() {
        return this.f16687k;
    }

    public final void c(boolean z5) {
        this.f16687k = z5;
    }

    public final void d(@NotNull ViewModelStoreOwner owner) {
        g0.p(owner, "owner");
        x(B(this, owner));
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        g0.p(inflater, "inflater");
        FragmentActivity requireActivity = requireActivity();
        g0.o(requireActivity, "requireActivity(...)");
        a(requireActivity);
        Context requireContext = requireContext();
        g0.o(requireContext, "requireContext(...)");
        K(requireContext);
        s(this);
        x(B(this, this));
        z(w(this, inflater, viewGroup));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        g0.o(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        setLifecycleOwner(viewLifecycleOwner);
        FragmentManager childFragmentManager = getChildFragmentManager();
        g0.o(childFragmentManager, "getChildFragmentManager(...)");
        F(childFragmentManager);
        E();
        t();
        p();
        cn.bluemobi.dylan.base.utils.a.n().d(q());
        this.f16687k = true;
        return L().getRoot();
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public Fragment q() {
        Fragment fragment = this.f16680d;
        if (fragment != null) {
            return fragment;
        }
        g0.S("mFragment");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public FragmentActivity r() {
        FragmentActivity fragmentActivity = this.f16679c;
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        g0.S("mActivity");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    public void s(@NotNull Fragment fragment) {
        g0.p(fragment, "<set-?>");
        this.f16680d = fragment;
    }

    @Override // com.bxkj.base.v2.base.j
    public void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner) {
        g0.p(lifecycleOwner, "<set-?>");
        this.f16684h = lifecycleOwner;
    }

    @Override // com.bxkj.base.v2.base.j
    public void x(@NotNull VM vm) {
        g0.p(vm, "<set-?>");
        this.f16682f = vm;
    }

    @Override // com.bxkj.base.v2.base.j
    @Nullable
    public p y() {
        return this.f16686j;
    }

    @Override // com.bxkj.base.v2.base.j
    public void z(@NotNull VB vb) {
        g0.p(vb, "<set-?>");
        this.f16683g = vb;
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

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        BaseFragment<VB, VM> baseFragment;
        Fragment q5;
        super.onDestroy();
        if (this.f16680d != null) {
            baseFragment = this;
        } else {
            baseFragment = null;
        }
        if (baseFragment != null && (q5 = baseFragment.q()) != null) {
            cn.bluemobi.dylan.base.utils.a.n().t(q5);
        }
        u();
        this.f16687k = false;
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
