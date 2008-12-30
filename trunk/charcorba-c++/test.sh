#!/bin/sh

killall -9 sleep
kill -9 `ps ux | grep start-naming-mico | awk '{ print $2 ;}'`
killall -9 imr
killall -9 nsd
killall -9 micod

# Lancement du service linux micod ( dans un shell )
./ORB/start-naming-mico.sh &


# Lancement du NameService
nsd -ORBIIOPAddr inet:localhost:10809 & 


# Lancement du serveur d'annuaire
xterm -e "Serveur/bin/serveur -ORBInitRef NameService=corbaloc::localhost:10809/NameService ; sleep 1000" &
sleep 5

# Lancement des clients
#xterm -e "Client/bin/client -ORBInitRef NameService=corbaloc::localhost:10809/NameService < Client/tests/florent.test ; sleep 10"  &
#sleep 1
xterm -e "Client/bin/client -ORBInitRef NameService=corbaloc::localhost:10809/NameService < Client/tests/michael.test ; sleep 10"  &
sleep 1
xterm -e "Client/bin/client -ORBInitRef NameService=corbaloc::localhost:10809/NameService < Client/tests/aurelien.test ; sleep 10" &
#sleep
#xterm -e "Client/bin/client -ORBInitRef NameService=corbaloc::localhost:10809/NameService < Client/tests/tony.test ; sleep 10" &
#sleep 1
xterm -e "Client/bin/client -ORBInitRef NameService=corbaloc::localhost:10809/NameService < Client/tests/sylvain.test ; sleep 10"  &

