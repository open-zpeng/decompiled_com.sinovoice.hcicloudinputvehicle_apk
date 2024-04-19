package com.sinovoice.hcicloudinputvehicle.service;
/* loaded from: classes.dex */
public interface InputLogicControlInterface {
    void checkInitStatus();

    void clear();

    void finishInput();

    com.sinovoice.hcicloudinputvehicle.input.d getCurrentInput();

    int getCurrentInputMode();

    void handleCandChoosed(int i);

    void handleDelete();

    void handleEnter();

    void handleNextPage();

    void handleShift(int i);

    void handleSpace();

    void handleSyllableChosen(int i);

    void handleSymbol(int i);

    void handleSymbol(String str);

    void init();

    void onInputModeChange(int i);

    void query(CharSequence charSequence);

    void query(short[] sArr);

    void release();

    void startSession();

    void stopSession();
}
