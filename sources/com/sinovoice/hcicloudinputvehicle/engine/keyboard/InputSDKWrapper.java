package com.sinovoice.hcicloudinputvehicle.engine.keyboard;
/* loaded from: classes.dex */
interface InputSDKWrapper {
    d getMore();

    boolean init();

    d query(String str);

    boolean release();

    void setFuzzyOn(boolean z);

    void submitUDB(String str, String str2);
}
