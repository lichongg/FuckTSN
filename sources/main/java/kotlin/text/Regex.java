package kotlin.text;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.ExperimentalStdlibApi;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/Regex\n+ 2 Regex.kt\nkotlin/text/RegexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,404:1\n24#2,3:405\n1#3:408\n*S KotlinDebug\n*F\n+ 1 Regex.kt\nkotlin/text/Regex\n*L\n105#1:405,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Regex implements Serializable {

    @NotNull
    public static final a Companion = new a(null);

    @Nullable
    private Set<? extends RegexOption> _options;

    @NotNull
    private final Pattern nativePattern;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b(int i6) {
            return (i6 & 2) != 0 ? i6 | 64 : i6;
        }

        @NotNull
        public final String c(@NotNull String literal) {
            kotlin.jvm.internal.g0.p(literal, "literal");
            String quote = Pattern.quote(literal);
            kotlin.jvm.internal.g0.o(quote, "quote(...)");
            return quote;
        }

        @NotNull
        public final String d(@NotNull String literal) {
            kotlin.jvm.internal.g0.p(literal, "literal");
            String quoteReplacement = Matcher.quoteReplacement(literal);
            kotlin.jvm.internal.g0.o(quoteReplacement, "quoteReplacement(...)");
            return quoteReplacement;
        }

        @NotNull
        public final Regex e(@NotNull String literal) {
            kotlin.jvm.internal.g0.p(literal, "literal");
            return new Regex(literal, RegexOption.LITERAL);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b implements Serializable {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final a f47837c = new a(null);
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f47838a;

        /* renamed from: b, reason: collision with root package name */
        private final int f47839b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class a {
            public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
                this();
            }

            private a() {
            }
        }

        public b(@NotNull String pattern, int i6) {
            kotlin.jvm.internal.g0.p(pattern, "pattern");
            this.f47838a = pattern;
            this.f47839b = i6;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.f47838a, this.f47839b);
            kotlin.jvm.internal.g0.o(compile, "compile(...)");
            return new Regex(compile);
        }

        public final int a() {
            return this.f47839b;
        }

        @NotNull
        public final String b() {
            return this.f47838a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<p, p> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f47840a = new c();

        c() {
            super(1, p.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final p invoke(p p02) {
            kotlin.jvm.internal.g0.p(p02, "p0");
            return p02.next();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt$fromInt$1$1\n*L\n1#1,404:1\n*E\n"})
    public static final class d implements Function1<RegexOption, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f47841a;

        public d(int i6) {
            this.f47841a = i6;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(RegexOption regexOption) {
            RegexOption regexOption2 = regexOption;
            return Boolean.valueOf((this.f47841a & regexOption2.getMask()) == regexOption2.getValue());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, MediaPlayer.MEDIA_PLAYER_OPTION_UPDATE_TIMESTAMP_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "$this$sequence", "matcher", "nextStart", "splitCount", "$this$sequence", "matcher", "nextStart", "splitCount"}, nl = {281, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"}, v = 2)
    static final class e extends RestrictedSuspendLambda implements Function2<kotlin.sequences.o<? super String>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f47842a;

        /* renamed from: b, reason: collision with root package name */
        int f47843b;

        /* renamed from: c, reason: collision with root package name */
        int f47844c;

        /* renamed from: d, reason: collision with root package name */
        int f47845d;

        /* renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f47846e;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ CharSequence f47848g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f47849h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(CharSequence charSequence, int i6, kotlin.coroutines.e<? super e> eVar) {
            super(2, eVar);
            this.f47848g = charSequence;
            this.f47849h = i6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            e eVar2 = Regex.this.new e(this.f47848g, this.f47849h, eVar);
            eVar2.f47846e = obj;
            return eVar2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlin.sequences.o<? super String> oVar, kotlin.coroutines.e<? super n1> eVar) {
            return ((e) create(oVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00af, code lost:
        
            if (r0.c(r4, r10) != r1) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00cd, code lost:
        
            if (r0.c(r2, r10) == r1) goto L35;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0075  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0075 -> B:13:0x0076). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = r10.f47846e
                kotlin.sequences.o r0 = (kotlin.sequences.o) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r10.f47845d
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L39
                if (r2 == r5) goto L30
                if (r2 == r4) goto L26
                if (r2 != r3) goto L1e
                java.lang.Object r0 = r10.f47842a
                java.util.regex.Matcher r0 = (java.util.regex.Matcher) r0
                kotlin.g0.n(r11)
                goto Lb2
            L1e:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L26:
                int r2 = r10.f47844c
                java.lang.Object r6 = r10.f47842a
                java.util.regex.Matcher r6 = (java.util.regex.Matcher) r6
                kotlin.g0.n(r11)
                goto L76
            L30:
                java.lang.Object r0 = r10.f47842a
                java.util.regex.Matcher r0 = (java.util.regex.Matcher) r0
                kotlin.g0.n(r11)
                goto Ld0
            L39:
                kotlin.g0.n(r11)
                kotlin.text.Regex r11 = kotlin.text.Regex.this
                java.util.regex.Pattern r11 = kotlin.text.Regex.access$getNativePattern$p(r11)
                java.lang.CharSequence r2 = r10.f47848g
                java.util.regex.Matcher r11 = r11.matcher(r2)
                int r2 = r10.f47849h
                if (r2 == r5) goto Lb5
                boolean r2 = r11.find()
                if (r2 != 0) goto L53
                goto Lb5
            L53:
                r2 = 0
                r6 = r11
                r11 = 0
            L56:
                java.lang.CharSequence r7 = r10.f47848g
                int r8 = r6.start()
                java.lang.CharSequence r7 = r7.subSequence(r2, r8)
                java.lang.String r7 = r7.toString()
                r10.f47846e = r0
                r10.f47842a = r6
                r10.f47843b = r2
                r10.f47844c = r11
                r10.f47845d = r4
                java.lang.Object r2 = r0.c(r7, r10)
                if (r2 != r1) goto L75
                goto Lcf
            L75:
                r2 = r11
            L76:
                int r11 = r6.end()
                int r2 = r2 + r5
                int r7 = r10.f47849h
                int r7 = r7 - r5
                if (r2 == r7) goto L8b
                boolean r7 = r6.find()
                if (r7 != 0) goto L87
                goto L8b
            L87:
                r9 = r2
                r2 = r11
                r11 = r9
                goto L56
            L8b:
                java.lang.CharSequence r4 = r10.f47848g
                int r5 = r4.length()
                java.lang.CharSequence r4 = r4.subSequence(r11, r5)
                java.lang.String r4 = r4.toString()
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.j.a(r0)
                r10.f47846e = r5
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.j.a(r6)
                r10.f47842a = r5
                r10.f47843b = r11
                r10.f47844c = r2
                r10.f47845d = r3
                java.lang.Object r11 = r0.c(r4, r10)
                if (r11 != r1) goto Lb2
                goto Lcf
            Lb2:
                kotlin.n1 r11 = kotlin.n1.f44123a
                return r11
            Lb5:
                java.lang.CharSequence r2 = r10.f47848g
                java.lang.String r2 = r2.toString()
                java.lang.Object r3 = kotlin.coroutines.jvm.internal.j.a(r0)
                r10.f47846e = r3
                java.lang.Object r11 = kotlin.coroutines.jvm.internal.j.a(r11)
                r10.f47842a = r11
                r10.f47845d = r5
                java.lang.Object r11 = r0.c(r2, r10)
                if (r11 != r1) goto Ld0
            Lcf:
                return r1
            Ld0:
                kotlin.n1 r11 = kotlin.n1.f44123a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @PublishedApi
    public Regex(@NotNull Pattern nativePattern) {
        kotlin.jvm.internal.g0.p(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    @NotNull
    public final String replace(@NotNull CharSequence input, @NotNull String replacement) {
        kotlin.jvm.internal.g0.p(input, "input");
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        String replaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        kotlin.jvm.internal.g0.o(replaceAll, "replaceAll(...)");
        return replaceAll;
    }

    public static /* synthetic */ p find$default(Regex regex, CharSequence charSequence, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return regex.find(charSequence, i6);
    }

    public static /* synthetic */ kotlin.sequences.m findAll$default(Regex regex, CharSequence charSequence, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return regex.findAll(charSequence, i6);
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return regex.split(charSequence, i6);
    }

    public static /* synthetic */ kotlin.sequences.m splitToSequence$default(Regex regex, CharSequence charSequence, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return regex.splitToSequence(charSequence, i6);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        kotlin.jvm.internal.g0.o(pattern, "pattern(...)");
        return new b(pattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(@NotNull CharSequence input) {
        kotlin.jvm.internal.g0.p(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    @Nullable
    public final p find(@NotNull CharSequence input, int i6) {
        p f6;
        kotlin.jvm.internal.g0.p(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        kotlin.jvm.internal.g0.o(matcher, "matcher(...)");
        f6 = t.f(matcher, i6, input);
        return f6;
    }

    @NotNull
    public final kotlin.sequences.m<p> findAll(@NotNull final CharSequence input, final int i6) {
        kotlin.jvm.internal.g0.p(input, "input");
        if (i6 >= 0 && i6 <= input.length()) {
            return kotlin.sequences.p.v(new Function0() { // from class: kotlin.text.s
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    p find;
                    find = Regex.this.find(input, i6);
                    return find;
                }
            }, c.f47840a);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i6 + ", input length: " + input.length());
    }

    @NotNull
    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        int flags = this.nativePattern.flags();
        EnumSet allOf = EnumSet.allOf(RegexOption.class);
        kotlin.jvm.internal.g0.m(allOf);
        kotlin.collections.f0.S0(allOf, new d(flags));
        Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
        kotlin.jvm.internal.g0.o(unmodifiableSet, "unmodifiableSet(...)");
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    @NotNull
    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        kotlin.jvm.internal.g0.o(pattern, "pattern(...)");
        return pattern;
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public final p matchAt(@NotNull CharSequence input, int i6) {
        kotlin.jvm.internal.g0.p(input, "input");
        Matcher region = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i6, input.length());
        if (!region.lookingAt()) {
            return null;
        }
        kotlin.jvm.internal.g0.m(region);
        return new q(region, input);
    }

    @Nullable
    public final p matchEntire(@NotNull CharSequence input) {
        p h6;
        kotlin.jvm.internal.g0.p(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        kotlin.jvm.internal.g0.o(matcher, "matcher(...)");
        h6 = t.h(matcher, input);
        return h6;
    }

    public final boolean matches(@NotNull CharSequence input) {
        kotlin.jvm.internal.g0.p(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public final boolean matchesAt(@NotNull CharSequence input, int i6) {
        kotlin.jvm.internal.g0.p(input, "input");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i6, input.length()).lookingAt();
    }

    @NotNull
    public final String replace(@NotNull CharSequence input, @NotNull Function1<? super p, ? extends CharSequence> transform) {
        kotlin.jvm.internal.g0.p(input, "input");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int i6 = 0;
        p find$default = find$default(this, input, 0, 2, null);
        if (find$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(input, i6, find$default.d().getStart().intValue());
            sb.append(transform.invoke(find$default));
            i6 = find$default.d().getEndInclusive().intValue() + 1;
            find$default = find$default.next();
            if (i6 >= length) {
                break;
            }
        } while (find$default != null);
        if (i6 < length) {
            sb.append(input, i6, length);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.g0.o(sb2, "toString(...)");
        return sb2;
    }

    @NotNull
    public final String replaceFirst(@NotNull CharSequence input, @NotNull String replacement) {
        kotlin.jvm.internal.g0.p(input, "input");
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        String replaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        kotlin.jvm.internal.g0.o(replaceFirst, "replaceFirst(...)");
        return replaceFirst;
    }

    @NotNull
    public final List<String> split(@NotNull CharSequence input, int i6) {
        kotlin.jvm.internal.g0.p(input, "input");
        l0.f5(i6);
        Matcher matcher = this.nativePattern.matcher(input);
        if (i6 == 1 || !matcher.find()) {
            return kotlin.collections.f0.l(input.toString());
        }
        ArrayList arrayList = new ArrayList(i6 > 0 ? kotlin.ranges.t.B(i6, 10) : 10);
        int i7 = i6 - 1;
        int i8 = 0;
        do {
            arrayList.add(input.subSequence(i8, matcher.start()).toString());
            i8 = matcher.end();
            if (i7 >= 0 && arrayList.size() == i7) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(i8, input.length()).toString());
        return arrayList;
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @NotNull
    public final kotlin.sequences.m<String> splitToSequence(@NotNull CharSequence input, int i6) {
        kotlin.jvm.internal.g0.p(input, "input");
        l0.f5(i6);
        return kotlin.sequences.p.b(new e(input, i6, null));
    }

    @NotNull
    public final Pattern toPattern() {
        return this.nativePattern;
    }

    @NotNull
    public String toString() {
        String pattern = this.nativePattern.toString();
        kotlin.jvm.internal.g0.o(pattern, "toString(...)");
        return pattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.g0.p(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(...)"
            kotlin.jvm.internal.g0.o(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull kotlin.text.RegexOption r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.g0.p(r2, r0)
            java.lang.String r0 = "option"
            kotlin.jvm.internal.g0.p(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = r3.getValue()
            int r3 = kotlin.text.Regex.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(...)"
            kotlin.jvm.internal.g0.o(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, kotlin.text.RegexOption):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull java.util.Set<? extends kotlin.text.RegexOption> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.g0.p(r2, r0)
            java.lang.String r0 = "options"
            kotlin.jvm.internal.g0.p(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = kotlin.text.t.e(r3)
            int r3 = kotlin.text.Regex.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(...)"
            kotlin.jvm.internal.g0.o(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, java.util.Set):void");
    }
}
