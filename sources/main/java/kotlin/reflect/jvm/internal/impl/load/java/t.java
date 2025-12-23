package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Arrays;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface t {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.name.b f45736a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final byte[] f45737b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private final y3.g f45738c;

        public a(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId, @Nullable byte[] bArr, @Nullable y3.g gVar) {
            kotlin.jvm.internal.g0.p(classId, "classId");
            this.f45736a = classId;
            this.f45737b = bArr;
            this.f45738c = gVar;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.g0.g(this.f45736a, aVar.f45736a) && kotlin.jvm.internal.g0.g(this.f45737b, aVar.f45737b) && kotlin.jvm.internal.g0.g(this.f45738c, aVar.f45738c);
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.b a() {
            return this.f45736a;
        }

        public int hashCode() {
            int hashCode = this.f45736a.hashCode() * 31;
            byte[] bArr = this.f45737b;
            int hashCode2 = (hashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            y3.g gVar = this.f45738c;
            return hashCode2 + (gVar != null ? gVar.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Request(classId=" + this.f45736a + ", previouslyFoundClassFileContent=" + Arrays.toString(this.f45737b) + ", outerClass=" + this.f45738c + ')';
        }

        public /* synthetic */ a(kotlin.reflect.jvm.internal.impl.name.b bVar, byte[] bArr, y3.g gVar, int i6, kotlin.jvm.internal.v vVar) {
            this(bVar, (i6 & 2) != 0 ? null : bArr, (i6 & 4) != 0 ? null : gVar);
        }
    }

    @Nullable
    Set<String> a(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar);

    @Nullable
    y3.g b(@NotNull a aVar);

    @Nullable
    y3.u c(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar, boolean z5);
}
