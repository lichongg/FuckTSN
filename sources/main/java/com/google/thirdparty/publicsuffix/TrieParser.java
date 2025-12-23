package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
final class TrieParser {
    private static final Joiner PREFIX_JOINER = Joiner.on("");

    private static CharSequence reverse(CharSequence charSequence) {
        return new StringBuilder(charSequence).reverse();
    }

    TrieParser() {
    }

    private static int doParseTrieToBuilder(List<CharSequence> list, CharSequence charSequence, int i6, ImmutableMap.Builder<String, PublicSuffixType> builder) {
        int length = charSequence.length();
        int i7 = i6;
        char c6 = 0;
        while (i7 < length && (c6 = charSequence.charAt(i7)) != '&' && c6 != '?' && c6 != '!' && c6 != ':' && c6 != ',') {
            i7++;
        }
        list.add(0, reverse(charSequence.subSequence(i6, i7)));
        if (c6 == '!' || c6 == '?' || c6 == ':' || c6 == ',') {
            String join = PREFIX_JOINER.join(list);
            if (join.length() > 0) {
                builder.put(join, PublicSuffixType.fromCode(c6));
            }
        }
        int i8 = i7 + 1;
        if (c6 != '?' && c6 != ',') {
            while (i8 < length) {
                i8 += doParseTrieToBuilder(list, charSequence, i8, builder);
                if (charSequence.charAt(i8) == '?' || charSequence.charAt(i8) == ',') {
                    i8++;
                    break;
                }
            }
        }
        list.remove(0);
        return i8 - i6;
    }

    static ImmutableMap<String, PublicSuffixType> parseTrie(CharSequence charSequence) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int length = charSequence.length();
        int i6 = 0;
        while (i6 < length) {
            i6 += doParseTrieToBuilder(Lists.newLinkedList(), charSequence, i6, builder);
        }
        return builder.build();
    }
}
