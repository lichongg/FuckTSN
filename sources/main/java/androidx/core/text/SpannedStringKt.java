package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class SpannedStringKt {
    public static final /* synthetic */ <T> T[] getSpans(Spanned spanned, int i6, int i7) {
        g0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T[]) spanned.getSpans(i6, i7, Object.class);
    }

    public static /* synthetic */ Object[] getSpans$default(Spanned spanned, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = spanned.length();
        }
        g0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        return spanned.getSpans(i6, i7, Object.class);
    }

    @NotNull
    public static final Spanned toSpanned(@NotNull CharSequence charSequence) {
        return SpannedString.valueOf(charSequence);
    }
}
