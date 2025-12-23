package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.zip.Checksum;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Immutable
/* loaded from: D:\Downloads\app\classes5.dex */
final class ChecksumHashFunction extends AbstractHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    private final int bits;
    private final ImmutableSupplier<? extends Checksum> checksumSupplier;
    private final String toString;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.hash.ChecksumHashFunction$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class ChecksumHasher extends AbstractByteHasher {
        private final Checksum checksum;

        /* synthetic */ ChecksumHasher(ChecksumHashFunction checksumHashFunction, Checksum checksum, AnonymousClass1 anonymousClass1) {
            this(checksum);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(byte b6) {
            this.checksum.update(b6);
        }

        private ChecksumHasher(Checksum checksum) {
            this.checksum = (Checksum) Preconditions.checkNotNull(checksum);
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            long value = this.checksum.getValue();
            return ChecksumHashFunction.this.bits == 32 ? HashCode.fromInt((int) value) : HashCode.fromLong(value);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(byte[] bArr, int i6, int i7) {
            this.checksum.update(bArr, i6, i7);
        }
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.bits;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new ChecksumHasher(this, this.checksumSupplier.get(), null);
    }

    public String toString() {
        return this.toString;
    }

    ChecksumHashFunction(ImmutableSupplier<? extends Checksum> immutableSupplier, int i6, String str) {
        boolean z5;
        this.checksumSupplier = (ImmutableSupplier) Preconditions.checkNotNull(immutableSupplier);
        if (i6 != 32 && i6 != 64) {
            z5 = false;
        } else {
            z5 = true;
        }
        Preconditions.checkArgument(z5, "bits (%s) must be either 32 or 64", i6);
        this.bits = i6;
        this.toString = (String) Preconditions.checkNotNull(str);
    }
}
