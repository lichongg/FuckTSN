package j1;

import android.content.Context;
import java.io.InputStream;

@Deprecated
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f43448a;

    /* renamed from: b, reason: collision with root package name */
    private InputStream f43449b;

    public abstract InputStream b(Context context);

    public final void a() {
        com.huawei.agconnect.config.impl.b.a(this.f43449b);
    }

    public InputStream c() {
        if (this.f43449b == null) {
            this.f43449b = b(this.f43448a);
        }
        return this.f43449b;
    }

    public b(Context context) {
        this.f43448a = context;
    }
}
