package site.tj.program.controller;

public interface BaseWS {
    void onOpen();
    void onMessage();
    void onError();
    void onClose();
}
