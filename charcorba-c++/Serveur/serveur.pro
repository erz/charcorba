TEMPLATE = app
CONFIG += release warn_on console
DESTDIR = bin
OBJECTS_DIR = build
MOC_DIR = build
UI_DIR = build
HEADERS = src/Compteur_impl.h src/serveur.h ../ORB/src/orb.h
SOURCES = src/main.cpp \
 src/Compteur_impl.cpp \
 src/serveur.cpp \
 ../ORB/src/orb.cpp \
 ../ORB/src/Compteur.cpp
LIBS += -lmicocoss2.3.13 -lmico2.3.13 -lssl -lboost_thread
INCLUDEPATH += ../ORB/src src
