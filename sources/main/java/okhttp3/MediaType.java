package okhttp3;

import com.acse.ottn.l3;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.Regex;
import kotlin.text.m;
import kotlin.text.p;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class MediaType {

    @NotNull
    private static final String QUOTED = "\"([^\"]*)\"";

    @NotNull
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";

    @NotNull
    private final String mediaType;

    @NotNull
    private final String[] parameterNamesAndValues;

    @NotNull
    private final String subtype;

    @NotNull
    private final String type;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Regex TYPE_SUBTYPE = new Regex("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    @NotNull
    private static final Regex PARAMETER = new Regex(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nMediaType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaType.kt\nokhttp3/MediaType$Companion\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,183:1\n37#2,2:184\n*S KotlinDebug\n*F\n+ 1 MediaType.kt\nokhttp3/MediaType$Companion\n*L\n145#1:184,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "mediaType.toMediaType()", imports = {"okhttp3.MediaType.Companion.toMediaType"}))
        @JvmName(name = "-deprecated_get")
        @NotNull
        /* renamed from: -deprecated_get, reason: not valid java name */
        public final MediaType m224deprecated_get(@NotNull String mediaType) {
            g0.p(mediaType, "mediaType");
            return get(mediaType);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "mediaType.toMediaTypeOrNull()", imports = {"okhttp3.MediaType.Companion.toMediaTypeOrNull"}))
        @JvmName(name = "-deprecated_parse")
        @Nullable
        /* renamed from: -deprecated_parse, reason: not valid java name */
        public final MediaType m225deprecated_parse(@NotNull String mediaType) {
            g0.p(mediaType, "mediaType");
            return parse(mediaType);
        }

        @JvmStatic
        @JvmName(name = l3.f4736f)
        @NotNull
        public final MediaType get(@NotNull String str) {
            g0.p(str, "<this>");
            p matchAt = MediaType.TYPE_SUBTYPE.matchAt(str, 0);
            if (matchAt == null) {
                throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
            }
            String str2 = matchAt.c().get(1);
            Locale locale = Locale.ROOT;
            String lowerCase = str2.toLowerCase(locale);
            g0.o(lowerCase, "toLowerCase(...)");
            String lowerCase2 = matchAt.c().get(2).toLowerCase(locale);
            g0.o(lowerCase2, "toLowerCase(...)");
            ArrayList arrayList = new ArrayList();
            int f6 = matchAt.d().f();
            while (true) {
                int i6 = f6 + 1;
                if (i6 >= str.length()) {
                    return new MediaType(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]));
                }
                p matchAt2 = MediaType.PARAMETER.matchAt(str, i6);
                if (matchAt2 == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Parameter is not formatted correctly: \"");
                    String substring = str.substring(i6);
                    g0.o(substring, "substring(...)");
                    sb.append(substring);
                    sb.append("\" for: \"");
                    sb.append(str);
                    sb.append('\"');
                    throw new IllegalArgumentException(sb.toString().toString());
                }
                m mVar = matchAt2.b().get(1);
                String f7 = mVar != null ? mVar.f() : null;
                if (f7 == null) {
                    f6 = matchAt2.d().f();
                } else {
                    m mVar2 = matchAt2.b().get(2);
                    String f8 = mVar2 != null ? mVar2.f() : null;
                    if (f8 == null) {
                        m mVar3 = matchAt2.b().get(3);
                        g0.m(mVar3);
                        f8 = mVar3.f();
                    } else if (u.y5(f8, '\'', false, 2, null) && u.q3(f8, '\'', false, 2, null) && f8.length() > 2) {
                        f8 = f8.substring(1, f8.length() - 1);
                        g0.o(f8, "substring(...)");
                    }
                    arrayList.add(f7);
                    arrayList.add(f8);
                    f6 = matchAt2.d().f();
                }
            }
        }

        @JvmStatic
        @JvmName(name = "parse")
        @Nullable
        public final MediaType parse(@NotNull String str) {
            g0.p(str, "<this>");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    @JvmOverloads
    @Nullable
    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    public MediaType(@NotNull String mediaType, @NotNull String type, @NotNull String subtype, @NotNull String[] parameterNamesAndValues) {
        g0.p(mediaType, "mediaType");
        g0.p(type, "type");
        g0.p(subtype, "subtype");
        g0.p(parameterNamesAndValues, "parameterNamesAndValues");
        this.mediaType = mediaType;
        this.type = type;
        this.subtype = subtype;
        this.parameterNamesAndValues = parameterNamesAndValues;
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType, Charset charset, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = null;
        }
        return mediaType.charset(charset);
    }

    @JvmStatic
    @JvmName(name = l3.f4736f)
    @NotNull
    public static final MediaType get(@NotNull String str) {
        return Companion.get(str);
    }

    @JvmStatic
    @JvmName(name = "parse")
    @Nullable
    public static final MediaType parse(@NotNull String str) {
        return Companion.parse(str);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "subtype", imports = {}))
    @JvmName(name = "-deprecated_subtype")
    @NotNull
    /* renamed from: -deprecated_subtype, reason: not valid java name */
    public final String m222deprecated_subtype() {
        return this.subtype;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "type", imports = {}))
    @JvmName(name = "-deprecated_type")
    @NotNull
    /* renamed from: -deprecated_type, reason: not valid java name */
    public final String m223deprecated_type() {
        return this.type;
    }

    @JvmOverloads
    @Nullable
    public final Charset charset(@Nullable Charset charset) {
        String parameter = parameter("charset");
        if (parameter == null) {
            return charset;
        }
        try {
            return Charset.forName(parameter);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof MediaType) && g0.g(((MediaType) obj).mediaType, this.mediaType);
    }

    @NotNull
    public final String getMediaType$okhttp() {
        return this.mediaType;
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    @Nullable
    public final String parameter(@NotNull String name) {
        g0.p(name, "name");
        int i6 = 0;
        int c6 = kotlin.internal.c.c(0, this.parameterNamesAndValues.length - 1, 2);
        if (c6 < 0) {
            return null;
        }
        while (!u.a2(this.parameterNamesAndValues[i6], name, true)) {
            if (i6 == c6) {
                return null;
            }
            i6 += 2;
        }
        return this.parameterNamesAndValues[i6 + 1];
    }

    @JvmName(name = "subtype")
    @NotNull
    public final String subtype() {
        return this.subtype;
    }

    @NotNull
    public String toString() {
        return this.mediaType;
    }

    @JvmName(name = "type")
    @NotNull
    public final String type() {
        return this.type;
    }
}
