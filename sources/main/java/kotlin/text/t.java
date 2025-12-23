package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,404:1\n1803#2,3:405\n*S KotlinDebug\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt\n*L\n21#1:405,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt$fromInt$1$1\n*L\n1#1,404:1\n*E\n"})
    public static final class a<T> implements Function1<T, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f47954a;

        public a(int i6) {
            this.f47954a = i6;
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)Ljava/lang/Boolean; */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Enum r32) {
            h hVar = (h) r32;
            return Boolean.valueOf((this.f47954a & hVar.getMask()) == hVar.getValue());
        }
    }

    private static final /* synthetic */ <T extends Enum<T> & h> Set<T> g(int i6) {
        kotlin.jvm.internal.g0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        EnumSet allOf = EnumSet.allOf(Enum.class);
        kotlin.jvm.internal.g0.m(allOf);
        kotlin.jvm.internal.g0.w();
        kotlin.collections.f0.S0(allOf, new a(i6));
        Set<T> unmodifiableSet = Collections.unmodifiableSet(allOf);
        kotlin.jvm.internal.g0.o(unmodifiableSet, "unmodifiableSet(...)");
        return unmodifiableSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final p f(Matcher matcher, int i6, CharSequence charSequence) {
        if (!matcher.find(i6)) {
            return null;
        }
        return new q(matcher, charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final p h(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new q(matcher, charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.ranges.m i(MatchResult matchResult) {
        return kotlin.ranges.t.W1(matchResult.start(), matchResult.end());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.ranges.m j(MatchResult matchResult, int i6) {
        return kotlin.ranges.t.W1(matchResult.start(i6), matchResult.end(i6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k(Iterable<? extends h> iterable) {
        Iterator<? extends h> it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 |= it.next().getValue();
        }
        return i6;
    }
}
