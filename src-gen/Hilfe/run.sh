#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

java -cp aisco.product.hilfe --module-path aisco.product.hilfe -m aisco.product.hilfe &

wait