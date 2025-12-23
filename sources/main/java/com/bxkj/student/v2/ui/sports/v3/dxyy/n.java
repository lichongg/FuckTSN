package com.bxkj.student.v2.ui.sports.v3.dxyy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.qrcode.b;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.R;
import com.bxkj.student.v2.ui.sports.v3.dxyy.ar.ARActivity;
import com.bxkj.student.v2.ui.sports.v3.dxyy.n;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import t.b;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDxyyTypeDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DxyyTypeDialog.kt\ncom/bxkj/student/v2/ui/sports/v3/dxyy/DxyyTypeDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,297:1\n1#2:298\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final FragmentActivity f21775a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ iOSOneButtonDialog f21776a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f21777b;

        @Override // u.b.a
        public void a(int i6, Intent intent) {
            com.orhanobut.logger.j.d("定向越野AR识别返回", new Object[0]);
            com.orhanobut.logger.j.d("result:" + (intent != null ? intent.getStringExtra("result") : null), new Object[0]);
            this.f21776a.dismiss();
            this.f21777b.invoke();
        }

        a(iOSOneButtonDialog iosonebuttondialog, Function0<n1> function0) {
            this.f21776a = iosonebuttondialog;
            this.f21777b = function0;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nDxyyTypeDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DxyyTypeDialog.kt\ncom/bxkj/student/v2/ui/sports/v3/dxyy/DxyyTypeDialog$camera$2$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,297:1\n1#2:298\n*E\n"})
    public static final class b implements b.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ iOSOneButtonDialog f21779b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f21780c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nDxyyTypeDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DxyyTypeDialog.kt\ncom/bxkj/student/v2/ui/sports/v3/dxyy/DxyyTypeDialog$camera$2$1$camera$2$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,297:1\n1#2:298\n*E\n"})
        public static final class a implements b.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ iOSOneButtonDialog f21781a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function0<n1> f21782b;

            a(iOSOneButtonDialog iosonebuttondialog, Function0<n1> function0) {
                this.f21781a = iosonebuttondialog;
                this.f21782b = function0;
            }

            @Override // u.b.a
            public void a(int i6, Intent intent) {
                Integer valueOf = Integer.valueOf(i6);
                if (valueOf.intValue() != -1) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    iOSOneButtonDialog iosonebuttondialog = this.f21781a;
                    Function0<n1> function0 = this.f21782b;
                    com.orhanobut.logger.j.d("定向越野拍照返回", new Object[0]);
                    iosonebuttondialog.dismiss();
                    function0.invoke();
                }
            }
        }

        b(iOSOneButtonDialog iosonebuttondialog, Function0<n1> function0) {
            this.f21779b = iosonebuttondialog;
            this.f21780c = function0;
        }

        @Override // t.b.a
        public void b(String[] permission) {
            g0.p(permission, "permission");
            ContextExtKt.m(n.this.A(), "你拒接了拍照无法完成AR识别");
        }

        @Override // t.b.a
        public void c(String[] permission) {
            g0.p(permission, "permission");
            ContextExtKt.m(n.this.A(), "你拒接了拍照无法完成AR识别");
        }

        @Override // t.b.a
        public void a() {
            d();
        }

        public final void d() {
            File file;
            Uri uriForFile;
            if (e()) {
                if (g0.g("mounted", Environment.getExternalStorageState())) {
                    file = n.this.A().getExternalCacheDir();
                    if (file != null && !file.exists()) {
                        file.mkdirs();
                    }
                } else {
                    file = null;
                }
                if (file == null || !file.exists()) {
                    file = n.this.A().getCacheDir();
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                }
                File file2 = new File(file, "avatar");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                File file3 = new File(file2, System.currentTimeMillis() + "_temp_photo.jpg");
                if (Build.VERSION.SDK_INT < 24) {
                    uriForFile = Uri.fromFile(file3);
                    g0.m(uriForFile);
                } else {
                    uriForFile = FileProvider.getUriForFile(n.this.A(), "com.bxkj.student.provider", file3);
                    g0.m(uriForFile);
                }
                Intent intent = new Intent();
                intent.putExtra("output", uriForFile);
                intent.setAction("android.media.action.IMAGE_CAPTURE");
                intent.addFlags(1);
                intent.addCategory("android.intent.category.DEFAULT");
                Activity a6 = com.bxkj.student.v2.common.utils.a.f20868a.a();
                if (a6 == null) {
                    a6 = n.this.A();
                }
                g0.n(a6, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                new u.b((FragmentActivity) a6).startActivityForResult(intent).c(new a(this.f21779b, this.f21780c));
                return;
            }
            ContextExtKt.q(n.this.A(), "未找到存储卡，无法拍照！");
        }

        public final boolean e() {
            return g0.g(Environment.getExternalStorageState(), "mounted");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.dxyy.DxyyTypeDialog$questionDialog$2$1", f = "DxyyTypeDialog.kt", i = {1, 1, 1, 1}, l = {77, 81}, m = "invokeSuspend", n = {"exerciseQuestion", "question", "answers", "isRight"}, s = {"L$0", "L$1", "L$2", "I$0"})
    static final class c extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f21783a;

        /* renamed from: b, reason: collision with root package name */
        Object f21784b;

        /* renamed from: c, reason: collision with root package name */
        Object f21785c;

        /* renamed from: d, reason: collision with root package name */
        int f21786d;

        /* renamed from: e, reason: collision with root package name */
        int f21787e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ iOSOneButtonDialog f21788f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f21789g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f21790h;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.dxyy.DxyyTypeDialog$questionDialog$2$1$1", f = "DxyyTypeDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        @SourceDebugExtension({"SMAP\nDxyyTypeDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DxyyTypeDialog.kt\ncom/bxkj/student/v2/ui/sports/v3/dxyy/DxyyTypeDialog$questionDialog$2$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,297:1\n1869#2,2:298\n*S KotlinDebug\n*F\n+ 1 DxyyTypeDialog.kt\ncom/bxkj/student/v2/ui/sports/v3/dxyy/DxyyTypeDialog$questionDialog$2$1$1\n*L\n93#1:298,2\n*E\n"})
        static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f21791a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ iOSOneButtonDialog f21792b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ n f21793c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f21794d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ List<Map<String, Object>> f21795e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Function0<n1> f21796f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(iOSOneButtonDialog iosonebuttondialog, n nVar, String str, List<? extends Map<String, ? extends Object>> list, Function0<n1> function0, kotlin.coroutines.e<? super a> eVar) {
                super(2, eVar);
                this.f21792b = iosonebuttondialog;
                this.f21793c = nVar;
                this.f21794d = str;
                this.f21795e = list;
                this.f21796f = function0;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new a(this.f21792b, this.f21793c, this.f21794d, this.f21795e, this.f21796f, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void i(iOSOneButtonDialog iosonebuttondialog, n nVar, List list, Function0 function0, View view) {
                RadioGroup radioGroup = (RadioGroup) iosonebuttondialog.findViewById(R.id.rg_answer);
                if (radioGroup != null) {
                    com.orhanobut.logger.j.d("checkedRadioButtonId:" + radioGroup.getCheckedRadioButtonId(), new Object[0]);
                    if (radioGroup.getCheckedRadioButtonId() == -1) {
                        ContextExtKt.q(nVar.A(), "请答题");
                    } else if (c0.f16887a.k((Map) list.get(radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()))), "isRight") == 1) {
                        iosonebuttondialog.dismiss();
                        function0.invoke();
                    } else {
                        ContextExtKt.q(nVar.A(), "回答错误");
                    }
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f21791a == 0) {
                    kotlin.g0.n(obj);
                    this.f21792b.dismiss();
                    Activity a6 = com.bxkj.student.v2.common.utils.a.f20868a.a();
                    if (a6 == null) {
                        a6 = this.f21793c.A();
                    }
                    final iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(a6);
                    iOSOneButtonDialog centerCustomView = iosonebuttondialog.setTitle("请完成答题以继续").setCenterCustomView(R.layout.ys_dialog_question);
                    String str = this.f21794d;
                    List<Map<String, Object>> list = this.f21795e;
                    n nVar = this.f21793c;
                    centerCustomView.setCanceledOnTouchOutside(false);
                    centerCustomView.setCancelable(false);
                    centerCustomView.setClickAutoCancel(false);
                    TextView textView = (TextView) centerCustomView.findViewById(R.id.tv_question);
                    if (textView != null) {
                        textView.setText(str);
                    }
                    RadioGroup radioGroup = (RadioGroup) centerCustomView.findViewById(R.id.rg_answer);
                    if (radioGroup != null) {
                        radioGroup.removeAllViews();
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            Map<String, ? extends Object> map = (Map) it.next();
                            RadioButton radioButton = new RadioButton(nVar.A());
                            c0 c0Var = c0.f16887a;
                            radioButton.setText(c0Var.t(map, "mark") + "." + c0Var.t(map, "answer"));
                            radioGroup.addView(radioButton);
                        }
                    }
                    final n nVar2 = this.f21793c;
                    final List<Map<String, Object>> list2 = this.f21795e;
                    final Function0<n1> function0 = this.f21796f;
                    centerCustomView.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.dxyy.o
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            n.c.a.i(iOSOneButtonDialog.this, nVar2, list2, function0, view);
                        }
                    }).show();
                    return n1.f44123a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(iOSOneButtonDialog iosonebuttondialog, n nVar, Function0<n1> function0, kotlin.coroutines.e<? super c> eVar) {
            super(2, eVar);
            this.f21788f = iosonebuttondialog;
            this.f21789g = nVar;
            this.f21790h = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new c(this.f21788f, this.f21789g, this.f21790h, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x007d, code lost:
        
            if (kotlinx.coroutines.i.h(r1, r4, r11) == r0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x007f, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
        
            if (r12 == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r11.f21787e
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2a
                if (r1 == r3) goto L26
                if (r1 != r2) goto L1e
                java.lang.Object r0 = r11.f21785c
                java.util.List r0 = (java.util.List) r0
                java.lang.Object r0 = r11.f21784b
                java.lang.String r0 = (java.lang.String) r0
                java.lang.Object r0 = r11.f21783a
                java.util.Map r0 = (java.util.Map) r0
                kotlin.g0.n(r12)
                goto L80
            L1e:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L26:
                kotlin.g0.n(r12)
                goto L3c
            L2a:
                kotlin.g0.n(r12)
                com.bxkj.student.v2.retrofit.e r12 = com.bxkj.student.v2.retrofit.e.f21288a
                com.bxkj.student.v2.retrofit.b r12 = r12.c()
                r11.f21787e = r3
                java.lang.Object r12 = r12.H(r11)
                if (r12 != r0) goto L3c
                goto L7f
            L3c:
                com.bxkj.base.v2.http.result.ApiResult r12 = (com.bxkj.base.v2.http.result.ApiResult) r12
                java.lang.Object r12 = r12.apiData()
                java.util.Map r12 = (java.util.Map) r12
                com.bxkj.base.v2.common.utils.c0 r1 = com.bxkj.base.v2.common.utils.c0.f16887a
                java.lang.String r3 = "question"
                java.lang.String r7 = r1.t(r12, r3)
                java.lang.String r3 = "answers"
                java.util.List r8 = r1.n(r12, r3)
                kotlinx.coroutines.p2 r1 = kotlinx.coroutines.g1.e()
                com.bxkj.student.v2.ui.sports.v3.dxyy.n$c$a r4 = new com.bxkj.student.v2.ui.sports.v3.dxyy.n$c$a
                cn.bluemobi.dylan.base.view.iOSOneButtonDialog r5 = r11.f21788f
                com.bxkj.student.v2.ui.sports.v3.dxyy.n r6 = r11.f21789g
                kotlin.jvm.functions.Function0<kotlin.n1> r9 = r11.f21790h
                r10 = 0
                r4.<init>(r5, r6, r7, r8, r9, r10)
                java.lang.Object r12 = kotlin.coroutines.jvm.internal.j.a(r12)
                r11.f21783a = r12
                java.lang.Object r12 = kotlin.coroutines.jvm.internal.j.a(r7)
                r11.f21784b = r12
                java.lang.Object r12 = kotlin.coroutines.jvm.internal.j.a(r8)
                r11.f21785c = r12
                r12 = 0
                r11.f21786d = r12
                r11.f21787e = r2
                java.lang.Object r12 = kotlinx.coroutines.i.h(r1, r4, r11)
                if (r12 != r0) goto L80
            L7f:
                return r0
            L80:
                kotlin.n1 r12 = kotlin.n1.f44123a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.ui.sports.v3.dxyy.n.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.dxyy.DxyyTypeDialog$scanQrCode$2$2$1", f = "DxyyTypeDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21797a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ iOSOneButtonDialog f21799c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f21800d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class a implements b.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ iOSOneButtonDialog f21801a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function0<n1> f21802b;

            a(iOSOneButtonDialog iosonebuttondialog, Function0<n1> function0) {
                this.f21801a = iosonebuttondialog;
                this.f21802b = function0;
            }

            @Override // com.bxkj.base.v2.common.qrcode.b.a
            public void a(String result) {
                g0.p(result, "result");
                com.orhanobut.logger.j.d("定向越野扫码返回", new Object[0]);
                com.orhanobut.logger.j.d("result:" + result, new Object[0]);
                this.f21801a.dismiss();
                this.f21802b.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(iOSOneButtonDialog iosonebuttondialog, Function0<n1> function0, kotlin.coroutines.e<? super d> eVar) {
            super(2, eVar);
            this.f21799c = iosonebuttondialog;
            this.f21800d = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return n.this.new d(this.f21799c, this.f21800d, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((d) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f21797a == 0) {
                kotlin.g0.n(obj);
                new com.bxkj.base.v2.common.qrcode.b(n.this.A()).m(new a(this.f21799c, this.f21800d));
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public n(@NotNull FragmentActivity mActivity, int i6, @NotNull final Function0<n1> continueRun) {
        g0.p(mActivity, "mActivity");
        g0.p(continueRun, "continueRun");
        this.f21775a = mActivity;
        if (i6 == 0) {
            continueRun.invoke();
            return;
        }
        if (i6 == 1) {
            B(new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.dxyy.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    n1 o5;
                    o5 = n.o(Function0.this);
                    return o5;
                }
            });
            return;
        }
        if (i6 == 2) {
            s(new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.dxyy.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    n1 p5;
                    p5 = n.p(Function0.this);
                    return p5;
                }
            });
        } else if (i6 == 3) {
            F(new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.dxyy.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    n1 q5;
                    q5 = n.q(Function0.this);
                    return q5;
                }
            });
        } else {
            if (i6 != 4) {
                return;
            }
            w(new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.dxyy.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    n1 r5;
                    r5 = n.r(Function0.this);
                    return r5;
                }
            });
        }
    }

    private final void B(final Function0<n1> function0) {
        iOSOneButtonDialog o5;
        Activity a6 = com.bxkj.student.v2.common.utils.a.f20868a.a();
        if (a6 == null || (o5 = ContextExtKt.o(a6, "请完成答题以继续", new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.dxyy.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 E;
                E = n.E(n.this, function0, (iOSOneButtonDialog) obj);
                return E;
            }
        })) == null) {
            return;
        }
        o5.setCanceledOnTouchOutside(false);
        o5.setCancelable(false);
        o5.setClickAutoCancel(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void C(n nVar, Function0 function0, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            function0 = new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.dxyy.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    n1 D;
                    D = n.D();
                    return D;
                }
            };
        }
        nVar.B(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 D() {
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 E(n nVar, Function0 function0, iOSOneButtonDialog dialog) {
        g0.p(dialog, "dialog");
        kotlinx.coroutines.k.f(LifecycleOwnerKt.getLifecycleScope(nVar.f21775a), g1.c(), null, new c(dialog, nVar, function0, null), 2, null);
        return n1.f44123a;
    }

    private final void F(final Function0<n1> function0) {
        iOSOneButtonDialog o5;
        Activity a6 = com.bxkj.student.v2.common.utils.a.f20868a.a();
        if (a6 == null || (o5 = ContextExtKt.o(a6, "请完成扫码以继续", new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.dxyy.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 I;
                I = n.I(n.this, function0, (iOSOneButtonDialog) obj);
                return I;
            }
        })) == null) {
            return;
        }
        o5.setCanceledOnTouchOutside(false);
        o5.setCancelable(false);
        o5.setClickAutoCancel(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void G(n nVar, Function0 function0, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            function0 = new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.dxyy.m
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    n1 H;
                    H = n.H();
                    return H;
                }
            };
        }
        nVar.F(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 H() {
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 I(n nVar, Function0 function0, iOSOneButtonDialog dialog) {
        g0.p(dialog, "dialog");
        Activity a6 = com.bxkj.student.v2.common.utils.a.f20868a.a();
        if (a6 == null) {
            a6 = nVar.f21775a;
        }
        g0.n(a6, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        kotlinx.coroutines.k.f(LifecycleOwnerKt.getLifecycleScope(nVar.f21775a), g1.e(), null, nVar.new d(dialog, function0, null), 2, null);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 n() {
        return n1.f44123a;
    }

    private final void s(final Function0<n1> function0) {
        iOSOneButtonDialog o5;
        Activity a6 = com.bxkj.student.v2.common.utils.a.f20868a.a();
        if (a6 == null || (o5 = ContextExtKt.o(a6, "请完成AR识图以继续", new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.dxyy.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 u5;
                u5 = n.u(n.this, function0, (iOSOneButtonDialog) obj);
                return u5;
            }
        })) == null) {
            return;
        }
        o5.setCanceledOnTouchOutside(false);
        o5.setCancelable(false);
        o5.setClickAutoCancel(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void t(n nVar, Function0 function0, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            function0 = new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.dxyy.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    n1 v5;
                    v5 = n.v();
                    return v5;
                }
            };
        }
        nVar.s(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 u(n nVar, Function0 function0, iOSOneButtonDialog dialog) {
        g0.p(dialog, "dialog");
        Activity a6 = com.bxkj.student.v2.common.utils.a.f20868a.a();
        if (a6 == null) {
            a6 = nVar.f21775a;
        }
        g0.n(a6, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        new u.b((FragmentActivity) a6).startActivityForResult(new Intent(nVar.f21775a, (Class<?>) ARActivity.class)).c(new a(dialog, function0));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 v() {
        return n1.f44123a;
    }

    private final void w(final Function0<n1> function0) {
        iOSOneButtonDialog o5;
        Activity a6 = com.bxkj.student.v2.common.utils.a.f20868a.a();
        if (a6 == null || (o5 = ContextExtKt.o(a6, "请完成拍照以继续", new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.dxyy.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 z5;
                z5 = n.z(n.this, function0, (iOSOneButtonDialog) obj);
                return z5;
            }
        })) == null) {
            return;
        }
        o5.setCanceledOnTouchOutside(false);
        o5.setCancelable(false);
        o5.setClickAutoCancel(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void x(n nVar, Function0 function0, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            function0 = new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.dxyy.l
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    n1 y5;
                    y5 = n.y();
                    return y5;
                }
            };
        }
        nVar.w(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 y() {
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 z(n nVar, Function0 function0, iOSOneButtonDialog dialog) {
        g0.p(dialog, "dialog");
        new t.b(nVar.f21775a).c("android.permission.CAMERA").d(nVar.new b(dialog, function0));
        return n1.f44123a;
    }

    @NotNull
    public final FragmentActivity A() {
        return this.f21775a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 o(Function0 function0) {
        function0.invoke();
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 p(Function0 function0) {
        function0.invoke();
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 q(Function0 function0) {
        function0.invoke();
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 r(Function0 function0) {
        function0.invoke();
        return n1.f44123a;
    }

    public /* synthetic */ n(FragmentActivity fragmentActivity, int i6, Function0 function0, int i7, v vVar) {
        this(fragmentActivity, i6, (i7 & 4) != 0 ? new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.dxyy.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 n6;
                n6 = n.n();
                return n6;
            }
        } : function0);
    }
}
