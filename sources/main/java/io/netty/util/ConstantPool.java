package io.netty.util;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.util.Constant;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class ConstantPool<T extends Constant<T>> {
    private final ConcurrentMap<String, T> constants = PlatformDependent.newConcurrentHashMap();
    private final AtomicInteger nextId = new AtomicInteger(1);

    protected abstract T newConstant(int i6, String str);

    public T valueOf(Class<?> cls, String str) {
        if (cls == null) {
            throw new NullPointerException("firstNameComponent");
        }
        if (str == null) {
            throw new NullPointerException("secondNameComponent");
        }
        return valueOf(cls.getName() + '#' + str);
    }

    private static String checkNotNullAndNotEmpty(String str) {
        ObjectUtil.checkNotNull(str, CommonNetImpl.NAME);
        if (str.isEmpty()) {
            throw new IllegalArgumentException("empty name");
        }
        return str;
    }

    private T createOrThrow(String str) {
        if (this.constants.get(str) == null) {
            T newConstant = newConstant(nextId(), str);
            if (this.constants.putIfAbsent(str, newConstant) == null) {
                return newConstant;
            }
        }
        throw new IllegalArgumentException(String.format("'%s' is already in use", str));
    }

    private T getOrCreate(String str) {
        T t5 = this.constants.get(str);
        if (t5 != null) {
            return t5;
        }
        T newConstant = newConstant(nextId(), str);
        T putIfAbsent = this.constants.putIfAbsent(str, newConstant);
        return putIfAbsent == null ? newConstant : putIfAbsent;
    }

    @Deprecated
    public final int nextId() {
        return this.nextId.getAndIncrement();
    }

    public boolean exists(String str) {
        checkNotNullAndNotEmpty(str);
        return this.constants.containsKey(str);
    }

    public T newInstance(String str) {
        checkNotNullAndNotEmpty(str);
        return createOrThrow(str);
    }

    public T valueOf(String str) {
        checkNotNullAndNotEmpty(str);
        return getOrCreate(str);
    }
}
