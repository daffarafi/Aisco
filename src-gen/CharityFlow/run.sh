#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

java -cp aisco.product.charityflow --module-path aisco.product.charityflow -m aisco.product.charityflow &

wait