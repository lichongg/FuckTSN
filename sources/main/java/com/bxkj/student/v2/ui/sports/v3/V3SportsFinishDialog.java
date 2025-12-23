package com.bxkj.student.v2.ui.sports.v3;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.v2.base.BaseDialog;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.student.App;
import com.bxkj.student.R;
import com.bxkj.student.databinding.AcV3SportsFinishBinding;
import com.bxkj.student.v2.common.data.PointData;
import com.bxkj.student.v2.common.data.i;
import com.bxkj.student.v2.ui.dialog.FaceOutDialog;
import com.bxkj.student.v2.ui.sports.set.PermissionSetActivity;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import com.bxkj.student.v2.ui.sports.v3.service.V3LocationService;
import com.bxkj.student.v2.ui.sports.v3.service.step.V3StepService;
import com.bxkj.student.v2.vm.sports.SportsVM;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.card.MaterialCardView;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nV3SportsFinishDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3SportsFinishDialog.kt\ncom/bxkj/student/v2/ui/sports/v3/V3SportsFinishDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,497:1\n1#2:498\n256#3,2:499\n256#3,2:501\n*S KotlinDebug\n*F\n+ 1 V3SportsFinishDialog.kt\ncom/bxkj/student/v2/ui/sports/v3/V3SportsFinishDialog\n*L\n171#1:499,2\n172#1:501,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3SportsFinishDialog extends BaseDialog<AcV3SportsFinishBinding, SportsVM> {

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private Function0<n1> f21542k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private Function0<Boolean> f21543l;

    /* renamed from: m, reason: collision with root package name */
    private long f21544m;

    /* renamed from: n, reason: collision with root package name */
    private final int f21545n = 500;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private BottomSheetDialog f21546o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    private FaceOutDialog f21547p;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class a extends FunctionReferenceImpl implements Function2<String, String, n1> {
        a(Object obj) {
            super(2, obj, V3SportsFinishDialog.class, "commitSuccess", "commitSuccess(Ljava/lang/String;Ljava/lang/String;)V", 0);
        }

        public final void c(String str, String str2) {
            ((V3SportsFinishDialog) this.receiver).n0(str, str2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ n1 invoke(String str, String str2) {
            c(str, str2);
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<String, n1> {
        b(Object obj) {
            super(1, obj, V3SportsFinishDialog.class, "commitFail", "commitFail(Ljava/lang/String;)V", 0);
        }

        public final void c(String str) {
            ((V3SportsFinishDialog) this.receiver).k0(str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ n1 invoke(String str) {
            c(str);
            return n1.f44123a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 a0(V3SportsFinishDialog v3SportsFinishDialog) {
        Function0<Boolean> function0 = v3SportsFinishDialog.f21543l;
        if (function0 != null && function0.invoke().booleanValue()) {
            return n1.f44123a;
        }
        v3SportsFinishDialog.dismiss();
        com.bxkj.student.v2.common.data.i.f20657a.v0(false);
        return n1.f44123a;
    }

    private final void b0(final String str, final String str2) {
        if (!com.bxkj.base.v2.common.utils.c0.f16887a.d(com.bxkj.student.v2.common.data.i.f20657a.B(), "exceptionTrace")) {
            m0(str, str2);
            return;
        }
        String string = App.f17573d.a().getString(R.string.exception_trace_alert_msg);
        kotlin.jvm.internal.g0.o(string, "getString(...)");
        SpannableStringBuilder append = new SpannableStringBuilder().append((CharSequence) string).append((CharSequence) "如果本次跑步成绩与实际成绩相差较大，请及时提交申诉，并重新设置手机权限！");
        append.setSpan(new ForegroundColorSpan(ContextCompat.getColor(H(), 2131099718)), string.length(), append.length(), 33);
        FragmentActivity r5 = r();
        kotlin.jvm.internal.g0.m(append);
        TextView textView = (TextView) ContextExtKt.g(r5, "注意", append, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 c02;
                c02 = V3SportsFinishDialog.c0(V3SportsFinishDialog.this, (iOSTwoButtonDialog) obj);
                return c02;
            }
        }, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 d02;
                d02 = V3SportsFinishDialog.d0(V3SportsFinishDialog.this, str, str2, (iOSTwoButtonDialog) obj);
                return d02;
            }
        }, "直接提交", "设置运动权限").findViewById(2131299164);
        if (textView != null) {
            textView.setText("注意");
            textView.setTextColor(ContextCompat.getColor(r(), 2131099718));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 c0(V3SportsFinishDialog v3SportsFinishDialog, iOSTwoButtonDialog it) {
        kotlin.jvm.internal.g0.p(it, "it");
        v3SportsFinishDialog.r().startActivity(new Intent(v3SportsFinishDialog.r(), (Class<?>) PermissionSetActivity.class));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 d0(V3SportsFinishDialog v3SportsFinishDialog, String str, String str2, iOSTwoButtonDialog it) {
        kotlin.jvm.internal.g0.p(it, "it");
        v3SportsFinishDialog.m0(str, str2);
        return n1.f44123a;
    }

    private final void e0(final String str, final String str2) {
        com.bxkj.base.v2.common.utils.c0 c0Var = com.bxkj.base.v2.common.utils.c0.f16887a;
        if (c0Var.k(D().M(), "isEndFace") != 1) {
            b0(str, str2);
            return;
        }
        ContextExtKt.h(r(), "温馨提示", com.bxkj.student.v2.common.utils.s.f20923a.d(c0Var.k(D().M(), "runType")) + "结束前，请先进行人脸识别!\n请注意周边环境是否安全！", new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 f02;
                f02 = V3SportsFinishDialog.f0(V3SportsFinishDialog.this, str, str2, (iOSTwoButtonDialog) obj);
                return f02;
            }
        }, null, null, null, 56, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 f0(final V3SportsFinishDialog v3SportsFinishDialog, final String str, final String str2, iOSTwoButtonDialog it) {
        kotlin.jvm.internal.g0.p(it, "it");
        i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
        if (kotlin.jvm.internal.g0.g(aVar.k().getValue(), Boolean.TRUE)) {
            v3SportsFinishDialog.z0(str, str2);
        } else {
            Integer value = aVar.j().getValue();
            v3SportsFinishDialog.f21547p = FaceOutDialog.f21310r.g((value != null ? value.intValue() : 0) + 1, (int) (com.bxkj.base.v2.common.utils.c0.f16887a.f(v3SportsFinishDialog.D().M(), "faceDistanceOut") * 1000), v3SportsFinishDialog.J(), new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 h02;
                    h02 = V3SportsFinishDialog.h0(V3SportsFinishDialog.this, str, str2, (DialogFragment) obj);
                    return h02;
                }
            }, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 g02;
                    g02 = V3SportsFinishDialog.g0(V3SportsFinishDialog.this, str, str2, (DialogFragment) obj);
                    return g02;
                }
            });
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 g0(V3SportsFinishDialog v3SportsFinishDialog, String str, String str2, DialogFragment it) {
        kotlin.jvm.internal.g0.p(it, "it");
        v3SportsFinishDialog.z0(str, str2);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 h0(V3SportsFinishDialog v3SportsFinishDialog, String str, String str2, DialogFragment it) {
        kotlin.jvm.internal.g0.p(it, "it");
        v3SportsFinishDialog.b0(str, str2);
        return n1.f44123a;
    }

    private final void i0() {
        List<Map<String, Object>> n6 = com.bxkj.base.v2.common.utils.c0.f16887a.n(D().M(), "list");
        List<Map<String, Object>> x5 = com.bxkj.student.v2.common.data.i.f20657a.x();
        MaterialCardView cardPassPoint = L().cardPassPoint;
        kotlin.jvm.internal.g0.o(cardPassPoint, "cardPassPoint");
        cardPassPoint.setVisibility(!n6.isEmpty() ? 0 : 8);
        MaterialCardView cardNoPass = L().cardNoPass;
        kotlin.jvm.internal.g0.o(cardNoPass, "cardNoPass");
        cardNoPass.setVisibility(x5.size() < n6.size() ? 0 : 8);
        L().tvPassPointTarget.setText("本次需要经过必经点:" + n6.size() + "个");
        L().tvPassPoint.setText("本次实际经过必经点: " + x5.size() + "个");
        TextView textView = L().tvNoPassPoint;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        com.bxkj.base.v2.common.utils.k0 k0Var = com.bxkj.base.v2.common.utils.k0.f16922a;
        textView.setText(spannableStringBuilder.append((CharSequence) k0Var.a("未达标", ContextCompat.getColor(H(), 2131099718))).append((CharSequence) com.snail.antifake.deviceid.e.f37542d).append((CharSequence) k0Var.a("未经过点详情", ContextCompat.getColor(H(), R.color.v3_button_color))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 l0(V3SportsFinishDialog v3SportsFinishDialog, String str, iOSOneButtonDialog it) {
        kotlin.jvm.internal.g0.p(it, "it");
        v3SportsFinishDialog.j0();
        v3SportsFinishDialog.startActivity(new Intent(v3SportsFinishDialog.H(), (Class<?>) V3RecordDetailActivity.class).putExtra("identify", str));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(String str, String str2) {
        if (str == null) {
            str = "上传成功";
        }
        ContextExtKt.s(H(), str, 0, 2, null);
        j0();
        if (str2 != null) {
            startActivity(new Intent(H(), (Class<?>) V3RecordDetailActivity.class).putExtra("exerciseRecordId", str2));
        }
    }

    static /* synthetic */ void o0(V3SportsFinishDialog v3SportsFinishDialog, String str, String str2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "上传成功";
        }
        v3SportsFinishDialog.n0(str, str2);
    }

    private final boolean q0() {
        com.bxkj.base.v2.common.utils.c0 c0Var = com.bxkj.base.v2.common.utils.c0.f16887a;
        int l6 = c0Var.l(D().M(), "runType", 1);
        if (l6 == 0 || l6 == 5) {
            return true;
        }
        double f6 = c0Var.f(D().M(), "minSaveRange");
        i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
        return aVar.e() >= ((long) (c0Var.k(D().M(), "startQualifiedTime") * 60)) && aVar.g() >= f6 * ((double) 1000);
    }

    private final void z0(final String str, final String str2) {
        i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
        PointData pointData = !aVar.s().isEmpty() ? (PointData) kotlin.collections.f0.u3(aVar.s()) : null;
        com.bxkj.student.v2.ui.face.f0 f0Var = com.bxkj.student.v2.ui.face.f0.f21370a;
        FragmentActivity r5 = r();
        com.bxkj.base.v2.common.utils.c0 c0Var = com.bxkj.base.v2.common.utils.c0.f16887a;
        f0Var.d(r5, c0Var.k(D().M(), "runType"), c0Var.k(D().M(), "livingFace"), "3", c0Var.t(D().M(), "identify"), pointData, new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 A0;
                A0 = V3SportsFinishDialog.A0(V3SportsFinishDialog.this, str, str2);
                return A0;
            }
        });
    }

    public final void m0(@NotNull String isValid, @NotNull String isException) {
        kotlin.jvm.internal.g0.p(isValid, "isValid");
        kotlin.jvm.internal.g0.p(isException, "isException");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.stopService(new Intent(H(), (Class<?>) V3LocationService.class));
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.stopService(new Intent(H(), (Class<?>) V3StepService.class));
        }
        n0.a.f50398a.b(H(), R.raw.stop_run);
        D().F(isValid, isException, new a(this), new b(this));
    }

    public final void s0(@Nullable Function0<Boolean> function0) {
        this.f21543l = function0;
    }

    public final void t0(@Nullable Function0<n1> function0) {
        this.f21542k = function0;
    }

    public final void u0() {
        new V3PassPointDialog().show(J(), "finishDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 A0(V3SportsFinishDialog v3SportsFinishDialog, String str, String str2) {
        v3SportsFinishDialog.b0(str, str2);
        return n1.f44123a;
    }

    private final void j0() {
        V3SportsHomeActivity v3SportsHomeActivity = (V3SportsHomeActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(V3SportsHomeActivity.class);
        if (v3SportsHomeActivity != null) {
            v3SportsHomeActivity.y1();
        }
        i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
        aVar.B().clear();
        FaceOutDialog faceOutDialog = this.f21547p;
        if (faceOutDialog != null) {
            faceOutDialog.dismissAllowingStateLoss();
        }
        Function0<n1> function0 = this.f21542k;
        if (function0 != null) {
            function0.invoke();
        }
        BottomSheetDialog bottomSheetDialog = this.f21546o;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.dismiss();
        }
        dismissAllowingStateLoss();
        V4SportActivity v4SportActivity = (V4SportActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(V4SportActivity.class);
        if (v4SportActivity != null) {
            v4SportActivity.finish();
        }
        aVar.l0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(final String str) {
        iOSOneButtonDialog o5 = ContextExtKt.o(H(), "提交异常,已为您暂存本地,请稍后在本地锻炼记录中重新上传！", new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 l02;
                l02 = V3SportsFinishDialog.l0(V3SportsFinishDialog.this, str, (iOSOneButtonDialog) obj);
                return l02;
            }
        });
        o5.setCancelable(false);
        o5.setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(V3SportsFinishDialog v3SportsFinishDialog, View view) {
        v3SportsFinishDialog.v0();
    }

    private final boolean r0() {
        boolean z5;
        TextView textView = L().tvDistance;
        i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
        textView.setText(com.bxkj.student.run.app.utils.i.c(aVar.g()) + "公里");
        double g6 = aVar.g();
        com.bxkj.base.v2.common.utils.c0 c0Var = com.bxkj.base.v2.common.utils.c0.f16887a;
        if (g6 < c0Var.f(D().M(), "totalRange") * 1000) {
            L().tvDistance.setTextColor(ContextCompat.getColor(H(), 2131099718));
            L().tvDistanceStatus.setText("未达标");
            L().tvDistanceStatus.setTextColor(ContextCompat.getColor(H(), 2131099718));
            z5 = false;
        } else {
            L().tvDistance.setTextColor(ContextCompat.getColor(H(), 2131099731));
            L().tvDistanceStatus.setText("已达标");
            L().tvDistanceStatus.setTextColor(ContextCompat.getColor(H(), R.color.v3_tab_color2));
            z5 = true;
        }
        L().tvTime.setText(com.bxkj.base.v2.common.utils.g.b(aVar.e()));
        int k6 = c0Var.k(D().M(), "startQualifiedTime");
        int b6 = aVar.b();
        if (aVar.e() >= k6 * 60 && (b6 == -1 || aVar.e() <= b6 * 60)) {
            L().tvTime.setTextColor(ContextCompat.getColor(H(), 2131099731));
            L().tvTimeStatus.setText("已达标");
            L().tvTimeStatus.setTextColor(ContextCompat.getColor(H(), R.color.v3_tab_color2));
        } else {
            L().tvTime.setTextColor(ContextCompat.getColor(H(), 2131099718));
            L().tvTimeStatus.setText("未达标");
            L().tvTimeStatus.setTextColor(ContextCompat.getColor(H(), 2131099718));
            z5 = false;
        }
        L().tvStep.setText(aVar.G() + "步");
        if (aVar.G() < aVar.a()) {
            L().tvStep.setTextColor(ContextCompat.getColor(H(), 2131099718));
            L().tvStepStatus.setText("未达标");
            L().tvStepStatus.setTextColor(ContextCompat.getColor(H(), 2131099718));
            z5 = false;
        } else {
            L().tvStep.setTextColor(ContextCompat.getColor(H(), 2131099731));
            L().tvStepStatus.setText("已达标");
            L().tvStepStatus.setTextColor(ContextCompat.getColor(H(), R.color.v3_tab_color2));
        }
        if (aVar.x().size() < c0Var.n(D().M(), "list").size()) {
            return false;
        }
        return z5;
    }

    private final void v0() {
        String str;
        if (System.currentTimeMillis() - this.f21544m < this.f21545n) {
            return;
        }
        this.f21544m = System.currentTimeMillis();
        if (!q0()) {
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(H(), R.style.run_type_dialog);
            bottomSheetDialog.setContentView(R.layout.dialog_bottom_sheet_dialog);
            TextView textView = (TextView) bottomSheetDialog.findViewById(R.id.tv_continue);
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        V3SportsFinishDialog.w0(BottomSheetDialog.this, view);
                    }
                });
            }
            TextView textView2 = (TextView) bottomSheetDialog.findViewById(R.id.tv_stop);
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        V3SportsFinishDialog.x0(V3SportsFinishDialog.this, view);
                    }
                });
            }
            bottomSheetDialog.show();
            this.f21546o = bottomSheetDialog;
            return;
        }
        if (r0()) {
            str = "1";
        } else {
            str = "0";
        }
        e0(str, "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(BottomSheetDialog bottomSheetDialog, View view) {
        bottomSheetDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(final V3SportsFinishDialog v3SportsFinishDialog, View view) {
        v3SportsFinishDialog.D().G(new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 y02;
                y02 = V3SportsFinishDialog.y0(V3SportsFinishDialog.this);
                return y02;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 y0(V3SportsFinishDialog v3SportsFinishDialog) {
        v3SportsFinishDialog.j0();
        return n1.f44123a;
    }

    public final void Z() {
        if (System.currentTimeMillis() - this.f21544m < this.f21545n) {
            return;
        }
        this.f21544m = System.currentTimeMillis();
        if (kotlin.jvm.internal.g0.g(com.bxkj.student.v2.common.data.i.f20657a.k().getValue(), Boolean.FALSE)) {
            Function0<Boolean> function0 = this.f21543l;
            if (function0 != null && function0.invoke().booleanValue()) {
                return;
            }
            dismiss();
            return;
        }
        D().P(new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 a02;
                a02 = V3SportsFinishDialog.a0(V3SportsFinishDialog.this);
                return a02;
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, R.style.V2AppTheme);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        WindowManager windowManager;
        Display defaultDisplay;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            FragmentActivity r5 = r();
            if (r5 != null && (windowManager = r5.getWindowManager()) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
                defaultDisplay.getMetrics(displayMetrics);
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(2131100584);
                window.setLayout((int) (displayMetrics.widthPixels * 0.9d), (int) (displayMetrics.heightPixels * 0.8d));
            }
            dialog.setCanceledOnTouchOutside(false);
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        SportsVM D = D();
        i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
        D.S(aVar.B());
        L().setDialog(this);
        AcV3SportsFinishBinding L = L();
        com.bxkj.base.v2.common.utils.c0 c0Var = com.bxkj.base.v2.common.utils.c0.f16887a;
        L.setSportType(c0Var.k(aVar.B(), "runType"));
        L().setTipsText(c0Var.t(D().M(), "contextV2"));
        L().tvDistanceTag.setText("达标里程:" + c0Var.t(D().M(), "totalRange") + "公里");
        L().cpDistance.j(c0Var.i(D().M(), "totalRange"));
        L().cpDistance.k((float) com.bxkj.student.run.app.utils.i.e(aVar.g()));
        L().tvTimeTarget.setText("有效时间:" + c0Var.t(D().M(), "startQualifiedTime") + "-" + c0Var.t(D().M(), "endQualifiedTime") + "分钟");
        L().cpTime.j(c0Var.i(D().M(), "startQualifiedTime"));
        L().cpTime.k(((float) aVar.e()) / 60.0f);
        Integer valueOf = Integer.valueOf(aVar.b());
        if (valueOf.intValue() == -1) {
            valueOf = null;
        }
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            L().cpTime.l(intValue);
            L().tvTimeTarget.setText("有效时间:" + c0Var.t(D().M(), "startQualifiedTime") + "-" + intValue + "分钟");
        }
        int a6 = aVar.a();
        L().tvStepTarget.setText("达标步数:" + a6 + "步");
        L().cpStep.j((float) a6);
        L().cpStep.k((float) aVar.G());
        i0();
        r0();
        L().btOk.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                V3SportsFinishDialog.p0(V3SportsFinishDialog.this, view);
            }
        });
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
