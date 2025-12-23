package com.bytedance.sdk.component.j;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public enum v {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    @Override // java.lang.Enum
    public String toString() {
        return this == PRIVATE ? "private" : this == PROTECTED ? "protected" : "public";
    }

    static v j(String str) {
        if (TextUtils.isEmpty(str)) {
            return PUBLIC;
        }
        String lowerCase = str.toLowerCase();
        if (TextUtils.equals("protected", lowerCase)) {
            return PROTECTED;
        }
        if (TextUtils.equals("private", lowerCase)) {
            return PRIVATE;
        }
        return PUBLIC;
    }
}
