package com.alibaba.fastjson.asm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class MethodWriter implements MethodVisitor {
    private int access;
    private ByteVector code = new ByteVector();
    final ClassWriter cw;
    private final int desc;
    int exceptionCount;
    int[] exceptions;
    private int maxLocals;
    private int maxStack;
    private final int name;
    MethodWriter next;

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitMethodInsn(int i6, String str, String str2, String str3) {
        boolean z5 = i6 == 185;
        Item newMethodItem = this.cw.newMethodItem(str, str2, str3, z5);
        int i7 = newMethodItem.intVal;
        if (!z5) {
            this.code.put12(i6, newMethodItem.index);
            return;
        }
        if (i7 == 0) {
            i7 = Type.getArgumentsAndReturnSizes(str3);
            newMethodItem.intVal = i7;
        }
        this.code.put12(185, newMethodItem.index).put11(i7 >> 2, 0);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitVarInsn(int i6, int i7) {
        if (i7 < 4 && i6 != 169) {
            this.code.putByte((i6 < 54 ? ((i6 - 21) << 2) + 26 : ((i6 - 54) << 2) + 59) + i7);
        } else if (i7 >= 256) {
            this.code.putByte(MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE).put12(i6, i7);
        } else {
            this.code.put11(i6, i7);
        }
    }

    final int getSize() {
        int i6;
        if (this.code.length > 0) {
            this.cw.newUTF8("Code");
            i6 = this.code.length + 26;
        } else {
            i6 = 8;
        }
        if (this.exceptionCount <= 0) {
            return i6;
        }
        this.cw.newUTF8("Exceptions");
        return i6 + (this.exceptionCount * 2) + 8;
    }

    final void put(ByteVector byteVector) {
        byteVector.putShort(this.access & (-393217)).putShort(this.name).putShort(this.desc);
        int i6 = this.code.length > 0 ? 1 : 0;
        if (this.exceptionCount > 0) {
            i6++;
        }
        byteVector.putShort(i6);
        int i7 = this.code.length;
        if (i7 > 0) {
            byteVector.putShort(this.cw.newUTF8("Code")).putInt(i7 + 12);
            byteVector.putShort(this.maxStack).putShort(this.maxLocals);
            ByteVector putInt = byteVector.putInt(this.code.length);
            ByteVector byteVector2 = this.code;
            putInt.putByteArray(byteVector2.data, 0, byteVector2.length);
            byteVector.putShort(0);
            byteVector.putShort(0);
        }
        if (this.exceptionCount > 0) {
            byteVector.putShort(this.cw.newUTF8("Exceptions")).putInt((this.exceptionCount * 2) + 2);
            byteVector.putShort(this.exceptionCount);
            for (int i8 = 0; i8 < this.exceptionCount; i8++) {
                byteVector.putShort(this.exceptions[i8]);
            }
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitFieldInsn(int i6, String str, String str2, String str3) {
        this.code.put12(i6, this.cw.newFieldItem(str, str2, str3).index);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitIincInsn(int i6, int i7) {
        this.code.putByte(MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA).put11(i6, i7);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitInsn(int i6) {
        this.code.putByte(i6);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitIntInsn(int i6, int i7) {
        this.code.put11(i6, i7);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitJumpInsn(int i6, Label label) {
        if ((label.status & 2) != 0 && label.position - this.code.length < -32768) {
            throw new UnsupportedOperationException();
        }
        this.code.putByte(i6);
        label.put(this, this.code, r3.length - 1);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitLabel(Label label) {
        ByteVector byteVector = this.code;
        label.resolve(this, byteVector.length, byteVector.data);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitLdcInsn(Object obj) {
        Item newConstItem = this.cw.newConstItem(obj);
        int i6 = newConstItem.index;
        int i7 = newConstItem.type;
        if (i7 == 5 || i7 == 6) {
            this.code.put12(20, i6);
        } else if (i6 >= 256) {
            this.code.put12(19, i6);
        } else {
            this.code.put11(18, i6);
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitMaxs(int i6, int i7) {
        this.maxStack = i6;
        this.maxLocals = i7;
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitTypeInsn(int i6, String str) {
        this.code.put12(i6, this.cw.newClassItem(str).index);
    }

    public MethodWriter(ClassWriter classWriter, int i6, String str, String str2, String str3, String[] strArr) {
        if (classWriter.firstMethod == null) {
            classWriter.firstMethod = this;
        } else {
            classWriter.lastMethod.next = this;
        }
        classWriter.lastMethod = this;
        this.cw = classWriter;
        this.access = i6;
        this.name = classWriter.newUTF8(str);
        this.desc = classWriter.newUTF8(str2);
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.exceptionCount = length;
            this.exceptions = new int[length];
            for (int i7 = 0; i7 < this.exceptionCount; i7++) {
                this.exceptions[i7] = classWriter.newClassItem(strArr[i7]).index;
            }
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitEnd() {
    }
}
