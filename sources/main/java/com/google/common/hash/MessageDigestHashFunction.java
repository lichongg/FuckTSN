package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Immutable
/* loaded from: D:\Downloads\app\classes5.dex */
final class MessageDigestHashFunction extends AbstractHashFunction implements Serializable {
    private final int bytes;
    private final MessageDigest prototype;
    private final boolean supportsClone;
    private final String toString;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.hash.MessageDigestHashFunction$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class MessageDigestHasher extends AbstractByteHasher {
        private final int bytes;
        private final MessageDigest digest;
        private boolean done;

        /* synthetic */ MessageDigestHasher(MessageDigest messageDigest, int i6, AnonymousClass1 anonymousClass1) {
            this(messageDigest, i6);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(byte b6) {
            checkNotDone();
            this.digest.update(b6);
        }

        private MessageDigestHasher(MessageDigest messageDigest, int i6) {
            this.digest = messageDigest;
            this.bytes = i6;
        }

        private void checkNotDone() {
            Preconditions.checkState(!this.done, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            checkNotDone();
            this.done = true;
            if (this.bytes == this.digest.getDigestLength()) {
                return HashCode.fromBytesNoCopy(this.digest.digest());
            }
            return HashCode.fromBytesNoCopy(Arrays.copyOf(this.digest.digest(), this.bytes));
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(byte[] bArr, int i6, int i7) {
            checkNotDone();
            this.digest.update(bArr, i6, i7);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(ByteBuffer byteBuffer) {
            checkNotDone();
            this.digest.update(byteBuffer);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final String algorithmName;
        private final int bytes;
        private final String toString;

        /* synthetic */ SerializedForm(String str, int i6, String str2, AnonymousClass1 anonymousClass1) {
            this(str, i6, str2);
        }

        private SerializedForm(String str, int i6, String str2) {
            this.algorithmName = str;
            this.bytes = i6;
            this.toString = str2;
        }

        private Object readResolve() {
            return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
        }
    }

    MessageDigestHashFunction(String str, String str2) {
        MessageDigest messageDigest = getMessageDigest(str);
        this.prototype = messageDigest;
        this.bytes = messageDigest.getDigestLength();
        this.toString = (String) Preconditions.checkNotNull(str2);
        this.supportsClone = supportsClone(messageDigest);
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.bytes * 8;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        AnonymousClass1 anonymousClass1 = null;
        if (this.supportsClone) {
            try {
                return new MessageDigestHasher((MessageDigest) this.prototype.clone(), this.bytes, anonymousClass1);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new MessageDigestHasher(getMessageDigest(this.prototype.getAlgorithm()), this.bytes, anonymousClass1);
    }

    public String toString() {
        return this.toString;
    }

    Object writeReplace() {
        return new SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString, null);
    }

    private static MessageDigest getMessageDigest(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e6) {
            throw new AssertionError(e6);
        }
    }

    private static boolean supportsClone(MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    MessageDigestHashFunction(String str, int i6, String str2) {
        this.toString = (String) Preconditions.checkNotNull(str2);
        MessageDigest messageDigest = getMessageDigest(str);
        this.prototype = messageDigest;
        int digestLength = messageDigest.getDigestLength();
        Preconditions.checkArgument(i6 >= 4 && i6 <= digestLength, "bytes (%s) must be >= 4 and < %s", i6, digestLength);
        this.bytes = i6;
        this.supportsClone = supportsClone(messageDigest);
    }
}
