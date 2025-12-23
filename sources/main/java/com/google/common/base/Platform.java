package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
final class Platform {
    private static final Logger logger = Logger.getLogger(Platform.class.getName());
    private static final PatternCompiler patternCompiler = loadPatternCompiler();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.base.Platform$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class JdkPatternCompiler implements PatternCompiler {
        private JdkPatternCompiler() {
        }

        @Override // com.google.common.base.PatternCompiler
        public boolean isPcreLike() {
            return true;
        }

        /* synthetic */ JdkPatternCompiler(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.base.PatternCompiler
        public CommonPattern compile(String str) {
            return new JdkPattern(Pattern.compile(str));
        }
    }

    static String formatCompact4Digits(double d6) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d6));
    }

    private static PatternCompiler loadPatternCompiler() {
        return new JdkPatternCompiler(null);
    }

    private static void logPatternCompilerError(ServiceConfigurationError serviceConfigurationError) {
        logger.log(Level.WARNING, "Error loading regex compiler, falling back to next option", (Throwable) serviceConfigurationError);
    }

    static String nullToEmpty(@NullableDecl String str) {
        return str == null ? "" : str;
    }

    static boolean patternCompilerIsPcreLike() {
        return patternCompiler.isPcreLike();
    }

    static boolean stringIsNullOrEmpty(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }

    private Platform() {
    }

    static CommonPattern compilePattern(String str) {
        Preconditions.checkNotNull(str);
        return patternCompiler.compile(str);
    }

    static String emptyToNull(@NullableDecl String str) {
        if (stringIsNullOrEmpty(str)) {
            return null;
        }
        return str;
    }

    static <T extends Enum<T>> Optional<T> getEnumIfPresent(Class<T> cls, String str) {
        WeakReference<? extends Enum<?>> weakReference = Enums.getEnumConstants(cls).get(str);
        if (weakReference == null) {
            return Optional.absent();
        }
        return Optional.of(cls.cast(weakReference.get()));
    }

    static CharMatcher precomputeCharMatcher(CharMatcher charMatcher) {
        return charMatcher.precomputedInternal();
    }

    static long systemNanoTime() {
        return System.nanoTime();
    }
}
