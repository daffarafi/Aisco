#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

java -cp aisco.product.donorcare --module-path aisco.product.donorcare -m aisco.product.donorcare &

wait