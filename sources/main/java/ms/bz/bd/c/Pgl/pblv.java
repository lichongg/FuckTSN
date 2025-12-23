package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pblv {

    /* renamed from: b, reason: collision with root package name */
    private static final pblv f50375b = new pblv();

    /* renamed from: a, reason: collision with root package name */
    private Context f50376a;

    public static pblv a() {
        return f50375b;
    }

    public final void b(Context context) {
        this.f50376a = context != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : null;
    }

    public final Context c() {
        return this.f50376a;
    }
}
