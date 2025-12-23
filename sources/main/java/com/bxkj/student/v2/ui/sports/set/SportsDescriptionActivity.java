package com.bxkj.student.v2.ui.sports.set;

import android.os.CountDownTimer;
import android.webkit.WebSettings;
import androidx.lifecycle.Observer;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.databinding.AcV2SportsDescriptionBinding;
import com.bxkj.student.v2.ui.sports.v3.V4SportActivity;
import com.bxkj.student.v2.vm.sports.SportsDescriptionVM;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.g0;
import kotlin.n;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class SportsDescriptionActivity extends BaseActivity<AcV2SportsDescriptionBinding, SportsDescriptionVM> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends CountDownTimer {
        a(long j6) {
            super(j6, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            SportsDescriptionActivity.this.L().setStartButtonEnable(Boolean.TRUE);
            SportsDescriptionActivity.this.L().btStart.setText("开始锻炼");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j6) {
            SportsDescriptionActivity.this.L().btStart.setText("开始锻炼(" + ((j6 / 1000) + 1) + "秒)");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b implements Observer, b0 {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f21527a;

        b(Function1 function) {
            g0.p(function, "function");
            this.f21527a = function;
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
            return this.f21527a;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21527a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 f(SportsDescriptionActivity sportsDescriptionActivity, Map map) {
        if (map != null) {
            if (sportsDescriptionActivity.getIntent().hasExtra("showBottom")) {
                sportsDescriptionActivity.L().setShowBottom(Boolean.valueOf(sportsDescriptionActivity.getIntent().getBooleanExtra("showBottom", true)));
            } else {
                sportsDescriptionActivity.L().setShowBottom(Boolean.TRUE);
            }
            sportsDescriptionActivity.L().swv.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            c0 c0Var = c0.f16887a;
            sportsDescriptionActivity.L().swv.h(c0Var.t(map, "content"));
            sportsDescriptionActivity.new a(c0Var.p(map, "countdownTime", 10L) * 1000).start();
        }
        return n1.f44123a;
    }

    public final void M() {
        com.bxkj.base.v2.data.b.f16998d.a().E0(L().cbIgnore.isChecked());
        startActivity(getIntent().setClass(H(), V4SportActivity.class));
        finish();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        D().v().observe(this, new b(new Function1() { // from class: com.bxkj.student.v2.ui.sports.set.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 f6;
                f6 = SportsDescriptionActivity.f(SportsDescriptionActivity.this, (Map) obj);
                return f6;
            }
        }));
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        D().w();
        L().setStartButtonEnable(Boolean.FALSE);
        L().setMActivity(this);
    }
}
