#!/bin/sh

killall -9 sleep
kill -9 `ps ux | grep start-naming-mico | awk '{ print $2 ;}'`
killall -9 imr
killall -9 nsd
killall -9 micod

if [ "$*" = "local" ]; then
	ip=`ifconfig | grep "inet addr" | grep -v 127.0.0.1 | sed -e 's/:/ /g' | awk '{ print $3 ; }' | tail -n 1`
else
	ip=`wget -O - -q whatismyip.org`
fi		

# Lancement du service linux micod
./ORB/start-naming-mico.sh &

# Lancement du NameService
nsd -ORBIIOPAddr inet:$ip:10809 & 

# Lancement du serveur
xterm -e "Serveur/bin/serveur -ORBInitRef NameService=corbaloc::$ip:10809/NameService" &

sleep 100000000
