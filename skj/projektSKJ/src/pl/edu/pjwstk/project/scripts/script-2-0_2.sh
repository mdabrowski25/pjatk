#!/bin/bash

# Start 2 network nodes, then terminate them
java NetworkNode -ident 1 -tcpport 9000 A:1 &
sleep 1
java NetworkNode -ident 1 -tcpport 9001 -gateway localhost:9000 A:1 &
sleep 1
java NetworkClient -gateway localhost:9001 terminate
