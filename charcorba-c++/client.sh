#!/bin/sh

ip_serveur="$2"

if [ "$#" -eq 0 ]; then
	echo "./client <fichier_test> [ip_serveur]"
	exit
fi

if [ "$#" -eq 1 ]; then
	ip_serveur=`ifconfig | grep "inet addr" | grep -v 127.0.0.1 | sed -e 's/:/ /g' | awk '{ print $3 ; }' | tail -n 1`
fi
ip_serveur="localhost"

xterm -e "Client/bin/client -ORBNoResolve -ORBInitRef NameService=corbaloc::$ip_serveur:10809/NameService < Client/tests/$1.test ; sleep 100 "  &

sleep 10000000
