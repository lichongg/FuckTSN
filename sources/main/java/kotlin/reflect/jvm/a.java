package kotlin.reflect.jvm;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import kotlin.reflect.i;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.calls.g;
import kotlin.reflect.jvm.internal.e0;
import kotlin.reflect.jvm.internal.p3;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "KCallablesJvm")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {
    public static final boolean a(@NotNull kotlin.reflect.c<?> cVar) {
        g<?> Y;
        g0.p(cVar, "<this>");
        if (cVar instanceof j) {
            n nVar = (n) cVar;
            Field e6 = d.e(nVar);
            if (e6 != null ? e6.isAccessible() : true) {
                Method f6 = d.f(nVar);
                if (f6 != null ? f6.isAccessible() : true) {
                    Method h6 = d.h((j) cVar);
                    if (h6 != null ? h6.isAccessible() : true) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (cVar instanceof n) {
            n nVar2 = (n) cVar;
            Field e7 = d.e(nVar2);
            if (e7 != null ? e7.isAccessible() : true) {
                Method f7 = d.f(nVar2);
                if (f7 != null ? f7.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (cVar instanceof n.c) {
            Field e8 = d.e(((n.c) cVar).f0());
            if (e8 != null ? e8.isAccessible() : true) {
                Method g6 = d.g((i) cVar);
                if (g6 != null ? g6.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (cVar instanceof j.a) {
            Field e9 = d.e(((j.a) cVar).f0());
            if (e9 != null ? e9.isAccessible() : true) {
                Method g7 = d.g((i) cVar);
                if (g7 != null ? g7.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (!(cVar instanceof i)) {
            throw new UnsupportedOperationException("Unknown callable: " + cVar + " (" + cVar.getClass() + ')');
        }
        i iVar = (i) cVar;
        Method g8 = d.g(iVar);
        if (g8 != null ? g8.isAccessible() : true) {
            e0<?> b6 = p3.b(cVar);
            Object c6 = (b6 == null || (Y = b6.Y()) == null) ? null : Y.c();
            AccessibleObject accessibleObject = c6 instanceof AccessibleObject ? (AccessibleObject) c6 : null;
            if (accessibleObject != null ? accessibleObject.isAccessible() : true) {
                Constructor c7 = d.c(iVar);
                if (c7 != null ? c7.isAccessible() : true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final void b(@NotNull kotlin.reflect.c<?> cVar, boolean z5) {
        g<?> Y;
        g0.p(cVar, "<this>");
        if (cVar instanceof j) {
            n nVar = (n) cVar;
            Field e6 = d.e(nVar);
            if (e6 != null) {
                e6.setAccessible(z5);
            }
            Method f6 = d.f(nVar);
            if (f6 != null) {
                f6.setAccessible(z5);
            }
            Method h6 = d.h((j) cVar);
            if (h6 != null) {
                h6.setAccessible(z5);
                return;
            }
            return;
        }
        if (cVar instanceof n) {
            n nVar2 = (n) cVar;
            Field e7 = d.e(nVar2);
            if (e7 != null) {
                e7.setAccessible(z5);
            }
            Method f7 = d.f(nVar2);
            if (f7 != null) {
                f7.setAccessible(z5);
                return;
            }
            return;
        }
        if (cVar instanceof n.c) {
            Field e8 = d.e(((n.c) cVar).f0());
            if (e8 != null) {
                e8.setAccessible(z5);
            }
            Method g6 = d.g((i) cVar);
            if (g6 != null) {
                g6.setAccessible(z5);
                return;
            }
            return;
        }
        if (cVar instanceof j.a) {
            Field e9 = d.e(((j.a) cVar).f0());
            if (e9 != null) {
                e9.setAccessible(z5);
            }
            Method g7 = d.g((i) cVar);
            if (g7 != null) {
                g7.setAccessible(z5);
                return;
            }
            return;
        }
        if (!(cVar instanceof i)) {
            throw new UnsupportedOperationException("Unknown callable: " + cVar + " (" + cVar.getClass() + ')');
        }
        i iVar = (i) cVar;
        Method g8 = d.g(iVar);
        if (g8 != null) {
            g8.setAccessible(z5);
        }
        e0<?> b6 = p3.b(cVar);
        Object c6 = (b6 == null || (Y = b6.Y()) == null) ? null : Y.c();
        AccessibleObject accessibleObject = c6 instanceof AccessibleObject ? (AccessibleObject) c6 : null;
        if (accessibleObject != null) {
            accessibleObject.setAccessible(true);
        }
        Constructor c7 = d.c(iVar);
        if (c7 != null) {
            c7.setAccessible(z5);
        }
    }
}
