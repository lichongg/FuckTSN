package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.LinkedList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e implements d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final ProtoBuf.StringTable f46240a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final ProtoBuf.QualifiedNameTable f46241b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46242a;

        static {
            int[] iArr = new int[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.values().length];
            try {
                iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f46242a = iArr;
        }
    }

    public e(@NotNull ProtoBuf.StringTable strings, @NotNull ProtoBuf.QualifiedNameTable qualifiedNames) {
        g0.p(strings, "strings");
        g0.p(qualifiedNames, "qualifiedNames");
        this.f46240a = strings;
        this.f46241b = qualifiedNames;
    }

    private final Triple<List<String>, List<String>, Boolean> c(int i6) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z5 = false;
        while (i6 != -1) {
            ProtoBuf.QualifiedNameTable.QualifiedName qualifiedName = this.f46241b.getQualifiedName(i6);
            String string = this.f46240a.getString(qualifiedName.getShortName());
            ProtoBuf.QualifiedNameTable.QualifiedName.Kind kind = qualifiedName.getKind();
            g0.m(kind);
            int i7 = a.f46242a[kind.ordinal()];
            if (i7 == 1) {
                linkedList2.addFirst(string);
            } else if (i7 == 2) {
                linkedList.addFirst(string);
            } else {
                if (i7 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                linkedList2.addFirst(string);
                z5 = true;
            }
            i6 = qualifiedName.getParentQualifiedName();
        }
        return new Triple<>(linkedList, linkedList2, Boolean.valueOf(z5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.d
    @NotNull
    public String getString(int i6) {
        String string = this.f46240a.getString(i6);
        g0.o(string, "getString(...)");
        return string;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.d
    @NotNull
    public String a(int i6) {
        Triple<List<String>, List<String>, Boolean> c6 = c(i6);
        List<String> component1 = c6.component1();
        String r32 = f0.r3(c6.component2(), ".", null, null, 0, null, null, 62, null);
        if (component1.isEmpty()) {
            return r32;
        }
        return f0.r3(component1, "/", null, null, 0, null, null, 62, null) + '/' + r32;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.d
    public boolean b(int i6) {
        return c(i6).getThird().booleanValue();
    }
}
