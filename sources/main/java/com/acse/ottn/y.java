package com.acse.ottn;

import android.content.res.Resources;
import android.graphics.Outline;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class y {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f5510a;

        public a(float f6) {
            this.f5510a = f6;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f5510a);
        }
    }

    public static int a(boolean z5, int i6, int i7) {
        if (!z5) {
            return i6;
        }
        if (i6 == 0) {
            return i7 - 1;
        }
        if (i6 == i7 + 1) {
            return 0;
        }
        return i6 - 1;
    }

    public static View a(@NonNull ViewGroup viewGroup, @LayoutRes int i6) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i6, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams.height == -1 && layoutParams.width == -1) {
            return inflate;
        }
        layoutParams.height = -1;
        layoutParams.width = -1;
        inflate.setLayoutParams(layoutParams);
        return inflate;
    }

    public static float a(float f6) {
        return TypedValue.applyDimension(1, f6, Resources.getSystem().getDisplayMetrics());
    }

    @RequiresApi(api = 21)
    public static void a(View view, float f6) {
        view.setOutlineProvider(new a(f6));
        view.setClipToOutline(true);
    }
}
