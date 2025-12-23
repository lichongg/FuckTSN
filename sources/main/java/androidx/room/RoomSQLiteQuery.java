package androidx.room;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"WrongConstant"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;
    public static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    public static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    private int argCount;

    @NotNull
    private final int[] bindingTypes;

    @JvmField
    @NotNull
    public final byte[][] blobBindings;

    @VisibleForTesting
    private final int capacity;

    @JvmField
    @NotNull
    public final double[] doubleBindings;

    @JvmField
    @NotNull
    public final long[] longBindings;

    @Nullable
    private volatile String query;

    @JvmField
    @NotNull
    public final String[] stringBindings;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final TreeMap<Integer, RoomSQLiteQuery> queryPool = new TreeMap<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Binding {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.v vVar) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final RoomSQLiteQuery acquire(@NotNull String query, int i6) {
            g0.p(query, "query");
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            synchronized (treeMap) {
                Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i6));
                if (ceilingEntry == null) {
                    n1 n1Var = n1.f44123a;
                    RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i6, null);
                    roomSQLiteQuery.init(query, i6);
                    return roomSQLiteQuery;
                }
                treeMap.remove(ceilingEntry.getKey());
                RoomSQLiteQuery value = ceilingEntry.getValue();
                value.init(query, i6);
                g0.m(value);
                return value;
            }
        }

        @JvmStatic
        @NotNull
        public final RoomSQLiteQuery copyFrom(@NotNull SupportSQLiteQuery supportSQLiteQuery) {
            g0.p(supportSQLiteQuery, "supportSQLiteQuery");
            final RoomSQLiteQuery acquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
            supportSQLiteQuery.bindTo(new SupportSQLiteProgram() { // from class: androidx.room.RoomSQLiteQuery$Companion$copyFrom$1
                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindDouble(int i6, double d6) {
                    RoomSQLiteQuery.this.bindDouble(i6, d6);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindLong(int i6, long j6) {
                    RoomSQLiteQuery.this.bindLong(i6, j6);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindNull(int i6) {
                    RoomSQLiteQuery.this.bindNull(i6);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void clearBindings() {
                    RoomSQLiteQuery.this.clearBindings();
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    RoomSQLiteQuery.this.close();
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindBlob(int i6, byte[] value) {
                    g0.p(value, "value");
                    RoomSQLiteQuery.this.bindBlob(i6, value);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindString(int i6, String value) {
                    g0.p(value, "value");
                    RoomSQLiteQuery.this.bindString(i6, value);
                }
            });
            return acquire;
        }

        public final void prunePoolLocked$room_runtime_release() {
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            if (treeMap.size() <= 15) {
                return;
            }
            int size = treeMap.size() - 10;
            Iterator<Integer> it = treeMap.descendingKeySet().iterator();
            g0.o(it, "iterator(...)");
            while (true) {
                int i6 = size - 1;
                if (size <= 0) {
                    return;
                }
                it.next();
                it.remove();
                size = i6;
            }
        }

        @VisibleForTesting
        public static /* synthetic */ void getDESIRED_POOL_SIZE$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getPOOL_LIMIT$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getQueryPool$annotations() {
        }
    }

    public /* synthetic */ RoomSQLiteQuery(int i6, kotlin.jvm.internal.v vVar) {
        this(i6);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(@NotNull SupportSQLiteProgram statement) {
        g0.p(statement, "statement");
        int argCount = getArgCount();
        if (1 > argCount) {
            return;
        }
        int i6 = 1;
        while (true) {
            int i7 = this.bindingTypes[i6];
            if (i7 == 1) {
                statement.bindNull(i6);
            } else if (i7 == 2) {
                statement.bindLong(i6, this.longBindings[i6]);
            } else if (i7 == 3) {
                statement.bindDouble(i6, this.doubleBindings[i6]);
            } else if (i7 == 4) {
                String str = this.stringBindings[i6];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                statement.bindString(i6, str);
            } else if (i7 == 5) {
                byte[] bArr = this.blobBindings[i6];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                statement.bindBlob(i6, bArr);
            }
            if (i6 == argCount) {
                return;
            } else {
                i6++;
            }
        }
    }

    private RoomSQLiteQuery(int i6) {
        this.capacity = i6;
        int i7 = i6 + 1;
        this.bindingTypes = new int[i7];
        this.longBindings = new long[i7];
        this.doubleBindings = new double[i7];
        this.stringBindings = new String[i7];
        this.blobBindings = new byte[i7][];
    }

    @JvmStatic
    @NotNull
    public static final RoomSQLiteQuery acquire(@NotNull String str, int i6) {
        return Companion.acquire(str, i6);
    }

    @JvmStatic
    @NotNull
    public static final RoomSQLiteQuery copyFrom(@NotNull SupportSQLiteQuery supportSQLiteQuery) {
        return Companion.copyFrom(supportSQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 toRoomRawQuery$lambda$1(RoomSQLiteQuery roomSQLiteQuery, SQLiteStatement it) {
        g0.p(it, "it");
        roomSQLiteQuery.bindTo(it);
        return n1.f44123a;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i6, double d6) {
        this.bindingTypes[i6] = 3;
        this.doubleBindings[i6] = d6;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i6, long j6) {
        this.bindingTypes[i6] = 2;
        this.longBindings[i6] = j6;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i6) {
        this.bindingTypes[i6] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        kotlin.collections.n.T1(this.bindingTypes, 1, 0, 0, 6, null);
        kotlin.collections.n.V1(this.stringBindings, null, 0, 0, 6, null);
        kotlin.collections.n.V1(this.blobBindings, null, 0, 0, 6, null);
        this.query = null;
    }

    public final void copyArgumentsFrom(@NotNull RoomSQLiteQuery other) {
        g0.p(other, "other");
        int argCount = other.getArgCount() + 1;
        System.arraycopy(other.bindingTypes, 0, this.bindingTypes, 0, argCount);
        System.arraycopy(other.longBindings, 0, this.longBindings, 0, argCount);
        System.arraycopy(other.stringBindings, 0, this.stringBindings, 0, argCount);
        System.arraycopy(other.blobBindings, 0, this.blobBindings, 0, argCount);
        System.arraycopy(other.doubleBindings, 0, this.doubleBindings, 0, argCount);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.argCount;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    @NotNull
    public String getSql() {
        String str = this.query;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    public final void init(@NotNull String query, int i6) {
        g0.p(query, "query");
        this.query = query;
        this.argCount = i6;
    }

    public final void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = queryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.capacity), this);
            Companion.prunePoolLocked$room_runtime_release();
            n1 n1Var = n1.f44123a;
        }
    }

    @NotNull
    public final RoomRawQuery toRoomRawQuery() {
        return new RoomRawQuery(getSql(), new Function1() { // from class: androidx.room.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 roomRawQuery$lambda$1;
                roomRawQuery$lambda$1 = RoomSQLiteQuery.toRoomRawQuery$lambda$1(RoomSQLiteQuery.this, (SQLiteStatement) obj);
                return roomRawQuery$lambda$1;
            }
        });
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i6, @NotNull byte[] value) {
        g0.p(value, "value");
        this.bindingTypes[i6] = 5;
        this.blobBindings[i6] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i6, @NotNull String value) {
        g0.p(value, "value");
        this.bindingTypes[i6] = 4;
        this.stringBindings[i6] = value;
    }

    public final void bindText(int i6, @NotNull String value) {
        g0.p(value, "value");
        bindString(i6, value);
    }

    public final void bindTo(@NotNull SQLiteStatement statement) {
        g0.p(statement, "statement");
        int argCount = getArgCount();
        if (1 > argCount) {
            return;
        }
        int i6 = 1;
        while (true) {
            int i7 = this.bindingTypes[i6];
            if (i7 == 1) {
                statement.mo39bindNull(i6);
            } else if (i7 == 2) {
                statement.mo38bindLong(i6, this.longBindings[i6]);
            } else if (i7 == 3) {
                statement.mo37bindDouble(i6, this.doubleBindings[i6]);
            } else if (i7 == 4) {
                String str = this.stringBindings[i6];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                statement.mo40bindText(i6, str);
            } else if (i7 == 5) {
                byte[] bArr = this.blobBindings[i6];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                statement.mo36bindBlob(i6, bArr);
            }
            if (i6 == argCount) {
                return;
            } else {
                i6++;
            }
        }
    }

    private static /* synthetic */ void getBindingTypes$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getBlobBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getDoubleBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getLongBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getStringBindings$annotations() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
