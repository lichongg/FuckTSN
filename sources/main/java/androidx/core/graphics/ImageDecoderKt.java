package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import kotlin.jvm.functions.Function3;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class ImageDecoderKt {
    @RequiresApi(28)
    @NotNull
    public static final Bitmap decodeBitmap(@NotNull ImageDecoder.Source source, @NotNull final Function3<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, n1> function3) {
        Bitmap decodeBitmap;
        decodeBitmap = ImageDecoder.decodeBitmap(source, u.a(new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt$decodeBitmap$1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(@NotNull ImageDecoder imageDecoder, @NotNull ImageDecoder.ImageInfo imageInfo, @NotNull ImageDecoder.Source source2) {
                function3.invoke(imageDecoder, imageInfo, source2);
            }
        }));
        return decodeBitmap;
    }

    @RequiresApi(28)
    @NotNull
    public static final Drawable decodeDrawable(@NotNull ImageDecoder.Source source, @NotNull final Function3<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, n1> function3) {
        Drawable decodeDrawable;
        decodeDrawable = ImageDecoder.decodeDrawable(source, u.a(new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt$decodeDrawable$1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(@NotNull ImageDecoder imageDecoder, @NotNull ImageDecoder.ImageInfo imageInfo, @NotNull ImageDecoder.Source source2) {
                function3.invoke(imageDecoder, imageInfo, source2);
            }
        }));
        return decodeDrawable;
    }
}
