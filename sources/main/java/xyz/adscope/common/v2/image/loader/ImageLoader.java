package xyz.adscope.common.v2.image.loader;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import xyz.adscope.common.v2.image.tool.GaussianBlurUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ImageLoader {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static ImageLoader instance = new ImageLoader();

        private InstanceHolder() {
        }
    }

    public void loadPermanentImage(ImageView imageView, String str, boolean z5) {
        loadPermanentImage(imageView, str, z5, null);
    }

    private ImageLoader() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    public void loadMainImage(final ImageView imageView, String str, final boolean z5, final IImageFillResult iImageFillResult) {
        if (imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        BitmapHolder.getInstance().loadImage(imageView.getContext(), str, true, new IBitmapResult() { // from class: xyz.adscope.common.v2.image.loader.ImageLoader.2
            @Override // xyz.adscope.common.v2.image.loader.IBitmapResult
            public void onImageLoadFailed() {
                IImageFillResult iImageFillResult2 = iImageFillResult;
                if (iImageFillResult2 != null) {
                    iImageFillResult2.onImageLoadFailed();
                }
            }

            @Override // xyz.adscope.common.v2.image.loader.IBitmapResult
            public void onImageLoaded(Bitmap bitmap) {
                if (bitmap == null) {
                    IImageFillResult iImageFillResult2 = iImageFillResult;
                    if (iImageFillResult2 != null) {
                        iImageFillResult2.onImageLoadFailed();
                        return;
                    }
                    return;
                }
                imageView.setImageBitmap(bitmap);
                System.currentTimeMillis();
                if (z5) {
                    imageView.setBackground(new BitmapDrawable(imageView.getContext().getResources(), GaussianBlurUtil.blurBitmap(imageView.getContext(), bitmap, 20.0f)));
                }
                IImageFillResult iImageFillResult3 = iImageFillResult;
                if (iImageFillResult3 != null) {
                    iImageFillResult3.onImageLoaded();
                }
            }
        });
    }

    public void loadPermanentImage(final ImageView imageView, String str, boolean z5, final IImageFillResult iImageFillResult) {
        if (imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        BitmapHolder.getInstance().loadImage(imageView.getContext(), str, z5, new IBitmapResult() { // from class: xyz.adscope.common.v2.image.loader.ImageLoader.1
            @Override // xyz.adscope.common.v2.image.loader.IBitmapResult
            public void onImageLoadFailed() {
                IImageFillResult iImageFillResult2 = iImageFillResult;
                if (iImageFillResult2 != null) {
                    iImageFillResult2.onImageLoadFailed();
                }
            }

            @Override // xyz.adscope.common.v2.image.loader.IBitmapResult
            public void onImageLoaded(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
                IImageFillResult iImageFillResult2 = iImageFillResult;
                if (iImageFillResult2 != null) {
                    iImageFillResult2.onImageLoaded();
                }
            }
        });
    }

    public static ImageLoader getInstance() {
        return InstanceHolder.instance;
    }
}
