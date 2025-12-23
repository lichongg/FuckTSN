package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class m<Z> extends e<Z> {

    /* renamed from: e, reason: collision with root package name */
    private static final int f16255e = 1;

    /* renamed from: f, reason: collision with root package name */
    private static final Handler f16256f = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.i f16257d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((m) message.obj).a();
            return true;
        }

        a() {
        }
    }

    public static <Z> m<Z> c(com.bumptech.glide.i iVar, int i6, int i7) {
        return new m<>(iVar, i6, i7);
    }

    void a() {
        this.f16257d.z(this);
    }

    @Override // com.bumptech.glide.request.target.p
    public void h(@NonNull Z z5, @Nullable com.bumptech.glide.request.transition.f<? super Z> fVar) {
        f16256f.obtainMessage(1, this).sendToTarget();
    }

    private m(com.bumptech.glide.i iVar, int i6, int i7) {
        super(i6, i7);
        this.f16257d = iVar;
    }

    @Override // com.bumptech.glide.request.target.p
    public void g(@Nullable Drawable drawable) {
    }
}
