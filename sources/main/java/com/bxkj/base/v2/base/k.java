package com.bxkj.base.v2.base;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBaseUI.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseUI.kt\ncom/bxkj/base/v2/base/BaseUIKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,163:1\n1869#2,2:164\n*S KotlinDebug\n*F\n+ 1 BaseUI.kt\ncom/bxkj/base/v2/base/BaseUIKt\n*L\n157#1:164,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class k {
    public static final /* synthetic */ <VB extends ViewDataBinding, VM extends BaseViewModel, F extends Fragment> F a(j<VB, VM> jVar, NavHostFragment navHostFragment, Class<F> fragmentClass) {
        g0.p(jVar, "<this>");
        g0.p(navHostFragment, "navHostFragment");
        g0.p(fragmentClass, "fragmentClass");
        List<Fragment> fragments = navHostFragment.getChildFragmentManager().getFragments();
        g0.o(fragments, "getFragments(...)");
        Iterator<T> it = fragments.iterator();
        while (it.hasNext()) {
            F f6 = (F) it.next();
            if (fragmentClass.isAssignableFrom(f6.getClass())) {
                g0.y(1, "F");
                return f6;
            }
        }
        return null;
    }
}
