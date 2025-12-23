package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class l extends e<Bitmap> {

    /* renamed from: d, reason: collision with root package name */
    private final RemoteViews f16249d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f16250e;

    /* renamed from: f, reason: collision with root package name */
    private final int f16251f;

    /* renamed from: g, reason: collision with root package name */
    private final String f16252g;

    /* renamed from: h, reason: collision with root package name */
    private final Notification f16253h;

    /* renamed from: i, reason: collision with root package name */
    private final int f16254i;

    public l(Context context, int i6, RemoteViews remoteViews, Notification notification, int i7) {
        this(context, i6, remoteViews, notification, i7, null);
    }

    @Override // com.bumptech.glide.request.target.p
    public void g(@Nullable Drawable drawable) {
        c(null);
    }

    public l(Context context, int i6, RemoteViews remoteViews, Notification notification, int i7, String str) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i6, remoteViews, notification, i7, str);
    }

    private void c(@Nullable Bitmap bitmap) {
        this.f16249d.setImageViewBitmap(this.f16254i, bitmap);
        update();
    }

    private void update() {
        ((NotificationManager) com.bumptech.glide.util.k.d((NotificationManager) this.f16250e.getSystemService("notification"))).notify(this.f16252g, this.f16251f, this.f16253h);
    }

    public l(Context context, int i6, int i7, int i8, RemoteViews remoteViews, Notification notification, int i9, String str) {
        super(i6, i7);
        this.f16250e = (Context) com.bumptech.glide.util.k.e(context, "Context must not be null!");
        this.f16253h = (Notification) com.bumptech.glide.util.k.e(notification, "Notification object can not be null!");
        this.f16249d = (RemoteViews) com.bumptech.glide.util.k.e(remoteViews, "RemoteViews object can not be null!");
        this.f16254i = i8;
        this.f16251f = i9;
        this.f16252g = str;
    }

    @Override // com.bumptech.glide.request.target.p
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void h(@NonNull Bitmap bitmap, @Nullable com.bumptech.glide.request.transition.f<? super Bitmap> fVar) {
        c(bitmap);
    }
}
