package pl.droidsonroids.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import pl.droidsonroids.relinker.elf.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d extends c.b {

    /* renamed from: m, reason: collision with root package name */
    private final f f51910m;

    @Override // pl.droidsonroids.relinker.elf.c.b
    public c.a a(long j6, int i6) throws IOException {
        return new a(this.f51910m, this, j6, i6);
    }

    @Override // pl.droidsonroids.relinker.elf.c.b
    public c.AbstractC1002c b(long j6) throws IOException {
        return new g(this.f51910m, this, j6);
    }

    @Override // pl.droidsonroids.relinker.elf.c.b
    public c.d c(int i6) throws IOException {
        return new i(this.f51910m, this, i6);
    }

    public d(boolean z5, f fVar) throws IOException {
        ByteOrder byteOrder;
        this.f51894a = z5;
        this.f51910m = fVar;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        if (z5) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        this.f51895b = fVar.f(allocate, 16L);
        this.f51896c = fVar.i(allocate, 28L);
        this.f51897d = fVar.i(allocate, 32L);
        this.f51898e = fVar.f(allocate, 42L);
        this.f51899f = fVar.f(allocate, 44L);
        this.f51900g = fVar.f(allocate, 46L);
        this.f51901h = fVar.f(allocate, 48L);
        this.f51902i = fVar.f(allocate, 50L);
    }
}
