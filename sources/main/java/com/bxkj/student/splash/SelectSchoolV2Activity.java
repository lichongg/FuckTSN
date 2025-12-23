package com.bxkj.student.splash;

import androidx.lifecycle.ViewModelKt;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.data.b;
import com.bxkj.base.view.SearchView;
import com.bxkj.student.databinding.AcSchoolListV2Binding;
import com.bxkj.student.v2.common.db.AppDatabase;
import com.bxkj.student.v2.vm.splash.SelectSchoolVM;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlin.s;
import kotlin.t;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class SelectSchoolV2Activity extends BaseActivity<AcSchoolListV2Binding, SelectSchoolVM> {

    @NotNull
    private List<? extends Map<String, Object>> U = f0.J();

    @NotNull
    private final s V = t.c(new Function0() { // from class: com.bxkj.student.splash.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SelectSchoolV2Activity$adapter$2$1 i6;
            i6 = SelectSchoolV2Activity.i(SelectSchoolV2Activity.this);
            return i6;
        }
    });

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.splash.SelectSchoolV2Activity$resetLocalData$1", f = "SelectSchoolV2Activity.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f20462a;

        a(kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new a(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f20462a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                b.a aVar = com.bxkj.base.v2.data.b.f16998d;
                aVar.a().c();
                aVar.a().d();
                com.bxkj.student.v2.common.db.dao.l w5 = AppDatabase.f20686a.a().w();
                if (w5 != null) {
                    this.f20462a = 1;
                    if (w5.a(this) == l6) {
                        return l6;
                    }
                }
            }
            return n1.f44123a;
        }
    }

    private final SelectSchoolV2Activity$adapter$2$1 M() {
        return (SelectSchoolV2Activity$adapter$2$1) this.V.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 O(SelectSchoolV2Activity selectSchoolV2Activity, List it) {
        kotlin.jvm.internal.g0.p(it, "it");
        selectSchoolV2Activity.M().l(f0.a6(it));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SelectSchoolV2Activity$adapter$2$1 i(SelectSchoolV2Activity selectSchoolV2Activity) {
        return new SelectSchoolV2Activity$adapter$2$1(selectSchoolV2Activity, selectSchoolV2Activity.U);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(final SelectSchoolV2Activity selectSchoolV2Activity, String str) {
        kotlin.jvm.internal.g0.m(str);
        if (str.length() == 0) {
            selectSchoolV2Activity.M().l(new ArrayList());
        } else if (str.length() >= 4) {
            selectSchoolV2Activity.D().w(str, new Function1() { // from class: com.bxkj.student.splash.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 O;
                    O = SelectSchoolV2Activity.O(SelectSchoolV2Activity.this, (List) obj);
                    return O;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P() {
        kotlinx.coroutines.k.f(ViewModelKt.getViewModelScope(D()), g1.c(), null, new a(null), 2, null);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        L().searchView.setOnSearchListener(new SearchView.a() { // from class: com.bxkj.student.splash.g
            @Override // com.bxkj.base.view.SearchView.a
            public final void a(String str) {
                SelectSchoolV2Activity.N(SelectSchoolV2Activity.this, str);
            }
        });
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        L().setActivity(this);
        L().rvSchool.setAdapter(M());
    }
}
