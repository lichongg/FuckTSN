package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Immutable
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class AbstractCompositeHashFunction extends AbstractHashFunction {
    private static final long serialVersionUID = 0;
    final HashFunction[] functions;

    abstract HashCode makeHash(Hasher[] hasherArr);

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        int length = this.functions.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i6 = 0; i6 < length; i6++) {
            hasherArr[i6] = this.functions[i6].newHasher();
        }
        return fromHashers(hasherArr);
    }

    private Hasher fromHashers(final Hasher[] hasherArr) {
        return new Hasher() { // from class: com.google.common.hash.AbstractCompositeHashFunction.1
            @Override // com.google.common.hash.Hasher
            public HashCode hash() {
                return AbstractCompositeHashFunction.this.makeHash(hasherArr);
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putBoolean(boolean z5) {
                for (Hasher hasher : hasherArr) {
                    hasher.putBoolean(z5);
                }
                return this;
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putByte(byte b6) {
                for (Hasher hasher : hasherArr) {
                    hasher.putByte(b6);
                }
                return this;
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putChar(char c6) {
                for (Hasher hasher : hasherArr) {
                    hasher.putChar(c6);
                }
                return this;
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putDouble(double d6) {
                for (Hasher hasher : hasherArr) {
                    hasher.putDouble(d6);
                }
                return this;
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putFloat(float f6) {
                for (Hasher hasher : hasherArr) {
                    hasher.putFloat(f6);
                }
                return this;
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putInt(int i6) {
                for (Hasher hasher : hasherArr) {
                    hasher.putInt(i6);
                }
                return this;
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putLong(long j6) {
                for (Hasher hasher : hasherArr) {
                    hasher.putLong(j6);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher
            public <T> Hasher putObject(T t5, Funnel<? super T> funnel) {
                for (Hasher hasher : hasherArr) {
                    hasher.putObject(t5, funnel);
                }
                return this;
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putShort(short s5) {
                for (Hasher hasher : hasherArr) {
                    hasher.putShort(s5);
                }
                return this;
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putString(CharSequence charSequence, Charset charset) {
                for (Hasher hasher : hasherArr) {
                    hasher.putString(charSequence, charset);
                }
                return this;
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putUnencodedChars(CharSequence charSequence) {
                for (Hasher hasher : hasherArr) {
                    hasher.putUnencodedChars(charSequence);
                }
                return this;
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putBytes(byte[] bArr) {
                for (Hasher hasher : hasherArr) {
                    hasher.putBytes(bArr);
                }
                return this;
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putBytes(byte[] bArr, int i6, int i7) {
                for (Hasher hasher : hasherArr) {
                    hasher.putBytes(bArr, i6, i7);
                }
                return this;
            }

            @Override // com.google.common.hash.PrimitiveSink
            public Hasher putBytes(ByteBuffer byteBuffer) {
                int position = byteBuffer.position();
                for (Hasher hasher : hasherArr) {
                    byteBuffer.position(position);
                    hasher.putBytes(byteBuffer);
                }
                return this;
            }
        };
    }

    AbstractCompositeHashFunction(HashFunction... hashFunctionArr) {
        for (HashFunction hashFunction : hashFunctionArr) {
            Preconditions.checkNotNull(hashFunction);
        }
        this.functions = hashFunctionArr;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public Hasher newHasher(int i6) {
        Preconditions.checkArgument(i6 >= 0);
        int length = this.functions.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i7 = 0; i7 < length; i7++) {
            hasherArr[i7] = this.functions[i7].newHasher(i6);
        }
        return fromHashers(hasherArr);
    }
}
