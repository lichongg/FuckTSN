package com.bxkj.student.v2.ui.sports.set;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.student.databinding.AcV2SoundSetFrequencyBinding;
import com.bxkj.student.v2.vm.sports.set.SoundFrequencySetVM;
import kotlin.jvm.internal.g0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class SoundFrequencyActivity extends BaseActivity<AcV2SoundSetFrequencyBinding, SoundFrequencySetVM> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(SoundFrequencyActivity soundFrequencyActivity, RadioGroup radioGroup, int i6) {
        com.bxkj.base.v2.data.b.f16998d.a().m0(soundFrequencyActivity.L().rg.indexOfChild(soundFrequencyActivity.L().rg.findViewById(i6)));
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        L().rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.bxkj.student.v2.ui.sports.set.b
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i6) {
                SoundFrequencyActivity.f(SoundFrequencyActivity.this, radioGroup, i6);
            }
        });
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        L().setMActivity(this);
        View childAt = L().rg.getChildAt(com.bxkj.base.v2.data.b.f16998d.a().o());
        g0.n(childAt, "null cannot be cast to non-null type android.widget.RadioButton");
        ((RadioButton) childAt).setChecked(true);
    }
}
