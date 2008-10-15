#!/bin/sh
cc_root="${*%.*}"
echo "$cc_root"
echo ${cc_root}.cc ${cc_root}.cpp
mv ${cc_root}.cc ${cc_root}.cpp 
