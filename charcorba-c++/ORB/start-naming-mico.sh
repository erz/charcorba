#!/bin/sh

NSD=/usr/local/bin/nsd
ADDR=inet:192.168.0.4:12456
# ADDR=inet:protea:12456
RC=" -ORBNoResolve -ORBImplRepoAddr $ADDR -ORBNamingAddr $ADDR"
rm -f NameService-root.inf
# run POA daemon
echo "starting POA daemon ..."
micod -ORBNoResolve -ORBIIOPAddr $ADDR --forward &
micod_pid=$!

trap "kill $micod_pid" 0

sleep 1

# register server
echo "register name service ..."
imr create NameService poa $NSD \
    IDL:omg.org/CosNaming/NamingContext:1.0#NameService $RC
sleep 1
echo "activating server implementations"
imr activate NameService $RC

sleep 100000

