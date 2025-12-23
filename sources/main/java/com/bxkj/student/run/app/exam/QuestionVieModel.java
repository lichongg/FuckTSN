package com.bxkj.student.run.app.exam;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableArrayMap;
import androidx.lifecycle.ViewModel;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class QuestionVieModel extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private Integer f19793a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final s f19794b = t.c(new Function0() { // from class: com.bxkj.student.run.app.exam.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ObservableArrayMap d6;
            d6 = QuestionVieModel.d();
            return d6;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final s f19795c = t.c(new Function0() { // from class: com.bxkj.student.run.app.exam.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ObservableArrayList c6;
            c6 = QuestionVieModel.c();
            return c6;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private boolean f19796d;

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableArrayList c() {
        return new ObservableArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableArrayMap d() {
        return new ObservableArrayMap();
    }

    @NotNull
    public final ObservableArrayList<Map<String, Object>> e() {
        return (ObservableArrayList) this.f19795c.getValue();
    }

    @Nullable
    public final Integer f() {
        return this.f19793a;
    }

    @NotNull
    public final ObservableArrayMap<String, Object> g() {
        return (ObservableArrayMap) this.f19794b.getValue();
    }

    public final boolean h() {
        return this.f19796d;
    }

    public final void i(@Nullable Integer num) {
        this.f19793a = num;
    }

    public final void j(boolean z5) {
        this.f19796d = z5;
    }
}
