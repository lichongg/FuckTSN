package androidx.room;

import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRoomDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomDatabase.kt\nandroidx/room/RoomDatabaseKt__RoomDatabaseKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,596:1\n1#2:597\n216#3,2:598\n*S KotlinDebug\n*F\n+ 1 RoomDatabase.kt\nandroidx/room/RoomDatabaseKt__RoomDatabaseKt\n*L\n565#1:598,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
final /* synthetic */ class RoomDatabaseKt__RoomDatabaseKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <R> java.lang.Object useWriterConnection(@org.jetbrains.annotations.NotNull androidx.room.RoomDatabase r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.room.Transactor, ? super kotlin.coroutines.e<? super R>, ? extends java.lang.Object> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super R> r7) {
        /*
            boolean r0 = r7 instanceof androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1 r0 = (androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1 r0 = new androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            androidx.room.RoomDatabase r5 = (androidx.room.RoomDatabase) r5
            kotlin.g0.n(r7)
            goto L51
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.g0.n(r7)
            kotlinx.coroutines.r0 r7 = r5.getCoroutineScope()
            kotlin.coroutines.i r7 = r7.getCoroutineContext()
            androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2 r2 = new androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.i.h(r7, r2, r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            androidx.room.InvalidationTracker r5 = r5.getInvalidationTracker()
            r5.refreshAsync()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt__RoomDatabaseKt.useWriterConnection(androidx.room.RoomDatabase, kotlin.jvm.functions.Function2, kotlin.coroutines.e):java.lang.Object");
    }

    public static final void validateAutoMigrations(@NotNull RoomDatabase roomDatabase, @NotNull DatabaseConfiguration configuration) {
        g0.p(roomDatabase, "<this>");
        g0.p(configuration, "configuration");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set<kotlin.reflect.d<? extends AutoMigrationSpec>> requiredAutoMigrationSpecClasses = roomDatabase.getRequiredAutoMigrationSpecClasses();
        int size = configuration.autoMigrationSpecs.size();
        boolean[] zArr = new boolean[size];
        Iterator<kotlin.reflect.d<? extends AutoMigrationSpec>> it = requiredAutoMigrationSpecClasses.iterator();
        while (true) {
            int i6 = -1;
            if (!it.hasNext()) {
                int size2 = configuration.autoMigrationSpecs.size() - 1;
                if (size2 >= 0) {
                    while (true) {
                        int i7 = size2 - 1;
                        if (size2 >= size || !zArr[size2]) {
                            break;
                        } else if (i7 < 0) {
                            break;
                        } else {
                            size2 = i7;
                        }
                    }
                    throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                }
                for (Migration migration : roomDatabase.createAutoMigrations(linkedHashMap)) {
                    if (!configuration.migrationContainer.contains(migration.startVersion, migration.endVersion)) {
                        configuration.migrationContainer.addMigration(migration);
                    }
                }
                return;
            }
            kotlin.reflect.d<? extends AutoMigrationSpec> next = it.next();
            int size3 = configuration.autoMigrationSpecs.size() - 1;
            if (size3 >= 0) {
                while (true) {
                    int i8 = size3 - 1;
                    if (next.C(configuration.autoMigrationSpecs.get(size3))) {
                        zArr[size3] = true;
                        i6 = size3;
                        break;
                    } else if (i8 < 0) {
                        break;
                    } else {
                        size3 = i8;
                    }
                }
            }
            if (i6 < 0) {
                throw new IllegalArgumentException(("A required auto migration spec (" + next.x() + ") is missing in the database configuration.").toString());
            }
            linkedHashMap.put(next, configuration.autoMigrationSpecs.get(i6));
        }
    }

    public static final void validateMigrationsNotRequired(@NotNull Set<Integer> migrationStartAndEndVersions, @NotNull Set<Integer> migrationsNotRequiredFrom) {
        g0.p(migrationStartAndEndVersions, "migrationStartAndEndVersions");
        g0.p(migrationsNotRequiredFrom, "migrationsNotRequiredFrom");
        if (migrationStartAndEndVersions.isEmpty()) {
            return;
        }
        Iterator<Integer> it = migrationStartAndEndVersions.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (migrationsNotRequiredFrom.contains(Integer.valueOf(intValue))) {
                throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration() that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(). Start version is: " + intValue).toString());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006c A[LOOP:1: B:5:0x003b->B:17:0x006c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void validateTypeConverters(@org.jetbrains.annotations.NotNull androidx.room.RoomDatabase r9, @org.jetbrains.annotations.NotNull androidx.room.DatabaseConfiguration r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.g0.p(r9, r0)
            java.lang.String r0 = "configuration"
            kotlin.jvm.internal.g0.p(r10, r0)
            java.util.Map r0 = r9.getRequiredTypeConverterClassesMap$room_runtime_release()
            java.util.List<java.lang.Object> r1 = r10.typeConverters
            int r1 = r1.size()
            boolean[] r1 = new boolean[r1]
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L1e:
            boolean r2 = r0.hasNext()
            r3 = -1
            if (r2 == 0) goto La6
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r4 = r2.getKey()
            kotlin.reflect.d r4 = (kotlin.reflect.d) r4
            java.lang.Object r2 = r2.getValue()
            java.util.List r2 = (java.util.List) r2
            java.util.Iterator r2 = r2.iterator()
        L3b:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L1e
            java.lang.Object r5 = r2.next()
            kotlin.reflect.d r5 = (kotlin.reflect.d) r5
            java.util.List<java.lang.Object> r6 = r10.typeConverters
            java.util.Collection r6 = (java.util.Collection) r6
            int r6 = r6.size()
            int r6 = r6 + r3
            if (r6 < 0) goto L69
        L52:
            int r7 = r6 + (-1)
            java.util.List<java.lang.Object> r8 = r10.typeConverters
            java.lang.Object r8 = r8.get(r6)
            boolean r8 = r5.C(r8)
            if (r8 == 0) goto L64
            r7 = 1
            r1[r6] = r7
            goto L6a
        L64:
            if (r7 >= 0) goto L67
            goto L69
        L67:
            r6 = r7
            goto L52
        L69:
            r6 = -1
        L6a:
            if (r6 < 0) goto L76
            java.util.List<java.lang.Object> r7 = r10.typeConverters
            java.lang.Object r6 = r7.get(r6)
            r9.addTypeConverter$room_runtime_release(r5, r6)
            goto L3b
        L76:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "A required type converter ("
            r9.append(r10)
            java.lang.String r10 = r5.x()
            r9.append(r10)
            java.lang.String r10 = ") for "
            r9.append(r10)
            java.lang.String r10 = r4.x()
            r9.append(r10)
            java.lang.String r10 = " is missing in the database configuration."
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        La6:
            java.util.List<java.lang.Object> r9 = r10.typeConverters
            java.util.Collection r9 = (java.util.Collection) r9
            int r9 = r9.size()
            int r9 = r9 + r3
            if (r9 < 0) goto Lde
        Lb1:
            int r0 = r9 + (-1)
            boolean r2 = r1[r9]
            if (r2 == 0) goto Lbc
            if (r0 >= 0) goto Lba
            goto Lde
        Lba:
            r9 = r0
            goto Lb1
        Lbc:
            java.util.List<java.lang.Object> r10 = r10.typeConverters
            java.lang.Object r9 = r10.get(r9)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unexpected type converter "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder."
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r10.<init>(r9)
            throw r10
        Lde:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt__RoomDatabaseKt.validateTypeConverters(androidx.room.RoomDatabase, androidx.room.DatabaseConfiguration):void");
    }

    @Nullable
    public static final <R> Object useReaderConnection(@NotNull RoomDatabase roomDatabase, @NotNull Function2<? super Transactor, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super R> eVar) {
        return kotlinx.coroutines.i.h(roomDatabase.getCoroutineScope().getCoroutineContext(), new RoomDatabaseKt__RoomDatabaseKt$useReaderConnection$2(roomDatabase, function2, null), eVar);
    }
}
