package io.netty.handler.codec;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.AbstractList;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class CodecOutputList extends AbstractList<Object> implements RandomAccess {
    private Object[] array;
    private boolean insertSinceRecycled;
    private final CodecOutputListRecycler recycler;
    private int size;
    private static final CodecOutputListRecycler NOOP_RECYCLER = new CodecOutputListRecycler() { // from class: io.netty.handler.codec.CodecOutputList.1
        @Override // io.netty.handler.codec.CodecOutputList.CodecOutputListRecycler
        public void recycle(CodecOutputList codecOutputList) {
        }
    };
    private static final FastThreadLocal<CodecOutputLists> CODEC_OUTPUT_LISTS_POOL = new FastThreadLocal<CodecOutputLists>() { // from class: io.netty.handler.codec.CodecOutputList.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public CodecOutputLists initialValue() throws Exception {
            return new CodecOutputLists(16);
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface CodecOutputListRecycler {
        void recycle(CodecOutputList codecOutputList);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class CodecOutputLists implements CodecOutputListRecycler {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int count;
        private int currentIdx;
        private final CodecOutputList[] elements;
        private final int mask;

        public CodecOutputList getOrCreate() {
            int i6 = this.count;
            if (i6 == 0) {
                return new CodecOutputList(CodecOutputList.NOOP_RECYCLER, 4);
            }
            this.count = i6 - 1;
            int i7 = (this.currentIdx - 1) & this.mask;
            CodecOutputList codecOutputList = this.elements[i7];
            this.currentIdx = i7;
            return codecOutputList;
        }

        @Override // io.netty.handler.codec.CodecOutputList.CodecOutputListRecycler
        public void recycle(CodecOutputList codecOutputList) {
            int i6 = this.currentIdx;
            this.elements[i6] = codecOutputList;
            this.currentIdx = this.mask & (i6 + 1);
            this.count++;
        }

        CodecOutputLists(int i6) {
            this.elements = new CodecOutputList[MathUtil.safeFindNextPositivePowerOfTwo(i6)];
            int i7 = 0;
            while (true) {
                CodecOutputList[] codecOutputListArr = this.elements;
                if (i7 < codecOutputListArr.length) {
                    codecOutputListArr[i7] = new CodecOutputList(this, 16);
                    i7++;
                } else {
                    this.count = codecOutputListArr.length;
                    this.currentIdx = codecOutputListArr.length;
                    this.mask = codecOutputListArr.length - 1;
                    return;
                }
            }
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        ObjectUtil.checkNotNull(obj, "element");
        try {
            insert(this.size, obj);
        } catch (IndexOutOfBoundsException unused) {
            expandArray();
            insert(this.size, obj);
        }
        this.size++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.size = 0;
    }

    void recycle() {
        for (int i6 = 0; i6 < this.size; i6++) {
            this.array[i6] = null;
        }
        this.size = 0;
        this.insertSinceRecycled = false;
        this.recycler.recycle(this);
    }

    private CodecOutputList(CodecOutputListRecycler codecOutputListRecycler, int i6) {
        this.recycler = codecOutputListRecycler;
        this.array = new Object[i6];
    }

    private void checkIndex(int i6) {
        if (i6 >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void expandArray() {
        Object[] objArr = this.array;
        int length = objArr.length << 1;
        if (length < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        this.array = objArr2;
    }

    private void insert(int i6, Object obj) {
        this.array[i6] = obj;
        this.insertSinceRecycled = true;
    }

    static CodecOutputList newInstance() {
        return CODEC_OUTPUT_LISTS_POOL.get().getOrCreate();
    }

    Object getUnsafe(int i6) {
        return this.array[i6];
    }

    boolean insertSinceRecycled() {
        return this.insertSinceRecycled;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i6, Object obj) {
        ObjectUtil.checkNotNull(obj, "element");
        checkIndex(i6);
        Object obj2 = this.array[i6];
        insert(i6, obj);
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i6) {
        checkIndex(i6);
        return this.array[i6];
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i6) {
        checkIndex(i6);
        Object[] objArr = this.array;
        Object obj = objArr[i6];
        int i7 = (this.size - i6) - 1;
        if (i7 > 0) {
            System.arraycopy(objArr, i6 + 1, objArr, i6, i7);
        }
        Object[] objArr2 = this.array;
        int i8 = this.size - 1;
        this.size = i8;
        objArr2[i8] = null;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i6, Object obj) {
        ObjectUtil.checkNotNull(obj, "element");
        checkIndex(i6);
        if (this.size == this.array.length) {
            expandArray();
        }
        int i7 = this.size;
        if (i6 != i7) {
            Object[] objArr = this.array;
            System.arraycopy(objArr, i6, objArr, i6 + 1, i7 - i6);
        }
        insert(i6, obj);
        this.size++;
    }
}
