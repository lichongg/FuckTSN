package com.bxkj.student.v2.ui.sports.set;

import androidx.fragment.app.FragmentActivity;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.data.UserType;
import com.bxkj.student.databinding.AcV2SportsSetBinding;
import com.bxkj.student.v2.common.utils.i;
import com.bxkj.student.v2.ui.sports.v3.record.V3RecordListActivity;
import com.bxkj.student.v2.ui.sports.v3.set.V3StatisticsActivity;
import com.bxkj.student.v2.vm.sports.set.SportsSetVM;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class SportsSetActivity extends BaseActivity<AcV2SportsSetBinding, SportsSetVM> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 O(SportsSetActivity sportsSetActivity, Map it) {
        g0.p(it, "it");
        c0 c0Var = c0.f16887a;
        String t5 = c0Var.t(it, CommonNetImpl.NAME);
        String t6 = c0Var.t(it, "linkUrl");
        i iVar = i.f20904a;
        FragmentActivity r5 = sportsSetActivity.r();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(CommonNetImpl.NAME, t5);
        linkedHashMap.put("linkUrl", t6);
        n1 n1Var = n1.f44123a;
        iVar.b(r5, linkedHashMap);
        return n1Var;
    }

    public final void M() {
        startActivity(getIntent().setClass(H(), SportsDescriptionActivity.class).putExtra("showBottom", false));
    }

    public final void N() {
        D().x(new Function1() { // from class: com.bxkj.student.v2.ui.sports.set.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 O;
                O = SportsSetActivity.O(SportsSetActivity.this, (Map) obj);
                return O;
            }
        });
    }

    public final void P() {
        startActivity(getIntent().setClass(H(), V3RecordListActivity.class));
    }

    public final void Q() {
        startActivity(getIntent().setClass(H(), SoundFrequencyActivity.class));
    }

    public final void R() {
        startActivity(getIntent().setClass(H(), V3StatisticsActivity.class));
    }

    public final void S() {
        startActivity(getIntent().setClass(H(), PermissionSetActivity.class));
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        L().setMSportsSetActivity(this);
        if (com.bxkj.base.v2.data.b.f16998d.a().T() == UserType.TEACHER) {
            L().tvRank.setVisibility(8);
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
