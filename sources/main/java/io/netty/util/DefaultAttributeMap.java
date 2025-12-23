package io.netty.util;

import androidx.concurrent.futures.a;
import com.google.common.util.concurrent.b;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultAttributeMap implements AttributeMap {
    private static final int BUCKET_SIZE = 4;
    private static final int MASK = 3;
    private static final AtomicReferenceFieldUpdater<DefaultAttributeMap, AtomicReferenceArray> updater = AtomicReferenceFieldUpdater.newUpdater(DefaultAttributeMap.class, AtomicReferenceArray.class, "attributes");
    private volatile AtomicReferenceArray<DefaultAttribute<?>> attributes;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class DefaultAttribute<T> extends AtomicReference<T> implements Attribute<T> {
        private static final long serialVersionUID = -2661411462200283011L;
        private final DefaultAttribute<?> head;
        private final AttributeKey<T> key;
        private DefaultAttribute<?> next;
        private DefaultAttribute<?> prev;
        private volatile boolean removed;

        DefaultAttribute(DefaultAttribute<?> defaultAttribute, AttributeKey<T> attributeKey) {
            this.head = defaultAttribute;
            this.key = attributeKey;
        }

        @Override // io.netty.util.Attribute
        public T getAndRemove() {
            this.removed = true;
            T andSet = getAndSet(null);
            remove0();
            return andSet;
        }

        @Override // io.netty.util.Attribute
        public void remove() {
            this.removed = true;
            set(null);
            remove0();
        }

        @Override // io.netty.util.Attribute
        public T setIfAbsent(T t5) {
            T t6;
            do {
                t6 = null;
                if (compareAndSet(null, t5)) {
                    break;
                }
                t6 = get();
            } while (t6 == null);
            return t6;
        }

        private void remove0() {
            synchronized (this.head) {
                try {
                    DefaultAttribute<?> defaultAttribute = this.prev;
                    if (defaultAttribute == null) {
                        return;
                    }
                    defaultAttribute.next = this.next;
                    DefaultAttribute<?> defaultAttribute2 = this.next;
                    if (defaultAttribute2 != null) {
                        defaultAttribute2.prev = defaultAttribute;
                    }
                    this.prev = null;
                    this.next = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.netty.util.Attribute
        public AttributeKey<T> key() {
            return this.key;
        }

        /* JADX WARN: Multi-variable type inference failed */
        DefaultAttribute() {
            this.head = this;
            this.key = null;
        }
    }

    @Override // io.netty.util.AttributeMap
    public <T> Attribute<T> attr(AttributeKey<T> attributeKey) {
        if (attributeKey == null) {
            throw new NullPointerException("key");
        }
        AtomicReferenceArray<DefaultAttribute<?>> atomicReferenceArray = this.attributes;
        if (atomicReferenceArray == null) {
            atomicReferenceArray = new AtomicReferenceArray<>(4);
            if (!a.a(updater, this, null, atomicReferenceArray)) {
                atomicReferenceArray = this.attributes;
            }
        }
        int index = index(attributeKey);
        DefaultAttribute<?> defaultAttribute = atomicReferenceArray.get(index);
        if (defaultAttribute == null) {
            DefaultAttribute defaultAttribute2 = new DefaultAttribute();
            DefaultAttribute defaultAttribute3 = new DefaultAttribute(defaultAttribute2, attributeKey);
            defaultAttribute2.next = defaultAttribute3;
            defaultAttribute3.prev = defaultAttribute2;
            if (b.a(atomicReferenceArray, index, null, defaultAttribute2)) {
                return defaultAttribute3;
            }
            defaultAttribute = atomicReferenceArray.get(index);
        }
        synchronized (defaultAttribute) {
            DefaultAttribute<?> defaultAttribute4 = defaultAttribute;
            while (true) {
                try {
                    DefaultAttribute<?> defaultAttribute5 = ((DefaultAttribute) defaultAttribute4).next;
                    if (defaultAttribute5 == null) {
                        DefaultAttribute defaultAttribute6 = new DefaultAttribute(defaultAttribute, attributeKey);
                        ((DefaultAttribute) defaultAttribute4).next = defaultAttribute6;
                        defaultAttribute6.prev = defaultAttribute4;
                        return defaultAttribute6;
                    }
                    if (((DefaultAttribute) defaultAttribute5).key == attributeKey && !((DefaultAttribute) defaultAttribute5).removed) {
                        return defaultAttribute5;
                    }
                    defaultAttribute4 = defaultAttribute5;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // io.netty.util.AttributeMap
    public <T> boolean hasAttr(AttributeKey<T> attributeKey) {
        DefaultAttribute<?> defaultAttribute;
        if (attributeKey == null) {
            throw new NullPointerException("key");
        }
        AtomicReferenceArray<DefaultAttribute<?>> atomicReferenceArray = this.attributes;
        if (atomicReferenceArray == null || (defaultAttribute = atomicReferenceArray.get(index(attributeKey))) == null) {
            return false;
        }
        synchronized (defaultAttribute) {
            try {
                for (DefaultAttribute defaultAttribute2 = ((DefaultAttribute) defaultAttribute).next; defaultAttribute2 != null; defaultAttribute2 = defaultAttribute2.next) {
                    if (defaultAttribute2.key == attributeKey && !defaultAttribute2.removed) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static int index(AttributeKey<?> attributeKey) {
        return attributeKey.id() & 3;
    }
}
