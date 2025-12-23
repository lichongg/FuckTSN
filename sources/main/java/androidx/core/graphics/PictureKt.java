package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.d0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class PictureKt {
    @NotNull
    public static final Picture record(@NotNull Picture picture, int i6, int i7, @NotNull Function1<? super Canvas, n1> function1) {
        Canvas beginRecording = picture.beginRecording(i6, i7);
        try {
            function1.invoke(beginRecording);
            return picture;
        } finally {
            d0.d(1);
            picture.endRecording();
            d0.c(1);
        }
    }
}
