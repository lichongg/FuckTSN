package io.netty.handler.ssl.util;

import io.netty.util.internal.PlatformDependent;
import java.security.SecureRandom;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class ThreadLocalInsecureRandom extends SecureRandom {
    private static final SecureRandom INSTANCE = new ThreadLocalInsecureRandom();
    private static final long serialVersionUID = -8209473337192526191L;

    @Override // java.util.Random
    public int nextInt() {
        return random().nextInt();
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void setSeed(long j6) {
    }

    static SecureRandom current() {
        return INSTANCE;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int i6) {
        byte[] bArr = new byte[i6];
        random().nextBytes(bArr);
        return bArr;
    }

    @Override // java.security.SecureRandom
    public String getAlgorithm() {
        return "insecure";
    }

    @Override // java.util.Random
    public int nextInt(int i6) {
        return random().nextInt(i6);
    }

    @Override // java.security.SecureRandom
    public void setSeed(byte[] bArr) {
    }

    private ThreadLocalInsecureRandom() {
    }

    private static Random random() {
        return PlatformDependent.threadLocalRandom();
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return random().nextBoolean();
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] bArr) {
        random().nextBytes(bArr);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return random().nextDouble();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return random().nextFloat();
    }

    @Override // java.util.Random
    public double nextGaussian() {
        return random().nextGaussian();
    }

    @Override // java.util.Random
    public long nextLong() {
        return random().nextLong();
    }
}
