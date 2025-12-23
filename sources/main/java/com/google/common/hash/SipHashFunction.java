package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Immutable
/* loaded from: D:\Downloads\app\classes5.dex */
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* renamed from: c, reason: collision with root package name */
    private final int f32755c;

    /* renamed from: d, reason: collision with root package name */
    private final int f32756d;

    /* renamed from: k0, reason: collision with root package name */
    private final long f32757k0;

    /* renamed from: k1, reason: collision with root package name */
    private final long f32758k1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* renamed from: b, reason: collision with root package name */
        private long f32759b;

        /* renamed from: c, reason: collision with root package name */
        private final int f32760c;

        /* renamed from: d, reason: collision with root package name */
        private final int f32761d;
        private long finalM;

        /* renamed from: v0, reason: collision with root package name */
        private long f32762v0;

        /* renamed from: v1, reason: collision with root package name */
        private long f32763v1;

        /* renamed from: v2, reason: collision with root package name */
        private long f32764v2;

        /* renamed from: v3, reason: collision with root package name */
        private long f32765v3;

        private void sipRound(int i6) {
            for (int i7 = 0; i7 < i6; i7++) {
                long j6 = this.f32762v0;
                long j7 = this.f32763v1;
                this.f32762v0 = j6 + j7;
                this.f32764v2 += this.f32765v3;
                this.f32763v1 = Long.rotateLeft(j7, 13);
                long rotateLeft = Long.rotateLeft(this.f32765v3, 16);
                long j8 = this.f32763v1;
                long j9 = this.f32762v0;
                this.f32763v1 = j8 ^ j9;
                this.f32765v3 = rotateLeft ^ this.f32764v2;
                long rotateLeft2 = Long.rotateLeft(j9, 32);
                long j10 = this.f32764v2;
                long j11 = this.f32763v1;
                this.f32764v2 = j10 + j11;
                this.f32762v0 = rotateLeft2 + this.f32765v3;
                this.f32763v1 = Long.rotateLeft(j11, 17);
                long rotateLeft3 = Long.rotateLeft(this.f32765v3, 21);
                long j12 = this.f32763v1;
                long j13 = this.f32764v2;
                this.f32763v1 = j12 ^ j13;
                this.f32765v3 = rotateLeft3 ^ this.f32762v0;
                this.f32764v2 = Long.rotateLeft(j13, 32);
            }
        }

        SipHasher(int i6, int i7, long j6, long j7) {
            super(8);
            this.f32759b = 0L;
            this.finalM = 0L;
            this.f32760c = i6;
            this.f32761d = i7;
            this.f32762v0 = 8317987319222330741L ^ j6;
            this.f32763v1 = 7237128888997146477L ^ j7;
            this.f32764v2 = 7816392313619706465L ^ j6;
            this.f32765v3 = 8387220255154660723L ^ j7;
        }

        private void processM(long j6) {
            this.f32765v3 ^= j6;
            sipRound(this.f32760c);
            this.f32762v0 = j6 ^ this.f32762v0;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public HashCode makeHash() {
            long j6 = this.finalM ^ (this.f32759b << 56);
            this.finalM = j6;
            processM(j6);
            this.f32764v2 ^= 255;
            sipRound(this.f32761d);
            return HashCode.fromLong(((this.f32762v0 ^ this.f32763v1) ^ this.f32764v2) ^ this.f32765v3);
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void process(ByteBuffer byteBuffer) {
            this.f32759b += 8;
            processM(byteBuffer.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void processRemaining(ByteBuffer byteBuffer) {
            this.f32759b += byteBuffer.remaining();
            int i6 = 0;
            while (byteBuffer.hasRemaining()) {
                this.finalM ^= (byteBuffer.get() & 255) << i6;
                i6 += 8;
            }
        }
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof SipHashFunction) {
            SipHashFunction sipHashFunction = (SipHashFunction) obj;
            if (this.f32755c == sipHashFunction.f32755c && this.f32756d == sipHashFunction.f32756d && this.f32757k0 == sipHashFunction.f32757k0 && this.f32758k1 == sipHashFunction.f32758k1) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((SipHashFunction.class.hashCode() ^ this.f32755c) ^ this.f32756d) ^ this.f32757k0) ^ this.f32758k1);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new SipHasher(this.f32755c, this.f32756d, this.f32757k0, this.f32758k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f32755c + "" + this.f32756d + "(" + this.f32757k0 + ", " + this.f32758k1 + ")";
    }

    SipHashFunction(int i6, int i7, long j6, long j7) {
        boolean z5;
        if (i6 > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "The number of SipRound iterations (c=%s) during Compression must be positive.", i6);
        Preconditions.checkArgument(i7 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i7);
        this.f32755c = i6;
        this.f32756d = i7;
        this.f32757k0 = j6;
        this.f32758k1 = j7;
    }
}
