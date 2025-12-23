package com.umeng.socialize.media;

import android.content.Context;
import android.graphics.Bitmap;
import com.umeng.social.tool.UMImageMark;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMEmoji extends UMImage {
    public UMEmoji(Context context, File file) {
        super(context, file);
    }

    public UMEmoji(Context context, String str) {
        super(context, str);
    }

    public UMEmoji(Context context, int i6) {
        super(context, i6);
    }

    public UMEmoji(Context context, byte[] bArr) {
        super(context, bArr);
    }

    public UMEmoji(Context context, Bitmap bitmap) {
        super(context, bitmap);
    }

    public UMEmoji(Context context, Bitmap bitmap, UMImageMark uMImageMark) {
        super(context, bitmap, uMImageMark);
    }

    public UMEmoji(Context context, int i6, UMImageMark uMImageMark) {
        super(context, i6, uMImageMark);
    }

    public UMEmoji(Context context, byte[] bArr, UMImageMark uMImageMark) {
        super(context, bArr, uMImageMark);
    }
}
