package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zam;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zag {
    final zad zaa;
    protected int zab;

    protected abstract void zaa(@Nullable Drawable drawable, boolean z5, boolean z6, boolean z7);

    final void zab(Context context, zam zamVar, boolean z5) {
        int i6 = this.zab;
        zaa(i6 != 0 ? context.getResources().getDrawable(i6) : null, z5, false, false);
    }

    public zag(Uri uri, int i6) {
        this.zab = 0;
        this.zaa = new zad(uri);
        this.zab = i6;
    }

    final void zac(Context context, Bitmap bitmap, boolean z5) {
        Asserts.checkNotNull(bitmap);
        zaa(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
