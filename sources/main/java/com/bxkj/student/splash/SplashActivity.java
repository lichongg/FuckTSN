package com.bxkj.student.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import cn.bluemobi.dylan.base.utils.u;
import com.bumptech.glide.load.resource.bitmap.i0;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.b0;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.databinding.AcSplashBinding;
import com.bxkj.student.personal.login.LoginActivity;
import com.bxkj.student.v2.ui.MainActivity;
import com.bxkj.student.v2.ui.h5.H5AppActivity;
import com.bxkj.student.v2.vm.splash.SplashVM;
import com.stub.StubApp;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.Nullable;
import xyz.adscope.amps.ad.splash.AMPSSplashAd;
import xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.tool.util.AMPSScreenUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSplashActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SplashActivity.kt\ncom/bxkj/student/splash/SplashActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,244:1\n1#2:245\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class SplashActivity extends BaseActivity<AcSplashBinding, SplashVM> {

    @Nullable
    private CountDownTimer U;
    private boolean V;

    @Nullable
    private AMPSSplashAd W;
    private boolean X;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends CountDownTimer {
        a() {
            super(5000L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            SplashActivity.this.U();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j6) {
            SplashActivity.this.L().tvTime.setText("跳过" + (j6 / 1000));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements AMPSSplashLoadEventListener {
        b() {
        }

        @Override // xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener
        public void onAmpsAdDismiss() {
            SplashActivity.this.U();
        }

        @Override // xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener
        public void onAmpsAdFailed(AMPSError errorCode) {
            g0.p(errorCode, "errorCode");
            SplashActivity.this.U();
        }

        @Override // xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener
        public void onAmpsAdLoaded() {
            AMPSSplashAd aMPSSplashAd = SplashActivity.this.W;
            if (aMPSSplashAd != null) {
                aMPSSplashAd.show(SplashActivity.this.L().adsFl);
            }
        }

        @Override // xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener
        public void onAmpsAdShow() {
            CountDownTimer countDownTimer = SplashActivity.this.U;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }

        @Override // xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener
        public void onAmpsAdClicked() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 T(int i6) {
        com.orhanobut.logger.j.d("启动页刷新Token成功", new Object[0]);
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        aVar.a().L0(true);
        com.bxkj.student.common.jpush.a.f17746a.d(aVar.a().R(), aVar.a().Y());
        aVar.a().e();
        return n1.f44123a;
    }

    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        StubApp.mark();
        super.onCreate(bundle);
    }

    private final void M() {
        a aVar = new a();
        this.U = aVar;
        aVar.cancel();
        CountDownTimer countDownTimer = this.U;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
        L().tvTime.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.splash.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplashActivity.N(SplashActivity.this, view);
            }
        });
        if (com.bxkj.base.v2.data.b.f16998d.a().a0() == 1) {
            O();
        } else {
            com.orhanobut.logger.j.d("未开启广告", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(SplashActivity splashActivity, View view) {
        CountDownTimer countDownTimer = splashActivity.U;
        if (countDownTimer != null) {
            countDownTimer.onFinish();
        }
    }

    private final void O() {
        AMPSSplashAd aMPSSplashAd = new AMPSSplashAd(this, new AMPSRequestParameters.Builder().setSpaceId(com.bxkj.student.v2.common.data.a.f20653c).setTimeOut(5000).setWidth(AMPSScreenUtil.getScreenWidth(this)).setHeight(AMPSScreenUtil.getScreenHeight(this)).build(), new b());
        this.W = aMPSSplashAd;
        aMPSSplashAd.loadAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 Q(SplashActivity splashActivity, String it) {
        g0.p(it, "it");
        com.bumptech.glide.request.h hVar = new com.bumptech.glide.request.h();
        hVar.R0(new m(), new i0(10));
        com.bumptech.glide.b.D(splashActivity.H()).a(it).b(hVar).y0(2131689689).z(2131689689).m1(splashActivity.L().ivLogo);
        return n1.f44123a;
    }

    private final void R() {
        if (this.V) {
            return;
        }
        D().y();
        D().w();
        P();
        S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        if (!this.X) {
            this.X = true;
            return;
        }
        if (!this.V) {
            if (LoginUser.getLoginUser().getSysType() == 2) {
                startActivity(new Intent(H(), (Class<?>) MainActivity.class));
            } else {
                startActivity(new Intent(H(), (Class<?>) com.bxkj.student.MainActivity.class));
            }
        }
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void s0() {
        CountDownTimer countDownTimer = this.U;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        AMPSSplashAd aMPSSplashAd = this.W;
        if (aMPSSplashAd != null) {
            aMPSSplashAd.destroy();
        }
        super.s0();
    }

    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        CountDownTimer countDownTimer = this.U;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        AMPSSplashAd aMPSSplashAd = this.W;
        if (aMPSSplashAd != null) {
            aMPSSplashAd.destroy();
        }
        super.onDestroy();
    }

    private final void P() {
        D().x(new Function1() { // from class: com.bxkj.student.splash.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 Q;
                Q = SplashActivity.Q(SplashActivity.this, (String) obj);
                return Q;
            }
        });
    }

    private final void S() {
        SplashActivity splashActivity;
        SplashActivity splashActivity2 = null;
        if (LoginUser.getLoginUser().getSysType() == 2) {
            splashActivity = this;
        } else {
            splashActivity = null;
        }
        if (splashActivity != null) {
            b.a aVar = com.bxkj.base.v2.data.b.f16998d;
            String j6 = aVar.a().j();
            if (j6.length() != 0) {
                j6 = null;
            }
            if (j6 != null) {
                D().v();
            }
            if (aVar.a().Y()) {
                splashActivity2 = this;
            }
            if (splashActivity2 != null) {
                D().u(new Function1() { // from class: com.bxkj.student.splash.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        n1 T;
                        T = SplashActivity.T(((Integer) obj).intValue());
                        return T;
                    }
                });
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.X = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.X) {
            U();
        }
        this.X = true;
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        if (!isTaskRoot()) {
            String action = getIntent().getAction();
            if (getIntent().hasCategory("android.intent.category.LAUNCHER") && g0.g("android.intent.action.MAIN", action)) {
                finish();
            }
        }
        if (getIntent().hasExtra("onlyOpenAd")) {
            this.V = getIntent().getBooleanExtra("onlyOpenAd", false);
        }
        if (!this.V) {
            cn.bluemobi.dylan.base.utils.a.n().i(com.bxkj.student.MainActivity.class);
            cn.bluemobi.dylan.base.utils.a.n().i(LoginActivity.class);
            cn.bluemobi.dylan.base.utils.a.n().i(H5AppActivity.class);
            cn.bluemobi.dylan.base.utils.a.n().i(MainActivity.class);
            cn.bluemobi.dylan.base.utils.a.n().i(com.bxkj.student.v2.ui.LoginActivity.class);
        }
        if (!LoginUser.getLoginUser().isAgreement()) {
            startActivity(new Intent(H(), (Class<?>) OpenPrivacyAgreementActivity.class));
            finish();
            return;
        }
        if (b0.g(H()) != LoginUser.getLoginUser().getLastVersionCode()) {
            startActivity(new Intent(H(), (Class<?>) WelcomeActivity.class));
            finish();
        } else {
            if (u.b0(LoginUser.getLoginUser().getSchoolId())) {
                startActivity(new Intent(H(), (Class<?>) SelectSchoolV2Activity.class));
                finish();
                return;
            }
            L().tvSchoolName.setText(com.bxkj.base.v2.data.b.f16998d.a().L());
            try {
                R();
                M();
            } catch (Exception e6) {
                com.orhanobut.logger.j.e(com.bxkj.base.v2.common.ext.e.a(e6), new Object[0]);
            }
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
