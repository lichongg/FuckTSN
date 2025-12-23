package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Splitter {
    private final int limit;
    private final boolean omitEmptyStrings;
    private final Strategy strategy;
    private final CharMatcher trimmer;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Beta
    public static final class MapSplitter {
        private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
        private final Splitter entrySplitter;
        private final Splitter outerSplitter;

        private MapSplitter(Splitter splitter, Splitter splitter2) {
            this.outerSplitter = splitter;
            this.entrySplitter = (Splitter) Preconditions.checkNotNull(splitter2);
        }

        public Map<String, String> split(CharSequence charSequence) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : this.outerSplitter.split(charSequence)) {
                Iterator splittingIterator = this.entrySplitter.splittingIterator(str);
                Preconditions.checkArgument(splittingIterator.hasNext(), INVALID_ENTRY_MESSAGE, str);
                String str2 = (String) splittingIterator.next();
                Preconditions.checkArgument(!linkedHashMap.containsKey(str2), "Duplicate key [%s] found.", str2);
                Preconditions.checkArgument(splittingIterator.hasNext(), INVALID_ENTRY_MESSAGE, str);
                linkedHashMap.put(str2, (String) splittingIterator.next());
                Preconditions.checkArgument(!splittingIterator.hasNext(), INVALID_ENTRY_MESSAGE, str);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class SplittingIterator extends AbstractIterator<String> {
        int limit;
        int offset = 0;
        final boolean omitEmptyStrings;
        final CharSequence toSplit;
        final CharMatcher trimmer;

        abstract int separatorEnd(int i6);

        abstract int separatorStart(int i6);

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.AbstractIterator
        public String computeNext() {
            int separatorStart;
            int i6 = this.offset;
            while (true) {
                int i7 = this.offset;
                if (i7 == -1) {
                    return endOfData();
                }
                separatorStart = separatorStart(i7);
                if (separatorStart == -1) {
                    separatorStart = this.toSplit.length();
                    this.offset = -1;
                } else {
                    this.offset = separatorEnd(separatorStart);
                }
                int i8 = this.offset;
                if (i8 == i6) {
                    int i9 = i8 + 1;
                    this.offset = i9;
                    if (i9 > this.toSplit.length()) {
                        this.offset = -1;
                    }
                } else {
                    while (i6 < separatorStart && this.trimmer.matches(this.toSplit.charAt(i6))) {
                        i6++;
                    }
                    while (separatorStart > i6 && this.trimmer.matches(this.toSplit.charAt(separatorStart - 1))) {
                        separatorStart--;
                    }
                    if (!this.omitEmptyStrings || i6 != separatorStart) {
                        break;
                    }
                    i6 = this.offset;
                }
            }
            int i10 = this.limit;
            if (i10 == 1) {
                separatorStart = this.toSplit.length();
                this.offset = -1;
                while (separatorStart > i6 && this.trimmer.matches(this.toSplit.charAt(separatorStart - 1))) {
                    separatorStart--;
                }
            } else {
                this.limit = i10 - 1;
            }
            return this.toSplit.subSequence(i6, separatorStart).toString();
        }

        protected SplittingIterator(Splitter splitter, CharSequence charSequence) {
            this.trimmer = splitter.trimmer;
            this.omitEmptyStrings = splitter.omitEmptyStrings;
            this.limit = splitter.limit;
            this.toSplit = charSequence;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface Strategy {
        Iterator<String> iterator(Splitter splitter, CharSequence charSequence);
    }

    private Splitter(Strategy strategy) {
        this(strategy, false, CharMatcher.none(), Integer.MAX_VALUE);
    }

    public static Splitter on(char c6) {
        return on(CharMatcher.is(c6));
    }

    public Splitter trimResults() {
        return trimResults(CharMatcher.whitespace());
    }

    @Beta
    public MapSplitter withKeyValueSeparator(String str) {
        return withKeyValueSeparator(on(str));
    }

    private Splitter(Strategy strategy, boolean z5, CharMatcher charMatcher, int i6) {
        this.strategy = strategy;
        this.omitEmptyStrings = z5;
        this.trimmer = charMatcher;
        this.limit = i6;
    }

    public static Splitter fixedLength(final int i6) {
        Preconditions.checkArgument(i6 > 0, "The length may not be less than 1");
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.4
            @Override // com.google.common.base.Splitter.Strategy
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) { // from class: com.google.common.base.Splitter.4.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int separatorStart(int i7) {
                        int i8 = i7 + i6;
                        if (i8 < this.toSplit.length()) {
                            return i8;
                        }
                        return -1;
                    }

                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int separatorEnd(int i7) {
                        return i7;
                    }
                };
            }
        });
    }

    public static Splitter on(final CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.1
            @Override // com.google.common.base.Splitter.Strategy
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) { // from class: com.google.common.base.Splitter.1.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    int separatorEnd(int i6) {
                        return i6 + 1;
                    }

                    @Override // com.google.common.base.Splitter.SplittingIterator
                    int separatorStart(int i6) {
                        return CharMatcher.this.indexIn(this.toSplit, i6);
                    }
                };
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Iterator<String> splittingIterator(CharSequence charSequence) {
        return this.strategy.iterator(this, charSequence);
    }

    public Splitter limit(int i6) {
        Preconditions.checkArgument(i6 > 0, "must be greater than zero: %s", i6);
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, i6);
    }

    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    public Splitter trimResults(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.strategy, this.omitEmptyStrings, charMatcher, this.limit);
    }

    @Beta
    public MapSplitter withKeyValueSeparator(char c6) {
        return withKeyValueSeparator(on(c6));
    }

    @GwtIncompatible
    public static Splitter onPattern(String str) {
        return on(Platform.compilePattern(str));
    }

    public Iterable<String> split(final CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return new Iterable<String>() { // from class: com.google.common.base.Splitter.5
            @Override // java.lang.Iterable
            public Iterator<String> iterator() {
                return Splitter.this.splittingIterator(charSequence);
            }

            public String toString() {
                Joiner on = Joiner.on(", ");
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                StringBuilder appendTo = on.appendTo(sb, (Iterable<?>) this);
                appendTo.append(']');
                return appendTo.toString();
            }
        };
    }

    public List<String> splitToList(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Iterator<String> splittingIterator = splittingIterator(charSequence);
        ArrayList arrayList = new ArrayList();
        while (splittingIterator.hasNext()) {
            arrayList.add(splittingIterator.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Beta
    public MapSplitter withKeyValueSeparator(Splitter splitter) {
        return new MapSplitter(splitter);
    }

    public static Splitter on(final String str) {
        Preconditions.checkArgument(str.length() != 0, "The separator may not be the empty string.");
        if (str.length() == 1) {
            return on(str.charAt(0));
        }
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.2
            @Override // com.google.common.base.Splitter.Strategy
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) { // from class: com.google.common.base.Splitter.2.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int separatorEnd(int i6) {
                        return i6 + str.length();
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
                    
                        r6 = r6 + 1;
                     */
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public int separatorStart(int r6) {
                        /*
                            r5 = this;
                            com.google.common.base.Splitter$2 r0 = com.google.common.base.Splitter.AnonymousClass2.this
                            java.lang.String r0 = r1
                            int r0 = r0.length()
                            java.lang.CharSequence r1 = r5.toSplit
                            int r1 = r1.length()
                            int r1 = r1 - r0
                        Lf:
                            if (r6 > r1) goto L2d
                            r2 = 0
                        L12:
                            if (r2 >= r0) goto L2c
                            java.lang.CharSequence r3 = r5.toSplit
                            int r4 = r2 + r6
                            char r3 = r3.charAt(r4)
                            com.google.common.base.Splitter$2 r4 = com.google.common.base.Splitter.AnonymousClass2.this
                            java.lang.String r4 = r1
                            char r4 = r4.charAt(r2)
                            if (r3 == r4) goto L29
                            int r6 = r6 + 1
                            goto Lf
                        L29:
                            int r2 = r2 + 1
                            goto L12
                        L2c:
                            return r6
                        L2d:
                            r6 = -1
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Splitter.AnonymousClass2.AnonymousClass1.separatorStart(int):int");
                    }
                };
            }
        });
    }

    @GwtIncompatible
    public static Splitter on(Pattern pattern) {
        return on(new JdkPattern(pattern));
    }

    private static Splitter on(final CommonPattern commonPattern) {
        Preconditions.checkArgument(!commonPattern.matcher("").matches(), "The pattern may not match the empty string: %s", commonPattern);
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.3
            @Override // com.google.common.base.Splitter.Strategy
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                final CommonMatcher matcher = CommonPattern.this.matcher(charSequence);
                return new SplittingIterator(splitter, charSequence) { // from class: com.google.common.base.Splitter.3.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int separatorEnd(int i6) {
                        return matcher.end();
                    }

                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int separatorStart(int i6) {
                        if (matcher.find(i6)) {
                            return matcher.start();
                        }
                        return -1;
                    }
                };
            }
        });
    }
}
