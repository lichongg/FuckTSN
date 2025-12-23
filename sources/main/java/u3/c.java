package u3;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface c {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f54673a = new a();

        @Override // u3.c
        public boolean a() {
            return false;
        }

        @Override // u3.c
        public void b(@NotNull String filePath, @NotNull Position position, @NotNull String scopeFqName, @NotNull ScopeKind scopeKind, @NotNull String name) {
            g0.p(filePath, "filePath");
            g0.p(position, "position");
            g0.p(scopeFqName, "scopeFqName");
            g0.p(scopeKind, "scopeKind");
            g0.p(name, "name");
        }

        private a() {
        }
    }

    boolean a();

    void b(@NotNull String str, @NotNull Position position, @NotNull String str2, @NotNull ScopeKind scopeKind, @NotNull String str3);
}
