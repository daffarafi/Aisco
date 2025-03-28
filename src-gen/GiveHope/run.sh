#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

java -cp aisco.product.givehope --module-path aisco.product.givehope -m aisco.product.givehope &

wait