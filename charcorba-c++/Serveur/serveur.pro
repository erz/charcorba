TEMPLATE = app
CONFIG += release warn_on console
DESTDIR = bin
OBJECTS_DIR = build
MOC_DIR = build
UI_DIR = build
HEADERS = src/serveur.h \
 ../ORB/src/orb.h \
 src/annuaire_impl.h \
 ../ORB/src/annuaire.h \
 src/client_annuaire.h
SOURCES = src/main.cpp \
 src/serveur.cpp \
 ../ORB/src/orb.cpp \
 src/annuaire_impl.cpp \
 ../ORB/src/annuaire.cpp \
 src/client_annuaire.cpp
LIBS += -lmicocoss2.3.13 -lmico2.3.13 -lssl -lboost_thread
INCLUDEPATH += ../ORB/src src
