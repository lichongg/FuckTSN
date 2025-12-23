package okio;

import java.util.List;
import java.util.RandomAccess;
import kotlin.collections.f0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okio.Options;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class TypedOptions<T> extends kotlin.collections.d<T> implements RandomAccess {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final List<T> list;

    @NotNull
    private final Options options;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final <T> TypedOptions<T> of(@NotNull Iterable<? extends T> values, @NotNull Function1<? super T, ? extends ByteString> encode) {
            g0.p(values, "values");
            g0.p(encode, "encode");
            List a6 = f0.a6(values);
            Options.Companion companion = Options.Companion;
            int size = a6.size();
            ByteString[] byteStringArr = new ByteString[size];
            for (int i6 = 0; i6 < size; i6++) {
                byteStringArr[i6] = encode.invoke((Object) a6.get(i6));
            }
            return new TypedOptions<>(a6, companion.of(byteStringArr));
        }
    }

    public TypedOptions(@NotNull List<? extends T> list, @NotNull Options options) {
        g0.p(list, "list");
        g0.p(options, "options");
        this.options = options;
        List<T> a6 = f0.a6(list);
        this.list = a6;
        if (a6.size() != options.size()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    @JvmStatic
    @NotNull
    public static final <T> TypedOptions<T> of(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends ByteString> function1) {
        return Companion.of(iterable, function1);
    }

    @Override // kotlin.collections.d, java.util.List
    @NotNull
    public T get(int i6) {
        return this.list.get(i6);
    }

    @NotNull
    public final List<T> getList$okio() {
        return this.list;
    }

    @NotNull
    public final Options getOptions$okio() {
        return this.options;
    }

    @Override // kotlin.collections.d, kotlin.collections.b
    public int getSize() {
        return this.list.size();
    }
}
