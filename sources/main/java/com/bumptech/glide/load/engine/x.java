package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class x {

    /* renamed from: a, reason: collision with root package name */
    private boolean f15382a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f15383b = new Handler(Looper.getMainLooper(), new a());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a implements Handler.Callback {

        /* renamed from: a, reason: collision with root package name */
        static final int f15384a = 1;

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((u) message.obj).recycle();
            return true;
        }

        a() {
        }
    }

    synchronized void a(u<?> uVar, boolean z5) {
        try {
            if (!this.f15382a && !z5) {
                this.f15382a = true;
                uVar.recycle();
                this.f15382a = false;
            }
            this.f15383b.obtainMessage(1, uVar).sendToTarget();
        } catch (Throwable th) {
            throw th;
        }
    }

    x() {
    }
}
