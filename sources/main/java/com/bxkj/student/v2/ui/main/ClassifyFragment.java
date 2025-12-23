package com.bxkj.student.v2.ui.main;

import android.animation.ObjectAnimator;
import androidx.collection.ArrayMap;
import androidx.lifecycle.Observer;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.base.v2.base.BaseMultiItemAdapter;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.databinding.V2ItemForClassifyMenuBinding;
import com.bxkj.student.databinding.V2MainTabClassifyFragmentBinding;
import com.bxkj.student.v2.common.view.CardGridMenuItemDecoration;
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
@SourceDebugExtension({"SMAP\nClassifyFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassifyFragment.kt\ncom/bxkj/student/v2/ui/main/ClassifyFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,177:1\n774#2:178\n865#2,2:179\n1869#2,2:181\n774#2:184\n865#2,2:185\n1869#2:187\n774#2:188\n865#2,2:189\n1870#2:191\n1#3:183\n*S KotlinDebug\n*F\n+ 1 ClassifyFragment.kt\ncom/bxkj/student/v2/ui/main/ClassifyFragment\n*L\n143#1:178\n143#1:179,2\n144#1:181,2\n120#1:184\n120#1:185,2\n126#1:187\n127#1:188\n127#1:189,2\n126#1:191\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class ClassifyFragment extends BaseFragment<V2MainTabClassifyFragmentBinding, MainViewModel> {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final List<Map<String, Object>> f21465l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private final List<Map<String, Object>> f21466m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    private BaseMultiItemAdapter<Map<String, Object>> f21467n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private BaseAdapter<Map<String, Object>, V2ItemForClassifyMenuBinding> f21468o;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements Observer, b0 {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f21469a;

        a(Function1 function) {
            g0.p(function, "function");
            this.f21469a = function;
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
            return this.f21469a;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21469a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 h(ClassifyFragment classifyFragment, List list) {
        Integer num;
        classifyFragment.f21466m.clear();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (g0.g(c0.f16887a.t((Map) obj, "isShow"), "1")) {
                    arrayList.add(obj);
                }
            }
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        classifyFragment.L().tvHomeMenuCount.setText("已收起" + num + "个应用");
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 i(ClassifyFragment classifyFragment, List list) {
        BaseMultiItemAdapter<Map<String, Object>> baseMultiItemAdapter = classifyFragment.f21467n;
        if (baseMultiItemAdapter != null) {
            baseMultiItemAdapter.notifyItemRangeRemoved(0, classifyFragment.f21465l.size());
        }
        classifyFragment.f21465l.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Map<String, ? extends Object> map = (Map) it.next();
                List<Map<String, Object>> n6 = c0.f16887a.n(map, "menus");
                ArrayList arrayList = new ArrayList();
                for (Object obj : n6) {
                    if (g0.g(c0.f16887a.t((Map) obj, "isShow"), "1")) {
                        arrayList.add(obj);
                    }
                }
                if (!arrayList.isEmpty()) {
                    ArrayMap arrayMap = new ArrayMap();
                    arrayMap.put(CommonNetImpl.NAME, c0.f16887a.t(map, "typeName"));
                    arrayMap.put("type", 0);
                    classifyFragment.f21465l.add(arrayMap);
                    classifyFragment.f21465l.addAll(arrayList);
                }
            }
        }
        BaseMultiItemAdapter<Map<String, Object>> baseMultiItemAdapter2 = classifyFragment.f21467n;
        if (baseMultiItemAdapter2 != null) {
            baseMultiItemAdapter2.notifyItemRangeInserted(0, classifyFragment.f21465l.size());
        }
        return n1.f44123a;
    }

    @Nullable
    public final BaseAdapter<Map<String, Object>, V2ItemForClassifyMenuBinding> g() {
        return this.f21468o;
    }

    public final void j() {
        ClassifyFragment classifyFragment = this.f16682f != 0 ? this : null;
        if (classifyFragment != null) {
            if (D().g0()) {
                classifyFragment = null;
            }
            if (classifyFragment != null) {
                if (!this.f21465l.isEmpty()) {
                    classifyFragment = null;
                }
                if (classifyFragment != null) {
                    if ((b() ? classifyFragment : null) != null) {
                        D().P();
                    }
                }
            }
        }
    }

    public final void m(@Nullable BaseAdapter<Map<String, Object>, V2ItemForClassifyMenuBinding> baseAdapter) {
        this.f21468o = baseAdapter;
    }

    public final void n() {
        BaseAdapter<Map<String, Object>, V2ItemForClassifyMenuBinding> baseAdapter = this.f21468o;
        if (baseAdapter == null || baseAdapter.getItemCount() != 0) {
            this.f21466m.clear();
            l();
        } else {
            List<Map<String, Object>> value = D().T().getValue();
            if (value != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : value) {
                    if (g0.g(c0.f16887a.t((Map) obj, "isShow"), "1")) {
                        arrayList.add(obj);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f21466m.add((Map) it.next());
                }
            }
            k();
        }
        BaseAdapter<Map<String, Object>, V2ItemForClassifyMenuBinding> baseAdapter2 = this.f21468o;
        if (baseAdapter2 != null) {
            baseAdapter2.notifyDataSetChanged();
        }
    }

    private final void k() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(L().tvHomeMenuArrow, "rotation", 0.0f, 90.0f);
        ofFloat.setDuration(200L);
        ofFloat.start();
    }

    private final void l() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(L().tvHomeMenuArrow, "rotation", 90.0f, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.start();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        D().T().observe(r(), new a(new Function1() { // from class: com.bxkj.student.v2.ui.main.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 h6;
                h6 = ClassifyFragment.h(ClassifyFragment.this, (List) obj);
                return h6;
            }
        }));
        D().Q().observe(r(), new a(new Function1() { // from class: com.bxkj.student.v2.ui.main.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 i6;
                i6 = ClassifyFragment.i(ClassifyFragment.this, (List) obj);
                return i6;
            }
        }));
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        d(r());
        L().setClassifyFragment(this);
        this.f21467n = new ClassifyFragment$initUiData$1(this, this.f21465l);
        L().rvMenu.setAdapter(this.f21467n);
        L().rvMenu.addItemDecoration(new CardGridMenuItemDecoration());
        D().P();
        this.f21468o = new ClassifyFragment$initUiData$2(this, this.f21466m);
        L().rvHomeMenu.setAdapter(this.f21468o);
    }
}
