#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

java -cp aisco.product.charityschool --module-path aisco.product.charityschool -m aisco.product.charityschool &

wait