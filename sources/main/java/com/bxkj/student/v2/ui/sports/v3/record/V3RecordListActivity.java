package com.bxkj.student.v2.ui.sports.v3.record;

import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.adapter.b;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.student.R;
import com.bxkj.student.common.utils.k;
import com.bxkj.student.databinding.AcV3RecordListBinding;
import com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordInValidFragment;
import com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordValidFragment;
import com.bxkj.student.v2.ui.sports.v3.record.tab.V3StatisticsFragment;
import com.bxkj.student.v2.vm.sports.record.RecordVM;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import kotlin.jvm.internal.SourceDebugExtension;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nV3RecordListActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3RecordListActivity.kt\ncom/bxkj/student/v2/ui/sports/v3/record/V3RecordListActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,54:1\n1#2:55\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3RecordListActivity extends BaseActivity<AcV3RecordListBinding, RecordVM> {
    private boolean U;

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        V3RecordListActivity v3RecordListActivity;
        TabLayout.Tab tabAt;
        if (getIntent().hasExtra("toLocal")) {
            this.U = getIntent().getBooleanExtra("toLocal", false);
        }
        k.g(r(), ContextCompat.getColor(H(), R.color.v3_tab_color3));
        L().setMActivity(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new V3StatisticsFragment());
        arrayList.add(new V3RecordValidFragment());
        arrayList.add(new V3RecordInValidFragment());
        new b(getSupportFragmentManager(), arrayList, 2131298030, L().tb);
        V3RecordListActivity v3RecordListActivity2 = null;
        if (this.U) {
            v3RecordListActivity = this;
        } else {
            v3RecordListActivity = null;
        }
        if (v3RecordListActivity != null && (tabAt = L().tb.getTabAt(2)) != null) {
            tabAt.select();
        }
        if (getIntent().hasExtra("tabIndex")) {
            v3RecordListActivity2 = this;
        }
        if (v3RecordListActivity2 != null) {
            TabLayout.Tab tabAt2 = L().tb.getTabAt(getIntent().getIntExtra("tabIndex", 0));
            if (tabAt2 != null) {
                tabAt2.select();
            }
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
