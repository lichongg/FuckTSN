package com.jg.ids.k;

import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: D:\Downloads\app\classes10.dex */
final class b extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    private String f35559a;

    /* renamed from: b, reason: collision with root package name */
    private int f35560b;

    /* renamed from: c, reason: collision with root package name */
    private /* synthetic */ a f35561c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, Handler handler, String str, int i6) {
        super(null);
        this.f35561c = aVar;
        this.f35559a = str;
        this.f35560b = i6;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z5) {
        super.onChange(z5);
        this.f35561c.b(this.f35560b, this.f35559a);
    }
}
