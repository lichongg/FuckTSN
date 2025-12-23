package androidx.core.graphics.drawable;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class IconKt {
    @RequiresApi(26)
    @NotNull
    public static final Icon toIcon(@NotNull Bitmap bitmap) {
        Icon createWithBitmap;
        createWithBitmap = Icon.createWithBitmap(bitmap);
        return createWithBitmap;
    }

    @RequiresApi(26)
    @NotNull
    public static final Icon toIcon(@NotNull Uri uri) {
        Icon createWithContentUri;
        createWithContentUri = Icon.createWithContentUri(uri);
        return createWithContentUri;
    }

    @RequiresApi(26)
    @NotNull
    public static final Icon toAdaptiveIcon(@NotNull Bitmap bitmap) {
        Icon createWithAdaptiveBitmap;
        createWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        return createWithAdaptiveBitmap;
    }

    @RequiresApi(26)
    @NotNull
    public static final Icon toIcon(@NotNull byte[] bArr) {
        Icon createWithData;
        createWithData = Icon.createWithData(bArr, 0, bArr.length);
        return createWithData;
    }
}
