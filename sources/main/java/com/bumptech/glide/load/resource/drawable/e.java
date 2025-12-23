package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.g;
import com.stub.StubApp;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class e implements g<Uri, Drawable> {

    /* renamed from: b, reason: collision with root package name */
    private static final String f15690b = "android";

    /* renamed from: c, reason: collision with root package name */
    private static final int f15691c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static final int f15692d = 2;

    /* renamed from: e, reason: collision with root package name */
    private static final int f15693e = 0;

    /* renamed from: f, reason: collision with root package name */
    private static final int f15694f = 1;

    /* renamed from: g, reason: collision with root package name */
    private static final int f15695g = 1;

    /* renamed from: h, reason: collision with root package name */
    private static final int f15696h = 0;

    /* renamed from: a, reason: collision with root package name */
    private final Context f15697a;

    @NonNull
    private Context d(Uri uri, String str) {
        if (str.equals(this.f15697a.getPackageName())) {
            return this.f15697a;
        }
        try {
            return this.f15697a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e6) {
            if (str.contains(this.f15697a.getPackageName())) {
                return this.f15697a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e6);
        }
    }

    public e(Context context) {
        this.f15697a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @DrawableRes
    private int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e6) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e6);
        }
    }

    @DrawableRes
    private int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    @DrawableRes
    private int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // com.bumptech.glide.load.g
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public u<Drawable> b(@NonNull Uri uri, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        Context d6 = d(uri, uri.getAuthority());
        return d.c(a.b(this.f15697a, d6, g(d6, uri)));
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri, @NonNull com.bumptech.glide.load.f fVar) {
        return uri.getScheme().equals("android.resource");
    }
}
