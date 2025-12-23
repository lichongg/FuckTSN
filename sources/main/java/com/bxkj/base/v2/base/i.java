package com.bxkj.base.v2.base;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewbinding.ViewBinding;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.text.u;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final /* synthetic */ class i {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements DialogInterface.OnKeyListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j<Object, Object> f16737a;

        /* JADX WARN: Type inference failed for: r1v6, types: [com.bxkj.base.v2.base.BaseViewModel] */
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
            if (i6 != 4) {
                return false;
            }
            p y5 = this.f16737a.y();
            if (y5 != null) {
                y5.b();
            }
            e2 b6 = this.f16737a.D().b();
            if (b6 == null) {
                return true;
            }
            b6.b(new CancellationException());
            return true;
        }

        a(j<Object, Object> jVar) {
            this.f16737a = jVar;
        }
    }

    @NotNull
    public static ViewBinding b(j jVar, @NotNull Object obj, @NotNull LayoutInflater inflater) {
        g0.p(obj, "<this>");
        g0.p(inflater, "inflater");
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        g0.n(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        g0.o(actualTypeArguments, "getActualTypeArguments(...)");
        ArrayList arrayList = new ArrayList();
        for (Type type : actualTypeArguments) {
            if (type instanceof Class) {
                arrayList.add(type);
            }
        }
        Object invoke = ((Class) arrayList.get(0)).getDeclaredMethod("inflate", LayoutInflater.class).invoke(null, inflater);
        g0.n(invoke, "null cannot be cast to non-null type VB of com.bxkj.base.v2.base.BaseUI.getActivityViewBinding");
        return (ViewBinding) invoke;
    }

    @NotNull
    public static ViewBinding c(j jVar, @NotNull Object obj, @NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup) {
        g0.p(obj, "<this>");
        g0.p(inflater, "inflater");
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        g0.n(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        g0.o(actualTypeArguments, "getActualTypeArguments(...)");
        ArrayList arrayList = new ArrayList();
        for (Type type : actualTypeArguments) {
            if (type instanceof Class) {
                arrayList.add(type);
            }
        }
        Object invoke = ((Class) arrayList.get(0)).getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, Boolean.TYPE).invoke(null, inflater, viewGroup, Boolean.FALSE);
        g0.n(invoke, "null cannot be cast to non-null type VB of com.bxkj.base.v2.base.BaseUI.getFragmentViewBinding");
        return (ViewBinding) invoke;
    }

    @NotNull
    public static ViewModel d(j jVar, @NotNull Object obj, @NonNull @NotNull ViewModelStoreOwner owner) {
        g0.p(obj, "<this>");
        g0.p(owner, "owner");
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        g0.n(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        g0.o(actualTypeArguments, "getActualTypeArguments(...)");
        ArrayList arrayList = new ArrayList();
        for (Type type : actualTypeArguments) {
            if (type instanceof Class) {
                arrayList.add(type);
            }
        }
        return new ViewModelProvider(owner).get((Class) arrayList.get(1));
    }

    public static void m(j jVar, String str) {
        if (str != null) {
            ContextExtKt.q(jVar.H(), str);
        }
    }

    public static void n(final j jVar, final String str) {
        if (str != null) {
            ContextExtKt.o(jVar.H(), str, new Function1() { // from class: com.bxkj.base.v2.base.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return i.o(str, jVar, (iOSOneButtonDialog) obj);
                }
            }).setCancelable(false);
        }
    }

    public static n1 o(String str, j jVar, iOSOneButtonDialog it) {
        g0.p(it, "it");
        if (u.l3(str, "登录失效", false, 2, null)) {
            jVar.r().startActivity(new Intent().setClassName(jVar.H(), g0.g(jVar.H().getPackageName(), com.bxkj.student.d.f17843b) ? "com.bxkj.student.v2.ui.LoginActivity" : "com.bxkj.teacher.v2.ui.LoginActivity").setFlags(268468224));
        }
        return n1.f44123a;
    }

    public static void p(j jVar, String str) {
        if (str != null) {
            ContextExtKt.m(jVar.H(), str);
        }
    }

    public static void q(j jVar, String str) {
        if (str != null) {
            ContextExtKt.s(jVar.H(), str, 0, 2, null);
        }
    }

    public static /* synthetic */ void r(j jVar, String str, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showProgressDialog");
        }
        if ((i6 & 1) != 0) {
            str = "loading...";
        }
        f(jVar, str);
    }

    public static void a(final j jVar) {
        BaseViewModel D = jVar.D();
        D.c().observe(jVar.G(), new Observer() { // from class: com.bxkj.base.v2.base.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                i.l(j.this, (Integer) obj);
            }
        });
        D.e().observe(jVar.G(), new Observer() { // from class: com.bxkj.base.v2.base.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                i.n(j.this, (String) obj);
            }
        });
        D.f().observe(jVar.G(), new Observer() { // from class: com.bxkj.base.v2.base.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                i.p(j.this, (String) obj);
            }
        });
        D.h().observe(jVar.G(), new Observer() { // from class: com.bxkj.base.v2.base.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                i.q(j.this, (String) obj);
            }
        });
        D.g().observe(jVar.G(), new Observer() { // from class: com.bxkj.base.v2.base.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                i.m(j.this, (String) obj);
            }
        });
    }

    public static void e(j jVar) {
        p y5 = jVar.y();
        if (y5 != null) {
            y5.b();
        }
    }

    public static void f(j jVar, String str) {
        if (jVar.y() == null) {
            jVar.C(new p(jVar.H()));
            p y5 = jVar.y();
            if (y5 != null) {
                y5.g(new a(jVar));
            }
        }
        p y6 = jVar.y();
        if (y6 != null) {
            y6.i(str);
        }
    }

    public static void l(j jVar, Integer num) {
        if (num.intValue() > 0) {
            f(jVar, jVar.D().d().getValue());
        } else {
            jVar.u();
        }
    }
}
