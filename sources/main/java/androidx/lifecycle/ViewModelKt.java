package androidx.lifecycle;

import kotlin.jvm.internal.g0;
import kotlinx.coroutines.d3;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ViewModelKt {

    @NotNull
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    @NotNull
    public static final r0 getViewModelScope(@NotNull ViewModel viewModel) {
        g0.p(viewModel, "<this>");
        r0 r0Var = (r0) viewModel.getTag(JOB_KEY);
        if (r0Var != null) {
            return r0Var;
        }
        Object tagIfAbsent = viewModel.setTagIfAbsent(JOB_KEY, new CloseableCoroutineScope(d3.c(null, 1, null).plus(g1.e().v())));
        g0.o(tagIfAbsent, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (r0) tagIfAbsent;
    }
}
