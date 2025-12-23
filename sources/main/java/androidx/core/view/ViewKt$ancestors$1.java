package androidx.core.view;

import android.view.ViewParent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
/* synthetic */ class ViewKt$ancestors$1 extends FunctionReferenceImpl implements Function1<ViewParent, ViewParent> {
    public static final ViewKt$ancestors$1 INSTANCE = new ViewKt$ancestors$1();

    @Override // kotlin.jvm.functions.Function1
    public final ViewParent invoke(@NotNull ViewParent viewParent) {
        return viewParent.getParent();
    }

    ViewKt$ancestors$1() {
        super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }
}
