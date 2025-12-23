package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private d f46507a;

    /* renamed from: b, reason: collision with root package name */
    private f f46508b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f46509c;

    /* renamed from: d, reason: collision with root package name */
    protected volatile n f46510d;

    protected void a(n nVar) {
        if (this.f46510d != null) {
            return;
        }
        synchronized (this) {
            if (this.f46510d != null) {
                return;
            }
            try {
                if (this.f46507a != null) {
                    this.f46510d = nVar.getParserForType().c(this.f46507a, this.f46508b);
                } else {
                    this.f46510d = nVar;
                }
            } catch (IOException unused) {
            }
        }
    }

    public int b() {
        return this.f46509c ? this.f46510d.getSerializedSize() : this.f46507a.size();
    }

    public n d(n nVar) {
        n nVar2 = this.f46510d;
        this.f46510d = nVar;
        this.f46507a = null;
        this.f46509c = true;
        return nVar2;
    }

    public n c(n nVar) {
        a(nVar);
        return this.f46510d;
    }
}
