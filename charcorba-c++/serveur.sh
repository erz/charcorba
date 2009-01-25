#!/bin/sh

killall -9 sleep
kill -9 `ps ux | grep start-naming-mico | awk '{ print $2 ;}'`
killall -9 imr
killall -9 nsd
killall -9 micod

ip=`ifconfig | grep "inet addr" | grep -v 127.0.0.1 | sed -e 's/:/ /g' | awk '{ print $3 ; }' | tail -n 1`

# Lancement du service linux micod
./ORB/start-naming-mico.sh &

# Lancement du NameService
nsd -ORBNoResolve -ORBIIOPVersion 1.2 -ORBIIOPAddr inet:$ip:10809 & 

# Lancement du serveur
xterm -e "Serveur/bin/serveur -ORBNoResolve -ORBInitRef NameService=corbaloc::$ip:10809/NameService ; sleep 100 " &

sleep 100000000
