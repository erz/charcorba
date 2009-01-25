#!/bin/sh

./serveur.sh &
sleep 8

./client.sh sylvain &
./client.sh florent &
./client.sh michael &
#./client.sh aurelien &
#./client.sh tony &
