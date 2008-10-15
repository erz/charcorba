#!/bin/sh

idl --c++-suffix cpp --c++-impl "$*" 
./to_cpp_dirs.sh
