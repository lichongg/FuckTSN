package xyz.adscope.common.imageloader.inter;

import android.content.Context;
import android.widget.ImageView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IImageLoader {
    void loadCacheImage(Context context, String str, boolean z5, IImageLoaderCallback iImageLoaderCallback);

    void loadImage(Context context, String str, IImageLoaderCallback iImageLoaderCallback);

    void loadImage(Context context, String str, boolean z5, IImageLoaderCallback iImageLoaderCallback);

    void loadImage(ImageView imageView, String str);
}
