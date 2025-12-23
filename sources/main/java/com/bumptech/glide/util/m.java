package com.bumptech.glide.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.f;
import com.bumptech.glide.request.target.o;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class m<T> implements f.b<T>, o {

    /* renamed from: a, reason: collision with root package name */
    private int[] f16348a;

    /* renamed from: b, reason: collision with root package name */
    private a f16349b;

    public m() {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends com.bumptech.glide.request.target.f<View, Object> {
        a(@NonNull View view) {
            super(view);
        }

        @Override // com.bumptech.glide.request.target.f
        protected void k(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.p
        public void o(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.p
        public void h(@NonNull Object obj, @Nullable com.bumptech.glide.request.transition.f<? super Object> fVar) {
        }
    }

    public m(@NonNull View view) {
        a aVar = new a(view);
        this.f16349b = aVar;
        aVar.q(this);
    }

    @Override // com.bumptech.glide.f.b
    @Nullable
    public int[] a(@NonNull T t5, int i6, int i7) {
        int[] iArr = this.f16348a;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public void b(@NonNull View view) {
        if (this.f16348a == null && this.f16349b == null) {
            a aVar = new a(view);
            this.f16349b = aVar;
            aVar.q(this);
        }
    }

    @Override // com.bumptech.glide.request.target.o
    public void d(int i6, int i7) {
        this.f16348a = new int[]{i6, i7};
        this.f16349b = null;
    }
}
