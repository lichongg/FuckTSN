package io.netty.channel;

import io.netty.channel.Channel;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.Constructor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ReflectiveChannelFactory<T extends Channel> implements ChannelFactory<T> {
    private final Constructor<? extends T> constructor;

    @Override // io.netty.channel.ChannelFactory, io.netty.bootstrap.ChannelFactory
    public T newChannel() {
        try {
            return this.constructor.newInstance(null);
        } catch (Throwable th) {
            throw new ChannelException("Unable to create Channel from class " + this.constructor.getDeclaringClass(), th);
        }
    }

    public String toString() {
        return StringUtil.simpleClassName((Class<?>) ReflectiveChannelFactory.class) + '(' + StringUtil.simpleClassName((Class<?>) this.constructor.getDeclaringClass()) + ".class)";
    }

    public ReflectiveChannelFactory(Class<? extends T> cls) {
        ObjectUtil.checkNotNull(cls, "clazz");
        try {
            this.constructor = cls.getConstructor(null);
        } catch (NoSuchMethodException e6) {
            throw new IllegalArgumentException("Class " + StringUtil.simpleClassName((Class<?>) cls) + " does not have a public non-arg constructor", e6);
        }
    }
}
