package cn.jiguang.push.asus;

import android.content.Context;
import android.content.Intent;

/* loaded from: D:\Downloads\app\classes2.dex */
final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f3169a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Intent f3170b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ PushMessageReceiver f3171c;

    a(PushMessageReceiver pushMessageReceiver, Context context, Intent intent) {
        this.f3171c = pushMessageReceiver;
        this.f3169a = context;
        this.f3170b = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3171c.a(this.f3169a, this.f3170b);
    }
}
