package okhttp3.internal.idn;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nIdnaMappingTable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IdnaMappingTable.kt\nokhttp3/internal/idn/IdnaMappingTable\n+ 2 IdnaMappingTable.kt\nokhttp3/internal/idn/IdnaMappingTableKt\n*L\n1#1,286:1\n272#2,13:287\n272#2,13:300\n*S KotlinDebug\n*F\n+ 1 IdnaMappingTable.kt\nokhttp3/internal/idn/IdnaMappingTable\n*L\n209#1:287,13\n237#1:300,13\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class IdnaMappingTable {

    @NotNull
    private final String mappings;

    @NotNull
    private final String ranges;

    @NotNull
    private final String sections;

    public IdnaMappingTable(@NotNull String sections, @NotNull String ranges, @NotNull String mappings) {
        g0.p(sections, "sections");
        g0.p(ranges, "ranges");
        g0.p(mappings, "mappings");
        this.sections = sections;
        this.ranges = ranges;
        this.mappings = mappings;
    }

    private final int findRangesOffset(int i6, int i7, int i8) {
        int i9;
        int i10 = i6 & 127;
        int i11 = i8 - 1;
        while (true) {
            if (i7 > i11) {
                i9 = (-i7) - 1;
                break;
            }
            i9 = (i7 + i11) / 2;
            int t5 = g0.t(i10, this.ranges.charAt(i9 * 4));
            if (t5 >= 0) {
                if (t5 <= 0) {
                    break;
                }
                i7 = i9 + 1;
            } else {
                i11 = i9 - 1;
            }
        }
        return i9 >= 0 ? i9 * 4 : ((-i9) - 2) * 4;
    }

    @NotNull
    public final String getMappings() {
        return this.mappings;
    }

    @NotNull
    public final String getRanges() {
        return this.ranges;
    }

    @NotNull
    public final String getSections() {
        return this.sections;
    }

    public final boolean map(int i6, @NotNull BufferedSink sink) {
        g0.p(sink, "sink");
        int findSectionsIndex = findSectionsIndex(i6);
        int findRangesOffset = findRangesOffset(i6, IdnaMappingTableKt.read14BitInt(this.sections, findSectionsIndex + 2), findSectionsIndex + 4 < this.sections.length() ? IdnaMappingTableKt.read14BitInt(this.sections, findSectionsIndex + 6) : this.ranges.length() / 4);
        char charAt = this.ranges.charAt(findRangesOffset + 1);
        if (charAt >= 0 && charAt < '@') {
            int read14BitInt = IdnaMappingTableKt.read14BitInt(this.ranges, findRangesOffset + 2);
            sink.writeUtf8(this.mappings, read14BitInt, charAt + read14BitInt);
            return true;
        }
        if ('@' <= charAt && charAt < 'P') {
            sink.writeUtf8CodePoint(i6 - (this.ranges.charAt(findRangesOffset + 3) | (((charAt & 15) << 14) | (this.ranges.charAt(findRangesOffset + 2) << 7))));
            return true;
        }
        if ('P' <= charAt && charAt < '`') {
            sink.writeUtf8CodePoint(i6 + (this.ranges.charAt(findRangesOffset + 3) | ((charAt & 15) << 14) | (this.ranges.charAt(findRangesOffset + 2) << 7)));
            return true;
        }
        if (charAt == 'w') {
            n1 n1Var = n1.f44123a;
            return true;
        }
        if (charAt == 'x') {
            sink.writeUtf8CodePoint(i6);
            return true;
        }
        if (charAt == 'y') {
            sink.writeUtf8CodePoint(i6);
            return false;
        }
        if (charAt == 'z') {
            sink.writeByte(this.ranges.charAt(findRangesOffset + 2));
            return true;
        }
        if (charAt == '{') {
            sink.writeByte(this.ranges.charAt(findRangesOffset + 2) | 128);
            return true;
        }
        if (charAt == '|') {
            sink.writeByte(this.ranges.charAt(findRangesOffset + 2));
            sink.writeByte(this.ranges.charAt(findRangesOffset + 3));
            return true;
        }
        if (charAt == '}') {
            sink.writeByte(this.ranges.charAt(findRangesOffset + 2) | 128);
            sink.writeByte(this.ranges.charAt(findRangesOffset + 3));
            return true;
        }
        if (charAt == '~') {
            sink.writeByte(this.ranges.charAt(findRangesOffset + 2));
            sink.writeByte(this.ranges.charAt(findRangesOffset + 3) | 128);
            return true;
        }
        if (charAt == 127) {
            sink.writeByte(this.ranges.charAt(findRangesOffset + 2) | 128);
            sink.writeByte(this.ranges.charAt(findRangesOffset + 3) | 128);
            return true;
        }
        throw new IllegalStateException(("unexpected rangesIndex for " + i6).toString());
    }

    private final int findSectionsIndex(int i6) {
        int i7;
        int i8 = (i6 & 2097024) >> 7;
        int length = (this.sections.length() / 4) - 1;
        int i9 = 0;
        while (true) {
            if (i9 <= length) {
                i7 = (i9 + length) / 2;
                int t5 = g0.t(i8, IdnaMappingTableKt.read14BitInt(this.sections, i7 * 4));
                if (t5 < 0) {
                    length = i7 - 1;
                } else {
                    if (t5 <= 0) {
                        break;
                    }
                    i9 = i7 + 1;
                }
            } else {
                i7 = (-i9) - 1;
                break;
            }
        }
        if (i7 >= 0) {
            return i7 * 4;
        }
        return ((-i7) - 2) * 4;
    }
}
