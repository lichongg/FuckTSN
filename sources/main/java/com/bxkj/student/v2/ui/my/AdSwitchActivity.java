package com.bxkj.student.v2.ui.my;

import android.view.View;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.databinding.V2AdSwitchBinding;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import xyz.adscope.amps.AMPSSDK;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class AdSwitchActivity extends BaseActivity<V2AdSwitchBinding, BaseViewModel> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final AdSwitchActivity adSwitchActivity, View view) {
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        if (aVar.a().h()) {
            ContextExtKt.g(adSwitchActivity, "关闭个性化广告设置", "关闭后，该设备将不再展示个性化广告，但您看到的广告数量并不会减少且可能是您不感兴趣的广告", new Function1() { // from class: com.bxkj.student.v2.ui.my.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 i6;
                    i6 = AdSwitchActivity.i(AdSwitchActivity.this, (iOSTwoButtonDialog) obj);
                    return i6;
                }
            }, new Function1() { // from class: com.bxkj.student.v2.ui.my.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 j6;
                    j6 = AdSwitchActivity.j((iOSTwoButtonDialog) obj);
                    return j6;
                }
            }, "确认关闭", "我再想想");
        } else {
            aVar.a().f0(true);
            AMPSSDK.setPersonalRecommend(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 i(AdSwitchActivity adSwitchActivity, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        adSwitchActivity.L().tagAd.setChecked(true);
        AMPSSDK.setPersonalRecommend(true);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 j(iOSTwoButtonDialog it) {
        g0.p(it, "it");
        com.bxkj.base.v2.data.b.f16998d.a().f0(false);
        AMPSSDK.setPersonalRecommend(false);
        return n1.f44123a;
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        L().setBackEvent(this);
        L().tagAd.setChecked(com.bxkj.base.v2.data.b.f16998d.a().h());
        L().tagAd.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.my.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdSwitchActivity.h(AdSwitchActivity.this, view);
            }
        });
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
