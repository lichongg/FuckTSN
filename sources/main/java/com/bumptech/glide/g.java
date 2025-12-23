package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.net.URL;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
interface g<T> {
    @NonNull
    @CheckResult
    T a(@Nullable String str);

    @CheckResult
    @Deprecated
    T c(@Nullable URL url);

    @NonNull
    @CheckResult
    T e(@Nullable File file);

    @NonNull
    @CheckResult
    T f(@Nullable Drawable drawable);

    @NonNull
    @CheckResult
    T i(@Nullable Object obj);

    @NonNull
    @CheckResult
    T k(@Nullable Uri uri);

    @NonNull
    @CheckResult
    T l(@Nullable byte[] bArr);

    @NonNull
    @CheckResult
    T m(@Nullable Bitmap bitmap);

    @NonNull
    @CheckResult
    T p(@Nullable @DrawableRes @RawRes Integer num);
}
