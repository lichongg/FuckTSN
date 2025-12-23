package com.bxkj.student.v2.ui.sports.v3.detail.tab;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.databinding.FmV3SportsChartBinding;
import com.bxkj.student.v2.common.utils.r;
import com.bxkj.student.v2.vm.sports.record.RecordDetailVM;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartZoomType;
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle;
import com.github.aachartmodel.aainfographics.aatools.AAColorKt;
import com.github.aachartmodel.aainfographics.aatools.AAGradientColor;
import com.github.aachartmodel.aainfographics.aatools.AALinearGradientDirection;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.b0;
import kotlin.n;
import kotlin.n1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nV3RecordChartFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3RecordChartFragment.kt\ncom/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordChartFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,259:1\n1878#2,3:260\n1878#2,3:265\n37#3,2:263\n37#3,2:268\n*S KotlinDebug\n*F\n+ 1 V3RecordChartFragment.kt\ncom/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordChartFragment\n*L\n162#1:260,3\n219#1:265,3\n191#1:263,2\n249#1:268,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3RecordChartFragment extends BaseFragment<FmV3SportsChartBinding, RecordDetailVM> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$initStepChart$1", f = "V3RecordChartFragment.kt", i = {0, 1, 1, 2, 2, 2}, l = {200, 205, 210}, m = "invokeSuspend", n = {"avgStep", "avgStep", "maxStep", "avgStep", "maxStep", "stepChartModel"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f21622a;

        /* renamed from: b, reason: collision with root package name */
        Object f21623b;

        /* renamed from: c, reason: collision with root package name */
        Object f21624c;

        /* renamed from: d, reason: collision with root package name */
        int f21625d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<Integer> f21626e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ V3RecordChartFragment f21627f;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$initStepChart$1$1", f = "V3RecordChartFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$a$a, reason: collision with other inner class name */
        static final class C0296a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f21628a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ V3RecordChartFragment f21629b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f21630c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0296a(V3RecordChartFragment v3RecordChartFragment, String str, kotlin.coroutines.e<? super C0296a> eVar) {
                super(2, eVar);
                this.f21629b = v3RecordChartFragment;
                this.f21630c = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new C0296a(this.f21629b, this.f21630c, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((C0296a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f21628a == 0) {
                    g0.n(obj);
                    this.f21629b.L().tvAvgStep.setText(this.f21630c);
                    return n1.f44123a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$initStepChart$1$2", f = "V3RecordChartFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class b extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f21631a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ V3RecordChartFragment f21632b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f21633c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(V3RecordChartFragment v3RecordChartFragment, String str, kotlin.coroutines.e<? super b> eVar) {
                super(2, eVar);
                this.f21632b = v3RecordChartFragment;
                this.f21633c = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new b(this.f21632b, this.f21633c, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((b) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f21631a == 0) {
                    g0.n(obj);
                    this.f21632b.L().tvBestStep.setText(this.f21633c);
                    return n1.f44123a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$initStepChart$1$3", f = "V3RecordChartFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class c extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f21634a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ V3RecordChartFragment f21635b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ AAChartModel f21636c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(V3RecordChartFragment v3RecordChartFragment, AAChartModel aAChartModel, kotlin.coroutines.e<? super c> eVar) {
                super(2, eVar);
                this.f21635b = v3RecordChartFragment;
                this.f21636c = aAChartModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new c(this.f21635b, this.f21636c, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((c) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f21634a == 0) {
                    g0.n(obj);
                    this.f21635b.L().AAChartViewStep.aa_drawChartWithChartModel(this.f21636c);
                    return n1.f44123a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List<Integer> list, V3RecordChartFragment v3RecordChartFragment, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f21626e = list;
            this.f21627f = v3RecordChartFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new a(this.f21626e, this.f21627f, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x00d1, code lost:
        
            if (kotlinx.coroutines.i.h(r4, r6, r8) != r0) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x006c, code lost:
        
            if (kotlinx.coroutines.i.h(r1, r6, r8) == r0) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r8.f21625d
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L41
                if (r1 == r4) goto L38
                if (r1 == r3) goto L2b
                if (r1 != r2) goto L23
                java.lang.Object r0 = r8.f21624c
                com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel r0 = (com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel) r0
                java.lang.Object r0 = r8.f21623b
                java.lang.String r0 = (java.lang.String) r0
                java.lang.Object r0 = r8.f21622a
                java.lang.String r0 = (java.lang.String) r0
                kotlin.g0.n(r9)
                goto Ld4
            L23:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L2b:
                java.lang.Object r1 = r8.f21623b
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r3 = r8.f21622a
                java.lang.String r3 = (java.lang.String) r3
                kotlin.g0.n(r9)
                goto La6
            L38:
                java.lang.Object r1 = r8.f21622a
                java.lang.String r1 = (java.lang.String) r1
                kotlin.g0.n(r9)
                r9 = r1
                goto L6f
            L41:
                kotlin.g0.n(r9)
                java.util.List<java.lang.Integer> r9 = r8.f21626e
                java.lang.Iterable r9 = (java.lang.Iterable) r9
                double r6 = kotlin.collections.f0.Q1(r9)
                double r6 = java.lang.Math.floor(r6)
                int r9 = (int) r6
                java.lang.String r9 = java.lang.String.valueOf(r9)
                kotlinx.coroutines.p2 r1 = kotlinx.coroutines.g1.e()
                com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$a$a r6 = new com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$a$a
                com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment r7 = r8.f21627f
                r6.<init>(r7, r9, r5)
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.j.a(r9)
                r8.f21622a = r7
                r8.f21625d = r4
                java.lang.Object r1 = kotlinx.coroutines.i.h(r1, r6, r8)
                if (r1 != r0) goto L6f
                goto Ld3
            L6f:
                java.util.List<java.lang.Integer> r1 = r8.f21626e
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.lang.Comparable r1 = kotlin.collections.f0.U3(r1)
                java.lang.Integer r1 = (java.lang.Integer) r1
                if (r1 == 0) goto L80
                int r1 = r1.intValue()
                goto L81
            L80:
                r1 = 0
            L81:
                java.lang.String r1 = java.lang.String.valueOf(r1)
                kotlinx.coroutines.p2 r4 = kotlinx.coroutines.g1.e()
                com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$a$b r6 = new com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$a$b
                com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment r7 = r8.f21627f
                r6.<init>(r7, r1, r5)
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.j.a(r9)
                r8.f21622a = r7
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.j.a(r1)
                r8.f21623b = r7
                r8.f21625d = r3
                java.lang.Object r3 = kotlinx.coroutines.i.h(r4, r6, r8)
                if (r3 != r0) goto La5
                goto Ld3
            La5:
                r3 = r9
            La6:
                com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment r9 = r8.f21627f
                java.util.List<java.lang.Integer> r4 = r8.f21626e
                com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel r9 = com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment.h(r9, r4)
                kotlinx.coroutines.p2 r4 = kotlinx.coroutines.g1.e()
                com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$a$c r6 = new com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$a$c
                com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment r7 = r8.f21627f
                r6.<init>(r7, r9, r5)
                java.lang.Object r3 = kotlin.coroutines.jvm.internal.j.a(r3)
                r8.f21622a = r3
                java.lang.Object r1 = kotlin.coroutines.jvm.internal.j.a(r1)
                r8.f21623b = r1
                java.lang.Object r9 = kotlin.coroutines.jvm.internal.j.a(r9)
                r8.f21624c = r9
                r8.f21625d = r2
                java.lang.Object r9 = kotlinx.coroutines.i.h(r4, r6, r8)
                if (r9 != r0) goto Ld4
            Ld3:
                return r0
            Ld4:
                kotlin.n1 r9 = kotlin.n1.f44123a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b implements Observer, b0 {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f21637a;

        b(Function1 function) {
            kotlin.jvm.internal.g0.p(function, "function");
            this.f21637a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof b0)) {
                return kotlin.jvm.internal.g0.g(getFunctionDelegate(), ((b0) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.b0
        @NotNull
        public final n<?> getFunctionDelegate() {
            return this.f21637a;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21637a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$setMinutePace$1", f = "V3RecordChartFragment.kt", i = {0, 1, 1, 2, 2, 2}, l = {66, 72, 76}, m = "invokeSuspend", n = {"agePace", "agePace", "bestPace", "agePace", "bestPace", "paceChartModel"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2"})
    @SourceDebugExtension({"SMAP\nV3RecordChartFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3RecordChartFragment.kt\ncom/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordChartFragment$setMinutePace$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,259:1\n1#2:260\n774#3:261\n865#3,2:262\n*S KotlinDebug\n*F\n+ 1 V3RecordChartFragment.kt\ncom/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordChartFragment$setMinutePace$1\n*L\n70#1:261\n70#1:262,2\n*E\n"})
    static final class c extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f21638a;

        /* renamed from: b, reason: collision with root package name */
        Object f21639b;

        /* renamed from: c, reason: collision with root package name */
        Object f21640c;

        /* renamed from: d, reason: collision with root package name */
        int f21641d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<Double> f21642e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ V3RecordChartFragment f21643f;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$setMinutePace$1$1", f = "V3RecordChartFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f21644a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ V3RecordChartFragment f21645b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f21646c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(V3RecordChartFragment v3RecordChartFragment, String str, kotlin.coroutines.e<? super a> eVar) {
                super(2, eVar);
                this.f21645b = v3RecordChartFragment;
                this.f21646c = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new a(this.f21645b, this.f21646c, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f21644a == 0) {
                    g0.n(obj);
                    this.f21645b.L().tvAvgPace.setText(this.f21646c);
                    return n1.f44123a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$setMinutePace$1$2", f = "V3RecordChartFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class b extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f21647a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ V3RecordChartFragment f21648b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f21649c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(V3RecordChartFragment v3RecordChartFragment, String str, kotlin.coroutines.e<? super b> eVar) {
                super(2, eVar);
                this.f21648b = v3RecordChartFragment;
                this.f21649c = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new b(this.f21648b, this.f21649c, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((b) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f21647a == 0) {
                    g0.n(obj);
                    this.f21648b.L().tvBestPace.setText(this.f21649c);
                    return n1.f44123a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$setMinutePace$1$3", f = "V3RecordChartFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$c$c, reason: collision with other inner class name */
        static final class C0297c extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f21650a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ V3RecordChartFragment f21651b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ AAChartModel f21652c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0297c(V3RecordChartFragment v3RecordChartFragment, AAChartModel aAChartModel, kotlin.coroutines.e<? super C0297c> eVar) {
                super(2, eVar);
                this.f21651b = v3RecordChartFragment;
                this.f21652c = aAChartModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new C0297c(this.f21651b, this.f21652c, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((C0297c) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f21650a == 0) {
                    g0.n(obj);
                    this.f21651b.L().AAChartView.aa_drawChartWithChartModel(this.f21652c);
                    return n1.f44123a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List<Double> list, V3RecordChartFragment v3RecordChartFragment, kotlin.coroutines.e<? super c> eVar) {
            super(2, eVar);
            this.f21642e = list;
            this.f21643f = v3RecordChartFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new c(this.f21642e, this.f21643f, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0107, code lost:
        
            if (kotlinx.coroutines.i.h(r4, r6, r13) != r0) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0078, code lost:
        
            if (kotlinx.coroutines.i.h(r1, r6, r13) == r0) goto L41;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 269
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AAChartModel N(List<Integer> list) {
        int size = list.size() + 1;
        String[] strArr = new String[size];
        for (int i6 = 0; i6 < size; i6++) {
            strArr[i6] = "";
        }
        int i7 = 0;
        for (Object obj : list) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                f0.b0();
            }
            ((Number) obj).intValue();
            strArr[i7] = String.valueOf(i8);
            i7 = i8;
        }
        Map<String, Object> linearGradient = AAGradientColor.INSTANCE.linearGradient(AALinearGradientDirection.ToBottom, "rgba(12,191,121,1)", "rgba(221,245,234,0.5)");
        AAChartModel yAxisGridLineWidth = new AAChartModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 4095, null).yAxisTitle("").subtitleAlign(AAChartAlignType.Right).subtitleStyle(new AAStyle().position("bottom")).chartType(AAChartType.Areaspline).categories(strArr).markerRadius(0).yAxisGridLineWidth(0);
        Boolean bool = Boolean.FALSE;
        return yAxisGridLineWidth.legendEnabled(bool).series(new Object[]{new AASeriesElement().enableMouseTracking(bool).name("步频").lineWidth(1).color(AAColorKt.AARgba(12, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 121, 1.0f)).fillColor(linearGradient).data(list.toArray(new Object[0]))});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AAChartModel l(List<Double> list) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i6 = 0; i6 < size; i6++) {
            strArr[i6] = "";
        }
        int i7 = 0;
        for (Object obj : list) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                f0.b0();
            }
            ((Number) obj).doubleValue();
            strArr[i7] = String.valueOf(i8);
            i7 = i8;
        }
        Map<String, Object> linearGradient = AAGradientColor.INSTANCE.linearGradient(AALinearGradientDirection.ToBottom, "rgba(09,62,251,1)", "rgba(204,216,249,0.5)");
        AAChartModel yAxisGridLineWidth = new AAChartModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 4095, null).yAxisTitle("").zoomType(AAChartZoomType.XY).subtitleAlign(AAChartAlignType.Right).subtitleStyle(new AAStyle().position("bottom")).chartType(AAChartType.Areaspline).categories(strArr).markerRadius(0).yAxisGridLineWidth(0);
        Boolean bool = Boolean.FALSE;
        return yAxisGridLineWidth.legendEnabled(bool).series(new Object[]{new AASeriesElement().enableMouseTracking(bool).name("").lineWidth(1).color(AAColorKt.AARgba(9, 62, 251, 1.0f)).fillColor(linearGradient).data(list.toArray(new Object[0]))});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 k(V3RecordChartFragment v3RecordChartFragment, Map map) {
        c0 c0Var = c0.f16887a;
        v3RecordChartFragment.j(c0Var.m(map, "stepNumbers"));
        v3RecordChartFragment.n(c0Var.h(map, "paceMinute"));
        return n1.f44123a;
    }

    @NotNull
    public final Bitmap i() {
        r rVar = r.f20922a;
        Context H = H();
        ConstraintLayout clRoot = L().clRoot;
        kotlin.jvm.internal.g0.o(clRoot, "clRoot");
        return rVar.a(H, clRoot);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        FragmentActivity requireActivity = requireActivity();
        kotlin.jvm.internal.g0.o(requireActivity, "requireActivity(...)");
        x((BaseViewModel) new ViewModelProvider(requireActivity).get(RecordDetailVM.class));
        D().w().observe(requireActivity(), new b(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 k6;
                k6 = V3RecordChartFragment.k(V3RecordChartFragment.this, (Map) obj);
                return k6;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(int i6, int i7, TextView textView) {
        int a6 = Resources.getSystem().getDisplayMetrics().widthPixels - cn.bluemobi.dylan.base.utils.d.a(H(), 60.0f);
        textView.measure(-2, u.a(30.0f, H()));
        int measuredWidth = textView.getMeasuredWidth();
        float f6 = a6 * (i7 / i6);
        float f7 = measuredWidth;
        int i8 = a6 - measuredWidth;
        float f8 = (f6 - f7) - f7;
        if (f8 <= 0.0f) {
            f8 = 0.0f;
        }
        float f9 = i8;
        if (f8 > f9) {
            f8 = f9;
        }
        textView.setTranslationX(f8);
    }

    private final void j(List<Integer> list) {
        k.f(LifecycleOwnerKt.getLifecycleScope(this), g1.a(), null, new a(list, this, null), 2, null);
    }

    private final void m(List<Double> list) {
        k.f(LifecycleOwnerKt.getLifecycleScope(this), null, null, new V3RecordChartFragment$setKmPace$1(list, this, null), 3, null);
    }

    private final void n(List<Double> list) {
        k.f(LifecycleOwnerKt.getLifecycleScope(this), null, null, new c(list, this, null), 3, null);
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
    }
}
