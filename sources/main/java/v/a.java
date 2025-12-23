package v;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.e;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a implements e<ByteBuffer> {

    /* renamed from: a, reason: collision with root package name */
    private final ByteBuffer f54677a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: v.a$a, reason: collision with other inner class name */
    public static class C1082a implements e.a<ByteBuffer> {
        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public e<ByteBuffer> b(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ByteBuffer a() {
        this.f54677a.position(0);
        return this.f54677a;
    }

    public a(ByteBuffer byteBuffer) {
        this.f54677a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
    }
}
