#!/bin/bash
read -p "please input y/n:" yn
if [ "$yn" == "y" ] || [ "$yn" == "Y" ]; then
	echo "OK"
elif [ "$yn" == "n" ] || [ "$yn" == "N" ]; then
	echo "NO"
else
	echo "hhhh"
fi
