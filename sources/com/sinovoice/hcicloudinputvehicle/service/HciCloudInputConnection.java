package com.sinovoice.hcicloudinputvehicle.service;
/* loaded from: classes.dex */
public interface HciCloudInputConnection {
    void commitComposing(String str);

    void commitComposingStr(String str);

    void commitComposingStr(String str, String str2);

    void commitString(String str, int i);

    void commitSymbol(String str, int i);

    void finishComposingText();

    int getComposingLength();

    void keyDownUp(int i);

    void upperCheck();
}
