package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class o implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<a> f51858a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f51859b;

    public o() {
        this(false);
    }

    public void a(Drawable.Callback callback) {
        for (int i6 = 0; i6 < this.f51858a.size(); i6++) {
            a aVar = this.f51858a.get(i6);
            if (aVar.get() == null) {
                this.f51858a.remove(aVar);
            }
        }
        this.f51858a.addIfAbsent(new a(callback));
    }

    public void b(Drawable.Callback callback) {
        for (int i6 = 0; i6 < this.f51858a.size(); i6++) {
            a aVar = this.f51858a.get(i6);
            Drawable.Callback callback2 = aVar.get();
            if (callback2 == null || callback2 == callback) {
                this.f51858a.remove(aVar);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        for (int i6 = 0; i6 < this.f51858a.size(); i6++) {
            a aVar = this.f51858a.get(i6);
            Drawable.Callback callback = aVar.get();
            if (callback == null) {
                this.f51858a.remove(aVar);
            } else if (this.f51859b && (callback instanceof View)) {
                ((View) callback).invalidate();
            } else {
                callback.invalidateDrawable(drawable);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j6) {
        for (int i6 = 0; i6 < this.f51858a.size(); i6++) {
            a aVar = this.f51858a.get(i6);
            Drawable.Callback callback = aVar.get();
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j6);
            } else {
                this.f51858a.remove(aVar);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        for (int i6 = 0; i6 < this.f51858a.size(); i6++) {
            a aVar = this.f51858a.get(i6);
            Drawable.Callback callback = aVar.get();
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            } else {
                this.f51858a.remove(aVar);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends WeakReference<Drawable.Callback> {
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && a.class == obj.getClass() && get() == ((a) obj).get();
        }

        a(Drawable.Callback callback) {
            super(callback);
        }

        public int hashCode() {
            Drawable.Callback callback = get();
            if (callback != null) {
                return callback.hashCode();
            }
            return 0;
        }
    }

    public o(boolean z5) {
        this.f51858a = new CopyOnWriteArrayList<>();
        this.f51859b = z5;
    }
}
