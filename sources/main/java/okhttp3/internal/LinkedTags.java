package okhttp3.internal;

import kotlin.collections.f0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.sequences.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class LinkedTags<K> extends Tags {

    @NotNull
    private final kotlin.reflect.d<K> key;

    @NotNull
    private final Tags next;

    @NotNull
    private final K value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkedTags(@NotNull kotlin.reflect.d<K> key, @NotNull K value, @NotNull Tags next) {
        super(null);
        g0.p(key, "key");
        g0.p(value, "value");
        g0.p(next, "next");
        this.key = key;
        this.value = value;
        this.next = next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkedTags toString$lambda$0(LinkedTags it) {
        g0.p(it, "it");
        Tags tags = it.next;
        if (tags instanceof LinkedTags) {
            return (LinkedTags) tags;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$1(LinkedTags it) {
        g0.p(it, "it");
        StringBuilder sb = new StringBuilder();
        sb.append(it.key);
        sb.append('=');
        sb.append(it.value);
        return sb.toString();
    }

    @Override // okhttp3.internal.Tags
    @Nullable
    public <T> T get(@NotNull kotlin.reflect.d<T> key) {
        g0.p(key, "key");
        return g0.g(key, this.key) ? (T) l3.a.e(key).cast(this.value) : (T) this.next.get(key);
    }

    @Override // okhttp3.internal.Tags
    @NotNull
    public <T> Tags plus(@NotNull kotlin.reflect.d<T> key, @Nullable T t5) {
        Tags linkedTags;
        g0.p(key, "key");
        if (g0.g(key, this.key)) {
            linkedTags = this.next;
        } else {
            Tags plus = this.next.plus(key, null);
            linkedTags = plus == this.next ? this : new LinkedTags(this.key, this.value, plus);
        }
        return t5 != null ? new LinkedTags(key, t5, linkedTags) : linkedTags;
    }

    @NotNull
    public String toString() {
        return f0.r3(f0.c5(p.I3(p.t(this, new Function1() { // from class: okhttp3.internal.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                LinkedTags string$lambda$0;
                string$lambda$0 = LinkedTags.toString$lambda$0((LinkedTags) obj);
                return string$lambda$0;
            }
        }))), null, "{", "}", 0, null, new Function1() { // from class: okhttp3.internal.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence string$lambda$1;
                string$lambda$1 = LinkedTags.toString$lambda$1((LinkedTags) obj);
                return string$lambda$1;
            }
        }, 25, null);
    }
}
