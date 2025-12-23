package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.PlatformDependent;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class FastThreadLocal<V> {
    private static final int variablesToRemoveIndex = InternalThreadLocalMap.nextVariableIndex();
    private final int index = InternalThreadLocalMap.nextVariableIndex();

    public final V get() {
        InternalThreadLocalMap internalThreadLocalMap = InternalThreadLocalMap.get();
        V v5 = (V) internalThreadLocalMap.indexedVariable(this.index);
        return v5 != InternalThreadLocalMap.UNSET ? v5 : initialize(internalThreadLocalMap);
    }

    protected V initialValue() throws Exception {
        return null;
    }

    public final boolean isSet() {
        return isSet(InternalThreadLocalMap.getIfSet());
    }

    public final void remove() {
        remove(InternalThreadLocalMap.getIfSet());
    }

    public final void set(V v5) {
        if (v5 != InternalThreadLocalMap.UNSET) {
            setKnownNotUnset(InternalThreadLocalMap.get(), v5);
        } else {
            remove();
        }
    }

    private static void addToVariablesToRemove(InternalThreadLocalMap internalThreadLocalMap, FastThreadLocal<?> fastThreadLocal) {
        Set newSetFromMap;
        int i6 = variablesToRemoveIndex;
        Object indexedVariable = internalThreadLocalMap.indexedVariable(i6);
        if (indexedVariable == InternalThreadLocalMap.UNSET || indexedVariable == null) {
            newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            internalThreadLocalMap.setIndexedVariable(i6, newSetFromMap);
        } else {
            newSetFromMap = (Set) indexedVariable;
        }
        newSetFromMap.add(fastThreadLocal);
    }

    private static void removeFromVariablesToRemove(InternalThreadLocalMap internalThreadLocalMap, FastThreadLocal<?> fastThreadLocal) {
        Object indexedVariable = internalThreadLocalMap.indexedVariable(variablesToRemoveIndex);
        if (indexedVariable == InternalThreadLocalMap.UNSET || indexedVariable == null) {
            return;
        }
        ((Set) indexedVariable).remove(fastThreadLocal);
    }

    private void setKnownNotUnset(InternalThreadLocalMap internalThreadLocalMap, V v5) {
        if (internalThreadLocalMap.setIndexedVariable(this.index, v5)) {
            addToVariablesToRemove(internalThreadLocalMap, this);
        }
    }

    public final boolean isSet(InternalThreadLocalMap internalThreadLocalMap) {
        return internalThreadLocalMap != null && internalThreadLocalMap.isIndexedVariableSet(this.index);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void remove(InternalThreadLocalMap internalThreadLocalMap) {
        if (internalThreadLocalMap == null) {
            return;
        }
        Object removeIndexedVariable = internalThreadLocalMap.removeIndexedVariable(this.index);
        removeFromVariablesToRemove(internalThreadLocalMap, this);
        if (removeIndexedVariable != InternalThreadLocalMap.UNSET) {
            try {
                onRemoval(removeIndexedVariable);
            } catch (Exception e6) {
                PlatformDependent.throwException(e6);
            }
        }
    }

    public static void destroy() {
        InternalThreadLocalMap.destroy();
    }

    private V initialize(InternalThreadLocalMap internalThreadLocalMap) {
        V v5;
        try {
            v5 = initialValue();
        } catch (Exception e6) {
            PlatformDependent.throwException(e6);
            v5 = null;
        }
        internalThreadLocalMap.setIndexedVariable(this.index, v5);
        addToVariablesToRemove(internalThreadLocalMap, this);
        return v5;
    }

    public static void removeAll() {
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet == null) {
            return;
        }
        try {
            Object indexedVariable = ifSet.indexedVariable(variablesToRemoveIndex);
            if (indexedVariable != null && indexedVariable != InternalThreadLocalMap.UNSET) {
                for (FastThreadLocal fastThreadLocal : (FastThreadLocal[]) ((Set) indexedVariable).toArray(new FastThreadLocal[0])) {
                    fastThreadLocal.remove(ifSet);
                }
            }
        } finally {
            InternalThreadLocalMap.remove();
        }
    }

    public static int size() {
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet == null) {
            return 0;
        }
        return ifSet.size();
    }

    public final V getIfExists() {
        V v5;
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet != null && (v5 = (V) ifSet.indexedVariable(this.index)) != InternalThreadLocalMap.UNSET) {
            return v5;
        }
        return null;
    }

    public final V get(InternalThreadLocalMap internalThreadLocalMap) {
        V v5 = (V) internalThreadLocalMap.indexedVariable(this.index);
        return v5 != InternalThreadLocalMap.UNSET ? v5 : initialize(internalThreadLocalMap);
    }

    public final void set(InternalThreadLocalMap internalThreadLocalMap, V v5) {
        if (v5 != InternalThreadLocalMap.UNSET) {
            setKnownNotUnset(internalThreadLocalMap, v5);
        } else {
            remove(internalThreadLocalMap);
        }
    }

    protected void onRemoval(V v5) throws Exception {
    }
}
