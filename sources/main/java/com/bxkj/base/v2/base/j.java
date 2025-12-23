package com.bxkj.base.v2.base;

import android.content.Context;
import android.view.LayoutInflater;
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
@SourceDebugExtension({"SMAP\nBaseUI.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseUI.kt\ncom/bxkj/base/v2/base/BaseUI\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,163:1\n4225#2,11:164\n4225#2,11:175\n4225#2,11:186\n1#3:197\n*S KotlinDebug\n*F\n+ 1 BaseUI.kt\ncom/bxkj/base/v2/base/BaseUI\n*L\n44#1:164,11\n54#1:175,11\n66#1:186,11\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public interface j<VB extends ViewDataBinding, VM extends BaseViewModel> extends com.bxkj.base.v2.base.a<VB> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        @Deprecated
        @NotNull
        public static <VB_I1 extends ViewDataBinding, VM extends BaseViewModel, VB extends ViewBinding> VB b(@NotNull j<VB_I1, VM> jVar, @NotNull Object receiver, @NotNull LayoutInflater inflater) {
            ViewBinding b6;
            g0.p(receiver, "$receiver");
            g0.p(inflater, "inflater");
            b6 = i.b(jVar, receiver, inflater);
            return (VB) b6;
        }

        @Deprecated
        @NotNull
        public static <VB_I1 extends ViewDataBinding, VM extends BaseViewModel, VB extends ViewBinding> VB c(@NotNull j<VB_I1, VM> jVar, @NotNull Object receiver, @NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup) {
            ViewBinding c6;
            g0.p(receiver, "$receiver");
            g0.p(inflater, "inflater");
            c6 = i.c(jVar, receiver, inflater, viewGroup);
            return (VB) c6;
        }

        @Deprecated
        @NotNull
        public static <VB extends ViewDataBinding, VM_I1 extends BaseViewModel, VM extends ViewModel> VM d(@NotNull j<VB, VM_I1> jVar, @NotNull Object receiver, @NonNull @NotNull ViewModelStoreOwner owner) {
            ViewModel d6;
            g0.p(receiver, "$receiver");
            g0.p(owner, "owner");
            d6 = i.d(jVar, receiver, owner);
            return (VM) d6;
        }

        @Deprecated
        public static <VB extends ViewDataBinding, VM extends BaseViewModel> void a(@NotNull j<VB, VM> jVar) {
            i.a(jVar);
        }

        @Deprecated
        public static <VB extends ViewDataBinding, VM extends BaseViewModel> void e(@NotNull j<VB, VM> jVar) {
            i.e(jVar);
        }
    }

    @NotNull
    <VM extends ViewModel> VM B(@NotNull Object obj, @NonNull @NotNull ViewModelStoreOwner viewModelStoreOwner);

    void C(@Nullable p pVar);

    @NotNull
    VM D();

    void E();

    void F(@NotNull FragmentManager fragmentManager);

    @NotNull
    LifecycleOwner G();

    @NotNull
    Context H();

    @NotNull
    FragmentManager J();

    void K(@NotNull Context context);

    @NotNull
    VB L();

    void a(@NotNull FragmentActivity fragmentActivity);

    @NotNull
    Fragment q();

    @NotNull
    FragmentActivity r();

    void s(@NotNull Fragment fragment);

    void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner);

    void u();

    @NotNull
    <VB extends ViewBinding> VB v(@NotNull Object obj, @NotNull LayoutInflater layoutInflater);

    @NotNull
    <VB extends ViewBinding> VB w(@NotNull Object obj, @NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup);

    void x(@NotNull VM vm);

    @Nullable
    p y();

    void z(@NotNull VB vb);
}
