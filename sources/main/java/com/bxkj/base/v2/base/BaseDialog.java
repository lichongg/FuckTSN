package com.bxkj.base.v2.base;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
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
public abstract class BaseDialog<VB extends ViewDataBinding, VM extends BaseViewModel> extends DialogFragment implements j<VB, VM> {

    /* renamed from: c, reason: collision with root package name */
    public FragmentActivity f16671c;

    /* renamed from: d, reason: collision with root package name */
    public Fragment f16672d;

    /* renamed from: e, reason: collision with root package name */
    public Context f16673e;

    /* renamed from: f, reason: collision with root package name */
    public VM f16674f;

    /* renamed from: g, reason: collision with root package name */
    public VB f16675g;

    /* renamed from: h, reason: collision with root package name */
    public LifecycleOwner f16676h;

    /* renamed from: i, reason: collision with root package name */
    public FragmentManager f16677i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private p f16678j;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(BaseDialog baseDialog, DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
        if (i6 != 4) {
            return false;
        }
        baseDialog.e();
        return true;
    }

    public static /* synthetic */ void k(BaseDialog baseDialog, FragmentManager fragmentManager, String str, boolean z5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
        if ((i6 & 4) != 0) {
            z5 = true;
        }
        baseDialog.i(fragmentManager, str, z5);
    }

    public static /* synthetic */ void l(BaseDialog baseDialog, FragmentManager fragmentManager, boolean z5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
        if ((i6 & 2) != 0) {
            z5 = true;
        }
        baseDialog.j(fragmentManager, z5);
    }

    @Override // com.bxkj.base.v2.base.j
    public void C(@Nullable p pVar) {
        this.f16678j = pVar;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public VM D() {
        VM vm = this.f16674f;
        if (vm != null) {
            return vm;
        }
        g0.S("mViewModel");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    public void F(@NotNull FragmentManager fragmentManager) {
        g0.p(fragmentManager, "<set-?>");
        this.f16677i = fragmentManager;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public LifecycleOwner G() {
        LifecycleOwner lifecycleOwner = this.f16676h;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        g0.S("lifecycleOwner");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public Context H() {
        Context context = this.f16673e;
        if (context != null) {
            return context;
        }
        g0.S("mContext");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public FragmentManager J() {
        FragmentManager fragmentManager = this.f16677i;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        g0.S("dialogFagmentManager");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    public void K(@NotNull Context context) {
        g0.p(context, "<set-?>");
        this.f16673e = context;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public VB L() {
        VB vb = this.f16675g;
        if (vb != null) {
            return vb;
        }
        g0.S("mDataBinding");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    public void a(@NotNull FragmentActivity fragmentActivity) {
        g0.p(fragmentActivity, "<set-?>");
        this.f16671c = fragmentActivity;
    }

    public final void h(@NotNull FragmentManager fragmentManager) {
        g0.p(fragmentManager, "fragmentManager");
        i(fragmentManager, "TSNDialog", true);
    }

    public final void i(@NotNull FragmentManager fragmentManager, @Nullable String str, boolean z5) {
        g0.p(fragmentManager, "fragmentManager");
        try {
            if (fragmentManager.isDestroyed()) {
                return;
            }
            setCancelable(z5);
            if (isAdded() || isVisible() || isRemoving()) {
                return;
            }
            super.showNow(fragmentManager, str);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public final void j(@NotNull FragmentManager fragmentManager, boolean z5) {
        g0.p(fragmentManager, "fragmentManager");
        i(fragmentManager, "TSNDialog", z5);
    }

    public final void m(@NotNull FragmentManager fragmentManager) {
        g0.p(fragmentManager, "fragmentManager");
        i(fragmentManager, "TSNDialog", true);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Window window;
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
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.requestFeature(1);
        }
        E();
        t();
        p();
        c();
        return L().getRoot();
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public Fragment q() {
        Fragment fragment = this.f16672d;
        if (fragment != null) {
            return fragment;
        }
        g0.S("mFragment");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    @NotNull
    public FragmentActivity r() {
        FragmentActivity fragmentActivity = this.f16671c;
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        g0.S("mActivity");
        return null;
    }

    @Override // com.bxkj.base.v2.base.j
    public void s(@NotNull Fragment fragment) {
        g0.p(fragment, "<set-?>");
        this.f16672d = fragment;
    }

    @Override // com.bxkj.base.v2.base.j
    public void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner) {
        g0.p(lifecycleOwner, "<set-?>");
        this.f16676h = lifecycleOwner;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(@NotNull FragmentManager manager, @Nullable String str) {
        g0.p(manager, "manager");
        i(manager, "TSNDialog", true);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void showNow(@NotNull FragmentManager manager, @Nullable String str) {
        g0.p(manager, "manager");
        i(manager, "TSNDialog", true);
    }

    @Override // com.bxkj.base.v2.base.j
    public void x(@NotNull VM vm) {
        g0.p(vm, "<set-?>");
        this.f16674f = vm;
    }

    @Override // com.bxkj.base.v2.base.j
    @Nullable
    public p y() {
        return this.f16678j;
    }

    @Override // com.bxkj.base.v2.base.j
    public void z(@NotNull VB vb) {
        g0.p(vb, "<set-?>");
        this.f16675g = vb;
    }

    private final void c() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bxkj.base.v2.base.b
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
                    boolean d6;
                    d6 = BaseDialog.d(BaseDialog.this, dialogInterface, i6, keyEvent);
                    return d6;
                }
            });
        }
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

    public final void f() {
        if (isAdded() && getActivity() != null && !isRemoving()) {
            if (isStateSaved()) {
                dismissAllowingStateLoss();
            } else {
                dismiss();
            }
        }
    }

    public final void g() {
        FragmentActivity requireActivity = requireActivity();
        g0.o(requireActivity, "requireActivity(...)");
        x(B(this, requireActivity));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
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

    protected void e() {
    }
}
