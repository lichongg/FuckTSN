package com.bytedance.sdk.component.adexpress.r;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.model.layer.a;
import com.bytedance.adsdk.lottie.model.layer.b;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.utils.vl;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {

    /* renamed from: j, reason: collision with root package name */
    private static final byte[] f25841j = j("VP8X");

    private static byte[] j(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new byte[1];
        }
    }

    private static void r(final ImageView imageView, byte[] bArr, int i6, int i7) {
        final Bitmap j6 = new com.bytedance.sdk.component.m.cw.xt.j(i6, i7, imageView.getScaleType(), Bitmap.Config.RGB_565, i6, i7).j(bArr);
        if (j6 != null) {
            com.bytedance.sdk.component.utils.tl.xt().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.r.m.2
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageBitmap(j6);
                }
            });
        }
    }

    public static void xt(ImageView imageView, byte[] bArr, int i6, int i7) {
        try {
            if (imageView instanceof GifView) {
                ((GifView) imageView).j(bArr, false);
                return;
            }
            if (TextUtils.equals("png", com.bytedance.sdk.component.utils.g.j(Arrays.copyOfRange(bArr, 0, com.bytedance.sdk.component.utils.g.j())))) {
                cw(imageView, bArr, i6, i7);
            } else if (j(bArr, 0)) {
                j(imageView, bArr, i6, i7);
            } else {
                r(imageView, bArr, i6, i7);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private static void cw(final ImageView imageView, byte[] bArr, int i6, int i7) {
        if (j(bArr)) {
            final com.bytedance.adsdk.j.j.j j6 = com.bytedance.adsdk.j.j.j.j(ByteBuffer.wrap(bArr));
            com.bytedance.sdk.component.utils.tl.xt().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.r.m.1
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageDrawable(j6);
                }
            });
        } else {
            r(imageView, bArr, i6, i7);
        }
    }

    public static boolean j(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        return j.j(bArr);
    }

    public static void j(final ImageView imageView, byte[] bArr, int i6, int i7) {
        ImageDecoder.Source createSource;
        final Drawable decodeDrawable;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (Build.VERSION.SDK_INT >= 28) {
            createSource = ImageDecoder.createSource(wrap);
            try {
                decodeDrawable = ImageDecoder.decodeDrawable(createSource);
                com.bytedance.sdk.component.utils.tl.xt().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.r.m.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.a(decodeDrawable)) {
                            b.a(decodeDrawable).start();
                        }
                        imageView.setImageDrawable(decodeDrawable);
                    }
                });
                return;
            } catch (IOException e6) {
                vl.j(e6);
                return;
            }
        }
        r(imageView, bArr, i6, i7);
    }

    public static boolean j(byte[] bArr, int i6) {
        try {
            boolean j6 = j(bArr, i6 + 12, f25841j);
            int i7 = i6 + 20;
            if (bArr.length <= i7) {
                return false;
            }
            return j6 && ((bArr[i7] & 2) == 2);
        } catch (Throwable th) {
            vl.j(th);
            return false;
        }
    }

    private static boolean j(byte[] bArr, int i6, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i6 > bArr.length) {
            return false;
        }
        for (int i7 = 0; i7 < bArr2.length; i7++) {
            if (bArr[i7 + i6] != bArr2[i7]) {
                return false;
            }
        }
        return true;
    }
}
