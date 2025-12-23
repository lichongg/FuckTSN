package androidx.databinding.adapters;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@BindingMethods({@BindingMethod(attribute = "android:tint", method = "setImageTintList", type = ImageView.class), @BindingMethod(attribute = "android:tintMode", method = "setImageTintMode", type = ImageView.class)})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
public class ImageViewBindingAdapter {
    @BindingAdapter({"android:src"})
    public static void setImageUri(ImageView imageView, String str) {
        if (str == null) {
            imageView.setImageURI(null);
        } else {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    @BindingAdapter({"android:src"})
    public static void setImageDrawable(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }

    @BindingAdapter({"android:src"})
    public static void setImageUri(ImageView imageView, Uri uri) {
        imageView.setImageURI(uri);
    }
}
