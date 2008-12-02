TEMPLATE = app
QT = gui core
CONFIG += qt warn_on console debug
DESTDIR = bin
OBJECTS_DIR = build
MOC_DIR = build
UI_DIR = build
FORMS = ui/mainwindow.ui ui/dialog_connexion.ui
HEADERS = src/mainwindowimpl.h \
 ../ORB/src/orb.h \
 src/client.h \
 src/standard_impl.h \
 src/autotest_client.h \
 src/chatroom_impl.h \
 src/dialog_connexion.h
SOURCES = src/mainwindowimpl.cpp \
 src/main.cpp \
 ../ORB/src/orb.cpp \
 ../ORB/src/annuaire.cpp \
 src/client.cpp \
 src/standard_impl.cpp \
 ../ORB/src/standard.cpp \
 src/autotest_client.cpp \
 src/chatroom_impl.cpp \
 ../ORB/src/chatroom.cpp \
 src/dialog_connexion.cpp
LIBS += -lmicocoss2.3.13 \
 -lmico2.3.13 \
 -lssl \
 -lpthread \
 -lboost_thread \
 -ldl \
 -lm
INCLUDEPATH += ../ORB/src src
