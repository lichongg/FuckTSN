package cn.jiguang.at;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.jiguang.au.f;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1742a;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            f.a().a(this.f1742a, message.what, message.obj);
        } catch (Throwable unused) {
        }
    }

    public a(Context context, Looper looper) {
        super(looper);
        this.f1742a = context;
    }
}
