TEMPLATE = app
QT = gui core
CONFIG += qt release warn_on console
DESTDIR = bin
OBJECTS_DIR = build
MOC_DIR = build
UI_DIR = build
FORMS = ui/mainwindow.ui
HEADERS = src/mainwindowimpl.h ../ORB/src/orb.h
SOURCES = src/mainwindowimpl.cpp src/main.cpp ../ORB/src/orb.cpp
LIBS += -lmicocoss2.3.13 \
 -lmico2.3.13 \
 -lssl \
 -lpthread \
 -lboost_thread
INCLUDEPATH += ../ORB/src src
