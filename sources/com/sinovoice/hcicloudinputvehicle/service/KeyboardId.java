package com.sinovoice.hcicloudinputvehicle.service;

import java.util.Objects;
/* loaded from: classes.dex */
public class KeyboardId {
    private int inputMode;
    private String kbName;
    private int keyboardMode;
    private int layoutMode;
    private boolean needPreview;

    public KeyboardId(String str, int i) {
        this(str, i, 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KeyboardId) {
            KeyboardId keyboardId = (KeyboardId) obj;
            return this.inputMode == keyboardId.inputMode && this.layoutMode == keyboardId.layoutMode && this.keyboardMode == keyboardId.keyboardMode && Objects.equals(this.kbName, keyboardId.kbName);
        }
        return false;
    }

    public int getInputMode() {
        return this.inputMode;
    }

    public int getKbMode() {
        return this.keyboardMode;
    }

    public String getKbName() {
        return this.kbName;
    }

    public int getLayoutMode() {
        return this.layoutMode;
    }

    public int hashCode() {
        return Objects.hash(this.kbName, Integer.valueOf(this.inputMode), Integer.valueOf(this.layoutMode), Integer.valueOf(this.keyboardMode));
    }

    public boolean isNeedPreview() {
        return this.needPreview;
    }

    public void setInputMode(int i) {
        this.inputMode = i;
    }

    public void setKbMode(int i) {
        this.keyboardMode = i;
    }

    public void setKbName(String str) {
        this.kbName = str;
    }

    public void setNeedPreview(boolean z) {
        this.needPreview = z;
    }

    public String toString() {
        return "KeyboardId{xmlId=" + this.kbName + ", inputMode=" + this.inputMode + ", layoutMode=" + this.layoutMode + ", keyboardMode=" + this.keyboardMode + '}';
    }

    public KeyboardId(String str, int i, int i2) {
        this(str, i, i2, 1);
    }

    public KeyboardId(String str, int i, int i2, boolean z) {
        this(str, i, i2, 1);
        this.needPreview = z;
    }

    public KeyboardId(String str, int i, int i2, int i3) {
        this.needPreview = true;
        this.kbName = str;
        this.inputMode = i;
        this.layoutMode = i2;
        this.keyboardMode = i3;
    }
}
