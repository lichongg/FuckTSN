package pl.droidsonroids.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import pl.droidsonroids.relinker.elf.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class h extends c.AbstractC1002c {
    public h(f fVar, c.b bVar, long j6) throws IOException {
        ByteOrder byteOrder;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        if (bVar.f51894a) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        long j7 = bVar.f51896c + (j6 * bVar.f51898e);
        this.f51905a = fVar.i(allocate, j7);
        this.f51906b = fVar.g(allocate, 8 + j7);
        this.f51907c = fVar.g(allocate, 16 + j7);
        this.f51908d = fVar.g(allocate, j7 + 40);
    }
}
