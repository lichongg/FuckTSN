package com.bxkj.student.v2.ui.main;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.base.v2.base.BaseMultiItemAdapter;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.R;
import com.bxkj.student.databinding.V2ItemForClassifyMenuBinding;
import com.bxkj.student.databinding.V2ItemForClassifyTitleBinding;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.g0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class ClassifyFragment$initUiData$1 extends BaseMultiItemAdapter<Map<String, ? extends Object>> {

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ ClassifyFragment f21470g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClassifyFragment$initUiData$1(ClassifyFragment classifyFragment, List<Map<String, Object>> list) {
        super(list);
        this.f21470g = classifyFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Map map, ClassifyFragment classifyFragment, View view) {
        if (g0.g(c0.f16887a.t(map, "type"), "0")) {
            return;
        }
        com.bxkj.student.v2.common.utils.l.f20907a.d(classifyFragment.r(), map, "2");
    }

    @Override // com.bxkj.base.v2.base.BaseMultiItemAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i6) {
        return c0.f16887a.l(i(i6), "type", -1);
    }

    @Override // com.bxkj.base.v2.base.BaseMultiItemAdapter
    public int j(int i6) {
        return i6 == 0 ? R.layout.v2_item_for_classify_title : R.layout.v2_item_for_classify_menu;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        g0.p(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            ((GridLayoutManager) layoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.bxkj.student.v2.ui.main.ClassifyFragment$initUiData$1$onAttachedToRecyclerView$1
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i6) {
                    return (i6 < ClassifyFragment$initUiData$1.this.getItemCount() && ClassifyFragment$initUiData$1.this.getItemViewType(i6) != 0) ? 1 : 5;
                }
            });
        }
    }

    @Override // com.bxkj.base.v2.base.BaseMultiItemAdapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void g(ViewDataBinding itemBinding, final Map<String, ? extends Object> bean, int i6) {
        g0.p(itemBinding, "itemBinding");
        g0.p(bean, "bean");
        String t5 = c0.f16887a.t(bean, CommonNetImpl.NAME);
        View root = itemBinding.getRoot();
        final ClassifyFragment classifyFragment = this.f21470g;
        root.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.main.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClassifyFragment$initUiData$1.s(bean, classifyFragment, view);
            }
        });
        if (getItemViewType(i6) == 0) {
            ((V2ItemForClassifyTitleBinding) itemBinding).tvName.setText(t5);
        } else {
            ((V2ItemForClassifyMenuBinding) itemBinding).setMap(bean);
        }
    }
}
