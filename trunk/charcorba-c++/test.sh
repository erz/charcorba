#!/bin/sh

killall -9 sleep
kill -9 `ps ux | grep start-naming-mico | awk '{ print $2 ;}'`
killall -9 imr
killall -9 nsd
killall -9 micod

# Lancement du service linux micod ( dans un shell )
./ORB/start-naming-mico.sh &


# Lancement du NameService
nsd -ORBIIOPAddr inet:localhost:2809 & 


# Lancement du serveur d'annuaire
xterm -e "Serveur/bin/serveur -ORBInitRef NameService=corbaloc::localhost:2809/NameService ; sleep 10" &

# Lancement des clients
xterm -e "Client/bin/client -ORBInitRef NameService=corbaloc::localhost:2809/NameService trix geek informatique anti-java ; sleep 10"  &

# Lancement des clients
xterm -e "Client/bin/client -ORBInitRef NameService=corbaloc::localhost:2809/NameService tony echangisme 19cm fetching  anulingus bukkake auto-sodomie anti-c++ ; sleep 10"  &

