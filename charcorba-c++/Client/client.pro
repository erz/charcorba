CONFIG += console debug qt warn_on
DESTDIR = bin
FORMS = ui/dialog_connexion.ui ui/mainwindow.ui ui/dialog_window.ui ui/dialog_tags.ui
HEADERS = ../ORB/src/orb.h \
 src/autotest_client.h \
 src/chatroom_impl.h \
 src/client.h \
 src/dialog_connexion.h \
 src/mainwindowimpl.h \
 src/standard_impl.h \
 src/dialog_window.h \
 src/dialog_tableaublanc.h \
 src/tableaublanc.h \
 src/pixel.h \
 src/tableau_blanc_impl.h \
 src/dialog_tags.h
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
 src/dialog_window.cpp \
 src/dialog_tableaublanc.cpp \
 src/tableaublanc.cpp \
 src/pixel.cpp \
 src/tableau_blanc_impl.cpp \
 ../ORB/src/tableau_blanc.cpp \
 src/dialog_tags.cpp
TEMPLATE = app
UI_DIR = build
