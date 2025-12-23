package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f46256b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final j f46257c = new j(f0.J());

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<ProtoBuf.VersionRequirement> f46258a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final j a(@NotNull ProtoBuf.VersionRequirementTable table) {
            g0.p(table, "table");
            if (table.getRequirementCount() == 0) {
                return b();
            }
            List<ProtoBuf.VersionRequirement> requirementList = table.getRequirementList();
            g0.o(requirementList, "getRequirementList(...)");
            return new j(requirementList, null);
        }

        @NotNull
        public final j b() {
            return j.f46257c;
        }
    }

    public /* synthetic */ j(List list, v vVar) {
        this(list);
    }

    private j(List<ProtoBuf.VersionRequirement> list) {
        this.f46258a = list;
    }

    @Nullable
    public final ProtoBuf.VersionRequirement b(int i6) {
        return (ProtoBuf.VersionRequirement) f0.b3(this.f46258a, i6);
    }
}
