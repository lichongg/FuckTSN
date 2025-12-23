package io.netty.channel.nio;

import java.nio.channels.SelectionKey;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class SelectedSelectionKeySet extends AbstractSet<SelectionKey> {
    SelectionKey[] keys = new SelectionKey[1024];
    int size;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return false;
    }

    void reset() {
        reset(0);
    }

    private void increaseCapacity() {
        SelectionKey[] selectionKeyArr = this.keys;
        SelectionKey[] selectionKeyArr2 = new SelectionKey[selectionKeyArr.length << 1];
        System.arraycopy(selectionKeyArr, 0, selectionKeyArr2, 0, this.size);
        this.keys = selectionKeyArr2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(SelectionKey selectionKey) {
        if (selectionKey == null) {
            return false;
        }
        SelectionKey[] selectionKeyArr = this.keys;
        int i6 = this.size;
        int i7 = i6 + 1;
        this.size = i7;
        selectionKeyArr[i6] = selectionKey;
        if (i7 != selectionKeyArr.length) {
            return true;
        }
        increaseCapacity();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<SelectionKey> iterator() {
        return new Iterator<SelectionKey>() { // from class: io.netty.channel.nio.SelectedSelectionKeySet.1
            private int idx;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.idx < SelectedSelectionKeySet.this.size;
            }

            @Override // java.util.Iterator
            public SelectionKey next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                SelectionKey[] selectionKeyArr = SelectedSelectionKeySet.this.keys;
                int i6 = this.idx;
                this.idx = i6 + 1;
                return selectionKeyArr[i6];
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    void reset(int i6) {
        Arrays.fill(this.keys, i6, this.size, (Object) null);
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    SelectedSelectionKeySet() {
    }
}
