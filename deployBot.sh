#!/bin/bash

tokenFile="./config/token"

if [[ ! -e $tokenFile ]]; then
	echo "Token file does not exist! ( $tokenFile )"
	exit 1	
fi

tokenInput="$(cat $tokenFile)"

echo "Found token: $tokenInput"

# Remove previous nohup.out if present
if [[ -e ./nohup.out ]]; then
	echo "Removing previous nohup file."
	rm ./nohup.out
fi

nohup java -jar target/rollBot-1.2-SNAPSHOT.jar -t $tokenInput &
