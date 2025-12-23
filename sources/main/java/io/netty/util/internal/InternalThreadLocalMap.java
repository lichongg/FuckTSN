package io.netty.util.internal;

import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class InternalThreadLocalMap extends UnpaddedInternalThreadLocalMap {
    private static final int DEFAULT_ARRAY_LIST_INITIAL_CAPACITY = 8;
    private static final int STRING_BUILDER_INITIAL_SIZE;
    private static final int STRING_BUILDER_MAX_SIZE;
    public static final Object UNSET;
    private static final InternalLogger logger;
    private BitSet cleanerFlags;
    public long rp1;
    public long rp2;
    public long rp3;
    public long rp4;
    public long rp5;
    public long rp6;
    public long rp7;
    public long rp8;
    public long rp9;

    public <E> ArrayList<E> arrayList() {
        return arrayList(8);
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) InternalThreadLocalMap.class);
        logger = internalLoggerFactory;
        UNSET = new Object();
        int i6 = SystemPropertyUtil.getInt("io.netty.threadLocalMap.stringBuilder.initialSize", 1024);
        STRING_BUILDER_INITIAL_SIZE = i6;
        internalLoggerFactory.debug("-Dio.netty.threadLocalMap.stringBuilder.initialSize: {}", Integer.valueOf(i6));
        int i7 = SystemPropertyUtil.getInt("io.netty.threadLocalMap.stringBuilder.maxSize", 4096);
        STRING_BUILDER_MAX_SIZE = i7;
        internalLoggerFactory.debug("-Dio.netty.threadLocalMap.stringBuilder.maxSize: {}", Integer.valueOf(i7));
    }

    public static void destroy() {
        UnpaddedInternalThreadLocalMap.slowThreadLocalMap.remove();
    }

    private void expandIndexedVariableTableAndSet(int i6, Object obj) {
        Object[] objArr = this.indexedVariables;
        int length = objArr.length;
        int i7 = (i6 >>> 1) | i6;
        int i8 = i7 | (i7 >>> 2);
        int i9 = i8 | (i8 >>> 4);
        int i10 = i9 | (i9 >>> 8);
        Object[] copyOf = Arrays.copyOf(objArr, (i10 | (i10 >>> 16)) + 1);
        Arrays.fill(copyOf, length, copyOf.length, UNSET);
        copyOf[i6] = obj;
        this.indexedVariables = copyOf;
    }

    public static int lastVariableIndex() {
        return UnpaddedInternalThreadLocalMap.nextIndex.get() - 1;
    }

    private static Object[] newIndexedVariableTable() {
        Object[] objArr = new Object[32];
        Arrays.fill(objArr, UNSET);
        return objArr;
    }

    public static int nextVariableIndex() {
        AtomicInteger atomicInteger = UnpaddedInternalThreadLocalMap.nextIndex;
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement >= 0) {
            return andIncrement;
        }
        atomicInteger.decrementAndGet();
        throw new IllegalStateException("too many thread-local indexed variables");
    }

    private static InternalThreadLocalMap slowGet() {
        ThreadLocal<InternalThreadLocalMap> threadLocal = UnpaddedInternalThreadLocalMap.slowThreadLocalMap;
        InternalThreadLocalMap internalThreadLocalMap = threadLocal.get();
        if (internalThreadLocalMap != null) {
            return internalThreadLocalMap;
        }
        InternalThreadLocalMap internalThreadLocalMap2 = new InternalThreadLocalMap();
        threadLocal.set(internalThreadLocalMap2);
        return internalThreadLocalMap2;
    }

    public <E> ArrayList<E> arrayList(int i6) {
        ArrayList<E> arrayList = (ArrayList<E>) this.arrayList;
        if (arrayList == null) {
            ArrayList<E> arrayList2 = new ArrayList<>(i6);
            this.arrayList = arrayList2;
            return arrayList2;
        }
        arrayList.clear();
        arrayList.ensureCapacity(i6);
        return arrayList;
    }

    public Map<Charset, CharsetDecoder> charsetDecoderCache() {
        Map<Charset, CharsetDecoder> map = this.charsetDecoderCache;
        if (map != null) {
            return map;
        }
        IdentityHashMap identityHashMap = new IdentityHashMap();
        this.charsetDecoderCache = identityHashMap;
        return identityHashMap;
    }

    public Map<Charset, CharsetEncoder> charsetEncoderCache() {
        Map<Charset, CharsetEncoder> map = this.charsetEncoderCache;
        if (map != null) {
            return map;
        }
        IdentityHashMap identityHashMap = new IdentityHashMap();
        this.charsetEncoderCache = identityHashMap;
        return identityHashMap;
    }

    @Deprecated
    public IntegerHolder counterHashCode() {
        return this.counterHashCode;
    }

    public int futureListenerStackDepth() {
        return this.futureListenerStackDepth;
    }

    public Map<Class<?>, Boolean> handlerSharableCache() {
        Map<Class<?>, Boolean> map = this.handlerSharableCache;
        if (map != null) {
            return map;
        }
        WeakHashMap weakHashMap = new WeakHashMap(4);
        this.handlerSharableCache = weakHashMap;
        return weakHashMap;
    }

    public Object indexedVariable(int i6) {
        Object[] objArr = this.indexedVariables;
        return i6 < objArr.length ? objArr[i6] : UNSET;
    }

    public boolean isCleanerFlagSet(int i6) {
        BitSet bitSet = this.cleanerFlags;
        return bitSet != null && bitSet.get(i6);
    }

    public boolean isIndexedVariableSet(int i6) {
        Object[] objArr = this.indexedVariables;
        return i6 < objArr.length && objArr[i6] != UNSET;
    }

    public int localChannelReaderStackDepth() {
        return this.localChannelReaderStackDepth;
    }

    public ThreadLocalRandom random() {
        ThreadLocalRandom threadLocalRandom = this.random;
        if (threadLocalRandom != null) {
            return threadLocalRandom;
        }
        ThreadLocalRandom threadLocalRandom2 = new ThreadLocalRandom();
        this.random = threadLocalRandom2;
        return threadLocalRandom2;
    }

    public Object removeIndexedVariable(int i6) {
        Object[] objArr = this.indexedVariables;
        if (i6 >= objArr.length) {
            return UNSET;
        }
        Object obj = objArr[i6];
        objArr[i6] = UNSET;
        return obj;
    }

    public void setCleanerFlag(int i6) {
        if (this.cleanerFlags == null) {
            this.cleanerFlags = new BitSet();
        }
        this.cleanerFlags.set(i6);
    }

    @Deprecated
    public void setCounterHashCode(IntegerHolder integerHolder) {
        this.counterHashCode = integerHolder;
    }

    public void setFutureListenerStackDepth(int i6) {
        this.futureListenerStackDepth = i6;
    }

    public boolean setIndexedVariable(int i6, Object obj) {
        Object[] objArr = this.indexedVariables;
        if (i6 >= objArr.length) {
            expandIndexedVariableTableAndSet(i6, obj);
            return true;
        }
        Object obj2 = objArr[i6];
        objArr[i6] = obj;
        return obj2 == UNSET;
    }

    public void setLocalChannelReaderStackDepth(int i6) {
        this.localChannelReaderStackDepth = i6;
    }

    public int size() {
        int i6 = this.futureListenerStackDepth != 0 ? 1 : 0;
        if (this.localChannelReaderStackDepth != 0) {
            i6++;
        }
        if (this.handlerSharableCache != null) {
            i6++;
        }
        if (this.counterHashCode != null) {
            i6++;
        }
        if (this.random != null) {
            i6++;
        }
        if (this.typeParameterMatcherGetCache != null) {
            i6++;
        }
        if (this.typeParameterMatcherFindCache != null) {
            i6++;
        }
        if (this.stringBuilder != null) {
            i6++;
        }
        if (this.charsetEncoderCache != null) {
            i6++;
        }
        if (this.charsetDecoderCache != null) {
            i6++;
        }
        if (this.arrayList != null) {
            i6++;
        }
        for (Object obj : this.indexedVariables) {
            if (obj != UNSET) {
                i6++;
            }
        }
        return i6 - 1;
    }

    public StringBuilder stringBuilder() {
        StringBuilder sb = this.stringBuilder;
        if (sb == null) {
            StringBuilder sb2 = new StringBuilder(STRING_BUILDER_INITIAL_SIZE);
            this.stringBuilder = sb2;
            return sb2;
        }
        if (sb.capacity() > STRING_BUILDER_MAX_SIZE) {
            sb.setLength(STRING_BUILDER_INITIAL_SIZE);
            sb.trimToSize();
        }
        sb.setLength(0);
        return sb;
    }

    public Map<Class<?>, Map<String, TypeParameterMatcher>> typeParameterMatcherFindCache() {
        Map<Class<?>, Map<String, TypeParameterMatcher>> map = this.typeParameterMatcherFindCache;
        if (map != null) {
            return map;
        }
        IdentityHashMap identityHashMap = new IdentityHashMap();
        this.typeParameterMatcherFindCache = identityHashMap;
        return identityHashMap;
    }

    public Map<Class<?>, TypeParameterMatcher> typeParameterMatcherGetCache() {
        Map<Class<?>, TypeParameterMatcher> map = this.typeParameterMatcherGetCache;
        if (map != null) {
            return map;
        }
        IdentityHashMap identityHashMap = new IdentityHashMap();
        this.typeParameterMatcherGetCache = identityHashMap;
        return identityHashMap;
    }

    private InternalThreadLocalMap() {
        super(newIndexedVariableTable());
    }

    private static InternalThreadLocalMap fastGet(FastThreadLocalThread fastThreadLocalThread) {
        InternalThreadLocalMap threadLocalMap = fastThreadLocalThread.threadLocalMap();
        if (threadLocalMap == null) {
            InternalThreadLocalMap internalThreadLocalMap = new InternalThreadLocalMap();
            fastThreadLocalThread.setThreadLocalMap(internalThreadLocalMap);
            return internalThreadLocalMap;
        }
        return threadLocalMap;
    }

    public static InternalThreadLocalMap get() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof FastThreadLocalThread) {
            return fastGet((FastThreadLocalThread) currentThread);
        }
        return slowGet();
    }

    public static InternalThreadLocalMap getIfSet() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof FastThreadLocalThread) {
            return ((FastThreadLocalThread) currentThread).threadLocalMap();
        }
        return UnpaddedInternalThreadLocalMap.slowThreadLocalMap.get();
    }

    public static void remove() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof FastThreadLocalThread) {
            ((FastThreadLocalThread) currentThread).setThreadLocalMap(null);
        } else {
            UnpaddedInternalThreadLocalMap.slowThreadLocalMap.remove();
        }
    }
}
