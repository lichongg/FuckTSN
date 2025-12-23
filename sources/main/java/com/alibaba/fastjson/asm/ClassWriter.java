package com.alibaba.fastjson.asm;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ClassWriter {
    private int access;
    FieldWriter firstField;
    MethodWriter firstMethod;
    int index;
    private int interfaceCount;
    private int[] interfaces;
    Item[] items;
    final Item key;
    final Item key2;
    final Item key3;
    FieldWriter lastField;
    MethodWriter lastMethod;
    private int name;
    final ByteVector pool;
    private int superName;
    String thisName;
    int threshold;
    Item[] typeTable;
    int version;

    public ClassWriter() {
        this(0);
    }

    private ClassWriter(int i6) {
        this.index = 1;
        this.pool = new ByteVector();
        this.items = new Item[256];
        this.threshold = (int) (r5.length * 0.75d);
        this.key = new Item();
        this.key2 = new Item();
        this.key3 = new Item();
    }

    private Item get(Item item) {
        Item[] itemArr = this.items;
        Item item2 = itemArr[item.hashCode % itemArr.length];
        while (item2 != null && (item2.type != item.type || !item.isEqualTo(item2))) {
            item2 = item2.next;
        }
        return item2;
    }

    private Item newString(String str) {
        this.key2.set(8, str, null, null);
        Item item = get(this.key2);
        if (item != null) {
            return item;
        }
        this.pool.put12(8, newUTF8(str));
        int i6 = this.index;
        this.index = i6 + 1;
        Item item2 = new Item(i6, this.key2);
        put(item2);
        return item2;
    }

    private void put(Item item) {
        if (this.index > this.threshold) {
            int length = this.items.length;
            int i6 = (length * 2) + 1;
            Item[] itemArr = new Item[i6];
            for (int i7 = length - 1; i7 >= 0; i7--) {
                Item item2 = this.items[i7];
                while (item2 != null) {
                    int i8 = item2.hashCode % i6;
                    Item item3 = item2.next;
                    item2.next = itemArr[i8];
                    itemArr[i8] = item2;
                    item2 = item3;
                }
            }
            this.items = itemArr;
            this.threshold = (int) (i6 * 0.75d);
        }
        int i9 = item.hashCode;
        Item[] itemArr2 = this.items;
        int length2 = i9 % itemArr2.length;
        item.next = itemArr2[length2];
        itemArr2[length2] = item;
    }

    public Item newClassItem(String str) {
        this.key2.set(7, str, null, null);
        Item item = get(this.key2);
        if (item != null) {
            return item;
        }
        this.pool.put12(7, newUTF8(str));
        int i6 = this.index;
        this.index = i6 + 1;
        Item item2 = new Item(i6, this.key2);
        put(item2);
        return item2;
    }

    Item newConstItem(Object obj) {
        if (!(obj instanceof Integer)) {
            if (obj instanceof String) {
                return newString((String) obj);
            }
            if (obj instanceof Type) {
                Type type = (Type) obj;
                return newClassItem(type.sort == 10 ? type.getInternalName() : type.getDescriptor());
            }
            throw new IllegalArgumentException("value " + obj);
        }
        int intValue = ((Integer) obj).intValue();
        this.key.set(intValue);
        Item item = get(this.key);
        if (item != null) {
            return item;
        }
        this.pool.putByte(3).putInt(intValue);
        int i6 = this.index;
        this.index = i6 + 1;
        Item item2 = new Item(i6, this.key);
        put(item2);
        return item2;
    }

    Item newFieldItem(String str, String str2, String str3) {
        this.key3.set(9, str, str2, str3);
        Item item = get(this.key3);
        if (item != null) {
            return item;
        }
        int i6 = newClassItem(str).index;
        this.pool.put12(9, i6).putShort(newNameTypeItem(str2, str3).index);
        int i7 = this.index;
        this.index = i7 + 1;
        Item item2 = new Item(i7, this.key3);
        put(item2);
        return item2;
    }

    Item newMethodItem(String str, String str2, String str3, boolean z5) {
        int i6 = z5 ? 11 : 10;
        this.key3.set(i6, str, str2, str3);
        Item item = get(this.key3);
        if (item != null) {
            return item;
        }
        this.pool.put12(i6, newClassItem(str).index).putShort(newNameTypeItem(str2, str3).index);
        int i7 = this.index;
        this.index = i7 + 1;
        Item item2 = new Item(i7, this.key3);
        put(item2);
        return item2;
    }

    public Item newNameTypeItem(String str, String str2) {
        this.key2.set(12, str, str2, null);
        Item item = get(this.key2);
        if (item != null) {
            return item;
        }
        int newUTF8 = newUTF8(str);
        this.pool.put12(12, newUTF8).putShort(newUTF8(str2));
        int i6 = this.index;
        this.index = i6 + 1;
        Item item2 = new Item(i6, this.key2);
        put(item2);
        return item2;
    }

    public int newUTF8(String str) {
        this.key.set(1, str, null, null);
        Item item = get(this.key);
        if (item == null) {
            this.pool.putByte(1).putUTF8(str);
            int i6 = this.index;
            this.index = i6 + 1;
            item = new Item(i6, this.key);
            put(item);
        }
        return item.index;
    }

    public byte[] toByteArray() {
        int i6 = (this.interfaceCount * 2) + 24;
        int i7 = 0;
        for (FieldWriter fieldWriter = this.firstField; fieldWriter != null; fieldWriter = fieldWriter.next) {
            i7++;
            i6 += fieldWriter.getSize();
        }
        int i8 = 0;
        for (MethodWriter methodWriter = this.firstMethod; methodWriter != null; methodWriter = methodWriter.next) {
            i8++;
            i6 += methodWriter.getSize();
        }
        ByteVector byteVector = new ByteVector(i6 + this.pool.length);
        byteVector.putInt(-889275714).putInt(this.version);
        ByteVector putShort = byteVector.putShort(this.index);
        ByteVector byteVector2 = this.pool;
        putShort.putByteArray(byteVector2.data, 0, byteVector2.length);
        byteVector.putShort(this.access & (-393217)).putShort(this.name).putShort(this.superName);
        byteVector.putShort(this.interfaceCount);
        for (int i9 = 0; i9 < this.interfaceCount; i9++) {
            byteVector.putShort(this.interfaces[i9]);
        }
        byteVector.putShort(i7);
        for (FieldWriter fieldWriter2 = this.firstField; fieldWriter2 != null; fieldWriter2 = fieldWriter2.next) {
            fieldWriter2.put(byteVector);
        }
        byteVector.putShort(i8);
        for (MethodWriter methodWriter2 = this.firstMethod; methodWriter2 != null; methodWriter2 = methodWriter2.next) {
            methodWriter2.put(byteVector);
        }
        byteVector.putShort(0);
        return byteVector.data;
    }

    public void visit(int i6, int i7, String str, String str2, String[] strArr) {
        this.version = i6;
        this.access = i7;
        this.name = newClassItem(str).index;
        this.thisName = str;
        this.superName = str2 == null ? 0 : newClassItem(str2).index;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.interfaceCount = length;
        this.interfaces = new int[length];
        for (int i8 = 0; i8 < this.interfaceCount; i8++) {
            this.interfaces[i8] = newClassItem(strArr[i8]).index;
        }
    }
}
