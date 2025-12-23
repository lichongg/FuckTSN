package com.bxkj.student.v2.ui.main;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.v2.base.BaseMultiItemAdapter;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.R;
import com.bxkj.student.databinding.V2ItemForClassifyTitleBinding;
import com.bxkj.student.databinding.V2ItemForMyMenuBinding;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.g0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class MyFragment$initUiData$1 extends BaseMultiItemAdapter<Map<String, ? extends Object>> {

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ MyFragment f21484g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MyFragment$initUiData$1(MyFragment myFragment, List<Map<String, Object>> list) {
        super(list);
        this.f21484g = myFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(MyFragment myFragment, Map map, View view) {
        com.bxkj.student.v2.common.utils.l.f20907a.d(myFragment.r(), map, "5");
    }

    @Override // com.bxkj.base.v2.base.BaseMultiItemAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i6) {
        return c0.f16887a.l(i(i6), "type", -1);
    }

    @Override // com.bxkj.base.v2.base.BaseMultiItemAdapter
    public int j(int i6) {
        return i6 == 0 ? R.layout.v2_item_for_classify_title : R.layout.v2_item_for_my_menu;
    }

    @Override // com.bxkj.base.v2.base.BaseMultiItemAdapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void g(ViewDataBinding itemBinding, final Map<String, ? extends Object> bean, int i6) {
        g0.p(itemBinding, "itemBinding");
        g0.p(bean, "bean");
        c0 c0Var = c0.f16887a;
        String t5 = c0Var.t(bean, CommonNetImpl.NAME);
        c0Var.t(bean, "mkey");
        if (getItemViewType(i6) == 0) {
            ((V2ItemForClassifyTitleBinding) itemBinding).tvName.setText(t5);
            return;
        }
        V2ItemForMyMenuBinding v2ItemForMyMenuBinding = (V2ItemForMyMenuBinding) itemBinding;
        v2ItemForMyMenuBinding.setMap(bean);
        View root = v2ItemForMyMenuBinding.getRoot();
        final MyFragment myFragment = this.f21484g;
        root.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.main.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyFragment$initUiData$1.s(MyFragment.this, bean, view);
            }
        });
    }
}
