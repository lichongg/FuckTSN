package com.bxkj.student.splash;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.App;
import com.bxkj.student.databinding.AcFacePrivacyAgreementBinding;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.LinkedHashMap;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class OpenPrivacyAgreementActivity extends BaseActivity<AcFacePrivacyAgreementBinding, BaseViewModel> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(OpenPrivacyAgreementActivity openPrivacyAgreementActivity, View view) {
        com.bxkj.student.v2.common.utils.i iVar = com.bxkj.student.v2.common.utils.i.f20904a;
        FragmentActivity r5 = openPrivacyAgreementActivity.r();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(CommonNetImpl.NAME, "用户协议");
        linkedHashMap.put("linkUrl", com.bxkj.student.v2.retrofit.b.f21275a.c());
        n1 n1Var = n1.f44123a;
        iVar.b(r5, linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(OpenPrivacyAgreementActivity openPrivacyAgreementActivity, View view) {
        com.bxkj.student.v2.common.utils.i iVar = com.bxkj.student.v2.common.utils.i.f20904a;
        FragmentActivity r5 = openPrivacyAgreementActivity.r();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(CommonNetImpl.NAME, "隐私政策");
        linkedHashMap.put("linkUrl", com.bxkj.student.v2.retrofit.b.f21275a.b());
        n1 n1Var = n1.f44123a;
        iVar.b(r5, linkedHashMap);
    }

    protected final void M() {
        App.f17573d.a().n();
        LoginUser.getLoginUser().setAgreement(true);
        startActivity(new Intent(H(), (Class<?>) SplashActivity.class));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(OpenPrivacyAgreementActivity openPrivacyAgreementActivity, View view) {
        openPrivacyAgreementActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(OpenPrivacyAgreementActivity openPrivacyAgreementActivity, View view) {
        openPrivacyAgreementActivity.M();
    }

    protected final void R() {
        L().btRefuse.setVisibility(0);
        L().btAgree.setVisibility(0);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        L().btRefuse.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.splash.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenPrivacyAgreementActivity.P(OpenPrivacyAgreementActivity.this, view);
            }
        });
        L().btAgree.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.splash.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenPrivacyAgreementActivity.Q(OpenPrivacyAgreementActivity.this, view);
            }
        });
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        L().setMActivity(this);
        L().tvUserAgree.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.splash.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenPrivacyAgreementActivity.N(OpenPrivacyAgreementActivity.this, view);
            }
        });
        L().tvUserPrivate.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.splash.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenPrivacyAgreementActivity.O(OpenPrivacyAgreementActivity.this, view);
            }
        });
        R();
    }
}
