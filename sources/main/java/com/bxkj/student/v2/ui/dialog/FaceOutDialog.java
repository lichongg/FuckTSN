package com.bxkj.student.v2.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.bxkj.base.v2.base.BaseDialog;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.databinding.FaceOutOfCompassBinding;
import com.bxkj.student.v2.ui.dialog.FaceOutDialog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class FaceOutDialog extends BaseDialog<FaceOutOfCompassBinding, BaseViewModel> {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final b f21310r = new b(null);

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private Function1<? super DialogFragment, n1> f21315o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    private Function1<? super DialogFragment, n1> f21316p;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private CharSequence f21311k = "本次跑步记录无效";

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private CharSequence f21312l = "本次跑步记录无效";

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private CharSequence f21313m = "结束跑步";

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private CharSequence f21314n = "";

    /* renamed from: q, reason: collision with root package name */
    private boolean f21317q = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nFaceOutDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FaceOutDialog.kt\ncom/bxkj/student/v2/ui/dialog/FaceOutDialog$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,216:1\n1#2:217\n*E\n"})
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f21318a = "系统检测到您中途第1次人脸识别超出100米允许识别范围，本次跑步无效，白跑啦！请点击下方结束跑步按钮结束本次跑步，请下次弹出中途人脸识别时及时在有效范围内进行识别！";

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final String f21319b = "由于您中途人脸识别超出100米允许识别范围，本次跑步已无效！是否继续进行结束人脸识别？";

        /* renamed from: c, reason: collision with root package name */
        private boolean f21320c = true;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private CharSequence f21321d = "本次跑步记录无效";

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        private CharSequence f21322e = "本次跑步记录无效";

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        private CharSequence f21323f = "结束跑步";

        /* renamed from: g, reason: collision with root package name */
        @NotNull
        private CharSequence f21324g = "";

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        private Function1<? super DialogFragment, n1> f21325h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        private Function1<? super DialogFragment, n1> f21326i;

        @NotNull
        public final FaceOutDialog a() {
            FaceOutDialog faceOutDialog = new FaceOutDialog();
            faceOutDialog.T(this.f21321d);
            faceOutDialog.Q(this.f21322e);
            faceOutDialog.P(this.f21323f);
            faceOutDialog.S(this.f21324g);
            faceOutDialog.O(this.f21325h);
            faceOutDialog.R(this.f21326i);
            faceOutDialog.N(this.f21320c);
            return faceOutDialog;
        }

        @NotNull
        public final String b() {
            return this.f21319b;
        }

        @NotNull
        public final String c() {
            return this.f21318a;
        }

        @NotNull
        public final a d(boolean z5) {
            this.f21320c = z5;
            return this;
        }

        @NotNull
        public final a e(@NotNull CharSequence text) {
            g0.p(text, "text");
            this.f21323f = text;
            return this;
        }

        @NotNull
        public final a f(@Nullable Function1<? super DialogFragment, n1> function1) {
            this.f21325h = function1;
            return this;
        }

        @NotNull
        public final a g(@NotNull CharSequence msg) {
            g0.p(msg, "msg");
            this.f21322e = msg;
            return this;
        }

        @NotNull
        public final a h(@NotNull CharSequence text) {
            g0.p(text, "text");
            this.f21324g = text;
            return this;
        }

        @NotNull
        public final a i(@Nullable Function1<? super DialogFragment, n1> function1) {
            this.f21326i = function1;
            return this;
        }

        @NotNull
        public final a j(@NotNull CharSequence title) {
            g0.p(title, "title");
            this.f21321d = title;
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {
        public /* synthetic */ b(v vVar) {
            this();
        }

        private b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FaceOutDialog e(b bVar, int i6, int i7, FragmentManager fragmentManager, Function1 function1, int i8, Object obj) {
            if ((i8 & 8) != 0) {
                function1 = null;
            }
            return bVar.d(i6, i7, fragmentManager, function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 f(Function1 function1, DialogFragment dialog) {
            g0.p(dialog, "dialog");
            if (function1 != null) {
                function1.invoke(dialog);
            }
            return n1.f44123a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FaceOutDialog h(b bVar, int i6, int i7, FragmentManager fragmentManager, Function1 function1, Function1 function12, int i8, Object obj) {
            if ((i8 & 8) != 0) {
                function1 = null;
            }
            if ((i8 & 16) != 0) {
                function12 = null;
            }
            return bVar.g(i6, i7, fragmentManager, function1, function12);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 i(Function1 function1, DialogFragment dialog) {
            g0.p(dialog, "dialog");
            if (function1 != null) {
                function1.invoke(dialog);
            }
            return n1.f44123a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 j(Function1 function1, DialogFragment dialog) {
            g0.p(dialog, "dialog");
            if (function1 != null) {
                function1.invoke(dialog);
            }
            return n1.f44123a;
        }

        @NotNull
        public final FaceOutDialog d(int i6, int i7, @NotNull FragmentManager fragmentManager, @Nullable final Function1<? super DialogFragment, n1> function1) {
            g0.p(fragmentManager, "fragmentManager");
            FaceOutDialog a6 = new a().g("系统检测到您中途第" + i6 + "次人脸识别超出" + i7 + "米允许识别范围，本次跑步无效，白跑啦！请点击下方结束跑步按钮结束本次跑步，请下次弹出中途人脸识别时及时在有效范围内进行识别！").e("结束跑步").f(new Function1() { // from class: com.bxkj.student.v2.ui.dialog.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 f6;
                    f6 = FaceOutDialog.b.f(Function1.this, (DialogFragment) obj);
                    return f6;
                }
            }).h("").d(false).a();
            a6.h(fragmentManager);
            return a6;
        }

        @NotNull
        public final FaceOutDialog g(int i6, int i7, @NotNull FragmentManager fragmentManager, @Nullable final Function1<? super DialogFragment, n1> function1, @Nullable final Function1<? super DialogFragment, n1> function12) {
            g0.p(fragmentManager, "fragmentManager");
            FaceOutDialog a6 = new a().g("由于您中途第" + i6 + "次人脸识别超出" + i7 + "米允许识别范围，本次跑步已无效！是否继续进行结束人脸识别？").e("直接提交").f(new Function1() { // from class: com.bxkj.student.v2.ui.dialog.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 i8;
                    i8 = FaceOutDialog.b.i(Function1.this, (DialogFragment) obj);
                    return i8;
                }
            }).h("人脸识别").i(new Function1() { // from class: com.bxkj.student.v2.ui.dialog.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 j6;
                    j6 = FaceOutDialog.b.j(Function1.this, (DialogFragment) obj);
                    return j6;
                }
            }).d(false).a();
            a6.h(fragmentManager);
            return a6;
        }
    }

    public final void M() {
        Function1<? super DialogFragment, n1> function1 = this.f21316p;
        if (function1 != null) {
            function1.invoke(this);
        }
    }

    public final void N(boolean z5) {
        this.f21317q = z5;
    }

    public final void O(@Nullable Function1<? super DialogFragment, n1> function1) {
        this.f21315o = function1;
    }

    public final void P(@NotNull CharSequence text) {
        g0.p(text, "text");
        this.f21313m = text;
    }

    public final void Q(@NotNull CharSequence msg) {
        g0.p(msg, "msg");
        this.f21312l = msg;
    }

    public final void R(@Nullable Function1<? super DialogFragment, n1> function1) {
        this.f21316p = function1;
    }

    public final void S(@NotNull CharSequence text) {
        g0.p(text, "text");
        this.f21314n = text;
    }

    public final void T(@NotNull CharSequence title) {
        g0.p(title, "title");
        this.f21311k = title;
    }

    @Override // com.bxkj.base.v2.base.BaseDialog
    protected void e() {
        if (this.f21317q) {
            super.e();
        }
    }

    public final void n() {
        Function1<? super DialogFragment, n1> function1 = this.f21315o;
        if (function1 != null) {
            function1.invoke(this);
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        setCancelable(this.f21317q);
        L().setDialog(this);
        L().tvTitle.setText(this.f21311k);
        L().textMessage.setText(this.f21312l);
        L().btnOne.setText(this.f21313m);
        L().btnTwo.setText(this.f21314n);
        if (u.M3(this.f21311k)) {
            L().tvTitle.setVisibility(8);
        }
        if (u.M3(this.f21312l)) {
            L().textMessage.setVisibility(8);
        }
        if (u.M3(this.f21313m)) {
            L().btnTwo.setVisibility(8);
        }
        if (u.M3(this.f21314n)) {
            L().btnTwo.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, 2132017957);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            window = dialog.getWindow();
        } else {
            window = null;
        }
        if (window != null) {
            window.setLayout(-2, -2);
            window.setBackgroundDrawableResource(2131100584);
            window.setGravity(17);
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
