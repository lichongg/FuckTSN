package okio.internal;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.j1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.o0;
import kotlin.text.u;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;
import okio.ZipFileSystem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nZipFiles.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZipFiles.kt\nokio/internal/ZipFilesKt\n+ 2 Okio.kt\nokio/Okio__OkioKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,503:1\n58#2,4:504\n58#2,4:508\n58#2,22:512\n66#2,10:534\n62#2,3:544\n77#2,3:547\n58#2,22:550\n66#2,10:572\n62#2,3:582\n77#2,3:585\n1056#3:588\n*S KotlinDebug\n*F\n+ 1 ZipFiles.kt\nokio/internal/ZipFilesKt\n*L\n66#1:504,4\n101#1:508,4\n109#1:512,22\n101#1:534,10\n101#1:544,3\n101#1:547,3\n125#1:550,22\n66#1:572,10\n66#1:582,3\n66#1:585,3\n155#1:588\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class ZipFilesKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_NTFS_EXTRA = 10;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    @Nullable
    public static final Long dosDateTimeToEpochMillis(int i6, int i7) {
        if (i7 == -1) {
            return null;
        }
        return Long.valueOf(_ZlibJvmKt.datePartsToEpochMillis(((i6 >> 9) & 127) + 1980, (i6 >> 5) & 15, i6 & 31, (i7 >> 11) & 31, (i7 >> 5) & 63, (i7 & 31) << 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 readCentralDirectoryZipEntry$lambda$1(Ref.BooleanRef booleanRef, long j6, Ref.LongRef longRef, final BufferedSource bufferedSource, Ref.LongRef longRef2, Ref.LongRef longRef3, final Ref.ObjectRef objectRef, final Ref.ObjectRef objectRef2, final Ref.ObjectRef objectRef3, int i6, long j7) {
        if (i6 != 1) {
            if (i6 == 10) {
                if (j7 < 4) {
                    throw new IOException("bad zip: NTFS extra too short");
                }
                bufferedSource.skip(4L);
                readExtra(bufferedSource, (int) (j7 - 4), new Function2() { // from class: okio.internal.d
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        n1 readCentralDirectoryZipEntry$lambda$1$0;
                        readCentralDirectoryZipEntry$lambda$1$0 = ZipFilesKt.readCentralDirectoryZipEntry$lambda$1$0(Ref.ObjectRef.this, bufferedSource, objectRef2, objectRef3, ((Integer) obj).intValue(), ((Long) obj2).longValue());
                        return readCentralDirectoryZipEntry$lambda$1$0;
                    }
                });
            }
        } else {
            if (booleanRef.element) {
                throw new IOException("bad zip: zip64 extra repeated");
            }
            booleanRef.element = true;
            if (j7 < j6) {
                throw new IOException("bad zip: zip64 extra too short");
            }
            long j8 = longRef.element;
            if (j8 == 4294967295L) {
                j8 = bufferedSource.readLongLe();
            }
            longRef.element = j8;
            longRef2.element = longRef2.element == 4294967295L ? bufferedSource.readLongLe() : 0L;
            longRef3.element = longRef3.element == 4294967295L ? bufferedSource.readLongLe() : 0L;
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r2v6, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.Long] */
    public static final n1 readCentralDirectoryZipEntry$lambda$1$0(Ref.ObjectRef objectRef, BufferedSource bufferedSource, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, int i6, long j6) {
        if (i6 == 1) {
            if (objectRef.element != 0) {
                throw new IOException("bad zip: NTFS extra attribute tag 0x0001 repeated");
            }
            if (j6 != 24) {
                throw new IOException("bad zip: NTFS extra attribute tag 0x0001 size != 24");
            }
            objectRef.element = Long.valueOf(bufferedSource.readLongLe());
            objectRef2.element = Long.valueOf(bufferedSource.readLongLe());
            objectRef3.element = Long.valueOf(bufferedSource.readLongLe());
        }
        return n1.f44123a;
    }

    private static final void readExtra(BufferedSource bufferedSource, int i6, Function2<? super Integer, ? super Long, n1> function2) {
        long j6 = i6;
        while (j6 != 0) {
            if (j6 < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int readShortLe = bufferedSource.readShortLe() & j1.f43986d;
            long readShortLe2 = bufferedSource.readShortLe() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
            long j7 = j6 - 4;
            if (j7 < readShortLe2) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            bufferedSource.require(readShortLe2);
            long size = bufferedSource.getBuffer().size();
            function2.invoke(Integer.valueOf(readShortLe), Long.valueOf(readShortLe2));
            long size2 = (bufferedSource.getBuffer().size() + readShortLe2) - size;
            if (size2 < 0) {
                throw new IOException("unsupported zip: too many bytes processed for " + readShortLe);
            }
            if (size2 > 0) {
                bufferedSource.getBuffer().skip(size2);
            }
            j6 = j7 - readShortLe2;
        }
    }

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        Path path = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
        Map<Path, ZipEntry> j02 = i1.j0(o0.a(path, new ZipEntry(path, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, null, null, null, 65532, null)));
        for (ZipEntry zipEntry : f0.z5(list, new Comparator() { // from class: okio.internal.ZipFilesKt$buildIndex$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                return kotlin.comparisons.a.l(((ZipEntry) t5).getCanonicalPath(), ((ZipEntry) t6).getCanonicalPath());
            }
        })) {
            if (j02.put(zipEntry.getCanonicalPath(), zipEntry) == null) {
                while (true) {
                    Path parent = zipEntry.getCanonicalPath().parent();
                    if (parent != null) {
                        ZipEntry zipEntry2 = j02.get(parent);
                        if (zipEntry2 != null) {
                            zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                            break;
                        }
                        ZipEntry zipEntry3 = new ZipEntry(parent, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, null, null, null, 65532, null);
                        j02.put(parent, zipEntry3);
                        zipEntry3.getChildren().add(zipEntry.getCanonicalPath());
                        zipEntry = zipEntry3;
                    }
                }
            }
        }
        return j02;
    }

    public static final long filetimeToEpochMillis(long j6) {
        return (j6 / 10000) - 11644473600000L;
    }

    private static final String getHex(int i6) {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        String num = Integer.toString(i6, kotlin.text.b.a(16));
        g0.o(num, "toString(...)");
        sb.append(num);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010b A[Catch: all -> 0x0103, TryCatch #1 {all -> 0x0103, blocks: (B:3:0x0019, B:5:0x0027, B:6:0x0030, B:19:0x004e, B:21:0x005a, B:60:0x010b, B:65:0x00ff, B:77:0x010c, B:97:0x016e, B:104:0x017f, B:118:0x0168, B:10:0x0182, B:14:0x018e, B:15:0x0195, B:122:0x0196, B:123:0x0199, B:124:0x019a, B:125:0x01b4, B:8:0x0038, B:18:0x0041, B:79:0x011d, B:82:0x0125, B:84:0x0135, B:86:0x0141, B:88:0x0148, B:91:0x014c, B:92:0x0153, B:94:0x0154, B:115:0x0161, B:62:0x00f8), top: B:2:0x0019, inners: #0, #2, #3, #12 }] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final okio.ZipFileSystem openZip(@org.jetbrains.annotations.NotNull okio.Path r19, @org.jetbrains.annotations.NotNull okio.FileSystem r20, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super okio.internal.ZipEntry, java.lang.Boolean> r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ZipFilesKt.openZip(okio.Path, okio.FileSystem, kotlin.jvm.functions.Function1):okio.ZipFileSystem");
    }

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, Function1 function1, int i6, Object obj) throws IOException {
        if ((i6 & 4) != 0) {
            function1 = new Function1() { // from class: okio.internal.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    boolean openZip$lambda$0;
                    openZip$lambda$0 = ZipFilesKt.openZip$lambda$0((ZipEntry) obj2);
                    return Boolean.valueOf(openZip$lambda$0);
                }
            };
        }
        return openZip(path, fileSystem, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean openZip$lambda$0(ZipEntry it) {
        g0.p(it, "it");
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final ZipEntry readCentralDirectoryZipEntry(@NotNull final BufferedSource bufferedSource) throws IOException {
        g0.p(bufferedSource, "<this>");
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe != CENTRAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
        }
        bufferedSource.skip(4L);
        short readShortLe = bufferedSource.readShortLe();
        int i6 = readShortLe & j1.f43986d;
        if ((readShortLe & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(i6));
        }
        int readShortLe2 = bufferedSource.readShortLe() & j1.f43986d;
        int readShortLe3 = bufferedSource.readShortLe() & j1.f43986d;
        int readShortLe4 = bufferedSource.readShortLe() & j1.f43986d;
        long readIntLe2 = bufferedSource.readIntLe() & 4294967295L;
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = bufferedSource.readIntLe() & 4294967295L;
        final Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = bufferedSource.readIntLe() & 4294967295L;
        int readShortLe5 = bufferedSource.readShortLe() & j1.f43986d;
        int readShortLe6 = bufferedSource.readShortLe() & j1.f43986d;
        int readShortLe7 = bufferedSource.readShortLe() & j1.f43986d;
        bufferedSource.skip(8L);
        final Ref.LongRef longRef3 = new Ref.LongRef();
        longRef3.element = bufferedSource.readIntLe() & 4294967295L;
        String readUtf8 = bufferedSource.readUtf8(readShortLe5);
        if (u.k3(readUtf8, (char) 0, false, 2, null)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        long j6 = longRef2.element == 4294967295L ? 8 : 0L;
        if (longRef.element == 4294967295L) {
            j6 += 8;
        }
        if (longRef3.element == 4294967295L) {
            j6 += 8;
        }
        final long j7 = j6;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        readExtra(bufferedSource, readShortLe6, new Function2() { // from class: okio.internal.f
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                n1 readCentralDirectoryZipEntry$lambda$1;
                readCentralDirectoryZipEntry$lambda$1 = ZipFilesKt.readCentralDirectoryZipEntry$lambda$1(Ref.BooleanRef.this, j7, longRef2, bufferedSource, longRef, longRef3, objectRef, objectRef2, objectRef3, ((Integer) obj).intValue(), ((Long) obj2).longValue());
                return readCentralDirectoryZipEntry$lambda$1;
            }
        });
        if (j7 <= 0 || booleanRef.element) {
            return new ZipEntry(Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null).resolve(readUtf8), u.Z1(readUtf8, "/", false, 2, null), bufferedSource.readUtf8(readShortLe7), readIntLe2, longRef.element, longRef2.element, readShortLe2, longRef3.element, readShortLe4, readShortLe3, (Long) objectRef.element, (Long) objectRef2.element, (Long) objectRef3.element, null, null, null, 57344, null);
        }
        throw new IOException("bad zip: zip64 extra required but absent");
    }

    @NotNull
    public static final ZipEntry readLocalHeader(@NotNull BufferedSource bufferedSource, @NotNull ZipEntry centralDirectoryZipEntry) {
        g0.p(bufferedSource, "<this>");
        g0.p(centralDirectoryZipEntry, "centralDirectoryZipEntry");
        ZipEntry readOrSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, centralDirectoryZipEntry);
        g0.m(readOrSkipLocalHeader);
        return readOrSkipLocalHeader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r10v2, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r13v3, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r9v5, types: [T, java.lang.Integer] */
    public static final n1 readOrSkipLocalHeader$lambda$0(BufferedSource bufferedSource, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, int i6, long j6) {
        if (i6 == HEADER_ID_EXTENDED_TIMESTAMP) {
            if (j6 < 1) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            byte readByte = bufferedSource.readByte();
            boolean z5 = (readByte & 1) == 1;
            boolean z6 = (readByte & 2) == 2;
            boolean z7 = (readByte & 4) == 4;
            long j7 = z5 ? 5L : 1L;
            if (z6) {
                j7 += 4;
            }
            if (z7) {
                j7 += 4;
            }
            if (j6 < j7) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            if (z5) {
                objectRef.element = Integer.valueOf(bufferedSource.readIntLe());
            }
            if (z6) {
                objectRef2.element = Integer.valueOf(bufferedSource.readIntLe());
            }
            if (z7) {
                objectRef3.element = Integer.valueOf(bufferedSource.readIntLe());
            }
        }
        return n1.f44123a;
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12L);
        int readIntLe = bufferedSource.readIntLe();
        int readIntLe2 = bufferedSource.readIntLe();
        long readLongLe = bufferedSource.readLongLe();
        if (readLongLe != bufferedSource.readLongLe() || readIntLe != 0 || readIntLe2 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource.skip(8L);
        return new EocdRecord(readLongLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
    }

    public static final void skipLocalHeader(@NotNull BufferedSource bufferedSource) {
        g0.p(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, null);
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        int readShortLe = bufferedSource.readShortLe() & j1.f43986d;
        int readShortLe2 = bufferedSource.readShortLe() & j1.f43986d;
        long readShortLe3 = bufferedSource.readShortLe() & j1.f43986d;
        if (readShortLe3 == (bufferedSource.readShortLe() & j1.f43986d) && readShortLe == 0 && readShortLe2 == 0) {
            bufferedSource.skip(4L);
            return new EocdRecord(readShortLe3, 4294967295L & bufferedSource.readIntLe(), bufferedSource.readShortLe() & j1.f43986d);
        }
        throw new IOException("unsupported zip: spanned");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final ZipEntry readOrSkipLocalHeader(final BufferedSource bufferedSource, ZipEntry zipEntry) {
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == LOCAL_FILE_HEADER_SIGNATURE) {
            bufferedSource.skip(2L);
            short readShortLe = bufferedSource.readShortLe();
            int i6 = readShortLe & j1.f43986d;
            if ((readShortLe & 1) == 0) {
                bufferedSource.skip(18L);
                long readShortLe2 = bufferedSource.readShortLe() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                int readShortLe3 = bufferedSource.readShortLe() & j1.f43986d;
                bufferedSource.skip(readShortLe2);
                if (zipEntry == null) {
                    bufferedSource.skip(readShortLe3);
                    return null;
                }
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                readExtra(bufferedSource, readShortLe3, new Function2() { // from class: okio.internal.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        n1 readOrSkipLocalHeader$lambda$0;
                        readOrSkipLocalHeader$lambda$0 = ZipFilesKt.readOrSkipLocalHeader$lambda$0(BufferedSource.this, objectRef, objectRef2, objectRef3, ((Integer) obj).intValue(), ((Long) obj2).longValue());
                        return readOrSkipLocalHeader$lambda$0;
                    }
                });
                return zipEntry.copy$okio((Integer) objectRef.element, (Integer) objectRef2.element, (Integer) objectRef3.element);
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(i6));
        }
        throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }
}
