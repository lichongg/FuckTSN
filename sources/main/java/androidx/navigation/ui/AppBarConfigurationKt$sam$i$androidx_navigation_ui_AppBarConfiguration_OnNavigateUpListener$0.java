package androidx.navigation.ui;

import androidx.navigation.ui.AppBarConfiguration;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0 implements AppBarConfiguration.OnNavigateUpListener {
    private final /* synthetic */ Function0 function;

    @Override // androidx.navigation.ui.AppBarConfiguration.OnNavigateUpListener
    public final /* synthetic */ boolean onNavigateUp() {
        Object invoke = this.function.invoke();
        g0.h(invoke, "invoke(...)");
        return ((Boolean) invoke).booleanValue();
    }

    public AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(Function0 function0) {
        this.function = function0;
    }
}
