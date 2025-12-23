package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a extends e<Bitmap> {

    /* renamed from: d, reason: collision with root package name */
    private final int[] f16215d;

    /* renamed from: e, reason: collision with root package name */
    private final ComponentName f16216e;

    /* renamed from: f, reason: collision with root package name */
    private final RemoteViews f16217f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f16218g;

    /* renamed from: h, reason: collision with root package name */
    private final int f16219h;

    public a(Context context, int i6, int i7, int i8, RemoteViews remoteViews, int... iArr) {
        super(i6, i7);
        if (iArr.length == 0) {
            throw new IllegalArgumentException("WidgetIds must have length > 0");
        }
        this.f16218g = (Context) com.bumptech.glide.util.k.e(context, "Context can not be null!");
        this.f16217f = (RemoteViews) com.bumptech.glide.util.k.e(remoteViews, "RemoteViews object can not be null!");
        this.f16215d = (int[]) com.bumptech.glide.util.k.e(iArr, "WidgetIds can not be null!");
        this.f16219h = i8;
        this.f16216e = null;
    }

    @Override // com.bumptech.glide.request.target.p
    public void g(@Nullable Drawable drawable) {
        c(null);
    }

    private void c(@Nullable Bitmap bitmap) {
        this.f16217f.setImageViewBitmap(this.f16219h, bitmap);
        update();
    }

    private void update() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.f16218g);
        ComponentName componentName = this.f16216e;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.f16217f);
        } else {
            appWidgetManager.updateAppWidget(this.f16215d, this.f16217f);
        }
    }

    @Override // com.bumptech.glide.request.target.p
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void h(@NonNull Bitmap bitmap, @Nullable com.bumptech.glide.request.transition.f<? super Bitmap> fVar) {
        c(bitmap);
    }

    public a(Context context, int i6, RemoteViews remoteViews, int... iArr) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i6, remoteViews, iArr);
    }

    public a(Context context, int i6, int i7, int i8, RemoteViews remoteViews, ComponentName componentName) {
        super(i6, i7);
        this.f16218g = (Context) com.bumptech.glide.util.k.e(context, "Context can not be null!");
        this.f16217f = (RemoteViews) com.bumptech.glide.util.k.e(remoteViews, "RemoteViews object can not be null!");
        this.f16216e = (ComponentName) com.bumptech.glide.util.k.e(componentName, "ComponentName can not be null!");
        this.f16219h = i8;
        this.f16215d = null;
    }

    public a(Context context, int i6, RemoteViews remoteViews, ComponentName componentName) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i6, remoteViews, componentName);
    }
}
