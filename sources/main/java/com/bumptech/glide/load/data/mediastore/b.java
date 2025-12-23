package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import com.umeng.socialize.common.SocializeConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final int f14958a = 512;

    /* renamed from: b, reason: collision with root package name */
    private static final int f14959b = 384;

    public static boolean b(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && SocializeConstants.KEY_PLATFORM.equals(uri.getAuthority());
    }

    public static boolean d(int i6, int i7) {
        return i6 != Integer.MIN_VALUE && i7 != Integer.MIN_VALUE && i6 <= 512 && i7 <= 384;
    }

    private b() {
    }

    public static boolean a(Uri uri) {
        if (b(uri) && !e(uri)) {
            return true;
        }
        return false;
    }

    public static boolean c(Uri uri) {
        if (b(uri) && e(uri)) {
            return true;
        }
        return false;
    }

    private static boolean e(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
