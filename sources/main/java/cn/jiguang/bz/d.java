package cn.jiguang.bz;

import android.content.Context;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReference<Context> f2726a = new AtomicReference<>();

    public static Context a() {
        return a(null);
    }

    public static Context a(Context context) {
        AtomicReference<Context> atomicReference = f2726a;
        Context context2 = atomicReference.get();
        if (context2 != null) {
            return context2;
        }
        Context origApplicationContext = context != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : t.a();
        atomicReference.set(origApplicationContext);
        return origApplicationContext;
    }
}
