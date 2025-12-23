package com.kwad.sdk.core.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.service.a.i;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IImageLoader extends i {
    void clearMemory(Context context);

    File isImageExistOnDisk(String str);

    void load(@NonNull Context context, String str, ImageView imageView, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener);

    void load(Context context, String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener);

    void load(ImageView imageView, Object obj, ImageLoadingListener imageLoadingListener);

    void load(KsFragment ksFragment, Context context, String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener);

    Bitmap loadImageSync(String str);

    void pause();

    void resume();

    void setCacheSize(int i6);
}
