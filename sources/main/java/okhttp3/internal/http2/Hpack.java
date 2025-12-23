package okhttp3.internal.http2;

import com.baidu.mobads.sdk.internal.cl;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.collections.n;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okhttp3.internal._UtilCommonKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import xyz.adscope.common.network.Headers;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nHpack.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Hpack.kt\nokhttp3/internal/http2/Hpack\n+ 2 -UtilJvm.kt\nokhttp3/internal/_UtilJvmKt\n*L\n1#1,647:1\n250#2:648\n*S KotlinDebug\n*F\n+ 1 Hpack.kt\nokhttp3/internal/http2/Hpack\n*L\n398#1:648\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Hpack {

    @NotNull
    public static final Hpack INSTANCE;

    @NotNull
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;

    @NotNull
    private static final Header[] STATIC_HEADER_TABLE;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Reader {

        @JvmField
        @NotNull
        public Header[] dynamicTable;

        @JvmField
        public int dynamicTableByteCount;

        @JvmField
        public int headerCount;

        @NotNull
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;

        @NotNull
        private final BufferedSource source;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public Reader(@NotNull Source source, int i6) {
            this(source, i6, 0, 4, null);
            g0.p(source, "source");
        }

        private final int evictToRecoverBytes(int i6) {
            int i7;
            int i8 = 0;
            if (i6 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i7 = this.nextHeaderIndex;
                    if (length < i7 || i6 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    g0.m(header);
                    int i9 = header.hpackSize;
                    i6 -= i9;
                    this.dynamicTableByteCount -= i9;
                    this.headerCount--;
                    i8++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i7 + 1, headerArr, i7 + 1 + i8, this.headerCount);
                this.nextHeaderIndex += i8;
            }
            return i8;
        }

        public final int readInt(int i6, int i7) throws IOException {
            int i8 = i6 & i7;
            if (i8 < i7) {
                return i8;
            }
            int i9 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i7 + (readByte << i9);
                }
                i7 += (readByte & 127) << i9;
                i9 += 7;
            }
        }

        @JvmOverloads
        public Reader(@NotNull Source source, int i6, int i7) {
            g0.p(source, "source");
            this.headerTableSizeSetting = i6;
            this.maxDynamicTableByteCount = i7;
            this.headerList = new ArrayList();
            this.source = Okio.buffer(source);
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = r2.length - 1;
        }

        private final void adjustDynamicTableByteCount() {
            int i6 = this.maxDynamicTableByteCount;
            int i7 = this.dynamicTableByteCount;
            if (i6 < i7) {
                if (i6 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i7 - i6);
                }
            }
        }

        private final void clearDynamicTable() {
            n.V1(this.dynamicTable, null, 0, 0, 6, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int i6) {
            return this.nextHeaderIndex + 1 + i6;
        }

        private final void insertIntoDynamicTable(int i6, Header header) {
            this.headerList.add(header);
            int i7 = header.hpackSize;
            if (i6 != -1) {
                Header header2 = this.dynamicTable[dynamicTableIndex(i6)];
                g0.m(header2);
                i7 -= header2.hpackSize;
            }
            int i8 = this.maxDynamicTableByteCount;
            if (i7 > i8) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i7) - i8);
            if (i6 == -1) {
                int i9 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i9 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i10 = this.nextHeaderIndex;
                this.nextHeaderIndex = i10 - 1;
                this.dynamicTable[i10] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i6 + dynamicTableIndex(i6) + evictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i7;
        }

        private final boolean isStaticHeader(int i6) {
            return i6 >= 0 && i6 <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1;
        }

        private final int readByte() throws IOException {
            return _UtilCommonKt.and(this.source.readByte(), 255);
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        @NotNull
        public final List<Header> getAndResetHeaderList() {
            List<Header> a6 = f0.a6(this.headerList);
            this.headerList.clear();
            return a6;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public final void readHeaders() throws IOException {
            while (!this.source.exhausted()) {
                int and = _UtilCommonKt.and(this.source.readByte(), 255);
                if (and == 128) {
                    throw new IOException("index == 0");
                }
                if ((and & 128) == 128) {
                    readIndexedHeader(readInt(and, 127) - 1);
                } else if (and == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((and & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(and, 63) - 1);
                } else if ((and & 32) == 32) {
                    int readInt = readInt(and, 31);
                    this.maxDynamicTableByteCount = readInt;
                    if (readInt < 0 || readInt > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (and == 16 || and == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(and, 15) - 1);
                }
            }
        }

        private final ByteString getName(int i6) throws IOException {
            if (isStaticHeader(i6)) {
                return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i6].name;
            }
            int dynamicTableIndex = dynamicTableIndex(i6 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    Header header = headerArr[dynamicTableIndex];
                    g0.m(header);
                    return header.name;
                }
            }
            throw new IOException("Header index too large " + (i6 + 1));
        }

        private final void readIndexedHeader(int i6) throws IOException {
            if (isStaticHeader(i6)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i6]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i6 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    List<Header> list = this.headerList;
                    Header header = headerArr[dynamicTableIndex];
                    g0.m(header);
                    list.add(header);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i6 + 1));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int i6) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i6), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int i6) throws IOException {
            this.headerList.add(new Header(getName(i6), readByteString()));
        }

        @NotNull
        public final ByteString readByteString() throws IOException {
            boolean z5;
            int readByte = readByte();
            if ((readByte & 128) == 128) {
                z5 = true;
            } else {
                z5 = false;
            }
            long readInt = readInt(readByte, 127);
            if (z5) {
                Buffer buffer = new Buffer();
                Huffman.INSTANCE.decode(this.source, readInt, buffer);
                return buffer.readByteString();
            }
            return this.source.readByteString(readInt);
        }

        public /* synthetic */ Reader(Source source, int i6, int i7, int i8, v vVar) {
            this(source, i6, (i8 & 4) != 0 ? i6 : i7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Writer {

        @JvmField
        @NotNull
        public Header[] dynamicTable;

        @JvmField
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;

        @JvmField
        public int headerCount;

        @JvmField
        public int headerTableSizeSetting;

        @JvmField
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;

        @NotNull
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public Writer(int i6, @NotNull Buffer out) {
            this(i6, false, out, 2, null);
            g0.p(out, "out");
        }

        private final int evictToRecoverBytes(int i6) {
            int i7;
            int i8 = 0;
            if (i6 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i7 = this.nextHeaderIndex;
                    if (length < i7 || i6 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    g0.m(header);
                    i6 -= header.hpackSize;
                    int i9 = this.dynamicTableByteCount;
                    Header header2 = this.dynamicTable[length];
                    g0.m(header2);
                    this.dynamicTableByteCount = i9 - header2.hpackSize;
                    this.headerCount--;
                    i8++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i7 + 1, headerArr, i7 + 1 + i8, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i10 = this.nextHeaderIndex;
                Arrays.fill(headerArr2, i10 + 1, i10 + 1 + i8, (Object) null);
                this.nextHeaderIndex += i8;
            }
            return i8;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public Writer(@NotNull Buffer out) {
            this(0, false, out, 3, null);
            g0.p(out, "out");
        }

        private final void adjustDynamicTableByteCount() {
            int i6 = this.maxDynamicTableByteCount;
            int i7 = this.dynamicTableByteCount;
            if (i6 < i7) {
                if (i6 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i7 - i6);
                }
            }
        }

        private final void clearDynamicTable() {
            n.V1(this.dynamicTable, null, 0, 0, 6, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final void insertIntoDynamicTable(Header header) {
            int i6 = header.hpackSize;
            int i7 = this.maxDynamicTableByteCount;
            if (i6 > i7) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i6) - i7);
            int i8 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i8 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i9 = this.nextHeaderIndex;
            this.nextHeaderIndex = i9 - 1;
            this.dynamicTable[i9] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i6;
        }

        public final void resizeHeaderTable(int i6) {
            this.headerTableSizeSetting = i6;
            int min = Math.min(i6, 16384);
            int i7 = this.maxDynamicTableByteCount;
            if (i7 == min) {
                return;
            }
            if (min < i7) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = min;
            adjustDynamicTableByteCount();
        }

        public final void writeByteString(@NotNull ByteString data) throws IOException {
            g0.p(data, "data");
            if (this.useCompression) {
                Huffman huffman = Huffman.INSTANCE;
                if (huffman.encodedLength(data) < data.size()) {
                    Buffer buffer = new Buffer();
                    huffman.encode(data, buffer);
                    ByteString readByteString = buffer.readByteString();
                    writeInt(readByteString.size(), 127, 128);
                    this.out.write(readByteString);
                    return;
                }
            }
            writeInt(data.size(), 127, 0);
            this.out.write(data);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00c4  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00cc  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void writeHeaders(@org.jetbrains.annotations.NotNull java.util.List<okhttp3.internal.http2.Header> r13) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 264
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Hpack.Writer.writeHeaders(java.util.List):void");
        }

        public final void writeInt(int i6, int i7, int i8) {
            if (i6 < i7) {
                this.out.writeByte(i6 | i8);
                return;
            }
            this.out.writeByte(i8 | i7);
            int i9 = i6 - i7;
            while (i9 >= 128) {
                this.out.writeByte(128 | (i9 & 127));
                i9 >>>= 7;
            }
            this.out.writeByte(i9);
        }

        @JvmOverloads
        public Writer(int i6, boolean z5, @NotNull Buffer out) {
            g0.p(out, "out");
            this.headerTableSizeSetting = i6;
            this.useCompression = z5;
            this.out = out;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i6;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = r2.length - 1;
        }

        public /* synthetic */ Writer(int i6, boolean z5, Buffer buffer, int i7, v vVar) {
            this((i7 & 1) != 0 ? 4096 : i6, (i7 & 2) != 0 ? true : z5, buffer);
        }
    }

    static {
        Hpack hpack = new Hpack();
        INSTANCE = hpack;
        Header header = new Header(Header.TARGET_AUTHORITY, "");
        ByteString byteString = Header.TARGET_METHOD;
        Header header2 = new Header(byteString, "GET");
        Header header3 = new Header(byteString, "POST");
        ByteString byteString2 = Header.TARGET_PATH;
        Header header4 = new Header(byteString2, "/");
        Header header5 = new Header(byteString2, "/index.html");
        ByteString byteString3 = Header.TARGET_SCHEME;
        Header header6 = new Header(byteString3, master.flame.danmaku.danmaku.parser.b.f50154a);
        Header header7 = new Header(byteString3, master.flame.danmaku.danmaku.parser.b.f50155b);
        ByteString byteString4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{header, header2, header3, header4, header5, header6, header7, new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, cl.f10887b), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", Headers.VALUE_ACCEPT_ENCODING), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header(Constants.FROM, ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header(SocializeConstants.KEY_LOCATION, ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header(SocializeProtocolConstants.PROTOCOL_KEY_VERIFY_MEDIA, ""), new Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = hpack.nameToFirstIndex();
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        Header[] headerArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length, 1.0f);
        int length = headerArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            Header[] headerArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(headerArr2[i6].name)) {
                linkedHashMap.put(headerArr2[i6].name, Integer.valueOf(i6));
            }
        }
        Map<ByteString, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        g0.o(unmodifiableMap, "unmodifiableMap(...)");
        return unmodifiableMap;
    }

    @NotNull
    public final ByteString checkLowercase(@NotNull ByteString name) throws IOException {
        g0.p(name, "name");
        int size = name.size();
        for (int i6 = 0; i6 < size; i6++) {
            byte b6 = name.getByte(i6);
            if (65 <= b6 && b6 < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.utf8());
            }
        }
        return name;
    }

    @NotNull
    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    @NotNull
    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }

    private Hpack() {
    }
}
