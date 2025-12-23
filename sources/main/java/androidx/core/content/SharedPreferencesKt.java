package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class SharedPreferencesKt {
    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z5, Function1 function1, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        function1.invoke(edit);
        if (z5) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public static final void edit(@NotNull SharedPreferences sharedPreferences, boolean z5, @NotNull Function1<? super SharedPreferences.Editor, n1> function1) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        function1.invoke(edit);
        if (z5) {
            edit.commit();
        } else {
            edit.apply();
        }
    }
}
