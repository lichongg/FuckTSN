package v;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.util.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b implements u<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f54678a;

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<byte[]> a() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.f54678a;
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return this.f54678a.length;
    }

    public b(byte[] bArr) {
        this.f54678a = (byte[]) k.d(bArr);
    }

    @Override // com.bumptech.glide.load.engine.u
    public void recycle() {
    }
}
