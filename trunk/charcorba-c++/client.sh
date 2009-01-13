#!/bin/sh

ip_serveur="$*"

if [ "$#" -eq 0 ]; then
	echo "./client <fichier_test> [ip_serveur]"
	exit
fi

if [ "$#" -eq 1 ]; then
	ip_serveur=`ifconfig | grep "inet addr" | grep -v 127.0.0.1 | sed -e 's/:/ /g' | awk '{ print $3 ; }' | tail -n 1`
fi

xterm -e "Client/bin/client -ORBInitRef NameService=corbaloc::$ip_serveur:10809/NameService < Client/tests/$1.test ;"  &

sleep 10000000
