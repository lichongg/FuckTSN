package androidx.navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.MainThread;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ActivityNavArgsLazyKt {
    @MainThread
    @NotNull
    public static final /* synthetic */ <Args extends NavArgs> NavArgsLazy<Args> navArgs(@NotNull final Activity navArgs) {
        g0.q(navArgs, "$this$navArgs");
        g0.y(4, "Args");
        return new NavArgsLazy<>(o0.d(NavArgs.class), new Function0<Bundle>() { // from class: androidx.navigation.ActivityNavArgsLazyKt$navArgs$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Bundle invoke() {
                Intent intent = navArgs.getIntent();
                if (intent == null) {
                    throw new IllegalStateException("Activity " + navArgs + " has a null Intent");
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    return extras;
                }
                throw new IllegalStateException("Activity " + navArgs + " has null extras in " + intent);
            }
        });
    }
}
