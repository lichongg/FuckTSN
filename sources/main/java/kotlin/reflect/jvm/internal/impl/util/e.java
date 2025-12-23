package kotlin.reflect.jvm.internal.impl.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAttributeArrayOwner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AttributeArrayOwner.kt\norg/jetbrains/kotlin/util/AttributeArrayOwner\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,103:1\n1573#2:104\n1604#2,3:105\n295#2,2:108\n1607#2:110\n*S KotlinDebug\n*F\n+ 1 AttributeArrayOwner.kt\norg/jetbrains/kotlin/util/AttributeArrayOwner\n*L\n76#1:104\n76#1:105,3\n77#1:108,2\n76#1:110\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class e<K, T> extends a<K, T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private c<T> f47392a;

    protected e(@NotNull c<T> arrayMap) {
        g0.p(arrayMap, "arrayMap");
        this.f47392a = arrayMap;
    }

    private final String g(c<T> cVar, int i6, String str) {
        T t5;
        StringBuilder sb = new StringBuilder();
        sb.append("Race condition happened, the size of ArrayMap is " + i6 + " but it isn't an `" + str + '`');
        sb.append('\n');
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Type: ");
        sb2.append(cVar.getClass());
        sb.append(sb2.toString());
        sb.append('\n');
        StringBuilder sb3 = new StringBuilder();
        Map<String, Integer> b6 = d().b();
        sb3.append("[");
        sb3.append('\n');
        ArrayList arrayList = new ArrayList(f0.d0(cVar, 10));
        int i7 = 0;
        for (T t6 : cVar) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                f0.b0();
            }
            Iterator<T> it = b6.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t5 = null;
                    break;
                }
                t5 = it.next();
                if (((Number) ((Map.Entry) t5).getValue()).intValue() == i7) {
                    break;
                }
            }
            sb3.append("  " + ((Map.Entry) t5) + '[' + i7 + "]: " + t6);
            sb3.append('\n');
            arrayList.add(sb3);
            i7 = i8;
        }
        sb3.append("]");
        sb3.append('\n');
        sb.append("Content: " + sb3.toString());
        sb.append('\n');
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.a
    @NotNull
    protected final c<T> a() {
        return this.f47392a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.util.a
    protected final void e(@NotNull String keyQualifiedName, @NotNull T value) {
        g0.p(keyQualifiedName, "keyQualifiedName");
        g0.p(value, "value");
        int e6 = d().e(keyQualifiedName);
        int a6 = this.f47392a.a();
        if (a6 == 0) {
            c<T> cVar = this.f47392a;
            if (!(cVar instanceof i)) {
                throw new IllegalStateException(g(cVar, 0, "EmptyArrayMap"));
            }
            this.f47392a = new o(value, e6);
            return;
        }
        if (a6 == 1) {
            c<T> cVar2 = this.f47392a;
            try {
                g0.n(cVar2, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
                o oVar = (o) cVar2;
                if (oVar.e() == e6) {
                    this.f47392a = new o(value, e6);
                    return;
                } else {
                    d dVar = new d();
                    dVar.d(oVar.e(), oVar.f());
                    this.f47392a = dVar;
                }
            } catch (ClassCastException e7) {
                throw new IllegalStateException(g(cVar2, 1, "OneElementArrayMap"), e7);
            }
        }
        this.f47392a.d(e6, value);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public e() {
        /*
            r2 = this;
            kotlin.reflect.jvm.internal.impl.util.i r0 = kotlin.reflect.jvm.internal.impl.util.i.f47405a
            java.lang.String r1 = "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>"
            kotlin.jvm.internal.g0.n(r0, r1)
            r2.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.e.<init>():void");
    }
}
