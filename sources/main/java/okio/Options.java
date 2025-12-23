package okio;

import java.util.List;
import java.util.RandomAccess;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Options extends kotlin.collections.d<ByteString> implements RandomAccess {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final ByteString[] byteStrings;

    @NotNull
    private final int[] trie;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Options.kt\nokio/Options$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,238:1\n1#2:239\n13870#3,3:240\n73#4:243\n73#4:244\n*S KotlinDebug\n*F\n+ 1 Options.kt\nokio/Options$Companion\n*L\n48#1:240,3\n153#1:243\n210#1:244\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        private final void buildTrieRecursive(long j6, Buffer buffer, int i6, List<? extends ByteString> list, int i7, int i8, List<Integer> list2) {
            int i9;
            int i10;
            int i11;
            long j7;
            int i12 = i6;
            if (i7 >= i8) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            for (int i13 = i7; i13 < i8; i13++) {
                if (list.get(i13).size() < i12) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            ByteString byteString = list.get(i7);
            ByteString byteString2 = list.get(i8 - 1);
            if (i12 == byteString.size()) {
                int intValue = list2.get(i7).intValue();
                int i14 = i7 + 1;
                ByteString byteString3 = list.get(i14);
                i9 = i14;
                i10 = intValue;
                byteString = byteString3;
            } else {
                i9 = i7;
                i10 = -1;
            }
            if (byteString.getByte(i12) == byteString2.getByte(i12)) {
                int min = Math.min(byteString.size(), byteString2.size());
                int i15 = 0;
                for (int i16 = i12; i16 < min && byteString.getByte(i16) == byteString2.getByte(i16); i16++) {
                    i15++;
                }
                long intCount = j6 + getIntCount(buffer) + 2 + i15 + 1;
                buffer.writeInt(-i15);
                buffer.writeInt(i10);
                int i17 = i12 + i15;
                while (i12 < i17) {
                    buffer.writeInt(byteString.getByte(i12) & 255);
                    i12++;
                }
                if (i9 + 1 == i8) {
                    if (i17 != list.get(i9).size()) {
                        throw new IllegalStateException("Check failed.");
                    }
                    buffer.writeInt(list2.get(i9).intValue());
                    return;
                } else {
                    Buffer buffer2 = new Buffer();
                    buffer.writeInt(((int) (getIntCount(buffer2) + intCount)) * (-1));
                    buildTrieRecursive(intCount, buffer2, i17, list, i9, i8, list2);
                    buffer.writeAll(buffer2);
                    return;
                }
            }
            int i18 = 1;
            for (int i19 = i9 + 1; i19 < i8; i19++) {
                if (list.get(i19 - 1).getByte(i12) != list.get(i19).getByte(i12)) {
                    i18++;
                }
            }
            long intCount2 = j6 + getIntCount(buffer) + 2 + (i18 * 2);
            buffer.writeInt(i18);
            buffer.writeInt(i10);
            for (int i20 = i9; i20 < i8; i20++) {
                byte b6 = list.get(i20).getByte(i12);
                if (i20 == i9 || b6 != list.get(i20 - 1).getByte(i12)) {
                    buffer.writeInt(b6 & 255);
                }
            }
            Buffer buffer3 = new Buffer();
            while (i9 < i8) {
                byte b7 = list.get(i9).getByte(i12);
                int i21 = i9 + 1;
                int i22 = i21;
                while (true) {
                    if (i22 >= i8) {
                        i11 = i8;
                        break;
                    } else {
                        if (b7 != list.get(i22).getByte(i12)) {
                            i11 = i22;
                            break;
                        }
                        i22++;
                    }
                }
                if (i21 == i11 && i12 + 1 == list.get(i9).size()) {
                    buffer.writeInt(list2.get(i9).intValue());
                    j7 = intCount2;
                } else {
                    buffer.writeInt(((int) (getIntCount(buffer3) + intCount2)) * (-1));
                    j7 = intCount2;
                    buildTrieRecursive(j7, buffer3, i12 + 1, list, i9, i11, list2);
                }
                intCount2 = j7;
                i9 = i11;
            }
            buffer.writeAll(buffer3);
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j6, Buffer buffer, int i6, List list, int i7, int i8, List list2, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                j6 = 0;
            }
            companion.buildTrieRecursive(j6, buffer, (i9 & 4) != 0 ? 0 : i6, list, (i9 & 16) != 0 ? 0 : i7, (i9 & 32) != 0 ? list.size() : i8, list2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
        
            continue;
         */
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okio.Options of(@org.jetbrains.annotations.NotNull okio.ByteString... r17) {
            /*
                Method dump skipped, instructions count: 270
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Options.Companion.of(okio.ByteString[]):okio.Options");
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / 4;
        }
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, v vVar) {
        this(byteStringArr, iArr);
    }

    @Override // kotlin.collections.b, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    @Override // kotlin.collections.d, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.d, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    @JvmStatic
    @NotNull
    public static final Options of(@NotNull ByteString... byteStringArr) {
        return Companion.of(byteStringArr);
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Object) byteString);
    }

    @Override // kotlin.collections.d, java.util.List
    @NotNull
    public ByteString get(int i6) {
        return this.byteStrings[i6];
    }

    @NotNull
    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    @Override // kotlin.collections.d, kotlin.collections.b
    public int getSize() {
        return this.byteStrings.length;
    }

    @NotNull
    public final int[] getTrie$okio() {
        return this.trie;
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((Object) byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Object) byteString);
    }
}
