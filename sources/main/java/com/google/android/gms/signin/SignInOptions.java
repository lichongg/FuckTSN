package com.google.android.gms.signin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class SignInOptions implements Api.ApiOptions.Optional {

    @NonNull
    public static final SignInOptions zaa = new SignInOptions(false, false, null, false, null, null, false, null, null, null);
    private final boolean zab = false;
    private final boolean zac = false;

    @Nullable
    private final String zad = null;
    private final boolean zae = false;
    private final boolean zah = false;

    @Nullable
    private final String zaf = null;

    @Nullable
    private final String zag = null;

    @Nullable
    private final Long zai = null;

    @Nullable
    private final Long zaj = null;

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof SignInOptions) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null);
    }

    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Objects.hashCode(bool, bool, null, bool, bool, null, null, null, null);
    }

    /* synthetic */ SignInOptions(boolean z5, boolean z6, String str, boolean z7, String str2, String str3, boolean z8, Long l6, Long l7, zaf zafVar) {
    }
}
