package okhttp3.internal.publicsuffix;

import java.net.IDN;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.sequences.p;
import kotlin.text.e;
import kotlin.text.u;
import okhttp3.internal._UtilCommonKt;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class PublicSuffixDatabase {
    private static final char EXCEPTION_MARKER = '!';

    @NotNull
    private final PublicSuffixList publicSuffixList;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final ByteString WILDCARD_LABEL = ByteString.Companion.of(42);

    @NotNull
    private static final List<String> PREVAILING_RULE = f0.l("*");

    @NotNull
    private static PublicSuffixDatabase instance = new PublicSuffixDatabase(PublicSuffixList_androidKt.getDefault(PublicSuffixList.Companion));

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String binarySearch(ByteString byteString, ByteString[] byteStringArr, int i6) {
            int i7;
            int and;
            boolean z5;
            int and2;
            int size = byteString.size();
            int i8 = 0;
            while (i8 < size) {
                int i9 = (i8 + size) / 2;
                while (i9 > -1 && byteString.getByte(i9) != 10) {
                    i9--;
                }
                int i10 = i9 + 1;
                int i11 = 1;
                while (true) {
                    i7 = i10 + i11;
                    if (byteString.getByte(i7) == 10) {
                        break;
                    }
                    i11++;
                }
                int i12 = i7 - i10;
                int i13 = i6;
                boolean z6 = false;
                int i14 = 0;
                int i15 = 0;
                while (true) {
                    if (z6) {
                        and = 46;
                        z5 = false;
                    } else {
                        boolean z7 = z6;
                        and = _UtilCommonKt.and(byteStringArr[i13].getByte(i14), 255);
                        z5 = z7;
                    }
                    and2 = and - _UtilCommonKt.and(byteString.getByte(i10 + i15), 255);
                    if (and2 != 0) {
                        break;
                    }
                    i15++;
                    i14++;
                    if (i15 == i12) {
                        break;
                    }
                    if (byteStringArr[i13].size() != i14) {
                        z6 = z5;
                    } else {
                        if (i13 == byteStringArr.length - 1) {
                            break;
                        }
                        i13++;
                        z6 = true;
                        i14 = -1;
                    }
                }
                if (and2 >= 0) {
                    if (and2 <= 0) {
                        int i16 = i12 - i15;
                        int size2 = byteStringArr[i13].size() - i14;
                        int length = byteStringArr.length;
                        for (int i17 = i13 + 1; i17 < length; i17++) {
                            size2 += byteStringArr[i17].size();
                        }
                        if (size2 >= i16) {
                            if (size2 <= i16) {
                                return byteString.substring(i10, i12 + i10).string(e.f47851b);
                            }
                        }
                    }
                    i8 = i7 + 1;
                }
                size = i9;
            }
            return null;
        }

        public final void resetForTests$okhttp() {
            PublicSuffixDatabase.instance = new PublicSuffixDatabase(PublicSuffixList_androidKt.getDefault(PublicSuffixList.Companion));
        }

        @NotNull
        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }
    }

    private final List<String> splitDomain(String str) {
        List<String> l52 = u.l5(str, new char[]{'.'}, false, 0, 6, null);
        return g0.g(f0.u3(l52), "") ? f0.h2(l52, 1) : l52;
    }

    public PublicSuffixDatabase(@NotNull PublicSuffixList publicSuffixList) {
        g0.p(publicSuffixList, "publicSuffixList");
        this.publicSuffixList = publicSuffixList;
    }

    private final List<String> findMatchingRule(List<String> list) {
        String str;
        String str2;
        String str3;
        List<String> J;
        List<String> J2;
        this.publicSuffixList.ensureLoaded();
        int size = list.size();
        ByteString[] byteStringArr = new ByteString[size];
        for (int i6 = 0; i6 < size; i6++) {
            byteStringArr[i6] = ByteString.Companion.encodeUtf8(list.get(i6));
        }
        int i7 = 0;
        while (true) {
            str = null;
            if (i7 >= size) {
                str2 = null;
                break;
            }
            str2 = Companion.binarySearch(this.publicSuffixList.getBytes(), byteStringArr, i7);
            if (str2 != null) {
                break;
            }
            i7++;
        }
        if (size > 1) {
            ByteString[] byteStringArr2 = (ByteString[]) byteStringArr.clone();
            int length = byteStringArr2.length - 1;
            for (int i8 = 0; i8 < length; i8++) {
                byteStringArr2[i8] = WILDCARD_LABEL;
                String binarySearch = Companion.binarySearch(this.publicSuffixList.getBytes(), byteStringArr2, i8);
                if (binarySearch != null) {
                    str3 = binarySearch;
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            int i9 = size - 1;
            int i10 = 0;
            while (true) {
                if (i10 >= i9) {
                    break;
                }
                String binarySearch2 = Companion.binarySearch(this.publicSuffixList.getExceptionBytes(), byteStringArr, i10);
                if (binarySearch2 != null) {
                    str = binarySearch2;
                    break;
                }
                i10++;
            }
        }
        if (str != null) {
            return u.l5(EXCEPTION_MARKER + str, new char[]{'.'}, false, 0, 6, null);
        }
        if (str2 == null && str3 == null) {
            return PREVAILING_RULE;
        }
        if (str2 == null || (J = u.l5(str2, new char[]{'.'}, false, 0, 6, null)) == null) {
            J = f0.J();
        }
        if (str3 == null || (J2 = u.l5(str3, new char[]{'.'}, false, 0, 6, null)) == null) {
            J2 = f0.J();
        }
        return J.size() > J2.size() ? J : J2;
    }

    @Nullable
    public final String getEffectiveTldPlusOne(@NotNull String domain) {
        int size;
        int size2;
        g0.p(domain, "domain");
        String unicode = IDN.toUnicode(domain);
        g0.m(unicode);
        List<String> splitDomain = splitDomain(unicode);
        List<String> findMatchingRule = findMatchingRule(splitDomain);
        if (splitDomain.size() == findMatchingRule.size() && findMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (findMatchingRule.get(0).charAt(0) == '!') {
            size = splitDomain.size();
            size2 = findMatchingRule.size();
        } else {
            size = splitDomain.size();
            size2 = findMatchingRule.size() + 1;
        }
        return p.H1(p.J0(f0.E1(splitDomain(domain)), size - size2), ".", null, null, 0, null, null, 62, null);
    }
}
