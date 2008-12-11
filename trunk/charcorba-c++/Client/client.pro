CONFIG += console debug qt warn_on
DESTDIR = bin
FORMS = ui/dialog_connexion.ui ui/mainwindow.ui ui/dialog_window.ui
HEADERS = ../ORB/src/orb.h \
 src/autotest_client.h \
 src/chatroom_impl.h \
 src/client.h \
 src/dialog_connexion.h \
 src/mainwindowimpl.h \
 src/standard_impl.h \
 src/dialog_window.h
INCLUDEPATH += ../ORB/src src
LIBS += -lboost_thread \
 -ldl \
 -lm \
 -lmico2.3.13 \
 -lmicocoss2.3.13 \
 -lpthread \
 -lssl
MOC_DIR = build
OBJECTS_DIR = build
QT = core gui
SOURCES = ../ORB/src/annuaire.cpp \
 ../ORB/src/chatroom.cpp \
 ../ORB/src/orb.cpp \
 ../ORB/src/standard.cpp \
 src/autotest_client.cpp \
 src/chatroom_impl.cpp \
 src/client.cpp \
 src/dialog_connexion.cpp \
 src/main.cpp \
 src/mainwindowimpl.cpp \
 src/standard_impl.cpp \
 src/dialog_window.cpp
TEMPLATE = app
UI_DIR = build
