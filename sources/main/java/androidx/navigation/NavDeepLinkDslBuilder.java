package androidx.navigation;

import androidx.navigation.NavDeepLink;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@NavDeepLinkDsl
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavDeepLinkDslBuilder {

    @Nullable
    private String action;
    private final NavDeepLink.Builder builder = new NavDeepLink.Builder();

    @Nullable
    private String mimeType;

    @Nullable
    private String uriPattern;

    @NotNull
    public final NavDeepLink build$navigation_common_ktx_release() {
        NavDeepLink.Builder builder = this.builder;
        String str = this.uriPattern;
        if (!((str == null && this.action == null && this.mimeType == null) ? false : true)) {
            throw new IllegalStateException("The NavDeepLink must have an uri, action, and/or mimeType.");
        }
        if (str != null) {
            builder.setUriPattern(str);
        }
        String str2 = this.action;
        if (str2 != null) {
            builder.setAction(str2);
        }
        String str3 = this.mimeType;
        if (str3 != null) {
            builder.setMimeType(str3);
        }
        NavDeepLink build = builder.build();
        g0.h(build, "builder.apply {\n        …eType(it) }\n    }.build()");
        return build;
    }

    @Nullable
    public final String getAction() {
        return this.action;
    }

    @Nullable
    public final String getMimeType() {
        return this.mimeType;
    }

    @Nullable
    public final String getUriPattern() {
        return this.uriPattern;
    }

    public final void setAction(@Nullable String str) {
        if (str != null && str.length() == 0) {
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
        }
        this.action = str;
    }

    public final void setMimeType(@Nullable String str) {
        this.mimeType = str;
    }

    public final void setUriPattern(@Nullable String str) {
        this.uriPattern = str;
    }
}
