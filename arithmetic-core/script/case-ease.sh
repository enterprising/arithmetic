#!/bin/bash
case $1 in
  "hello")
	echo "hello, how are you?"
	;;
  "")
	echo "you must input parameters,ex> {$0 some word}"
	;;
  *)
	echo "usgae $0 {hellp}"
	;;
esac
