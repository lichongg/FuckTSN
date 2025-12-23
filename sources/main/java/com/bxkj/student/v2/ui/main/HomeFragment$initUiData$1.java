package com.bxkj.student.v2.ui.main;

import android.view.View;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.student.databinding.V2ItemForHomeMenuBinding;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.g0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class HomeFragment$initUiData$1 extends BaseAdapter<Map<String, ? extends Object>, V2ItemForHomeMenuBinding> {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ HomeFragment f21480f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeFragment$initUiData$1(HomeFragment homeFragment, List<Map<String, Object>> list) {
        super(list);
        this.f21480f = homeFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(HomeFragment homeFragment, Map map, View view) {
        com.bxkj.student.v2.common.utils.l.f20907a.d(homeFragment.r(), map, "1");
    }

    @Override // com.bxkj.base.v2.base.BaseAdapter
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void f(V2ItemForHomeMenuBinding itemBinding, final Map<String, ? extends Object> bean, int i6) {
        g0.p(itemBinding, "itemBinding");
        g0.p(bean, "bean");
        itemBinding.setMap(bean);
        itemBinding.setLoggedInUser(com.bxkj.base.v2.data.b.f16998d.a());
        View root = itemBinding.getRoot();
        final HomeFragment homeFragment = this.f21480f;
        root.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.main.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFragment$initUiData$1.o(HomeFragment.this, bean, view);
            }
        });
    }
}
