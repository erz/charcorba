TEMPLATE = app
QT = gui core
CONFIG += qt release warn_on console
DESTDIR = bin
OBJECTS_DIR = build
MOC_DIR = build
UI_DIR = build
FORMS = ui/mainwindow.ui
HEADERS = src/mainwindowimpl.h \
 ../ORB/src/orb.h \
 ../ORB/src/annuaire.h \
 src/client.h \
 src/client_impl.h
SOURCES = src/mainwindowimpl.cpp \
 src/main.cpp \
 ../ORB/src/orb.cpp \
 ../ORB/src/annuaire.cpp \
 src/client.cpp \
 src/client_impl.cpp
LIBS += -lmicocoss2.3.13 \
 -lmico2.3.13 \
 -lssl \
 -lpthread \
 -lboost_thread \
 -ldl \
 -lm
INCLUDEPATH += ../ORB/src src
