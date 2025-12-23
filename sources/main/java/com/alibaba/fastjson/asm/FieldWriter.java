package com.alibaba.fastjson.asm;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class FieldWriter {
    private final int access;
    private final int desc;
    private final int name;
    FieldWriter next;

    int getSize() {
        return 8;
    }

    void put(ByteVector byteVector) {
        byteVector.putShort(this.access & (-393217)).putShort(this.name).putShort(this.desc);
        byteVector.putShort(0);
    }

    public FieldWriter(ClassWriter classWriter, int i6, String str, String str2) {
        if (classWriter.firstField == null) {
            classWriter.firstField = this;
        } else {
            classWriter.lastField.next = this;
        }
        classWriter.lastField = this;
        this.access = i6;
        this.name = classWriter.newUTF8(str);
        this.desc = classWriter.newUTF8(str2);
    }

    public void visitEnd() {
    }
}
