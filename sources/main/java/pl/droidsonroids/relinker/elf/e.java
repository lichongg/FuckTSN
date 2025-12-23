package pl.droidsonroids.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import pl.droidsonroids.relinker.elf.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e extends c.b {

    /* renamed from: m, reason: collision with root package name */
    private final f f51911m;

    @Override // pl.droidsonroids.relinker.elf.c.b
    public c.a a(long j6, int i6) throws IOException {
        return new b(this.f51911m, this, j6, i6);
    }

    @Override // pl.droidsonroids.relinker.elf.c.b
    public c.AbstractC1002c b(long j6) throws IOException {
        return new h(this.f51911m, this, j6);
    }

    @Override // pl.droidsonroids.relinker.elf.c.b
    public c.d c(int i6) throws IOException {
        return new j(this.f51911m, this, i6);
    }

    public e(boolean z5, f fVar) throws IOException {
        ByteOrder byteOrder;
        this.f51894a = z5;
        this.f51911m = fVar;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        if (z5) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        this.f51895b = fVar.f(allocate, 16L);
        this.f51896c = fVar.g(allocate, 32L);
        this.f51897d = fVar.g(allocate, 40L);
        this.f51898e = fVar.f(allocate, 54L);
        this.f51899f = fVar.f(allocate, 56L);
        this.f51900g = fVar.f(allocate, 58L);
        this.f51901h = fVar.f(allocate, 60L);
        this.f51902i = fVar.f(allocate, 62L);
    }
}
