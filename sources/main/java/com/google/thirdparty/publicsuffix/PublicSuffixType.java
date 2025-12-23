package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public enum PublicSuffixType {
    PRIVATE(':', StringUtil.COMMA),
    REGISTRY('!', '?');

    private final char innerNodeCode;
    private final char leafNodeCode;

    static PublicSuffixType fromIsPrivate(boolean z5) {
        return z5 ? PRIVATE : REGISTRY;
    }

    char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    char getLeafNodeCode() {
        return this.leafNodeCode;
    }

    PublicSuffixType(char c6, char c7) {
        this.innerNodeCode = c6;
        this.leafNodeCode = c7;
    }

    static PublicSuffixType fromCode(char c6) {
        for (PublicSuffixType publicSuffixType : values()) {
            if (publicSuffixType.getInnerNodeCode() == c6 || publicSuffixType.getLeafNodeCode() == c6) {
                return publicSuffixType;
            }
        }
        throw new IllegalArgumentException("No enum corresponding to given code: " + c6);
    }
}
