package io.netty.util;

import androidx.camera.view.p;
import androidx.concurrent.futures.a;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ResourceLeakDetector<T> {
    private static final Level DEFAULT_LEVEL;
    private static final int DEFAULT_SAMPLING_INTERVAL = 128;
    private static final int DEFAULT_TARGET_RECORDS = 4;
    private static final String PROP_LEVEL = "io.netty.leakDetection.level";
    private static final String PROP_LEVEL_OLD = "io.netty.leakDetectionLevel";
    private static final String PROP_SAMPLING_INTERVAL = "io.netty.leakDetection.samplingInterval";
    private static final String PROP_TARGET_RECORDS = "io.netty.leakDetection.targetRecords";
    static final int SAMPLING_INTERVAL;
    private static final int TARGET_RECORDS;
    private static final AtomicReference<String[]> excludedMethods;
    private static Level level;
    private static final InternalLogger logger;
    private final Set<DefaultResourceLeak<?>> allLeaks;
    private final ReferenceQueue<Object> refQueue;
    private final ConcurrentMap<String, Boolean> reportedLeaks;
    private final String resourceType;
    private final int samplingInterval;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class DefaultResourceLeak<T> extends WeakReference<Object> implements ResourceLeakTracker<T>, ResourceLeak {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Set<DefaultResourceLeak<?>> allLeaks;
        private volatile int droppedRecords;
        private volatile Record head;
        private final int trackedHash;
        private static final AtomicReferenceFieldUpdater<DefaultResourceLeak<?>, Record> headUpdater = AtomicReferenceFieldUpdater.newUpdater(DefaultResourceLeak.class, Record.class, "head");
        private static final AtomicIntegerFieldUpdater<DefaultResourceLeak<?>> droppedRecordsUpdater = AtomicIntegerFieldUpdater.newUpdater(DefaultResourceLeak.class, "droppedRecords");

        @Override // io.netty.util.ResourceLeak
        public boolean close() {
            if (!this.allLeaks.remove(this)) {
                return false;
            }
            clear();
            headUpdater.set(this, null);
            return true;
        }

        @Override // io.netty.util.ResourceLeakTracker, io.netty.util.ResourceLeak
        public void record() {
            record0(null);
        }

        private static void reachabilityFence0(Object obj) {
            if (obj != null) {
                synchronized (obj) {
                }
            }
        }

        @Override // io.netty.util.ResourceLeakTracker, io.netty.util.ResourceLeak
        public void record(Object obj) {
            record0(obj);
        }

        public String toString() {
            Record andSet = headUpdater.getAndSet(this, null);
            if (andSet == null) {
                return "";
            }
            int i6 = droppedRecordsUpdater.get(this);
            int i7 = 1;
            int i8 = andSet.pos + 1;
            StringBuilder sb = new StringBuilder(i8 * 2048);
            String str = StringUtil.NEWLINE;
            sb.append(str);
            sb.append("Recent access records: ");
            sb.append(str);
            HashSet hashSet = new HashSet(i8);
            int i9 = 0;
            while (andSet != Record.BOTTOM) {
                String record = andSet.toString();
                if (!hashSet.add(record)) {
                    i9++;
                } else if (andSet.next == Record.BOTTOM) {
                    sb.append("Created at:");
                    sb.append(StringUtil.NEWLINE);
                    sb.append(record);
                } else {
                    sb.append('#');
                    sb.append(i7);
                    sb.append(':');
                    sb.append(StringUtil.NEWLINE);
                    sb.append(record);
                    i7++;
                }
                andSet = andSet.next;
            }
            if (i9 > 0) {
                sb.append(": ");
                sb.append(i9);
                sb.append(" leak records were discarded because they were duplicates");
                sb.append(StringUtil.NEWLINE);
            }
            if (i6 > 0) {
                sb.append(": ");
                sb.append(i6);
                sb.append(" leak records were discarded because the leak record count is targeted to ");
                sb.append(ResourceLeakDetector.TARGET_RECORDS);
                sb.append(". Use system property ");
                sb.append(ResourceLeakDetector.PROP_TARGET_RECORDS);
                sb.append(" to increase the limit.");
                sb.append(StringUtil.NEWLINE);
            }
            sb.setLength(sb.length() - StringUtil.NEWLINE.length());
            return sb.toString();
        }

        DefaultResourceLeak(Object obj, ReferenceQueue<Object> referenceQueue, Set<DefaultResourceLeak<?>> set) {
            super(obj, referenceQueue);
            this.trackedHash = System.identityHashCode(obj);
            set.add(this);
            headUpdater.set(this, new Record(Record.BOTTOM));
            this.allLeaks = set;
        }

        private void record0(Object obj) {
            AtomicReferenceFieldUpdater<DefaultResourceLeak<?>, Record> atomicReferenceFieldUpdater;
            Record record;
            boolean z5;
            Record record2;
            Record record3;
            if (ResourceLeakDetector.TARGET_RECORDS > 0) {
                do {
                    atomicReferenceFieldUpdater = headUpdater;
                    record = atomicReferenceFieldUpdater.get(this);
                    if (record != null) {
                        boolean z6 = true;
                        int i6 = record.pos + 1;
                        z5 = false;
                        if (i6 >= ResourceLeakDetector.TARGET_RECORDS) {
                            if (PlatformDependent.threadLocalRandom().nextInt(1 << Math.min(i6 - ResourceLeakDetector.TARGET_RECORDS, 30)) == 0) {
                                z6 = false;
                            }
                            if (z6) {
                                record2 = record.next;
                            } else {
                                record2 = record;
                            }
                            z5 = z6;
                        } else {
                            record2 = record;
                        }
                        if (obj != null) {
                            record3 = new Record(record2, obj);
                        } else {
                            record3 = new Record(record2);
                        }
                    } else {
                        return;
                    }
                } while (!a.a(atomicReferenceFieldUpdater, this, record, record3));
                if (z5) {
                    droppedRecordsUpdater.incrementAndGet(this);
                }
            }
        }

        boolean dispose() {
            clear();
            return this.allLeaks.remove(this);
        }

        @Override // io.netty.util.ResourceLeakTracker
        public boolean close(T t5) {
            try {
                return close();
            } finally {
                reachabilityFence0(t5);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Record extends Throwable {
        private static final Record BOTTOM = new Record();
        private static final long serialVersionUID = 6065153674892850720L;
        private final String hintString;
        private final Record next;
        private final int pos;

        Record(Record record, Object obj) {
            this.hintString = obj instanceof ResourceLeakHint ? ((ResourceLeakHint) obj).toHintString() : obj.toString();
            this.next = record;
            this.pos = record.pos + 1;
        }

        @Override // java.lang.Throwable
        public String toString() {
            int i6;
            StringBuilder sb = new StringBuilder(2048);
            if (this.hintString != null) {
                sb.append("\tHint: ");
                sb.append(this.hintString);
                sb.append(StringUtil.NEWLINE);
            }
            StackTraceElement[] stackTrace = getStackTrace();
            for (int i7 = 3; i7 < stackTrace.length; i7++) {
                StackTraceElement stackTraceElement = stackTrace[i7];
                String[] strArr = (String[]) ResourceLeakDetector.excludedMethods.get();
                while (true) {
                    if (i6 >= strArr.length) {
                        sb.append('\t');
                        sb.append(stackTraceElement.toString());
                        sb.append(StringUtil.NEWLINE);
                        break;
                    }
                    i6 = (strArr[i6].equals(stackTraceElement.getClassName()) && strArr[i6 + 1].equals(stackTraceElement.getMethodName())) ? 0 : i6 + 2;
                }
            }
            return sb.toString();
        }

        Record(Record record) {
            this.hintString = null;
            this.next = record;
            this.pos = record.pos + 1;
        }

        private Record() {
            this.hintString = null;
            this.next = null;
            this.pos = -1;
        }
    }

    @Deprecated
    public ResourceLeakDetector(Class<?> cls) {
        this(StringUtil.simpleClassName(cls));
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Level {
        DISABLED,
        SIMPLE,
        ADVANCED,
        PARANOID;

        static Level parseLevel(String str) {
            String trim = str.trim();
            for (Level level : values()) {
                if (trim.equalsIgnoreCase(level.name()) || trim.equals(String.valueOf(level.ordinal()))) {
                    return level;
                }
            }
            return ResourceLeakDetector.DEFAULT_LEVEL;
        }
    }

    static {
        Level level2 = Level.SIMPLE;
        DEFAULT_LEVEL = level2;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) ResourceLeakDetector.class);
        logger = internalLoggerFactory;
        boolean z5 = false;
        if (SystemPropertyUtil.get("io.netty.noResourceLeakDetection") != null) {
            z5 = SystemPropertyUtil.getBoolean("io.netty.noResourceLeakDetection", false);
            internalLoggerFactory.debug("-Dio.netty.noResourceLeakDetection: {}", Boolean.valueOf(z5));
            internalLoggerFactory.warn("-Dio.netty.noResourceLeakDetection is deprecated. Use '-D{}={}' instead.", PROP_LEVEL, level2.name().toLowerCase());
        }
        if (z5) {
            level2 = Level.DISABLED;
        }
        Level parseLevel = Level.parseLevel(SystemPropertyUtil.get(PROP_LEVEL, SystemPropertyUtil.get(PROP_LEVEL_OLD, level2.name())));
        int i6 = SystemPropertyUtil.getInt(PROP_TARGET_RECORDS, 4);
        TARGET_RECORDS = i6;
        SAMPLING_INTERVAL = SystemPropertyUtil.getInt(PROP_SAMPLING_INTERVAL, 128);
        level = parseLevel;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-D{}: {}", PROP_LEVEL, parseLevel.name().toLowerCase());
            internalLoggerFactory.debug("-D{}: {}", PROP_TARGET_RECORDS, Integer.valueOf(i6));
        }
        excludedMethods = new AtomicReference<>(EmptyArrays.EMPTY_STRINGS);
    }

    @Deprecated
    public ResourceLeakDetector(String str) {
        this(str, 128, Long.MAX_VALUE);
    }

    public static void addExclusions(Class cls, String... strArr) {
        String[] strArr2;
        String[] strArr3;
        HashSet hashSet = new HashSet(Arrays.asList(strArr));
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        for (int i6 = 0; i6 < length && (!hashSet.remove(declaredMethods[i6].getName()) || !hashSet.isEmpty()); i6++) {
        }
        if (!hashSet.isEmpty()) {
            throw new IllegalArgumentException("Can't find '" + hashSet + "' in " + cls.getName());
        }
        do {
            strArr2 = excludedMethods.get();
            strArr3 = (String[]) Arrays.copyOf(strArr2, strArr2.length + (strArr.length * 2));
            for (int i7 = 0; i7 < strArr.length; i7++) {
                int i8 = i7 * 2;
                strArr3[strArr2.length + i8] = cls.getName();
                strArr3[strArr2.length + i8 + 1] = strArr[i7];
            }
        } while (!p.a(excludedMethods, strArr2, strArr3));
    }

    private void clearRefQueue() {
        while (true) {
            DefaultResourceLeak defaultResourceLeak = (DefaultResourceLeak) this.refQueue.poll();
            if (defaultResourceLeak == null) {
                return;
            } else {
                defaultResourceLeak.dispose();
            }
        }
    }

    public static Level getLevel() {
        return level;
    }

    private void reportLeak() {
        if (!logger.isErrorEnabled()) {
            clearRefQueue();
            return;
        }
        while (true) {
            DefaultResourceLeak defaultResourceLeak = (DefaultResourceLeak) this.refQueue.poll();
            if (defaultResourceLeak == null) {
                return;
            }
            if (defaultResourceLeak.dispose()) {
                String defaultResourceLeak2 = defaultResourceLeak.toString();
                if (this.reportedLeaks.putIfAbsent(defaultResourceLeak2, Boolean.TRUE) == null) {
                    if (defaultResourceLeak2.isEmpty()) {
                        reportUntracedLeak(this.resourceType);
                    } else {
                        reportTracedLeak(this.resourceType, defaultResourceLeak2);
                    }
                }
            }
        }
    }

    @Deprecated
    public static void setEnabled(boolean z5) {
        setLevel(z5 ? Level.SIMPLE : Level.DISABLED);
    }

    public static void setLevel(Level level2) {
        if (level2 == null) {
            throw new NullPointerException("level");
        }
        level = level2;
    }

    private DefaultResourceLeak track0(T t5) {
        Level level2 = level;
        if (level2 == Level.DISABLED) {
            return null;
        }
        if (level2.ordinal() >= Level.PARANOID.ordinal()) {
            reportLeak();
            return new DefaultResourceLeak(t5, this.refQueue, this.allLeaks);
        }
        if (PlatformDependent.threadLocalRandom().nextInt(this.samplingInterval) != 0) {
            return null;
        }
        reportLeak();
        return new DefaultResourceLeak(t5, this.refQueue, this.allLeaks);
    }

    protected void reportTracedLeak(String str, String str2) {
        logger.error("LEAK: {}.release() was not called before it's garbage-collected. See https://netty.io/wiki/reference-counted-objects.html for more information.{}", str, str2);
    }

    protected void reportUntracedLeak(String str) {
        logger.error("LEAK: {}.release() was not called before it's garbage-collected. Enable advanced leak reporting to find out where the leak occurred. To enable advanced leak reporting, specify the JVM option '-D{}={}' or call {}.setLevel() See https://netty.io/wiki/reference-counted-objects.html for more information.", str, PROP_LEVEL, Level.ADVANCED.name().toLowerCase(), StringUtil.simpleClassName(this));
    }

    @Deprecated
    public ResourceLeakDetector(Class<?> cls, int i6, long j6) {
        this(cls, i6);
    }

    public static boolean isEnabled() {
        if (getLevel().ordinal() > Level.DISABLED.ordinal()) {
            return true;
        }
        return false;
    }

    @Deprecated
    public final ResourceLeak open(T t5) {
        return track0(t5);
    }

    public final ResourceLeakTracker<T> track(T t5) {
        return track0(t5);
    }

    public ResourceLeakDetector(Class<?> cls, int i6) {
        this(StringUtil.simpleClassName(cls), i6, Long.MAX_VALUE);
    }

    @Deprecated
    public ResourceLeakDetector(String str, int i6, long j6) {
        this.allLeaks = Collections.newSetFromMap(new ConcurrentHashMap());
        this.refQueue = new ReferenceQueue<>();
        this.reportedLeaks = PlatformDependent.newConcurrentHashMap();
        if (str != null) {
            this.resourceType = str;
            this.samplingInterval = i6;
            return;
        }
        throw new NullPointerException("resourceType");
    }

    @Deprecated
    protected void reportInstancesLeak(String str) {
    }
}
