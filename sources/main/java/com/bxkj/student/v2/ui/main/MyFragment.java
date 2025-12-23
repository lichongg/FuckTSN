package com.bxkj.student.v2.ui.main;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebStorage;
import androidx.collection.ArrayMap;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.utils.o;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.base.v2.base.BaseMultiItemAdapter;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.R;
import com.bxkj.student.databinding.V2MainTabMyFragmentBinding;
import com.bxkj.student.v2.common.view.CardListMenuItemDecoration;
import com.bxkj.student.v2.ui.LoginActivity;
import com.bxkj.student.v2.vm.MainViewModel;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.g0;
import kotlin.n;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMyFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyFragment.kt\ncom/bxkj/student/v2/ui/main/MyFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,121:1\n1#2:122\n1869#3:123\n774#3:124\n865#3,2:125\n1870#3:127\n*S KotlinDebug\n*F\n+ 1 MyFragment.kt\ncom/bxkj/student/v2/ui/main/MyFragment\n*L\n94#1:123\n100#1:124\n100#1:125,2\n94#1:127\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class MyFragment extends BaseFragment<V2MainTabMyFragmentBinding, MainViewModel> {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final List<Map<String, Object>> f21481l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private BaseMultiItemAdapter<Map<String, Object>> f21482m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements Observer, b0 {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f21483a;

        a(Function1 function) {
            g0.p(function, "function");
            this.f21483a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof b0)) {
                return g0.g(getFunctionDelegate(), ((b0) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.b0
        @NotNull
        public final n<?> getFunctionDelegate() {
            return this.f21483a;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21483a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 j(MyFragment myFragment, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        myFragment.D().j0();
        WebStorage.getInstance().deleteAllData();
        myFragment.startActivity(new Intent(myFragment.r(), (Class<?>) LoginActivity.class));
        myFragment.D().Z().postValue(Boolean.TRUE);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 l(MyFragment myFragment, List list) {
        myFragment.f21481l.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Map<String, ? extends Object> map = (Map) it.next();
                ArrayMap arrayMap = new ArrayMap();
                c0 c0Var = c0.f16887a;
                arrayMap.put(CommonNetImpl.NAME, c0Var.t(map, "typeName"));
                arrayMap.put("type", 0);
                myFragment.f21481l.add(arrayMap);
                List<Map<String, Object>> n6 = c0Var.n(map, "menus");
                ArrayList arrayList = new ArrayList();
                for (Object obj : n6) {
                    if (g0.g(c0.f16887a.t((Map) obj, "isShow"), "1")) {
                        arrayList.add(obj);
                    }
                }
                myFragment.f21481l.addAll(arrayList);
            }
        }
        BaseMultiItemAdapter<Map<String, Object>> baseMultiItemAdapter = myFragment.f21482m;
        if (baseMultiItemAdapter != null) {
            baseMultiItemAdapter.notifyDataSetChanged();
        }
        return n1.f44123a;
    }

    public final void m() {
        MyFragment myFragment = this.f21481l.isEmpty() ? this : null;
        if (myFragment != null) {
            if ((b() ? myFragment : null) != null) {
                D().c0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 k(MyFragment myFragment, Map map) {
        Context H = myFragment.H();
        c0 c0Var = c0.f16887a;
        o.f(H, c0Var.t(map, "imageRouteUrl"), myFragment.L().ivHead, R.mipmap.v3_head_icon, R.mipmap.v3_head_icon);
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        aVar.a().X0(c0Var.t(map, "nickName"));
        myFragment.L().tvName.setText(aVar.a().U());
        myFragment.L().tvUserNumber.setText(aVar.a().S());
        return n1.f44123a;
    }

    public final void h() {
        MyFragment myFragment;
        MyFragment myFragment2 = null;
        if (b()) {
            myFragment = this;
        } else {
            myFragment = null;
        }
        if (myFragment != null) {
            if (com.bxkj.base.v2.data.b.f16998d.a().Y()) {
                myFragment2 = myFragment;
            }
            if (myFragment2 != null) {
                D().a0();
            }
        }
    }

    public final void i() {
        ContextExtKt.h(r(), "提示", "确定要退出登录吗?", new Function1() { // from class: com.bxkj.student.v2.ui.main.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 j6;
                j6 = MyFragment.j(MyFragment.this, (iOSTwoButtonDialog) obj);
                return j6;
            }
        }, null, null, null, 56, null);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        D().e0().observe(r(), new a(new Function1() { // from class: com.bxkj.student.v2.ui.main.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 k6;
                k6 = MyFragment.k(MyFragment.this, (Map) obj);
                return k6;
            }
        }));
        D().d0().observe(r(), new a(new Function1() { // from class: com.bxkj.student.v2.ui.main.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 l6;
                l6 = MyFragment.l(MyFragment.this, (List) obj);
                return l6;
            }
        }));
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        d(r());
        L().setLoggedInUser(com.bxkj.base.v2.data.b.f16998d.a());
        L().setMyFragment(this);
        D().c0();
        D().a0();
        this.f21482m = new MyFragment$initUiData$1(this, this.f21481l);
        L().rvMenu.setAdapter(this.f21482m);
        L().rvMenu.addItemDecoration(new CardListMenuItemDecoration());
    }
}
