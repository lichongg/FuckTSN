package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class b<T extends Drawable> implements u<T>, q {

    /* renamed from: a, reason: collision with root package name */
    protected final T f15689a;

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final T get() {
        Drawable.ConstantState constantState = this.f15689a.getConstantState();
        return constantState == null ? this.f15689a : (T) constantState.newDrawable();
    }

    public void initialize() {
        T t5 = this.f15689a;
        if (t5 instanceof BitmapDrawable) {
            ((BitmapDrawable) t5).getBitmap().prepareToDraw();
        } else if (t5 instanceof GifDrawable) {
            ((GifDrawable) t5).e().prepareToDraw();
        }
    }

    public b(T t5) {
        this.f15689a = (T) k.d(t5);
    }
}
