package com.bxkj.student.v2.ui.sports.v3.detail.tab;

import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.student.R;
import com.bxkj.student.databinding.ItemForPaceKmBinding;
import java.math.BigDecimal;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.r0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$setKmPace$1", f = "V3RecordChartFragment.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {90, 102, 110, 118}, m = "invokeSuspend", n = {"agePace", "agePace", "minPace", "maxPace", "agePace", "minPace", "maxPace", "kmList", "it", "countDistance", "$i$a$-let-V3RecordChartFragment$setKmPace$1$4", "agePace", "minPace", "maxPace", "kmList", "countDistance"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$5", "D$0", "I$0", "L$0", "L$1", "L$2", "L$3", "D$0"})
@SourceDebugExtension({"SMAP\nV3RecordChartFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3RecordChartFragment.kt\ncom/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordChartFragment$setKmPace$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,259:1\n1#2:260\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
final class V3RecordChartFragment$setKmPace$1 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

    /* renamed from: a, reason: collision with root package name */
    Object f21653a;

    /* renamed from: b, reason: collision with root package name */
    Object f21654b;

    /* renamed from: c, reason: collision with root package name */
    Object f21655c;

    /* renamed from: d, reason: collision with root package name */
    Object f21656d;

    /* renamed from: e, reason: collision with root package name */
    Object f21657e;

    /* renamed from: f, reason: collision with root package name */
    Object f21658f;

    /* renamed from: g, reason: collision with root package name */
    double f21659g;

    /* renamed from: h, reason: collision with root package name */
    int f21660h;

    /* renamed from: i, reason: collision with root package name */
    int f21661i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ List<Double> f21662j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ V3RecordChartFragment f21663k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$setKmPace$1$5", f = "V3RecordChartFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$setKmPace$1$5, reason: invalid class name */
    static final class AnonymousClass5 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21664a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ V3RecordChartFragment f21665b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<Double> f21666c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Double> f21667d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Double> f21668e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(V3RecordChartFragment v3RecordChartFragment, List<Double> list, Ref.ObjectRef<Double> objectRef, Ref.ObjectRef<Double> objectRef2, kotlin.coroutines.e<? super AnonymousClass5> eVar) {
            super(2, eVar);
            this.f21665b = v3RecordChartFragment;
            this.f21666c = list;
            this.f21667d = objectRef;
            this.f21668e = objectRef2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new AnonymousClass5(this.f21665b, this.f21666c, this.f21667d, this.f21668e, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((AnonymousClass5) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f21664a == 0) {
                g0.n(obj);
                RecyclerView recyclerView = this.f21665b.L().rvPace2;
                List<Double> list = this.f21666c;
                final Ref.ObjectRef<Double> objectRef = this.f21667d;
                final V3RecordChartFragment v3RecordChartFragment = this.f21665b;
                final Ref.ObjectRef<Double> objectRef2 = this.f21668e;
                recyclerView.setAdapter(new BaseAdapter<Double, ItemForPaceKmBinding>(list) { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment.setKmPace.1.5.1
                    @Override // com.bxkj.base.v2.base.BaseAdapter
                    public /* bridge */ /* synthetic */ void f(ItemForPaceKmBinding itemForPaceKmBinding, Double d6, int i6) {
                        m(itemForPaceKmBinding, d6.doubleValue(), i6);
                    }

                    public void m(ItemForPaceKmBinding itemBinding, double d6, int i6) {
                        kotlin.jvm.internal.g0.p(itemBinding, "itemBinding");
                        itemBinding.tvNumber.setText(String.valueOf(i6 + 1));
                        itemBinding.tvAvgPaceHint.setText(com.bxkj.student.v2.common.data.j.f20683a.f(d6));
                        int intValue = new BigDecimal(objectRef.element.doubleValue()).setScale(0, 4).intValue();
                        itemBinding.pbDistance.setMax(intValue);
                        int intValue2 = new BigDecimal(d6).setScale(0, 4).intValue();
                        itemBinding.pbDistance.setProgress(intValue2);
                        V3RecordChartFragment v3RecordChartFragment2 = v3RecordChartFragment;
                        TextView tvAvgPaceHint = itemBinding.tvAvgPaceHint;
                        kotlin.jvm.internal.g0.o(tvAvgPaceHint, "tvAvgPaceHint");
                        v3RecordChartFragment2.M(intValue, intValue2, tvAvgPaceHint);
                        itemBinding.pbDistance.setProgressDrawable(kotlin.jvm.internal.g0.a(d6, objectRef2.element) ? ContextCompat.getDrawable(v3RecordChartFragment.H(), R.drawable.progress_style_pace) : ContextCompat.getDrawable(v3RecordChartFragment.H(), R.drawable.progress_style_pace_slow));
                    }
                });
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$setKmPace$1$1", f = "V3RecordChartFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21672a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ V3RecordChartFragment f21673b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21674c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(V3RecordChartFragment v3RecordChartFragment, String str, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f21673b = v3RecordChartFragment;
            this.f21674c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new a(this.f21673b, this.f21674c, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f21672a == 0) {
                g0.n(obj);
                this.f21673b.L().tvAvgPace2.setText(this.f21674c);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$setKmPace$1$2", f = "V3RecordChartFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21675a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ V3RecordChartFragment f21676b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Double> f21677c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(V3RecordChartFragment v3RecordChartFragment, Ref.ObjectRef<Double> objectRef, kotlin.coroutines.e<? super b> eVar) {
            super(2, eVar);
            this.f21676b = v3RecordChartFragment;
            this.f21677c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new b(this.f21676b, this.f21677c, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((b) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f21675a == 0) {
                g0.n(obj);
                this.f21676b.L().tvBestPace2.setText(com.bxkj.student.v2.common.data.j.f20683a.f(this.f21677c.element.doubleValue()));
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$setKmPace$1$4$1", f = "V3RecordChartFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21678a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ V3RecordChartFragment f21679b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<Double> f21680c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(V3RecordChartFragment v3RecordChartFragment, List<Double> list, kotlin.coroutines.e<? super c> eVar) {
            super(2, eVar);
            this.f21679b = v3RecordChartFragment;
            this.f21680c = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new c(this.f21679b, this.f21680c, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f21678a == 0) {
                g0.n(obj);
                this.f21679b.L().tvLastKmPace.setText("最后不足一公里，配速 " + com.bxkj.student.v2.common.data.j.f20683a.f(this.f21680c.get(r1.size() - 1).doubleValue()));
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    V3RecordChartFragment$setKmPace$1(List<Double> list, V3RecordChartFragment v3RecordChartFragment, kotlin.coroutines.e<? super V3RecordChartFragment$setKmPace$1> eVar) {
        super(2, eVar);
        this.f21662j = list;
        this.f21663k = v3RecordChartFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
        return new V3RecordChartFragment$setKmPace$1(this.f21662j, this.f21663k, eVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
        return ((V3RecordChartFragment$setKmPace$1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x01a5, code lost:
    
        if (kotlinx.coroutines.i.h(r2, r11, r17) != r1) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a6, code lost:
    
        if (kotlinx.coroutines.i.h(r8, r9, r17) == r1) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0124  */
    /* JADX WARN: Type inference failed for: r11v2, types: [T, java.lang.Double] */
    /* JADX WARN: Type inference failed for: r8v7, types: [T, java.lang.Double] */
    /* JADX WARN: Type inference failed for: r8v9, types: [T, java.lang.Double] */
    /* JADX WARN: Type inference failed for: r9v4, types: [T, java.lang.Double] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 427
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment$setKmPace$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
