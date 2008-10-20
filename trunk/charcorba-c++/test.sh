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
sleep 5

# Lancement des clients
xterm -e "Client/bin/client -ORBInitRef NameService=corbaloc::localhost:2809/NameService sylvain geek c++ pieton anti-java ; sleep 10"  &
sleep 1
xterm -e "Client/bin/client -ORBInitRef NameService=corbaloc::localhost:2809/NameService tony donneur-de-plaisir anulingus echangisme 19cm anti-c++ ; sleep 10"  &
sleep 1
xterm -e "Client/bin/client -ORBInitRef NameService=corbaloc::localhost:2809/NameService florent keke-des-plages blond violent homophobe gros-bras le-plus ; sleep 10"  &
sleep 1
xterm -e "Client/bin/client -ORBInitRef NameService=corbaloc::localhost:2809/NameService michael mignon-mais-... langue-de-pute fourbe ; sleep 10" &
sleep 1
xterm -e "Client/bin/client -ORBInitRef NameService=corbaloc::localhost:2809/NameService aurélien pédophile asiatiques fetching enfants poil-dans-la-main ; sleep 10" &

