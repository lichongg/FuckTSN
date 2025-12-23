package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.RecyclableArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.j1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CompositeByteBuf extends AbstractReferenceCountedByteBuf implements Iterable<ByteBuf> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ByteBufAllocator alloc;
    private int componentCount;
    private Component[] components;
    private final boolean direct;
    private boolean freed;
    private Component lastAccessed;
    private final int maxNumComponents;
    private static final ByteBuffer EMPTY_NIO_BUFFER = Unpooled.EMPTY_BUFFER.nioBuffer();
    private static final Iterator<ByteBuf> EMPTY_ITERATOR = Collections.EMPTY_LIST.iterator();
    static final ByteWrapper<byte[]> BYTE_ARRAY_WRAPPER = new ByteWrapper<byte[]>() { // from class: io.netty.buffer.CompositeByteBuf.1
        @Override // io.netty.buffer.CompositeByteBuf.ByteWrapper
        public boolean isEmpty(byte[] bArr) {
            return bArr.length == 0;
        }

        @Override // io.netty.buffer.CompositeByteBuf.ByteWrapper
        public ByteBuf wrap(byte[] bArr) {
            return Unpooled.wrappedBuffer(bArr);
        }
    };
    static final ByteWrapper<ByteBuffer> BYTE_BUFFER_WRAPPER = new ByteWrapper<ByteBuffer>() { // from class: io.netty.buffer.CompositeByteBuf.2
        @Override // io.netty.buffer.CompositeByteBuf.ByteWrapper
        public boolean isEmpty(ByteBuffer byteBuffer) {
            return !byteBuffer.hasRemaining();
        }

        @Override // io.netty.buffer.CompositeByteBuf.ByteWrapper
        public ByteBuf wrap(ByteBuffer byteBuffer) {
            return Unpooled.wrappedBuffer(byteBuffer);
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface ByteWrapper<T> {
        boolean isEmpty(T t5);

        ByteBuf wrap(T t5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Component {
        int adjustment;
        final ByteBuf buf;
        int endOffset;
        int offset;
        private ByteBuf slice;

        ByteBuf duplicate() {
            return this.buf.duplicate().setIndex(idx(this.offset), idx(this.endOffset));
        }

        void free() {
            ByteBuf byteBuf = this.slice;
            if (byteBuf != null) {
                byteBuf.release();
            } else {
                this.buf.release();
            }
            this.slice = null;
        }

        int idx(int i6) {
            return i6 + this.adjustment;
        }

        ByteBuffer internalNioBuffer(int i6, int i7) {
            return this.slice != null ? this.buf.nioBuffer(idx(i6), i7) : this.buf.internalNioBuffer(idx(i6), i7);
        }

        int length() {
            return this.endOffset - this.offset;
        }

        void reposition(int i6) {
            int i7 = i6 - this.offset;
            this.endOffset += i7;
            this.adjustment -= i7;
            this.offset = i6;
        }

        ByteBuf slice() {
            ByteBuf byteBuf = this.slice;
            if (byteBuf != null) {
                return byteBuf;
            }
            ByteBuf slice = this.buf.slice(idx(this.offset), length());
            this.slice = slice;
            return slice;
        }

        void transferTo(ByteBuf byteBuf) {
            byteBuf.writeBytes(this.buf, idx(this.offset), length());
            free();
        }

        Component(ByteBuf byteBuf, int i6, int i7, int i8, ByteBuf byteBuf2) {
            this.buf = byteBuf;
            this.offset = i7;
            this.endOffset = i8 + i7;
            this.adjustment = i6 - i7;
            this.slice = byteBuf2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class CompositeByteBufIterator implements Iterator<ByteBuf> {
        private int index;
        private final int size;

        private CompositeByteBufIterator() {
            this.size = CompositeByteBuf.this.numComponents();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.size > this.index;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public ByteBuf next() {
            if (this.size != CompositeByteBuf.this.numComponents()) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            try {
                Component[] componentArr = CompositeByteBuf.this.components;
                int i6 = this.index;
                this.index = i6 + 1;
                return componentArr[i6].slice();
            } catch (IndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-Only");
        }
    }

    private CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z5, int i6, int i7) {
        super(Integer.MAX_VALUE);
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        if (i6 >= 1) {
            this.alloc = byteBufAllocator;
            this.direct = z5;
            this.maxNumComponents = i6;
            this.components = newCompArray(i7, i6);
            return;
        }
        throw new IllegalArgumentException("maxNumComponents: " + i6 + " (expected: >= 1)");
    }

    private void addComp(int i6, Component component) {
        shiftComps(i6, 1);
        this.components[i6] = component;
    }

    private int addComponent0(boolean z5, int i6, ByteBuf byteBuf) {
        boolean z6 = false;
        try {
            checkComponentIndex(i6);
            Component newComponent = newComponent(byteBuf, 0);
            int length = newComponent.length();
            addComp(i6, newComponent);
            z6 = true;
            if (length > 0 && i6 < this.componentCount - 1) {
                updateComponentOffsets(i6);
            } else if (i6 > 0) {
                newComponent.reposition(this.components[i6 - 1].endOffset);
            }
            if (z5) {
                this.writerIndex += length;
            }
            return i6;
        } catch (Throwable th) {
            if (!z6) {
                byteBuf.release();
            }
            throw th;
        }
    }

    private CompositeByteBuf addComponents0(boolean z5, int i6, ByteBuf[] byteBufArr, int i7) {
        int length = byteBufArr.length;
        int i8 = length - i7;
        int i9 = Integer.MAX_VALUE;
        try {
            checkComponentIndex(i6);
            shiftComps(i6, i8);
            int i10 = i6 > 0 ? this.components[i6 - 1].endOffset : 0;
            int i11 = i6;
            while (i7 < length) {
                try {
                    ByteBuf byteBuf = byteBufArr[i7];
                    if (byteBuf == null) {
                        break;
                    }
                    Component newComponent = newComponent(byteBuf, i10);
                    this.components[i11] = newComponent;
                    i10 = newComponent.endOffset;
                    i7++;
                    i11++;
                } catch (Throwable th) {
                    int i12 = i11;
                    th = th;
                    i9 = i12;
                    if (i9 < this.componentCount) {
                        int i13 = i8 + i6;
                        if (i9 < i13) {
                            removeCompRange(i9, i13);
                            while (i7 < length) {
                                ReferenceCountUtil.safeRelease(byteBufArr[i7]);
                                i7++;
                            }
                        }
                        updateComponentOffsets(i9);
                    }
                    if (z5 && i9 > i6 && i9 <= this.componentCount) {
                        int i14 = this.writerIndex;
                        Component[] componentArr = this.components;
                        this.writerIndex = i14 + (componentArr[i9 - 1].endOffset - componentArr[i6].offset);
                    }
                    throw th;
                }
            }
            if (i11 < this.componentCount) {
                int i15 = i8 + i6;
                if (i11 < i15) {
                    removeCompRange(i11, i15);
                    while (i7 < length) {
                        ReferenceCountUtil.safeRelease(byteBufArr[i7]);
                        i7++;
                    }
                }
                updateComponentOffsets(i11);
            }
            if (z5 && i11 > i6 && i11 <= this.componentCount) {
                int i16 = this.writerIndex;
                Component[] componentArr2 = this.components;
                this.writerIndex = i16 + (componentArr2[i11 - 1].endOffset - componentArr2[i6].offset);
            }
            return this;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void checkComponentIndex(int i6) {
        ensureAccessible();
        if (i6 < 0 || i6 > this.componentCount) {
            throw new IndexOutOfBoundsException(String.format("cIndex: %d (expected: >= 0 && <= numComponents(%d))", Integer.valueOf(i6), Integer.valueOf(this.componentCount)));
        }
    }

    private void clearComps() {
        removeCompRange(0, this.componentCount);
    }

    private void copyTo(int i6, int i7, int i8, ByteBuf byteBuf) {
        int i9 = 0;
        while (i7 > 0) {
            Component component = this.components[i8];
            int min = Math.min(i7, component.endOffset - i6);
            component.buf.getBytes(component.idx(i6), byteBuf, i9, min);
            i6 += min;
            i9 += min;
            i7 -= min;
            i8++;
        }
        byteBuf.writerIndex(byteBuf.capacity());
    }

    public CompositeByteBuf addComponent(ByteBuf byteBuf) {
        return addComponent(false, byteBuf);
    }

    public CompositeByteBuf addComponents(ByteBuf... byteBufArr) {
        return addComponents(false, byteBufArr);
    }

    public CompositeByteBuf consolidate() {
        ensureAccessible();
        int i6 = this.componentCount;
        if (i6 <= 1) {
            return this;
        }
        int i7 = this.components[i6 - 1].endOffset;
        ByteBuf allocBuffer = allocBuffer(i7);
        for (int i8 = 0; i8 < i6; i8++) {
            this.components[i8].transferTo(allocBuffer);
        }
        this.lastAccessed = null;
        this.components[0] = new Component(allocBuffer, 0, 0, i7, allocBuffer);
        removeCompRange(1, i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int forEachByteAsc0(int i6, int i7, ByteProcessor byteProcessor) throws Exception {
        if (i7 <= i6) {
            return -1;
        }
        int componentIndex0 = toComponentIndex0(i6);
        int i8 = i7 - i6;
        while (i8 > 0) {
            Component component = this.components[componentIndex0];
            if (component.offset != component.endOffset) {
                ByteBuf byteBuf = component.buf;
                int idx = component.idx(i6);
                int min = Math.min(i8, component.endOffset - i6);
                int forEachByteAsc0 = byteBuf instanceof AbstractByteBuf ? ((AbstractByteBuf) byteBuf).forEachByteAsc0(idx, idx + min, byteProcessor) : byteBuf.forEachByte(idx, min, byteProcessor);
                if (forEachByteAsc0 != -1) {
                    return forEachByteAsc0 - component.adjustment;
                }
                i6 += min;
                i8 -= min;
            }
            componentIndex0++;
        }
        return -1;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int forEachByteDesc0(int i6, int i7, ByteProcessor byteProcessor) throws Exception {
        if (i7 > i6) {
            return -1;
        }
        int componentIndex0 = toComponentIndex0(i6);
        int i8 = (i6 + 1) - i7;
        while (i8 > 0) {
            Component component = this.components[componentIndex0];
            if (component.offset != component.endOffset) {
                ByteBuf byteBuf = component.buf;
                int idx = component.idx(i8 + i7);
                int min = Math.min(i8, idx);
                int i9 = idx - min;
                int forEachByteDesc0 = byteBuf instanceof AbstractByteBuf ? ((AbstractByteBuf) byteBuf).forEachByteDesc0(idx - 1, i9, byteProcessor) : byteBuf.forEachByteDesc(i9, min, byteProcessor);
                if (forEachByteDesc0 != -1) {
                    return forEachByteDesc0 - component.adjustment;
                }
                i8 -= min;
            }
            componentIndex0--;
        }
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i6, int i7) {
        checkIndex(i6, i7);
        if (i7 == 0) {
            return new ByteBuffer[]{EMPTY_NIO_BUFFER};
        }
        RecyclableArrayList newInstance = RecyclableArrayList.newInstance(this.componentCount);
        try {
            int componentIndex0 = toComponentIndex0(i6);
            while (i7 > 0) {
                Component component = this.components[componentIndex0];
                ByteBuf byteBuf = component.buf;
                int min = Math.min(i7, component.endOffset - i6);
                int nioBufferCount = byteBuf.nioBufferCount();
                if (nioBufferCount == 0) {
                    throw new UnsupportedOperationException();
                }
                if (nioBufferCount != 1) {
                    Collections.addAll(newInstance, byteBuf.nioBuffers(component.idx(i6), min));
                } else {
                    newInstance.add(byteBuf.nioBuffer(component.idx(i6), min));
                }
                i6 += min;
                i7 -= min;
                componentIndex0++;
            }
            ByteBuffer[] byteBufferArr = (ByteBuffer[]) newInstance.toArray(new ByteBuffer[0]);
            newInstance.recycle();
            return byteBufferArr;
        } catch (Throwable th) {
            newInstance.recycle();
            throw th;
        }
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf touch() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    private ByteBuf allocBuffer(int i6) {
        return this.direct ? alloc().directBuffer(i6) : alloc().heapBuffer(i6);
    }

    private void consolidateIfNeeded() {
        int i6 = this.componentCount;
        if (i6 > this.maxNumComponents) {
            int i7 = this.components[i6 - 1].endOffset;
            ByteBuf allocBuffer = allocBuffer(i7);
            this.lastAccessed = null;
            for (int i8 = 0; i8 < i6; i8++) {
                this.components[i8].transferTo(allocBuffer);
            }
            this.components[0] = new Component(allocBuffer, 0, 0, i7, allocBuffer);
            removeCompRange(1, i6);
        }
    }

    private Component findComponent(int i6) {
        Component component = this.lastAccessed;
        if (component == null || i6 < component.offset || i6 >= component.endOffset) {
            checkIndex(i6);
            return findIt(i6);
        }
        ensureAccessible();
        return component;
    }

    private Component findComponent0(int i6) {
        Component component = this.lastAccessed;
        return (component == null || i6 < component.offset || i6 >= component.endOffset) ? findIt(i6) : component;
    }

    private Component findIt(int i6) {
        int i7 = this.componentCount;
        int i8 = 0;
        while (i8 <= i7) {
            int i9 = (i8 + i7) >>> 1;
            Component component = this.components[i9];
            if (i6 >= component.endOffset) {
                i8 = i9 + 1;
            } else {
                if (i6 >= component.offset) {
                    this.lastAccessed = component;
                    return component;
                }
                i7 = i9 - 1;
            }
        }
        throw new Error("should not reach here");
    }

    private static Component[] newCompArray(int i6, int i7) {
        return new Component[Math.max(i6, Math.min(16, i7))];
    }

    private Component newComponent(ByteBuf byteBuf, int i6) {
        int i7;
        ByteBuf byteBuf2;
        int i8;
        ByteBuf unwrap;
        if (AbstractByteBuf.checkAccessible && !byteBuf.isAccessible()) {
            throw new IllegalReferenceCountException(0);
        }
        int readerIndex = byteBuf.readerIndex();
        int readableBytes = byteBuf.readableBytes();
        if (byteBuf instanceof AbstractUnpooledSlicedByteBuf) {
            i8 = readerIndex + ((AbstractUnpooledSlicedByteBuf) byteBuf).idx(0);
            unwrap = byteBuf.unwrap();
        } else {
            if (!(byteBuf instanceof PooledSlicedByteBuf)) {
                i7 = readerIndex;
                byteBuf2 = null;
                return new Component(byteBuf.order(ByteOrder.BIG_ENDIAN), i7, i6, readableBytes, byteBuf2);
            }
            i8 = readerIndex + ((PooledSlicedByteBuf) byteBuf).adjustment;
            unwrap = byteBuf.unwrap();
        }
        byteBuf2 = byteBuf;
        i7 = i8;
        byteBuf = unwrap;
        return new Component(byteBuf.order(ByteOrder.BIG_ENDIAN), i7, i6, readableBytes, byteBuf2);
    }

    private void removeComp(int i6) {
        removeCompRange(i6, i6 + 1);
    }

    private void removeCompRange(int i6, int i7) {
        if (i6 >= i7) {
            return;
        }
        int i8 = this.componentCount;
        if (i7 < i8) {
            Component[] componentArr = this.components;
            System.arraycopy(componentArr, i7, componentArr, i6, i8 - i7);
        }
        int i9 = (i8 - i7) + i6;
        for (int i10 = i9; i10 < i8; i10++) {
            this.components[i10] = null;
        }
        this.componentCount = i9;
    }

    private void shiftComps(int i6, int i7) {
        Component[] componentArr;
        int i8 = this.componentCount;
        int i9 = i8 + i7;
        Component[] componentArr2 = this.components;
        if (i9 > componentArr2.length) {
            int max = Math.max((i8 >> 1) + i8, i9);
            if (i6 == i8) {
                componentArr = (Component[]) Arrays.copyOf(this.components, max, Component[].class);
            } else {
                Component[] componentArr3 = new Component[max];
                if (i6 > 0) {
                    System.arraycopy(this.components, 0, componentArr3, 0, i6);
                }
                if (i6 < i8) {
                    System.arraycopy(this.components, i6, componentArr3, i7 + i6, i8 - i6);
                }
                componentArr = componentArr3;
            }
            this.components = componentArr;
        } else if (i6 < i8) {
            System.arraycopy(componentArr2, i6, componentArr2, i7 + i6, i8 - i6);
        }
        this.componentCount = i9;
    }

    private int toComponentIndex0(int i6) {
        int i7 = this.componentCount;
        int i8 = 0;
        if (i6 == 0) {
            for (int i9 = 0; i9 < i7; i9++) {
                if (this.components[i9].endOffset > 0) {
                    return i9;
                }
            }
        }
        if (i7 <= 2) {
            return (i7 == 1 || i6 < this.components[0].endOffset) ? 0 : 1;
        }
        while (i8 <= i7) {
            int i10 = (i8 + i7) >>> 1;
            Component component = this.components[i10];
            if (i6 >= component.endOffset) {
                i8 = i10 + 1;
            } else {
                if (i6 >= component.offset) {
                    return i10;
                }
                i7 = i10 - 1;
            }
        }
        throw new Error("should not reach here");
    }

    private void updateComponentOffsets(int i6) {
        int i7 = this.componentCount;
        if (i7 <= i6) {
            return;
        }
        int i8 = i6 > 0 ? this.components[i6 - 1].endOffset : 0;
        while (i6 < i7) {
            Component component = this.components[i6];
            component.reposition(i8);
            i8 = component.endOffset;
            i6++;
        }
    }

    public CompositeByteBuf addComponent(int i6, ByteBuf byteBuf) {
        return addComponent(false, i6, byteBuf);
    }

    public CompositeByteBuf addComponents(Iterable<ByteBuf> iterable) {
        return addComponents(false, iterable);
    }

    public CompositeByteBuf addFlattenedComponents(boolean z5, ByteBuf byteBuf) {
        int i6;
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        int readerIndex = byteBuf.readerIndex();
        int writerIndex = byteBuf.writerIndex();
        if (readerIndex == writerIndex) {
            byteBuf.release();
            return this;
        }
        if (!(byteBuf instanceof CompositeByteBuf)) {
            addComponent0(z5, this.componentCount, byteBuf);
            consolidateIfNeeded();
            return this;
        }
        CompositeByteBuf compositeByteBuf = (CompositeByteBuf) byteBuf;
        int i7 = writerIndex - readerIndex;
        compositeByteBuf.checkIndex(readerIndex, i7);
        Component[] componentArr = compositeByteBuf.components;
        int i8 = this.componentCount;
        int i9 = this.writerIndex;
        try {
            int componentIndex0 = compositeByteBuf.toComponentIndex0(readerIndex);
            int capacity = capacity();
            while (true) {
                Component component = componentArr[componentIndex0];
                int max = Math.max(readerIndex, component.offset);
                int min = Math.min(writerIndex, component.endOffset);
                int i10 = min - max;
                if (i10 > 0) {
                    i6 = min;
                    addComp(this.componentCount, new Component(component.buf.retain(), component.idx(max), capacity, i10, null));
                } else {
                    i6 = min;
                }
                if (writerIndex == i6) {
                    break;
                }
                capacity += i10;
                componentIndex0++;
            }
            if (z5) {
                this.writerIndex = i7 + i9;
            }
            consolidateIfNeeded();
            byteBuf.release();
            return this;
        } catch (Throwable th) {
            if (z5) {
                this.writerIndex = i9;
            }
            for (int i11 = this.componentCount - 1; i11 >= i8; i11--) {
                this.components[i11].free();
                removeComp(i11);
            }
            throw th;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        int i6 = this.componentCount;
        if (i6 == 0) {
            return EmptyArrays.EMPTY_BYTES;
        }
        if (i6 == 1) {
            return this.components[0].buf.array();
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        int i6 = this.componentCount;
        if (i6 == 0) {
            return 0;
        }
        if (i6 != 1) {
            throw new UnsupportedOperationException();
        }
        Component component = this.components[0];
        return component.idx(component.buf.arrayOffset());
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        int i6 = this.componentCount;
        if (i6 > 0) {
            return this.components[i6 - 1].endOffset;
        }
        return 0;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf clear() {
        super.clear();
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected void deallocate() {
        if (this.freed) {
            return;
        }
        this.freed = true;
        int i6 = this.componentCount;
        for (int i7 = 0; i7 < i6; i7++) {
            this.components[i7].free();
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf discardReadBytes() {
        ensureAccessible();
        int readerIndex = readerIndex();
        if (readerIndex == 0) {
            return this;
        }
        int writerIndex = writerIndex();
        if (readerIndex == writerIndex && writerIndex == capacity()) {
            int i6 = this.componentCount;
            for (int i7 = 0; i7 < i6; i7++) {
                this.components[i7].free();
            }
            this.lastAccessed = null;
            clearComps();
            setIndex(0, 0);
            adjustMarkers(readerIndex);
            return this;
        }
        int i8 = this.componentCount;
        Component component = null;
        int i9 = 0;
        while (i9 < i8) {
            component = this.components[i9];
            if (component.endOffset > readerIndex) {
                break;
            }
            component.free();
            i9++;
        }
        int i10 = readerIndex - component.offset;
        component.offset = 0;
        component.endOffset -= readerIndex;
        component.adjustment += readerIndex;
        ByteBuf byteBuf = component.slice;
        if (byteBuf != null) {
            component.slice = byteBuf.slice(i10, component.length());
        }
        Component component2 = this.lastAccessed;
        if (component2 != null && component2.endOffset <= readerIndex) {
            this.lastAccessed = null;
        }
        removeCompRange(0, i9);
        updateComponentOffsets(0);
        setIndex(0, writerIndex - readerIndex);
        adjustMarkers(readerIndex);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf discardSomeReadBytes() {
        return discardReadComponents();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf ensureWritable(int i6) {
        super.ensureWritable(i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        int i6 = this.componentCount;
        if (i6 == 0) {
            return true;
        }
        if (i6 != 1) {
            return false;
        }
        return this.components[0].buf.hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        int i6 = this.componentCount;
        if (i6 == 0) {
            return Unpooled.EMPTY_BUFFER.hasMemoryAddress();
        }
        if (i6 != 1) {
            return false;
        }
        return this.components[0].buf.hasMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i6, int i7) {
        int i8 = this.componentCount;
        if (i8 == 0) {
            return EMPTY_NIO_BUFFER;
        }
        if (i8 == 1) {
            return this.components[0].internalNioBuffer(i6, i7);
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf
    boolean isAccessible() {
        return !this.freed;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        int i6 = this.componentCount;
        if (i6 == 0) {
            return false;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (!this.components[i7].buf.isDirect()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf markReaderIndex() {
        super.markReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf markWriterIndex() {
        super.markWriterIndex();
        return this;
    }

    public int maxNumComponents() {
        return this.maxNumComponents;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        int i6 = this.componentCount;
        if (i6 == 0) {
            return Unpooled.EMPTY_BUFFER.memoryAddress();
        }
        if (i6 != 1) {
            throw new UnsupportedOperationException();
        }
        return this.components[0].buf.memoryAddress() + r0.adjustment;
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        int i6 = this.componentCount;
        if (i6 == 0) {
            return 1;
        }
        if (i6 == 1) {
            return this.components[0].buf.nioBufferCount();
        }
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            i7 += this.components[i8].buf.nioBufferCount();
        }
        return i7;
    }

    public int numComponents() {
        return this.componentCount;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readerIndex(int i6) {
        super.readerIndex(i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf resetReaderIndex() {
        super.resetReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf resetWriterIndex() {
        super.resetWriterIndex();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBoolean(int i6, boolean z5) {
        return setByte(i6, z5 ? 1 : 0);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setByte(int i6, int i7) {
        Component findComponent = findComponent(i6);
        findComponent.buf.setByte(findComponent.idx(i6), i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setChar(int i6, int i7) {
        return setShort(i6, i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setDouble(int i6, double d6) {
        return setLong(i6, Double.doubleToRawLongBits(d6));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setFloat(int i6, float f6) {
        return setInt(i6, Float.floatToRawIntBits(f6));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setIndex(int i6, int i7) {
        super.setIndex(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setInt(int i6, int i7) {
        checkIndex(i6, 4);
        _setInt(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setLong(int i6, long j6) {
        checkIndex(i6, 8);
        _setLong(i6, j6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setMedium(int i6, int i7) {
        checkIndex(i6, 3);
        _setMedium(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setShort(int i6, int i7) {
        checkIndex(i6, 2);
        _setShort(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setZero(int i6, int i7) {
        super.setZero(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf skipBytes(int i6) {
        super.skipBytes(i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf touch(Object obj) {
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBoolean(boolean z5) {
        writeByte(z5 ? 1 : 0);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeByte(int i6) {
        ensureWritable0(1);
        int i7 = this.writerIndex;
        this.writerIndex = i7 + 1;
        _setByte(i7, i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeChar(int i6) {
        super.writeShort(i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeDouble(double d6) {
        super.writeLong(Double.doubleToRawLongBits(d6));
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeFloat(float f6) {
        super.writeInt(Float.floatToRawIntBits(f6));
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeInt(int i6) {
        super.writeInt(i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeLong(long j6) {
        super.writeLong(j6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeMedium(int i6) {
        super.writeMedium(i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeShort(int i6) {
        super.writeShort(i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeZero(int i6) {
        super.writeZero(i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writerIndex(int i6) {
        super.writerIndex(i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i6) {
        Component findComponent0 = findComponent0(i6);
        return findComponent0.buf.getByte(findComponent0.idx(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i6) {
        Component findComponent0 = findComponent0(i6);
        if (i6 + 4 <= findComponent0.endOffset) {
            return findComponent0.buf.getInt(findComponent0.idx(i6));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getShort(i6 + 2) & j1.f43986d) | ((_getShort(i6) & j1.f43986d) << 16);
        }
        return ((_getShort(i6 + 2) & j1.f43986d) << 16) | (_getShort(i6) & j1.f43986d);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i6) {
        Component findComponent0 = findComponent0(i6);
        if (i6 + 4 <= findComponent0.endOffset) {
            return findComponent0.buf.getIntLE(findComponent0.idx(i6));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getShortLE(i6 + 2) & j1.f43986d) << 16) | (_getShortLE(i6) & j1.f43986d);
        }
        return (_getShortLE(i6 + 2) & j1.f43986d) | ((_getShortLE(i6) & j1.f43986d) << 16);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i6) {
        Component findComponent0 = findComponent0(i6);
        if (i6 + 8 <= findComponent0.endOffset) {
            return findComponent0.buf.getLong(findComponent0.idx(i6));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getInt(i6) & 4294967295L) << 32) | (4294967295L & _getInt(i6 + 4));
        }
        return (_getInt(i6) & 4294967295L) | ((4294967295L & _getInt(i6 + 4)) << 32);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i6) {
        Component findComponent0 = findComponent0(i6);
        if (i6 + 8 <= findComponent0.endOffset) {
            return findComponent0.buf.getLongLE(findComponent0.idx(i6));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getIntLE(i6) & 4294967295L) | ((4294967295L & _getIntLE(i6 + 4)) << 32);
        }
        return ((_getIntLE(i6) & 4294967295L) << 32) | (4294967295L & _getIntLE(i6 + 4));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i6) {
        Component findComponent0 = findComponent0(i6);
        if (i6 + 2 <= findComponent0.endOffset) {
            return findComponent0.buf.getShort(findComponent0.idx(i6));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) ((_getByte(i6 + 1) & 255) | ((_getByte(i6) & 255) << 8));
        }
        return (short) (((_getByte(i6 + 1) & 255) << 8) | (_getByte(i6) & 255));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i6) {
        Component findComponent0 = findComponent0(i6);
        if (i6 + 2 <= findComponent0.endOffset) {
            return findComponent0.buf.getShortLE(findComponent0.idx(i6));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) (((_getByte(i6 + 1) & 255) << 8) | (_getByte(i6) & 255));
        }
        return (short) ((_getByte(i6 + 1) & 255) | ((_getByte(i6) & 255) << 8));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i6) {
        Component findComponent0 = findComponent0(i6);
        if (i6 + 3 <= findComponent0.endOffset) {
            return findComponent0.buf.getUnsignedMedium(findComponent0.idx(i6));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getByte(i6 + 2) & 255) | ((_getShort(i6) & j1.f43986d) << 8);
        }
        return ((_getByte(i6 + 2) & 255) << 16) | (_getShort(i6) & j1.f43986d);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i6) {
        Component findComponent0 = findComponent0(i6);
        if (i6 + 3 <= findComponent0.endOffset) {
            return findComponent0.buf.getUnsignedMediumLE(findComponent0.idx(i6));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getByte(i6 + 2) & 255) << 16) | (_getShortLE(i6) & j1.f43986d);
        }
        return (_getByte(i6 + 2) & 255) | ((_getShortLE(i6) & j1.f43986d) << 8);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i6, int i7) {
        Component findComponent0 = findComponent0(i6);
        findComponent0.buf.setByte(findComponent0.idx(i6), i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i6, int i7) {
        Component findComponent0 = findComponent0(i6);
        if (i6 + 4 <= findComponent0.endOffset) {
            findComponent0.buf.setInt(findComponent0.idx(i6), i7);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShort(i6, (short) (i7 >>> 16));
            _setShort(i6 + 2, (short) i7);
        } else {
            _setShort(i6, (short) i7);
            _setShort(i6 + 2, (short) (i7 >>> 16));
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i6, int i7) {
        Component findComponent0 = findComponent0(i6);
        if (i6 + 4 <= findComponent0.endOffset) {
            findComponent0.buf.setIntLE(findComponent0.idx(i6), i7);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShortLE(i6, (short) i7);
            _setShortLE(i6 + 2, (short) (i7 >>> 16));
        } else {
            _setShortLE(i6, (short) (i7 >>> 16));
            _setShortLE(i6 + 2, (short) i7);
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i6, long j6) {
        Component findComponent0 = findComponent0(i6);
        if (i6 + 8 <= findComponent0.endOffset) {
            findComponent0.buf.setLong(findComponent0.idx(i6), j6);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setInt(i6, (int) (j6 >>> 32));
            _setInt(i6 + 4, (int) j6);
        } else {
            _setInt(i6, (int) j6);
            _setInt(i6 + 4, (int) (j6 >>> 32));
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i6, long j6) {
        Component findComponent0 = findComponent0(i6);
        if (i6 + 8 <= findComponent0.endOffset) {
            findComponent0.buf.setLongLE(findComponent0.idx(i6), j6);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setIntLE(i6, (int) j6);
            _setIntLE(i6 + 4, (int) (j6 >>> 32));
        } else {
            _setIntLE(i6, (int) (j6 >>> 32));
            _setIntLE(i6 + 4, (int) j6);
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i6, int i7) {
        Component findComponent0 = findComponent0(i6);
        if (i6 + 3 <= findComponent0.endOffset) {
            findComponent0.buf.setMedium(findComponent0.idx(i6), i7);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShort(i6, (short) (i7 >> 8));
            _setByte(i6 + 2, (byte) i7);
        } else {
            _setShort(i6, (short) i7);
            _setByte(i6 + 2, (byte) (i7 >>> 16));
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i6, int i7) {
        Component findComponent0 = findComponent0(i6);
        if (i6 + 3 <= findComponent0.endOffset) {
            findComponent0.buf.setMediumLE(findComponent0.idx(i6), i7);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShortLE(i6, (short) i7);
            _setByte(i6 + 2, (byte) (i7 >>> 16));
        } else {
            _setShortLE(i6, (short) (i7 >> 8));
            _setByte(i6 + 2, (byte) i7);
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i6, int i7) {
        Component findComponent0 = findComponent0(i6);
        if (i6 + 2 <= findComponent0.endOffset) {
            findComponent0.buf.setShort(findComponent0.idx(i6), i7);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setByte(i6, (byte) (i7 >>> 8));
            _setByte(i6 + 1, (byte) i7);
        } else {
            _setByte(i6, (byte) i7);
            _setByte(i6 + 1, (byte) (i7 >>> 8));
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i6, int i7) {
        Component findComponent0 = findComponent0(i6);
        if (i6 + 2 <= findComponent0.endOffset) {
            findComponent0.buf.setShortLE(findComponent0.idx(i6), i7);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setByte(i6, (byte) i7);
            _setByte(i6 + 1, (byte) (i7 >>> 8));
        } else {
            _setByte(i6, (byte) (i7 >>> 8));
            _setByte(i6 + 1, (byte) i7);
        }
    }

    public CompositeByteBuf addComponent(boolean z5, ByteBuf byteBuf) {
        return addComponent(z5, this.componentCount, byteBuf);
    }

    public CompositeByteBuf addComponents(boolean z5, ByteBuf... byteBufArr) {
        ObjectUtil.checkNotNull(byteBufArr, "buffers");
        addComponents0(z5, this.componentCount, byteBufArr, 0);
        consolidateIfNeeded();
        return this;
    }

    public ByteBuf component(int i6) {
        checkComponentIndex(i6);
        return this.components[i6].duplicate();
    }

    public ByteBuf componentAtOffset(int i6) {
        return findComponent(i6).duplicate();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i6, int i7) {
        checkIndex(i6, i7);
        ByteBuf allocBuffer = allocBuffer(i7);
        if (i7 != 0) {
            copyTo(i6, i7, toComponentIndex0(i6), allocBuffer);
        }
        return allocBuffer;
    }

    public List<ByteBuf> decompose(int i6, int i7) {
        checkIndex(i6, i7);
        if (i7 == 0) {
            return Collections.EMPTY_LIST;
        }
        int componentIndex0 = toComponentIndex0(i6);
        Component component = this.components[componentIndex0];
        ByteBuf slice = component.buf.slice(component.idx(i6), Math.min(component.endOffset - i6, i7));
        int readableBytes = i7 - slice.readableBytes();
        if (readableBytes == 0) {
            return Collections.singletonList(slice);
        }
        ArrayList arrayList = new ArrayList(this.componentCount - componentIndex0);
        arrayList.add(slice);
        do {
            componentIndex0++;
            Component component2 = this.components[componentIndex0];
            ByteBuf slice2 = component2.buf.slice(component2.idx(component2.offset), Math.min(component2.length(), readableBytes));
            readableBytes -= slice2.readableBytes();
            arrayList.add(slice2);
        } while (readableBytes > 0);
        return arrayList;
    }

    public CompositeByteBuf discardReadComponents() {
        ensureAccessible();
        int readerIndex = readerIndex();
        if (readerIndex != 0) {
            int writerIndex = writerIndex();
            if (readerIndex == writerIndex && writerIndex == capacity()) {
                int i6 = this.componentCount;
                for (int i7 = 0; i7 < i6; i7++) {
                    this.components[i7].free();
                }
                this.lastAccessed = null;
                clearComps();
                setIndex(0, 0);
                adjustMarkers(readerIndex);
                return this;
            }
            int i8 = this.componentCount;
            Component component = null;
            int i9 = 0;
            while (i9 < i8) {
                component = this.components[i9];
                if (component.endOffset > readerIndex) {
                    break;
                }
                component.free();
                i9++;
            }
            if (i9 != 0) {
                Component component2 = this.lastAccessed;
                if (component2 != null && component2.endOffset <= readerIndex) {
                    this.lastAccessed = null;
                }
                removeCompRange(0, i9);
                int i10 = component.offset;
                updateComponentOffsets(0);
                setIndex(readerIndex - i10, writerIndex - i10);
                adjustMarkers(i10);
                return this;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i6) {
        Component findComponent = findComponent(i6);
        return findComponent.buf.getByte(findComponent.idx(i6));
    }

    public ByteBuf internalComponent(int i6) {
        checkComponentIndex(i6);
        return this.components[i6].slice();
    }

    public ByteBuf internalComponentAtOffset(int i6) {
        return findComponent(i6).slice();
    }

    public Iterator<ByteBuf> iterator() {
        ensureAccessible();
        if (this.componentCount == 0) {
            return EMPTY_ITERATOR;
        }
        return new CompositeByteBufIterator();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i6, int i7) {
        checkIndex(i6, i7);
        int i8 = this.componentCount;
        if (i8 != 0) {
            if (i8 == 1) {
                Component component = this.components[0];
                ByteBuf byteBuf = component.buf;
                if (byteBuf.nioBufferCount() == 1) {
                    return byteBuf.nioBuffer(component.idx(i6), i7);
                }
            }
            ByteBuffer[] nioBuffers = nioBuffers(i6, i7);
            if (nioBuffers.length == 1) {
                return nioBuffers[0];
            }
            ByteBuffer order = ByteBuffer.allocate(i7).order(order());
            for (ByteBuffer byteBuffer : nioBuffers) {
                order.put(byteBuffer);
            }
            order.flip();
            return order;
        }
        return EMPTY_NIO_BUFFER;
    }

    public CompositeByteBuf removeComponent(int i6) {
        checkComponentIndex(i6);
        Component component = this.components[i6];
        if (this.lastAccessed == component) {
            this.lastAccessed = null;
        }
        component.free();
        removeComp(i6);
        if (component.length() > 0) {
            updateComponentOffsets(i6);
        }
        return this;
    }

    public CompositeByteBuf removeComponents(int i6, int i7) {
        checkComponentIndex(i6, i7);
        if (i7 != 0) {
            int i8 = i7 + i6;
            boolean z5 = false;
            for (int i9 = i6; i9 < i8; i9++) {
                Component component = this.components[i9];
                if (component.length() > 0) {
                    z5 = true;
                }
                if (this.lastAccessed == component) {
                    this.lastAccessed = null;
                }
                component.free();
            }
            removeCompRange(i6, i8);
            if (z5) {
                updateComponentOffsets(i6);
            }
        }
        return this;
    }

    public int toByteIndex(int i6) {
        checkComponentIndex(i6);
        return this.components[i6].offset;
    }

    public int toComponentIndex(int i6) {
        checkIndex(i6);
        return toComponentIndex0(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public String toString() {
        return super.toString().substring(0, r0.length() - 1) + ", components=" + this.componentCount + ')';
    }

    public CompositeByteBuf addComponent(boolean z5, int i6, ByteBuf byteBuf) {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        addComponent0(z5, i6, byteBuf);
        consolidateIfNeeded();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf capacity(int i6) {
        checkNewCapacity(i6);
        int i7 = this.componentCount;
        int capacity = capacity();
        if (i6 > capacity) {
            int i8 = i6 - capacity;
            addComponent0(false, i7, allocBuffer(i8).setIndex(0, i8));
            if (this.componentCount >= this.maxNumComponents) {
                consolidateIfNeeded();
                return this;
            }
        } else if (i6 < capacity) {
            this.lastAccessed = null;
            int i9 = i7 - 1;
            int i10 = capacity - i6;
            while (true) {
                if (i9 < 0) {
                    break;
                }
                Component component = this.components[i9];
                int length = component.length();
                if (i10 < length) {
                    component.endOffset -= i10;
                    ByteBuf byteBuf = component.slice;
                    if (byteBuf != null) {
                        component.slice = byteBuf.slice(0, component.length());
                    }
                } else {
                    component.free();
                    i10 -= length;
                    i9--;
                }
            }
            removeCompRange(i9 + 1, i7);
            if (readerIndex() > i6) {
                setIndex0(i6, i6);
                return this;
            }
            if (this.writerIndex > i6) {
                this.writerIndex = i6;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf retain(int i6) {
        super.retain(i6);
        return this;
    }

    private void checkComponentIndex(int i6, int i7) {
        ensureAccessible();
        if (i6 < 0 || i6 + i7 > this.componentCount) {
            throw new IndexOutOfBoundsException(String.format("cIndex: %d, numComponents: %d (expected: cIndex >= 0 && cIndex + numComponents <= totalNumComponents(%d))", Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(this.componentCount)));
        }
    }

    public CompositeByteBuf addComponents(boolean z5, Iterable<ByteBuf> iterable) {
        return addComponents(z5, this.componentCount, iterable);
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf retain() {
        super.retain();
        return this;
    }

    public CompositeByteBuf addComponents(int i6, ByteBuf... byteBufArr) {
        ObjectUtil.checkNotNull(byteBufArr, "buffers");
        addComponents0(false, i6, byteBufArr, 0);
        consolidateIfNeeded();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i6, byte[] bArr, int i7, int i8) {
        checkSrcIndex(i6, i8, i7, bArr.length);
        if (i8 != 0) {
            int componentIndex0 = toComponentIndex0(i6);
            while (i8 > 0) {
                Component component = this.components[componentIndex0];
                int min = Math.min(i8, component.endOffset - i6);
                component.buf.setBytes(component.idx(i6), bArr, i7, min);
                i6 += min;
                i7 += min;
                i8 -= min;
                componentIndex0++;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf) {
        super.writeBytes(byteBuf, byteBuf.readableBytes());
        return this;
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z5, int i6) {
        this(byteBufAllocator, z5, i6, 0);
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, byte[] bArr, int i7, int i8) {
        checkDstIndex(i6, i8, i7, bArr.length);
        if (i8 != 0) {
            int componentIndex0 = toComponentIndex0(i6);
            while (i8 > 0) {
                Component component = this.components[componentIndex0];
                int min = Math.min(i8, component.endOffset - i6);
                component.buf.getBytes(component.idx(i6), bArr, i7, min);
                i6 += min;
                i7 += min;
                i8 -= min;
                componentIndex0++;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf) {
        super.readBytes(byteBuf, byteBuf.writableBytes());
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i6) {
        super.writeBytes(byteBuf, i6);
        return this;
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z5, int i6, ByteBuf... byteBufArr) {
        this(byteBufAllocator, z5, i6, byteBufArr, 0);
    }

    public CompositeByteBuf consolidate(int i6, int i7) {
        checkComponentIndex(i6, i7);
        if (i7 <= 1) {
            return this;
        }
        int i8 = i7 + i6;
        Component[] componentArr = this.components;
        int i9 = componentArr[i8 - 1].endOffset - componentArr[i6].offset;
        ByteBuf allocBuffer = allocBuffer(i9);
        for (int i10 = i6; i10 < i8; i10++) {
            this.components[i10].transferTo(allocBuffer);
        }
        this.lastAccessed = null;
        removeCompRange(i6 + 1, i8);
        this.components[i6] = new Component(allocBuffer, 0, 0, i9, allocBuffer);
        updateComponentOffsets(i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i6) {
        super.readBytes(byteBuf, i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i6, int i7) {
        super.writeBytes(byteBuf, i6, i7);
        return this;
    }

    CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z5, int i6, ByteBuf[] byteBufArr, int i7) {
        this(byteBufAllocator, z5, i6, byteBufArr.length - i7);
        addComponents0(false, 0, byteBufArr, i7);
        consolidateIfNeeded();
        setIndex0(0, capacity());
    }

    public CompositeByteBuf addComponents(int i6, Iterable<ByteBuf> iterable) {
        return addComponents(false, i6, iterable);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i6, int i7) {
        super.readBytes(byteBuf, i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] bArr) {
        super.writeBytes(bArr, 0, bArr.length);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CompositeByteBuf addComponents(boolean z5, int i6, Iterable<ByteBuf> iterable) {
        ByteBuf byteBuf;
        if (iterable instanceof ByteBuf) {
            return addComponent(z5, i6, (ByteBuf) iterable);
        }
        ObjectUtil.checkNotNull(iterable, "buffers");
        Iterator it = iterable.iterator();
        try {
            checkComponentIndex(i6);
            while (it.hasNext() && (byteBuf = (ByteBuf) it.next()) != null) {
                i6 = Math.min(addComponent0(z5, i6, byteBuf) + 1, this.componentCount);
            }
            consolidateIfNeeded();
            return this;
        } finally {
            while (it.hasNext()) {
                ReferenceCountUtil.safeRelease(it.next());
            }
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] bArr) {
        super.readBytes(bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] bArr, int i6, int i7) {
        super.writeBytes(bArr, i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] bArr, int i6, int i7) {
        super.readBytes(bArr, i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i6, ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int remaining = byteBuffer.remaining();
        checkIndex(i6, remaining);
        if (remaining == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i6);
        while (remaining > 0) {
            try {
                Component component = this.components[componentIndex0];
                int min = Math.min(remaining, component.endOffset - i6);
                byteBuffer.limit(byteBuffer.position() + min);
                component.buf.setBytes(component.idx(i6), byteBuffer);
                i6 += min;
                remaining -= min;
                componentIndex0++;
            } finally {
                byteBuffer.limit(limit);
            }
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuffer byteBuffer) {
        super.writeBytes(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int remaining = byteBuffer.remaining();
        checkIndex(i6, remaining);
        if (remaining == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i6);
        while (remaining > 0) {
            try {
                Component component = this.components[componentIndex0];
                int min = Math.min(remaining, component.endOffset - i6);
                byteBuffer.limit(byteBuffer.position() + min);
                component.buf.getBytes(component.idx(i6), byteBuffer);
                i6 += min;
                remaining -= min;
                componentIndex0++;
            } finally {
                byteBuffer.limit(limit);
            }
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuffer byteBuffer) {
        super.readBytes(byteBuffer);
        return this;
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z5, int i6, Iterable<ByteBuf> iterable) {
        this(byteBufAllocator, z5, i6, iterable instanceof Collection ? ((Collection) iterable).size() : 0);
        addComponents(false, 0, iterable);
        setIndex(0, capacity());
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(OutputStream outputStream, int i6) throws IOException {
        super.readBytes(outputStream, i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return nioBuffers(readerIndex(), readableBytes());
    }

    <T> CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z5, int i6, ByteWrapper<T> byteWrapper, T[] tArr, int i7) {
        this(byteBufAllocator, z5, i6, tArr.length - i7);
        addComponents0(false, 0, byteWrapper, tArr, i7);
        consolidateIfNeeded();
        setIndex(0, capacity());
    }

    private <T> int addComponents0(boolean z5, int i6, ByteWrapper<T> byteWrapper, T[] tArr, int i7) {
        int i8;
        checkComponentIndex(i6);
        int length = tArr.length;
        while (i7 < length) {
            T t5 = tArr[i7];
            if (t5 == null) {
                break;
            }
            if (!byteWrapper.isEmpty(t5) && (i6 = addComponent0(z5, i6, byteWrapper.wrap(t5)) + 1) > (i8 = this.componentCount)) {
                i6 = i8;
            }
            i7++;
        }
        return i6;
    }

    CompositeByteBuf(ByteBufAllocator byteBufAllocator) {
        super(Integer.MAX_VALUE);
        this.alloc = byteBufAllocator;
        this.direct = false;
        this.maxNumComponents = 0;
        this.components = null;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        checkSrcIndex(i6, i8, i7, byteBuf.capacity());
        if (i8 != 0) {
            int componentIndex0 = toComponentIndex0(i6);
            while (i8 > 0) {
                Component component = this.components[componentIndex0];
                int min = Math.min(i8, component.endOffset - i6);
                component.buf.setBytes(component.idx(i6), byteBuf, i7, min);
                i6 += min;
                i7 += min;
                i8 -= min;
                componentIndex0++;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        checkDstIndex(i6, i8, i7, byteBuf.capacity());
        if (i8 != 0) {
            int componentIndex0 = toComponentIndex0(i6);
            while (i8 > 0) {
                Component component = this.components[componentIndex0];
                int min = Math.min(i8, component.endOffset - i6);
                component.buf.getBytes(component.idx(i6), byteBuf, i7, min);
                i6 += min;
                i7 += min;
                i8 -= min;
                componentIndex0++;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, InputStream inputStream, int i7) throws IOException {
        checkIndex(i6, i7);
        if (i7 == 0) {
            return inputStream.read(EmptyArrays.EMPTY_BYTES);
        }
        int componentIndex0 = toComponentIndex0(i6);
        int i8 = 0;
        do {
            Component component = this.components[componentIndex0];
            int min = Math.min(i7, component.endOffset - i6);
            if (min != 0) {
                int bytes = component.buf.setBytes(component.idx(i6), inputStream, min);
                if (bytes < 0) {
                    if (i8 == 0) {
                        return -1;
                    }
                    return i8;
                }
                i6 += bytes;
                i7 -= bytes;
                i8 += bytes;
                if (bytes != min) {
                }
            }
            componentIndex0++;
        } while (i7 > 0);
        return i8;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i6, GatheringByteChannel gatheringByteChannel, int i7) throws IOException {
        if (nioBufferCount() == 1) {
            return gatheringByteChannel.write(internalNioBuffer(i6, i7));
        }
        long write = gatheringByteChannel.write(nioBuffers(i6, i7));
        if (write > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) write;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        if (nioBufferCount() == 1) {
            return fileChannel.write(internalNioBuffer(i6, i7), j6);
        }
        long j7 = 0;
        for (int i8 = 0; i8 < nioBuffers(i6, i7).length; i8++) {
            j7 += fileChannel.write(r7[i8], j6 + j7);
        }
        if (j7 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j7;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, ScatteringByteChannel scatteringByteChannel, int i7) throws IOException {
        checkIndex(i6, i7);
        if (i7 == 0) {
            return scatteringByteChannel.read(EMPTY_NIO_BUFFER);
        }
        int componentIndex0 = toComponentIndex0(i6);
        int i8 = 0;
        do {
            Component component = this.components[componentIndex0];
            int min = Math.min(i7, component.endOffset - i6);
            if (min != 0) {
                int bytes = component.buf.setBytes(component.idx(i6), scatteringByteChannel, min);
                if (bytes != 0) {
                    if (bytes >= 0) {
                        i6 += bytes;
                        i7 -= bytes;
                        i8 += bytes;
                        if (bytes != min) {
                        }
                    } else if (i8 == 0) {
                        return -1;
                    }
                }
                return i8;
            }
            componentIndex0++;
        } while (i7 > 0);
        return i8;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, OutputStream outputStream, int i7) throws IOException {
        checkIndex(i6, i7);
        if (i7 != 0) {
            int componentIndex0 = toComponentIndex0(i6);
            while (i7 > 0) {
                Component component = this.components[componentIndex0];
                int min = Math.min(i7, component.endOffset - i6);
                component.buf.getBytes(component.idx(i6), outputStream, min);
                i6 += min;
                i7 -= min;
                componentIndex0++;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        FileChannel fileChannel2;
        checkIndex(i6, i7);
        if (i7 == 0) {
            return fileChannel.read(EMPTY_NIO_BUFFER, j6);
        }
        int componentIndex0 = toComponentIndex0(i6);
        int i8 = 0;
        while (true) {
            Component component = this.components[componentIndex0];
            int min = Math.min(i7, component.endOffset - i6);
            if (min != 0) {
                fileChannel2 = fileChannel;
                int bytes = component.buf.setBytes(component.idx(i6), fileChannel2, j6 + i8, min);
                if (bytes == 0) {
                    break;
                }
                if (bytes >= 0) {
                    i6 += bytes;
                    i7 -= bytes;
                    i8 += bytes;
                    if (bytes == min) {
                        componentIndex0++;
                    }
                } else if (i8 == 0) {
                    return -1;
                }
            } else {
                componentIndex0++;
                fileChannel2 = fileChannel;
            }
            if (i7 <= 0) {
                return i8;
            }
            fileChannel = fileChannel2;
        }
        return i8;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, ByteBuf byteBuf) {
        return getBytes(i6, byteBuf, byteBuf.writableBytes());
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, ByteBuf byteBuf, int i7) {
        getBytes(i6, byteBuf, byteBuf.writerIndex(), i7);
        byteBuf.writerIndex(byteBuf.writerIndex() + i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i6, byte[] bArr) {
        return getBytes(i6, bArr, 0, bArr.length);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i6, ByteBuf byteBuf) {
        super.setBytes(i6, byteBuf, byteBuf.readableBytes());
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i6, ByteBuf byteBuf, int i7) {
        super.setBytes(i6, byteBuf, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i6, byte[] bArr) {
        return setBytes(i6, bArr, 0, bArr.length);
    }
}
