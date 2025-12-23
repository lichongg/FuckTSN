package com.bumptech.glide.signature;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.util.l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a implements com.bumptech.glide.load.c {

    /* renamed from: c, reason: collision with root package name */
    private final int f16298c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.c f16299d;

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        this.f16299d.b(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f16298c).array());
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f16298c == aVar.f16298c && this.f16299d.equals(aVar.f16299d)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return l.q(this.f16299d, this.f16298c);
    }

    private a(int i6, com.bumptech.glide.load.c cVar) {
        this.f16298c = i6;
        this.f16299d = cVar;
    }

    @NonNull
    public static com.bumptech.glide.load.c c(@NonNull Context context) {
        return new a(context.getResources().getConfiguration().uiMode & 48, b.c(context));
    }
}
