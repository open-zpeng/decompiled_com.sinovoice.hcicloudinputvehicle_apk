package com.sinovoice.hcicloudinputvehicle.input;
/* loaded from: classes.dex */
interface PinyinComposingInterface {
    void appendLetter(char c);

    void appendSelectedItem(String str, String str2);

    void appendSelectedSyllable(String str);

    void clear();

    void del();

    String getCompoingToQuery();

    String getComposingToCommiting();

    String getCurrentOutput();

    char getLastCharOfCompoingToQuery();

    String getSelectComposing();

    boolean isMatchComplete();

    void updateFirstCandidate(String str, String str2);
}
