#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

java -cp aisco.product.hopebridge --module-path aisco.product.hopebridge -m aisco.product.hopebridge &

wait