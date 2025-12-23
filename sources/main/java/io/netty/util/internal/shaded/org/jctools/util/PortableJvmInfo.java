package io.netty.util.internal.shaded.org.jctools.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface PortableJvmInfo {
    public static final int CACHE_LINE_SIZE = Integer.getInteger("jctools.cacheLineSize", 64).intValue();
    public static final int CPUs;
    public static final int RECOMENDED_OFFER_BATCH;
    public static final int RECOMENDED_POLL_BATCH;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPUs = availableProcessors;
        RECOMENDED_OFFER_BATCH = availableProcessors * 4;
        RECOMENDED_POLL_BATCH = availableProcessors * 4;
    }
}
