#!/bin/bash
[ -z "$HOME" ] ; echo $?
[ -z "$JAVA_HOME" ];echo $?

[ "$HOME" == "$JAVA_HOME" ];echo $?

name="Tan"
[ "$name" == "Tan" ] && echo "OK" && exit 0


