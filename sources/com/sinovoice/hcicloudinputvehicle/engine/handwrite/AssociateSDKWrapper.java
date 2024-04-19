package com.sinovoice.hcicloudinputvehicle.engine.handwrite;

import java.util.ArrayList;
/* loaded from: classes.dex */
interface AssociateSDKWrapper {
    ArrayList<String> associate(String str);

    void init();

    void raisePriority(String str);

    void release();
}
