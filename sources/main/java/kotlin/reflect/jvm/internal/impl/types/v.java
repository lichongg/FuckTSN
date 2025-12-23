package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class v extends b {

    /* renamed from: d, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.d f47352d;

    /* renamed from: e, reason: collision with root package name */
    private final List<kotlin.reflect.jvm.internal.impl.descriptors.j1> f47353e;

    /* renamed from: f, reason: collision with root package name */
    private final Collection<t0> f47354f;

    private static /* synthetic */ void H(int i6) {
        String str = (i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) ? 2 : 3];
        switch (i6) {
            case 1:
                objArr[0] = "parameters";
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i6 == 4) {
            objArr[1] = "getParameters";
        } else if (i6 == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i6 == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i6 != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (i6 != 4 && i6 != 5 && i6 != 6 && i6 != 7) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i6 != 4 && i6 != 5 && i6 != 6 && i6 != 7) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    public boolean d() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull List<? extends kotlin.reflect.jvm.internal.impl.descriptors.j1> list, @NotNull Collection<t0> collection, @NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        super(nVar);
        if (dVar == null) {
            H(0);
        }
        if (list == null) {
            H(1);
        }
        if (collection == null) {
            H(2);
        }
        if (nVar == null) {
            H(3);
        }
        this.f47352d = dVar;
        this.f47353e = Collections.unmodifiableList(new ArrayList(list));
        this.f47354f = Collections.unmodifiableCollection(collection);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.b, kotlin.reflect.jvm.internal.impl.types.w, kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    /* renamed from: I */
    public kotlin.reflect.jvm.internal.impl.descriptors.d c() {
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = this.f47352d;
        if (dVar == null) {
            H(5);
        }
        return dVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.j1> getParameters() {
        List<kotlin.reflect.jvm.internal.impl.descriptors.j1> list = this.f47353e;
        if (list == null) {
            H(4);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q
    @NotNull
    protected Collection<t0> r() {
        Collection<t0> collection = this.f47354f;
        if (collection == null) {
            H(6);
        }
        return collection;
    }

    public String toString() {
        return kotlin.reflect.jvm.internal.impl.resolve.i.m(this.f47352d).a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q
    @NotNull
    protected kotlin.reflect.jvm.internal.impl.descriptors.h1 v() {
        h1.a aVar = h1.a.f44688a;
        if (aVar == null) {
            H(7);
        }
        return aVar;
    }
}
