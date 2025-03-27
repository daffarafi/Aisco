#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

java -cp aisco.product.yayasanpandhu --module-path aisco.product.yayasanpandhu -m aisco.product.yayasanpandhu &

wait