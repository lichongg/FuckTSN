package androidx.core.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.provider.FontProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class b {
    public static FontProvider.ContentQueryWrapper a(Context context, Uri uri) {
        return Build.VERSION.SDK_INT < 24 ? new FontProvider.ContentQueryWrapperApi16Impl(context, uri) : new FontProvider.ContentQueryWrapperApi24Impl(context, uri);
    }
}
